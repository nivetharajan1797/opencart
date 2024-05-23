package com.swayam.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.swayam.base.Util;

public class PreviewPage extends HomePage {

	final static Logger Log = Logger.getLogger(PreviewPage.class.getName());

	@FindBy(xpath = "//h2")
	WebElement pageHeading;

	@FindBy(css = ".col-lg-12.col-md-12.col-sm-12.col-xs-12")
	WebElement instructorAndInstituute;

	@FindBy(className = "marginTop25")
	WebElement aboutTheCourse;

	@FindBy(css = ".col-lg-12.col-md-12.col-sm-12.col-sm-12")
	List<WebElement> coursDetailsList;

	@FindBy(xpath = "//h3[.='SUMMARY']/../div")
	WebElement fdpStatusText;

	@FindBy(xpath = "//table[@class='summaryTable']//td[.='Course Status :']/following-sibling::td")
	WebElement CourseStatus;

	@FindBy(xpath = "//table[@class='summaryTable']//td[.='Course Type :']/following-sibling::td")
	WebElement courseType;

	@FindBy(xpath = "//table[@class='summaryTable']//td[.='Duration :']/following-sibling::td")
	WebElement duration;

	@FindBy(xpath = "//table[@class='summaryTable']//td[.='Start Date :']/following-sibling::td")
	WebElement startDate;

	@FindBy(xpath = "//table[@class='summaryTable']//td[.='End Date :']/following-sibling::td")
	WebElement endDate;

	@FindBy(xpath = "//table[@class='summaryTable']//td[.='Exam Date :']/following-sibling::td")
	WebElement examDate;

	@FindBy(xpath = "//table[@class='summaryTable']//td[.='Category :']/following-sibling::td")
	WebElement category;

	@FindBy(xpath = "//table[@class='summaryTable']//td[.='Level :']/following-sibling::td")
	WebElement level;
	
	@FindBy(xpath = "//h3[contains(.,'COURSE LAYOUT')]//parent::div")
	WebElement courseLayout;
	
	@FindBy(xpath = "//h3[contains(.,'BOOKS AND REFERENCES')]//parent::div")
	WebElement booksAndReferences;
	
	@FindBy(xpath = "//h3[contains(.,'INSTRUCTOR BIO')]//parent::div")
	WebElement instructorBio;
	
	@FindBy(xpath = "//h3[contains(.,'COURSE CERTIFICATE')]//parent::div")
	WebElement courseCertificate;
	
	@FindBy(xpath = "//h3[contains(.,'INSTRUCTOR BIO')]//parent::div//div//h3[@class='profileName']")
	WebElement instructorName;

	public PreviewPage() {
		super();
	}

	public void verifyCourseLayoutText(String courseLayoutText) {
		Log.info("verifying Course Layout Text");
//	//	Assert.assertEquals(coursDetailsList.get(2).getText().split("\n")[1],
//		Assert.assertEquals(coursDetailsList.get(1).getText().split("\n")[1],
//		prop.getProperty(courseLayoutText));
		
		Assert.assertTrue(courseLayout.getText().contains(prop.getProperty(courseLayoutText)));
	}

	public void verifyBooksReferencesText(String booksReferencesText) {
		Log.info("verifying Books & References Text");
//	//	Assert.assertEquals(coursDetailsList.get(3).getText().split("\n")[1],
//		Assert.assertEquals(coursDetailsList.get(2).getText().split("\n")[1],
//				prop.getProperty(booksReferencesText));
		
		Assert.assertTrue(booksAndReferences.getText().contains(prop.getProperty(booksReferencesText)));
	}

	public void verifyInstructorBioText(String instructorBioText) {
		Log.info("verifying Instructor Bio Text");
//	//	Log.info((coursDetailsList.get(4).getText().split("\n")[3]).trim());
//		Log.info(prop.getProperty(instructorBioText).trim());
//		Assert.assertEquals(
//	//			(coursDetailsList.get(4).getText().split("\n")[3]).trim(),
//				(coursDetailsList.get(3).getText().split("\n")[3]).trim(),
//				(prop.getProperty(instructorBioText)).trim());
		
		Assert.assertTrue(instructorBio.getText().contains(prop.getProperty(instructorBioText)));
	}

	public void verifyCourseCertificateText(String courseCertificateText) {
		Log.info("verifying Course Certificate Text");
//	//	Log.info(coursDetailsList.get(5).getText());
//		Log.info(prop.getProperty(courseCertificateText));
//
//	//	Assert.assertTrue(coursDetailsList.get(5).getText()
//		Assert.assertTrue(coursDetailsList.get(4).getText()
//				.contains(prop.getProperty(courseCertificateText)));
		
		Assert.assertTrue(courseCertificate.getText().contains(prop.getProperty(courseCertificateText)));
	}

	public void verifyInstructorInstituteText(String instructorInstituteText) {
		Log.info("verifying Instructor Institute Text");
//		Assert.assertEquals(
//				instructorAndInstituute.getText().split("   |  ")[2],
//				prop.getProperty(instructorInstituteText));
		
		Assert.assertTrue(instructorBio.getText().contains(prop.getProperty(instructorInstituteText)));
	}

	public void verifyAboutCourseText(String aboutCourseText) {
		Log.info("verifying About Course Text");
		Assert.assertEquals(aboutTheCourse.getText(),
				prop.getProperty(aboutCourseText));

	}

	public void verifyYoutubeIdValue(String youTubeId) {
		youTubeId = prop.getProperty(youTubeId);
		Util util = new Util();
		String elementXpath = util.getFormatedLocator("central.course.video",
				youTubeId);
		Log.info("verifyingYoutube Id Value");
		Assert.assertTrue(util.isElementPresentByXpath(elementXpath));

	}

	public void verifyInstructorNameText(String instructorNameText) {
		Log.info("verifying Instructor Name Text");
//		Assert.assertEquals(
//				instructorAndInstituute.getText().split("   |  ")[0], "By "
//						+ prop.getProperty(instructorBioText));
		//Assert.assertTrue(instructorName.getText().contains(prop.getProperty(instructorNameText)));
//		Assert.assertEquals(instructorName.getText(), prop.getProperty(instructorNameText));
		Assert.assertTrue(instructorName.getText().equalsIgnoreCase(prop.getProperty(instructorNameText)));
		
	}

	public void verifyCourseWeeksValue(String courseWeeksValue) {
		Log.info("verifying Course Weeks Value");
		Assert.assertEquals(duration.getText(), courseWeeksValue);

	}

	public void verifyFDPCourseStatus(String fDPCourseStatus) {
		Log.info("verifying FDP Course Status");
		Util util = new Util();
		if (fDPCourseStatus.equals("Yes"))
			Assert.assertEquals(fdpStatusText.getText(),
					prop.getProperty("course.fdp.status"));
		else
			Assert.assertFalse(util
					.isElementPresentByXpath("//h3[.='SUMMARY']/../div"));
	}

	public void verifyCourseTypeValue(String courseTypeValue) {
		Log.info("verifying Course Type Value");
		Assert.assertEquals(courseType.getText(), courseTypeValue);
	}

	public void verifyCourseLevelValue(String courseLevelValue) {
		Log.info("verifying Course Level  Value");
		Assert.assertEquals(level.getText(), courseLevelValue);
	}

}
