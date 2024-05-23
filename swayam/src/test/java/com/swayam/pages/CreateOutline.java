package com.swayam.pages;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.ListIterator;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.swayam.base.Util;

public class CreateOutline extends HomePage {

	final static Logger Log = Logger.getLogger(CreateOutline.class.getName());

	Util Util = new Util();
	@FindBy(name = "title")
	WebElement titleField;

	@FindBy(name = "availablity")
	WebElement availabilitySelect;

	@FindBy(name = "weight")
	WebElement assessmentPoints;

	@FindBy(xpath = "//label[.='Due Date']/parent::div/following-sibling::div//input")
	WebElement assessmentDueDate;

	@FindBy(id = "edit-course")
	WebElement courseLink;

	@FindBy(name = "course:credits")
	WebElement courseCreditSelect;

	@FindBy(xpath = "//input[@name='course:show_in_explorer']/preceding-sibling::input")
	WebElement pushToCentralCheckbox;

	@FindBy(css = ".gcb-butterbar.shown")
	WebElement butterbarMsg;

	@FindBy(id = "menu-group__edit")
	WebElement createMenu;

	@FindBy(id = "menu-group__publish")
	WebElement publishMenu;

	@FindBy(id = "menu-group__analytics")
	WebElement manageMenu;

	@FindBy(id = "menu-item__edit__outline")
	WebElement outlineLink;
	
	@FindBy(id = "upload-button")
	WebElement uploadButton;

	// @FindBy(id = "menu-item__publish__availability")
	// WebElement availabilityLink;

	@FindBy(linkText = "Availability")
	WebElement availabilityLink;

	@FindBy(id = "menu-item__analytics__announcements")
	WebElement announcementsLink;

	@FindBy(id = "menu-item__analytics__list_course_staff")
	WebElement courseStaffLink;

	@FindBy(id = "menu-item__edit__questions")
	WebElement questionLink;
	@FindBy(id = "menu-item__edit__groups")
	WebElement questionGroupLink;

	@FindBy(id = "menu-item__edit__images")
	WebElement imagesFilesLink;

	@FindBy(name = "course:forum_embed_url")
	WebElement forumEmbedUrl;

	@FindBy(name = "course:forum_url")
	WebElement forumUrl;

	@FindBy(name = "course:announcement_list_url")
	WebElement announcementListUrl;

	@FindBy(name = "course:announcement_list_email")
	WebElement announcementListEmail;

	@FindBy(name = "course:weeks")
	WebElement courseWeeksSelect;

	@FindBy(name = "course:nc_code")
	WebElement selectNcCode;

	@FindBy(name = "course:course_type")
	WebElement selectCourseType;

	@FindBy(name = "course:course_level")
	WebElement selectCourseLevel;

	@FindBy(name = "course:explorer_instructor_name")
	WebElement instructorNameOnCard;

	// //input[@name='course:explorer_instructor_name']

	@FindBy(xpath = "//input[@name='course:instructor_institute']")
	WebElement instructorInstituteName;

	// @FindBy(xpath = "//input[@type='search']")
	@FindBy(xpath = "//input[@class='yui3-aclist-input']")
	WebElement instructorSearch;

	@FindBy(className = "yui3-aclist-content")
	WebElement instructorListContainer;

	@FindBy(xpath = "//ul[@role='listbox']/li")
	List<WebElement> instructorList;

	@FindBy(name = "course:course_picture_url")
	WebElement coursepPictureUrl;

	@FindBy(name = "course:main_image:url")
	WebElement youtubeID;

	@FindBy(className = "mdl-layout-title")
	WebElement dashboardHeader;
	@FindBy(id = "closed_courses_toggle")
	WebElement closedCoursesToggle;

	@FindBy(name = "video")
	WebElement videoIDField;

	@FindBy(xpath = "//div[@class='mc-container mdl-tabs__panel is-active']//input[@name='description']")
	WebElement questionDescription;

	@FindBy(name = "content:evaluator")
	WebElement evaluator;

	@FindBy(name = "content:public_testcase[0]input")
	WebElement firstPublicTestInput;
	@FindBy(name = "content:private_testcase[0]input")
	WebElement firstPrivateTestInput;

	@FindBy(name = "content:public_testcase[0]output")
	WebElement firstPublicTestOutput;

	@FindBy(name = "content:private_testcase[0]output")
	WebElement firstPrivateTestOutput;

	@FindBy(name = "content:allowed_languages[0]language")
	WebElement languagesDropdown;

	@FindBy(name = "content:allowed_languages[0]sample_solution")
	WebElement sampleSolutionField;

	@FindBy(name = "content:allowed_languages[0]filename")
	WebElement filenameField;

	@FindBy(id = "transcript_language1")
	WebElement vttLanguageDropdown;

	@FindBy(css = "html")
	WebElement lessonBody;

	@FindBy(xpath = "//span[@class='yui-button yui-push-button yui-toolbar-question'][@title='Question']")
	WebElement activityQuestion;

	@FindBy(xpath = "//span[contains(text(),'Save')]")
	WebElement saveButton;

	@FindBy(css = "div.yui-toolbar-container.yui-toolbar-grouped.slid-in")
	WebElement multipleChoiceQuestion;

	@FindBy(css = ".inputEx-Field.inputEx-CheckBox.assessment-editor-check-answers")
	WebElement cbxShowCorrectAnswer;

	@FindBy(id = "select_tab")
	WebElement selectExistingTab;

	@FindBy(xpath = "//label[contains(.,'Question')]//parent::div//following-sibling::div//select[@name='quid']")
	WebElement selectExistingQuestion;

	@FindBy(id = "nm_tab")
	WebElement createNumericAnswerTab;

	@FindBy(id = "yui-gen2000015_editor")
	WebElement numericAnswerQuestion;

	@FindBy(xpath = "//div[@class='nm-grader-score']//select[(@name='graders[0]matcher')]")
	WebElement numericAnsDropdown;

	@FindBy(xpath = "//div[@class='nm-grader-score']//select[(@name='graders[0]matcher')]/option[contains(text(),'Range Match')]")
	WebElement selectRangeType;

