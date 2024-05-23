package com.swayam.pages;

import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.swayam.base.Util;

public class ExplorerPage extends HomePage {

	final static Logger Log = Logger.getLogger(ExplorerPage.class.getName());
	Util Util = new Util();
	@FindBy(xpath = "//h2")
	WebElement pageHeading;

	@FindBy(id = "keyword-input")
	WebElement keywordSearchInput;

	@FindBy(xpath = "//div[@id='filter-input-div']/span/img")
	WebElement searchIcon;

	@FindBy(xpath = "//div[not(@hidden)]/course-card")
	List<WebElement> coursecardTile;

	@FindBy(tagName = "h1")
	WebElement coursePreviewTitle;

	@FindBy(id = "register-button")
	WebElement joinButton;

	@FindBy(className = "profileHead")
	WebElement profilePageTitle;

	@FindBy(id = "profession")
	WebElement professionField;

	@FindBy(id = "country_of_residence")
	WebElement countryField;

	@FindBy(id = "state_of_residence")
	WebElement stateField;

	@FindBy(id = "city_of_residence")
	WebElement cityField;
	
	@FindBy(id = "select2-local_chapter_college-container")
	WebElement localChapterCollege;
	
	@FindBy(xpath = "//input[@class='select2-search__field']")
	WebElement localChapterSearchbox;

	@FindBy(id = "industry_local_chapter_employer")
	WebElement localChapterIndustry;

	@FindBy(id = "terms")
	WebElement termsCheckbox;
	@FindBy(id = "honor_code")
	WebElement honorCodeCheckbox;

	@FindBy(id = "gcb-nav-course-title")
	WebElement navCourseTitle;

	@FindBy(id = "gcb-butterbar-message")
	WebElement butterbarMessage;

	@FindBy(css = ".blueBarTitle.style-scope.course-explorer")
	WebElement CourseCatalogTitle;

	@FindBy(id = "nc-select")
	WebElement NationalCoordinatorSelect;

	@FindBy(xpath = "//div[@id='noCourses']")
	WebElement emptySearchMsg;

	@FindBy(id = "unit_heading_1")
	WebElement unitNavbar;

	@FindBy(xpath = "//ul[@class='subunit_navbar_current']")
	WebElement subunitNavbar;

	@FindBy(className = "subunit_navbar_other")
	WebElement unitNavCollapsed;

	@FindBy(xpath = "//div[@class='gcb-assessment-contents']/h1")
	WebElement assessmentHeader;

//	@FindBy(id = "lesson_title_2")
	@FindBy(xpath = "//a[contains(@href,'lesson')]")
	WebElement lessonHeader;

	@FindBy(className = "gcb-valid-submission-due-date")
	WebElement assessmentDueDate;

	@FindBy(className = "gcb-submission-due-date")
	WebElement postAssessmentDueDate;

	@FindBy(className = "qt-question")
	WebElement assessmentQuestion;

	@FindBy(className = "gcb-mcq-choice")
	List<WebElement> questionOptionList;

	@FindBy(xpath = "//div[@class='gcb-mcq-choice']/input")
	List<WebElement> OptionChoiceList;

	@FindBy(className = "gcb-submit-only-once")
	WebElement messageForSubmission;

	@FindBy(className = "qt-points")
	WebElement questionPoints;

	@FindBy(id = "submitbutton")
	WebElement submitBtn;

	@FindBy(xpath = "//div[@id='assessmentContents']/following-sibling::div[1]")
	WebElement submissionStatus;

	@FindBy(xpath = "//div[@id='gcb-main-article']/div[@class='gcb-button-box']")
	WebElement confirmationMsg;

	@FindBy(className = "feedback-header")
	WebElement feedback;

	@FindBy(className = "assessment-top-info")
	WebElement dueDatePassedTxt;

	//@FindBy(className = "gcb-student-data-table")
	@FindBy(xpath = "//span[contains(@id,'assessment-score')]")
	WebElement studentProgressTable;

	@FindBy(id = "college_roll_no")
	WebElement studentRollNumber;

	@FindBy(id = "student_degree")
	WebElement studentDegreeSelect;

	@FindBy(id = "student_department")
	WebElement studentDepartmentSelect;
	
	@FindBy(id = "faculty_area")
	WebElement facultyAreaSelect;
	
	@FindBy(id = "faculty_department")
	WebElement facultyDepartmentSelect;

	@FindBy(id = "study_year")
	WebElement studyYearSelect;

	@FindBy(className = "gcb-lesson-content")
	WebElement lessonContent;

	@FindBy(id = "editProfileBtn")
	WebElement editProfileAndJoin;

	@FindBy(id = "videoDiv")
	WebElement videoDiv;

	@FindBy(xpath = "//*[@id='videoDiv'][contains(@src,'6xFaXIwwq0s')]")
	WebElement lessonVideo;

//	@FindBy(xpath = "//*[@id='Ongoing']/div[@class='learnerCard'][1]//button")
	@FindBy(xpath = "//a/button/span[contains(.,'Go to Course')]")
	WebElement btnGoToCourse;

