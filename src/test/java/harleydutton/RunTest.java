package harleydutton;

import java.net.URL;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class RunTest {
    UiAutomator2Options options = new UiAutomator2Options()
            .setUdid("123456")
            .setApp("/home/myapp.apk");
    AndroidDriver driver = new AndroidDriver(
        new URL("http://127.0.0.1:4723"), options);
    try {
        WebElement el = driver.findElement(AppiumBy.xpath("//Button"));
        el.click();
        driver.getPageSource();
    } finally {
        driver.quit();
    }
}
