package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public static WebElement getLoginHeaderLabel(WebDriver driver) {
        return driver.findElement(By.cssSelector("#customer_login > div.u-column1.col-1 > h2"));
    }

    public static WebElement getUserNameLabel(WebDriver driver) {
        return driver.findElement(By.cssSelector("#customer_login > div.u-column1.col-1 > form > p:nth-child(1) > label"));
    }

    public static WebElement getUserEmailInputField(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id='username']"));
    }

    public static WebElement getPasswordLabel(WebDriver driver) {
        return driver.findElement(By.cssSelector("#customer_login > div.u-column1.col-1 > form > p:nth-child(2) > label"));
    }

    public static WebElement getPasswordInputField(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id='password']"));
    }

    public static WebElement getLoginButton(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id='customer_login']/div[1]/form/p[3]/input[3]"));
    }

    public static WebElement getLostPasswordLink(WebDriver driver) {
        return driver.findElement(By.cssSelector("#customer_login > div.u-column1.col-1 > form > p.woocommerce-LostPassword.lost_password > a"));
    }

    public static WebElement getRememberMe(WebDriver driver) {
        return driver.findElement(By.cssSelector("#customer_login > div.u-column1.col-1 > form > p:nth-child(3) > label"));
    }

    public static WebElement getInvalidErrorMessage(WebDriver driver) {
        return driver.findElement(By.cssSelector("#page-36 > div > div.woocommerce > ul > li"));
    }

    public static WebElement getLogoutLink(WebDriver driver) {
        return driver.findElement(By.cssSelector("#page-36 > div > div.woocommerce > nav > ul > li.woocommerce-MyAccount-navigation-link.woocommerce-MyAccount-navigation-link--customer-logout > a"));
    }

    public static WebElement getDashboardLink(WebDriver driver) {
        return driver.findElement(By.cssSelector("#page-36 > div > div.woocommerce > nav > ul > li.woocommerce-MyAccount-navigation-link.woocommerce-MyAccount-navigation-link--dashboard.is-active > a"));
    }
}
