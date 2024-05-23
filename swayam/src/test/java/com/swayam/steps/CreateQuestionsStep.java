package com.swayam.steps;

import java.util.List;
import java.util.Map;

import com.swayam.pages.CreateOutline;
import com.swayam.pages.CreateQuestions;
import com.swayam.pages.ExplorerPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateQuestionsStep {
	
	@When("^user clicks on Questions link to add questions$")
	public void user_clicks_on_Questions_link_to_add_questions() {
		CreateQuestions createQuestions = new CreateQuestions();
		createQuestions.gotoCreateQuestions();
	}
	
	@When("^user clicks on Add Short Answer button$")
	public void user_clicks_on_Add_Short_Answer_button(){
		CreateQuestions createQuestions = new CreateQuestions();
		createQuestions.addShortAnswerQuestion();
	}
	
	@When("^user verifies types of short answer question$")
	public void user_verifies_types_of_short_answer_question(){
		CreateQuestions createQuestions = new CreateQuestions();
		createQuestions.verifyTypesOfShortAnswerQuestion();
	}
	
	@When("^user clicks on Add Multiple Choice button$")
	public void user_clicks_on_Add_Multiple_Choice_button(){
		CreateQuestions createQuestions = new CreateQuestions();
		createQuestions.addMultipleChoiceQuestion();
	}
	
	@When("^user clicks on Add Numerical button$")
	public void user_clicks_on_Add_Numerical_button(){
		CreateQuestions createQuestions = new CreateQuestions();
		createQuestions.addNumericalQuestion();
	}
	
	@When("^user enter following required details on Short Answer Question page$")
	public void user_enter_following_required_details_on_Short_Answer_Question_page(
			DataTable dataTable) {
		CreateQuestions createQuestionsPage = new CreateQuestions();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);

		String question = list.get(0).get("Question");
		String type = list.get(0).get("Type");
		String answer = list.get(0).get("Answer");
		String description = list.get(0).get("Description");

		createQuestionsPage.addQuestionText(question);
		createQuestionsPage.selectShortAnswerType(type);
		createQuestionsPage.addAnswer(answer);
		createQuestionsPage.addDescription(description);
	}
	
	@When("^user enter following required details on Multiple Choice Question page$")
	public void user_enter_following_required_details_on_Multiple_Choice_Question_page(
			DataTable dataTable) {
		CreateQuestions createQuestionsPage = new CreateQuestions();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);

		String question = list.get(0).get("Question");
		String mathExpression = list.get(0).get("MathJax Expression");
		String choice1 = list.get(0).get("Choice1");
		String choice2 = list.get(0).get("Choice2");
		String description = list.get(0).get("Description");

		createQuestionsPage.addMathjaxQuestionToAssessment(question, mathExpression,
				choice1, choice2, description);
	}
	
	@When("^user confirms that question is added successfully$")
	public void user_confirms_that_question_is_added_successfully(
			DataTable dataTable){
		CreateQuestions createQuestions = new CreateQuestions();
		List<Map<String, String>> list = dataTable.asMaps(String.class,
				String.class);

		String description = list.get(0).get("Description");
		createQuestions.confirmQuestionAddition(description);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
