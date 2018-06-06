package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    public static WebElement getDashboardLink(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/nav/ul/li[1]/a"));
    }

    public static WebElement getOrderLink(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/nav/ul/li[2]/a"));
    }

    public static WebElement getDownloadsLink(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/nav/ul/li[3]/a"));
    }

    public static WebElement getAddressLink(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/nav/ul/li[4]/a"));
    }

    public static WebElement getAccountDetailsLink(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/nav/ul/li[5]/a"));
    }

    public static WebElement getLogoutLink(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/nav/ul/li[6]/a"));
    }

    public static WebElement getShopMenu(WebDriver driver) {
        return driver.findElement(By.cssSelector("#menu-item-40 > a"));
    }

    public static WebElement getMyAccountMenu(WebDriver driver) {
        return driver.findElement(By.cssSelector("#menu-item-50 > a"));
    }

    public static WebElement getTestCasesMenu(WebDriver driver) {
        return driver.findElement(By.cssSelector("#menu-item-224 > a"));
    }

    public static WebElement getAtSiteMenu(WebDriver driver) {
        return driver.findElement(By.cssSelector("#menu-item-244 > a"));
    }

    public static WebElement getDemoSiteMenu(WebDriver driver) {
        return driver.findElement(By.cssSelector("#menu-item-251 > a"));
    }
}
