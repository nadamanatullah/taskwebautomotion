Feature: Checkout Scenario

Background: 
    Given User is on the login page 

Scenario: User can checkout product successfuly
    Given User is on the login page 
    When User logged in with "standard_user" and "secret_sauce"
    Then User is navigated to the product page
    When User adds a product to the cart "Sauce Labs Backpack"
    And User clicks on the cart icon
    Then User verify the product is added to cart "Sauce Labs Backpack"
    When User clicks on the checkout button 
    Then User is navigated to the checkout page
    When User fills in the checkout information with valid data
    Then User verify the selected product in the overview list "Sauce Labs Backpack"
    When User clicks on the finish button 
    Then User should see the order confirmation page

Scenario Outline: User can't login with invalid credentials
    Given User is on the login page
    When User logged in with "<username>" and "<password>"
    Then User should see an error message

        Examples:
            | username          | password      |
            | standard_user     | invalid1      |
            | invalid_user2     | secret_sauce  |
            | invalid_user3     | invalid3      |

Scenario Outline: User can checkout product some variant successfuly
    Given User is on the login page 
    When User logged in with "standard_user" and "secret_sauce"
    Then User is navigated to the product page
    When User adds a product to the cart "<productName>"
    And User clicks on the cart icon
    Then User verify the product is added to cart "<productName>"
    When User clicks on the checkout button 
    Then User is navigated to the checkout page
    When User fills in the checkout information with valid data
    Then User verify the selected product in the overview list "<productName>"
    When User clicks on the finish button 
    Then User should see the order confirmation page

        Examples:
            | productName                |       
            | Sauce Labs Backpack        |   
            | Sauce Labs Bike Light      |  
            | Sauce Labs Bolt T-Shirt    |