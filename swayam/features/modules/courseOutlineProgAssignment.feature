@progAssignment
Feature: Course Outline -prog assignment
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

  @Assessment-progAssignment
  Scenario: Verify lesson creation and submission with correct ans
    When user clicks on "Add Unit" button
    When user creates a unit as "unit.name"
    And user clicks on "Save" Link
    And user waits for "Saved" confirmation
    And user clicks on "Close" Link
    When user clicks on "Programming Assignment" link under unit "Week 1"
    And user enter following required details on programming assignment page
      | Title                 | Problem Statement | Compile & Run | Program Evaluator | Ignore Presentation Errors | Due Date |
      | prog.assignment.title | problem.statement | Yes           | program.evaluator | Yes                        | future   |
    And user clicks on "Add Public Test Case" Link
    And user adds public test cases
      | input             | output             |
      | public.test.input | public.test.output |
    And user clicks on "Add Private Test Case" Link
    And user adds private test cases
      | input              | output              |
      | private.test.input | private.test.output |
    And user clicks on "Add Language" Link
    And user adds Programming Languages
      | Languages            | Sample Solution | File Name |
      | programming.Language | sample.solution | file.name |
    And store page url to "programming.admin.page"
    And user clicks on "Save" Link
    And user waits for "Saved" confirmation
    And user clicks on "Close" Link
    And user goes to course availaibity
    And user waits for "OK" confirmation
    And user set "unit.name" availability to "Course"
    And user set "prog.assignment.title" availability to "Course"
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
    And user goes to assessment "prog.assignment.title" on course outline
    And store page url to "programming.user.page"
    And user verifies the programming assingment content
      | Title                 | Problem Statement | Languages            | Due Date        |
      | prog.assignment.title | problem.statement | programming.Language | assessment.date |
    And user verifies the public test case
      | input             | output             |
      | public.test.input | public.test.output |
    And user select the Language preference as "programming.Language"
    And user verifies the filename as "file.name"
    And user writes the code as "sample.solution"
    And user compile and run the code
    And user verifies the test case status
      | name        | input             | Expectedoutput     | Actualoutput       | status |
      | Test Case 1 | public.test.input | public.test.output | public.test.output | Passed |
    And user submit the code
    And user verifies assignment submission before due date
      | name        | status |
      | Test Case 1 | Passed |
    And user clears the browser cache
    When user navigates to node as "firstNode"
    Then verify user redirects to azure login page
    When user login using "admin.username" and "admin.password"
    And user clicks on add course button
    And user navigates to node as "programming.admin.page"
    And user set the submission due date to "past"
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
    And user clicks on "Go to course" button
    And user goes to assessment "prog.assignment.title" on course outline
    And user verifies the programming assignment due date "assessment.date"
    And user verifies the test case status
      | name        | input              | Expectedoutput      | Actualoutput        | status |
      | Test Case 1 | private.test.input | private.test.output | private.test.output | Passed |
