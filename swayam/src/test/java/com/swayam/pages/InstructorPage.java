package com.swayam.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.swayam.base.Util;

public class InstructorPage extends HomePage {
	final static Logger Log = Logger
			.getLogger(CentralAdminPage.class.getName());

	Util util = new Util();

	@FindBy(className = "inputEx-UneditableField-wrapper")
	WebElement instructorID;

	@FindBy(name = "name")
	WebElement instructorNameEdit;

	@FindBy(name = "college")
	WebElement instructorCollegeEdit;

	@FindBy(name = "photo_url")
	WebElement instructorPhotoEdit;

	@FindBy(id = "gcb-footer")
	// yui-gen2000000_editor
	WebElement instructorBio;

	@FindBy(className = "inputEx-List-link")
	WebElement addInstructorEmailLink;

	@FindBy(name = "managing_emails[0]")
	WebElement instructorEmailEdit;

	@FindBy(xpath = "//input[@type='search']")
	WebElement instructorSearch;

	@FindBy(className = "yui3-aclist-content")
	WebElement instructorListContainer;

	@FindBy(xpath = "//ul[@role='listbox']/li")
	List<WebElement> instructorList;

	@FindBy(xpath = "//div[@class='CodeMirror-code']//pre")
	WebElement instructorBioView;

	@FindBy(name = "course:explorer_instructor_name")
	WebElement instructorNameOnCourseSettings;

	@FindBy(name = "course:instructor_institute")
	WebElement instructorCollegeOnCourseSettings;

	@FindBy(xpath = "//div[@class='gcb-lesson-content']/div/div[1]/img")
	WebElement instructorImgOnCourseSettings;

	@FindBy(xpath = "//div[@class='gcb-lesson-content']/div/div[1]/h3")
	WebElement instructorNameOnBio;

	@FindBy(xpath = "//div[@class='gcb-lesson-content']/div/div[1]/span")
	WebElement instructorCollegeOnBio;

	@FindBy(xpath = "//div[@class='gcb-lesson-content']/div/div[2]")
	WebElement instructorBioOnCourseSeetings;

	public void enterInstructorName(String name) {
		Log.info("entering istructor name");
		name = prop.getProperty(name);
		util.waitForElementToPresent(instructorNameEdit, 10);
		instructorNameEdit.sendKeys(name);

	}

	public void enterInstructorCollege(String college) {
		Log.info("entering istructor college");
		college = prop.getProperty(college);
		util.waitForElementToPresent(instructorCollegeEdit, 10);
		instructorCollegeEdit.sendKeys(college);

	}

	public void enterInstructorPhoto(String photoURL) {
		Log.info("entering istructor photo URL");
		photoURL = prop.getProperty(photoURL);
		util.waitForElementToPresent(instructorPhotoEdit, 10);
		instructorPhotoEdit.sendKeys(photoURL);

	}

	public void enterInstructorBio(String bio) {
		Log.info("entering istructor bio");
		bio = prop.getProperty(bio);
		util.fillRichTextField("yui-gen2000000_editor", bio);
	}

	public void enterInstructoremail(String email) {
		Log.info("entering istructor email");
		email = prop.getProperty(email);
		util.waitForElementToPresent(addInstructorEmailLink, 10);
		addInstructorEmailLink.click();
		util.waitForElementToPresent(instructorEmailEdit, 10);
		instructorEmailEdit.sendKeys(email);
	}

	public void storeinstructorID(String idholder) {
		util.waitForElementToPresent(instructorID, 10);
		prop.setProperty(idholder, instructorID.getText());
	}

	public void openInstructorById(String instructorID) {
		Log.info("openning istructor by its ID");
		util.clickOnLinkByProperty(instructorID);
	}

	public void verifyInstructorName(String name) {
		name = prop.getProperty(name);
		Log.info("veriying instructor name value on saved instructor " + name);
		util.waitForElementToPresent(instructorNameEdit, 10);
		Assert.assertEquals(instructorNameEdit.getAttribute("value"), name);

	}

	public void verifyInstructorCollege(String college) {
		college = prop.getProperty(college);
		Log.info("veriying instructor college value on saved instructor "
				+ college);
		util.waitForElementToPresent(instructorCollegeEdit, 10);
		Assert.assertEquals(instructorCollegeEdit.getAttribute("value"),
				college);
	}

	public void verifyInstructorPhoto(String photoURL) {
		photoURL = prop.getProperty(photoURL);
		Log.info("veriying instructor name photo URL on saved instructor "
				+ photoURL);
		util.waitForElementToPresent(instructorPhotoEdit, 10);
		Assert.assertEquals(instructorPhotoEdit.getAttribute("value"), photoURL);

	}

	public void verifyInstructorBio(String bio) {
		bio = prop.getProperty(bio);
		Log.info("Verifying instructor bio as " + bio);
		Assert.assertEquals(instructorBioView.getText(), bio);

	}

	public void verifyInstructoremail(String email) {
		email = prop.getProperty(email);
		Log.info("veriying instructor email value on saved instructor " + email);
		util.waitForElementToPresent(instructorEmailEdit, 10);
		Assert.assertEquals(instructorEmailEdit.getAttribute("value"), email);
	}

	public void verifyInstructorNameOnSettingsPage(String name) {
		name = prop.getProperty(name);
		Log.info("veriying instructor name value on populated instructor "
				+ name);
		util.waitForElementToPresent(instructorNameOnCourseSettings, 10);
		Assert.assertEquals(
				instructorNameOnCourseSettings.getAttribute("value"), name);
	}

	public void verifyInstructorCollegeOnSettingsPage(String college) {
		college = prop.getProperty(college);
		Log.info("veriying instructor college value on populated instructor "
				+ college);
		util.waitForElementToPresent(instructorCollegeOnCourseSettings, 10);
		Assert.assertEquals(
				instructorCollegeOnCourseSettings.getAttribute("value"),
				college);
	}

	public void verifyInstructorPhotoOnSettingsPage(String photoURL) {

		photoURL = prop.getProperty(photoURL);
		Log.info("veriying instructor photo url value on populated instructor "
				+ photoURL);
		Assert.assertEquals(instructorImgOnCourseSettings.getAttribute("src"),
				photoURL);
	}

	public void verifyInstructorBioOnSettingsPage(String bio) {
		bio = prop.getProperty(bio);
		Log.info("veriying instructor bio text  on populated instructor " + bio);
		Assert.assertEquals(instructorBioOnCourseSeetings.getText(), bio);
	}

	public void populateInstructor(String instructorId, String name) {
		Log.info("populating instructor using instructor id");
		instructorId = prop.getProperty(instructorId);
		name = prop.getProperty(name);
		util.waitForElementToPresent(instructorSearch, 10);
		instructorSearch.clear();
		instructorSearch.sendKeys(instructorId);
		util.waitForElementToPresent(instructorListContainer, 5);
		for (WebElement instructor : instructorList) {
			if (instructor.getText().contains(instructorId)) {
				instructor.click();
				try {
					Thread.sleep(2000);
				} catch (Exception e) {
				}
				break;

			}
		}
		util.clickOnButton("Populate");

	}

}