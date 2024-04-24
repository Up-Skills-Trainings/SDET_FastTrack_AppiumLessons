package com.cydeo.tests;

import com.cydeo.pages.LoginPage;
import com.cydeo.utils.Driver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

public class AL02_LoginTest {
    @Test
    public void login() throws InterruptedException {

        AppiumDriver driver = Driver.getDriver("local-sauceApp");

        Thread.sleep(3000);
      //  WebElement userNameBox = driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]"));
      //  WebElement userNameBox = driver.findElement(By.xpath("//*[@text='Username']")); // we use here text attribute
        WebElement userNameBox = driver.findElement(new AppiumBy.ByAccessibilityId("test-Username"));
        WebElement passwordBox = driver.findElement(new AppiumBy.ByAccessibilityId("test-Password"));
        WebElement loginButton = driver.findElement(new AppiumBy.ByAccessibilityId("test-LOGIN"));

        System.out.println(userNameBox.getAttribute("text"));


        userNameBox.sendKeys("standard_user");
        passwordBox.sendKeys("secret_sauce");
        loginButton.click();


        Thread.sleep(3000);

        Driver.closeDriver();
    }

    @Test
    public void loginWithPOM() throws InterruptedException {

        LoginPage page = new LoginPage();

        page.userName.sendKeys("standard_user");
        page.password.sendKeys("secret_sauce");
        page.loginButton.click();

        Thread.sleep(3000);

        Driver.closeDriver();
    }

    /*
    HW:
    implement Conf.Reader and Conf.prop approach
    then login to application and click on a product and verify

     */

}
