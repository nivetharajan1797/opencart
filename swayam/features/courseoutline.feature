@CourseOutline @regression
Feature: Course Outline -Lesson,Autograded Assignement and Programming Assignment
  I want to test Lesson,Autograded assessment and Programming assignment creation as admin, verifying lesson content, doing assesssments and checking score as student

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

  @Assessment-correctAnswer
  Scenario: Verify course outline for Lesson, Assessment and Programming Assingment
    When user clicks on "Add Unit" button
    When user creates a unit as "unit.name"
    And user clicks on "Save" Link
    And user waits for "Saved" confirmation
    And user clicks on "Close" Link
    #lesson creation
    When user clicks on "lesson" link under unit "Week 1"
    And user enter following required details on lesson page
      | Title        | videoID  | lessonBody          |
      | lesson.title | video.id | lesson.body.content |
    And store page url to "lesson.admin.page"
    And user clicks on "Save" Link
    And user waits for "Saved" confirmation
    And user clicks on "Close" Link
    #autograded assessment creation
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
    #programming assignment creation
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
    #Creating Announcemnet
    And user goes to manage->announcment
    And store page url to "announcement.admin.page"
    And user clicks on "Add Announcement" button
    Then user verifies the Announcement page
    When user creates the Announcement
      | title              | body                   | date  | status |
      | announcement.title | announcement.body.text | today | Public |
    And user set the status to "Public"
    And user clicks on "Save" Link
    And user waits for "Saved" confirmation
    #changing availability
    And user goes to course availaibity
    And user waits for "OK" confirmation
    And user set "unit.name" availability to "Course"
    And user set "lesson.title" availability to "Course"
    And user set "assessment.correct.header" availability to "Course"
    And user set "prog.assignment.title" availability to "Course"
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
    #verifying lesson content
    And user goes to assessment "lesson.title" on course outline
    And store page url to "lesson.user.page"
    And user verifies the lesson content
      | Title        | videoID  | lessonBody          |
      | lesson.title | video.id | lesson.body.content |
    #verifying assessment content and submission
    And user goes to assessment "assessment.correct.header" on course outline
    And store page url to "assessment.user.page"
    And user verifies the assessment content
      | Title                     | Question         | Options            | Due Date        | Points            | Submission Type | Show Correct Answer |
      | assessment.correct.header | assessment.ques1 | assessment.options | assessment.date | assessment.points | multiple        | No                  |
    And user chooses "first" option
    And user submits the assessment
    And user verifies the confirmation message "submit.confirmation.msg" for "assessment.correct.header"
    #verifying prog assignment content and submission
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
    #verifying announcement
    And user clicks on "Announcements" Link
    And user verifies announcement on user side
      | title              | date            | body                   |
      | announcement.title | announcement.date | announcement.body.text |
    And user logout from user side
    When user navigates to node as "firstNode"
    Then verify user redirects to azure login page
     When user login using local user as "admin.local.username" and "admin.local.password" 
    And user clicks on add course button
    #passing due date assessment
    And user navigates to node as "assessment.admin.page"
    And user set the assessment due date to "past"
    And user clicks on "Save" Link
    And user waits for "Saved" confirmation
    #passing due date prog assignment
    And user navigates to node as "programming.admin.page"
    And user set the submission due date to "past"
    And user clicks on "Save" Link
    And user waits for "Saved" confirmation
    #making announcement private
    And user navigates to node as "announcement.admin.page"
    And user verifies status as "public" for "announcement.title" announcement
    And user change the status to "private" for "announcement.title" announcement
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
    And user goes to assessment "assessment.correct.header" on course outline
    And user verifies the assessment due date "assessment.date"
    And user verified the due date passed message "duedate.passed.text"
    And user verifies the assessment result as "assessment.result.correct"
    And user clicks on "Progress" Link
    And user verifies the score on progress page
      | entityname                | score |
      | assessment.correct.header | 100.0 |
    And user goes to assessment "prog.assignment.title" on course outline
    And user verifies the programming assignment due date "assessment.date"
    And user verifies the test case status
      | name        | input              | Expectedoutput      | Actualoutput        | status |
      | Test Case 1 | private.test.input | private.test.output | private.test.output | Passed |
    And user clicks on "Progress" Link
    And user verifies the score on progress page
      | entityname            | score |
      | prog.assignment.title | 100.0 |
    And user clicks on "Announcements" Link
    And user verifies that no announcement is present with "announcement.title"
