package com.cydeo.pages;

import com.cydeo.utils.Driver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage(String env){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver(env+"-sauceApp")),this);
    }
}
