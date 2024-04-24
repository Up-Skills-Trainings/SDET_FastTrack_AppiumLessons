Feature: Saucelab Mobile App Functionality
@wip
  Scenario: Test login and product page
    When User login to mobile app with "local" setup
    And Add first product to cart
    Then Verify product is added