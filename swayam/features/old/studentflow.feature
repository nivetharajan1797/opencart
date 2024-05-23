#Author: vaibhav_choudhary@persistent.com
#Keywords Summary :studentflow, coursejoining
@studentflow
Feature: student flow feature
  I want to test student login, course search and profile completion and course joining 
  
  Background: 
    Given user launches the application
    Then verifies that applilcation launched successfully

  @CourseJoining
  Scenario: Verify student flow-login,course search, Student Profile and  course joining
    When user clicks on "Sign In" button from Homepage
    And verify user redirects to azure login page
    When user login using local user as "prod.username" and "prod.password"
    And user redirects back to application
    And user hovers on course catalog
    And user select "All" category from the list
    When user searches for "prod.coursename"
    Then user verifies the search results for "prod.coursename"
    And user clicks on the course "prod.coursename" 
    And user joins the course
    And user select the indian LC on update Profile Page
   
    
    