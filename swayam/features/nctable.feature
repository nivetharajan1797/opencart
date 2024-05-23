@NCtable @regression @jenkins 
Feature: NC table creation 
	I want to create NCs from central and verify them at nodes

Background: 
	Given user launches the application 
	
@NCtable 
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
	When user selects national coorinator option from left nav 
	Then user verifies the national coorinator page 
	And user removes the existing NC with "AICTE" code 
	And user clicks on "Add National Coordinator" Link 
	When user adds basic fields national coorinator with following details 
		| code  | name    | shortName | description    | URL                 | logo    | adminEmail     | supportEmail    | address    | phoneNumber  |
		| AICTE | nc.name | AICTE     | nc.description | www.aicte-india.org | nc.logo | admin@test.com | spport@test.com | nc.address | 040-23341036 |
	When user adds dashboard fields national coorinator with following details 
		| institutesEngaged | completedCourses | studentsEnrolled | examRegistrations | Certifications |
		|               234 |              254 |              300 |               200 |             50 |
	When user adds ongoing fields national coorinator with following details 
		| courses | studentEnrollment | examRegistrations |
		|      30 |                40 |                50 |
	And user clicks on "Add New National Coordinator" Link 
	And user clicks on "AICTE" Link 
	And user verifies NC details entered 
		| code  | name    | shortName | description    | URL                 | logo    | adminEmail     | supportEmail    | address    | phoneNumber  |
		| AICTE | nc.name | AICTE     | nc.description | www.aicte-india.org | nc.logo | admin@test.com | spport@test.com | nc.address | 040-23341036 |
	When user navigates to node as "central" 
	And user clicks on "National Coordinators" Link 
	And user verifies NC card on National Coordinators with following details 
		| name    | shortName | logo    |
		| nc.name | AICTE    | nc.logo |
	And user goes to NC detail page by short name "AICTE" 
	And user verifies following values on NC details page 
		| name    | shortName | logo    | description    | URL                 | adminEmail     | supportEmail    | address    | phoneNumber  |
		| nc.name | AICTE     | nc.logo | nc.description | www.aicte-india.org | admin@test.com | spport@test.com | nc.address | 040-23341036 |
	And user verifies dashboard fields national coorinator with following details 
		| institutesEngaged | completedCourses | studentsEnrolled | examRegistrations | Certifications |
		|               234 |              254 |              300 |               200 |             50 |
	And user verifies ongoing fields national coorinator with following details 
		| courses | studentEnrollment | examRegistrations |
		|      30 |                40 |                50 |
	And user clicks on "View Course Catalog" link 
	And user verifies course catalog page redirection 
	And user verifies that National Coordinators filter set with value as "AICTE" 