	@FindBy(xpath = "//a[@href='/mycourses/sync']/span")
	WebElement btnSyncYourCourses;

	@FindBy(xpath = "//a[@class='gcb-nav-course-title']")
	WebElement courseTitle;

	@FindBy(xpath = "//*[@id='videoDiv'][contains(@src,'e0nkkKDjY50')]")
	WebElement lessonVideoVtt;

	@FindBy(xpath = "//*[@id='video-transcript-div']/div[1][contains(.,'Hello, welcome to this course on Renewable')]")
	WebElement vttTextToVerify;

	@FindBy(id = "transcript_dropdown")
	WebElement transcriptLanguage;

	@FindBy(xpath = "//*[@class='gcb-mcq-choice']/label[contains(text(),'A')]//preceding-sibling::input")
	WebElement radioBtnA;

	@FindBy(xpath = "//*[@class='gcb-mcq-choice']/label[contains(text(),'B')]//preceding-sibling::input")
	WebElement radioBtnB;

	@FindBy(xpath = "//*[@class='gcb-mcq-choice']/label[contains(text(),'C')]//preceding-sibling::input")
	WebElement radioBtnC;

	@FindBy(xpath = "//*[@class='gcb-mcq-choice']/label[contains(text(),'D')]//preceding-sibling::input")
	WebElement radioBtnD;

	@FindBy(css = ".qt-check-answer-button")
	WebElement checkAnswerBtn;

	@FindBy(xpath = "//*[@class='feedback-header']/span[contains(text(),'Yes, the answer is correct')]")
	WebElement correctAnsMsg;

	@FindBy(xpath = "//*[@class='feedback-header']/span[contains(text(),'No, the answer is incorrect')]")
	WebElement wrongAnsMsg;

	@FindBy(className = "gcb-assessment-body")
	WebElement assessmentBody;

	@FindBy(xpath = "//div[contains(text(),'Enter')]//parent::div//following-sibling::div//input")
	WebElement txtRangeTypeAnswer;

	@FindBy(xpath = "//div[contains(text(),'Pi')]//parent::div//following-sibling::div//input")
	WebElement txtNumericTypeAnswer;

	@FindBy(xpath = "//div[@class='qt-response']/input")
	WebElement txtAnswer;

	@FindBy(xpath = "//*[@id='MathJax-Element-1'][contains(.,'x = {-b <\\pm \\sqrt{b^2-4ac}> \\over 2a}.')]")
	WebElement mathjaxQuestionTitle;

	@FindBy(xpath = "//div[@class='qt-choices']/div[@class='gcb-mcq-choice'][1]/input")
	WebElement radioMathjaxChoice1;

	Select select = null;

	public ExplorerPage() {
		super();
	}

	public void enterSearchKeyword(String searchKeyword) {
		String courseName = prop.getProperty(searchKeyword);
		Log.info("Entering search keyword on saerch field as " + searchKeyword);
		Util.waitForElementsToPresent(By.id("loading-img"), 20);
		//Assert.assertTrue(driver.findElement(By.id("loading-img")).isDisplayed());
		Util.waitForElementToPresent(keywordSearchInput, 30);
		keywordSearchInput.clear();
		keywordSearchInput.sendKeys(courseName);
		Util.WaitForElementToBeClickable(searchIcon, 20);
		searchIcon.click();
	}

	public void verifySearchResults(String courseName) {
		courseName = prop.getProperty(courseName);
		Log.info("verifying search results contains course name " + courseName);
		Util.waitForElementsToPresent(By.xpath("//div[not(@hidden)]/course-card"), 30);
		Assert.assertEquals(coursecardTile.size(), 1);
	}

	public void verifyCourseNotPresent(String msg) {
		Log.info("verifying no result found message");
		Util.waitForElementToPresent(emptySearchMsg, 30);
		Assert.assertEquals(coursecardTile.size(), 0);
	}

	public void clickOnTheCourse(String courseName) {
		Log.info("Clicking on course card by its name -" + courseName);
		courseName = prop.getProperty(courseName);
		Util.scrollToElement(keywordSearchInput);
		Util.clickOnCourse(courseName);
		Util.waitForElementToPresent(coursePreviewTitle, 20);

		Assert.assertEquals(coursePreviewTitle.getText(), courseName);

	}

	public void verifyCourseTitleOnDetailPage(String expectedTitle) {
		Log.info("verifying course title on detail page -" + expectedTitle);
		String actutalTitle = coursePreviewTitle.getText();
		Assert.assertEquals(actutalTitle, prop.getProperty(expectedTitle));
	}

	public void joinTheCourse() {
		Log.info("clicking on Join button on detail page");
		joinButton.click();
	}

