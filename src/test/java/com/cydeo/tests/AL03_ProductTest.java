package com.cydeo.tests;

import com.cydeo.pages.LoginPage;
import com.cydeo.pages.ProductPage;
import com.cydeo.utils.Driver;
import com.cydeo.utils.MobilUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AL03_ProductTest {

    @Test
    public void productTest() throws InterruptedException {

        LoginPage loginPage = new LoginPage();
        loginPage.login();


        /*
        Can we put implicit or explicit waits from Selenium
         */
        WebDriverWait wait = new WebDriverWait(Driver.getDriver("local-sauceApp"), Duration.ofSeconds(10));
        // click the product to add to cart
        ProductPage productPage = new ProductPage();

        wait.until(ExpectedConditions.visibilityOf(productPage.firstProduct));

        productPage.firstProduct.click();

        Assertions.assertEquals("REMOVE", productPage.removeElement.getAttribute("text"));

        Assertions.assertEquals("1",productPage.numberOfProducts.getAttribute("text"));

        // MobilUtils.scrollIntoView("local-sauceApp","Terms of Service | Privacy Policy");

        MobilUtils.scrollToEnd("local-sauceApp");

        Thread.sleep(1000);

        Driver.closeDriver();

        /*
        HW: Add a product to cart, then navigate to Cart and follow order instructions and make an order
            Then verify --  "THANK YOU FOR YOU ORDER"
            How to scroll down with Appium
         */

        // oscar@cydeo.com

    }

}
