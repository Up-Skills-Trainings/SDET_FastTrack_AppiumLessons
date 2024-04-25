package com.cydeo.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.MutableCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Objects;

public class Driver {

    public static AppiumDriver driver;
    public static URL url;
    public static UiAutomator2Options options = new UiAutomator2Options();
    private Driver(){

    }

    public static AppiumDriver getDriver(String platformType){
        String platform = ConfigurationReader.getProperty(platformType);

        String testDirectory = System.getProperty("user.dir");

        if(Objects.isNull(driver)){

            switch (platform){
                case "local-android-sauceApp":
                    options.setApp(testDirectory + "/sauceLab.apk");
                    options.setAppActivity("com.swaglabsmobileapp.MainActivity");
                    options.setAppPackage("com.swaglabsmobileapp");
                    try {
                        url = new URL("http://localhost:4723");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    driver = new AndroidDriver(url,options);
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                    break;
                case "remote-android-sauceApp":
                    MutableCapabilities caps = new MutableCapabilities();
                    caps.setCapability("platformName", "Android");
                    // change Application part
                    caps.setCapability("appium:app", "https://github.com/saucelabs/sample-app-mobile/releases/download/2.7.1/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
                    caps.setCapability("appium:deviceName", "Google Pixel 3 GoogleAPI Emulator");
                    caps.setCapability("appium:platformVersion", "11.0");
                    caps.setCapability("appium:automationName", "UiAutomator2");
                    caps.setCapability("appPackage","com.swaglabsmobileapp");
                    caps.setCapability("appActivity","com.swaglabsmobileapp.MainActivity");
                    // add app activity and package
                    MutableCapabilities sauceOptions = new MutableCapabilities();
                    sauceOptions.setCapability("appiumVersion", "2.0.0");
                    // username and access key is unique to the user
                    sauceOptions.setCapability("username", "oauth-testermichael77-6fc8b");
                    sauceOptions.setCapability("accessKey", "54923638-aed6-4432-8e2e-d8b72784bc1b");
                    sauceOptions.setCapability("build", "sauceLab123");
                    sauceOptions.setCapability("name", "smokeTest");
                    sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
                    caps.setCapability("sauce:options", sauceOptions);

                    try {
                        url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    driver = new AndroidDriver(url, caps);
                    break;

            }

        }
        return driver;
    }

    public static void closeDriver(){
        if(Objects.nonNull(driver)){
            driver.quit();
            driver = null;
        }
    }

}