	public void selectLocalChapterOnProfileUpdatePageold() {
		Log.info("Verifying that user is on Profile page");
		Assert.assertEquals(profilePageTitle.getText().trim(), "Update Profile");
		Util.selectAnOption(countryField, "United Kingdom");
		if (!Util.getSelctedOption(professionField).equals("Student"))
			Util.selectAnOption(professionField, "Student");
		Log.info("seleting local Chapter College on Profile page as LC_QA,Bristol, Bristol");
		// Util.selectAnOption(stateField, "Bristol");
		Util.selectAnOption(localChapterCollege, "LC_QA, Bristol, BRISTOL");
		termsCheckbox.click();
		honorCodeCheckbox.click();
		Util.clickOnButton("Update Profile and join course");
		Util.waitForElementToPresent(butterbarMessage, 20);
		Log.info("verifying that user has successfully joined the course by thanking confirmation message");
		Assert.assertTrue(butterbarMessage.getText().equals(prop.getProperty("course.join.message")));

	}

	public void selectNonIndianLocalChapterOnProfileUpdatePage() {
		String lcName = prop.getProperty("lc.int.name");
		String lcCity = prop.getProperty("lc.int.city");
		String lcState = prop.getProperty("lc.int.state");
		String lcCountry = prop.getProperty("lc.int.country");

		Log.info("Verifying that user is on Profile page");
		Assert.assertEquals(profilePageTitle.getText().trim(), "Update Profile");
		if (!Util.getSelctedOption(professionField).equals("Student"))
			Util.selectAnOption(professionField, "Student");
		String lcFullName = lcName + ", " + lcCity + ", " + lcState.toUpperCase();
		Log.info("seleting local Chapter College on Profile page as " + lcFullName);
		// Log.info("seleting local Chapter College on Profile page as LC_QA,
		// Chennai, DAMAN AND DIU");
		// Log.info("seleting local Chapter College on Profile page as" +
		// lcFullName +", "+ lcCity+", "+lcState);
		Util.selectAnOption(countryField, lcCountry);
		Util.selectAnOption(stateField, lcState);
		Util.selectAnOption(localChapterCollege, lcFullName);

		termsCheckbox.click();
		honorCodeCheckbox.click();
		Util.clickOnButton("Update Profile and join course");
		// Util.waitForElementToPresent(butterbarMessage, 20);
		Log.info("verifying that user has successfully joined the course by thanking confirmation message");
		// Assert.assertTrue(butterbarMessage.getText().equals(prop.getProperty("course.join.message")));

	}
	
	public void selectNonIndianLocalChapterOnProfileUpdatePageFaculty() {
		String lcName = prop.getProperty("lc.int.name");
		String lcCity = prop.getProperty("lc.int.city");
		String lcState = prop.getProperty("lc.int.state");
		String lcCountry = prop.getProperty("lc.int.country");

		Log.info("Verifying that user is on Profile page");
		Assert.assertEquals(profilePageTitle.getText().trim(), "Update Profile");
		if (!Util.getSelctedOption(professionField).equals("Faculty"))
			Util.selectAnOption(professionField, "Faculty");
		String lcFullName = lcName + ", " + lcCity + ", " + lcState.toUpperCase();
		Log.info("seleting local Chapter College on Profile page as " + lcFullName);
		// Log.info("seleting local Chapter College on Profile page as LC_QA,
		// Chennai, DAMAN AND DIU");
		// Log.info("seleting local Chapter College on Profile page as" +
		// lcFullName +", "+ lcCity+", "+lcState);
		Util.selectAnOption(countryField, lcCountry);
		Util.selectAnOption(stateField, lcState);
		// Util.selectAnOption(localChapterCollege, lcFullName);
		Util.waitForElementToPresent(localChapterCollege, 20);
		localChapterCollege.click();
		Util.waitForElementToPresent(localChapterSearchbox, 30);
		localChapterSearchbox.clear();
		localChapterSearchbox.sendKeys(lcFullName);
		
		termsCheckbox.click();
		honorCodeCheckbox.click();
		Util.clickOnButton("Update Profile and join course");
		// Util.waitForElementToPresent(butterbarMessage, 20);
		Log.info("verifying that user has successfully joined the course by thanking confirmation message");
		// Assert.assertTrue(butterbarMessage.getText().equals(prop.getProperty("course.join.message")));

	}

