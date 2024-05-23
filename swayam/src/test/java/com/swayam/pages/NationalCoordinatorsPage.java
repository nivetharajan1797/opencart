package com.swayam.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.swayam.base.Util;

public class NationalCoordinatorsPage extends HomePage {

	final static Logger Log = Logger.getLogger(NationalCoordinatorsPage.class
			.getName());
	Util util = new Util();
	String ncName = "";
	String ncCode = "";

	@FindBy(id = "menu-group__national_coordinator")
	WebElement nationalCoordinatorMenu;

	@FindBy(id = "menu-item__national_coordinator__national_coordinator")
	WebElement manageNationalCoordinatorMenu;

	@FindBy(name = "code")
	WebElement nationalCoordinatorCode;

	@FindBy(name = "name")
	WebElement nationalCoordinatorName;

	@FindBy(name = "description")
	WebElement nationalCoordinatorDescription;

	@FindBy(name = "url")
	WebElement nationalCoordinatorUrl;

	@FindBy(name = "logo_url")
	WebElement nationalCoordinatorLogoUrl;

	@FindBy(name = "admin_email")
	WebElement nationalCoordinatorAdminEmail;

	@FindBy(name = "support_email")
	WebElement nationalCoordinatorSupportEmail;

	@FindBy(name = "address")
	WebElement nationalCoordinatorAddress;

	@FindBy(name = "phone_number")
	WebElement nationalCoordinatorPhoneNumber;

	@FindBy(name = "institutes_engaged")
	WebElement nationalCoordinatorInstitutesEngaged;

	@FindBy(name = "completed_courses")
	WebElement nationalCoordinatorCompletedcCourses;

	@FindBy(name = "completed_enrollments")
	WebElement nationalCoordinatorCompletedEnrollments;

	@FindBy(name = "completed_exam_registrations")
	WebElement nationalCoordinatorCompletedExamRegistrations;

	@FindBy(name = "completed_certifications")
	WebElement nationalCoordinatorCompletedCertifications;

	@FindBy(name = "ongoing_courses")
	WebElement nationalCoordinatorOngoingCourses;

	@FindBy(name = "ongoing_enrollments")
	WebElement nationalCoordinatorOngoingEnrollments;

	@FindBy(name = "ongoing_exam_registrations")
	WebElement nationalCoordinatorOngoingExamRegistrations;

	@FindBy(name = "short_name")
	WebElement nationalCoordinatorShortName;

	@FindBy(xpath = "//div[@class='inputEx-UneditableField-wrapper']")
	WebElement ncNonEditableCode;

	@FindBy(xpath = "//div[@class='CodeMirror-code']//pre")
	WebElement descriptionCodeview;

	public NationalCoordinatorsPage() {
		super();
	}

	public void gotoNCPage() {
		Log.info("Going to National Coordinator  page");
		util.WaitForElementToBeClickable(nationalCoordinatorMenu, 20);
		nationalCoordinatorMenu.click();
		util.WaitForElementToBeClickable(manageNationalCoordinatorMenu, 20);
		manageNationalCoordinatorMenu.click();

	}

	public void verifyNCPage() {
		Log.info("Verifying NC page on Central dashboard");
		WebElement header = driver.findElement(By.tagName("h3"));
		util.waitForElementToPresent(header, 20);
		Assert.assertEquals(header.getText(), "Add National Coordinators");
	}

	public void enterNcCode(String code) {
		Log.info("Entering NC code on NC form as " + code);
		// code = code + util.generateRandomString();
		// this.ncCode = code;
		util.waitForElementToPresent(nationalCoordinatorCode, 10);
		nationalCoordinatorCode.clear();
		nationalCoordinatorCode.sendKeys(code);
	}

	public void enterNcName(String name) {
		name = prop.getProperty(name);
		Log.info("Entering NC name on NC form as " + name);
		nationalCoordinatorName.clear();
		nationalCoordinatorName.sendKeys(name);
	}

	public void enterNcDescription(String description) {
		description = prop.getProperty(description);
		Log.info("Entering NC description on NC form as " + description);
		WebElement iframe = driver.findElement(By.id("yui-gen2000000_editor"));
		driver.switchTo().frame(iframe);
		driver.findElement(By.tagName("Body")).sendKeys(description);
		driver.switchTo().defaultContent();
	}

	public void enterNcLogoUrl(String logoUrl) {
		logoUrl = prop.getProperty(logoUrl);
		Log.info("Entering NC logoUrl on NC form as " + logoUrl);
		nationalCoordinatorLogoUrl.clear();
		nationalCoordinatorLogoUrl.sendKeys(logoUrl);
	}

	public void enterNcUrl(String url) {
		Log.info("Entering NC Url on NC form as " + url);
		nationalCoordinatorUrl.clear();
		nationalCoordinatorUrl.sendKeys(url);
	}

	public void enterNcEmail(String email) {
		Log.info("Entering NC email on NC form as " + email);
		nationalCoordinatorAdminEmail.clear();
		nationalCoordinatorAdminEmail.sendKeys(email);
	}

	public void verifyNewNCUnderNcTable() {
		List<String> ncRecord = util.getRowRecordsFromTable(ncName);
		if (ncRecord == null)
			Assert.assertFalse(false, "NC name not found on the table");
		Log.info("Verifying created NC on NC table");
		Assert.assertEquals(ncRecord.get(0), ncCode);
		Assert.assertEquals(ncRecord.get(0), ncName);

	}

