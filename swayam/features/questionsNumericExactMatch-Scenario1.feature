@questionsNumericExactMatchType @regression_set2 
Feature: Questions - Numeric - Exact match Type - scenario 1
	I want to test questions with Numeric exact match type. Student will submit assessment answers.

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
	
@QuestionNumericType 
Scenario: Verify creation of numeric assessment with exact value, student submission and scores 
	When user clicks on "Add Unit" button 
	When user creates a unit as "unit.name" 
	And user clicks on "Save" Link 
	And user waits for "Saved" confirmation 
	And user clicks on "Close" Link 
	
	#autograded assessment creation
	
	When user clicks on "assessment" link under unit "Week 1" 
	And user enter following required details on assessment page 
		| Title                     	| Points | Show Correct Answer | Single Submission | Due Date |
		| assessment.numeric.desc1	|      5 | No                  | No                | future   |
	And store page url to "assessment.admin.page" 
	And user navigates to Create Numeric Answer tab 
	Then user adds numeric exact match question 
		| Question						|	Answer						|	Description					|
		| assessment.numeric.question1	|	assessment.numeric.answer1	|	assessment.numeric.desc1	|
	And user clicks on "Save" Link 
	
	And user scrolls down for Save button 
	And user clicks on "Save" Link 
	And user waits for "Saved" confirmation 
	And user clicks on "Close" Link 
	
	#changing availability
	And user goes to course availaibity 
	And user waits for "OK" confirmation 
	And user set "unit.name" availability to "Course" 
	And user set "assessment.numeric.desc1" availability to "Course" 
	And user clicks on "Save" Link 
	And user waits for "Saved" confirmation 
	And user clicks on "Logout" Link 
	And user clears the browser cache 
	
	# Login as a first student and attempt assessment
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
	#verifying assessment content and submission
	And user goes to assessment "assessment.numeric.desc1" on course outline 
	And store page url to "assessment.user.page" 
	And user attempts numeric type question 
		|	Answer						|
		| assessment.numeric.answer1	|
	And user submits the assessment 
	And user verifies the confirmation message "submit.confirmation.msg" for "assessment.numeric.desc1" 
	And user logout from user side 
	And user clears the browser cache 
	
	# Login as a second student and attempt assessment
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
	And user goes to assessment "assessment.numeric.desc1" on course outline 
	And store page url to "assessment.user.page" 
	And user attempts numeric type question 
		|	Answer						|
		| assessment.numeric.answer1-2	|
	And user submits the assessment 
	And user verifies the confirmation message "submit.confirmation.msg" for "assessment.numeric.desc1" 
	And user logout from user side 
	And user clears the browser cache 
	
	# Login as a third student and attempt assessment
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
	And user goes to assessment "assessment.numeric.desc1" on course outline 
	And store page url to "assessment.user.page" 
	And user attempts numeric type question 
		|	Answer						|
		| assessment.numeric.answer1-3	|
	And user submits the assessment 
	And user verifies the confirmation message "submit.confirmation.msg" for "assessment.numeric.desc1" 
	And user logout from user side 
	And user clears the browser cache 
	
	
	# Login as a forth student and attempt assessment
	When user navigates to node as "central" 
	When user clicks on "Sign In" button from Homepage 
	Then verify user redirects to azure login page 
	When user login using local user as "learner.emp.username" and "learner.emp.password" 
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
	And user goes to assessment "assessment.numeric.desc1" on course outline 
	And store page url to "assessment.user.page" 
	And user attempts numeric type question 
		|	Answer						|
		| assessment.numeric.answer1-4	|
	And user submits the assessment 
	And user verifies the confirmation message "submit.confirmation.msg" for "assessment.numeric.desc1" 
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
	When user navigates to node as "central" 
	When user clicks on "Sign In" button from Homepage 
	
	And user logout from user side 
	And user clears the browser cache 
	
	#Login as first student and verify submission results
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
	And user goes to assessment "assessment.numeric.desc1" on course outline 
	And user verifies the assessment due date "assessment.date" 
	And user verified the due date passed message "duedate.passed.text" 
	And user verifies the assessment result as "assessment.result.correct" 
	And user clicks on "Progress" Link 
	And user verifies the score on progress page 
		| entityname                	| score |
		| assessment.numeric.desc1	| 100.0 |
	And user logout from user side 
	And user clears the browser cache 
	
	#Login as second student and verify submission results
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
	And user goes to assessment "assessment.numeric.desc1" on course outline 
	And user verifies the assessment due date "assessment.date" 
	And user verified the due date passed message "duedate.passed.text" 
	And user verifies the assessment result as "assessment.result.correct" 
	And user clicks on "Progress" Link 
	And user verifies the score on progress page 
		| entityname                	| score |
		| assessment.numeric.desc1	| 100.0 |
	And user logout from user side 
	And user clears the browser cache 
	
	#Login as third student and verify submission results
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
	And user goes to assessment "assessment.numeric.desc1" on course outline 
	And user verifies the assessment due date "assessment.date" 
	And user verified the due date passed message "duedate.passed.text" 
	And user verifies the assessment result as "assessment.result.correct" 
	And user clicks on "Progress" Link 
	And user verifies the score on progress page 
		| entityname                	| score |
		| assessment.numeric.desc1	| 100.0 |
	And user logout from user side 
	And user clears the browser cache 
	
	#Login as forth student and verify submission results
	When user navigates to node as "central" 
	When user clicks on "Sign In" button from Homepage 
	Then verify user redirects to azure login page 
	When user login using local user as "learner.emp.username" and "learner.emp.password" 
	Then user redirects back to application 
	When user hovers on course catalog 
	And user select "All" category from the list 
	When user searches for "course.name" 
	Then user verifies the search results for "course.name" 
	And user clicks on the course "course.name" 
	And user clicks on "Go to course" button 
	And user navigates to node as "assessment.user.page" 
	And user goes to assessment "assessment.numeric.desc1" on course outline 
	And user verifies the assessment due date "assessment.date" 
	And user verified the due date passed message "duedate.passed.text" 
	And user verifies the assessment result as "assessment.result.incorrect" 
	And user clicks on "Progress" Link 
	And user verifies the score on progress page 
		| entityname                	| score |
		| assessment.numeric.desc1		| 0.0 	| 
	And user logout from user side 
	And user clears the browser cache 