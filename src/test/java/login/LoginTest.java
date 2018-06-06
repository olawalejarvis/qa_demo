package login;

import base.BaseTestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.LoginPage;

import java.net.MalformedURLException;

public class LoginTest extends BaseTestClass {

    @BeforeClass
    @Parameters({ "browser", "url", "node", "os" })
    public void testSetUp(String browser, String url, String node, String os) throws MalformedURLException, InterruptedException {
        setUpTest(browser, url, node, os);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#customer_login > div.u-column1.col-1 > h2")));
    }

    @Test(groups = "Default")
    public void defaultTest() {
        // validate login header
        Assert.assertTrue(LoginPage.getLoginHeaderLabel(driver).isDisplayed());
        Assert.assertEquals(LoginPage.getLoginHeaderLabel(driver).getText(), "Login");

        // validate email/username field
        Assert.assertTrue(LoginPage.getUserNameLabel(driver).isDisplayed());
        Assert.assertEquals(LoginPage.getUserNameLabel(driver).getText(), "Username or email address *");

        Assert.assertTrue(LoginPage.getUserEmailInputField(driver).isDisplayed());
        Assert.assertTrue(LoginPage.getUserEmailInputField(driver).isEnabled());

        // validate password field
        Assert.assertTrue(LoginPage.getPasswordLabel(driver).isDisplayed());
        Assert.assertEquals(LoginPage.getPasswordLabel(driver).getText(), "Password *");

        // validate login button
        Assert.assertTrue(LoginPage.getLoginButton(driver).isDisplayed());
        Assert.assertTrue(LoginPage.getLoginButton(driver).isEnabled());
        Assert.assertEquals(LoginPage.getLoginButton(driver).getAttribute("value"), "Login");

        // validate lost password link
        Assert.assertTrue(LoginPage.getLostPasswordLink(driver).isEnabled());
        Assert.assertTrue(LoginPage.getLostPasswordLink(driver).isDisplayed());
        Assert.assertEquals(LoginPage.getLostPasswordLink(driver).getText(), "Lost your password?");
        Assert.assertEquals(LoginPage.getLostPasswordLink(driver).getAttribute("href"), "http://practice.automationtesting.in/my-account/lost-password/");

        // validate remember me
        Assert.assertTrue(LoginPage.getRememberMe(driver).isDisplayed());
        Assert.assertEquals(LoginPage.getRememberMe(driver).getText(), "Remember me");
    }

    @Test(dataProvider = "invalidCredentials", dependsOnGroups = "Default", groups = "invalidCredentials")
    public void loginWithInvalidCredentials(String email, String password, String check) throws InterruptedException {

        loginUser(email, password);

        WebElement errorMessage = LoginPage.getInvalidErrorMessage(driver);
        Assert.assertTrue(errorMessage.isDisplayed());


        switch (check) {
            case "email":
                Assert.assertEquals(errorMessage.getText(), "Error: A user could not be found with this email address.");
                break;
            case "password":
                Assert.assertTrue(errorMessage.getText().contains("ERROR: The password you entered for the username"));
                break;
            case "both":
                Assert.assertEquals(errorMessage.getText(), "Error: A user could not be found with this email address.");
                break;
            case "script":
                Assert.assertEquals(errorMessage.getText(), "ERROR: The username field is empty.");
                break;
            case "emptyEmail":
                Assert.assertEquals(errorMessage.getText(), "Error: Username is required.");
                break;
            case "emptyPassword":
                Assert.assertEquals(errorMessage.getText(), "Error: Password is required.");
                break;
            case "empty":
                Assert.assertEquals(errorMessage.getText(), "Error: Username is required.");
                break;
            default:
                Assert.assertTrue(errorMessage.getText().contains("Error"));
        }
    }

    @Test(dependsOnGroups = "invalidCredentials")
    public void validLogin() throws InterruptedException {
        loginUser("olawalequest@gmail.com", "Pa223jjssj!@#98wjs");

        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#page-36 > div > div.woocommerce > nav > ul > li.woocommerce-MyAccount-navigation-link.woocommerce-MyAccount-navigation-link--customer-logout > a")));

        // Validate successful registration
        Assert.assertTrue(LoginPage.getLogoutLink(driver).isDisplayed());
        Assert.assertTrue(LoginPage.getLogoutLink(driver).isEnabled());
        Assert.assertTrue(LoginPage.getDashboardLink(driver).isDisplayed());
        Assert.assertTrue(LoginPage.getDashboardLink(driver).isEnabled());
    }

    @DataProvider(name = "invalidCredentials")
    Object [][] invalidCredentials(ITestContext content) {
        return new Object[][] {
                {"demo@mail.com", "ppsjsjshagass", "email"},
                {"olawalequest@gmail.com", "ahsjhsjhsghs", "password"},
                {"jhdhjdhjdjhd@mail.com", "Pa223jjssj!@#98wjs", "email"},
                {"<script>alert('email')</script>", "<div>hello</div>", "script"},
                {"sjhsjhshjs@gmail.com", "ajhsjhshjsshj", "both"},
                {"", "hshssgsgshs", "emptyEmail"},
                {"olawalequest@gmail.com", "", "emptyPassword"},
                {"", "", "empty"}
        };
    }

    private void loginUser(String email, String password) throws InterruptedException {
        WebElement emailField = LoginPage.getUserEmailInputField(driver);
        WebElement passwordField = LoginPage.getPasswordInputField(driver);
        WebElement loginButton = LoginPage.getLoginButton(driver);
        // clear
        emailField.sendKeys(Keys.CONTROL, "a");
        emailField.sendKeys(Keys.BACK_SPACE);

        passwordField.sendKeys(Keys.CONTROL, "a");
        passwordField.sendKeys(Keys.BACK_SPACE);

        // fill
        emailField.sendKeys(email);
        passwordField.sendKeys(password);

        loginButton.click();

        Thread.sleep(5000);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}
