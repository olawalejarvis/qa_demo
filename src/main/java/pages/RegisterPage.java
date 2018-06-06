package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    public static WebElement getRegisterLabel(WebDriver driver) {
        return driver.findElement(By.cssSelector("#customer_login > div.u-column2.col-2 > h2"));
    }

    public static WebElement getEmailLabel(WebDriver driver) {
        return driver.findElement(By.cssSelector("#customer_login > div.u-column2.col-2 > form > p:nth-child(1) > label"));
    }

    public static WebElement getEmailInputField(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id='reg_email']"));
    }

    public static WebElement getPassswordLabel(WebDriver driver) {
        return driver.findElement(By.cssSelector("#customer_login > div.u-column2.col-2 > form > p:nth-child(2) > label"));
    }

    public static WebElement getPasswordInputField(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id='reg_password']"));
    }

    public static WebElement getRegisterButton(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id='customer_login']/div[2]/form/p[3]/input[3]"));
    }

    public static WebElement getWeakPasswordText(WebDriver driver) {
        return driver.findElement(By.cssSelector("#customer_login > div.u-column2.col-2 > form > p:nth-child(2) > div"));
    }

    public static WebElement getWeakPasswordHintText(WebDriver driver) {
        return driver.findElement(By.cssSelector("#customer_login > div.u-column2.col-2 > form > p:nth-child(2) > small"));
    }

    public static WebElement getLogoutLink(WebDriver driver) {
        return driver.findElement(By.cssSelector("#page-36 > div > div.woocommerce > nav > ul > li.woocommerce-MyAccount-navigation-link.woocommerce-MyAccount-navigation-link--customer-logout > a"));
    }

    public static WebElement getDashboardLink(WebDriver driver) {
        return driver.findElement(By.cssSelector("#page-36 > div > div.woocommerce > nav > ul > li.woocommerce-MyAccount-navigation-link.woocommerce-MyAccount-navigation-link--dashboard.is-active > a"));
    }
}
