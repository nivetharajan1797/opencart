package com.swayam.steps;

import java.util.List;
import java.util.Map;

import com.swayam.pages.ExplorerPage;
import com.swayam.pages.NCAdminPage;
import com.swayam.pages.NationalCoordinatorsPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NationalCoordinatorsSteps {

	@When("^user selects national coorinator option from left nav$")
	public void goToNationalCoorinatorPage() {
		NationalCoordinatorsPage ncPage = new NationalCoordinatorsPage();
		ncPage.gotoNCPage();
	}

	@Then("^user verifies the national coorinator page$")
	public void verifyNationalCoorinatorPage() {
		NationalCoordinatorsPage ncPage = new NationalCoordinatorsPage();
		ncPage.verifyNCPage();
	}

	@Then("^user removes the existing NC with \"([^\"]*)\" code$")
	public void user_removes_the_existing_NC_with_code(String code) {
		NationalCoordinatorsPage ncPage = new NationalCoordinatorsPage();
		ncPage.removeNC(code);
	}

	@When("^user adds basic fields national coorinator with following details$")
	public void enterBasicNationalCoordinatorFields(DataTable dataTable) {
		NationalCoordinatorsPage ncPage = new NationalCoordinatorsPage();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);
		ncPage.enterNcCode(list.get(0).get("code"));
		ncPage.enterNcName(list.get(0).get("name"));
		ncPage.enterNcShortName(list.get(0).get("shortName"));
		ncPage.enterNcDescription(list.get(0).get("description"));
		ncPage.enterNcUrl(list.get(0).get("URL"));
		ncPage.enterNcLogoUrl(list.get(0).get("logo"));
		ncPage.enterNcEmail(list.get(0).get("adminEmail"));
		ncPage.enterNcSupportEmail(list.get(0).get("supportEmail"));
		ncPage.enterNcAddress(list.get(0).get("address"));
		ncPage.enterNcPhoneNumber(list.get(0).get("phoneNumber"));
	}

	@When("^user adds dashboard fields national coorinator with following details$")
	public void enterNationalCoordinatorFieldsForDashboard(DataTable dataTable) {
		NationalCoordinatorsPage ncPage = new NationalCoordinatorsPage();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);
		ncPage.enterNcInstitutesEngaged(list.get(0).get("institutesEngaged"));
		ncPage.enterNcCompletedCourses(list.get(0).get("completedCourses"));
		ncPage.enterNcStudentsEnrolled(list.get(0).get("studentsEnrolled"));
		ncPage.enterNcExamRegistrations(list.get(0).get("examRegistrations"));
		ncPage.enterNcCertifications(list.get(0).get("Certifications"));

	}

	@When("^user adds ongoing fields national coorinator with following details$")
	public void enterNationalCoordinatorFieldsForOngoing(DataTable dataTable) {
		NationalCoordinatorsPage ncPage = new NationalCoordinatorsPage();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);
		ncPage.enterNcOngoingCourses(list.get(0).get("courses"));
		ncPage.enterNcOngoingstudentEnrollment(list.get(0).get(
				"studentEnrollment"));
		ncPage.enterNcOngoingExamRegistrations(list.get(0).get(
				"examRegistrations"));

	}

	@Then("^user verifies the details NC table$")
	public void verifyNCTableDetails() throws Throwable {
		NationalCoordinatorsPage ncPage = new NationalCoordinatorsPage();
		ncPage.verifyNewNCUnderNcTable();
	}

	@When("^user verifies NC details entered$")
	public void user_verifies_NC_details_entered(DataTable dataTable) {
		NationalCoordinatorsPage ncPage = new NationalCoordinatorsPage();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);
		ncPage.verifyNcCode(list.get(0).get("code"));
		ncPage.verifyNcName(list.get(0).get("name"));
		ncPage.verifyNcShortName(list.get(0).get("shortName"));
		ncPage.verifyNcDescription(list.get(0).get("description"));
		ncPage.verifyNcUrl(list.get(0).get("URL"));
		ncPage.verifyNcLogoUrl(list.get(0).get("logo"));
		ncPage.verifyNcEmail(list.get(0).get("adminEmail"));
		ncPage.verifyNcSupportEmail(list.get(0).get("supportEmail"));
		// ncPage.verifyNcAddress(list.get(0).get("address"));
		ncPage.verifyNcPhoneNumber(list.get(0).get("phoneNumber"));
	}

	@When("^user verifies NC card on National Coordinators with following details$")
	public void user_verifies_NC_card_on_National_Coordinators_with_following_details(
			DataTable dataTable) {
		NCAdminPage ncPage = new NCAdminPage();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);
		String ncShortName = list.get(0).get("shortName");
		String name = list.get(0).get("name");
		String imageUrl = list.get(0).get("logo");

		ncPage.verifyNcNameOnCard(ncShortName, name);
		ncPage.verifyNcImageOnCard(ncShortName, imageUrl);
	}

	@When("^user goes to NC detail page by short name \"([^\"]*)\"$")
	public void user_goes_to_NC_detail_page(String ncShortName)
			throws Throwable {
		NCAdminPage ncPage = new NCAdminPage();
		ncPage.goToNCDetailPage(ncShortName);
		ncPage.verifyUserIsOnNcDetailPage("nc.name");
	}

	@When("^user verifies following values on NC details page$")
	public void user_verifies_following_values_on_NC_details_page(
			DataTable dataTable) {
		NCAdminPage ncPage = new NCAdminPage();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);
		String ncName = list.get(0).get("name");
		String description = list.get(0).get("description");
		String websiteUrl = list.get(0).get("URL");
		String address = list.get(0).get("address");
		String supportEmail = list.get(0).get("supportEmail");
		String phoneNumber = list.get(0).get("phoneNumber");

		ncPage.verifyNcDesriptionOnDetailPage(ncName, description);
		ncPage.verifyNcAddressSectionOnDetailPage(websiteUrl, address,
				supportEmail, phoneNumber);
	}

	@When("^user verifies dashboard fields national coorinator with following details$")
	public void user_verifies_dashboard_fields_national_coorinator_with_following_details(
			DataTable dataTable) {
		NCAdminPage ncPage = new NCAdminPage();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);

		String institutesEngaged = list.get(0).get("institutesEngaged");
		String completedCourses = list.get(0).get("completedCourses");
		String studentsEnrolled = list.get(0).get("studentsEnrolled");
		String examRegistrations = list.get(0).get("examRegistrations");
		String Certifications = list.get(0).get("Certifications");
		ncPage.verifyNcDashboardOnDetailPage(institutesEngaged,
				completedCourses, studentsEnrolled, examRegistrations,
				Certifications);
	}

	@When("^user verifies ongoing fields national coorinator with following details$")
	public void user_verifies_ongoing_fields_national_coorinator_with_following_details(
			DataTable dataTable) {
		NCAdminPage ncPage = new NCAdminPage();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);

		String ongoingCourses = list.get(0).get("courses");
		String studentEnrollment = list.get(0).get("studentEnrollment");
		String examRegistrations = list.get(0).get("examRegistrations");

		ncPage.verifyOngoingSection(ongoingCourses, studentEnrollment,
				examRegistrations);
	}
	
	@When("^user verifies course catalog page redirection$")
	public void user_verifies_course_catalog_page_redirection()  {
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.verifyUserOnCourseCatalogPage();
	}

	@When("^user verifies that National Coordinators filter set with value as \"([^\"]*)\"$")
	public void user_verifies_that_National_Coordinators_filter_set_with_value_as(String ncShortName)  {
		ExplorerPage explorerPage = new ExplorerPage();
		explorerPage.verifyNationalCoordinatorFilterValue(ncShortName);
	}


}
