package com.swayam.steps;

import java.util.List;
import java.util.Map;

import com.swayam.pages.CourseStaffUserPage;
import com.swayam.pages.SubjectiveAssignmentPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;

public class SubjectiveAssignmentSteps {

	@Then("^user verifies the course staff page header as \"([^\"]*)\"$")
	public void user_verifies_the_course_staff_page_header_as(String header) {
		CourseStaffUserPage cf = new CourseStaffUserPage();
		cf.verifyCourseStaffUserPage(header);

	}

	@Then("^user verifies the course staff view for submission of \"([^\"]*)\"$")
	public void user_verifies_the_course_staff_view_for_submission_of(
			String assignmentName) {
		CourseStaffUserPage cf = new CourseStaffUserPage();
		cf.verifyCourseStaffUserPageForSubmission(assignmentName);
	}

	@Then("^user verifies not evaluated any submissions message \"([^\"]*)\"$")
	public void user_verifies_not_evaluated_any_submissions_message(
			String message) {
		CourseStaffUserPage cf = new CourseStaffUserPage();
		cf.verifyEvaluationSubmissionPage(message);
	}

	@Then("^user verified evaluation table$")
	public void user_verified_evaluation_table() {
		CourseStaffUserPage cf = new CourseStaffUserPage();
		cf.verifyEvaluationTable();
	}

	@Then("^user verifies the evaluation page$")
	public void user_verifies_the_evaluation_page() {
		CourseStaffUserPage cf = new CourseStaffUserPage();
		cf.verifyEvaluatorPage();
	}

	@Then("^user verifies the student submission as \"([^\"]*)\"$")
	public void user_verifies_the_student_submission_as(String studentSubmission) {
		CourseStaffUserPage cf = new CourseStaffUserPage();
		cf.verifyStudentSubmission(studentSubmission);
	}

	@Then("^user enter course staff comments \"([^\"]*)\"$")
	public void user_enter_course_staff_comments(String comments) {
		CourseStaffUserPage cf = new CourseStaffUserPage();
		cf.enterComments(comments);
	}

	@Then("^user gives score to assignment as \"([^\"]*)\"$")
	public void user_gives_score_to_assignment_as(String score) {
		CourseStaffUserPage cf = new CourseStaffUserPage();
		cf.setScores(score);
	}

	@Then("^user verifies subjective assignment for scores and comment$")
	public void userVerifiesScoreAndCommentOnSA(DataTable dataTable) {
		SubjectiveAssignmentPage sa = new SubjectiveAssignmentPage();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);
		String score = list.get(0).get("score");
		String comment = list.get(0).get("comment");
		sa.verifyScoreAndCommentOnSA(score, comment);

	}
}
