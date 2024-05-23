package com.swayam.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.swayam.base.Util;

public class LoginPage extends HomePage {
	final static Logger Log = Logger.getLogger(LoginPage.class.getName());
	Util Util = new Util();
	String username, password;

	@FindBy(xpath = "//input[@type='email']")
	WebElement emailEdit;
	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordEdit;
	@FindBy(xpath = "//span[.='Next']")
	WebElement loginButton;

	@FindBy(id = "next")
	WebElement localLoginButton;

	@FindBy(id = "logonIdentifier")
	WebElement localEmailField;

	@FindBy(id = "password")
	WebElement localPasswordField;

	@FindBy(id = "GoogleExchange")
	WebElement googleLoginOption;

	@FindBy(xpath = "//a/img[@src='/assets/img/swayam_images/login_Google.jpg']")
	WebElement googleSignIn;

	public LoginPage() {
		super();
	}

	public void gotoGoogleLogin() {
		Util.WaitForElementToBeClickable(googleLoginOption, 20);
		Util.WaitForElementToBeClickable(googleLoginOption, 20);
		googleLoginOption.click();
	}

	public void enterEmail(String email) {
		Util.waitForElementToPresent(emailEdit, 10);
		emailEdit.clear();
		emailEdit.sendKeys(email);
		loginButton.click();
	}

	public void enterLocalUserEmail(String email) {
		Util.waitForElementToPresent(localEmailField, 10);
		localEmailField.clear();
		localEmailField.sendKeys(email);
	}

	public void enterPassword(String password) {

		Util.waitForElementToPresent(passwordEdit, 20);
		passwordEdit.clear();
		passwordEdit.sendKeys(password);

	}

	public void enterLocalUserPassword(String password) {
		localPasswordField.clear();
		localPasswordField.sendKeys(password);
	}

	public void clickToLogin() {
		loginButton.click();
	}

	public void clickToLocalLogin() {
		localLoginButton.click();
	}

	public void Login(String uname, String pw) {
		String username = prop.getProperty(uname);
		String password = prop.getProperty(pw);
		Log.info("Login to the application with " + username);
		gotoGoogleLogin();
		verifyGoogleLoginPage();
		enterEmail(username);
		enterPassword(password);
		clickToLogin();
	}

	public void localLogin(String uname, String pw) {
		String username = prop.getProperty(uname);
		String password = prop.getProperty(pw);
		Log.info("Login to the application with local user " + username);
		enterLocalUserEmail(username);
		enterLocalUserPassword(password);
		clickToLocalLogin();
		Util.waitForUserToLoggedIn(40);
	}

	public void verifyLoginPage() {
		String expectedTitle = prop.getProperty("signin.page.title");
		Util.WaitForElementToBeClickable(googleLoginOption, 10);
		Log.info("Verifying the Azure login page");
		String expectedTitleStr = Util.getPageTitle();
		boolean LoginPageTitleFlag = expectedTitleStr.equals(expectedTitle) || expectedTitleStr.equals("Swayam");
		Assert.assertTrue(LoginPageTitleFlag);
	}

	public void verifyGoogleLoginPage() {
		String expectedTitle = prop.getProperty("signin.page.tilte.google");
		Util.waitForElementToPresent(emailEdit, 20);
		Log.info("Verifying the google login page");
		Assert.assertTrue(Util.getPageTitle().equals(expectedTitle));
	}

}
