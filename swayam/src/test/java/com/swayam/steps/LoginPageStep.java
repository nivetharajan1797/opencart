package com.swayam.steps;

import com.swayam.pages.LoginPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPageStep {

	@Then("^verify user redirects to azure login page$")
	public void verifyGoogleSignInPage() {
		LoginPage loginPage = new LoginPage();
		loginPage.verifyLoginPage();
	}

	@When("^user login using \"([^\"]*)\" and \"([^\"]*)\"$")
	public void login(String uname, String pw) {
		LoginPage loginPage = new LoginPage();
		loginPage.Login(uname, pw);
	}

	@When("^user login using local user as \"([^\"]*)\" and \"([^\"]*)\"$")
	public void loginLocal(String uname, String pw) {
		LoginPage loginPage = new LoginPage();
		loginPage.localLogin(uname, pw);
	}

}
