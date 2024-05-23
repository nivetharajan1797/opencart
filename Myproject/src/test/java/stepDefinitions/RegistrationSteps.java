package stepDefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class RegistrationSteps {

	WebDriver driver;
	HomePage hp;
	AccountRegistrationPage regpage;
	
	@Given("the user is on the nopcommerce page")
	public void the_user_is_on_the_nopcommerce_page() {
	   
		hp = new HomePage(BaseClass.getDriver());
		
//		driver.get("https://tutorialsninja.com/demo/");
		
	}

	@And("User clicks on the My Account button")
	public void user_clicks_on_the_my_account_button() {
	   
		hp.clickMyAccount();
	}

	@Then("Click on the Register button")
	public void click_on_the_register_button() {
	   hp.clickonRegister();
		
	}

	@Given("User should fill the required details")
	public void user_should_fill_the_required_details(DataTable dataTable) {
	    // Your implementation
	
	 
		
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		regpage=new AccountRegistrationPage(BaseClass.getDriver());
		regpage.setfirstName(dataMap.get("firstName"));
		regpage.setLastName(dataMap.get("lastName"));
		regpage.setEmail(BaseClass.randomAlphaNumeric()+"@gmail.com");
		regpage.setphone(dataMap.get("telephone"));
		regpage.setPassword(dataMap.get("password"));
		regpage.setConfirmPassword(dataMap.get("password"));
		

	}
	@Then("Click on the privacy policy")
	public void click_on_the_privacy_policy() {
	   regpage.privacyPolicy();
	}
	@Then("Click on the continue button")
	public void click_on_the_continue_button() {
	   regpage.btncontinue();
	}

	@And("User should see the confirmation message")
	public void user_should_see_the_confirmation_message() {
		String confmsg=regpage.confirmMessage();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
	}




}
