package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class BaseTestClass {

    public WebDriver driver = null;

    public void setUpTest(String browser, String url, String node, String os) throws MalformedURLException, InterruptedException {
        TestSetup setUp = new TestSetup(os, browser, url, node);
        driver = setUp.getDriver();
    }

}
