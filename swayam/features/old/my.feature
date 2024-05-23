Feature: Course Settings bulk upload
  I want to verify course settings

  Background: 
    Given user launches the application
    Then verifies that applilcation launched successfully
    When user navigates to node as "firstNode"
    Then verify user redirects to azure login page
    When user login using "admin.username" and "admin.password"
    When user clicks on add course button
    Then user verifies the add coursed pop up dispplays
    #And user verifies the admin email field placeholder value is "node.admin.username" on popup
    When user enters  following course details
      | Title | URL Component | Course Admin Email |
      | A     | url           | course.admin.user  |
    And user clicks on "OK" button
    And user clicks on the course checkbox

  @nodeCourseCreation-CourseSettings
  Scenario Outline: Verify course created on Node , is displayed correctly on Central
    When user sets the availability to "Public (Enrolment Open)"
    And user click on course from course list page
    When user goes to course settings
    And user enters the following details
      | ForumURLEmbed     | ForumURL  | AnnouncementURL   | AnnouncementEmail   |
      | forum.ulr.embeded | forum.ulr | announcements.url | announcements.email |
    And user sets the NC to the course as "CEC"
    And user changes the course settings
      | CourseCredit | CourseWeeks | CourseLayout       | BooksReferences       | CourseCertificate  | InstructorInstitute  | AboutCourse       | YoutubeId  | CoursePicture  | InstructorBio  | InstructorName              |
      |            3 | 4 weeks     | course.layout.code | books.references.code | course.certificate | instructor.institute | about.course.code | youtube.id | course.picture | instructor.bio | course.card.instructor.name |
    And user checks "FDP Course" checkbox
    And user sets the course type to the course as "Core"
    And user sets the course level to the course as "Undergraduate"
    And user checks "Push to SWAYAM Central" checkbox
    And user clicks on "Save" Link
    And user verifies the "saved" message for confirmation
    Then I should print <count>

    Examples: 
      | count |
      |     1 |
      |     2 |
      |     3 |
      |     4 |
      |     5 |
      |     6 |
      |     7 |
      |     8 |
      |     9 |
      |    10 |
