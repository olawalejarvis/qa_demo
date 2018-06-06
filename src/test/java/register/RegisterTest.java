package register;

import base.BaseTestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.RegisterPage;

import java.net.MalformedURLException;
import java.util.Random;

public class RegisterTest extends BaseTestClass{

    @BeforeClass
    @Parameters({ "browser", "url", "node", "os" })
    public void testSetUp(String browser, String url, String node, String os) throws MalformedURLException, InterruptedException {
        setUpTest(browser, url, node, os);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='customer_login']/div[2]/form/p[3]/input[3]")));
    }

    @Test(groups = "Default")
    public void defaultTest() {
        // Validate Register Label Header
        Assert.assertEquals(RegisterPage.getRegisterLabel(driver).getText(), "Register");

        // Validate email input field label is present
        Assert.assertTrue(RegisterPage.getEmailLabel(driver).isDisplayed());
        Assert.assertEquals(RegisterPage.getEmailLabel(driver).getText(), "Email address *");

        // Validate email field is present
        Assert.assertTrue(RegisterPage.getEmailInputField(driver).isDisplayed());
        Assert.assertTrue(RegisterPage.getEmailInputField(driver).isEnabled());

        // Validate password field
        Assert.assertTrue(RegisterPage.getPassswordLabel(driver).isDisplayed());
        Assert.assertEquals(RegisterPage.getPassswordLabel(driver).getText(), "Password *");

        Assert.assertTrue(RegisterPage.getPasswordInputField(driver).isDisplayed());
        Assert.assertTrue(RegisterPage.getPasswordInputField(driver).isEnabled());

        // Validate register Button
        Assert.assertTrue(RegisterPage.getRegisterButton(driver).isDisplayed());
        Assert.assertTrue(RegisterPage.getRegisterButton(driver).isEnabled());
    }

    @Test(dependsOnGroups = "Default", groups = "InvalidRegistrationCredentials", dataProvider = "invalidRegistrationPasswordCredentials")
    public void invalidPasswordTest(String email, String password) {
        WebElement emailField = RegisterPage.getEmailInputField(driver);
        WebElement passwordField = RegisterPage.getPasswordInputField(driver);
        // clear
        emailField.sendKeys(Keys.CONTROL, "a");
        emailField.sendKeys(Keys.BACK_SPACE);

        passwordField.sendKeys(Keys.CONTROL, "a");
        passwordField.sendKeys(Keys.BACK_SPACE);

        // enter value
        emailField.sendKeys(email);
        passwordField.sendKeys(password);

        Assert.assertTrue(RegisterPage.getWeakPasswordText(driver).isDisplayed());
        Assert.assertTrue(RegisterPage.getWeakPasswordHintText(driver).isDisplayed());

        Assert.assertEquals(RegisterPage.getWeakPasswordText(driver).getText(), "Very weak - Please enter a stronger password.");
        Assert.assertEquals(RegisterPage.getWeakPasswordHintText(driver).getText(), "The password should be at least seven characters long. To make it stronger, use upper and lower case letters, numbers and symbols like ! \" ? $ % ^ & ).");

        // Validate the registration buttoon is disabled
        Assert.assertFalse(RegisterPage.getRegisterButton(driver).isEnabled());
    }

    @Test(dependsOnGroups = "Default", groups = "InvalidRegistrationCredentials", dataProvider = "invalidRegistrationEmailCredentials")
    public void invalidEmailTest(String email, String password) {
        WebElement emailField = RegisterPage.getEmailInputField(driver);
        WebElement passwordField = RegisterPage.getPasswordInputField(driver);
        // clear
        emailField.sendKeys(Keys.CONTROL, "a");
        emailField.sendKeys(Keys.BACK_SPACE);

        passwordField.sendKeys(Keys.CONTROL, "a");
        passwordField.sendKeys(Keys.BACK_SPACE);

        // enter value
        emailField.sendKeys(email);
        passwordField.sendKeys(password);

        // Assert that Register is still present
        Assert.assertTrue(RegisterPage.getRegisterLabel(driver).isDisplayed());
        Assert.assertEquals(RegisterPage.getRegisterLabel(driver).getText(), "Register");

    }

    @Test(dependsOnGroups = "InvalidRegistrationCredentials")
    public void registerWithValidCredentialsTest() {
        WebElement emailField = RegisterPage.getEmailInputField(driver);
        WebElement passwordField = RegisterPage.getPasswordInputField(driver);
        // clear
        emailField.sendKeys(Keys.CONTROL, "a");
        emailField.sendKeys(Keys.BACK_SPACE);

        passwordField.sendKeys(Keys.CONTROL, "a");
        passwordField.sendKeys(Keys.BACK_SPACE);

        Random rand = new Random();
        int  randomNumber = rand.nextInt(50) + 1;

        // enter value
        emailField.sendKeys("qademo" + randomNumber + "@mail.com");
        passwordField.sendKeys("Pass9833Whsh!@##jjdd*&()jshGGFNKL");

        RegisterPage.getRegisterButton(driver).click();
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#page-36 > div > div.woocommerce > nav > ul > li.woocommerce-MyAccount-navigation-link.woocommerce-MyAccount-navigation-link--customer-logout > a")));

        // Validate successful registration
        Assert.assertTrue(RegisterPage.getLogoutLink(driver).isDisplayed());
        Assert.assertTrue(RegisterPage.getLogoutLink(driver).isEnabled());
        Assert.assertTrue(RegisterPage.getDashboardLink(driver).isDisplayed());
        Assert.assertTrue(RegisterPage.getDashboardLink(driver).isEnabled());

    }

    // setting dataprovider for registration credentials values
    @DataProvider(name = "invalidRegistrationPasswordCredentials")
    Object[][] invalidRegistrationPasswordCredentials(ITestContext context) {
        return new Object[][] {
                {"qademo@mail.com", "PASSWORDPASSWORDPASSWORDPASSWORDPASSWORD"},
                {"qademo@mail.com", "passwordpasswordpasswordpasswordpassword"},
                {"qademo@mail.com", "PASSWORDPASSWORDpasswordpassword"}
        };
    }

    // setting dataprovider for registration credentials values
    @DataProvider(name = "invalidRegistrationEmailCredentials")
    Object[][] invalidRegistrationEmailCredentials(ITestContext context) {
        return new Object[][] {
                {"qademomail.com", "Pa223jjssj!@#98wjs"},
                {"qademomail@.com", "Pa223jjssj!@#98wjs"},
                {"qademo.com@", "Pa223jjssj!@#98wjs"}
        };
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}
