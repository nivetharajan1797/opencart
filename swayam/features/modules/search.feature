#Author: your.email@your.domain.com
#Author: vaibhav_choudhary@persistent.com
#Keywords Summary :
@search
Feature: Create a course
  I want to test search feature with title,instructor,Institute and category

  Background: 
    Given user launches the application
    Then verifies that applilcation launched successfully
    When user hovers on course catalog
    And user select "All" category from the list

  @Search
  Scenario: Verify search UI
    When user verifies presence of search option
    And user verifies presence of search icon
    And user verfies seacrh field placeholder as "Search"

  #@keyword
  #Scenario: Verify search UI
    #When user searches for "course.name" 
    #Then user verifies the search results
    #
  #@CoursenameSearch
  #Scenario: Verify search UI
    #When user searches for a course from listed courses 
    #Then user verifies the search results
    