	@FindBy(xpath = "//div[@class='nm-grader-score']//select[(@name='graders[0]matcher')]/option[contains(text(),'Numeric')]")
	WebElement selectNumericType;

	@FindBy(css = ".nm-grader-text.show-when-numeric>div>input")
	WebElement numericAnswer;

	@FindBy(xpath = "//label[contains(text(),'From')]//parent::div//following-sibling::div/div/input")
	WebElement txtFromRangeMatch;

	@FindBy(xpath = "//label[contains(text(),'To')]//parent::div//following-sibling::div/div/input")
	WebElement txtToRangeMatch;

	@FindBy(xpath = "//*[@id='cb-oeditor-form']/div[3]/a/span[contains(.,'Close')]")
	WebElement closeBtn;

	@FindBy(xpath = "//*[@id='cb-oeditor-form']/div[2]/a/span[contains(.,'Save')]")
	WebElement saveBtnPopup;

	@FindBy(xpath = "//*[@id='cb-oeditor-form']/div[2]/a/span[contains(.,'Close')]")
	WebElement closeBtnPopup;

	@FindBy(id = "sa_tab")
	WebElement editShortAnsQuestion;

	@FindBy(xpath = "//button[@class='gcb-button'][contains(.,'Add Unit')]")
	WebElement btnAddUnit;

	@FindBy(xpath = "//div[contains(@class,'inputEx-Group') and contains(@class,'new-form-layout')]/form/div[3]/a/span[contains(.,'Save')]")
	WebElement saveBtnDefault;

	@FindBy(id = "transcript1")
	WebElement transcriptLink;

	@FindBy(xpath = "//button[@value='populate']")
	WebElement btnPopulate;

	@FindBy(name = "content:type")
	WebElement SubjectiveAssignmentType;

	@FindBy(name = "content:num_reviewers")
	WebElement inputNumReviewers;

	@FindBy(name = "workflow:submit_only_once")
	WebElement selectNoOfSubmission;

	@FindBy(name = "content:scoring_method")
	WebElement selectScoringMethod;
	
	@FindBy(xpath = "//a[contains(.,'Save')]")
	WebElement saveBtn;
	
	@FindBy(xpath = "//input[@name='file']")
	WebElement buttonChooseFiles;
	
	@FindBy(xpath = "//a[@href='#']/span[contains(.,'Upload')]")
	WebElement buttonFileUpload;
	
	@FindBy(xpath = "//thead[contains(.,'My Items')]//following-sibling::tbody//td[2]/a")
	WebElement uploadedImageLink;

	@FindBy(xpath = "//label[contains(text(),'Allow multiple selections')]")
	WebElement allowmultipleselctions;
	
	@FindBy(xpath = "//*[contains(@name,'description')]")
	WebElement questionDescription2;
	
	public void createUnit(String unitName) {
		Log.info("creating a unit with name: " + unitName);
		unitName = prop.getProperty(unitName);
		Util.closeNotificationBar();
		Util.waitForElementToPresent(titleField, 40);
		titleField.clear();
		titleField.sendKeys(unitName);
		Util.selectAnOption(availabilitySelect, "Course");
	}

	public void createEntity(String title) {
		Log.info("entering title to course outline entity");
		title = prop.getProperty(title);
		Util.closeNotificationBar();
		Util.waitForElementToPresent(titleField, 30);
		titleField.clear();
		titleField.sendKeys(title);
	}

	public void selectShowCorrectAnswer() {
		Log.info("Selecting checkbox for Show Correct Answer inside Lessons");
		Util.waitForElementToPresent(cbxShowCorrectAnswer, 30);
		driver.findElement(By.cssSelector(".inputEx-Field.inputEx-CheckBox.assessment-editor-check-answers")).click();
	}

	public void enterAssessmentPoints(String points) {
		Log.info("entering assessment points");
		assessmentPoints.clear();
		assessmentPoints.sendKeys(points);
	}

	public void setAssessmentDate(String phase) {
		Log.info("setting assessment due date");
		setAssessmentDueDate(phase, "Due Date");
	}

	public void setSubmissionDueDate(String phase) {
		Log.info("setting assessment submission due date");
		setAssessmentDueDate(phase, "Submission Due Date");
	}

	public void setEvaluationDueDate(String phase) {
		Log.info("setting assessment evaluation due date");
		setAssessmentDueDate(phase, "Evaluation Due Date");
	}

	public void setAvailability() {
		Log.info("setting entity availability to: course");
		Util.selectAnOption(availabilitySelect, "Course");
	}

	public void clickAssessmentLink(String entityName, String unitName) {
		Log.info("Clicking on " + entityName + " under unit");
		Util.clickAnEntityToUnit(entityName, unitName);
	}

