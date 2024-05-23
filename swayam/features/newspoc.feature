@SpocFlowNew @regression
Feature: SPOCnew 
	I want to verify Spoc creation, Spoc Selection,Spoc dashboard view

Background: 
	Given user launches the application 
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
	And user clicks on "Logout" Link 
	
@SpocFlowGeneral @jenkins 
Scenario: Verify LC flow for an Indian LC 
	#When user navigates to node as "central" 
	When user navigates to node as "firstNode"
	#When user clicks on "Sign In" button from Homepage 
	Then verify user redirects to azure login page 
	When user login using local user as "admin.local.username" and "admin.local.password" 
	#Then user redirects back to application 
	#And user opens the user dropdown 
	#And user verifies the "DASHBOARD" link on header 
	#And user goes to "DASHBOARD" page from user dropdown 
	And user opens the LC page 
	Then user verifies the Local Chapter Page 
	And user removes the existing local chapter with "lc.ind.code" code 
	Then user verifies the Local Chapter Page 
	And user clicks on "Add Local Chapter" link 
	And user fills the Local Chapter fields 
		| code        | name        | city        | country        | state        | org_type    | spoc_email   |
		| lc.ind.code | lc.ind.name | lc.ind.city | lc.ind.country | lc.ind.state | lc.ind.type | lc.ind.email |
	#And user clicks on "Add New Local Chapter" link
	And user clicks on "Add Local Chapter" link 
	Then user verifies the Local Chapter Page 
	And user clicks on "lc.ind.code" link by property 
	And user verifies added local chapter values 
		| code        | name        | city        | country        | state        | org_type    | spoc_email   |
		| lc.ind.code | lc.ind.name | lc.ind.city | lc.ind.country | lc.ind.state | lc.ind.type | lc.ind.email |
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
	And user select the indian LC on update Profile Page as Faculty
	
#	When user clicks "MY PROFILE" link from userdropdown on node
#	Then user clicks on "Edit Profile" button 
#	When user enters profile details for profession as Faculty 
#		|		Name 							 | Mobile Number					|	Age Group						|	Country					|	Profession						|	Qualification					|	Graduation Year				| LC Flag 								|	State					|	City				|	College			|	Area									|	Department							|
#		| profile.faculty.name | profile.faculty.mobile	|	profile.faculty.age	|	lc.ind.country	|	profile.faculty.prof	|	profile.faculty.qual	|	profile.faculty.year	|	profile.faculty.lcflag	|	lc.ind.state	|	lc.ind.city	|	lc.ind.name	|	profile.faculty.area	|	profile.faculty.depart	|	
#	Then user checks Honor Code checkbox and Swayam T&C 
#	Then user clicks on "Update Profile" button 
#	Then user validates below entered are updated for profession as Faculty 
#		|		Name 							 | Mobile Number					|	Age Group						|	Country					|	Profession						|	Qualification					|	Graduation Year				| LC Flag 								|	State					|	City				|	College			|	Area									|	Department							|
#		| profile.faculty.name | profile.faculty.mobile	|	profile.faculty.age	|	lc.ind.country	|	profile.faculty.prof	|	profile.faculty.qual	|	profile.faculty.year	|	profile.faculty.lcflag	|	lc.ind.state	|	lc.ind.city	|	lc.ind.name	|	profile.faculty.area	|	profile.faculty.depart	|	
	
	And user logout from user side 
	When user navigates to node as "central" 
	When user clicks on "Sign In" button from Homepage 
	Then verify user redirects to azure login page 
	When user login using local user as "local.spoc.adminuser" and "local.spoc.adminpassword" 
	Then user redirects back to application 
	And user opens the user dropdown 
  And user clicks on "MY COURSES" link from user dropdown
	And user clicks on SYNC YOUR COURSES button
	And user clicks on Go to Course button
  #When user clicks "SPOC COURSE DASHBOARD" link from userdropdown on node
  When user clicks "SPOC ADMIN" link from userdropdown on node
	#And user verifies the "SPOC ADMIN" link on header 
	#And user clicks on "SPOC ADMIN" link from user dropdown 
	And user verifies spoc admin view 
	And user clicks on namespace link for "course.name" 
	And user verifies user on the list for Enrolled Members for "learner.username" 
#	And user goes back to previous page 
#	And user goes to All Local Chapter Members page 
#	And user verifies course "learner.username" for the user "course.name" under course list 
	
	
@SpocFloweVBAB 
Scenario: Verify LC flow for a Non-Indian LC 
	#When user navigates to node as "central"
	When user navigates to node as "firstNode" 
	#When user clicks on "Sign In" button from Homepage 
	Then verify user redirects to azure login page 
	When user login using local user as "admin.local.username" and "admin.local.password" 
