package com.swayam.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.swayam.base.Util;

public class NodeAdminPage extends HomePage {

	final static Logger Log = Logger.getLogger(NodeAdminPage.class.getName());
	static List<String> myCourse = null;
	Util Util = new Util();

	@FindBy(id = "add_course")
	WebElement addCourseButton;

	@FindBy(xpath = "//h1")
	WebElement header;

	@FindBy(className = "add-course-panel")
	WebElement addCoursePopup;

	@FindBy(name = "admin_email")
	WebElement CourseAdminEmailField;

	@FindBy(name = "title")
	WebElement courseTitleField;

	@FindBy(name = "name")
	WebElement courseUrlField;

	@FindBy(id = "multi_course_actions")
	WebElement multiCourseActionsBtn;

	@FindBy(id = "edit_multi_course_availability")
	WebElement setCourseAvailabilityBtn;

	@FindBy(id = "multi-course-edit-panel")
	WebElement multiCourseEditPopup;

	@FindBy(id = "multi-course-select-availability")
	WebElement availabilitySelect;

	@FindBy(id = "gcb-butterbar-close")
	WebElement notificationCloseIcon;

	public NodeAdminPage() {
		super();
	}

	public void verifyUserOnNodeAdminPage() {
		Log.info("Verifying that user is on dashboard page");
		Util.waitForPageTitleToContainText("Course Builder", 20);
		Util.waitForElementToPresent(header, 20);
		String headerText = header.getText();
		Assert.assertTrue(headerText.equals(prop.getProperty("node.header"))
				|| headerText.equals(prop.getProperty("central.header")));
	}

	
	
	public void clickOnAddCourse() {
		Log.info("Clicking on add course button");
		Util util = new Util();
		util.waitForElementToPresent(addCourseButton, 10);
		addCourseButton.click();
	}

	public void verifyAddCoursePopup() {
		Log.info("verifying add course pop up");
		Assert.assertTrue(addCoursePopup.isDisplayed()
				& addCoursePopup.findElement(By.xpath("//h2")).getText()
						.equals("Add Course..."));

	}

	public void verifyAdminEmailPlaceholder(String email) {
		Log.info("verifying admin email placeholder field -" + email);
		Assert.assertEquals(CourseAdminEmailField.getAttribute("value"),
				prop.getProperty(email));
	}

	public void enterCourseTitle(String title) {
		Log.info("Entering course title -" + title);
		courseTitleField.clear();
		courseTitleField.sendKeys(title);
	}

	public void enterCourseURL(String url) {
		Log.info("Entering course URL-" + url);
		courseUrlField.clear();
		courseUrlField.sendKeys(url);
	}

	public void enterCourseAdminEmail(String email) {

		email = prop.getProperty(email);
		Util.waitForElementToPresent(CourseAdminEmailField, 30);
		String previousText = CourseAdminEmailField.getAttribute("value");
		CourseAdminEmailField.clear();
		Log.info("Entering course admin email -" + email);
		CourseAdminEmailField.sendKeys(previousText + "," + email);
	}

	public void clickOnButton(String buttonName) {
		Util.clickOnButton(buttonName);
	}

	public void createCourse(String CourseTitle, String courseUrl,
			String courseAdminEmail) {
		prop.setProperty("course.name", CourseTitle);
		System.setProperty("course.name", CourseTitle);
		enterCourseTitle(CourseTitle);
		enterCourseURL(courseUrl);
		enterCourseAdminEmail(courseAdminEmail);
	}

	public boolean getMultiCourseActionsButtonStatus() {
		return multiCourseActionsBtn.getAttribute("class").contains(
				"inactive-container");
	}

	public void setCourseAvailability(String availability) {
		Log.info("Setting course avialibility to -" + availability);
		Util.WaitForElementToBeClickable(multiCourseActionsBtn, 10);
		multiCourseActionsBtn.click();
		Util.waitForElementToPresent(setCourseAvailabilityBtn, 10);
		setCourseAvailabilityBtn.click();
		Assert.assertTrue(multiCourseEditPopup.isDisplayed());
		Util.selectAnOption(availabilitySelect, availability);
		Util.clickOnButton("Save");
		Util.handleAlert();
		Util.closeNotificationBar();
		Util.WaitForButtonToBeClickable("Close", 30);
		Util.clickOnButton("Close");
	}

	public void goToCourseOutline(String courseURL) {
		String courseLink = driver.getCurrentUrl().replaceAll("(/modules/admin).*",
				"/" + courseURL + "/dashboard");
		driver.get(courseLink);
	}

	public void goToCourseByName(String courseName) {
		Util.clickOnTheCourseByNameOnAdminDashboard(courseName);
	}

	public void veriyCreatedCourseOnCourseList(String courseTitle) {
		Log.info("Verifying created course on the course list under dashboard by name -"
				+ courseTitle);
		myCourse = Util.getRowRecordsFromWebTable(courseTitle);
		Assert.assertTrue(!myCourse.isEmpty());
		Assert.assertEquals(myCourse.get(1), courseTitle);
	}

	public void verifyCourseURLOnCourseList(String courseURL) {
		Log.info("Verifying course URL as - " + courseURL);
		Assert.assertTrue(myCourse.get(2).contains(courseURL));

	}

	public void selectCourseByUrl(String courseURL) {
		Log.info("selecting the course by it's URL -" + courseURL);
		Assert.assertTrue(getMultiCourseActionsButtonStatus());
		Assert.assertTrue(Util.selectCourseCheckBoxByURL(courseURL));
		Assert.assertTrue(!getMultiCourseActionsButtonStatus());
	}

}
