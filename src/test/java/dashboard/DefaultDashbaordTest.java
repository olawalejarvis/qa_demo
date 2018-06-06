package dashboard;

import base.BaseTestClass;
import com.sun.xml.internal.rngom.parse.host.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BasePage;

import java.net.MalformedURLException;

public class DefaultDashbaordTest extends BaseTestClass {
    @BeforeClass
    @Parameters({ "browser", "url", "node", "os" })
    public void testSetUp(String browser, String url, String node, String os) throws MalformedURLException, InterruptedException {
        setUpTest(browser, url, node, os);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#customer_login > div.u-column1.col-1 > h2")));
        login();
    }

    @Test
    public void dashboardLinkTest() {
        Assert.assertTrue(BasePage.getDashboardLink(driver).isDisplayed());
        Assert.assertTrue(BasePage.getDashboardLink(driver).isEnabled());
        Assert.assertEquals(BasePage.getDashboardLink(driver).getText(), "Dashboard");
        Assert.assertEquals(BasePage.getDashboardLink(driver).getAttribute("href"), "http://practice.automationtesting.in/my-account/");
    }

    @Test
    public void orderLinkTest() {
        Assert.assertTrue(BasePage.getOrderLink(driver).isDisplayed());
        Assert.assertTrue(BasePage.getOrderLink(driver).isEnabled());
        Assert.assertEquals(BasePage.getOrderLink(driver).getText(), "Orders");
        Assert.assertEquals(BasePage.getOrderLink(driver).getAttribute("href"), "http://practice.automationtesting.in/my-account/orders/");
    }

    @Test
    public void downloadsLinkTest() {
        Assert.assertTrue(BasePage.getDownloadsLink(driver).isDisplayed());
        Assert.assertTrue(BasePage.getDownloadsLink(driver).isEnabled());
        Assert.assertEquals(BasePage.getDownloadsLink(driver).getText(), "Downloads");
        Assert.assertEquals(BasePage.getDownloadsLink(driver).getAttribute("href"), "http://practice.automationtesting.in/my-account/downloads/");
    }

    @Test
    public void addressesLinkTest() {
        Assert.assertTrue(BasePage.getAddressLink(driver).isDisplayed());
        Assert.assertTrue(BasePage.getAddressLink(driver).isEnabled());
        Assert.assertEquals(BasePage.getAddressLink(driver).getText(), "Addresses");
        Assert.assertEquals(BasePage.getAddressLink(driver).getAttribute("href"), "http://practice.automationtesting.in/my-account/edit-address/");
    }

    @Test
    public void accountDetailLinkTest() {
        Assert.assertTrue(BasePage.getAccountDetailsLink(driver).isDisplayed());
        Assert.assertTrue(BasePage.getAccountDetailsLink(driver).isEnabled());
        Assert.assertEquals(BasePage.getAccountDetailsLink(driver).getText(), "Account Details");
        Assert.assertEquals(BasePage.getAccountDetailsLink(driver).getAttribute("href"), "http://practice.automationtesting.in/my-account/edit-account/");
    }

    @Test
    public void logoutLinkTest() {
        Assert.assertTrue(BasePage.getLogoutLink(driver).isDisplayed());
        Assert.assertTrue(BasePage.getLogoutLink(driver).isEnabled());
        Assert.assertEquals(BasePage.getLogoutLink(driver).getText(), "Logout");
        Assert.assertEquals(BasePage.getLogoutLink(driver).getAttribute("href"), "http://practice.automationtesting.in/my-account/customer-logout/");
    }

    @Test
    public void shopMenuLinkTest() {
        Assert.assertTrue(BasePage.getShopMenu(driver).isDisplayed());
        Assert.assertTrue(BasePage.getShopMenu(driver).isEnabled());
        Assert.assertEquals(BasePage.getShopMenu(driver).getText(), "Shop");
        Assert.assertEquals(BasePage.getShopMenu(driver).getAttribute("href"), "http://practice.automationtesting.in/shop/");
    }

    @Test
    public void myAccountMenuLinkTest() {
        Assert.assertTrue(BasePage.getMyAccountMenu(driver).isDisplayed());
        Assert.assertTrue(BasePage.getMyAccountMenu(driver).isEnabled());
        Assert.assertEquals(BasePage.getMyAccountMenu(driver).getText(), "My Account");
        Assert.assertEquals(BasePage.getMyAccountMenu(driver).getAttribute("href"), "http://practice.automationtesting.in/my-account/");
    }

    @Test
    public void testCasesMenuLinkTest() {
        Assert.assertTrue(BasePage.getTestCasesMenu(driver).isDisplayed());
        Assert.assertTrue(BasePage.getTestCasesMenu(driver).isEnabled());
        Assert.assertEquals(BasePage.getTestCasesMenu(driver).getText(), "Test Cases");
        Assert.assertEquals(BasePage.getTestCasesMenu(driver).getAttribute("href"), "http://practice.automationtesting.in/test-cases/");
    }

    @Test
    public void aTSiteMenuLinkTest() {
        Assert.assertTrue(BasePage.getAtSiteMenu(driver).isDisplayed());
        Assert.assertTrue(BasePage.getAtSiteMenu(driver).isEnabled());
        Assert.assertEquals(BasePage.getAtSiteMenu(driver).getText(), "AT Site");
        Assert.assertEquals(BasePage.getAtSiteMenu(driver).getAttribute("href"), "http://automationtesting.in/");
    }

    @Test
    public void demoSiteMenuLinkTest() {
        Assert.assertTrue(BasePage.getDemoSiteMenu(driver).isDisplayed());
        Assert.assertTrue(BasePage.getDemoSiteMenu(driver).isEnabled());
        Assert.assertEquals(BasePage.getDemoSiteMenu(driver).getText(), "Demo Site");
        Assert.assertEquals(BasePage.getDemoSiteMenu(driver).getAttribute("href"), "http://demo.automationtesting.in/Register.html");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}
