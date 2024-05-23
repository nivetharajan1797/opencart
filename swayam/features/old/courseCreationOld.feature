#Author: vaibhav_choudhary@persistent.com
#Keywords Summary :
@courseCreation
Feature: Create a course
  I want to create a course from admin site and verify it on user site

  Background: 
    Given user launches the application
    Then verifies that applilcation launched successfully

  #~@courseCreation1
  #Scenario: Verify filter selection for Course Duration
  #When user clicks on "Sign In" button on google page
  #Then verify user redirects to google sing in page
  #When user login using "admin.username" and "admin.password"
  #Then user  redirect back to application
  #And user verifies the "Dashboard" link on header
  #When user navigates to "nptel.node" Node
  #Then user verifies Node Homepage
  #When user clicks on "Login" link
  #Then user logged in to the application with "admin.username"
  #When user clicks on "Dashboard" link after login
  #Then user verifies the admin site page
  #When user clicks on add course button
  #Then user verifies the add coursed pop up dispplays
  #And user verifies the admin email field placeholder value is  "admin.username" on popup
  #When user enters  following course details
  #| Title | URL Component | Course Admin Email |
  #| test  | url           | test@test.com      |
  #And user clicks on "Cancel" button
  #Then user verifies the course on course list
  #And user verifies the course URL for created course
  #When user sets the availability to "Registration - Open"
  #And user click on course from course list page
  #And user clicks on "Add Unit" button
  #When user  creates a unit
  #And user clicks on "Save" Link
  #And user clicks on "Close" Link
  #When user selects assessement link
  #And user creates a assessment
  #And user clicks on "Save" Link
  #And user clicks on "Close" Link
  #When user change the course avialibility
  #And user clicks on "Save" Link
  @courseCreation2
  Scenario: Verify  course created on Node , is displayed correctly on Central
    #When user clicks on "Sign In" button on google page
    #Then verify user redirects to google sing in page
    #When user login using "admin.username" and "admin.password"
    #Then user  redirect back to application
    #And user verifies the "Dashboard" link on header
    #And user clears the browser cache
    When user navigates to "nptel.node" Node
    Then user verifies Node Homepage
    When user clicks on "Login" link
    When user login using "node.admin.username" and "node.admin.password"
    When user clicks on "Dashboard" link after login
    Then user verifies the admin site page
    When user clicks on add course button
    Then user verifies the add coursed pop up dispplays
    And user verifies the admin email field placeholder value is  "node.admin.username" on popup
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
    When user clicks on "Learning Path" dropdown
    Then user verifies the following "Learning Path" dropdown options
      | All           |
      | Post Graduate |
      | Undergraduate |
      | Diploma       |
      | School        |
      | Certificate   |
    When user clicks on "National Coordinator" dropdown
    Then user verifies the following "National Coordinator" dropdown options
      | All   |
      | UGC   |
      | CEC   |
      | IIMB  |
      | NPTEL |
    When user clicks on "Course Status" dropdown
    Then user verifies the following "Course Status" dropdown options
      | All       |
      | Current   |
      | Upcoming  |
      | Completed |
    When user clicks on "Course Exam Date" dropdown
    Then user verifies the following "Course Exam Date" dropdown options
      | All             |
      | Sun May 19 2019 |
      | Sun May 12 2019 |
      | Sun May 05 2019 |
      | Sun Apr 07 2019 |
      | Thu Mar 14 2019 |
