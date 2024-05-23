#Author: Sagar Wankhede
#Keywords Summary :
Feature: Update profile functionality 
	I want to validate update profile 

Background: 
	Given user launches the application 
	Then verifies that applilcation launched successfully 
	When user clicks on "Sign In" button from Homepage 
	Then verify user redirects to azure login page 
	When user login using local user as "learner.local.username" and "learner.local.password" 
	Then user redirects back to application 
	And user opens the user dropdown 
	
	
	
	#	@UpdateStudentProfileOtherProfession
	#	Scenario: Verify update profile change in LC for indian student 
	#		When user clicks on "MY PROFILE" link from user dropdown
	#		Then user clicks on "Edit Profile" button
	#		When user enters profile details for profession as other
	#	|		Name | Mobile Number	|	Age Group	|	Country	|	Profession	|	Qualification	|	Graduation Year	|
	#			| profile.other.name | profile.other.mobile	|	profile.other.age	|	profile.country.india	|	profile.other.prof	|	profile.other.qual	|	profile.other.year	|
	#		Then user checks Honor Code checkbox and Swayam T&C
	#		Then user clicks on "Update Profile" button
	#		
	#		Then user validates below entered are updated for profession as other
	#	|		Name | Mobile Number	|	Age Group	|	Country	|	Profession	|	Qualification	|	Graduation Year	|
	#			| profile.other.name | profile.other.mobile	|	profile.other.age	|	profile.country.india	|	profile.other.prof	|	profile.other.qual	|	profile.other.year	|
	#
	
@NoUpdateProfileStudentProfession 
Scenario: Verify update profile change in LC for indian student 
	When user clicks on "MY PROFILE" link from user dropdown 
	Then user clicks on "Edit Profile" button 
	When user enters profile details for profession as Student 
		|		Name | Mobile Number	|	Age Group	|	Country	|	Profession	|	Qualification	|	Graduation Year	| LC Flag |	State	|	City	|	College	|	Roll Number	|	Degree	|	Department	|	Study Year	|
		| profile.stud.name | profile.stud.mobile	|	profile.stud.age	|	profile.stud.country	|	profile.stud.prof	|	profile.stud.qual	|	profile.stud.year	|	profile.stud.lcflag	|	profile.stud.State	|	profile.stud.city	|	profile.stud.college	|	profile.stud.rnum	|	profile.stud.degree	|	profile.stud.depart	|	profile.stud.stdyear	|	
	Then user checks Honor Code checkbox and Swayam T&C 
	Then user clicks on "Update Profile" button 
	
	Then user validates below entered are updated for profession as Student 
		|		Name | Mobile Number	|	Age Group	|	Country	|	Profession	|	Qualification	|	Graduation Year	| LC Flag |	State	|	City	|	College	|	Roll Number	|	Degree	|	Department	|	Study Year	|
		| profile.stud.name | profile.stud.mobile	|	profile.stud.age	|	profile.stud.country	|	profile.stud.prof	|	profile.stud.qual	|	profile.stud.year	|	profile.stud.lcflag	|	profile.stud.State	|	profile.stud.city	|	profile.stud.college	|	profile.stud.rnum	|	profile.stud.degree	|	profile.stud.depart	|	profile.stud.stdyear	|	
	