	public void enterNcSupportEmail(String supportEmail) {
		Log.info("Entering NC support Email on NC form as " + supportEmail);
		nationalCoordinatorSupportEmail.sendKeys(supportEmail);
	}

	public void enterNcAddress(String address) {
		address = prop.getProperty(address);
		Log.info("Entering NC address on NC form as " + address);
		nationalCoordinatorAddress.sendKeys(address);
	}

	public void enterNcPhoneNumber(String phoneNumber) {
		Log.info("Entering NC phone Number on NC form as " + phoneNumber);
		nationalCoordinatorPhoneNumber.sendKeys(phoneNumber);
	}

	public void enterNcInstitutesEngaged(String institutesEngaged) {
		Log.info("Entering NC institutes Engaged  on NC form as "
				+ institutesEngaged);
		nationalCoordinatorInstitutesEngaged.sendKeys(institutesEngaged);

	}

	public void enterNcCompletedCourses(String completedcCourses) {
		Log.info("Entering NC completedc Courses  on NC form as "
				+ completedcCourses);
		nationalCoordinatorCompletedcCourses.sendKeys(completedcCourses);
	}

	public void enterNcStudentsEnrolled(String studentEnrolled) {
		Log.info("Entering NC student Enrolled on NC form as "
				+ studentEnrolled);
		nationalCoordinatorCompletedEnrollments.sendKeys(studentEnrolled);
	}

	public void enterNcExamRegistrations(String examRegistration) {
		Log.info("Entering NC exam Registration on NC form as "
				+ examRegistration);
		nationalCoordinatorCompletedExamRegistrations
				.sendKeys(examRegistration);
	}

	public void enterNcCertifications(String certifications) {
		Log.info("Entering NC certifications on NC form as " + certifications);
		nationalCoordinatorCompletedCertifications.sendKeys(certifications);
	}

	public void enterNcOngoingCourses(String ongoingCourses) {
		Log.info("Entering ongoing Courses on NC form as " + ongoingCourses);
		nationalCoordinatorOngoingCourses.sendKeys(ongoingCourses);
	}

	public void enterNcOngoingstudentEnrollment(String ongoingEnrollment) {
		Log.info("Entering ongoing Enrollment on NC form as "
				+ ongoingEnrollment);
		nationalCoordinatorOngoingEnrollments.sendKeys(ongoingEnrollment);
	}

	public void enterNcOngoingExamRegistrations(String ongoingRegistration) {
		Log.info("Entering ongoing Registration on NC form as "
				+ ongoingRegistration);
		nationalCoordinatorOngoingExamRegistrations
				.sendKeys(ongoingRegistration);
	}

	public void enterNcShortName(String shortName) {
		Log.info("Entering shortName on NC form as " + shortName);
		nationalCoordinatorShortName.sendKeys(shortName);

	}

	public void verifyNcCode(String ncCode) {
		Log.info("Verifying NC code as " + ncCode);
		util.waitForElementToPresent(ncNonEditableCode, 10);
		Assert.assertEquals(ncNonEditableCode.getText(), ncCode);

	}

	public void verifyNcName(String name) {
		name = prop.getProperty(name);
		Log.info("Verifying NC name as " + name);
		Assert.assertEquals(nationalCoordinatorName.getAttribute("value"), name);

	}

	public void verifyNcShortName(String shortName) {
		Log.info("Verifying NC shortName as " + shortName);
		Assert.assertEquals(nationalCoordinatorShortName.getAttribute("value"),
				shortName);
	}

	public void verifyNcDescription(String description) {
		description = prop.getProperty(description);
		Log.info("Verifying NC description as " + description);
		Assert.assertEquals(descriptionCodeview.getText(), description);
	}

	public void verifyNcUrl(String url) {
		Log.info("Verifying NC url as " + url);
		Assert.assertEquals(nationalCoordinatorUrl.getAttribute("value"), url);
	}

	public void verifyNcLogoUrl(String logoUrl) {
		logoUrl = prop.getProperty(logoUrl);
		Log.info("Verifying NC logoUrl as " + logoUrl);
		Assert.assertEquals(nationalCoordinatorLogoUrl.getAttribute("value"),
				logoUrl);
	}

	public void verifyNcEmail(String adminEmail) {
		Log.info("Verifying NC admin Email as " + adminEmail);
		Assert.assertEquals(
				nationalCoordinatorAdminEmail.getAttribute("value"), adminEmail);

	}

	public void verifyNcPhoneNumber(String phoneNumber) {
		Log.info("Verifying NC phone Number as " + phoneNumber);
		Assert.assertEquals(
				nationalCoordinatorPhoneNumber.getAttribute("value"),
				phoneNumber);
	}

	public void verifyNcSupportEmail(String supportEmail) {
		Log.info("Verifying NC support Email as " + supportEmail);
		Assert.assertEquals(
				nationalCoordinatorSupportEmail.getAttribute("value"),
				supportEmail);
	}

	public void verifyNcAddress(String address) {
		address = prop.getProperty(address);
		Log.info("Verifying NC address as " + address);
		Assert.assertEquals(nationalCoordinatorAddress.getText(), address);

	}

	public void removeNC(String code) {

		if (util.isElementPresent(code)) {
			Log.info("removing the NC bu its code -" + code);
			util.clickOnLink(code);
			util.waitForElementToPresent(nationalCoordinatorShortName, 10);
			util.clickOnLink("Delete");
			util.handleAlert();
		}

	}

}
