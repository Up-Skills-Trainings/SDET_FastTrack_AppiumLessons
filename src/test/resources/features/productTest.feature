Feature: Saucelab Mobile App Functionality
  Scenario: Test login and product page on local setup
    When User login to mobile app with "local" setup
    And Add first product to cart
    Then Verify product is added


  Scenario: Test login and product page on local setup
    When User login to mobile app with "remote" setup
    And Add first product to cart
    Then Verify product is added

  @wip
  Scenario: Test login and product page on local setup
    When User login to mobile app with "remoteIOS" setup
    And Add first product to cart
    Then Verify product is added