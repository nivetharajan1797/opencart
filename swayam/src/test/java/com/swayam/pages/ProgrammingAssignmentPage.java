package com.swayam.pages;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.swayam.base.Util;

public class ProgrammingAssignmentPage extends HomePage {

	final static Logger Log = Logger.getLogger(ExplorerPage.class.getName());
	Util Util = new Util();

	@FindBy(className = "gcb-unit-header")
	WebElement assignmentHeader;

	@FindBy(xpath = "//div[@class='gcb-article tab-content']/div[3]/div[1]")
	WebElement problemStatement;

	@FindBy(id = "prog-assignment-lang")
	WebElement langSupportedSelect;

	@FindBy(id = "prog-filename-java")
	WebElement fileNameField;

	@FindBy(className = "gcb-submission-due-date")
	WebElement assignmentDueDate;
	
	@FindBy(xpath = "//table[@class='gcb-sample-input-table']")
	WebElement testcaseTable;

	@FindBy(xpath = "//table[contains(@class,'gcb-sample-input-table')]//tr[2]/td")
	List<WebElement> testCaseRow;

	@FindBy(css = ".CodeMirror.cm-s-eclipse")
	WebElement codeArea;

	@FindBy(id = "compile-code-button")
	WebElement compileAndRunBtn;

	@FindBy(id = "submit-code-button")
	WebElement submitBtn;

	public void verifyProgAssignmentTitle(String assignmentHeaderText) {
		Log.info("verifying programming assignment title");
		Util.waitForElementToPresent(assignmentHeader, 10);
		Assert.assertEquals(assignmentHeader.getText().trim(),
				prop.getProperty(assignmentHeaderText));
	}

	public void verifyProblemStatement(String problemStatementText) {
		Log.info("verifying programming assignment's problem statement");
		Util.waitForElementToPresent(problemStatement, 10);
		Assert.assertEquals(problemStatement.getText().trim(),
				prop.getProperty(problemStatementText));
	}

	public void verifySuportedLanguages(String languageName) {
		Log.info("verifying programming assignment's supported language");
		Util.waitForElementToPresent(langSupportedSelect, 10);
		Assert.assertEquals(
				Util.isOptionPresentInDropdown(langSupportedSelect,
						prop.getProperty(languageName)), true);
	}

	public void verifyFileName(String fileNameText) {
		Log.info("verifying programming assignment's file name");
		Util.waitForElementToPresent(fileNameField, 10);
		Assert.assertEquals(fileNameField.getAttribute("value").trim(),
				prop.getProperty(fileNameText));
	}

	public void verifyAssignmentDueDate(String dueDate) {
		Log.info("verifying programming assignment due date");
		Util.waitForElementToPresent(assignmentHeader, 15);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, Integer.valueOf(prop.getProperty(dueDate)));
		String date = sdf.format(c.getTime());
		Util.waitForElementToPresent(assignmentDueDate, 15);
		Assert.assertTrue(assignmentDueDate.getText().trim().contains(date));
	}
	
	public void verifyAssignmentDueDatePast(String dueDatePast) {

        Log.info("verifying programming assignment due date");
        Util.waitForElementToPresent(assignmentHeader, 15);
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        dueDatePast = yesterday.toString();
        Util.waitForElementToPresent(assignmentDueDate, 15);
        Assert.assertTrue(assignmentDueDate.getText().trim().contains(dueDatePast));
        Log.info("Due Date for past has been verified.");
 }
	
	public void verifyAssessmentDueDateFuture(String dueDateFuture) {

        Log.info("verifying programming assignment due date");
        Util.waitForElementToPresent(assignmentHeader, 15);
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        dueDateFuture = tomorrow.toString();
        Util.waitForElementToPresent(assignmentDueDate, 15);
        Assert.assertTrue(assignmentDueDate.getText().trim().contains(dueDateFuture));
        Log.info("Due Date for future has been verified.");
    }

	public void verifyPublicTestInputOuput(String input, String output) {
		Log.info("verifying programming assignment's public test case input output");
		input = prop.getProperty(input);
		output = prop.getProperty(output);
		Assert.assertEquals(testCaseRow.get(0).getText().trim(), "Test Case 1");
		Assert.assertEquals(testCaseRow.get(1).getText().trim(), input);
		Assert.assertEquals(testCaseRow.get(2).getText().trim(), output);
	}

	public void setProgLanguage(String language) {
		Log.info("selecting programming language");
		language = prop.getProperty(language);
		Util.selectAnOption(langSupportedSelect, language);

	}

	public void enterSolutionCode(String codeSolution) {
		Log.info("entering programming assignment solution");
		codeSolution = prop.getProperty(codeSolution);
		Util.waitForElementToPresent(codeArea, 15);
		Util.enterTextIntoCodeMirror(codeArea, codeSolution);
	}

	public void compileAndRun() {
		Log.info("click on compile and run button");
		Util.waitForElementToPresent(compileAndRunBtn, 20);
		compileAndRunBtn.click();
	}

	public void verifyPublicTestCompileAndRun(String name, String input,
			String expectedoutput, String actualoutput, String status) {
		Log.info("verifying programming assignment's private test case input output");
		//Util.waitForElementToPresent(testcaseTable, 20);
		Assert.assertEquals(testCaseRow.get(0).getText().trim(), name);
		Assert.assertEquals(testCaseRow.get(1).getText().trim(),
				prop.getProperty(input));
		Assert.assertEquals(testCaseRow.get(2).getText().trim(),
				prop.getProperty(expectedoutput));
		Assert.assertEquals(testCaseRow.get(3).getText().trim(),
				prop.getProperty(actualoutput));
		Assert.assertEquals(testCaseRow.get(4).getText().trim(), status);
	}

	public void submitCode() {
		Log.info("submitting programming assignment");
		submitBtn.click();
	}

	public void verifyCodeSubmissionBeforeDuedate(String name, String status) {
		Log.info("verifying prog assignment submission");
		Util.waitForElementsToPresent(testCaseRow, 20);
		Assert.assertEquals(testCaseRow.get(0).getText().trim(),name);
		Assert.assertEquals(testCaseRow.get(1).getText().trim(), status);
	}

}