	public void setAssessmentDueDate(String phase, String label) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int currentDay = c.get(Calendar.DAY_OF_MONTH);
		int currentMonth = c.get(Calendar.MONTH);
		int changedMonth = c.get(Calendar.MONTH);
		int changedYear = c.get(Calendar.YEAR);
		;
		String monthStatus = "";
		switch (phase.toUpperCase()) {
		case "FUTURE":
			c.add(Calendar.DAY_OF_MONTH, 1);
			currentDay = c.get(Calendar.DAY_OF_MONTH);
			changedMonth = c.get(Calendar.MONTH);
			changedYear = c.get(Calendar.YEAR);
			Log.info("current month :" + currentMonth + "changed month :"
					+ changedMonth);
			monthStatus = (changedMonth != currentMonth) ? "future" : "same";
			String dateFuture = sdf.format(c.getTime());
			Log.info("Future date is set to " + dateFuture + " & month is "
					+ monthStatus);
			break;
		case "PAST":
			c.add(Calendar.DAY_OF_MONTH, -1);
			currentDay = c.get(Calendar.DAY_OF_MONTH);
			changedMonth = c.get(Calendar.MONTH);
			changedYear = c.get(Calendar.YEAR);
			Log.info("current month :" + currentMonth + "changed month :"
					+ changedMonth);
			monthStatus = (changedMonth != currentMonth) ? "past" : "same";
			String datePast = sdf.format(c.getTime());
			Log.info("past date is set to " + datePast + " & month is "
					+ monthStatus);
			break;
		case "TWO":
			c.add(Calendar.DAY_OF_MONTH, 2);
			currentDay = c.get(Calendar.DAY_OF_MONTH);
			changedMonth = c.get(Calendar.MONTH);
			changedYear = c.get(Calendar.YEAR);
			Log.info("current month :" + currentMonth + "changed month :"
					+ changedMonth);
			monthStatus = (changedMonth != currentMonth) ? "future" : "same";
			String dateTwo = sdf.format(c.getTime());
			Log.info("Future date is set to " + dateTwo + " & month is "
					+ monthStatus);
			break;
		default:
			break;
		}
		prop.setProperty("assessment.date",
				String.valueOf(currentDay) + "-" + String.valueOf(changedMonth)
						+ "-" + String.valueOf(changedYear));
		WebElement assessmentDueDate = Util.getElementUsingLabelText(
				"admin.label.date", label);
		Util.WaitForElementToBeClickable(assessmentDueDate, 15);
		assessmentDueDate.click();
		Util.datePicker(String.valueOf(currentDay), monthStatus);
	}


	public void navigateToMenu(String menuName) {
		Util.openNavigationLinkByName(menuName);
	}

	public void goToCourseSettings() {
		Log.info("openning course settings page on admin side");
		Util.WaitForElementToBeClickable(courseLink, 30);
		courseLink.click();
	}

	public void setCourseCredit(String credit) {
		Log.info("setting up course credit value to: " + credit);
		Util.selectAnOption(courseCreditSelect, credit);
	}

	public void setCourseWeeks(String weeks) {
		Log.info("setting up course week value to: " + weeks);
		Util.selectAnOption(courseWeeksSelect, weeks);
		pushToCentralCheckbox.click();
	}

	public void enterCourseLayout(String description) {
		Log.info("entering course layout text");
		if (description.contains(".code")) {
			description = prop.getProperty(description);
			Util.fillRichTextField2("yui-gen2000000_editor");
			WebElement imageIcon = driver
					.findElement(By.cssSelector(".yui-button.yui-push-button.yui-toolbar-insertimage"));
			Util.WaitForElementToBeClickable(imageIcon, 10);
			imageIcon.click();
			WebElement imageEditor = driver.findElement(By.xpath("//input[@id='yui-gen2000000_insertimage_url']"));
			Util.WaitForElementToBeClickable(imageEditor, 10);
			((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", imageEditor, description);
			WebElement closeicon = driver.findElement(By.xpath("//div[@id='yui-gen2000000-panel']//span[.='X']"));
			Util.WaitForElementToBeClickable(closeicon, 30);
			closeicon.click();
		} else {
			description = prop.getProperty(description);
			Util.fillRichTextField("yui-gen2000000_editor", description);
		}

	}

	public void verifyConfirmationMessage(String message) {
		Log.info("verifying confirmation message");
		Util.waitForElementToNotPresent(By.cssSelector(".gcb-butterbar.shown"), 40);
	}

	public void gotoCourseOutline() {
		createMenu.click();
		Util.WaitForElementToBeClickable(outlineLink, 20);
		outlineLink.click();
	}

	// public void gotoCourseAvailability() {
	// Log.info("going to course availability page");
	// publishMenu.click();
	// Util.WaitForElementToBeClickable(availabilityLink, 10);
	// availabilityLink.click();
	// }

	public void gotoCourseAvailability() {
		// Util.closeNotificationBar();
		publishMenu.click();
		Util.WaitForElementToBeClickable(availabilityLink, 10);
		availabilityLink.click();
	}
	
	public void gotoImagesAndFiles() {
		
		createMenu.click();
		Util.WaitForElementToBeClickable(imagesFilesLink, 10);
		imagesFilesLink.click();
		Util.waitForElementToPresent(uploadButton, 30);
	}
	
    public void uploadImagesAndFiles() {
		
    	Util.waitForElementToPresent(uploadButton, 30);
		uploadButton.click();
		Util.waitForElementToPresent(buttonChooseFiles, 20);

		File file = new File("./resources/testimages/butterfly.png");
		buttonChooseFiles.sendKeys(file.getAbsolutePath());
		Util.waitForElementToPresent(buttonFileUpload, 20);
		buttonFileUpload.click();
	}
    
    public void copyLinkUploadedImage() {
    	
    	Util.waitForElementToPresent(uploadedImageLink, 30);
    	System.out.println(uploadedImageLink.getText());
    }

	public void gotoManage() {
		Log.info("going to manage page");
		Util.WaitForElementToBeClickable(manageMenu, 10);
		manageMenu.click();
	}

	public void gotoAnnoucement() {
		Log.info("going to announcement page");
		gotoManage();
		Util.WaitForElementToBeClickable(announcementsLink, 30);
		announcementsLink.click();
	}

	public void gotoCourseStaff() {
		Log.info("going to course staff page as super admin");
		gotoManage();
		Util.WaitForElementToBeClickable(courseStaffLink, 10);
		courseStaffLink.click();
	}

	public void verifyCourseCredit(String courseCreditsExpected) {
		Log.info("verifying course credits");
		String actualValue = Util.getSelctedOption(courseCreditSelect);
		Assert.assertEquals(actualValue, courseCreditsExpected);
	}

	public void verifyCourseWeeks(String courseWeeksExpected) {
		Log.info("verifying course weeks");
		String actualValue = Util.getSelctedOption(courseWeeksSelect);
		Assert.assertEquals(actualValue, courseWeeksExpected);

	}

	public void enterForumUrl(String url) {

		url = prop.getProperty(url);
		Log.info("entering forum URL");
		Util.closeNotificationBar();
		Util.waitForElementToPresent(forumUrl, 150);
		forumUrl.clear();
		forumUrl.sendKeys(url);
	}

	public void enterForumEmbedUrl(String embedUrl) {
		embedUrl = prop.getProperty(embedUrl);
		Log.info("entering forum embeded URL");
		Util.waitForElementToPresent(forumEmbedUrl, 20);
		forumEmbedUrl.clear();
		forumEmbedUrl.sendKeys(embedUrl);
	}

	public void enterAnnouncementListEmail(String annlistEmail) {
		Log.info("entering Announcement List Email");
		annlistEmail = prop.getProperty(annlistEmail);
		Util.waitForElementToPresent(announcementListEmail, 20);
		announcementListEmail.clear();
		announcementListEmail.sendKeys(annlistEmail);
	}

	public void enterAnnouncementListUrl(String annListUrl) {
		Log.info("entering Announcement List URL");
		annListUrl = prop.getProperty(annListUrl);
		Util.waitForElementToPresent(announcementListUrl, 20);
		announcementListUrl.clear();
		announcementListUrl.sendKeys(annListUrl);
	}

	public void setNcToCourse(String NcName) {
		Log.info("settng up NC to the course as: " + NcName);
		Util.waitForElementToPresent(selectNcCode, 20);
		Util.selectAnOption(selectNcCode, NcName);
	}

	public void enterBooksReferences(String booksReferences) {
		Log.info("entering books and references text");
		if (booksReferences.contains(".code")) {
			booksReferences = prop.getProperty(booksReferences);
			Util.fillRichTextField2("yui-gen2000003_editor");
			WebElement imageIcon = driver.findElement(By.id("yui-gen2000165"));
			Util.WaitForElementToBeClickable(imageIcon, 20);
			imageIcon.click();
			WebElement imageEditor = driver.findElement(By.xpath("//input[@id='yui-gen2000003_insertimage_url']"));
			Util.WaitForElementToBeClickable(imageEditor, 30);
			((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", imageEditor,
					booksReferences);
			// imageEditor.sendKeys(description);
			WebElement closeicon = driver.findElement(By.xpath("//div[@id='yui-gen2000003-panel']//span[.='X']"));
			Util.WaitForElementToBeClickable(closeicon, 30);
			closeicon.click();
		}
		// Util.fillHTMLInCodeField("Books and References","yui-gen2000004",
		// booksReferences);
		else {
			booksReferences = prop.getProperty(booksReferences);
			Util.fillRichTextField("yui-gen2000003_editor", booksReferences);
		}

	}

	public void enterAboutCourse(String aboutCourse) {
		Log.info("entering about the course text");
		if (aboutCourse.contains(".code")) {
			aboutCourse = prop.getProperty(aboutCourse);
			Util.fillRichTextField2("yui-gen2000009_editor");
			WebElement imageIcon = driver.findElement(By.id("yui-gen2000193"));
			Util.WaitForElementToBeClickable(imageIcon, 10);
			imageIcon.click();
			WebElement imageEditor = driver.findElement(By.xpath("//input[@id='yui-gen2000009_insertimage_url']"));
			Util.WaitForElementToBeClickable(imageEditor, 30);
			((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", imageEditor, aboutCourse);
			// imageEditor.sendKeys(description);
			WebElement closeicon = driver.findElement(By.xpath("//div[@id='yui-gen2000009-panel']//span[.='X']"));
			Util.WaitForElementToBeClickable(closeicon, 30);
			closeicon.click();
		}
		// Util.fillHTMLInCodeField("About the course", "yui-gen2000010",
		// aboutCourse);
		else {
			aboutCourse = prop.getProperty(aboutCourse);
			Util.fillRichTextField("yui-gen2000009_editor", aboutCourse);
		}

	}

	public void enterInstructorBio(String instructorBio) {
		Log.info("entering instructor bio");
		instructorBio = prop.getProperty(instructorBio);
		Util.fillRichTextField("yui-gen2000012_editor", instructorBio);
	}

	public void enterCourseCertificatet(String courseCertificate) {
		Log.info("entering course certificate text");
		courseCertificate = prop.getProperty(courseCertificate);
		Util.fillRichTextField("yui-gen2000006_editor", courseCertificate);
	}

	public void enterVideoId(String VideoId) {
		Log.info("entering video id");
		VideoId = prop.getProperty(VideoId);
		youtubeID.clear();
		youtubeID.sendKeys(VideoId);
	}

	public void enterCoursePicture(String pictureUrl) {
		Log.info("entering course picture");
		pictureUrl = prop.getProperty(pictureUrl);
		coursepPictureUrl.clear();
		coursepPictureUrl.sendKeys(pictureUrl);
	}

	public void enterCourseCardInstructorName(String instructorName) {
		instructorName = prop.getProperty(instructorName);
		instructorNameOnCard.sendKeys(instructorName);
	}

	public void setCourseTypeToCourse(String courseType) {
		Log.info("setting up course type as:" + courseType);
		Util.waitForElementToPresent(selectCourseType, 10);
		Util.selectAnOption(selectCourseType, courseType);

	}

	public void setCourseLevelToCourse(String courseLevel) {
		Log.info("setting up course level as:" + courseLevel);
		Util.waitForElementToPresent(selectCourseLevel, 10);
		Util.selectAnOption(selectCourseLevel, courseLevel);

	}

	public void enterInstructorInstitute(String instructorInstitute) {
		Log.info("entering instructor institute");
		instructorInstitute = prop.getProperty(instructorInstitute);
		Util.waitForElementToPresent(instructorSearch, 20);
		instructorSearch.clear();
		instructorSearch.sendKeys(instructorInstitute);
		Util.waitForElementToPresent(instructorListContainer, 5);
		// instructorInstitute = instructorInstitute + " (Prof.Test info)";
		// for (WebElement instructor : instructorList) {
		// if (instructor.getText().equals(instructorInstitute))
		// instructor.click();
		// break;
		// }

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//li[@class='yui3-aclist-item'][contains(.,'i_2')]"));
		driver.findElement(By.xpath("//li[@class='yui3-aclist-item'][contains(.,'i_2')]")).click();
		// driver.findElement(By.xpath("//li[@class='yui3-aclist-item'][contains(.,"+instructorInstitute+"]"));
		//
		// driver.findElement(By.xpath("//li[@class='yui3-aclist-item'][contains(.,"+instructorInstitute+"]")).click();

		Util.clickOnButton("Populate");
		// instructorInstituteName.sendKeys(instructorInstitute);
	}

	public void verifyFDPCheckBox(String fdpCourse) {
		Log.info("verifying FDP checkbox status");
		boolean expectedFlag = false;
		if (fdpCourse.equalsIgnoreCase("Yes"))
			expectedFlag = true;

		Assert.assertEquals(Util.isCheckboxSelected("FDP Course"), expectedFlag);
	}

	public void verifyPushToCentralCheckbox(String pushCentral) {
		Log.info("verifying push to central checkbox status");
		boolean expectedFlag = false;
		if (pushCentral.equalsIgnoreCase("Yes"))
			expectedFlag = true;

		Assert.assertEquals(Util.isCheckboxSelected("Push to SWAYAM Central"), expectedFlag);

	}

	public void verifyCourseTypeValue(String courseType) {
		Log.info("verifying course type value as: " + courseType);
		String actualValue = Util.getSelctedOption(selectCourseType);
		Assert.assertEquals(actualValue, courseType);

	}

	public void verifyCourseLevelValue(String courseLevel) {
		Log.info("verifying course level value as: " + courseLevel);
		String actualValue = Util.getSelctedOption(selectCourseLevel);
		Assert.assertEquals(actualValue, courseLevel);

	}

	public void verifyCourseLayoutFieldValue(String courseLayout) {
		Log.info("verifying course layout text");

		Util.waitForElementToPresent(btnPopulate, 180);

		String actualText = Util.getValueOfRichTextField("yui-gen2000000_editor");
		Assert.assertEquals(actualText, prop.getProperty(courseLayout));
	}

	public void verifyBooksReferencesValue(String booksReferences) {
		Log.info("verifying books and references text");
		String actualText = Util.getValueOfRichTextField("yui-gen2000003_editor");
		Assert.assertEquals(actualText, prop.getProperty(booksReferences));
	}

	public void verifyCourseCertificateValue(String courseCertificate) {
		Log.info("verifying course certificate text");
		String actualText = Util.getValueOfRichTextField("yui-gen2000006_editor");
		Assert.assertEquals(actualText, prop.getProperty(courseCertificate));
	}

	public void verifyAboutCourseValue(String aboutCourse) {
		Log.info("verifying about the course text");
		String actualText = Util.getValueOfRichTextField("yui-gen2000009_editor");
		Assert.assertEquals(actualText, prop.getProperty(aboutCourse));
	}

	public void verifyInstructorBioValue(String instructorBio) {
		Log.info("verifying instructor bio text");
		String actualText = Util.getValueOfRichTextField("yui-gen2000012_editor");
		Assert.assertEquals((actualText.split("\n")[2]).trim(), (prop.getProperty(instructorBio)).trim());
	}

	public void verifyInstructorInstituteValue(String instructorInstitute) {
		Log.info("verifying instructor institute text");
		String actualText = Util.getInputFieldValueUsingJS(instructorInstituteName);
		Assert.assertEquals(actualText, prop.getProperty(instructorInstitute));
	}

	public void verifyCoursePictureValue(String coursePicture) {
		Log.info("verifying course picture url");
		String actualText = Util.getInputFieldValueUsingJS(coursepPictureUrl);
		Assert.assertEquals(actualText, prop.getProperty(coursePicture));

	}

	public void verifyInstructorNameValue(String instructorName) {
		Log.info("verifying course instructor text");
		String actualText = Util.getInputFieldValueUsingJS(instructorNameOnCard);
		Assert.assertEquals(actualText, prop.getProperty(instructorName));

	}

	public void verifyYoutubeIdValue(String youtubeId2) {
		Log.info("verifying youtube id");
		String actualText = Util.getInputFieldValueUsingJS(youtubeID);
		Assert.assertEquals(actualText, prop.getProperty(youtubeId2));

	}

	public void setShowCorrectAnswser(String showCorrectAnswer) {
		Log.info("verifying check answer checkbox status");
		if (showCorrectAnswer.equalsIgnoreCase("Yes"))
			Util.selectCheckboxByName("Show Correct Answer");
	}

	public void setSingleSubmission(String singleSubmission) {
		Log.info("verifying single submission checkbox status");
		if (singleSubmission.equalsIgnoreCase("Yes"))
			Util.selectCheckboxByName("Single Submission");
	}

	public void enterQuestionToAssessment(String questionName, String choice1, String choice2, String choice3,
			String choice4, String description) {
		Log.info("entering question statement for question under assessment");
		// Enter into assessment field
		Util.fillRichTextField2("yui-gen2000000_editor");
		// clicking on the question icon from rich text editor
		WebElement questionIcon = driver
				.findElement(By.cssSelector(".yui-button.yui-push-button.yui-toolbar-question"));
		List<WebElement> iframes = null;
		try {
			Util.WaitForElementToBeClickable(questionIcon, 10);
			Util.WaitForElementTextToBePresent(questionIcon, "Question", 20);
			Util.WaitForElementToBeClickable(questionIcon, 10);
			questionIcon.click();
			// switch into question pop up
			By questioniframeBy = By.id("modal-editor-iframe");
			Util.waitForFrameToAvailableAndSwitch(questioniframeBy, 50);
			Thread.sleep(6000);
			iframes = driver.findElements(By.tagName("iframe"));

		} catch (NoSuchElementException | InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		iframes = driver.findElements(By.tagName("iframe"));
		// switch into title field
		Util.fillRichTextField("yui-gen2000000_editor", prop.getProperty(questionName));
		// switch into first choice field
		if (choice1 != null)
			// Util.fillRichTextField("yui-gen2000104_editor", "A");
			Util.fillRichTextField(iframes.get(5), "A");
		// opening the new choice field
		if (choice2 != null) {
			// opening the new choice field
			Util.clickOnLink("Add a choice");
			iframes = driver.findElements(By.tagName("iframe"));
			// switch into second choice field
			Util.fillRichTextField(iframes.get(9), "B");
		}
		if (choice3 != null) {
			// opening the new choice field
			Util.clickOnLink("Add a choice");
			iframes = driver.findElements(By.tagName("iframe"));
			// switch into third choice field
			Util.fillRichTextField(iframes.get(13), "C");
		}
		if (choice4 != null) {
			// opening the new choice field
			Util.clickOnLink("Add a choice");
			iframes = driver.findElements(By.tagName("iframe"));
			// switch into fourth choice field
			Util.fillRichTextField(iframes.get(17), "D");

		}
		questionDescription.sendKeys(description);
		Util.clickOnLink("Save");
		driver.switchTo().defaultContent();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void accessSelectExistingTab() {

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Log.info("entering question statement for question under assessment");
		// Enter into assessment field
		Util.fillRichTextField2("yui-gen2000000_editor");
		// clicking on the question icon from rich text editor
		WebElement questionIcon = driver
				.findElement(By.cssSelector(".yui-button.yui-push-button.yui-toolbar-question"));
		List<WebElement> iframes = null;
		try {
			Util.WaitForElementToBeClickable(questionIcon, 10);
			Util.WaitForElementTextToBePresent(questionIcon, "Question", 20);
			Util.WaitForElementToBeClickable(questionIcon, 10);
			questionIcon.click();
			// switch into question pop up
			By questioniframeBy = By.id("modal-editor-iframe");
			Util.waitForFrameToAvailableAndSwitch(questioniframeBy, 50);
			Thread.sleep(6000);
			iframes = driver.findElements(By.tagName("iframe"));

		} catch (NoSuchElementException | InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Util.waitForElementToPresent(selectExistingTab, 10);
		selectExistingTab.click();
		Util.waitForElementToPresent(selectExistingQuestion, 10);
	}

	public void accessCreateNumericAnswerTab() {

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Log.info("entering question statement for question under assessment");
		// Enter into assessment field
		Util.fillRichTextField2("yui-gen2000000_editor");
		// clicking on the question icon from rich text editor
		WebElement questionIcon = driver
				.findElement(By.cssSelector(".yui-button.yui-push-button.yui-toolbar-question"));
		List<WebElement> iframes = null;
		try {
			Util.WaitForElementToBeClickable(questionIcon, 10);
			Util.WaitForElementTextToBePresent(questionIcon, "Question", 20);
			Util.WaitForElementToBeClickable(questionIcon, 10);
			questionIcon.click();
			// switch into question pop up
			By questioniframeBy = By.id("modal-editor-iframe");
			Util.waitForFrameToAvailableAndSwitch(questioniframeBy, 50);
			Thread.sleep(6000);
			iframes = driver.findElements(By.tagName("iframe"));

		} catch (NoSuchElementException | InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Util.waitForElementToPresent(createNumericAnswerTab, 10);
		createNumericAnswerTab.click();
		Util.waitForElementToPresent(numericAnswerQuestion, 10);
	}

	public void accessCreateNumericAnswerTabToAddAnotherQuestion() {

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Log.info("entering question statement for question under assessment");
		// Enter into assessment field
		WebElement iframe = driver.findElement(By.id("yui-gen2000000_editor"));
		driver.switchTo().frame(iframe);
		driver.findElement(By.tagName("Body"));
		driver.findElement(By.tagName("Body")).sendKeys("test Range Type Question");
		driver.switchTo().defaultContent();

		// clicking on the question icon from rich text editor
		WebElement questionIcon = driver
				.findElement(By.cssSelector(".yui-button.yui-push-button.yui-toolbar-question"));
		List<WebElement> iframes = null;
		try {
			Util.WaitForElementToBeClickable(questionIcon, 10);
			Util.WaitForElementTextToBePresent(questionIcon, "Question", 20);
			Util.WaitForElementToBeClickable(questionIcon, 10);
			questionIcon.click();
			// switch into question pop up
			By questioniframeBy = By.id("modal-editor-iframe");
			Util.waitForFrameToAvailableAndSwitch(questioniframeBy, 50);
			Thread.sleep(6000);
			iframes = driver.findElements(By.tagName("iframe"));

		} catch (NoSuchElementException | InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Util.waitForElementToPresent(createNumericAnswerTab, 10);
		createNumericAnswerTab.click();
		Util.waitForElementToPresent(numericAnswerQuestion, 10);
	}
	
	
	public void enterMSQToAssessment(String questionName, String c1, String c2, String c3,
			String c4,String c5, String description,String Answer, String allornothing) {
		Log.info("entering MSQ statement for question under assessment");
		// Enter into assessment field
		String choice1=prop.getProperty(c1);
		String choice2=prop.getProperty(c2);
		String choice3=prop.getProperty(c3);
		String choice4=prop.getProperty(c4);
		String choice5=prop.getProperty(c5);
		String answers=prop.getProperty(Answer);
		allowmultipleselctions.click();
		
		if(Util.isCheckboxSelected("All or Nothing"))
			Util.selectCheckboxByName("All or Nothing");
		
		if(allornothing.equalsIgnoreCase("Yes"))
			Util.selectCheckboxByName("All or Nothing");
		
		Util.fillRichTextField2("yui-gen2000000_editor");
		// clicking on the question icon from rich text editor
	//	WebElement questionIcon = driver
		//		.findElement(By.cssSelector(".yui-button.yui-push-button.yui-toolbar-question"));
		List<WebElement> iframes = null;
		iframes = driver.findElements(By.tagName("iframe"));
		// switch into title field
		Util.fillRichTextField("yui-gen2000000_editor", prop.getProperty(questionName));
		// switch into first choice field
		if (choice1 != null)
			// Util.fillRichTextField("yui-gen2000104_editor", "A");
			Util.fillRichTextField(iframes.get(5), choice1);
		// opening the new choice field
		if (choice2 != null) {
			// opening the new choice field
			Util.clickOnLink("Add a choice");
			iframes = driver.findElements(By.tagName("iframe"));
			// switch into second choice field
			Util.fillRichTextField(iframes.get(9), choice2);
		}
		if (choice3 != null) {
			// opening the new choice field
			Util.clickOnLink("Add a choice");
			iframes = driver.findElements(By.tagName("iframe"));
			// switch into third choice field
			Util.fillRichTextField(iframes.get(13), choice3);
		}
		if (choice4 != null) {
			// opening the new choice field
			Util.clickOnLink("Add a choice");
			iframes = driver.findElements(By.tagName("iframe"));
			// switch into fourth choice field
			Util.fillRichTextField(iframes.get(17), choice4);

		}
		if (choice5 != null) {
			// opening the new choice field
			Util.clickOnLink("Add a choice");
			iframes = driver.findElements(By.tagName("iframe"));
			// switch into fourth choice field
			Util.fillRichTextField(iframes.get(21), choice5);

		}
		
		String[] setcorrectchoices = answers.split(",");
		
		
		List<WebElement> checkboxelement = driver.findElements(By.xpath("//div[@class='mc-choice-score']"));
		
		ListIterator<WebElement> theListOfcheckboxanswers = checkboxelement.listIterator();
		    
		 int i = 1,k=0;
		    while(theListOfcheckboxanswers.hasNext()) {
		    	
		    	int choiceptr = Integer.parseInt(setcorrectchoices[k]);
		    	WebElement clickanswercheckbox= theListOfcheckboxanswers.next();
		    	if(choiceptr==1)
		    		clickanswercheckbox.click();;
		    	if(choiceptr==i)
		    		
		    			{ clickanswercheckbox.click(); ++k; 
		    		if(k>setcorrectchoices.length)
		    		{break;}
		    		System.out.println("correct answer set as choice" +i);} 
		    		
		    	++i;
		    	}
		questionDescription2.sendKeys(prop.getProperty(description));
		Util.clickOnLink("Save");
	}

	public void scrollDownforCloseButton() {

		Log.info("Searching for Close button");
		Util.waitForElementToPresent(closeBtnPopup, 10);
		Util.scrollToElement(closeBtnPopup);
		Log.info("Found Close button");
	}
	
	public void scrollDownforCloseButtonAssessment() {

		Log.info("Searching for Close button");
		Util.waitForElementToPresent(closeBtn, 20);
		Util.scrollToElement(closeBtn);
		Log.info("Found Close button");
	}

	public void scrollDownforSaveButton() {

		Log.info("Searching for Save button");
		Util.waitForElementToPresent(saveBtnDefault, 10);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Util.scrollToElement(saveBtnDefault);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.info("Found Save button");
	}

	public void scrollDownforSaveButtonCourseSettingsPage() {
		
		Log.info("Searching for Save button");
		Util.waitForElementToPresent(saveBtn, 60);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Util.scrollToElement(saveBtn);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.info("Found Save button");
		
	}

	public void addExistingQuestion() {

		Util.waitForElementToPresent(selectExistingQuestion, 10);

		String existingQuestion = prop.getProperty("assessment.description.short");
		Util.selectAnOption(selectExistingQuestion, existingQuestion);
		Util.waitForElementToPresent(editShortAnsQuestion, 20);

		// change started

		scrollDownforCloseButton();
		Util.waitForElementToPresent(saveBtnPopup, 20);
		saveBtnPopup.click();

		Log.info("Clicked on Save buton");
		// change completed

		// Util.clickOnLink("Save");

		driver.switchTo().defaultContent();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.info("Switched to default frame");
	}
	
	public void addExistingQuestion(String assessmentname) {

		Util.waitForElementToPresent(selectExistingQuestion, 10);

		String existingQuestion = prop.getProperty(assessmentname);
		Util.selectAnOption(selectExistingQuestion, existingQuestion);
		Util.waitForElementToPresent(editShortAnsQuestion, 20);

		// change started

		scrollDownforCloseButton();
		Util.waitForElementToPresent(saveBtnPopup, 20);
		saveBtnPopup.click();

		Log.info("Clicked on Save buton");
		// change completed

		// Util.clickOnLink("Save");

		driver.switchTo().defaultContent();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.info("Switched to default frame");
	}


	public void addNumericTypeQuestion() {

		Util.waitForElementToPresent(numericAnswerQuestion, 10);

		// iframes = driver.findElements(By.tagName("iframe"));
		// switch into title field
		Util.fillRichTextField("yui-gen2000015_editor", "What is exact value of Pi?");

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Util.waitForElementToPresent(selectNumericType, 10);
		Util.scrollToElement(selectNumericType);
		Util.selectAnOption(numericAnsDropdown, "Numeric");
		numericAnswer.sendKeys("3.14");

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Util.waitForElementToPresent(By.cssSelector(".inputEx-Field.nm-description>div>input"), 10);
		driver.findElement(By.cssSelector(".inputEx-Field.nm-description>div>input")).sendKeys("TestPiValue");

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addNumericTypeQuestion(String question1, String answer1, String desc1) {
		
		String question = prop.getProperty(question1);
		String answer = prop.getProperty(answer1);
		String desc = prop.getProperty(desc1);
		Util.waitForElementToPresent(numericAnswerQuestion, 10);

		// iframes = driver.findElements(By.tagName("iframe"));
		// switch into title field
		Util.fillRichTextField("yui-gen2000015_editor", question);

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Util.waitForElementToPresent(selectNumericType, 10);
		Util.scrollToElement(selectNumericType);
		Util.selectAnOption(numericAnsDropdown, "Numeric");
		numericAnswer.sendKeys(answer);

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Util.waitForElementToPresent(By.cssSelector(".inputEx-Field.nm-description>div>input"), 10);
		driver.findElement(By.cssSelector(".inputEx-Field.nm-description>div>input")).sendKeys(desc);

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void addRangeTypeQuestion() {

		Util.waitForElementToPresent(numericAnswerQuestion, 10);

		Util.fillRichTextField("yui-gen2000015_editor", "Enter decimal numbers between 0 and 1");

		Util.waitForElementToPresent(selectRangeType, 10);
		Util.scrollToElement(selectRangeType);
		Util.selectAnOption(numericAnsDropdown, "Range Match");

		Util.waitForElementToPresent(txtFromRangeMatch, 10);
		txtFromRangeMatch.sendKeys("0");
		Util.waitForElementToPresent(txtToRangeMatch, 10);
		txtToRangeMatch.sendKeys("1");

		Util.waitForElementToPresent(By.cssSelector(".inputEx-Field.nm-description>div>input"), 10);
		driver.findElement(By.cssSelector(".inputEx-Field.nm-description>div>input"))
				.sendKeys("RangeMatchQuestionDescription");

		Util.clickOnLink("Save");

		driver.switchTo().defaultContent();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setEntityAvailabilityByName(String entityName, String availabilityText) {
		entityName = prop.getProperty(entityName);
		Log.info("setting " + entityName + " avaialibility to: " + availabilityText);
		WebElement entitySelect = Util.getElementUsingLabelText("course.entity.availability", entityName);
		Util.selectAnOption(entitySelect, availabilityText);

	}

	public void verifyCourseIsNotPresentOnDashboard() {
		Log.info("verifying course is not present on dashbord");
		Util.waitForElementToPresent(dashboardHeader, 20);
		Assert.assertEquals(Util.isCoursePresentOnDashboard(), false);
	}

	public void verifyCourseIsPresentOnDashboard() {
		Log.info("verifying course is present on dashbord");
		Util.waitForElementToPresent(dashboardHeader, 20);
		Assert.assertEquals(Util.isCoursePresentOnDashboard(), true);
	}

	public void clickOnClosedCourseCheckbox() {
		Log.info("clicking on closed course checkbox");
		closedCoursesToggle.click();
	}

	public void enterVideoIdOnLessonsPage(String videoID) {
		Log.info("entering video id to lesson content");
		videoID = prop.getProperty(videoID);
		videoIDField.sendKeys(videoID);

	}

	public void enterLessonBody(String lessonBody) {
		Log.info("entering lesson body to the lesson");
		lessonBody = prop.getProperty(lessonBody);
		Util.fillRichTextField("yui-gen2000000_editor", lessonBody);

	}

	public void enterVttUrl(String url, String language) {

		url = prop.getProperty(url);

		Log.info("entering vtt details to lesson");
		Util.waitForElementToPresent(vttLanguageDropdown, 10);
		Util.selectAnOption(vttLanguageDropdown, language);

		Log.info("Selected language");

		Util.waitForElementToPresent(transcriptLink, 10);
		transcriptLink.clear();
		transcriptLink.sendKeys(url);

		Log.info("entered vtt link");
	}

	public void enterProblemStatement(String problemStatement) {
		Log.info("entering problem statement");
		problemStatement = prop.getProperty(problemStatement);
		Util.fillRichTextField("yui-gen2000000_editor", problemStatement);
	}

	public void setCompileAndRunOption(String compileAndRun) {
		Log.info("setting up compile&run checkbox to true");
		if (compileAndRun.equalsIgnoreCase("yes")) {
			Util.selectCheckboxByName("Allow \"Compile & Run\"");
		}
	}

	public void setProgramEvaluator(String programEvaluator) {
		programEvaluator = prop.getProperty(programEvaluator);
		Log.info("setting up program evaluator to: " + programEvaluator);
		Util.selectAnOption(evaluator, programEvaluator);

	}

	public void setPresentationErrorsPrefs(String presentationErrorsPrefs) {
		Log.info("setting up ignore presentation error checkbox to true");
		if (presentationErrorsPrefs.equalsIgnoreCase("yes")) {
			Util.selectCheckboxByName("Ignore Presentation Errors");
		}

	}

	public void createPublicTestCase(String input, String output) {
		Log.info("adding public test case to programing");
		input = prop.getProperty(input);
		output = prop.getProperty(output);
		Util.waitForElementToPresent(firstPublicTestInput, 10);
		firstPublicTestInput.sendKeys(input);
		firstPublicTestOutput.sendKeys(output);
	}

	public void createPrivateTestCase(String input, String output) {
		Log.info("adding private test case to programing");
		input = prop.getProperty(input);
		output = prop.getProperty(output);
		Util.waitForElementToPresent(firstPublicTestInput, 10);
		firstPrivateTestInput.sendKeys(input);
		firstPrivateTestOutput.sendKeys(output);

	}

	public void addLanguage(String language, String sampleSolution, String fileName) {

		language = prop.getProperty(language);
		Log.info("adding language programing assignment to: " + language);
		sampleSolution = prop.getProperty(sampleSolution);
		fileName = prop.getProperty(fileName);
		Util.waitForElementToPresent(languagesDropdown, 10);
		Util.selectAnOption(languagesDropdown, language);
		sampleSolutionField.sendKeys(sampleSolution);
		filenameField.sendKeys(fileName);
	}

	public void enterAssignmentType(String assignmentType) {
		assignmentType = prop.getProperty(assignmentType);
		Log.info("choosing assessment type as : " + assignmentType);
		Util.selectAnOption(SubjectiveAssignmentType, assignmentType);

	}

	public void setNumberOfSubmissions(String numberOfSubmissions) {
		numberOfSubmissions = prop.getProperty(numberOfSubmissions);
		Log.info("choosing number Of Submissions as : " + numberOfSubmissions);
		Util.selectAnOption(selectNoOfSubmission, numberOfSubmissions);

	}

	public void setnNumberOfReviewers(String numberOfReviewers) {
		numberOfReviewers = prop.getProperty(numberOfReviewers);
		Log.info("choosing number Of Reviewers as : " + numberOfReviewers);
		inputNumReviewers.clear();
		inputNumReviewers.sendKeys(numberOfReviewers);
	}

	public void setScoringMethod(String scoringMethod) {
		scoringMethod = prop.getProperty(scoringMethod);
		Log.info("choosing scoring method : " + scoringMethod);
		Util.selectAnOption(selectScoringMethod, scoringMethod);
	}


}
