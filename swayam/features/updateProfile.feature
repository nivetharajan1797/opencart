@UpdateProfile @regression @jenkins 
Feature: Update profile functionality 
	I want to validate update profile for all the roles

Background: 
	Given user launches the application 
	Then verifies that applilcation launched successfully 
	When user clicks on "Sign In" button from Homepage 
	Then verify user redirects to azure login page 
	When user login using local user as "profile.local.username" and "profile.local.password" 
	Then user redirects back to application 
	And user opens the user dropdown
	And user clicks on "MY COURSES" link from user dropdown
	And user clicks on SYNC YOUR COURSES button
	And user clicks on Go to Course button
	#And user clicks "MY PROFILE" link from userdropdown on node
	
@UpdateProfileOtherProfession
Scenario: Verify update profile for Other Profession 
	#When user clicks on "MY PROFILE" link from user dropdown
	When user clicks "MY PROFILE" link from userdropdown on node 
	Then user clicks on "Edit Profile" button 
	When user enters profile details for profession as other 
		|		Name | Mobile Number	|	Age Group	|	Country	|	Profession	|	Qualification	|	Graduation Year	|
		| profile.other.name | profile.other.mobile	|	profile.other.age	|	profile.country.india	|	profile.other.prof	|	profile.other.qual	|	profile.other.year	|
	Then user checks Honor Code checkbox and Swayam T&C 
	Then user clicks on "Update Profile" button 
	Then user validates below entered are updated for profession as other 
		|		Name | Mobile Number	|	Age Group	|	Country	|	Profession	|	Qualification	|	Graduation Year	|
		| profile.other.name | profile.other.mobile	|	profile.other.age	|	profile.country.india	|	profile.other.prof	|	profile.other.qual	|	profile.other.year	|
		
		
@UpdateProfileStudentProfession 
Scenario: Verify update profile for Student Profession 
	#When user clicks on "MY PROFILE" link from user dropdown 
	When user clicks "MY PROFILE" link from userdropdown on node
	Then user clicks on "Edit Profile" button 
	When user enters profile details for profession as Student 
		|		Name | Mobile Number	|	Age Group	|	Country	|	Profession	|	Qualification	|	Graduation Year	| LC Flag |	State	|	City	|	College	|	Roll Number	|	Degree	|	Department	|	Study Year	|
		| profile.stud.name | profile.stud.mobile	|	profile.stud.age	|	profile.stud.country	|	profile.stud.prof	|	profile.stud.qual	|	profile.stud.year	|	profile.stud.lcflag	|	profile.stud.State	|	profile.stud.city	|	profile.stud.college	|	profile.stud.rnum	|	profile.stud.degree	|	profile.stud.depart	|	profile.stud.stdyear	|	
	Then user checks Honor Code checkbox and Swayam T&C 
	Then user clicks on "Update Profile" button 
	Then user validates below entered are updated for profession as Student 
		|		Name | Mobile Number	|	Age Group	|	Country	|	Profession	|	Qualification	|	Graduation Year	| LC Flag |	State	|	City	|	College	|	Roll Number	|	Degree	|	Department	|	Study Year	|
		| profile.stud.name | profile.stud.mobile	|	profile.stud.age	|	profile.stud.country	|	profile.stud.prof	|	profile.stud.qual	|	profile.stud.year	|	profile.stud.lcflag	|	profile.stud.State	|	profile.stud.city	|	profile.stud.college	|	profile.stud.rnum	|	profile.stud.degree	|	profile.stud.depart	|	profile.stud.stdyear	|	
		
@UpdateProfileEmployedProfession 
Scenario: Verify update profile for Employed Profession 
	#When user clicks on "MY PROFILE" link from user dropdown 
	When user clicks "MY PROFILE" link from userdropdown on node
	Then user clicks on "Edit Profile" button 
	When user enters profile details for profession as Employed 
		|		Name | Mobile Number	|	Age Group	|	Country	|	Profession	|	Qualification	|	Graduation Year	| LC Flag | Industry Spoc |
		| profile.employed.name | profile.employed.mobile	|	profile.employed.age	|	profile.country.india	|	profile.employed.prof	|	profile.employed.qual	|	profile.employed.year	| profile.employed.lcflag | profile.employed.spoc |
	Then user checks Honor Code checkbox and Swayam T&C 
	Then user clicks on "Update Profile" button 
	Then user validates below entered are updated for profession as Employed 
		|		Name | Mobile Number	|	Age Group	|	Country	|	Profession	|	Qualification	|	Graduation Year	| LC Flag | Industry Spoc |
		| profile.employed.name | profile.employed.mobile	|	profile.employed.age	|	profile.country.india	|	profile.employed.prof	|	profile.employed.qual	|	profile.employed.year	| profile.employed.lcflag | profile.employed.spoc |
		
@UpdateProfileFacultyProfession 
Scenario: Verify update profile for Faculty Profession 
	#When user clicks on "MY PROFILE" link from user dropdown 
	When user clicks "MY PROFILE" link from userdropdown on node
	Then user clicks on "Edit Profile" button 
	When user enters profile details for profession as Faculty 
		|		Name | Mobile Number	|	Age Group	|	Country	|	Profession	|	Qualification	|	Graduation Year	| LC Flag |	State	|	City	|	College	|	Area	|	Department	|
		| profile.faculty.name | profile.faculty.mobile	|	profile.faculty.age	|	profile.country.india	|	profile.faculty.prof	|	profile.faculty.qual	|	profile.faculty.year	|	profile.faculty.lcflag	|	profile.faculty.State	|	profile.faculty.city	|	profile.faculty.college	|	profile.faculty.area	|	profile.faculty.depart	|	
	Then user checks Honor Code checkbox and Swayam T&C 
	Then user clicks on "Update Profile" button 
	Then user validates below entered are updated for profession as Faculty 
		|		Name | Mobile Number	|	Age Group	|	Country	|	Profession	|	Qualification	|	Graduation Year	| LC Flag |	State	|	City	|	College	|	Area	|	Department	|
		| profile.faculty.name | profile.faculty.mobile	|	profile.faculty.age	|	profile.country.india	|	profile.faculty.prof	|	profile.faculty.qual	|	profile.faculty.year	|	profile.faculty.lcflag	|	profile.faculty.State	|	profile.faculty.city	|	profile.faculty.college	|	profile.faculty.area	|	profile.faculty.depart	|	
		
		
#@CheckBoxValidation 
#Scenario: Verify checkbox validation for terms and honor code 
#	#When user clicks on "MY PROFILE" link from user dropdown 
#	When user clicks "MY PROFILE" link from userdropdown on node
#	Then user clicks on "Edit Profile" button 
#	And user validate the error message "warning.message" for both the checkboxes 
#	And user verifies the checkboex fields have required attribute for validation 
#	Then  user clicks on "Terms of Service" Link 
#	And verifies the text on terms of use pop up 
#	Then  user clicks on "Honor Code" Link 
#	And verifies the text on honor code pop up 
	
	