	public void selectIndianLocalChapterOnProfileUpdatePage() {
		String lcName = "";
		String lcCity = "";
		String lcState = "";
		String lcCountry = "";
		if (Util.isProd()) {
			lcName = prop.getProperty("lc.prod.name");
			lcCity = prop.getProperty("lc.prod.city");
			lcState = prop.getProperty("lc.prod.state");
			lcCountry = prop.getProperty("lc.prod.country");
		} else {
			lcName = prop.getProperty("lc.ind.name");
			lcCity = prop.getProperty("lc.ind.city");
			lcState = prop.getProperty("lc.ind.state");
			lcCountry = prop.getProperty("lc.ind.country");
		}

		Log.info("Verifying that user is on Profile page");
		Assert.assertEquals(profilePageTitle.getText().trim(), "Update Profile");
		if (!Util.getSelctedOption(professionField).equals("Student"))
			Util.selectAnOption(professionField, "Student");
		String lcFullName = lcName + ", " + lcCity + ", " + lcState.toUpperCase();
		Log.info("seleting local Chapter College on Profile page as " + lcFullName);
		Log.info("seleting local Chapter College on Profile page as LC_QA, Chennai, DAMAN AND DIU");
		Util.selectAnOption(countryField, lcCountry);
		Util.selectAnOption(stateField, lcState);
//		Util.selectAnOption(localChapterCollege, lcFullName);
		Util.waitForElementToPresent(localChapterCollege, 30);
		localChapterCollege.click();
		Util.waitForElementToPresent(localChapterSearchbox, 30);
		localChapterSearchbox.clear();
		localChapterSearchbox.sendKeys(lcFullName);
		
		if (studentRollNumber.getAttribute("value").isEmpty())
			studentRollNumber.sendKeys("1234");
		Util.selectAnOption(studentDegreeSelect, "BE");
		Util.selectAnOption(studentDepartmentSelect, "Planning");
		Util.selectAnOption(studyYearSelect, "1st Year");
		termsCheckbox.click();
		honorCodeCheckbox.click();
		Util.clickOnButton("Update Profile and join course");
		// Util.waitForElementToPresent(butterbarMessage, 20);
		Log.info("verifying that user has successfully joined the course by thanking confirmation message");
		// Assert.assertTrue(butterbarMessage.getText().equals(prop.getProperty("course.join.message")));
		Util.waitForElementToPresent(courseTitle, 20);
		Log.info("User has successfully joined the course");
	}
	
	public void selectIndianLocalChapterOnProfileUpdatePageFaculty() {
		String lcName = "";
		String lcCity = "";
		String lcState = "";
		String lcCountry = "";
		if (Util.isProd()) {
			lcName = prop.getProperty("lc.prod.name");
			lcCity = prop.getProperty("lc.prod.city");
			lcState = prop.getProperty("lc.prod.state");
			lcCountry = prop.getProperty("lc.prod.country");
		} else {
			lcName = prop.getProperty("lc.ind.name");
			lcCity = prop.getProperty("lc.ind.city");
			lcState = prop.getProperty("lc.ind.state");
			lcCountry = prop.getProperty("lc.ind.country");
		}

		Log.info("Verifying that user is on Profile page");
		Assert.assertEquals(profilePageTitle.getText().trim(), "Update Profile");
		if (!Util.getSelctedOption(professionField).equals("Faculty"))
			Util.selectAnOption(professionField, "Faculty");
		String lcFullName = lcName + ", " + lcCity + ", " + lcState.toUpperCase();
		Log.info("seleting local Chapter College on Profile page as " + lcFullName);
		Log.info("seleting local Chapter College on Profile page as LC_QA, Chennai, DAMAN AND DIU");
		Util.selectAnOption(countryField, lcCountry);
		Util.selectAnOption(stateField, lcState);
//		Util.selectAnOption(localChapterCollege, lcFullName);
		Util.waitForElementToPresent(localChapterCollege, 20);
		localChapterCollege.click();
		Util.waitForElementToPresent(localChapterSearchbox, 30);
		localChapterSearchbox.clear();
		localChapterSearchbox.sendKeys(lcFullName);
//		if (studentRollNumber.getAttribute("value").isEmpty())
//			studentRollNumber.sendKeys("1234");
//		Util.selectAnOption(studentDegreeSelect, "BE");
		Util.selectAnOption(facultyAreaSelect, "Medical");
		Util.selectAnOption(facultyDepartmentSelect, "MD");
//		Util.selectAnOption(studyYearSelect, "1st Year");
		termsCheckbox.click();
		honorCodeCheckbox.click();
		Util.clickOnButton("Update Profile and join course");
		// Util.waitForElementToPresent(butterbarMessage, 20);
		Log.info("verifying that user has successfully joined the course by thanking confirmation message");
		// Assert.assertTrue(butterbarMessage.getText().equals(prop.getProperty("course.join.message")));
		Util.waitForElementToPresent(courseTitle, 20);
		Log.info("User has successfully joined the course");
	}

	public void selectIndustryLocalChapterOnProfileUpdatePage() {
		String lcName = "";
		String lcCountry = "";

		lcName = prop.getProperty("lc.indus.name");
		lcCountry = prop.getProperty("lc.indus.country");

		Log.info("Verifying that user is on Profile page");
		Assert.assertEquals(profilePageTitle.getText().trim(), "Update Profile");
		if (!Util.getSelctedOption(professionField).equals("Employed"))
			Util.selectAnOption(professionField, "Employed");
		Log.info("seleting local Chapter Industry on Profile page as " + lcName);
		Util.selectAnOption(countryField, lcCountry);
		Util.selectAnOption(localChapterIndustry, lcName.trim());
		termsCheckbox.click();
		honorCodeCheckbox.click();
		Util.clickOnButton("Update Profile and join course");
		Util.waitForElementToPresent(butterbarMessage, 20);
		Log.info("verifying that user has successfully joined the course by thanking confirmation message");
		Assert.assertTrue(butterbarMessage.getText().equals(prop.getProperty("course.join.message")));
	}
	
