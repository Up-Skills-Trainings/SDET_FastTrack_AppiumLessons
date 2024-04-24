package com.cydeo.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

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
