package works.buddy.test;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.junit.Assert.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    private WebDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(new URL("http://selenium-ch:4444/wd/hub"), capability);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @Test
    public void test1() throws Exception {
    	driver.get("https://buddy.works");
        assertEquals("Buddy - The Development Automation and Continuous Delivery Platform", driver.getTitle());
    }

	//Error
    @Test
    public void test2() throws Exception {
    	driver.get("https://buddy.works");
        assertEquals("Buddy Works", driver.getTitle());
    }

    @After
    public void tearDown() {
    	driver.quit();
    }

}