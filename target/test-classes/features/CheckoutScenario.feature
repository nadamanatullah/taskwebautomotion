Feature: Checkout Scenario

    Scenario: User can checkout product successfuly
        Given User is on the login page 
        When User logged in with valid credentials
        Then User is navigated to the product page
        When User adds a product to the cart
        And User clicks on the cart icon
        Then User verify the product is added to cart
        When User clicks on the checkout button 
        Then User is navigated to the checkout page
        When User fills in the checkout information with valid data
        Then User verify the selected product in the overview list
        When User clicks on the finish button 
        Then User should see the order confirmation page
        