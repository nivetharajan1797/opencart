@subjectiveAssignment01 @regression
Feature: Course Outline -Subjective assignment
  I want to test Autograded Assessment creation as admin, taking assesssment and checking score as student

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
    And user clicks on the course checkbox
    When user sets the availability to "Public (Enrolment Open)"
    And user goes to course outine page
    And user goes to manage->coursestaff
    And store page url to "courseStaff.admin.page"
    And user adds a course staff to the course as "courseStaff.email"
    And user verifies the coursestaff successfull addition using "coursestaff.add.success.msg"
    And user goes to course outine page
    When user goes to course settings
    And user scrolls down for Save button on Course Settings page
    And user clicks on "Save" Link
    And user goes to course outine

  Scenario: Verify subjective assignment creation
    When user clicks on "Add Unit" button
    When user creates a unit as "unit.name"
    And user clicks on "Save" Link
    And user waits for "Saved" confirmation
    And user clicks on "Close" Link
    When user clicks on "Subjective Assignment" link under unit "Week 1"
    And user enter following required details on subjective assignment page
      | Title                | Assignment Type           | Problem Statement     | Submission Due Date | Evaluation Due Date | Number of Submissions    | Number of reviewers | Scoring method     |
      | sub.assignment.title | sub.assignment.type.essay | sub.problem.statement | future              | two                 | submission.type.multiple | number.reviewers    | scoring.method.avg |
    And store page url to "subjective.admin.page"
    And user clicks on "Save" Link
    And user waits for "Saved" confirmation
    And user clicks on "Close" Link
    
    #changing availability
    
    And user goes to course availaibity
    And user waits for "OK" confirmation
    And user set "unit.name" availability to "Course"
    And user set "sub.assignment.title" availability to "Course"
    And user clicks on "Save" Link
    And user waits for "Saved" confirmation
    And user clicks on "Logout" Link
    When user navigates to node as "central"
    When user clicks on "Sign In" button from Homepage
    Then verify user redirects to azure login page
    When user login using local user as "local.learner.username" and "local.learner.password"
    Then user redirects back to application
    When user hovers on course catalog
    And user select "All" category from the list
    When user searches for "course.name"
    Then user verifies the search results for "course.name"
    And user clicks on the course "course.name"
    And user joins the course
    And user choose to edit the profile before joining
    And user select the indian LC on update Profile Page
    
    #verifying prog assignment content and submission
    
    And user goes to assessment "sub.assignment.title" on course outline
    And store page url to "subjective.user.page"
    And user verifies the subjective assingment content
      | Title                | Problem Statement     | Due Date        |
      | sub.assignment.title | sub.problem.statement | assessment.date |
    And user enters the subjective assignment solution as "subjective.assignment.solution"
    And user submits the assignment
    And user verifies the confirmation message "submit.subj.confirmation.msg" for subjective assignment
    And user logout from user side
    When user navigates to node as "firstNode"
    Then verify user redirects to azure login page
    When user login using local user as "admin.local.username" and "admin.local.password"
    And user clicks on add course button
    
    #passing due date assessment
    #passing due date prog assignment
    
    And user navigates to node as "subjective.admin.page"
    And user set the submission due date to "past"
    And user clicks on "Save" Link
    And user waits for "Saved" confirmation
    And user clicks on "Logout" Link
    When user navigates to node as "central"
    When user clicks on "Sign In" button from Homepage
    Then verify user redirects to azure login page
    When user login using local user as "local.learner.username" and "local.learner.password"
    Then user redirects back to application
    When user hovers on course catalog
    And user select "All" category from the list
    When user searches for "course.name"
    Then user verifies the search results for "course.name"
    And user clicks on the course "course.name"
    And user clicks on "Go to course" button
    And user goes to assessment "sub.assignment.title" on course outline
    And user verifies the programming assignment due date "assessment.date"
    And user logout from user side
    When user navigates to node as "central"
    When user clicks on "Sign In" button from Homepage
    Then verify user redirects to azure login page
    When user login using local user as "local.evaluator.username" and "local.evaluator.password"
    Then user redirects back to application
    When user hovers on course catalog
    And user select "All" category from the list
    When user searches for "course.name"
    Then user verifies the search results for "course.name"
    And user clicks on the course "course.name"
    And user joins the course
    And user choose to edit the profile before joining
    And user select the indian LC on update Profile Page
    And user goes to assessment "sub.assignment.title" on course outline
    And user clicks on "Course Staff" Link
    And user verifies the course staff page header as "coursestaff.page.header"
    And user clicks on "sub.assignment.title" link using property
    And user verifies the course staff view for submission of "sub.assignment.title"
    And user clicks on "Show Evaluated Submissions" Link
    And user verifies not evaluated any submissions message "coursestaff.notEvaluate.msg"
    And user clicks on "Show unevaluated Submissions" Link
    And user verified evaluation table
    And user clicks on "Evaluate" Link
    And user verifies the evaluation page
    And user verifies the student submission as "subjective.assignment.solution"
    And user enter course staff comments "subjective.cs.comment"
    And user gives score to assignment as "50"
    And user clicks on "Submit" button with contains
    And user logout from user side
    When user navigates to node as "central"
    When user clicks on "Sign In" button from Homepage
    Then verify user redirects to azure login page
    When user login using local user as "local.learner.username" and "local.learner.password"
    Then user redirects back to application
    When user hovers on course catalog
    And user select "All" category from the list
    When user searches for "course.name"
    Then user verifies the search results for "course.name"
    And user clicks on the course "course.name"
    And user clicks on "Go to course" button
    And user goes to assessment "sub.assignment.title" on course outline
    And user verifies the programming assignment due date "assessment.date"
    And user verified the due date passed message for SA "duedate.passed.text"
    And user verifies subjective assignment for scores and comment
      | score    | comment               |
      | sa.score | subjective.cs.comment |
    And user clicks on "Progress" Link
    And user verifies the score on progress page
      | entityname           | score |
      | sub.assignment.title |  50.0 |
