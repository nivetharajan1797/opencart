@ExplorerPage
Feature: verify Explorer Page features

  Background: 
    Given user launches the application
    Then verifies that applilcation launched successfully
    When user hovers on course catalog
    And user select "All" category from the list

  @FilterOptions-valuelist
  Scenario: Verify filter selection for Learning Path
    When user clicks on "Course Duration" dropdown
    Then user verifies the following "Course Duration" dropdown options
      | All      |
      | 4 Weeks  |
      | 8 Weeks  |
      | 12 Weeks |
    When user clicks on "Course Credits" dropdown
    Then user verifies the following "Course Credits	" dropdown options
      | All |
      | Yes |
      | No  |
      

