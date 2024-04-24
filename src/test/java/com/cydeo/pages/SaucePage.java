package com.cydeo.pages;

import com.cydeo.utils.Driver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SaucePage {

    public SaucePage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver("local-sauceApp")),this);
    }

    @AndroidFindBy(xpath = "//*[@text='Username']")
    public WebElement userName;

    @AndroidFindBy(accessibility = "test-Password")
    public WebElement password;

    @AndroidFindBy(accessibility = "test-LOGIN")
    public WebElement loginButton;


}