	public void GotoCourseEntity(String entityName) {
		// if (unitNavCollapsed.isDisplayed())
		entityName = prop.getProperty(entityName);
		if (!Util.isElementPresentByClassname("subunit_navbar_current")) {
			Util.waitForElementToPresent(unitNavbar, 20);
			unitNavbar.click();
		}

		Util.clickUsingPartialText(entityName);

	}

	public void verifyEntityHeader(String header) {

	}

	/*
	 * public void () { Util.clearCacheChrome();
	 * driver.get(prop.getProperty("baseURL"));
	 * 
	 * }
	 */

	public void verifyExplorerProject() {
		Util.waitForElementToPresent(pageHeading, 10);
		String expecetedHeading = prop.getProperty("explorerpage.heading");
		Assert.assertTrue(pageHeading.getText().equals(expecetedHeading));
	}

	public void selectAFilter(String filterName) {
		Log.info("Selecting a filter value by its name " + filterName);
		String locator = String.format(prop.getProperty("explorer.generic.filter"), filterName);
		WebElement filter = Util.waitForElementToPresent(locator, 10);
		filter.click();
		select = new Select(filter);
	}

	public void verifyFilterOptions(List<String> ExpectedFilterOptions) {

		List<String> actualFilterOptions = new ArrayList<String>();
		for (WebElement e : select.getOptions()) {
			Log.info("verifying a filter options by its name " + e.getText());
			actualFilterOptions.add(e.getText());
		}
		Assert.assertTrue(actualFilterOptions.equals(ExpectedFilterOptions));
	}

	public String getCourseContentElement(String key, String courseName) {
		String loc = Util.getFormatedLocator(key, courseName);
		WebElement element = Util.waitForElementToPresent(loc, 10);
		return element.getText();

	}

	public void verifyCourseCardContent() {
		String courseName = prop.getProperty("course.name");
		String loc = Util.getFormatedLocator("central.course.content", courseName);
		Log.info("Verifying course name on course card on explorer page as " + courseName);
		WebElement element = Util.waitForElementToPresent(loc, 10);
		Util.scrollToElement(element);
		Assert.assertTrue(element.isDisplayed());
	}

	public void verifyCourseWeek(String weeks) {
		String courseName = prop.getProperty("course.name");
		String courseContentCredits = getCourseContentElement("central.course.week", courseName);
		Log.info("Verifying course weeks on course card on explorer page as " + weeks);
		Assert.assertTrue(courseContentCredits.equalsIgnoreCase(weeks));
	}

	public void verifySearchFieldIsPresent() {
		Log.info("Verifying search field is present on explorer page");
		Util.WaitForElementToBeClickable(keywordSearchInput, 10);
		assertEquals(keywordSearchInput.isDisplayed(), true);
	}

	public void verifySearchIconIsPresent() {
		Log.info("Verifying search icon is present on explorer page");
		Util.WaitForElementToBeClickable(searchIcon, 10);
		assertEquals(searchIcon.isDisplayed(), true);
	}

	public void verifySearchPlaceHolder(String placeHolder) {
		Log.info("Verifying search placeholder text  is " + placeHolder);
		Util.WaitForElementToBeClickable(keywordSearchInput, 10);
		assertEquals(keywordSearchInput.getAttribute("placeholder").equals(placeHolder), true);
	}

	public void clickonUserManu(String linkname) {
		Util.clickOnUserLink(linkname);
	}

	public void verifyUserOnCourseCatalogPage() {
		Log.info("Verifying course catalog/explorer page");
		Util.waitForElementToPresent(CourseCatalogTitle, 20);
		assertEquals(CourseCatalogTitle.getText(), "Course Catalog");
	}

	public void verifyNationalCoordinatorFilterValue(String ncName) {
		Log.info("Verifying National coordinator filter selected value is " + ncName);
		assertEquals(Util.getSelctedOption(NationalCoordinatorSelect), ncName);
	}

	public void verifyInstructorNameOnCard(String instructorName) {
		String courseName = prop.getProperty("course.name");
		String courseInstructorName = getCourseContentElement("central.course.instructor", courseName);
		Log.info("Verifying course Instructor name on the card as " + instructorName);
		Assert.assertEquals(courseInstructorName, prop.getProperty(instructorName));

	}

	public void verifyinstructorInstituteOnCard(String instructorInstitute) {
		String courseName = prop.getProperty("course.name");
		String courseInstituteName = getCourseContentElement("central.course.institute", courseName).trim();
		Log.info("Verifying course Instructor institute name on the card as " + instructorInstitute);
		Assert.assertEquals(courseInstituteName, prop.getProperty(instructorInstitute));
	}

	public void verifyNcNameOnCard(String ncName) {
		String courseName = prop.getProperty("course.name");
		String courseNcName = getCourseContentElement("central.course.nc", courseName);
		Log.info("Verifying NC name on the card as " + ncName);
		Assert.assertEquals(courseNcName, ncName);
	}

