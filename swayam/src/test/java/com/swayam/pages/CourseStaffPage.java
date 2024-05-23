package com.swayam.pages;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.swayam.base.Util;

public class CourseStaffPage extends HomePage {

	final static Logger Log = Logger.getLogger(NodeAdminPage.class.getName());
	Util util = new Util();

	@FindBy(name = "course_staff_email_list")
	WebElement emailTextArea;

	@FindBy(tagName = "h2")
	WebElement courseStaffPageHeader;

	@FindBy(tagName = "h3")
	WebElement courseStaffSuccessPageHeader;

	public void verifyCourseStaffPage() {
		System.out.println(courseStaffPageHeader.getText());
		util.WaitForElementTextToBePresent(courseStaffPageHeader,
				"Add Course Staff", 10);
	}

	public void enterCourseStaffEmail(String emailid) {
		emailTextArea.clear();
		emailTextArea.sendKeys(emailid);
	}

	public void addCourseStaff(String emailid) {
		emailid = prop.getProperty(emailid);
		enterCourseStaffEmail(emailid);
		emailTextArea.submit();
	}

	public void verifyCourseStaffAddition(String message) {
		message = prop.getProperty(message);
		System.out.println(courseStaffSuccessPageHeader.getText());
		util.waitForElementToPresent(courseStaffSuccessPageHeader, 20);
		Assert.assertEquals(courseStaffSuccessPageHeader.getText(), message);

	}

}
