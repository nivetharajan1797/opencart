package com.swayam.steps;

import com.swayam.base.Util;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CommonSteps {
	Util Util = new Util();

	@When("^user clicks on \"([^\"]*)\" button$")
	public void clickOnButton(String btnName) {
		Util.clickOnButton(btnName);
	}
	
	@When("^user clicks on \"([^\"]*)\" button with contains$")
	public void clickOnButtonContains(String btnName) {
		Util.clickOnButtonContains(btnName);
	}
	
	@When("^user clicks on \"([^\"]*)\" link using property$")
	public void clickOnLinkUsingProp(String linkProp) {
		Util.clickOnLinkUsingProp(linkProp);
	}

	@When("^user clicks on \"([^\"]*)\" Link$")
	public void clickOnLink(String linkName) {
		Util.clickOnLink(linkName);
	}

	@When("^user clicks on \"([^\"]*)\" link by property$")
	public void clickOnLinkByProperty(String linkName) {
		Util.clickOnLinkByProperty(linkName);
	}

	@When("^user goes back to the app$")
	public void switchToApp() {
		Util.goToApp();
	}

	@And("^user clears the browser cache$")
	public void clearChromeCache() {
		Util.clearChromeCache();
	}

	@When("^user checks \"([^\"]*)\" checkbox$")
	public void selectCheckboxByName(String labelName) {
		Util.selectCheckboxByName(labelName);
	}

	@And("^user goes back to previous page$")
	public void browserBack() {
		Util.browserBack();
	}

	@When("^user clicks on \"([^\"]*)\" link$")
	public void clickOnLogin(String link) {
		Util.clickOnLink(link);
	}

	@When("^user logout from user side$")
	public void clickOnLink() {
		Util.logoutFromUserSide();
	}

	@Then("^I should print (\\d+)$")
	public void dummyMethod(int num) {

	}

	@Then("user clicks on the course checkbox$")
	public void clickOncourse() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
		}

		Util.clickoncourse();

	}

	@When("^user waits for \"([^\"]*)\" confirmation$")
	public void waitForConfirmation(String message) {
		Util.waitForConfirmationMessage(message);
	}

	@When("^store page url to \"([^\"]*)\"$")
	public void store_page_url_to(String key) {
		Util.storePageURL(key);
	}
	
	@When("^store debug page url to \"([^\"]*)\"$")
	public void store_debug_page_url_to(String key) {
		Util.storeDebugPageURL(key);
	}

	
	@And("^user waits for sometime$")
	public void constWait(){
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}
	
	
	@And("^user goes to admin homepage$")
	public void goToAdminHomePage(){
		Util.goToAdminHomePage();
	}
	

}
