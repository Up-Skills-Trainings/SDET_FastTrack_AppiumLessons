package com.cydeo.step_definitions;

import com.cydeo.pages.LoginPage;
import com.cydeo.pages.ProductPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ProductTestSteps {
    LoginPage loginPage;
    ProductPage productPage;
    @When("User login to mobile app with {string} setup")
    public void user_login_to_mobile_app_with_setup(String env) {
        loginPage = new LoginPage(env);
        productPage = new ProductPage(env);
        loginPage.login();
    }
    @When("Add first product to cart")
    public void add_first_product_to_cart() {
        productPage.firstProduct.click();
    }
    @Then("Verify product is added")
    public void verify_product_is_added() {
     Assertions.assertEquals("REMOVE",  productPage.removeElement.getAttribute("text"));
     Assertions.assertEquals("1",productPage.numberOfProducts.getAttribute("text"));
    }
}
