package com.cydeo.pages;

import com.cydeo.utils.Driver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver("local-sauceApp")),this);
    }
}
