package com.swayam.pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.swayam.base.Util;

public class CreateQuestions extends HomePage {

	final static Logger Log = Logger.getLogger(CreateOutline.class.getName());

	Util Util = new Util();
	@FindBy(xpath = "//a[@id='menu-item__edit__questions']")
	WebElement questionsLink;

	@FindBy(xpath = "//a[contains(text(),'Add Multiple Choice')]")
	WebElement addMultipleChoice;

	@FindBy(xpath = "//a[contains(text(),'Add Short Answer')]")
	WebElement addShortAnswer;

	@FindBy(xpath = "//a[contains(text(),'Add Numerical')]")
	WebElement addNumerical;

	@FindBy(xpath = "//*[@id='yui-gen2000000_editor']")
	WebElement addQuestionTextArea;

	@FindBy(xpath = "//*[@id='yui-gen2000007']")
	WebElement txtAreaChoice1;

	@FindBy(xpath = "//*[@id='yui-gen2000006_toolbar']//div[contains(@class,'yui-toolbar-group-insertitem')]/ul/li[9]/span")
	WebElement mathFormulaIconChoice1;

	@FindBy(xpath = "//div[@class='mc-choice-container']/div[@class='inputEx-ListField-childContainer']/div[2]//fieldset/div[2]/div[2]/div[2]")
	WebElement txtAreaChoice2;

	@FindBy(xpath = "//*[@id='yui-gen2000188_toolbar']//div[contains(@class,'yui-toolbar-group-insertitem')]/ul/li[9]/span")
	WebElement mathFormulaIconChoice2;

	@FindBy(xpath = "//div[@class='sa-grader-score']/select")
	WebElement shortAnsQuestionType;
	
	@FindBy(xpath = "//div[@class='sa-grader-score']/select/option[contains(.,'Case insensitive string match')]")
	WebElement caseInsensitiveStringMatch;
	
	@FindBy(xpath = "//div[@class='sa-grader-score']/select/option[contains(.,'Case insensitive string starts with')]")
	WebElement caseInsensitiveStringStartsWith;
	
	@FindBy(xpath = "//div[@class='sa-grader-score']/select/option[contains(.,'Case insensitive string ends with')]")
	WebElement caseInsensitiveStringEndsWith;
	
	@FindBy(xpath = "//div[@class='sa-grader-score']/select/option[contains(.,'Comma-separated strings ( OR )')]")
	WebElement commaSeparatedStringsOr;
	
	@FindBy(xpath = "//div[@class='sa-grader-score']/select/option[contains(.,'Comma-separated strings ( AND )')]")
	WebElement commaSeparatedStringsAnd;

	@FindBy(xpath = "//div[@class='nm-grader-score']/select")
	WebElement numericQuestionType;

	@FindBy(xpath = "//div[@class='inputEx-label']/label[contains(.,'Answer')]//parent::div//following-sibling::div/div/input")
	WebElement addAnswer;

	@FindBy(xpath = "//div[@class='inputEx-label']/label[contains(.,'Description')]//parent::div//following-sibling::div/div/input")
	WebElement addDescription;

	@FindBy(xpath = "//label[contains(.,'Question')]//parent::div//following-sibling::div[contains(@class,'mc-question') and contains(@class,'cb-editor-field')]/div[2]/div[2]/div/div[2]/div/fieldset/div/div[6]")
	WebElement menuBar;

	@FindBy(xpath = "//label[contains(.,'Question')]//parent::div//following-sibling::div[contains(@class,'mc-question') and contains(@class,'cb-editor-field')]/div[2]/div[2]/div/div[2]/div/fieldset/div/div[6]//ul/li[9]/span")
	WebElement questionMathematicalFormula;

	// @FindBy(xpath =
	// "//label[contains(.,'Type')]//parent::div//following-sibling::div[contains(@class,'inputEx-Field')]/select")
	@FindBy(xpath = "//span[contains(.,'Mathematical Formula')]//parent::legend//parent::fieldset/div[1]/div[2]//select//option[contains(.,'TeX')]")
	WebElement formulaType;

	@FindBy(xpath = "//div[contains(@class,'inputEx-StringField-wrapper')]/textarea[contains(@name,'formula')]")
	WebElement txtareaFormula;

	@FindBy(xpath = "//*[@id='cb-oeditor-form']//fieldset//legend//span[contains(.,'Mathematical Formula')]//ancestor::form//div[2]//a//span[contains(.,'Save')]")
	WebElement btnSaveMathematicalFormula;

	public void gotoCreateQuestions() {
		Log.info("Navigating to Create Questions page");
		Util.WaitForElementToBeClickable(questionsLink, 30);
		questionsLink.click();
		Util.waitForElementToPresent(addShortAnswer, 30);
	}

