package com.swayam.steps;

import java.util.List;
import java.util.Map;

import com.swayam.pages.PreviewPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.When;

public class PreviewPageSteps {

	@When("^user verifies course details on preview page$")
	public void verifyCourseDetailsOnPreviewPage(DataTable dataTable) {
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);

		String courseLayoutText = list.get(0).get("CourseLayout");
		String booksReferencesText = list.get(0).get("BooksReferences");
		String courseCertificateText = list.get(0).get("CourseCertificate");
		String instructorInstituteText = list.get(0).get("InstructorInstitute");
		String aboutCourseText = list.get(0).get("AboutCourse");
		String youtubeIdValue = list.get(0).get("YoutubeId");
		String instructorBioText = list.get(0).get("InstructorBio");
		String instructorNameText = list.get(0).get("InstructorName");
		PreviewPage previewPage = new PreviewPage();
		previewPage.verifyCourseLayoutText(courseLayoutText);
		previewPage.verifyBooksReferencesText(booksReferencesText);
		previewPage.verifyInstructorBioText(instructorBioText);
		previewPage.verifyCourseCertificateText(courseCertificateText);
		
		
		previewPage.verifyInstructorInstituteText(instructorInstituteText);
		previewPage.verifyAboutCourseText(aboutCourseText);
		previewPage.verifyYoutubeIdValue(youtubeIdValue);
		previewPage.verifyInstructorNameText(instructorNameText);

	}

	@When("^user verifies the course summary on preview page$")
	public void verifyCourseSummaryOnPreviewPage(DataTable dataTable) {
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);
		String courseWeeksValue = list.get(0).get("CourseWeeks");
		String fDPCourseStatus = list.get(0).get("FDPCourse");
		String courseTypeValue = list.get(0).get("CourseType");
		String courseLevelValue = list.get(0).get("CourseLevel");

		PreviewPage previewPage = new PreviewPage();
		previewPage.verifyCourseWeeksValue(courseWeeksValue);
		previewPage.verifyFDPCourseStatus(fDPCourseStatus);
		previewPage.verifyCourseTypeValue(courseTypeValue);
		previewPage.verifyCourseLevelValue(courseLevelValue);
	}

}
