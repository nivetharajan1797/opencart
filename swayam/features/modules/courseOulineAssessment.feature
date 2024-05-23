@Assessmentflow 
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

  @Assessment-correctAnswer
  Scenario: Verify assessment creation and submission with correct ans
    When user clicks on "Add Unit" button
    When user creates a unit as "unit.name"
    And user clicks on "Save" Link
    And user waits for "Saved" confirmation
    And user clicks on "Close" Link
    When user clicks on "assessment" link under unit "Week 1"
    And user enter following required details on assessment page
      | Title                     | Points | Show Correct Answer | Single Submission | Due Date |
      | assessment.correct.header |      5 | No                  | No                | future   |
    And store page url to "assessment.admin.page"
    And user add questions to the assessment
      | questionname     | choice 1 | choice 2 | choice 3 | choice 4 | description      |
      | assessment.ques1 | A        | B        | C        | D        | correct question |
    And user clicks on "Save" Link
    And user waits for "Saved" confirmation
    And user clicks on "Close" Link
    And user goes to course availaibity
    And user waits for "OK" confirmation
    And user set "unit.name" availability to "Course"
    And user set "assessment.correct.header" availability to "Course"
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
    And user goes to assessment "assessment.correct.header" on course outline
    And store page url to "assessment.user.page"
    And user verifies the assessment content
      | Title                     | Question         | Options            | Due Date        | Points            | Submission Type | Show Correct Answer |
      | assessment.correct.header | assessment.ques1 | assessment.options | assessment.date | assessment.points | multiple        | No                  |
    And user chooses "first" option
    And user submits the assessment
    And user verifies the confirmation message "submit.confirmation.msg" for "assessment.correct.header"
    And user clears the browser cache
    When user navigates to node as "firstNode"
    Then verify user redirects to azure login page
    When user login using "admin.username" and "admin.password"
    And user clicks on add course button
    And user navigates to node as "assessment.admin.page"
    And user set the assessment due date to "past"
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
    And user goes to assessment "assessment.correct.header" on course outline
    And user verifies the assessment due date "assessment.date"
    And user verified the due date passed message "duedate.passed.text"
    And user verifies the assessment result as "assessment.result.correct"
    And user clicks on "Progress" Link
    And user verifies the score on progress page
      | entityname                | score |
      | assessment.correct.header | 100.0 |

  @Assessment-wrongAnswer
  Scenario: Verify assessment creation and submission with wrong ans
    When user clicks on "Add Unit" button
    When user creates a unit as "unit.name"
    And user clicks on "Save" Link
    And user waits for "Saved" confirmation
    And user clicks on "Close" Link
    When user clicks on "assessment" link under unit "Week 1"
    And user enter following required details on assessment page
      | Title                   | Points | Show Correct Answer | Single Submission | Due Date |
      | assessment.wrong.header |      5 | No                  | No                | future   |
    And store page url to "assessment.admin.page"
    And user add questions to the assessment
      | questionname     | choice 1 | choice 2 | choice 3 | choice 4 | description    |
      | assessment.ques2 | A        | B        | C        | D        | worng question |
    And user clicks on "Save" Link
    And user waits for "Saved" confirmation
    And user clicks on "Close" Link
    And user goes to course availaibity
    And user waits for "OK" confirmation
    And user set "unit.name" availability to "Course"
    And user set "assessment.wrong.header" availability to "Course"
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
    And user goes to assessment "assessment.wrong.header" on course outline
    And store page url to "assessment.user.page"
    And user verifies the assessment content
      | Title                   | Question         | Options            | Due Date        | Points            | Submission Type | Show Correct Answer |
      | assessment.wrong.header | assessment.ques2 | assessment.options | assessment.date | assessment.points | multiple        | No                  |
    And user chooses "second" option
    And user submits the assessment
    And user verifies the confirmation message "submit.confirmation.msg" for "assessment.wrong.header"
    And user clears the browser cache
    When user navigates to node as "firstNode"
    Then verify user redirects to azure login page
    When user login using "admin.username" and "admin.password"
    And user clicks on add course button
    And user navigates to node as "assessment.admin.page"
    And user set the assessment due date to "past"
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
    And user goes to assessment "assessment.wrong.header" on course outline
    And user verifies the assessment due date "assessment.date"
    And user verified the due date passed message "duedate.passed.text"
    And user verifies the assessment result as "assessment.result.incorrect"
    And user clicks on "Progress" Link
    And user verifies the score on progress page
      | entityname              | score |
      | assessment.wrong.header |   0.0 |
