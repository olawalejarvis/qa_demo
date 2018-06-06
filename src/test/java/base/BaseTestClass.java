package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import pages.LoginPage;

import java.net.MalformedURLException;

public class BaseTestClass {

    public WebDriver driver = null;

    public void setUpTest(String browser, String url, String node, String os) throws MalformedURLException, InterruptedException {
        TestSetup setUp = new TestSetup(os, browser, url, node);
        driver = setUp.getDriver();
    }


    public void login() throws InterruptedException {
        String email = "olawalequest@gmail.com";
        String password = "Pa223jjssj!@#98wjs";
        WebElement emailField = LoginPage.getUserEmailInputField(driver);
        WebElement passwordField = LoginPage.getPasswordInputField(driver);
        WebElement loginButton = LoginPage.getLoginButton(driver);
        emailField.sendKeys(Keys.CONTROL, "a");
        emailField.sendKeys(Keys.BACK_SPACE);
        passwordField.sendKeys(Keys.CONTROL, "a");
        passwordField.sendKeys(Keys.BACK_SPACE);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#page-36 > div > div.woocommerce > nav > ul > li.woocommerce-MyAccount-navigation-link.woocommerce-MyAccount-navigation-link--customer-logout > a")));
    }
}
