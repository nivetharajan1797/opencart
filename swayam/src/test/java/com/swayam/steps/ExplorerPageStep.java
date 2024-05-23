package com.swayam.steps;

import java.util.List;
import java.util.Map;

import com.swayam.pages.ExplorerPage;
import com.swayam.pages.ProgrammingAssignmentPage;
import com.swayam.pages.SubjectiveAssignmentPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExplorerPageStep {

	@When("^user verifies presence of search option$")
	public void verifySearchOption() throws Throwable {
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.verifySearchFieldIsPresent();
	}

	@When("^user verifies presence of search icon$")
	public void verifySearchIcon() throws Throwable {
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.verifySearchIconIsPresent();
	}

	@When("^user verfies seacrh field placeholder as \"([^\"]*)\"$")
	public void verfySeacrhFiledPlaceholderText(String placeholder)
			throws Throwable {
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.verifySearchPlaceHolder(placeholder);
	}

	@When("^user searches for \"([^\"]*)\"$")
	public void enterSearchCriteria(String searchKeyword) {
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.enterSearchKeyword(searchKeyword);

	}

	@When("^user verifies the search results shows \"([^\"]*)\" message on upcoming Tab$")
	public void verifyCourseNotShownOnSearch(String message) throws Throwable {
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.verifyCourseNotPresent(message);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Then("^user goes to \"([^\"]*)\" Tab of explorer page$")
	public void goToTab(String tabName) {
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.goToTab(tabName);
	}

	@Then("^user verifies the search results for \"([^\"]*)\"$")
	public void verifySearchResult(String courseName) {
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.verifySearchResults(courseName);
	}

	@Then("^user clicks on the course \"([^\"]*)\"$")
	public void userJoinsTheCourse(String courseName) {
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.clickOnTheCourse(courseName);
	}

	@Then("^user verifies the course title \"([^\"]*)\" on detail page$")
	public void verifyCourseTitle(String courseName) {
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.verifyCourseTitleOnDetailPage(courseName);
	}

	@Then("^user joins the course$")
	public void userJoinsTheCourse() {
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.joinTheCourse();
	}

	@Then("user select the LC on update Profile Page$")
	public void userSelectLocalChapter() {
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.selectNonIndianLocalChapterOnProfileUpdatePage();
	}
	
	@Then("user select the LC on update Profile Page as Faculty$")
	public void userSelectLocalChapterFaculty() {
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.selectNonIndianLocalChapterOnProfileUpdatePageFaculty();
	}

	@Then("user select the indian LC on update Profile Page$")
	public void userSelectIndianLocalChapter() {
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.selectIndianLocalChapterOnProfileUpdatePage();
	}
	
	@Then("user select the indian LC on update Profile Page as Faculty$")
	public void userSelectIndianLocalChapterFaculty() {
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.selectIndianLocalChapterOnProfileUpdatePageFaculty();
	}
	
	@Then("user select the industry LC on update Profile Page$")
	public void userSelectIndustryLocalChapter() {
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.selectIndustryLocalChapterOnProfileUpdatePage();
	}

	@Then("^user goes to assessment \"([^\"]*)\" on course outline$")
	public void user_goes_to_assessment_on_course_outline(String entityName) {
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.GotoCourseEntity(entityName);
	}

	@Then("^user verifies the assessment content$")
	public void user_verifies_the_assessment_content(DataTable dataTable) {
		ExplorerPage explorerPage = new ExplorerPage();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);
		String assessmentTitle = list.get(0).get("Title");
		String question = list.get(0).get("Question");
		String questionOptions = list.get(0).get("Options");
		String points = list.get(0).get("Points");
		String showCorrectAnswer = list.get(0).get("Show Correct Answer");
		String singleSubmission = list.get(0).get("Submission Type");
		String dueDate = list.get(0).get("Due Date");

		explorerPage.verifyAssessmentTitle(assessmentTitle);
		explorerPage.verifyAssessmentQuestion(question);
		explorerPage.verifyAsssessmentOptions(questionOptions);
		explorerPage.verifyAssessmentPoints(points);
		explorerPage.verifyCheckAns(showCorrectAnswer);
		explorerPage.verifyAssessmentSubmissionType(singleSubmission);
	//	explorerPage.verifyAssessmentDueDate(dueDate);
		explorerPage.verifyAssessmentDueDateFuture(dueDate);
	}

	@Then("^user verifies the lesson content$")
	public void user_verifies_the_lesson_content(DataTable dataTable) {
		ExplorerPage explorerPage = new ExplorerPage();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);

		String lessonTitle = list.get(0).get("Title");
		String lessonVideo = list.get(0).get("videoID");
		String lessonBody = list.get(0).get("lessonBody");
		

		explorerPage.verifylessonTitle(lessonTitle);
		explorerPage.verifyvideoOnLesson(lessonVideo);
		explorerPage.verifylessonBody(lessonBody);

	}
	
	@Then("^user verifies the lesson title and video details$")
	public void user_verifies_the_lesson_title_and_video_details(DataTable dataTable) {
		ExplorerPage explorerPage = new ExplorerPage();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);

		String lessonTitle = list.get(0).get("Title");
		String lessonVideo = list.get(0).get("videoID");

		explorerPage.verifylessonTitle(lessonTitle);
		explorerPage.verifyvideoOnLesson(lessonVideo);
	}

	@Then("^user verifies the programming assingment content$")
	public void user_verifies_the_programming_assignment_content(
			DataTable dataTable) {
		ProgrammingAssignmentPage progAssignmentPage = new ProgrammingAssignmentPage();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);
		String assignmentTitle = list.get(0).get("Title");
		String problemStatement = list.get(0).get("Problem Statement");
		String Languages = list.get(0).get("Languages");
		String dueDate = list.get(0).get("Due Date");
		progAssignmentPage.verifyProgAssignmentTitle(assignmentTitle);
		progAssignmentPage.verifyProblemStatement(problemStatement);
		progAssignmentPage.verifySuportedLanguages(Languages);
	//	progAssignmentPage.verifyAssignmentDueDate(dueDate);
		progAssignmentPage.verifyAssessmentDueDateFuture(dueDate);
	}

	@Then("^user verifies the public test case$")
	public void user_verifies_the_public_test_case(DataTable dataTable) {
		ProgrammingAssignmentPage progAssignmentPage = new ProgrammingAssignmentPage();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);
		String input = list.get(0).get("input");
		String output = list.get(0).get("output");
		progAssignmentPage.verifyPublicTestInputOuput(input, output);
	}
	
	@Then("^user verifies the test case status$")
	public void user_verifies_the_test_case_status(DataTable dataTable) {
		ProgrammingAssignmentPage progAssignmentPage = new ProgrammingAssignmentPage();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);
		String name = list.get(0).get("name");
		String input = list.get(0).get("input");
		String expectedoutput = list.get(0).get("Expectedoutput");
		String actualoutput = list.get(0).get("Actualoutput");
		String status = list.get(0).get("status");
		 progAssignmentPage.verifyPublicTestCompileAndRun(name,input,expectedoutput,actualoutput,status);
	
	}
	
	
	@Then("^user verifies assignment submission before due date$")
	public void userVerifyAssignmentSubmission(DataTable dataTable) {
		ProgrammingAssignmentPage progAssignmentPage = new ProgrammingAssignmentPage();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);
		String name = list.get(0).get("name");
		String status = list.get(0).get("status");
		progAssignmentPage.verifyCodeSubmissionBeforeDuedate(name,status);
	
		
		
	}
	@Then("^user verifies the \"([^\"]*)\" category page$")
	public void VerifyCategoryPage(String category) {
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.verifyExplorerProject();
	}

	@When("^user verifies the course details$")
	public void verifyCourseDetails(DataTable dataTable) {
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);
		String courseWeeks = list.get(0).get("CourseWeeks");
		String instructorName = list.get(0).get("InstructorName");
		String instructorInstitute = list.get(0).get("InstructorInstitute");
		String ncName = list.get(0).get("NcName");
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.verifyCourseCardContent();
		explorerPage.verifyInstructorNameOnCard(instructorName);
		explorerPage.verifyinstructorInstituteOnCard(instructorInstitute);
		explorerPage.verifyNcNameOnCard(ncName);
		explorerPage.verifyCourseWeek(courseWeeks);
	}

	@When("^user clicks on \"([^\"]*)\" dropdown$")
	public void clickOnFilterDropdown(String filterName) {
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.selectAFilter(filterName);
	}

	@Then("^user verifies the following \"([^\"]*)\" dropdown options$")
	public void user_verifies_the_following_Learning_Path_dropdown_options(
			String filterName, DataTable filterOptions) {
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.verifyFilterOptions(filterOptions.asList(String.class));

	}
	
	@And("^user clicks on Go to Course button$")
	public void user_clicks_on_Go_to_Course_button() {
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.clickOnGoToCourseButton();
	}

	@And("^user clicks on \"([^\"]*)\" link from user dropdown$")
	public void UserclickonUserManu(String linkname) {
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.clickonUserManu(linkname);
	}
	
	@And("^user clicks on SYNC YOUR COURSES button$")
	public void user_clicks_on_SYNC_YOUR_COURSES_button() {
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.clickonSyncYourCourses();
	}

	@Then("^user chooses \"([^\"]*)\" option$")
	public void user_chooses_option(String option) {
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.chooseAnOption(option);
	}

	@Then("^user submits the assessment$")
	public void user_submits_the_assessment() {
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.submitAssessment();
	}

	@Then("^user verifies the confirmation message \"([^\"]*)\" for \"([^\"]*)\"$")
	public void user_verifies_the_confirmation_message(String msgKey,
			String entityName) {
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.verifyAssessmentSubmissionMessage(msgKey, entityName);
	}

	@Then("^user clicks \"([^\"]*)\" link from userdropdown on node$")
	public void user_clicks_link_from_userdropdown_on_node(String linkName) {
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.openUserDropdownOnNode();
		explorerPage.clickOnUserdropdownLink(linkName);
	}

	@Then("^user verifies the assessment due date \"([^\"]*)\"$")
	public void user_verifies_the_assessment_due_date(String dueDate) {
		ExplorerPage explorerPage = new ExplorerPage();
	//	explorerPage.verifyPostAssessmentDueDate(dueDate);
		explorerPage.verifyAssessmentDueDatePast(dueDate);
	}
	
	@Then("^user verifies the programming assignment due date \"([^\"]*)\"$")
	public void user_verifies_the_programming_assignment_due_date(String dueDate) {
		ProgrammingAssignmentPage programmingAssignmentPage = new ProgrammingAssignmentPage();
	//	programmingAssignmentPage.verifyAssignmentDueDate( dueDate);
		programmingAssignmentPage.verifyAssignmentDueDatePast(dueDate);
	}
	

	@Then("^user verified the due date passed message \"([^\"]*)\"$")
	public void user_verified_the_due_date_passed_message(String messageKey) {
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.verifyDuedatePassedMessage(messageKey);
	}

	@Then("^user verifies the assessment result as \"([^\"]*)\"$")
	public void user_verifies_the_assessment_result_as(String expectedResult) {
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.verifyAssessmentResult(expectedResult);
	}

	@Then("^user verifies the score on progress page$")
	public void user_verifies_the_score_on_progress_page(DataTable dataTable)
			throws Throwable {
		ExplorerPage explorerPage = new ExplorerPage();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);
		String entityTitle = list.get(0).get("entityname");
		String expectedScore = list.get(0).get("score");
		explorerPage.verifyScoreOnProgressPage(entityTitle, expectedScore);

	}
	@Then("^user writes the code as \"([^\"]*)\"$")
	public void userWritessolutionCode(String codeSolution) {
		ProgrammingAssignmentPage programmingAssignmentPage = new ProgrammingAssignmentPage();
		programmingAssignmentPage.enterSolutionCode(codeSolution);
	}

	
	
	@Then("^user compile and run the code$")
	public void compileAndRun(){
		ProgrammingAssignmentPage programmingAssignmentPage = new ProgrammingAssignmentPage();
		programmingAssignmentPage.compileAndRun();
		
	}
	
	@Then("^user submit the code$")
	public void userSubmitTheCode(){
		ProgrammingAssignmentPage programmingAssignmentPage = new ProgrammingAssignmentPage();
		programmingAssignmentPage.submitCode();
		
	}
	
	
	@Then("^user select the Language preference as \"([^\"]*)\"$")
	public void userSetLanguage(String language) {
		ProgrammingAssignmentPage programmingAssignmentPage = new ProgrammingAssignmentPage();
		programmingAssignmentPage.setProgLanguage(language);
	}
	
	@Then("^user verifies answers of activity type lesson$")
	public void user_verifies_answers_of_activity_type_lesson(){
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.verifyActivityTypeLessonAnswers();
	}
	
	@Then("^user verifies the lesson video and vtt text$")
	public void user_verifies_the_lesson_video_and_vtt_text(DataTable dataTable) {
		ExplorerPage explorerPage = new ExplorerPage();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);

		String lessonTitle = list.get(0).get("Title");
		String lessonVideo = list.get(0).get("videoID");
		String vttText = list.get(0).get("vttText");

		explorerPage.verifylessonTitle(lessonTitle);
		explorerPage.verifyvideoOnLessonWithVtt(lessonVideo);
		explorerPage.verifyVttText(vttText);
	}
	 
	@Then("^user verifies the filename as \"([^\"]*)\"$")
	public void userVerifyFileNme(String fileName) {
		ProgrammingAssignmentPage programmingAssignmentPage = new ProgrammingAssignmentPage();
		programmingAssignmentPage.verifyFileName(fileName);
	}
	
	@Then("^user verifies MathJax type assessment content$")
	public void user_verifies_MathJax_type_assessment_content(DataTable dataTable){
		
		ExplorerPage explorerPage = new ExplorerPage();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);
		String assessmentTitle = list.get(0).get("Title");
		String mathjaxQuestion = list.get(0).get("MathJax Question");
		String points = list.get(0).get("Points");
		String submissionType = list.get(0).get("Submission Type");
		String showCorrectAnswer = list.get(0).get("Show Correct Answer");
		String dueDateFuture = list.get(0).get("Due Date");

		explorerPage.verifyAssessmentTitle(assessmentTitle);
		explorerPage.verifyAssessmentMathJaxQuestion(mathjaxQuestion);
		explorerPage.verifyAssessmentPoints(points);
		explorerPage.verifyAssessmentSubmissionType(submissionType);
		explorerPage.verifyCheckAns(showCorrectAnswer);
		explorerPage.verifyAssessmentDueDateFuture(dueDateFuture);
		
	}
	
	@Then("^user answers mathjax question$")
	public void user_answers_mathjax_question(){
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.answerMathjaxQuestion();
	}
	
	@Then("^user verifies numeric range type assessment content$")
	public void user_verifies_numeric_range_type_assessment_content(DataTable dataTable){
		
		ExplorerPage explorerPage = new ExplorerPage();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);
		String assessmentTitle = list.get(0).get("Title");
		String rangeTypeQuestion = list.get(0).get("Range Type Question");
		String numericQuestion = list.get(0).get("Numeric Question");
		String points = list.get(0).get("Points");
		String singleSubmission = list.get(0).get("Submission Type");
		String showCorrectAnswer = list.get(0).get("Show Correct Answer");
		String dueDateFuture = list.get(0).get("Due Date");

		explorerPage.verifyAssessmentTitle(assessmentTitle);
		explorerPage.verifyAssessmentQuestionRangeType(rangeTypeQuestion);
		explorerPage.verifyAssessmentQuestionNumericType(numericQuestion);
		explorerPage.verifyAssessmentPoints(points);
		explorerPage.verifyAssessmentSubmissionType(singleSubmission);
		explorerPage.verifyCheckAns(showCorrectAnswer);
		explorerPage.verifyAssessmentDueDateFuture(dueDateFuture);
		
	}
	
	@Then("^user answers range type question$")
	public void user_answers_range_type_question(){
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.answerRangeTypeQuestion();
	}
	
	@Then("^user answers numeric type question$")
	public void user_answers_numeric_type_question(){
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.answerNumericTypeQuestion();
	}
	
	@Then("^user verifies Short Answer type assessment content$")
	public void user_verifies_Short_Answer_type_assessment_content(DataTable dataTable){
		
		ExplorerPage explorerPage = new ExplorerPage();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);
		String assessmentTitle = list.get(0).get("Title");
		String shortAnsQuestion = list.get(0).get("Short Answer Question");
		String points = list.get(0).get("Points");
		String submissionType = list.get(0).get("Submission Type");
		String showCorrectAnswer = list.get(0).get("Show Correct Answer");
		String dueDateFuture = list.get(0).get("Due Date");

		explorerPage.verifyAssessmentTitle(assessmentTitle);
		explorerPage.verifyAssessmentShortAnswerQuestion(shortAnsQuestion);
		explorerPage.verifyAssessmentPoints(points);
		explorerPage.verifyAssessmentSubmissionType(submissionType);
		explorerPage.verifyCheckAns(showCorrectAnswer);
		explorerPage.verifyAssessmentDueDateFuture(dueDateFuture);
		
	}
	
	@Then("^user answers short answer question$")
	public void user_answers_short_answer_question(){
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.answerShortAnsQuestion();
	}
	
	@Then("^second user answers short answer question incorrectly$")
	public void second_user_answers_short_answer_question_incorrectly(){
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.answerShortAnsQuestionIncorrectly();
	}
	
	@Then("^second user answers short answer question incorrectly case insensitive starts with$")
	public void second_user_answers_short_answer_question_incorrectly_case_insensitive_starts_with(){
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.answerShortAnsQuestionIncorrectlyCaseInsensitiveStartsWith();
	}
	
	@Then("^second user answers short answer question incorrectly case insensitive ends with$")
	public void second_user_answers_short_answer_question_incorrectly_case_insensitive_ends_with(){
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.answerShortAnsQuestionIncorrectlyCaseInsensitiveEndsWith();
	}
	
	@Then("^second user answers short answer question incorrectly case insensitive and$")
	public void second_user_answers_short_answer_question_incorrectly_case_insensitive_and(){
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.answerShortAnsQuestionIncorrectlyCaseInsensitiveAnd();
	}
	
	@Then("^second user answers short answer question incorrectly case insensitive or$")
	public void second_user_answers_short_answer_question_incorrectly_case_insensitive_or(){
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.answerShortAnsQuestionIncorrectlyCaseInsensitiveOr();
	}
	
	@Then("^user answers short and or question$")
	public void user_answers_short_and_or_question(){
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.answerShortAndOrQuestion();
	}
	
	@Then("^user verifies assessment content$")
	public void user_verifies_assessment_content(DataTable dataTable){
		
		ExplorerPage explorerPage = new ExplorerPage();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);
		String assessmentTitle = list.get(0).get("Title");
		String question = list.get(0).get("Question");
		String points = list.get(0).get("Points");
		String singleSubmission = list.get(0).get("Submission Type");
		String showCorrectAnswer = list.get(0).get("Show Correct Answer");
		String dueDateFuture = list.get(0).get("Due Date");

		explorerPage.verifyAssessmentTitle(assessmentTitle);
		explorerPage.verifyAssessmentQuestion(question);
		explorerPage.verifyAssessmentPoints(points);
		explorerPage.verifyAssessmentSubmissionType(singleSubmission);
		explorerPage.verifyCheckAns(showCorrectAnswer);
		explorerPage.verifyAssessmentDueDateFuture(dueDateFuture);
		
	}
	
	@Then("^user select incorrect answer to question$")
	public void user_select_incorrect_answer_to_question(){
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.selectIncorrectAnswerToQuestion();
	}
	
	@Then("^user verified the due date passed message for SA \"([^\"]*)\"$")
	public void user_verified_the_due_date_passed_message_on_SA(String messageKey) {
		ExplorerPage explorerPage = new ExplorerPage();
		//explorerPage.verifyDuedatePassedMessageOnSA(messageKey);
	}
	
	@Then("^user verifies the subjective assingment content$")
	public void user_verifies_the_subjective_assignment_content(
			DataTable dataTable) {
		ProgrammingAssignmentPage progAssignmentPage = new ProgrammingAssignmentPage();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);
		String assignmentTitle = list.get(0).get("Title");
		String problemStatement = list.get(0).get("Problem Statement");
		String dueDate = list.get(0).get("Due Date");
		progAssignmentPage.verifyProgAssignmentTitle(assignmentTitle);
		progAssignmentPage.verifyProblemStatement(problemStatement);

		//progAssignmentPage.verifyAssignmentDueDate(dueDate);
	}
	
	@Then("^user enters the subjective assignment solution as \"([^\"]*)\"$")
	public void EnterSolution(String solution) {
		SubjectiveAssignmentPage subjectiveAssignmentPage = new SubjectiveAssignmentPage();
		subjectiveAssignmentPage.enterSubjectiveAssignmentSoluation(solution);
	}

	@Then("^user submits the assignment$")
	public void userSubmitSolution() {
		SubjectiveAssignmentPage subjectiveAssignmentPage = new SubjectiveAssignmentPage();
		subjectiveAssignmentPage.submitTheSolution();

	}

	@Then("^user verifies the confirmation message \"([^\"]*)\" for subjective assignment$")
	public void userVerifiesConfirmationMsg(String expectedMessage) {
		SubjectiveAssignmentPage subjectiveAssignmentPage = new SubjectiveAssignmentPage();
		subjectiveAssignmentPage.verifyAssignmentSubmission(expectedMessage);

	}

}
