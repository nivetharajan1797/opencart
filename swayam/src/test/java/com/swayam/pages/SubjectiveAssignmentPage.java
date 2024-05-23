package com.swayam.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.swayam.base.Util;

public class SubjectiveAssignmentPage extends HomePage {
	final static Logger Log = Logger.getLogger(ExplorerPage.class.getName());
	Util util = new Util();

	@FindBy(xpath = "//iframe[@class='cke_wysiwyg_frame cke_reset']")
	WebElement solutiontextbox;

	@FindBy(xpath = "//button[contains(.,'Submit')]")
	WebElement submitBtn;

	@FindBy(className = "gcb-submit-only-once")
	WebElement messageForSubmission;

	@FindBy(xpath = "//*[@id='gcb-submit-essay']/div/strong")
	WebElement submitConfirmationMsg;

	public void enterSubjectiveAssignmentSoluation(String solution) {
		solution = prop.getProperty(solution);
		Log.info("entering subjective assignment solution");
		util.fillRichTextField(solutiontextbox, solution);
	}

	public void submitTheSolution() {
		Log.info("submitting subjective assignment");
		submitBtn.click();
	}

	public void verifyAssignmentSubmission(String expectedMessage) {
		expectedMessage = prop.getProperty(expectedMessage);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd, HH:mm");
		Calendar c = Calendar.getInstance();
		String date = sdf.format(c.getTime());
		expectedMessage = expectedMessage + " " + date + " IST";
		Log.info("expected confirmation message is " + expectedMessage);
		util.waitForElementToPresent(submitConfirmationMsg, 10);
		String actualMessage = submitConfirmationMsg.getText().trim();
		Assert.assertEquals(expectedMessage, actualMessage);
	}

	public void verifyScoreAndCommentOnSA(String scoreText, String comment) {
		scoreText = prop.getProperty(scoreText);
		comment = prop.getProperty(comment);
		String postEvalText = messageForSubmission.getText();
		String[] actualText = postEvalText.split("\n");
		Log.info("verifying score text on subjective assignment");
		Assert.assertEquals(scoreText, actualText[2]);
	//	Assert.assertEquals("Evaluator comments:", actualText[4]);
		Assert.assertEquals("Latest evaluator comments:", actualText[4]);
		Log.info("verifying evaluator comment on subjective assignment");
		Assert.assertEquals(comment, actualText[5]);
	}
}
