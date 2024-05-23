@Lessonflow
Feature: Course Outline -lesson
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

  @Assessment-lesson
  Scenario: Verify lesson creation and submission with correct ans
    When user clicks on "Add Unit" button
    When user creates a unit as "unit.name"
    And user clicks on "Save" Link
    And user waits for "Saved" confirmation
    And user clicks on "Close" Link
    When user clicks on "lesson" link under unit "Week 1"
    And user enter following required details on lesson page
      | Title        | videoID  | lessonBody          |
      | lesson.title | video.id | lesson.body.content |
    And store page url to "lesson.admin.page"
    And user clicks on "Save" Link
    And user waits for "Saved" confirmation
    And user clicks on "Close" Link
    And user goes to course availaibity
    And user waits for "OK" confirmation
    And user set "unit.name" availability to "Course"
    And user set "lesson.title" availability to "Course"
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
    And user goes to assessment "lesson.title" on course outline
    And store page url to "lesson.user.page"
    And user verifies the lesson content
      | Title        | videoID  | lessonBody          |
      | lesson.title | video.id | lesson.body.content |
