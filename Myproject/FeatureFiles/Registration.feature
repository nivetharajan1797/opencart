Feature: Account Registration

  Scenario: Successful registration with valid details
    Given the user is on the nopcommerce page
    And   User clicks on the My Account button
    Then  Click on the Register button
    And 	User should fill the required details
      | firstName   | Nivi     |
      | lastName  | R          |
      | telephone | 1234567890 |
      | password  | test@123   |
    Then  Click on the privacy policy
    Then  Click on the continue button
    And   User should see the confirmation message

