#Author: your.email@your.domain.com
@CourseClosing 
Feature: Course closing
  I want to test course closing feature  from admin side and user side 

  @CourseClosing
  Scenario: Verify course closing feature from admin site and its behavior on user site
    Given user launches the application
    Then verifies that applilcation launched successfully
    When user navigates to node as "firstNode"
    Then verify user redirects to azure login page
    When user login using "admin.username" and "admin.password"
    When user clicks on add course button
    Then user verifies the add coursed pop up dispplays
    And user verifies the admin email field placeholder value is "node.admin.username" on popup
    When user enters  following course details 
      | Title | URL Component | Course Admin Email |
      | test  | url           | course.admin.user  |
    And user clicks on "OK" button
    When user clicks on the course checkbox
    And user sets the availability to "Public (Enrolment Open)"
    When user goes to course outine page
    And user goes to course availaibity
    And user waits for "OK" confirmation
    And user checks "Course Closed" checkbox
    And user clicks on "Save" Link
    And user verifies the "saved" message for confirmation
    And user clicks on "Dashboard" link
    Then user verifies course is not present on dashboard
    And user click on Show closed courses checkbox on dashboard
    Then user verifies course is present on dashboard on closed course list
    When user navigates to node as "central"
    When user hovers on course catalog
    And user select "All" category from the list
    When user searches for "course.name.test"
    Then user verifies the search results shows "No course" message on upcoming Tab
    And user goes to "Ongoing" Tab of explorer page
    Then user verifies the search results shows "No course" message on upcoming Tab

  
