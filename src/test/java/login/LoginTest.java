package login;

import base.BaseTestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import sun.rmi.runtime.Log;

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
        Assert.assertEquals(LoginPage.getLoginButton(driver).getText(), "Login");

        // validate lost password link
        Assert.assertTrue(LoginPage.getLostPasswordLink(driver).isEnabled());
        Assert.assertTrue(LoginPage.getLostPasswordLink(driver).isDisplayed());
        Assert.assertEquals(LoginPage.getLostPasswordLink(driver).getText(), "Lost your password?");
        Assert.assertEquals(LoginPage.getLostPasswordLink(driver).getAttribute("href"), "http://practice.automationtesting.in/my-account/lost-password/");

        // validate remember me
        Assert.assertTrue(LoginPage.getRememberMe(driver).isDisplayed());
        Assert.assertEquals(LoginPage.getRememberMe(driver).getText(), "Remember me");
    }

    @Test
    public void loginWithInvalidCredentials() {

    }

    @DataProvider(name = "invalidCredentials")
    Object [][] invalidCredentials(ITestContext content) {
        return new Object[][] {
                {"demo@mail.com", "ppsjsjshagass"}
        };
    }

}