	public void goToTab(String tabName) {
		Log.info("Going to " + tabName + " tab");
		WebElement tab = driver.findElement(By.xpath(Util.getFormatedLocator("central.explorer.tab", tabName)));
		tab.click();
	}

	public void verifyAssessmentTitle(String assessmentTitle) {
		Log.info("verifying assessment title");
		Util.waitForElementToPresent(assessmentHeader, 10);
		Assert.assertEquals(assessmentHeader.getText(), prop.getProperty(assessmentTitle));
	}

	public void verifylessonTitle(String lessonTitle) {
		Log.info("verifying lesson title");
		Util.waitForElementToPresent(lessonHeader, 10);
		Assert.assertEquals(lessonHeader.getText().trim(), prop.getProperty(lessonTitle));
	}

	public void verifyAssessmentQuestion(String question) {
		Log.info("verifying assessment question statement");
		Util.waitForElementToPresent(assessmentQuestion, 20);
		Assert.assertEquals(assessmentQuestion.getText(), prop.getProperty(question));
	}

	public void verifyAsssessmentOptions(String questionOptions) {
		Log.info("verifying assessment options");
		String[] optionArr = prop.getProperty(questionOptions).split(",");
		// String actualOptions = "";
		if (optionArr.length == questionOptionList.size()) {
			for (int i = 0; i < optionArr.length; i++) {
				Assert.assertEquals(questionOptionList.get(i).getText(), optionArr[i]);
			}
		}

		else {
			Assert.assertTrue(false, "Options number mismatch");

		}
	}

	public void verifyAssessmentPoints(String points) {
		Log.info("verifying assessment points");
		Assert.assertEquals(questionPoints.getText().trim(), prop.getProperty(points) + " point");
	}

	public void verifyCheckAns(String showCorrectAnswer) {

	}

	public boolean verifyAssessmentSubmissionType(String singleSubmission) {

		Log.info("verifying assessment submisson type");

		String actualMsg = messageForSubmission.getText().trim();
		System.out.println(actualMsg);
		boolean flag = false;
		switch (singleSubmission.toUpperCase()) {
		case "MULTIPLE":
			flag = actualMsg.equals(prop.getProperty("assessment.multi.submission.msg"));
			break;
		case "SINGLE":
			flag = actualMsg.equals(prop.getProperty("assessment.single.submission.msg"));
			break;

		default:
			Log.info("Please select correct choice for submission type");
			break;
		}
		return flag;

	}

	public void verifyAssessmentDueDate(String dueDate) {
		Log.info("verifying assessment due date");
		Util.waitForElementToPresent(assessmentHeader, 15);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		System.out.println("Calendar DAy of Month is : " + Calendar.DAY_OF_MONTH);
		System.out.println("Due Date is : " + dueDate);
		System.out.println("Assessment Date is : " + prop.getProperty("assessment.date"));
		c.set(Calendar.DAY_OF_MONTH, Integer.valueOf(prop.getProperty(dueDate)));
		String date = sdf.format(c.getTime());
		Util.waitForElementToPresent(assessmentDueDate, 15);
		Assert.assertTrue(assessmentDueDate.getText().trim().contains(date));
	}

	public void verifyAssessmentDueDateFuture(String dueDateFuture) {

		Log.info("verifying assessment due date");
		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plusDays(1);
		dueDateFuture = tomorrow.toString();
		Util.waitForElementToPresent(assessmentDueDate, 15);
		Assert.assertTrue(assessmentDueDate.getText().trim().contains(dueDateFuture));
		Log.info("Due Date for future has been verified.");
	}

