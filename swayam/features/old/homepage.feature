@homepage
Feature: verify website landing page

  Background: 
    Given user launches the application
    Then verifies that applilcation launched successfully

  @categoryDropdown
  Scenario: Verify category dropdown options on homepage
    When user hovers on course catalog
   # Then user verifies dropdown is displayed with following <categories>
      | Arts     |
      | Language |
      | Science  |

  @categorySelection
  Scenario: Verify category selection from  dropdown options on homepage
    When user hovers on course catalog
    And user select "Arts" category from the list
    Then user verifies the "Arts" category page

  @FilterSelection
  Scenario: Verify filter selection
    When user hovers on course catalog
    And user select "Arts" category from the list
    Then user verifies the "Arts" category page
