@Announcement
Feature: Course Outline -Autograded Assessment
  I want to test Autograded Assessment creation as admin, taking assesssment and checking score as student

  Background: 
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
    And user clicks on the course checkbox
    When user sets the availability to "Public (Enrolment Open)"
    And user goes to course outine page
    And user goes to manage->announcment
    And store page url to "announcement.admin.page"

  @Announcement
  Scenario: Verify Announcement creation and checking it from user side
    And user clicks on "Add Announcement" button
    Then user verifies the Announcement page
    When user creates the Announcement
      | title              | body                   | date  | status |
      | announcement.title | announcement.body.text | today | Public |
    And user set the status to "Public"
    And user clicks on "Save" Link
    And user waits for "Saved" confirmation
    And user clears the browser cache
    When user navigates to node as "central"
    When user clicks on "Sign In" button from Homepage
    Then verify user redirects to azure login page
    When user login using "learner.username" and "learner.password"
    Then user redirects back to application
    When user hovers on course catalog
    And user select "All" category from the list
    When user searches for "course.name"
    Then user verifies the search results for "course.name"
    And user clicks on the course "course.name"
    And user joins the course
    And user select the indian LC on update Profile Page
    And user clicks on "Announcements" Link
    And user verifies announcement on user side
      | title              | date            | body                   |
      | announcement.title | announcement.date | announcement.body.text |
       And user clears the browser cache
    When user navigates to node as "firstNode"
    Then verify user redirects to azure login page
    When user login using "admin.username" and "admin.password"
    And user clicks on add course button
    And user navigates to node as "announcement.admin.page"
    And user verifies status as "public" for "announcement.title" announcement
    And user change the status to "private" for "announcement.title" announcement
    And user clears the browser cache
    When user navigates to node as "central"
    When user clicks on "Sign In" button from Homepage
    Then verify user redirects to azure login page
    When user login using "learner.username" and "learner.password"
    Then user redirects back to application
    When user hovers on course catalog
    And user select "All" category from the list
    When user searches for "course.name"
    Then user verifies the search results for "course.name"
    And user clicks on the course "course.name"
    And user clicks on "Go to course" button
    And user clicks on "Announcements" Link
    And user verifies that no announcement is present with "announcement.title"
      
    
    