	public void verifyPostAssessmentDueDate(String dueDate) {
		Log.info("verifying assessment due date after due date");
		Util.waitForElementToPresent(assessmentHeader, 15);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, Integer.valueOf(prop.getProperty(dueDate)));
		String date = sdf.format(c.getTime());
		Util.waitForElementToPresent(postAssessmentDueDate, 15);
		Assert.assertTrue(postAssessmentDueDate.getText().trim().contains(date));
	}

	public void verifyAssessmentDueDatePast(String dueDatePast) {

		Log.info("verifying assessment due date after due date");
		Util.waitForElementToPresent(assessmentHeader, 15);
		LocalDate today = LocalDate.now();
		LocalDate yesterday = today.minusDays(1);
		dueDatePast = yesterday.toString();
		Util.waitForElementToPresent(postAssessmentDueDate, 15);
		Assert.assertTrue(postAssessmentDueDate.getText().trim().contains(dueDatePast));
		Log.info("Due Date for past has been verified.");
	}

	public void verifyAssessmentSubmissionMessage(String msgKey, String entityName) {
		Log.info("verfying assessment submission message");
		msgKey = String.format(prop.getProperty(msgKey), prop.getProperty(entityName));
		Util.waitForElementToPresent(confirmationMsg, 5);
		Assert.assertEquals(confirmationMsg.getText(), msgKey);

	}

	public void submitAssessment() {
		Log.info("submitting the assessment");
		submitBtn.click();
	}

	public void chooseAnOption(String option) {

		int index = 0;
		switch (option.toUpperCase()) {
		case "FIRST":
			index = 0;
			break;
		case "SECOND":
			index = 1;
			break;
		case "THIRD":
			index = 2;
			break;
		case "FOURTH":
			index = 3;
			break;
		case "FIFTH":
			index = 4;
			break;
		default:
			Log.info("Please select correct choice for submission");
			break;
		}

		OptionChoiceList.get(index).click();
	}

	public void clickOnUserdropdownLink(String linkName) {
		Log.info("clicking on user drop down link on explorer page");
		Util.clickUsingPartialText(linkName);

	}

	public void clickTermsAndCondCheckbox() {
		Log.info("clicking on terms and condition checkbox");
		termsCheckbox.click();
	}

	public void clickHonorCodeCheckbox() {
		Log.info("clicking on honor code checkbox");
		honorCodeCheckbox.click();
	}

	public void verifyAssessmentResult(String expectedResult) {
		Log.info("verifying assessment results");
		Assert.assertEquals(feedback.getText().trim(), prop.getProperty(expectedResult));
	}

	public void verifyDuedatePassedMessage(String messageKey) {
		Log.info("verifying due date passed message");
		Assert.assertTrue(dueDatePassedTxt.getText().contains(prop.getProperty(messageKey)));
	}

	public void verifyScoreOnProgressPage(String entityName, String expectedScore) {
		Log.info("verifying scores on student progress page");
		entityName = prop.getProperty(entityName);
		Util.waitForElementToPresent(studentProgressTable, 20);
		String entityScoreLocator = Util.getFormatedLocator("progress.entity.score", entityName);
		String actualScore = driver.findElement(By.xpath(entityScoreLocator)).getText();
		Log.info(actualScore);
		Assert.assertEquals(actualScore, expectedScore);

	}

	public void verifyvideoOnLesson(String videoID) {

		Log.info("verifying lesson video");
		Util.waitForElementToPresent(videoDiv, 40);

		Util.waitForElementToPresent(lessonVideo, 40);

	}

	public void verifylessonBody(String lessonBody) {
		Log.info("verifying lesson body");
		Assert.assertEquals(lessonContent.getText().trim(), prop.getProperty(lessonBody));

	}

	public void clickOnGoToCourseButton() {
		Log.info("Clicking on Go to Course button for first project to navigate to Node");
		Util.waitForElementToPresent(btnGoToCourse, 20);
		btnGoToCourse.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickonSyncYourCourses() {
		Log.info("Clicking on SYNC YOUR COURSES button");
		Util.waitForElementToPresent(btnSyncYourCourses, 20);
		btnSyncYourCourses.click();
		Util.waitForElementToPresent(btnGoToCourse, 20);
	}

	public void verifyActivityTypeLessonAnswers() {
		Log.info("Verifying Activity Type Lesson answers");

		Util.waitForElementToPresent(checkAnswerBtn, 10);
		Util.scrollToElement(checkAnswerBtn);

		Util.waitForElementToPresent(radioBtnA, 10);

		driver.findElement(
				By.xpath("//*[@class='gcb-mcq-choice']/label[contains(text(),'A')]//preceding-sibling::input")).click();
		checkAnswerBtn.click();
		Util.waitForElementToPresent(correctAnsMsg, 10);

		driver.findElement(
				By.xpath("//*[@class='gcb-mcq-choice']/label[contains(text(),'B')]//preceding-sibling::input")).click();
		checkAnswerBtn.click();
		Util.waitForElementToPresent(wrongAnsMsg, 10);

		driver.findElement(
				By.xpath("//*[@class='gcb-mcq-choice']/label[contains(text(),'C')]//preceding-sibling::input")).click();
		checkAnswerBtn.click();
		Util.waitForElementToPresent(wrongAnsMsg, 10);

		driver.findElement(
				By.xpath("//*[@class='gcb-mcq-choice']/label[contains(text(),'D')]//preceding-sibling::input")).click();
		checkAnswerBtn.click();
		Util.waitForElementToPresent(wrongAnsMsg, 10);
	}

	public void verifyvideoOnLessonWithVtt(String videoID) {

		Log.info("verifying lesson video with vtt");
		Util.waitForElementToPresent(videoDiv, 40);
		Util.waitForElementToPresent(lessonVideoVtt, 40);
	}

	public void verifyVttText(String vttText) {
		Log.info("verifying transcript language dropdown");

		Util.waitForElementToPresent(transcriptLanguage, 20);
		Util.scrollToElement(transcriptLanguage);

		Log.info("verifying vtt text");
		Util.waitForElementToPresent(vttTextToVerify, 20);
		Util.scrollToElement(vttTextToVerify);
	}

	public void answerMathjaxQuestion() {

		Util.waitForElementToPresent(radioMathjaxChoice1, 20);
		radioMathjaxChoice1.click();
	}

	public void verifyAssessmentShortAnswerQuestion(String shortAnsQuestion) {

		shortAnsQuestion = prop.getProperty(shortAnsQuestion);
		driver.findElement(By.xpath("//div[@class='qt-question  '][contains(.,'" + shortAnsQuestion + "')]"));
		Log.info("verified that short answer question is visible to user");

	}

	public void verifyAssessmentMathJaxQuestion(String mathjaxQuestion) {

		// mathjaxQuestion = prop.getProperty(mathjaxQuestion);
		driver.findElement(By.xpath("//div[@class='gcb-assessment-body'][contains(.,'" + mathjaxQuestion + "')]"));

		String mathjaxExpression = prop.getProperty("assessment.mathjax.expression");
		String mathjaxOption1 = prop.getProperty("assessment.mathjax.choice1");
		String mathjaxOption2 = prop.getProperty("assessment.mathjax.choice2");

		System.out.println("Question is " + mathjaxExpression);
		System.out.println("Choice1 is " + mathjaxOption1);
		System.out.println("Choice2 is " + mathjaxOption2);

//		driver.findElement(
//				By.xpath("//*[@id='MathJax-Element-1'][contains(.,'x = {-b <\\pm \\sqrt{b^2-4ac}> \\over 2a}.')]"));
		
//		driver.findElement(
//				By.xpath("//script[contains(.,'over 2a}.')]"));

//		driver.findElement(By.xpath("//*[@id='MathJax-Element-1'][contains(.,'" + mathjaxExpression + "')]"));
//		driver.findElement(By.xpath("//*[@id='MathJax-Element-2'][contains(.,'" + mathjaxOption1 + "')]"));
//		driver.findElement(By.xpath("//*[@id='MathJax-Element-3'][contains(.,'" + mathjaxOption2 + "')]"));

		Log.info("verified that MathJax question is visible to user");

	}

	public void verifyAssessmentQuestionRangeType(String rangeTypeQuestion) {
		Log.info("verifying Range type question");
		Util.waitForElementToPresent(assessmentBody, 10);
		String assessmentBodyText = prop.getProperty(rangeTypeQuestion);
		String[] locatorText = assessmentBody.getText().split("\\R");
		Assert.assertEquals(locatorText[1], assessmentBodyText);
	}

	public void verifyAssessmentQuestionNumericType(String numericQuestion) {
		Log.info("verifying Range type question");
		Util.waitForElementToPresent(assessmentBody, 10);
		String assessmentBodyText = prop.getProperty(numericQuestion);
		String[] locatorText = assessmentBody.getText().split("\\R");
		Assert.assertEquals(locatorText[4], assessmentBodyText);
	}

	public void answerRangeTypeQuestion() {

		Util.waitForElementToPresent(txtRangeTypeAnswer, 10);
		txtRangeTypeAnswer.sendKeys("0.5");
	}

	public void answerNumericTypeQuestion() {
		Util.waitForElementToPresent(txtNumericTypeAnswer, 10);
		txtNumericTypeAnswer.sendKeys("3.14");

	}

	public void answerShortAnsQuestion() {

		Util.waitForElementToPresent(txtAnswer, 10);
	//	txtAnswer.sendKeys("SwAyAM Is Great plaTFOrm fOr eLeANRing.");
		txtAnswer.sendKeys("Swayam is great platform for eLearning.");
	}
	
	public void answerShortAnsQuestionIncorrectly() {

		Util.waitForElementToPresent(txtAnswer, 10);
		txtAnswer.sendKeys("SwAyAM Is GOOD plaTFOrm fOr eLeANRing.");
	}
	
	public void answerShortAnsQuestionIncorrectlyCaseInsensitiveStartsWith() {

		Util.waitForElementToPresent(txtAnswer, 10);
		String answer = prop.getProperty("assessment.short.answer");
		txtAnswer.sendKeys("For me, "+ answer);
	}
	
	public void answerShortAnsQuestionIncorrectlyCaseInsensitiveEndsWith() {

		Util.waitForElementToPresent(txtAnswer, 10);
		String answer = prop.getProperty("assessment.short.answer");
		txtAnswer.sendKeys(answer + " For me !");
	}
	
	public void answerShortAnsQuestionIncorrectlyCaseInsensitiveAnd() {

		Util.waitForElementToPresent(txtAnswer, 10);
		txtAnswer.sendKeys("Swayam is great");
	}
	
	public void answerShortAnsQuestionIncorrectlyCaseInsensitiveOr() {

		Util.waitForElementToPresent(txtAnswer, 10);
		txtAnswer.sendKeys("   ");
	}

	public void answerShortAndOrQuestion() {

		Util.waitForElementToPresent(txtAnswer, 10);
		String answer = prop.getProperty("assessment.answer.comma.separated");
		txtAnswer.sendKeys(answer);
	}

	public void selectIncorrectAnswerToQuestion() {
		Log.info("Selecting incorrect answer to auto graded assignment question");

		driver.findElement(
				By.xpath("//*[@class='gcb-mcq-choice']/label[contains(text(),'B')]//preceding-sibling::input")).click();
	}

}
