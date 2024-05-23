@InstructorAdmin 
Feature: InstructorAdmin 
	I want to test instructor admin creation from central and using it on course seeting at node  
  
Background: 
	Given user launches the application 
	
@InstructorAdmin 
Scenario: Verify NC creation on Central 
	When user navigates to node as "central" 
	When user clicks on "Sign In" button from Homepage 
	Then verify user redirects to azure login page 
	When user login using local user as "admin.local.username" and "admin.local.password" 
	Then user redirects back to application 
	And user opens the user dropdown 
	And user verifies the "DASHBOARD" link on header 
	And user goes to "DASHBOARD" page from user dropdown 
	Then user verifies the admin site page 
	And user open the Instructor page 
	And user verifies the instructor page 
	And user clicks on "Add Instructor" Link 
	And user verifies Add instructor page 
	And user stores instructor id as "instructor.id" 
	And user creates an intructor 
		|name|college|photoURL|bio|email|
		|instructor.name|instructor.college|instructor.photo|instructor.bio|instructor.email|
	And user clicks on "Add New Instructor" link 
	And user verifies the instructor page 
	And user clicks on instructor with id as "instructor.id" 
	And user verifies the instructor details 
		|name|college|photoURL|bio|email|
		|instructor.name|instructor.college|instructor.photo|instructor.bio|instructor.email|
	And user clears the browser cache 
	When user navigates to node as "firstNode" 
	Then verify user redirects to azure login page 
	When user login using local user as "admin.local.username" and "admin.local.password" 
	And user navigates to admin dashboard homepage 
	And user open the Instructor page on node 
	And user clicks on "Update Instructors from Central" link 
	And user clicks on instructor with id as "instructor.id" 
	And user verifies the instructor details 
		|name|college|photoURL|bio|email|
		|instructor.name|instructor.college|instructor.photo|instructor.bio|instructor.email|
	And user goes to admin homepage 
	And user clicks on the course "Course for testing" on admin side 
	When user goes to course settings 
	And user enters the instructor with "instructor.id" and name as "instructor.name" 
	And user verifies the populated instructor details 
		|name|college|photoURL|bio|
		|instructor.name|instructor.college|instructor.photo|instructor.bio|
		
		
		
		
		
		
		
		
		
    