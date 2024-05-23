@CourseAvalability @regression @jenkins
Feature: Course Availability 
  I want to test course availability for opened, closed  and private

  Background: 
    Given user launches the application
    Then verifies that applilcation launched successfully
    When user navigates to node as "firstNode"
    Then verify user redirects to azure login page
    When user login using local user as "admin.local.username" and "admin.local.password"
    When user clicks on add course button
    Then user verifies the add coursed pop up dispplays
    And user verifies the admin email field placeholder value is "node.admin.username" on popup
    When user enters  following course details
      | Title | URL Component | Course Admin Email |
      | test  | url           | course.admin.user  |
    And user clicks on "OK" button 

  @CourseAvailability-EnrolmentOpen
  Scenario: Verify course availability for Enrolment Open course
    #When user clicks on add course button
    #Then user verifies the add coursed pop up dispplays
    #And user verifies the admin email field placeholder value is "node.admin.username" on popup
    #When user enters  following course details
      #| Title | URL Component | Course Admin Email |
      #| test  | url           | course.admin.user  |
    #And user clicks on "OK" button
    When user clicks on the course checkbox
    And user sets the availability to "Public (Enrolment Open)"
    And user navigates to node as "central"
    And user hovers on course catalog
    And user select "All" category from the list
    And user searches for "course.name"
    Then user verifies the search results for "course.name"

  
  @CourseAvailability-EnrolmentClosed
  Scenario: Verify course availability for Enrolment closed course
  When user clicks on the course checkbox
  And user sets the availability to "Public (Enrolment Closed)"
  And user navigates to node as "central"
  And user hovers on course catalog
  And user select "All" category from the list
  And user searches for "course.name"
  Then user verifies the search results shows "No course" message on upcoming Tab
  And user goes to "Ongoing" Tab of explorer page
  Then user verifies the search results for "course.name"
  
  @CourseAvailability-Private
  Scenario: Verify course availability for private course
  When user clicks on the course checkbox
  And user sets the availability to "Private"
  When user navigates to node as "central"
  When user hovers on course catalog
  And user select "All" category from the list
  When user searches for "course.name.test"
  Then user verifies the search results shows "No course" message on upcoming Tab
  And user goes to "Ongoing" Tab of explorer page
  Then user verifies the search results shows "No course" message on upcoming Tab
  
  

