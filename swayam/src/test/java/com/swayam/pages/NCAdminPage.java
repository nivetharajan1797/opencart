package com.swayam.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.swayam.base.Util;

public class NCAdminPage extends HomePage {

	final static Logger Log = Logger.getLogger(NCAdminPage.class.getName());
	
	
	@FindBy(className = "blueBarTitle")
	WebElement NCTitleBar;

	@FindBy(className = "size20")
	WebElement NcNameOnDetailPage;

	@FindBy(className = "webLink")
	WebElement NcWebsiteLink;

	@FindBy(xpath = "//div[@class='np_address']//p")
	List<WebElement> NcAddressSection;

	@FindBy(xpath = "//div[@class='np_address']/following-sibling::div")
	WebElement ongoingSection;

	@FindBy(xpath = "//div[@class='container iconsContainer']//p")
	List<WebElement> NcDashboardSection;

	@FindBy(xpath = "//div[@class='bottomBorder']/span")
	List<WebElement> ongoingDashboard;

	public NCAdminPage() {
		super();
	}

	public void verifyUserOnNcPage() {
		Log.info("Verifying user is on NC page");
		Util util = new Util();
		util.waitForElementToPresent(NCTitleBar, 10);
		Assert.assertTrue(NCTitleBar.getText().equals("National Coordinators"));
	}

	public void verifyNcNameOnCard(String ncShortName, String name) {
		name = prop.getProperty(name);
		Log.info("Verifying NC Name on NC card as " + name);
		Util util = new Util();
		String ncCodeLocator = util.getFormatedLocator("nc.card.code",
				ncShortName);
		WebElement ncCodeElement = util.waitForElementToPresent(ncCodeLocator,
				10);
		Assert.assertEquals(ncCodeElement.getText(), name);
	}

	public void verifyNcImageOnCard(String ncShortName, String imageUrl) {
		imageUrl = prop.getProperty(imageUrl);
		Log.info("Verifying NC image url on NC card as " + imageUrl);
		Util util = new Util();
		String ncImageLocator = util.getFormatedLocator("nc.card.image",
				ncShortName);
		WebElement ncImageElement = util.waitForElementToPresent(
				ncImageLocator, 10);
		Assert.assertEquals(ncImageElement.getAttribute("src"), imageUrl);
	}

	public void goToNCDetailPage(String ncShortName) {
		Log.info("Going to NC detail page by clicking on NC " + ncShortName);
		Util util = new Util();
		String ncLinkLocator = util.getFormatedLocator("nc.card.link",
				ncShortName);
		WebElement ncLinkElement = util.waitForElementToPresent(ncLinkLocator,
				10);
		ncLinkElement.click();
	}

	public void verifyUserIsOnNcDetailPage(String ncName) {
		ncName = prop.getProperty(ncName);
		Log.info("Verifying user is on NC detail page " + ncName);
		Util util = new Util();
		util.waitForElementToPresent(NcNameOnDetailPage, 10);
		Assert.assertTrue(NcNameOnDetailPage.getText().equals(ncName));
	}

	public void verifyNcDesriptionOnDetailPage(String ncName, String description) {
		description = prop.getProperty(description);
		Log.info("Verifying user is on NC description on detail page as "
				+ description);
		ncName = prop.getProperty(ncName);
		Util util = new Util();
		String ncDescriptionLocator = util.getFormatedLocator(
				"nc.detail.description", ncName);
		WebElement ncDescriptionElement = util.waitForElementToPresent(
				ncDescriptionLocator, 10);
		Assert.assertTrue(ncDescriptionElement.getText().equals(description));
	}

	public void verifyNcAddressSectionOnDetailPage(String websiteUrl,
			String address, String supportEmail, String phoneNumber) {
		address = prop.getProperty(address);
		Util util = new Util();
		util.waitForElementsToPresent(NcAddressSection, 10);
		Log.info("Verifying Wensite URL as" + websiteUrl);
		Assert.assertEquals(NcAddressSection.get(0).getText(), websiteUrl);
		Log.info("Verifying address as" + address);
		Assert.assertEquals(NcAddressSection.get(1).getText(), address.trim()
				.replaceAll("\\s{2,}", " "));
		Log.info("Verifying support email as" + supportEmail);
		Assert.assertEquals(
				NcAddressSection.get(2).getText().replace("|   ", "").trim(),
				supportEmail);
		Log.info("Verifying phone number as" + phoneNumber);
		Assert.assertEquals(
				NcAddressSection.get(3).getText().replace("|   ", "").trim(),
				phoneNumber);

	}

	public void verifyNcDashboardOnDetailPage(String institutesEngagedCount,
			String completedCoursesCount, String studentsEnrolledCount,
			String examRegistrationsCount, String CertificationsCount) {
		Log.info("Verifying institutes Engaged Count on dashboard as " + institutesEngagedCount);
		Assert.assertEquals(NcDashboardSection.get(0).getText(),
				institutesEngagedCount);
		Assert.assertEquals(NcDashboardSection.get(1).getText(),
				prop.get("nc.institutes.engaged"));
		Log.info("Verifying completed Courses Count on dashboard as " + completedCoursesCount);
		Assert.assertEquals(NcDashboardSection.get(2).getText(),
				completedCoursesCount);
		Assert.assertEquals(NcDashboardSection.get(3).getText(),
				prop.get("nc.completed.courses"));
		Log.info("Verifying students Enrolled Count on dashboard as " + studentsEnrolledCount);
		Assert.assertEquals(NcDashboardSection.get(4).getText(),
				studentsEnrolledCount);
		Assert.assertEquals(NcDashboardSection.get(5).getText(),
				prop.get("nc.students.enrolled"));
		Log.info("Verifying exam Registrations Count on dashboard as " + examRegistrationsCount);
		Assert.assertEquals(NcDashboardSection.get(6).getText(),
				examRegistrationsCount);
		Assert.assertEquals(NcDashboardSection.get(7).getText(),
				prop.get("nc.examRegistrations"));
		Log.info("Verifying Certifications Count on dashboard as " + CertificationsCount);
		Assert.assertEquals(NcDashboardSection.get(8).getText(),
				CertificationsCount);
		Assert.assertEquals(NcDashboardSection.get(9).getText(),
				prop.get("nc.certifications"));
	}

	public void verifyOngoingSection(String coursesCount,
			String studentEnrollmentCount, String examRegistrationsCount) {
		Assert.assertTrue(
				ongoingSection.getText().contains("ONGOING SEMESTER STATS"),
				"ONGOING section text not matching");
		Log.info("Verifying courses Count on ongoing section as " + coursesCount);
		Assert.assertEquals(ongoingDashboard.get(0).getText(),
				prop.get("nc.ongoing.courses"));
		Assert.assertEquals(ongoingDashboard.get(1).getText(), coursesCount);

		Log.info("Verifying student Enrollment Count on ongoing section as " + studentEnrollmentCount);
		Assert.assertEquals(ongoingDashboard.get(2).getText(),
				prop.get("nc.ongoing.studentEnrollment"));
		Assert.assertEquals(ongoingDashboard.get(3).getText(),
				studentEnrollmentCount);
		Log.info("Verifying exam Registrations Count on ongoing section as " + examRegistrationsCount);
		Assert.assertEquals(ongoingDashboard.get(4).getText(),
				prop.get("nc.ongoing.examRegistrations"));
		Assert.assertEquals(ongoingDashboard.get(5).getText(),
				examRegistrationsCount);

	}
}
