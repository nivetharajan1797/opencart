#Author: vaibhav_choudhary@persistent.com
#Keywords Summary :
@login @jenkins
Feature: Login feature 
	I want to test login feature as Admin, Spoc and Learner

Background: 
	Given user launches the application 
	Then verifies that applilcation launched successfully 
	
#@AdminLogin 
#Scenario: Verify login with admin user 
#	When user clicks on "Sign In" button from Homepage 
#	Then verify user redirects to azure login page 
#	When user login using "admin.username" and "admin.password" 
#	Then user redirects back to application 
#	And user opens the user dropdown 
#	And user verifies the "DASHBOARD" link on header 
	
@AdminLogin
Scenario: Verify login with admin user 
	When user clicks on "Sign In" button from Homepage 
	Then verify user redirects to azure login page 
	When user login using local user as "admin.local.username" and "admin.local.password" 
	Then user redirects back to application 
	And user opens the user dropdown 
	And user verifies the "DASHBOARD" link on header 
	
@LearnerLogin 
Scenario: Verify login with learner user 
	When user clicks on "Sign In" button from Homepage 
	Then verify user redirects to azure login page 
	When user login using local user as "local.learner.username" and "local.learner.password" 
	#When user login using "learner.username" and "learner.password" 
	Then user redirects back to application 
	And user opens the user dropdown 
	And user verifies the "DASHBOARD" link is not present on header 
	
#@SpocLogin 
#Scenario: Verify login with Spoc user 
#	When user clicks on "Sign In" button from Homepage 
#	Then verify user redirects to azure login page 
#	When user login using local user as "local.spoc.adminuser" and "local.spoc.adminpassword" 
#	#When user login using "spoc.username" and "spoc.password" 
#	Then user redirects back to application 
#	And user opens the user dropdown 
#	And user verifies the "SPOC ADMIN" link on header 
#	
#@Login-Local 
#Scenario: Verify login with local spoc user 
#	When user clicks on "Sign In" button from Homepage 
#	Then verify user redirects to azure login page 
#	When user login using local user as "spoc.local.username" and "spoc.local.password" 
#	Then user redirects back to application 
#	And user opens the user dropdown 
#	And user verifies the "SPOC ADMIN" link on header 
