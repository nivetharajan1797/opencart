package com.swayam.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.swayam.base.Util;

public class AnnouncementPage extends HomePage {

	final static Logger Log = Logger.getLogger(NodeAdminPage.class.getName());
	Util Util = new Util();

	@FindBy(className = "inputEx-Group-legend")
	WebElement AnnouncementPageHeader;

	@FindBy(name = "title")
	WebElement announcementPageTitle;

	@FindBy(name = "is_draft")
	WebElement announcementStatus;

	@FindBy(className = "gcb-announcement-title")
	WebElement announcementTitle;
	
	@FindBy(xpath = "//label[contains(.,'Status')]")
	WebElement textStatus;

	public void verifyAnnouncementPage() {
		Log.info("verifying user is on announcement page");
		Util.waitForElementToPresent(AnnouncementPageHeader, 10);
		Assert.assertEquals(AnnouncementPageHeader.getText().trim(),
				"Announcement");
	}

	public void enterAnnouncementPageTitle(String title) {
		Log.info("entering announcement title");
		title = prop.getProperty(title);
		announcementPageTitle.clear();
		announcementPageTitle.sendKeys(title);
	}

	public void enterAnnouncementBody(String body) {
		Log.info("entering announcement text");
		Util.fillRichTextField("yui-gen2000000_editor", prop.getProperty(body));
	}

	public void setStatus(String status) {
		Log.info("setting announcement visibility to : "+status);
		Util.waitForElementToPresent(textStatus, 20);
		textStatus.click();
		Util.waitForElementToPresent(announcementStatus, 20);
		Util.selectAnOption(announcementStatus, status);
	}

	public void verifyAnnouncementcontent(String title, String body, String date) {
		title = prop.getProperty(title);
		date = prop.getProperty(date);
		body = prop.getProperty(body);
		Log.info("verifying announcement cotents title, date & its body");
		
		Util.waitForElementToPresent(announcementTitle, 30);
		
		Assert.assertEquals(announcementTitle.getText().trim(), title);
		Assert.assertEquals(getAnnouncementBody(title), body);
		Assert.assertEquals(announcementTitle.getText().trim(), title);
	}

	public String getAnnouncementBody(String title) {
		return Util.getElementUsingLabelText("announcement.body", title)
				.getText().trim();

	}

	public void verifyAssessmentDueDate(String title, String dueDate) {
		Log.info("verifying announcement due date");
		Util.waitForElementToPresent(announcementTitle, 15);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, Integer.valueOf(prop.getProperty(dueDate)));
		String date = sdf.format(c.getTime());
		Assert.assertTrue(Util
				.getElementUsingLabelText("announcement.body", title).getText()
				.trim().contains(date));
	}

	public void verifyAnnouncementStatus(String status, String announcementName) {
		Log.info("verifying announcement status as: " + status);
		announcementName = prop.getProperty(announcementName);
		WebElement statusIcon = Util.getElementUsingLabelText(
				"announcement.status.icon", announcementName);
		Assert.assertTrue(statusIcon.getAttribute("class").endsWith(status));
	}

	public void setAnnouncementStatus(String status, String announcementName) {
		Log.info("setting announcement status as: " + status);
		announcementName = prop.getProperty(announcementName);
		WebElement statusIcon = Util.getElementUsingLabelText(
				"announcement.status.icon", announcementName);
		statusIcon.click();
		
	}

	public void setAnnouncementDate(String phase) {
		setDueDate(phase, "Date");
	}

	public void setDueDate(String phase, String label) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int currentDay = c.get(Calendar.DAY_OF_MONTH);
		int currentMonth = c.get(Calendar.MONTH);
		int changedMonth=c.get(Calendar.MONTH);
		String monthStatus ="";
		switch (phase.toUpperCase()) {
		case "FUTURE":
			c.add(Calendar.DAY_OF_MONTH, 1);
			currentDay = c.get(Calendar.DAY_OF_MONTH);
			changedMonth = c.get(Calendar.MONTH);
			monthStatus = changedMonth > currentMonth ? "future" : "same";
			String dateFuture = sdf.format(c.getTime());
			Log.info("Future date is set to " + dateFuture + "month is " + monthStatus);
			break;
		case "PAST":
			c.add(Calendar.DAY_OF_MONTH, -1);
			currentDay = c.get(Calendar.DAY_OF_MONTH);
			changedMonth = c.get(Calendar.MONTH);
			monthStatus = changedMonth < currentMonth ? "past" : "same";
			String datePast = sdf.format(c.getTime());
			Log.info("Future date is set to " + datePast + "month is " + monthStatus);
			break;
		default:
			break;
		}
		prop.setProperty("announcement.date", String.valueOf(currentDay)+"-"+ String.valueOf(changedMonth));
		WebElement assessmentDueDate = Util.getElementUsingLabelText(
				"admin.label.date", label);
		Util.WaitForElementToBeClickable(assessmentDueDate, 15);
		assessmentDueDate.click();
		Util.datePicker(String.valueOf(currentDay),monthStatus);
	}

	public void verifyPresenceOfAnnouncement(String announcementName) {
		Log.info("verifying presence of announcement");
		announcementName = prop.getProperty(announcementName);
		Boolean isAnnouncmentPresent = Util.isElementPresentByXpath(Util
				.getFormatedLocator("announcement.by.title", announcementName));
		Assert.assertFalse(isAnnouncmentPresent);
	}
}
