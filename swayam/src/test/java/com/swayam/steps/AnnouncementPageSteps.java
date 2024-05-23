package com.swayam.steps;

import java.util.List;
import java.util.Map;

import com.swayam.pages.AnnouncementPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;

public class AnnouncementPageSteps {

	@Then("^user verifies the Announcement page$")
	public void verifyGoogleSignInPage() {
		AnnouncementPage announcementPage = new AnnouncementPage();
		announcementPage.verifyAnnouncementPage();
	}

	@Then("^user set the status to \"([^\"]*)\"$")
	public void userSetStatus(String status) {
		AnnouncementPage announcementPage = new AnnouncementPage();
		announcementPage.setStatus(status);
	}

	@Then("^user creates the Announcement$")
	public void userCreatesAnnouncement(DataTable dataTable) {
		AnnouncementPage announcementPage = new AnnouncementPage();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);
		String title = list.get(0).get("title");
		String body = list.get(0).get("body");
		String date = list.get(0).get("date");
		String status = list.get(0).get("status");

		announcementPage.enterAnnouncementPageTitle(title);
		announcementPage.enterAnnouncementBody(body);
		announcementPage.setAnnouncementDate(date);
		announcementPage.setStatus(status);
	}

	@Then("^user verifies announcement on user side$")
	public void userVerifiesAnnouncementOnUserSide(DataTable dataTable) {
		AnnouncementPage announcementPage = new AnnouncementPage();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);
		String title = list.get(0).get("title");
		String body = list.get(0).get("body");
		String date = list.get(0).get("date");
		announcementPage.verifyAnnouncementcontent(title, body, date);

	}
	
	@Then("^user set the announcement date to \"([^\"]*)\"$")
	public void user_set_the_announcement_date_to(String dueDate) {
		AnnouncementPage announcementPage = new AnnouncementPage();
		announcementPage.setAnnouncementDate(dueDate);
	}

	@Then("^user verifies status as \"([^\"]*)\" for \"([^\"]*)\" announcement$")
	public void verifyAnnouncementStatus(String status, String announcementName) {
		AnnouncementPage announcementPage = new AnnouncementPage();
		announcementPage.verifyAnnouncementStatus(status, announcementName);
	}

	@Then("^user change the status to \"([^\"]*)\" for \"([^\"]*)\" announcement$")
	public void changeAnnouncementStatus(String status, String announcementName) {
		AnnouncementPage announcementPage = new AnnouncementPage();
		announcementPage.setAnnouncementStatus(status, announcementName);
	}
	
	@Then("^user verifies that no announcement is present with \"([^\"]*)\"$")
	public void verifyPresenceOfAnnouncement(String announcementName){
		AnnouncementPage announcementPage = new AnnouncementPage();
		announcementPage.verifyPresenceOfAnnouncement(announcementName);
}
}