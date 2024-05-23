package com.swayam.steps;

import java.util.List;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.swayam.base.Util;
import com.swayam.pages.HomePage;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageSteps {
	
	final static Logger Log = Logger.getLogger(HomePage.class.getName());
	Util Util = new Util();

	@Before
	public void startUp(Scenario scenario) {
		Log.info("--------------------------------------------------");
		Log.info(scenario.getName());
		Log.info("--------------------------------------------------");
	}

	@After
	public void tearDown(Scenario scenario) {

			if (scenario.isFailed()) {
			Log.info("Taking screenshot for test failures");
			// Take a screenshot...
			final byte[] screenshot = Util.getScreenshotinByte();
			scenario.embed(screenshot, "image/png"); // embed it in the report.
		}
		HomePage homePage = new HomePage();
		homePage.cleanup();
	}

	@Given("^user launches the application$")
	public void LaunchApplication() throws Throwable {
		HomePage homePage = new HomePage();
		homePage.launchApp();
	}

	@Then("^verifies that applilcation launched successfully$")
	public void verifyApplilcationLaunch() {
		HomePage homePage = new HomePage();
		Assert.assertTrue(homePage.isUserOnHomePage(),
				"user is not on homepage");
	}

	@When("^user hovers on course catalog$")
	public void OpenCategory() {
		HomePage homePage = new HomePage();
		homePage.openCategoriesDropdown();
	}

	@Then("^user verifies dropdown is displayed with following <categories>$")
	public void verifyCategoryDropdownValues(DataTable options) {
		HomePage homePage = new HomePage();
		List<String> catagories = options.asList(String.class);
		homePage.verifyCategoriesDropdown(catagories);
	}

	@When("^user select \"([^\"]*)\" category from the list$")
	public void selectACategory(String category) {
		HomePage homePage = new HomePage();
		// explorerPage = homePage.selectCategory(category);
		homePage.selectCategory(category);
	}

	@When("^user clicks on \"([^\"]*)\" button from Homepage$")
	public void clicksOnButton(String signInButton) {
		HomePage homePage = new HomePage();
		homePage.clickOnSigIn(signInButton);
	}

	@Then("^user redirects back to application$")
	public void verifyUserIsOnHomePage() {
		HomePage homePage = new HomePage();
		Assert.assertTrue(homePage.isUserOnHomePage());
	}

	@Then("^user verifies the \"([^\"]*)\" link on header$")
	public void verifyHeaderLink(String linkName) {
		HomePage homePage = new HomePage();
		homePage.verifyLinkPresentOnHeader(linkName);
	}

	@Then("^user verifies the \"([^\"]*)\" link is not present on header$")
	public void verifyHeaderLinkNotPresent(String linkName) {
		HomePage homePage = new HomePage();
		homePage.verifyLinkIsNotPresentOnHeader(linkName);
	}

	@Then("^user goes to \"([^\"]*)\" page from user dropdown$")
	public void goToSpocAdmin(String linkName) {
		HomePage homePage = new HomePage();
		homePage.selectAnOptionFromUserDropdown(linkName);
	}

	@And("^user opens the user dropdown$")
	public void openUserDropdown() {
		HomePage homePage = new HomePage();
		homePage.openUserDropdown();
	}
	
	@And("^user opens the user dropdown on node$")
	public void openUserDropdownOnNode() {
		HomePage homePage = new HomePage();
		homePage.openUserDropdownOnNode();
	}
}
