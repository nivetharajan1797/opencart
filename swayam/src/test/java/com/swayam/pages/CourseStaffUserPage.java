package com.swayam.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.swayam.base.Util;

public class CourseStaffUserPage extends HomePage {

	Util util = new Util();
	static String studentID;

	@FindBy(tagName = "h1")
	WebElement pageHeader;

	@FindBy(tagName = "h4")
	WebElement instructorElement;

	@FindBy(xpath = "//div[@class='gcb-article tab-content']/div[2]")
	WebElement evalSubmissionText;

	@FindBy(tagName = "table")
	WebElement tableElement;

	@FindBy(xpath = "//table//tr/td[2]")
	List<WebElement> evaluationList;

	@FindBy(xpath = "//table//tr/td[1]")
	List<WebElement> studentIdList;

	@FindBy(xpath = "//iframe[@class='cke_wysiwyg_frame cke_reset']")
	List<WebElement> rteList;

	@FindBy(id = "gcb-submit-comments")
	WebElement commentLabel;

	@FindBy(id = "score")
	WebElement scoreSelect;

	public void verifyCourseStaffUserPage(String expectedHeader) {
		Log.info("verifying header of course staff home page");
		expectedHeader = prop.getProperty(expectedHeader);
		util.waitForElementToPresent(pageHeader, 10);
		System.out.println(pageHeader.getText());
		System.out.println("expectedHeader- " + expectedHeader);
		Assert.assertEquals(expectedHeader, pageHeader.getText().trim());
	}

	public void verifyCourseStaffUserPageForSubmission(String assignmentName) {
		Log.info("verifying header of evaluate page");
		String expectedHeader = "Evaluate : "
				+ prop.getProperty(assignmentName);
		util.waitForElementToPresent(pageHeader, 10);
		System.out.println(pageHeader.getText());
		System.out.println("expectedHeader" + expectedHeader);
		Assert.assertEquals(expectedHeader, pageHeader.getText().trim());

	}

	public void verifyEvaluationSubmissionPage(String msg) {
		util.waitForElementToPresent(evalSubmissionText, 10);
		String expectedText = prop.getProperty(msg);
		Log.info("verifyig evalutaed submission message for course staff page"
				+ msg);
		System.out.println(evalSubmissionText.getText());
		System.out.println("expectedHeader" + expectedText);
		Assert.assertEquals(expectedText, evalSubmissionText.getText().trim());
	}

	public void verifyEvaluationTable() {
		Log.info("verifyig evaluator table on course staff page");
		util.waitForElementToPresent(tableElement, 10);
		studentID = studentIdList.get(0).getText().trim();
		System.out.println("studentID " + studentID);
		Assert.assertEquals("Evaluate", evaluationList.get(0).getText().trim());
	}

	public void verifyEvaluatorPage() {
		Log.info("verifyig evaluator view on course staff page");
		String expectedHeader = "Evaluate " + studentID + " for "
				+ prop.getProperty("sub.assignment.title");
		util.waitForElementToPresent(pageHeader, 10);
		System.out.println(pageHeader.getText());
		System.out.println("expectedHeader " + expectedHeader);
	//	Assert.assertEquals(expectedHeader, pageHeader.getText());
		String instructionText = prop.getProperty("score.instruction.text");
		Assert.assertEquals(instructionText, instructorElement.getText().trim());
		Assert.assertEquals(2, rteList.size());
	}

	public void verifyStudentSubmission(String studentSolution) {
		Log.info("verifyig student's submission on course staff page");
		WebElement submissionFrame = rteList.get(0);
		String submissionSoluton = util
				.getValueOfRichTextField(submissionFrame);
		String expectedSubmission = prop.getProperty(studentSolution);
		System.out.println("submissionSoluton" + submissionSoluton);
		System.out.println("expectedSubmission" + expectedSubmission);
		Assert.assertEquals(expectedSubmission, submissionSoluton);

	}

	public void verifyCommentsEditor() {
		util.waitForElementToPresent(commentLabel, 10);
		Log.info("verifying comment editor on course staff page");
		Assert.assertTrue(commentLabel.getText().contains("Comments:"));
	}

	public void enterComments(String comments) {
		comments = prop.getProperty(comments);
		Log.info("entering course staff comments -" + comments);
		util.fillRichTextField(rteList.get(1), comments);
	}

	public void setScores(String score) {
		Log.info("course staff putting score -" + score);
		util.waitForElementToPresent(scoreSelect, 30);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		util.selectAnOption(scoreSelect, score);
	}

}
