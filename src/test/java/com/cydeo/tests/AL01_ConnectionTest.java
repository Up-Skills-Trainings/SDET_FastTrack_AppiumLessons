package com.cydeo.tests;

import com.cydeo.utils.Driver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AL01_ConnectionTest {
    @Test
    public void test01() throws MalformedURLException {
        // UiAutomator2Options is the class that allows you to configure your driver with different options, we were using DesiredCapabilities before
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("app","myapp.apk");

        String testDirectory = System.getProperty("user.dir");

        UiAutomator2Options options = new UiAutomator2Options();
        options.setApp(testDirectory + "/sauceLab.apk");
        options.setAppActivity("com.swaglabsmobileapp.MainActivity");
        options.setAppPackage("com.swaglabsmobileapp");

        AndroidDriver driver = new AndroidDriver (new URL ("http://127.0.0.1:4723"), options);

        // Incorrect package and activity. Retrying.: you need to provide app activity and package name to appium

        System.out.println(driver.getDeviceTime());

        driver.quit();
    }

    @Test
    public void testWithSingletonDriver(){

        AppiumDriver driver = Driver.getDriver("local-sauceApp");

        System.out.println(((AndroidDriver)driver).getDeviceTime()); // since we created our driver as AppiumDriver which is an interface we need to cast driver object to use some of the methods defined only in the Android class

        Driver.closeDriver();

        // IOS devices use totally a different application which have .ipa extension, when creating driver we need to provide that application parameters
    }
}
