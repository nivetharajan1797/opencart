package com.swayam.steps;

import java.util.List;
import java.util.Map;

import com.swayam.base.Util;
import com.swayam.pages.NodeAdminPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NodeAdminPageTest {

	String courseTitle = "";
	String courseURL = "";
	String courseWeeks = "";
	String courseCredits = "";
	String courseAdminEmail = "";

	String unitName = "";
	Util Util = new Util();

	@Then("^user verifies the admin site page$")
	public void verifyAdminSitePage() {
		NodeAdminPage adminHome = new NodeAdminPage();
		adminHome.verifyUserOnNodeAdminPage();
	}

	@When("^user clicks on add course button$")
	public void ClickAddCourseButton() {
		NodeAdminPage adminHome = new NodeAdminPage();
		adminHome.clickOnAddCourse();
	}

	@Then("^user verifies the add coursed pop up dispplays$")
	public void verifyAddCoursePopup() {
		NodeAdminPage adminHome = new NodeAdminPage();
		adminHome.verifyAddCoursePopup();
	}

	@When("^user enters  following course details$")
	public void enterCourseDetailsForCourseCreation(DataTable dataTable) {
		NodeAdminPage adminHome = new NodeAdminPage();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);
		courseTitle = list.get(0).get("Title") + Util.getCurrentTimeStamp();
		courseURL = list.get(0).get("URL Component")
				+ Util.generateRandomString();
		courseAdminEmail = list.get(0).get("Course Admin Email");
		adminHome.createCourse(courseTitle, courseURL, courseAdminEmail);
	}

	@Then("^user verifies the course on course list$")
	public void verifyCreatedCourseOnCourseList() {
		NodeAdminPage adminHome = new NodeAdminPage();
		adminHome.veriyCreatedCourseOnCourseList(courseTitle);
	}

	@Then("^user verifies the course URL for created course$")
	public void verifyCourseURLForCreatedCourse() {
		NodeAdminPage adminHome = new NodeAdminPage();
		adminHome.verifyCourseURLOnCourseList(courseURL);
	}

	@Then("^user select the course by course URL$")
	public void selectCourseByURL() {
		NodeAdminPage adminHome = new NodeAdminPage();
		adminHome.selectCourseByUrl(courseURL);

	}

	@When("^user sets the availability to \"([^\"]*)\"$")
	public void setAvailabilityTo(String availability) {
		NodeAdminPage adminHome = new NodeAdminPage();
		adminHome.setCourseAvailability(availability);
	}

	@When("^user goes to course outine page$")
	public void goToCourseOutlineByCourseURL() throws Throwable {
		NodeAdminPage adminHome = new NodeAdminPage();
		adminHome.goToCourseOutline(courseURL);
	}

	@Then("^user clicks on the course \"([^\"]*)\" on admin side$")
	public void openCourseByName(String courseName) {
		NodeAdminPage adminHome = new NodeAdminPage();
		adminHome.goToCourseByName(courseName);
		
		
	}
	@Then("^user verifies the admin email field placeholder value is \"([^\"]*)\" on popup$")
	public void verifyAdminEmailPlaceholder(String placeholderEmail) {
		NodeAdminPage adminHome = new NodeAdminPage();
		adminHome.verifyAdminEmailPlaceholder(placeholderEmail);
	}
}
