package com.cydeo.pages;

import com.cydeo.utils.ConfigurationReader;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    @AndroidFindBy(xpath = "//*[@text='Username']")
    public WebElement userName;

    @AndroidFindBy(accessibility = "test-Password")
    public WebElement password;

    @AndroidFindBy(accessibility = "test-LOGIN")
    public WebElement loginButton;

    public void login(){
        userName.sendKeys(ConfigurationReader.getProperty("userName"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        loginButton.click();
    }

}
