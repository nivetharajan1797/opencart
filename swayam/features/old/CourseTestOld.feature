#Author: vaibhav_choudhary@persistent.com
#Keywords Summary :
@courseCreationNew
Feature: Course Test
  I want to verify course related scenarios

  Background: 
    Given user launches the application
    # Then verifies that applilcation launched successfully
    When user clicks on "Sign In" button on google page
    #Then verify user redirects to google sing in page
    When user login using "admin.username" and "admin.password"
    Then user  redirect back to application
    #And user verifies the "Dashboard" link on header
    When user navigates to "nptel.node" Node
    #Then user verifies Node Homepage
    When user clicks on "Login" link
    Then user logged in to the application with "admin.username"
    When user clicks on "Dashboard" link after login
    #Then user verifies the admin site page
    When user clicks on add course button
    #Then user verifies the add coursed pop up dispplays
    #And user verifies the admin email field placeholder value is  "admin.username" on popup
    When user enters  following course details
      | Title | URL Component | Course Admin Email |
      | test  | url           | test@test.com      |
    And user clicks on "OK" button
    Then user verifies the course on course list
    And user verifies the course URL for created course
    When user sets the availability to "Registration - Open"
    And user click on course from course list page
    When user goes  to course settings
    And user changes the course settings
      | CourseCredit | CourseWeeks |
      |            3 | 4 weeks     |
    And user clicks on "Save" Link
    And user goes back to the app
    When user hovers on course catalog
    And user select "All" category from the list
    And user verifies the course details

  @courseCreation3
  Scenario: Verify  course created on Node , is displayed correctly on Central
    #When user logouts from the app
    #When user login using "admin.username" and "admin.password"
    #And user select "All" category from the list
    #And user selects the course
    #And user verifies the course name on preview page 
    #When user clicks on join button
    #And user verifies the registration form on Node page
