@courseSettings @regression @jenkins
Feature: Course Settings
	I want to verify course settings

Background: 
	Given user launches the application 
	Then verifies that applilcation launched successfully 
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
	
@nodeCourseCreation-CourseSettings 
Scenario: Verify course settings on node and central 
	When user sets the availability to "Public (Enrolment Open)" 
	And user goes to course outine page 
	When user goes to course settings 
	And user enters the following details 
		| ForumURLEmbed     | ForumURL  | AnnouncementURL   | AnnouncementEmail   |
		| forum.ulr.embeded | forum.ulr | announcements.url | announcements.email |
	And user sets the NC to the course as "CEC" 
	And user changes the course settings 
		| CourseCredit | CourseWeeks | CourseLayout  | BooksReferences  | CourseCertificate  | InstructorInstitute | AboutCourse  | YoutubeId  | CoursePicture  |
		|            3 | 4 weeks     | course.layout | books.references | course.certificate | instructor.id       | about.course | youtube.id | course.picture | 
	And user checks "FDP Course" checkbox 
	And user sets the course type to the course as "Core" 
	And user sets the course level to the course as "Undergraduate" 
	And user checks "Push to SWAYAM Central" checkbox 
	And user clicks on "Save" Link 
	And user verifies the "saved" message for confirmation 
	And user goes to course outine 
	And user goes to course settings 
	And user verifies the course settings 
		| CourseLayout  | BooksReferences  | CourseCertificate  | InstructorInstitute  | AboutCourse  | YoutubeId  | CoursePicture  | InstructorBio  | InstructorName              |
		| course.layout | books.references | course.certificate | instructor.institute | about.course | youtube.id | course.picture | instructor.bio | course.card.instructor.name |
	And user verifies checkBox and dropdown settings 
		| CourseCredit | CourseWeeks | FDPCourse | PushToSWAYAMCentral | CourseType | CourseLevel   |
		|            3 | 4 weeks     | Yes       | Yes                 | Core       | Undergraduate |
	When user navigates to node as "central" 
	When user hovers on course catalog 
	And user select "All" category from the list 
	When user searches for "course.name" 
	Then user verifies the search results for "course.name" 
	And user verifies the course details 
		| InstructorName              | CourseWeeks | InstructorInstitute  | NcName | CoursePicture  |
		| course.card.instructor.name | 4 weeks     | instructor.institute | CEC    | course.picture |
	And user clicks on the course "course.name" 
	And user verifies course details on preview page 
		| CourseLayout  | BooksReferences  | CourseCertificate  |InstructorInstitute  | AboutCourse  | YoutubeId  | InstructorBio  | InstructorName              |
		| course.layout | books.references | course.certificate | instructor.institute | about.course | youtube.id | instructor.bio | course.card.instructor.name |
	And user verifies the course summary on preview page 
		| CourseWeeks | FDPCourse | CourseType | CourseLevel   |
		| 4 weeks     | Yes       | Core       | Undergraduate |
