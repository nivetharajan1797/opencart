
Feature: SPOC
  I want to verify Spoc creation, Spoc Selection,Spoc dashboard view

  Background: 
    Given user launches the application
    When user navigates to node as "firstNode"
    Then verify user redirects to azure login page
    When user login using "admin.username" and "admin.password"
    When user clicks on add course button
    Then user verifies the add coursed pop up dispplays
    And user verifies the admin email field placeholder value is "node.admin.username" on popup
    When user enters  following course details
      | Title | URL Component | Course Admin Email |
      | test  | url           | test@test.com      |
    And user clicks on "OK" button
    And user clicks on the course checkbox
    When user sets the availability to "Public (Enrolment Open)"
    And user clears the browser cache

  @SpocFlow
  Scenario: Verify LC flow for an Indian LC
    When user navigates to node as "central"
    When user clicks on "Sign In" button from Homepage
    Then verify user redirects to azure login page
    When user login using "admin.username" and "admin.password"
    Then user redirects back to application
    And user opens the user dropdown
    And user verifies the "DASHBOARD" link on header
    And user goes to "DASHBOARD" page from user dropdown
    And user opens the LC page
    Then user verifies the Local Chapter Page
    And user removes the existing local chapter with "2045" code
    Then user verifies the Local Chapter Page
    And user clicks on "Add Local Chapter" link
    And user fills the Local Chapter fields
      | code  | name  | city    | country | state         | org_type | spoc_email          |
      | 2045 | LC_QA | Chennai | India   | Daman and Diu | College  | bali21aug@gmail.com |
    And user clicks on "Add New Local Chapter" link
    Then user verifies the Local Chapter Page
    And user clicks on "2045" link
    And user verifies added local chapter values
      | code  | name  | city    | country | state         | org_type | spoc_email          |
      | 2045 | LC_QA | Chennai | India   | Daman and Diu | College  | bali21aug@gmail.com |
    And user clears the browser cache
    When user navigates to node as "central"
    When user clicks on "Sign In" button from Homepage
    Then verify user redirects to azure login page
    When user login using "learner.username" and "learner.password"
    Then user redirects back to application
    When user hovers on course catalog
    And user select "All" category from the list
    When user searches for "course.name"
    Then user verifies the search results for "course.name"
    And user clicks on the course "course.name"
    And user joins the course
    And user select the indian LC on update Profile Page
    And user clears the browser cache
    When user navigates to node as "central"
    When user clicks on "Sign In" button from Homepage
    Then verify user redirects to azure login page
    When user login using "spoc.username" and "spoc.password"
    Then user redirects back to application
    And user opens the user dropdown
    And user verifies the "SPOC ADMIN" link on header
    And user clicks on "SPOC ADMIN" link from user dropdown
    And user verifies spoc admin view
    And user clicks on namespace link for "course.name"
    And user verifies user on the list for Enrolled Members for "learner.username"
    And user goes back to previous page
    And user goes to All Local Chapter Members page
    And user verifies course "learner.username" for the user "course.name" under course list
    
    
  @SpocFloweVBABert
  Scenario: Verify LC flow for a Non-Indian LC
    When user navigates to node as "central"
    When user clicks on "Sign In" button from Homepage
    Then verify user redirects to azure login page
    When user login using "admin.username" and "admin.password"
    Then user redirects back to application
    And user opens the user dropdown
    And user verifies the "DASHBOARD" link on header
    And user goes to "DASHBOARD" page from user dropdown
    And user opens the LC page
    Then user verifies the Local Chapter Page
    And user removes the existing local chapter with "85112" code
    Then user verifies the Local Chapter Page
    And user clicks on "Add Local Chapter" link
    And user fills the Local Chapter fields
      | code  | name  | city    | country        | state   | org_type | spoc_email         |
      | 85112 | LC_QA | Bristol | United Kingdom | Bristol | College  | qzf49618@bcaoo.com |
    And user clicks on "Add New Local Chapter" link
    Then user verifies the Local Chapter Page
    And user clicks on "85112" link
    And user verifies added local chapter values
      | code  | name  | city    | country        | state   | org_type | spoc_email         |
      | 85112 | LC_QA | Bristol | United Kingdom | Bristol | College  | qzf49618@bcaoo.com |
    And user clears the browser cache
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
    And user select the LC on update Profile Page
    And user clears the browser cache
    When user navigates to node as "central"
    When user clicks on "Sign In" button from Homepage
    Then verify user redirects to azure login page
    When user login using local user as "spoc.local.username" and "spoc.local.password"
    Then user redirects back to application
    And user opens the user dropdown
    And user verifies the "SPOC ADMIN" link on header
    And user clicks on "SPOC ADMIN" link from user dropdown
    And user verifies spoc admin view
    And user clicks on namespace link for "course.name"
    And user verifies user on the list for Enrolled Members for "learner.local.email"
    And user goes back to previous page
    And user goes to All Local Chapter Members page
    And user verifies course "learner.local.email" for the user "course.name" under course list
