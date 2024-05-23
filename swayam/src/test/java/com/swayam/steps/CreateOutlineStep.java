package com.swayam.steps;

import java.util.List;
import java.util.Map;

import com.swayam.pages.CourseStaffPage;
import com.swayam.pages.CreateOutline;
import com.swayam.pages.InstructorPage;
import com.swayam.pages.NodeAdminPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateOutlineStep {

	String unitName = "";
	String courseCredits = "";
	String courseWeeks = "";

	@When("^user creates a unit as \"([^\"]*)\"$")
	public void createAUnit(String unitName) {
		CreateOutline createOutLinePage = new CreateOutline();
		createOutLinePage.createUnit(unitName);
	}
	
	@And("^user goes to manage->coursestaff$")
	public void gotoCourseStaff() {
		CreateOutline createOutLinePage = new CreateOutline();
		createOutLinePage.gotoCourseStaff();
	}

	@And("^user adds a course staff to the course as \"([^\"]*)\"$")
	public void addCourseStaff(String emailId) {
		CourseStaffPage cf = new CourseStaffPage();
		cf.verifyCourseStaffPage();
		cf.addCourseStaff(emailId);
	}

	@And("^user verifies the coursestaff successfull addition using \"([^\"]*)\"$")
	public void verifyCoursestaffAddition(String message) {
		CourseStaffPage cf = new CourseStaffPage();
		cf.verifyCourseStaffAddition(message);

	}

	
	@When("^user select checkbox for Show Correct Answer inside Lessons$")
	public void selectShowCorrectAnswerInsideLessons(){
		CreateOutline createOutLinePage = new CreateOutline();
		createOutLinePage.selectShowCorrectAnswer();
	}

	@When("^user clicks on \"([^\"]*)\" link under unit \"([^\"]*)\"$")
	public void selectAssessmentLink(String entityName, String unitName) {
		CreateOutline createOutLinePage = new CreateOutline();
		createOutLinePage.clickAssessmentLink(entityName, unitName);
	}


	@When("^user navigates to admin dashboard homepage$")
	public void verifyUserIsOnNodeAdminPage() {
		NodeAdminPage nodeAdminPage = new NodeAdminPage();
		nodeAdminPage.verifyUserOnNodeAdminPage();
	}

	@When("^user goes to course settings$")
	public void gotoCourseSettings() {
		CreateOutline createOutLinePage = new CreateOutline();
		createOutLinePage.goToCourseSettings();
	}

	@When("^user enters the following details$")
	public void enterCommunicationDetails(DataTable dataTable) {
		CreateOutline createOutLinePage = new CreateOutline();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);
		String ForumURLEmbed = list.get(0).get("ForumURLEmbed");
		String ForumURL = list.get(0).get("ForumURL");
		String AnnouncementURL = list.get(0).get("AnnouncementURL");
		String AnnouncementEmail = list.get(0).get("AnnouncementEmail");
		createOutLinePage.enterForumUrl(ForumURL);
		createOutLinePage.enterForumEmbedUrl(ForumURLEmbed);
		createOutLinePage.enterAnnouncementListUrl(AnnouncementURL);
		createOutLinePage.enterAnnouncementListEmail(AnnouncementEmail);
	}

	@When("^user sets the NC to the course as \"([^\"]*)\"$")
	public void setNC(String NcName) {
		CreateOutline createOutLinePage = new CreateOutline();
		createOutLinePage.setNcToCourse(NcName);
	}

	@When("user sets the course type to the course as \"([^\"]*)\"$")
	public void setCourseType(String courseType) {
		CreateOutline createOutLinePage = new CreateOutline();
		createOutLinePage.setCourseTypeToCourse(courseType);
	}

	@When("user sets the course level to the course as \"([^\"]*)\"$")
	public void setCourseLevel(String courseLevel) {
		CreateOutline createOutLinePage = new CreateOutline();
		createOutLinePage.setCourseLevelToCourse(courseLevel);
	}

	@When("^user changes the course settings$")
	public void changeCourseSettings(DataTable dataTable) {
		CreateOutline createOutLinePage = new CreateOutline();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);
		String courseCredits = list.get(0).get("CourseCredit");
		String courseWeeks = list.get(0).get("CourseWeeks");
		String courseLayout = list.get(0).get("CourseLayout");
		String booksReferences = list.get(0).get("BooksReferences");
		String courseCertificate = list.get(0).get("CourseCertificate");
		String instructorInstitute = list.get(0).get("InstructorInstitute");
		String aboutCourse = list.get(0).get("AboutCourse");
		String youtubeId = list.get(0).get("YoutubeId");
		String coursePicture = list.get(0).get("CoursePicture");
		/*
		 * String instructorBio = list.get(0).get("InstructorBio"); String
		 * instructorName = list.get(0).get("InstructorName");
		 */

		createOutLinePage.setCourseCredit(courseCredits);
		createOutLinePage.setCourseWeeks(courseWeeks);
		createOutLinePage.enterCourseLayout(courseLayout);
		createOutLinePage.enterCourseCertificatet(courseCertificate);
		createOutLinePage.enterBooksReferences(booksReferences);
		createOutLinePage.enterInstructorInstitute(instructorInstitute);
		createOutLinePage.enterAboutCourse(aboutCourse);
		createOutLinePage.enterVideoId(youtubeId);
		createOutLinePage.enterCoursePicture(coursePicture);
	}

	@When("^user verifies the \"([^\"]*)\" message for confirmation$")
	public void changeCourseSettings(String message) {
		CreateOutline createOutLinePage = new CreateOutline();
		createOutLinePage.verifyConfirmationMessage(message);
	}

	@And("^user goes to course outine$")
	public void gotoCourseOutine() {
		CreateOutline createOutLinePage = new CreateOutline();
		createOutLinePage.gotoCourseOutline();
	}

	@And("^user goes to course availaibity$")
	public void gotoCourseAvailability() {
		CreateOutline createOutLinePage = new CreateOutline();
		createOutLinePage.gotoCourseAvailability();
	}
	
	@And("^user goes to images and files$")
	public void gotoImagesAndFiles() {
		CreateOutline createOutLinePage = new CreateOutline();
		createOutLinePage.gotoImagesAndFiles();
	}
	
	@And("^user uploads images and files$")
	public void uploadImagesAndFiles() {
		CreateOutline createOutLinePage = new CreateOutline();
		createOutLinePage.uploadImagesAndFiles();
	}
	
	@And("^user copies link of uploaded image$")
	public void copyLinkUploadedImage() {
		CreateOutline createOutLinePage = new CreateOutline();
		createOutLinePage.copyLinkUploadedImage();
	}

	@And("^user goes to manage->announcment$")
	public void gotoAnnouncement() {
		CreateOutline createOutLinePage = new CreateOutline();
		createOutLinePage.gotoAnnoucement();
	}

	@When("^user set \"([^\"]*)\" availability to \"([^\"]*)\"$")
	public void user_set_availability_to(String entityName,
			String availabilityText) {
		CreateOutline createOutLinePage = new CreateOutline();
		createOutLinePage.setEntityAvailabilityByName(entityName,
				availabilityText);
	}

	@When("^user verifies the course settings$")
	public void verifyCourseSettings(DataTable dataTable) {
		CreateOutline createOutLinePage = new CreateOutline();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);
		String courseLayout = list.get(0).get("CourseLayout");
		String courseCertificate = list.get(0).get("CourseCertificate");
		String booksReferences = list.get(0).get("BooksReferences");
		String instructorInstitute = list.get(0).get("InstructorInstitute");
		String aboutCourse = list.get(0).get("AboutCourse");
		String youtubeId = list.get(0).get("YoutubeId");
		String coursePicture = list.get(0).get("CoursePicture");
		String instructorBio = list.get(0).get("InstructorBio");
		String instructorName = list.get(0).get("InstructorName");

		createOutLinePage.verifyCourseLayoutFieldValue(courseLayout);//
		createOutLinePage.verifyBooksReferencesValue(booksReferences);//
		createOutLinePage.verifyCourseCertificateValue(courseCertificate);//
		createOutLinePage.verifyInstructorInstituteValue(instructorInstitute);
		createOutLinePage.verifyAboutCourseValue(aboutCourse);//
		createOutLinePage.verifyCoursePictureValue(coursePicture);
		createOutLinePage.verifyInstructorBioValue(instructorBio);//
		createOutLinePage.verifyYoutubeIdValue(youtubeId);
		createOutLinePage.verifyInstructorNameValue(instructorName);

	}

	@When("^user verifies checkBox and dropdown settings$")
	public void verifyCourseCheckBoxAndDropdown(DataTable dataTable) {
		CreateOutline createOutLinePage = new CreateOutline();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);
		String courseCredits = list.get(0).get("CourseCredit");
		String courseWeeks = list.get(0).get("CourseWeeks");
		String fdpCourse = list.get(0).get("FDPCourse");
		String pushCentral = list.get(0).get("PushToSWAYAMCentral");
		String courseType = list.get(0).get("CourseType");
		String courseLevel = list.get(0).get("CourseLevel");

		createOutLinePage.verifyCourseCredit(courseCredits);
		createOutLinePage.verifyCourseWeeks(courseWeeks);
		createOutLinePage.verifyFDPCheckBox(fdpCourse);
		createOutLinePage.verifyPushToCentralCheckbox(pushCentral);
		createOutLinePage.verifyCourseTypeValue(courseType);
		createOutLinePage.verifyCourseLevelValue(courseLevel);
	}

	@When("^user enter following required details on assessment page$")
	public void user_enter_following_required_details_on_assessment_page(
			DataTable dataTable) {
		CreateOutline createOutLinePage = new CreateOutline();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);

		String assessmentTitle = list.get(0).get("Title");
		String points = list.get(0).get("Points");
		String showCorrectAnswer = list.get(0).get("Show Correct Answer");
		String singleSubmission = list.get(0).get("Single Submission");
		String dueDate = list.get(0).get("Due Date");

		createOutLinePage.createEntity(assessmentTitle);
		createOutLinePage.enterAssessmentPoints(points);
		createOutLinePage.setShowCorrectAnswser(showCorrectAnswer);
		createOutLinePage.setSingleSubmission(singleSubmission);
		createOutLinePage.setAssessmentDate(dueDate);

	}

	@When("^user enter following required details on lesson page$")
	public void user_enter_following_required_details_on_lesson_page(
			DataTable dataTable) {
		CreateOutline createOutLinePage = new CreateOutline();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);

		String lessonTitle = list.get(0).get("Title");
		String videoID = list.get(0).get("videoID");
		String lessonBody = list.get(0).get("lessonBody");

		createOutLinePage.createEntity(lessonTitle);
		createOutLinePage.enterVideoIdOnLessonsPage(videoID);
		createOutLinePage.enterLessonBody(lessonBody);
	}
	
	@When ("^user enter lesson title and video details on lesson page$")
	public void user_enter_lesson_title_and_video_details_on_lesson_page(
			DataTable dataTable){
		CreateOutline createOutLinePage = new CreateOutline();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);

		String lessonTitle = list.get(0).get("Title");
		String videoID = list.get(0).get("videoID");

		createOutLinePage.createEntity(lessonTitle);
		createOutLinePage.enterVideoIdOnLessonsPage(videoID);		
	}
	
	@When ("^user enter video and vtt details on lesson page$")
	public void user_enter_video_and_vtt_details_on_lesson_page(
			DataTable dataTable){
		CreateOutline createOutLinePage = new CreateOutline();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);

		String lessonTitle = list.get(0).get("Title");
		String videoID = list.get(0).get("videoID");
		String vttUrl = list.get(0).get("vttUrl");
		String vttLanguage = list.get(0).get("vttLanguage");
		
		createOutLinePage.createEntity(lessonTitle);
		createOutLinePage.enterVideoIdOnLessonsPage(videoID);
		createOutLinePage.enterVttUrl(vttUrl, vttLanguage);
	}

	@When("^user enter following required details on programming assignment page$")
	public void user_enter_following_required_details_on_programming_assignment_page(
			DataTable dataTable) {
		CreateOutline createOutLinePage = new CreateOutline();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);

		String progAssignmenTitle = list.get(0).get("Title");
		String problemStatement = list.get(0).get("Problem Statement");
		String compileAndRun = list.get(0).get("Compile & Run");
		String programEvaluator = list.get(0).get("Program Evaluator");
		String presentationErrorsPrefs = list.get(0).get(
				"Ignore Presentation Errors");
		String submissonDueDate = list.get(0).get("Due Date");

		createOutLinePage.createEntity(progAssignmenTitle);
		createOutLinePage.enterProblemStatement(problemStatement);
		createOutLinePage.setCompileAndRunOption(compileAndRun);
		createOutLinePage.setProgramEvaluator(programEvaluator);
		createOutLinePage.setPresentationErrorsPrefs(presentationErrorsPrefs);
		createOutLinePage.setSubmissionDueDate(submissonDueDate);

	}

	@When("^user adds public test cases$")
	public void addPublicTestcase(DataTable dataTable) {
		CreateOutline createOutLinePage = new CreateOutline();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);
		String input = list.get(0).get("input");
		String output = list.get(0).get("output");
		createOutLinePage.createPublicTestCase(input, output);

	}

	@When("^user adds private test cases$")
	public void addPrivateTestcase(DataTable dataTable) {
		CreateOutline createOutLinePage = new CreateOutline();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);
		String input = list.get(0).get("input");
		String output = list.get(0).get("output");
		createOutLinePage.createPrivateTestCase(input, output);
	}

	@When("^user adds Programming Languages$")
	public void addProgrammingLanguages(DataTable dataTable) {
		CreateOutline createOutLinePage = new CreateOutline();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);
		String language = list.get(0).get("Languages");
		String sampleSolution = list.get(0).get("Sample Solution");
		String fileName = list.get(0).get("File Name");

		createOutLinePage.addLanguage(language, sampleSolution, fileName);
	}

	@When("^user enter following required details on subjective assignment page$")
	public void user_enter_following_required_details_on_subjective_assignment_page(
			DataTable dataTable) {
		CreateOutline createOutLinePage = new CreateOutline();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);

		String progAssignmenTitle = list.get(0).get("Title");
		String assignmentType = list.get(0).get("Assignment Type");
		String problemStatement = list.get(0).get("Problem Statement");
		String submissionDueDate = list.get(0).get("Submission Due Date");
		String evaluationDueDate = list.get(0).get("Evaluation Due Date");
		String numberOfSubmissions = list.get(0).get("Number of Submissions");
		String numberOfReviewers = list.get(0).get("Number of reviewers");
		String scoringMethod = list.get(0).get("Scoring method");
		
		createOutLinePage.createEntity(progAssignmenTitle);
		createOutLinePage.enterAssignmentType(assignmentType);
		createOutLinePage.enterProblemStatement(problemStatement);
		createOutLinePage.setSubmissionDueDate(submissionDueDate);
		createOutLinePage.setEvaluationDueDate(evaluationDueDate);

		createOutLinePage.setnNumberOfReviewers(numberOfReviewers);
		createOutLinePage.setNumberOfSubmissions(numberOfSubmissions);
		createOutLinePage.setScoringMethod(scoringMethod);

	}

	
	@When("^user add questions to the assessment$")
	public void user_add_questions_to_the_assessment(DataTable dataTable) {
		CreateOutline createOutLinePage = new CreateOutline();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);
		String assessmentTitle = list.get(0).get("questionname");
		String choice1 = list.get(0).get("choice 1");
		String choice2 = list.get(0).get("choice 2");
		String choice3 = list.get(0).get("choice 3");
		String choice4 = list.get(0).get("choice 4");
		String description = list.get(0).get("description");

		createOutLinePage.enterQuestionToAssessment(assessmentTitle, choice1,
				choice2, choice3, choice4, description);
	}
	
	@When("^user navigates to Select Existing tab$")
	public void user_navigates_to_Select_Existing_tab(){
		CreateOutline createOutLinePage = new CreateOutline();
		createOutLinePage.accessSelectExistingTab();
	}
	
	@When("^user navigates to Create Numeric Answer tab$")
	public void user_navigates_to_Create_Numeric_Answer_tab(){
		CreateOutline createOutLinePage = new CreateOutline();
		createOutLinePage.accessCreateNumericAnswerTab();
	}
	
	@When("^user navigates to Create Numeric Answer tab to add another question$")
	public void user_navigates_to_Create_Numeric_Answer_tab_to_add_another_question(){
		CreateOutline createOutLinePage = new CreateOutline();
		createOutLinePage.accessCreateNumericAnswerTabToAddAnotherQuestion();
	}
	
	@When("^user adds numeric exact match question$")
	public void user_adds_numeric_extact_match_question(DataTable dataTable){
		
		CreateOutline createOutLinePage = new CreateOutline();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);

		String question = list.get(0).get("Question");
		String answer = list.get(0).get("Answer");
		String desc = list.get(0).get("Description");
		createOutLinePage.addNumericTypeQuestion(question,answer,desc);
	}

	
	@When("^user scrolls down for Close button$")
	public void user_scrolls_down_for_Close_button(){
		CreateOutline createOutLinePage = new CreateOutline();
		createOutLinePage.scrollDownforCloseButtonAssessment();
	}
	
	@When("^user scrolls down for Save button$")
	public void user_scrolls_down_for_Save_button(){
		CreateOutline createOutLinePage = new CreateOutline();
		createOutLinePage.scrollDownforSaveButton();
	}

	@When("^user adds MSQ question to the assessment$")
	public void user_add_MSQ_questions_to_the_assessment(DataTable dataTable) {
		CreateOutline createOutLinePage = new CreateOutline();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);
		String assessmentTitle = list.get(0).get("questionname");
		String choice1 = list.get(0).get("choice 1");
		String choice2 = list.get(0).get("choice 2");
		String choice3 = list.get(0).get("choice 3");
		String choice4 = list.get(0).get("choice 4");
		String choice5 = list.get(0).get("choice 5");
		String description = list.get(0).get("description");
		String answers = list.get(0).get("Answers");
		String allornothing = list.get(0).get("All or Nothing");

		
		createOutLinePage.enterMSQToAssessment(assessmentTitle, choice1,
				choice2, choice3, choice4, choice5, description, answers,allornothing);
	}

	
	@When("^user scrolls down for Save button on Course Settings page")
	public void user_scrolls_down_for_Save_button_on_Course_Settings_page() {
		CreateOutline createOutLinePage = new CreateOutline();
		createOutLinePage.scrollDownforSaveButtonCourseSettingsPage();
	}
	
	@When("^user adds existing question$")
	public void user_adds_existing_question(){
		CreateOutline createOutLinePage = new CreateOutline();
		createOutLinePage.addExistingQuestion();
	}
	
	@When("^user adds numeric type question$")
	public void user_adds_numeric_type_question(){
		CreateOutline createOutLinePage = new CreateOutline();
		createOutLinePage.addNumericTypeQuestion();
	}
	
	@When("^user adds range type question$")
	public void user_adds_range_type_question(){
		CreateOutline createOutLinePage = new CreateOutline();
		createOutLinePage.addRangeTypeQuestion();
	}

	@When("^admin selects existing question from dropdown$")
	public void user_adds_existing_question(DataTable datatable){
		
		CreateOutline createOutLinePage = new CreateOutline();
		List<Map<String, String>> list = datatable.asMaps(String.class,
				String.class);
		String assessment = list.get(0).get("Assessment Name");
		
		createOutLinePage.addExistingQuestion(assessment);
	}


	@Then("^user set the assessment due date to \"([^\"]*)\"$")
	public void user_set_the_assessment_due_date_to(String dueDate) {
		CreateOutline createOutLinePage = new CreateOutline();
		createOutLinePage.setAssessmentDate(dueDate);
	}

	@Then("^user set the submission due date to \"([^\"]*)\"$")
	public void user_set_the_submission_due_date_to(String dueDate) {
		CreateOutline createOutLinePage = new CreateOutline();
		createOutLinePage.setSubmissionDueDate(dueDate);
	}

	@Then("^user verifies course is not present on dashboard$")
	public void verifyCoursePresentOnDashboard() {
		CreateOutline createOutLinePage = new CreateOutline();
		createOutLinePage.verifyCourseIsNotPresentOnDashboard();
	}

	@Then("^user verifies course is present on dashboard on closed course list$")
	public void verifyCourseisNotPresentOnDashboard() {
		CreateOutline createOutLinePage = new CreateOutline();
		createOutLinePage.verifyCourseIsPresentOnDashboard();
	}

	@Then("^user click on Show closed courses checkbox on dashboard$")
	public void gotoClosedCourses() {
		CreateOutline createOutLinePage = new CreateOutline();
		createOutLinePage.clickOnClosedCourseCheckbox();
	}

	@When("^user creates an intructor$")
	public void userCreatesIntructor(DataTable dataTable) {
		InstructorPage instructorPage = new InstructorPage();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);
		String name = list.get(0).get("name");
		String college = list.get(0).get("college");
		String photoURL = list.get(0).get("photoURL");
		String bio = list.get(0).get("bio");
		String email = list.get(0).get("email");
		instructorPage.enterInstructorName(name);
		instructorPage.enterInstructorCollege(college);
		instructorPage.enterInstructorPhoto(photoURL);
		instructorPage.enterInstructorBio(bio);
		instructorPage.enterInstructoremail(email);

	}

	@Then("^user stores instructor id as \"([^\"]*)\"$")
	public void userStoreInstructorID(String instructorIdHolder) {
		InstructorPage instructorPage = new InstructorPage();
		instructorPage.storeinstructorID(instructorIdHolder);
	}

	@And("^user clicks on instructor with id as \"([^\"]*)\"$")
	public void clickOnInstructorFromList(String instructorID) {
		InstructorPage instructorPage = new InstructorPage();
		instructorPage.openInstructorById(instructorID);
	}

	@When("^user verifies the instructor details$")
	public void userVerifiesIntructor(DataTable dataTable) {
		InstructorPage instructorPage = new InstructorPage();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);
		String name = list.get(0).get("name");
		String college = list.get(0).get("college");
		String photoURL = list.get(0).get("photoURL");
		String bio = list.get(0).get("bio");
		String email = list.get(0).get("email");
		instructorPage.verifyInstructorName(name);
		instructorPage.verifyInstructorCollege(college);
		instructorPage.verifyInstructorPhoto(photoURL);
		instructorPage.verifyInstructorBio(bio);
		instructorPage.verifyInstructoremail(email);

	}

	@And("^user enters the instructor with \"([^\"]*)\" and name as \"([^\"]*)\"$")
	public void enterInstructorID(String instructorID, String instructorName) {
		InstructorPage instructorPage = new InstructorPage();
		instructorPage.populateInstructor(instructorID, instructorName);
	}

	@When("^user verifies the populated instructor details$")
	public void userVerifiesIntructorOnBio(DataTable dataTable) {
		InstructorPage instructorPage = new InstructorPage();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);
		String name = list.get(0).get("name");
		String college = list.get(0).get("college");
		String photoURL = list.get(0).get("photoURL");
		String bio = list.get(0).get("bio");
		instructorPage.verifyInstructorNameOnSettingsPage(name);
		instructorPage.verifyInstructorCollegeOnSettingsPage(college);
		instructorPage.verifyInstructorPhotoOnSettingsPage(photoURL);
		instructorPage.verifyInstructorBioOnSettingsPage(bio);

	}

}
