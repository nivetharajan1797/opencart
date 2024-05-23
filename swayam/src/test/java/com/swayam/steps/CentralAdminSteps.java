package com.swayam.steps;

import java.util.List;
import java.util.Map;

import com.swayam.pages.CentralAdminPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CentralAdminSteps {

	@And("^user opens the LC page$")
	public void userOpensLCPagethrows() {
		CentralAdminPage ca = new CentralAdminPage();
		ca.openLCpage();
	}

	@And("^user open the Instructor page$")
	public void openInstructorPage() {
		CentralAdminPage ca = new CentralAdminPage();
		ca.openInstructorpage();
	}
	
	@And("^user open the Instructor page on node$")
	public void openInstructorPageOnNode() {
		CentralAdminPage ca = new CentralAdminPage();
		ca.openInstructorpageOnNode();
	}
	@Then("^user verifies the Local Chapter Page$")
	public void verifyLocalChapterPage() {
		CentralAdminPage ca = new CentralAdminPage();
		ca.verifyLocalChapterPage();
	}

	@And("^user verifies Add instructor page$")
	public void verifyAddInstructorPage() {
		CentralAdminPage ca = new CentralAdminPage();
		ca.verifyAddInstructorPage();
	}
	@Then("^user verifies the instructor page$")
	public void verifyInstructorPage() {
		CentralAdminPage ca = new CentralAdminPage();
		ca.verifyInstructorPage();
	}

	@Then("^user removes the existing local chapter with \"([^\"]*)\" code$")
	public void removeLocalChapter(String code) {
		CentralAdminPage ca = new CentralAdminPage();
		ca.removeLocalChapter(code);
	}

	@When("^user fills the Local Chapter fields$")
	public void enterLocalChapter(DataTable dataTable) {
		CentralAdminPage ca = new CentralAdminPage();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);
		ca.enterLCCode(list.get(0).get("code"));
		ca.enterLCName(list.get(0).get("name"));
		ca.enterLCCity(list.get(0).get("city"));
		ca.enterLCCountry(list.get(0).get("country"));
		ca.enterLCState(list.get(0).get("state"));
		ca.enterLCOrgType(list.get(0).get("org_type"));
		ca.enterLCSPOCEmail(list.get(0).get("spoc_email"));
	}

	@Then("^user verifies added local chapter values$")
	public void verifyLocalChapterFieldValues(DataTable dataTable) {
		CentralAdminPage ca = new CentralAdminPage();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);
		ca.verifyValueOfLCCode(list.get(0).get("code"));
		ca.verifyValueOfLCName(list.get(0).get("name"));
		ca.verifyValueOfLCCity(list.get(0).get("city"));
		ca.verifyValueOfLCCountry(list.get(0).get("country"));
		ca.verifyValueOfLCState(list.get(0).get("state"));
		ca.verifyValueOfLCOrgType(list.get(0).get("org_type"));
		ca.verifyValueOfLCSPOCEmail(list.get(0).get("spoc_email"));
	}

	@Then("^user verifies spoc admin view$")
	public void verifySPOCDashboardView() {
		CentralAdminPage ca = new CentralAdminPage();
		ca.verifySPOCAdminPage();
	}

	
	@Then("^user verifies spoc admin view for industry spoc$")
	public void verifyIndustrySPOCDashboardView() {
		CentralAdminPage ca = new CentralAdminPage();
		ca.verifyIndustrySPOCAdminPage();
	}
	@Then("^user clicks on namespace link for \"([^\"]*)\"$")
	public void gotoCourseNamespace(String courseName) {
		CentralAdminPage ca = new CentralAdminPage();
		ca.clickCourseUrl(courseName);
	}
	
	@Then("^user clicks on industry namespace link for \"([^\"]*)\"$")
	public void gotoCourseNamespaceIndustry(String courseName) {
		CentralAdminPage ca = new CentralAdminPage();
		ca.clickCourseUrlIndustry(courseName);
	}

	@Then("^user verifies user on the list for Enrolled Members for \"([^\"]*)\"$")
	public void verifyUserOnList(String userName) {
		CentralAdminPage ca = new CentralAdminPage();
		ca.verifyUserOnSPOCEnrolledUserList(userName);
	}

	@Then("^user goes to All Local Chapter Members page$")
	public void goToAllLocalChapterPage() {
		CentralAdminPage ca = new CentralAdminPage();
		ca.gotoAllLocalChapterPage();
	}

	@Then("^user verifies course \"([^\"]*)\" for the user \"([^\"]*)\" under course list$")
	public void verifyCourseUnderCourseList(String email, String courseName) {
		CentralAdminPage ca = new CentralAdminPage();
		ca.verifySpocLearnerCourseList(email, courseName);
	}
}