#	Then user redirects back to application 
#	And user opens the user dropdown 
#	And user verifies the "DASHBOARD" link on header 
#	And user goes to "DASHBOARD" page from user dropdown 
	And user opens the LC page 
	Then user verifies the Local Chapter Page 
	And user removes the existing local chapter with "lc.int.code" code 
	Then user verifies the Local Chapter Page 
	And user clicks on "Add Local Chapter" link 
	And user fills the Local Chapter fields 
		| code        | name        | city        | country        | state        | org_type    | spoc_email   |
		| lc.int.code | lc.int.name | lc.int.city | lc.int.country | lc.int.state | lc.int.type | lc.int.email |
	#And user clicks on "Add New Local Chapter" link 
	And user clicks on "Add Local Chapter" link
	Then user verifies the Local Chapter Page 
	And user clicks on "lc.int.code" link by property 
	And user verifies added local chapter values 
		| code        | name        | city        | country        | state        | org_type    | spoc_email   |
		| lc.int.code | lc.int.name | lc.int.city | lc.int.country | lc.int.state | lc.int.type | lc.int.email |
	And user clicks on "Logout" Link 
	When user navigates to node as "central" 
	When user clicks on "Sign In" button from Homepage 
	Then verify user redirects to azure login page 
	When user login using local user as "learner.local.username" and "learner.local.password" 
	Then user redirects back to application 
	When user hovers on course catalog 
	And user select "All" category from the list 
	When user searches for "course.name" 
	Then user verifies the search results for "course.name" 
	And user clicks on the course "course.name" 
	And user joins the course 
        And user choose to edit the profile before joining 
	And user select the LC on update Profile Page as Faculty 
	And user logout from user side 
	When user navigates to node as "central" 
	When user clicks on "Sign In" button from Homepage 
	Then verify user redirects to azure login page 
	When user login using local user as "spoc.local.username" and "spoc.local.password" 
	Then user redirects back to application 
	And user opens the user dropdown
	And user clicks on "MY COURSES" link from user dropdown
	And user clicks on SYNC YOUR COURSES button
	And user clicks on Go to Course button
	And user opens the user dropdown on node
  #When user clicks "SPOC COURSE DASHBOARD" link from userdropdown on node 
  And user verifies the "SPOC ADMIN" link on header 
  And user clicks on "SPOC ADMIN" link from user dropdown 
	And user verifies spoc admin view 
	And user clicks on namespace link for "course.name" 
	And user verifies user on the list for Enrolled Members for "learner.local.email" 
#	And user goes back to previous page 
#	And user goes to All Local Chapter Members page 
#	And user verifies course "learner.local.email" for the user "course.name" under course list 
	
@IndustrySpoc @jenkins 
Scenario: Verify LC flow for a Industry Spoc 
	#When user navigates to node as "central" 
	When user navigates to node as "firstNode"
	#When user clicks on "Sign In" button from Homepage 
	Then verify user redirects to azure login page 
	When user login using local user as "admin.local.username" and "admin.local.password" 
	#Then user redirects back to application 
	#And user opens the user dropdown 
	#And user verifies the "DASHBOARD" link on header 
	#And user goes to "DASHBOARD" page from user dropdown 
	And user opens the LC page 
	Then user verifies the Local Chapter Page 
	And user removes the existing local chapter with "lc.indus.code" code 
	Then user verifies the Local Chapter Page 
	And user clicks on "Add Local Chapter" link 
	And user fills the Local Chapter fields 
		| code        | name        | city        | country        | state        | org_type    | spoc_email   |
		| lc.indus.code | lc.indus.name | lc.indus.city | lc.indus.country | lc.indus.state | lc.indus.type | lc.indus.email |
	#And user clicks on "Add New Local Chapter" link 
	And user clicks on "Add Local Chapter" link
	Then user verifies the Local Chapter Page 
	And user clicks on "lc.indus.code" link by property 
	And user verifies added local chapter values 
		| code        | name        | city        | country        | state        | org_type    | spoc_email   |
		| lc.indus.code | lc.indus.name | lc.indus.city | lc.indus.country | lc.indus.state | lc.indus.type | lc.indus.email |
	And user clicks on "Logout" Link 
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
	And user select the industry LC on update Profile Page 
	And user logout from user side 
	When user navigates to node as "central" 
	When user clicks on "Sign In" button from Homepage 
	Then verify user redirects to azure login page 
	When user login using local user as "spoc.indus.username" and "spoc.indus.password" 
	Then user redirects back to application 
	And user opens the user dropdown 
	And user clicks on "MY COURSES" link from user dropdown
	And user clicks on SYNC YOUR COURSES button
	And user clicks on Go to Course button
  #When user clicks "SPOC COURSE DASHBOARD" link from userdropdown on node
  And user opens the user dropdown on node
	And user verifies the "SPOC ADMIN" link on header 
	And user clicks on "SPOC ADMIN" link from user dropdown 
	And user verifies spoc admin view for industry spoc
	And user clicks on industry namespace link for "course.name" 
	And user verifies user on the list for Enrolled Members for "learner.emp.email" 
#	And user goes back to previous page 
#	And user goes to All Local Chapter Members page 
#	And user verifies course "learner.emp.email" for the user "course.name" under course list 