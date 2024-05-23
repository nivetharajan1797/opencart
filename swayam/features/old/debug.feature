@debug
Feature: debug features

  Background: 
    Given user launches the application
    Then verifies that applilcation launched successfully
    And store debug page url to "page.to.debug"
    And user navigates to node as "page.to.debug"
    Then verify user redirects to azure login page
    When user login using "admin.username" and "admin.password"
    And user waits for sometime

  @debug1
  Scenario: testing
    When user goes to manage->announcment
    And user clicks on "Add Announcement" button
    Then user verifies the Announcement page
    When user creates the Announcement
      | title              | body              | date  | status |
      | announcement.title | announcement.body | today | Public |
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
      | title              | date            | body              |
      | announcement.title | assessment.date | announcement.body |
     #And user set the announcement date to "today"
