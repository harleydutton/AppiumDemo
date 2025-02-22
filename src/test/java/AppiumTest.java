import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AppiumTest {

    static AppiumDriverLocalService service;
    static AndroidDriver driver;

    @BeforeClass
    static void LoadAppiumServer(){
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
        // do stuff with drivers. here or elsewhere?
    }

    @BeforeTest
    static void SetupAppiumDrivers() throws MalformedURLException{
        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid("123456")
                .setApp("/home/myapp.apk");
        // The default URL in Appium 1 is http://127.0.0.1:4723/wd/hub
        URL url = URI.create("http://127.0.0.1:4723").toURL();
        driver = new AndroidDriver(url, options);
    }

    @AfterClass
    static void StopAppiumServer(){
        service.stop();
    }
    
    @Test
    static void Test2(){
        String expectedText = "asdfasdf";
        String actualText = "";
        Assert.assertEquals(expectedText,actualText);
    }
}
