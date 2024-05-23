@questionsMathJax @regression
Feature: Questions - MathJax
  I want to test questions which are of type MathJax. Student will submit assessment answers.

  Background: 
    Given user launches the application
    Then verifies that applilcation launched successfully
    When user navigates to node as "firstNode"
    Then verify user redirects to azure login page
    #When user login using "admin.username" and "admin.password"
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

  @QuestionMathJax
  Scenario: Verify MathJax question and student submit assessment
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
    
    # user adds questions by clicking on Questions link in left panel
    
    When user clicks on Questions link to add questions
    And user clicks on Add Multiple Choice button
    And user enter following required details on Multiple Choice Question page
       | Question                    | MathJax Expression            | Choice1  									| Choice2                  	 | Description                  |
       | assessment.mathjax.question | assessment.mathjax.expression | assessment.mathjax.choice1 | assessment.mathjax.choice2 | assessment.description.short |   
    And user clicks on "Save" Link
    And user waits for "Saved" confirmation
    And user clicks on "Close" Link
    And user confirms that question is added successfully
       | Description                  |
       | assessment.description.short |
    And user goes to course outine
    
    #autograded assessment creation
    
    When user clicks on "assessment" link under unit "Week 1"
    And user enter following required details on assessment page
      | Title                     | Points | Show Correct Answer | Single Submission | Due Date |
      | assessment.correct.header |      5 | No                  | No                | future   |  
    And store page url to "assessment.admin.page"
    And user navigates to Select Existing tab
    And user adds existing question
    #And user scrolls down for Close button
    And user scrolls down for Save button
    And user clicks on "Save" Link
    And user waits for "Saved" confirmation
    And user clicks on "Close" Link
   
    #changing availability
    And user goes to course availaibity
    And user waits for "OK" confirmation
    And user set "unit.name" availability to "Course"
    And user set "lesson.title" availability to "Course"
    And user set "assessment.correct.header" availability to "Course"
    And user clicks on "Save" Link
    And user waits for "Saved" confirmation
    And user clicks on "Logout" Link
    And user clears the browser cache
    
    # Login as a student and verify
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
    
    # verifying lesson content
    And user goes to assessment "lesson.title" on course outline
    And store page url to "lesson.user.page"
    And user verifies the lesson content
      | Title        | videoID  | lessonBody          |
      | lesson.title | video.id | lesson.body.content |
    
    # verifying assessment content and submission
    And user goes to assessment "assessment.correct.header" on course outline
    And store page url to "assessment.user.page"
    And user verifies MathJax type assessment content
      | Title                     | MathJax Question | Points            | Submission Type | Show Correct Answer | Due Date |
      | assessment.correct.header | test Question    | assessment.points | multiple        | No                  | future   |  
    And user answers mathjax question
    And user submits the assessment
    And user verifies the confirmation message "submit.confirmation.msg" for "assessment.correct.header"
    