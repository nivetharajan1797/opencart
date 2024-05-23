package com.swayam.steps;

import org.openqa.selenium.By;

import com.swayam.pages.NptelHomePage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NptelHomePageStep {

	@When("^user navigates to node as \"([^\"]*)\"$")
	public void navigateToNode(String nodeName) {
		NptelHomePage nodeHome = new NptelHomePage();
		nodeHome.gotoNode(nodeName);
	}

	@Then("^user verifies Node Homepage$")
	public void verifyNodeHomepage() {
		NptelHomePage nodeHome = new NptelHomePage();
		nodeHome.isNptelHomePagePresent();
	}

	@When("^user clicks on \"([^\"]*)\" link after login$")
	public void userNavigatesToDashboard(String link) {
		NptelHomePage nodeHome = new NptelHomePage();
		nodeHome.clickOnDashboard(link);
	}

	@Then("^user logged in to the application with \"([^\"]*)\"$")
	public void verifyUserNameOnHeader(String uname) {
		NptelHomePage nodeHome = new NptelHomePage();
		nodeHome.verifyUserNameOnHeader(uname);
	}
}
