Feature: SPOC
  I want to use this template for my feature file

  #@SpocAddition
  #Scenario: Verify LC addition
  #Given user launches the application
  #When user clicks on "Sign In" button on google page
  #Then verify user redirects to google sing in page
  #When user login using "admin.username" and "admin.password"
  #Then user redirects back to application
  #And user opens the user dropdown
  #And user verifies the "DASHBOARD" link on header
  #And user goes to "DASHBOARD" page from user dropdown
  #And user opens the LC page
  #Then user verifies the Local Chapter Page
  #And user clicks on "Add Local Chapter" link
  #And user fills the Local Chapter fields
  #| code  | name  | city    | state      | org_type | spoc_email          |
  #| 85112 | LC_QA | Chennai | Tamil Nadu | College  | bali21aug@gmail.com |
  #And user clicks on "Add New Local Chapter" link
  #Then user verifies the Local Chapter Page
  #And user clicks on "85112" link
  #And user verifies added local chapter values
  #| code  | name  | city    | state      | org_type | spoc_email          |
  #| 85112 | LC_QA | Chennai | Tamil Nadu | College  | bali21aug@gmail.com |
  #@SpocLogin
  #Scenario: Verify login with admin user
  #Given user launches the application
  #When user clicks on "Sign In" button on google page
  #Then verify user redirects to google sing in page
  #When user login using "spoc.username" and "spoc.password"
  #Then user redirects back to application
  @SpocSelection
  Scenario: Verify LC selection as learner
    Given user launches the application
    When user clicks on "Sign In" button on google page
    Then verify user redirects to google sign in page
    When user login using "learner.username" and "learner.password"
    Then user redirects back to application
    When user hovers on course catalog
    And user select "All" category from the list
    When user searches for "test_qa"
    Then user verifies the search results for "course.name"
    When user clicks on "Sign In" button on google page
    Then verify user redirects to google sign in page
    When user login using "spoc.username" and "spoc.password"
    Then user redirects back to application
    And user opens the user dropdown
    And user verifies the "SPOC ADMIN" link on header
    And user clicks on "SPOC ADMIN" link from user dropdown
    And user verifies spoc admin view
    And user verifies user on the list for Enrolled Members for "course.name"
    And user goes back to previous page
    And user goes to All Local Chapter Members page
    And user verifies course "reviewer1@nptel.iitm.ac.in" for the user "test_qa" under course list
  #@SpocDasboardView
  #Scenario: Verify SPOC Admin view on user Site
#
  #@SpocDasboardView
  #Scenario: Verify course list for 'Active Courses for <LC Name> ' with SPOC Admin on admin dashboard
#
  #@SpocDasboardView
  #Scenario: Verify 'list of Members for your Local Chapter for this Course' on SPOC dashboard
#
  #@SpocDasboardView
  #Scenario: Verify student assignment progress on SPOC dashboard
#
  #@SpocDasboardView
  #Scenario: Verify 'All Local Chapter Members' on SPOC dashboard
#
  #@SpocDasboardView
  #Scenario: Verify SPOC Admin view on user Site without synced
