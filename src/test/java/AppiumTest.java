import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumTest {

    //put these strings in a config file somewhere
    static String appiumPath = "/var/home/hdutton/bin/node_modules/bin/appium";
    static String nodePath = "/usr/bin/node";
    static String apkPath = "/var/home/hdutton/src/test/resources/selendroid-test-app.apk";
    static String udid = "123456";
    static String appiumURI = "http://127.0.0.1:4723";


    static AppiumDriverLocalService service;
    static AndroidDriver driver;

    @BeforeClass
    static void LoadAppiumServer(){
        AppiumServiceBuilder asb = new AppiumServiceBuilder()
                .withAppiumJS(new File(appiumPath))
                .withIPAddress(null)
                .usingPort(1234)
                .usingDriverExecutable(new File(nodePath));
        service = AppiumDriverLocalService.buildService(asb);
        service.start();
    }

    @BeforeTest
    static void SetupAppiumDriver() throws MalformedURLException{
        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid(udid)
                .setApp(apkPath);
        // The default URL in Appium 1 is http://127.0.0.1:4723/wd/hub
        URL url = URI.create(appiumURI).toURL();
        driver = new AndroidDriver(url, options);
    }

    static void TeardownAppiumDriver(){
        driver.quit();
    }

    @AfterClass
    static void StopAppiumServer(){
        service.stop();
    }
    
    @Test
    static void Test2(){

        WebElement el = driver.findElement(AppiumBy.xpath("//Button"));
        el.click();
        driver.getPageSource();

        String expectedText = "asdfasdf";
        String actualText = "";
        Assert.assertEquals(expectedText,actualText);
    }
}
