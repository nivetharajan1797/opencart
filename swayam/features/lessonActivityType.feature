@lessonActivityType @regression
Feature: To create lesson with Video and activity question
  To test Lesson having video with Activity question, and verifying lesson content and answering as student.

  Background: 
    Given user launches the application
    Then verifies that applilcation launched successfully
    When user navigates to node as "firstNode"
    Then verify user redirects to azure login page
   #When user login using "admin.username" and "admin.password"
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
    And user goes to course outine page

  Scenario: Verify course outline for Lesson
    When user clicks on "Add Unit" button
    When user creates a unit as "unit.name"
    When user select checkbox for Show Correct Answer inside Lessons
    And user clicks on "Save" Link
    And user waits for "Saved" confirmation
    And user clicks on "Close" Link
    #lesson creation
    When user clicks on "lesson" link under unit "Week 1"
    And user enter lesson title and video details on lesson page
      | Title        | videoID  |
      | lesson.title | video.id |
    And user add questions to the assessment
      | questionname     | choice 1 | choice 2 | choice 3 | choice 4 | description      |
      | assessment.ques1 | A        | B        | C        | D        | correct question |  
  #  And user adds activity question on lesson    
    And store page url to "lesson.admin.page"
    And user clicks on "Save" Link
    And user waits for "Saved" confirmation
    And user clicks on "Close" Link
    
    # Setting availability
    And user goes to course availaibity
    And user waits for "OK" confirmation
    And user set "unit.name" availability to "Course"
    And user set "lesson.title" availability to "Course"
    And user clicks on "Save" Link
    And user waits for "Saved" confirmation
    And user clicks on "Logout" Link
    And user clears the browser cache
    
    # Login as a student and verify
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
    And user select the indian LC on update Profile Page
    
    #verifying lesson content
    
    And user goes to assessment "lesson.title" on course outline
    And store page url to "lesson.user.page"
    And user verifies the lesson title and video details
      | Title        | videoID  |
      | lesson.title | video.id |
    And user verifies answers of activity type lesson  
      