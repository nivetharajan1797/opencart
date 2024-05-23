@MSQTestAllorNothing @regression
Feature: Questions - MSQ - All or Nothing Tests
  I want to test MSQ questions without allowed partial marking. Student should be able to submit MSQ and view scores.

  Background: 
   Given user launches the application
    Then verifies that applilcation launched successfully
    When user navigates to node as "firstNode"
    Then verify user redirects to azure login page
   	When user login using local user as "admin.local.username" and "admin.local.password" 
 

  
  Scenario: Verify addition of MSQ assessment with All or Nothing, student attempting assessment and verifing scores.
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
  
    When user clicks on Questions link to add questions
    And user clicks on Add Multiple Choice button
    And user adds MSQ question to the assessment
      | questionname     | choice 1 | choice 2 | choice 3 | choice 4 | choice 5 | description 		| Answers		   | All or Nothing|
      | msq.q2.description | msq.q1.c1| msq.q1.c2|msq.q1.c3 |msq.q1.c4 |msq.q1.c5 | msq.q2.description| msq.q1.answers | Yes 		   |
    And user clicks on "Save" Link
    And user waits for "Saved" confirmation
    And user clicks on "Close" Link
    
    #autograded assessment creation
    When user goes to course outine
	And user clicks on "Add Unit" button
    When user creates a unit as "unit.name"
    And user clicks on "Save" Link
    And user waits for "Saved" confirmation
    And user clicks on "Close" Link
    
    When user clicks on "assessment" link under unit "Week 1"
    And user enter following required details on assessment page
      | Title                | Points | Show Correct Answer | Single Submission | Due Date |
      | msq.q2.description	 |      5 | No                  | No                | future   |
    And store page url to "assessment.admin.page"
    And user navigates to Select Existing tab
    And admin selects existing question from dropdown
    	| Assessment Name		|
    	| msq.q2.description 	|
    #And user scrolls down for Close button
    And user scrolls down for Save button 
    And user clicks on "Save" Link
    And user waits for "Saved" confirmation
    And user clicks on "Close" Link
   
    #changing availability

    And user goes to course availaibity
    And user waits for "OK" confirmation
    And user set "unit.name" availability to "Course"
    And user set "msq.q2.description" availability to "Course"
    And user clicks on "Save" Link
    And user waits for "Saved" confirmation
    And user clicks on "Logout" Link
    And user clears the browser cache
    
    # Login as first student and verify
    
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
    
    
    # verifying assessment content and submission
    
    And user goes to assessment "msq.q2.description" on course outline
    And store page url to "assessment.user.page"
   	And user verifies the assessment content
      | Title              | Question         	| Options        | Due Date        | Points            | Submission Type | Show Correct Answer |
      | msq.q2.description | msq.q2.description | msq.q1.options | assessment.date | assessment.points | multiple        | No                  |
    And user chooses "FIRST" option
    And user chooses "SECOND" option
    And user chooses "FIFTH" option
    And user submits the assessment
    And user verifies the confirmation message "submit.confirmation.msg" for "msq.q2.description"
    And user logout from user side
    And user clears the browser cache
    
    #Login as second student and verify
    
    When user navigates to node as "central"
    When user clicks on "Sign In" button from Homepage
    Then verify user redirects to azure login page
    When user login using local user as "spoc.local.username" and "spoc.local.password" 
    Then user redirects back to application
    When user hovers on course catalog
    And user select "All" category from the list
    When user searches for "course.name"
    Then user verifies the search results for "course.name"
    And user clicks on the course "course.name"
    And user joins the course
    And user choose to edit the profile before joining
    And user select the indian LC on update Profile Page
    
     #verifying assessment content and submission
    
    And user goes to assessment "msq.q2.description" on course outline
    And store page url to "assessment.user.page"
   	And user verifies the assessment content
      | Title              | Question         	| Options        | Due Date        | Points            | Submission Type | Show Correct Answer |
      | msq.q2.description | msq.q2.description | msq.q1.options | assessment.date | assessment.points | multiple        | No                  |
    And user chooses "FIRST" option
    And user chooses "FIFTH" option
    And user submits the assessment
    And user verifies the confirmation message "submit.confirmation.msg" for "msq.q2.description"
    And user logout from user side
    And user clears the browser cache
    
    #Login as Third student and verify without submitting the assignment
    
    When user navigates to node as "central"
    When user clicks on "Sign In" button from Homepage
    Then verify user redirects to azure login page
    When user login using local user as "spoc.indus.username" and "spoc.indus.password" 
    Then user redirects back to application
    When user hovers on course catalog
    And user select "All" category from the list
    When user searches for "course.name"
    Then user verifies the search results for "course.name"
    And user clicks on the course "course.name"
    And user joins the course
    And user choose to edit the profile before joining
    And user select the indian LC on update Profile Page
    
     #verifying assessment content and submission
  	And user goes to assessment "msq.q2.description" on course outline
    And store page url to "assessment.user.page"
   	And user verifies the assessment content
      | Title              | Question         	| Options        | Due Date        | Points            | Submission Type | Show Correct Answer |
      | msq.q2.description | msq.q2.description | msq.q1.options | assessment.date | assessment.points | multiple        | No                  |
    And user chooses "FIRST" option
    And user chooses "SECOND" option
    And user chooses "THIRD" option
    And user chooses "FIFTH" option
    And user submits the assessment
    And user verifies the confirmation message "submit.confirmation.msg" for "msq.q2.description"
    And user logout from user side
    And user clears the browser cache
    
  
  #Login as Forth student and verify incorrect submission
    
    When user navigates to node as "central"
    When user clicks on "Sign In" button from Homepage
    Then verify user redirects to azure login page
    When user login using local user as "profile.local.username" and "profile.local.password" 
    Then user redirects back to application
    When user hovers on course catalog
    And user select "All" category from the list
    When user searches for "course.name"
    Then user verifies the search results for "course.name"
    And user clicks on the course "course.name"
    And user joins the course
    And user choose to edit the profile before joining
    And user select the indian LC on update Profile Page
    
     #verifying assessment content and submission
  	And user goes to assessment "msq.q2.description" on course outline
    And store page url to "assessment.user.page"
   	And user verifies the assessment content
      | Title              | Question         	| Options        | Due Date        | Points            | Submission Type | Show Correct Answer |
      | msq.q2.description | msq.q2.description | msq.q1.options | assessment.date | assessment.points | multiple        | No                  |
    And user chooses "THIRD" option
    And user chooses "FOURTH" option
    And user submits the assessment
    And user verifies the confirmation message "submit.confirmation.msg" for "msq.q2.description"
    And user logout from user side
    And user clears the browser cache
 
     
    # Login to node as SuperAdmin and change assessment due date to past date
    
    When user navigates to node as "firstNode"
    Then verify user redirects to azure login page
    When user login using local user as "admin.local.username" and "admin.local.password"
    And user clicks on add course button
    And user navigates to node as "assessment.admin.page"
    And user set the assessment due date to "past"
    And user clicks on "Save" Link
    And user waits for "Saved" confirmation
    And user clicks on "Logout" Link
    And user clears the browser cache
    	    
    #Login as first student and verify
    
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
    And user navigates to node as "assessment.user.page"
    And user goes to assessment "msq.q2.description" on course outline
    And user verifies the assessment due date "assessment.date"
    And user verified the due date passed message "duedate.passed.text"
    And user verifies the assessment result as "assessment.result.correct"
    And user clicks on "Progress" Link
    And user verifies the score on progress page
      | entityname         | score |
      | msq.q2.description |  100.0 |
    And user logout from user side
    And user clears the browser cache
    
    #Login as second student and verify
    
    When user navigates to node as "central"
    When user clicks on "Sign In" button from Homepage
    Then verify user redirects to azure login page
    When user login using local user as "spoc.local.username" and "spoc.local.password" 
    Then user redirects back to application
    When user hovers on course catalog
    And user select "All" category from the list
    When user searches for "course.name"
    Then user verifies the search results for "course.name"
    And user clicks on the course "course.name"
    And user clicks on "Go to course" button
    And user navigates to node as "assessment.user.page"
    And user goes to assessment "msq.q2.description" on course outline
    And user verifies the assessment due date "assessment.date"
    And user verified the due date passed message "duedate.passed.text"
    And user verifies the assessment result as "assessment.result.incorrect"
    And user clicks on "Progress" Link
    And user verifies the score on progress page
      | entityname         | score |
      | msq.q2.description |  0.0 |
    And user logout from user side
    And user clears the browser cache
    
    #Login as Third student and verify results
    
    When user navigates to node as "central"
    When user clicks on "Sign In" button from Homepage
    Then verify user redirects to azure login page
    When user login using local user as "spoc.indus.username" and "spoc.indus.password" 
    Then user redirects back to application
    When user hovers on course catalog
    And user select "All" category from the list
    When user searches for "course.name"
    Then user verifies the search results for "course.name"
    And user clicks on the course "course.name"
    And user clicks on "Go to course" button
    And user navigates to node as "assessment.user.page"
    And user goes to assessment "msq.q2.description" on course outline
    And user verifies the assessment due date "assessment.date"
    And user verified the due date passed message "duedate.passed.text"
    And user verifies the assessment result as "assessment.result.incorrect"
        And user clicks on "Progress" Link
    And user verifies the score on progress page
      | entityname         | score |
      | msq.q2.description |  0.0 |
    And user logout from user side
    And user clears the browser cache
    
    
   #Login as fourth student and verify
    
    When user navigates to node as "central"
    When user clicks on "Sign In" button from Homepage
    Then verify user redirects to azure login page
    When user login using local user as "profile.local.username" and "profile.local.password" 
    Then user redirects back to application
    When user hovers on course catalog
    And user select "All" category from the list
    When user searches for "course.name"
    Then user verifies the search results for "course.name"
    And user clicks on the course "course.name"
    And user clicks on "Go to course" button
    And user navigates to node as "assessment.user.page"
    And user goes to assessment "msq.q2.description" on course outline
    And user verifies the assessment due date "assessment.date"
    And user verified the due date passed message "duedate.passed.text"
    And user verifies the assessment result as "assessment.result.incorrect"
        And user clicks on "Progress" Link
    And user verifies the score on progress page
      | entityname         | score|
      | msq.q2.description |  0.0 |
    And user logout from user side
    And user clears the browser cache
   
    
  Scenario: Admin closes course
     When user navigates to node as "assessment.admin.page"
	Then user goes to course availaibity
    And user waits for "OK" confirmation
    And user checks "Course Closed" checkbox
    And user clicks on "Save" Link
    And user verifies the "saved" message for confirmation
 
     