	public void addShortAnswerQuestion() {
		Log.info("Clicking on Add Short Answer button");
		Util.waitForElementToPresent(addShortAnswer, 10);
		addShortAnswer.click();
		Util.waitForElementToPresent(addQuestionTextArea, 10);
		Util.waitForElementToPresent(shortAnsQuestionType, 10);
		Log.info("Navigated to Short Answer Question page");
	}
	
	public void verifyTypesOfShortAnswerQuestion() {
		Log.info("Verifying types of Short Answer questions");
		Util.waitForElementToPresent(shortAnsQuestionType, 10);
		
		Util.waitForElementToPresent(caseInsensitiveStringMatch, 10);
		Util.waitForElementToPresent(caseInsensitiveStringStartsWith, 10);
		Util.waitForElementToPresent(caseInsensitiveStringEndsWith, 10);
		Util.waitForElementToPresent(commaSeparatedStringsOr, 10);
		Util.waitForElementToPresent(commaSeparatedStringsAnd, 10);
		
		Log.info("Verified types of Short Answer Question");
	}

	public void addMultipleChoiceQuestion() {
		Log.info("Clicking on Add Multiple Choice button");
		Util.waitForElementToPresent(addMultipleChoice, 10);
		addMultipleChoice.click();
		Util.waitForElementToPresent(addQuestionTextArea, 10);
		Log.info("Navigated to Multiple Choice Question page");
	}

	public void addNumericalQuestion() {
		Log.info("Clicking on Add Numerical button");
		Util.waitForElementToPresent(addNumerical, 10);
		addNumerical.click();
		Util.waitForElementToPresent(addQuestionTextArea, 10);
		Util.waitForElementToPresent(numericQuestionType, 10);
		Log.info("Navigated to Add Numerical Answer Question page");
	}

	public void addQuestionText(String question) {
		question = prop.getProperty(question);
		Util.waitForElementToPresent(addQuestionTextArea, 10);
		addQuestionTextArea.sendKeys(question);
	}

	public void addMathematicalFormula(WebElement txtArea, WebElement mathFormulaIcon, String mathExpression) {

		Util.waitForElementToPresent(txtArea, 60);
		txtArea.click();

		Util.waitForElementToPresent(mathFormulaIcon, 30);

		Util.WaitForElementToBeClickable(mathFormulaIcon, 20);
		mathFormulaIcon.click();

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		mathExpression = prop.getProperty(mathExpression);

		WebElement iframe = driver.findElement(By.id("modal-editor-iframe"));
		driver.switchTo().frame(iframe);

		Util.waitForElementToPresent(formulaType, 60);
		Util.waitForElementToPresent(txtareaFormula, 30);
		txtareaFormula.sendKeys(mathExpression);

		Util.waitForElementToPresent(btnSaveMathematicalFormula, 15);
		btnSaveMathematicalFormula.click();

		driver.switchTo().defaultContent();
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addMathjaxQuestionToAssessment(String questionName, String mathExpression, String choice1,
			String choice2, String description) {
		Log.info("adding Mathjax question statement for question under MCQ");

		addQuestionText(questionName);

		addMathematicalFormula(addQuestionTextArea, questionMathematicalFormula, mathExpression);

		addMathematicalFormula(txtAreaChoice1, mathFormulaIconChoice1, choice1);

		if (choice2 != null) {
			// opening the new choice field
			Util.clickOnLink("Add a choice");

			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		addMathematicalFormula(txtAreaChoice2, mathFormulaIconChoice2, choice2);

			description = prop.getProperty(description);
			addDescription.sendKeys(description);
			Util.clickOnLink("Save");
			driver.switchTo().defaultContent();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void selectShortAnswerType(String type) {
		
		Util.waitForElementToPresent(shortAnsQuestionType, 10);
		
		Util.selectAnOption(shortAnsQuestionType, type);
	}

	public void addAnswer(String answer) {
		answer = prop.getProperty(answer);
		Util.waitForElementToPresent(addAnswer, 10);
		addAnswer.clear();
		addAnswer.sendKeys(answer);
	}

	public void addDescription(String description) {
		description = prop.getProperty(description);
		Util.waitForElementToPresent(addDescription, 10);
		addDescription.clear();
		addDescription.sendKeys(description);
	}

	public void confirmQuestionAddition(String description) {
		description = prop.getProperty(description);
		Util.waitForElementToPresent(addShortAnswer, 10);
		driver.findElement(By.xpath("//table[@id='question-table']/tbody/tr/td[contains(.,'" + description + "')]"));
		Log.info("Verified that question is added successfully");
	}

}
