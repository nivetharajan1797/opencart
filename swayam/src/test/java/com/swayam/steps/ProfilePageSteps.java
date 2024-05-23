package com.swayam.steps;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;

import com.swayam.pages.ProfilePage;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProfilePageSteps {


	@When("^user enters profile details for profession as other$")
	public void updateProfile(DataTable datatable){
		ProfilePage profilepage = new ProfilePage();
		List<Map<String,String>> list = datatable.asMaps(String.class,String.class);
		String profilename = list.get(0).get("Name");
		String mobnumber = list.get(0).get("Mobile Number");
		String profileage = list.get(0).get("Age Group");
		String country = list.get(0).get("Country");
		String profession = list.get(0).get("Profession");
		String qualification = list.get(0).get("Qualification");
		String gradyear = list.get(0).get("Graduation Year");
		profilepage.setName(profilename);
		profilepage.setMobNumber(mobnumber);
		profilepage.setCountryResident(country);
		profilepage.setAgeGroup(profileage);
		
		profilepage.setProfession(profession);
		profilepage.setQualification(qualification);
		profilepage.setGraduationYear(gradyear);
	}
	
	@Then("^user validates below entered are updated for profession as other$")
	public void validateProfile(DataTable datatable){
		ProfilePage profilepage = new ProfilePage();
		List<Map<String,String>> list = datatable.asMaps(String.class, String.class);
		String profilename = list.get(0).get("Name");
		String mobnumber = list.get(0).get("Mobile Number");
		String profileage = list.get(0).get("Age Group");
		String profilecountry = list.get(0).get("Country");
		String profession = list.get(0).get("Profession");
		String qualification = list.get(0).get("Qualification");
		String gradyear = list.get(0).get("Graduation Year");
		
		profilepage.checkName(profilename);
		profilepage.checkMobNumber(mobnumber);
		profilepage.checkagegroup(profileage);
		profilepage.checkcountry(profilecountry);
		profilepage.checkprofession(profession);
		profilepage.checkqualification(qualification);
		profilepage.checkGraduationYear(gradyear);
	}

	@When("^user enters profile details for profession as Student$")
	public void updateProfileStudent(DataTable datatable){
		
		
		ProfilePage profilepage = new ProfilePage();
		List<Map<String,String>> list = datatable.asMaps(String.class,String.class);
		String profilename = list.get(0).get("Name");
		String mobnumber = list.get(0).get("Mobile Number");
		String profileage = list.get(0).get("Age Group");
		String country = list.get(0).get("Country");
		String profession = list.get(0).get("Profession");
		String qualification = list.get(0).get("Qualification");
		String gradyear = list.get(0).get("Graduation Year");
		String lcflag= list.get(0).get("LC Flag");
		String state= list.get(0).get("State");
		String city= list.get(0).get("City");
		String college= list.get(0).get("College");
		String rollno = list.get(0).get("Roll Number");
		String degree= list.get(0).get("Degree");
		String department= list.get(0).get("Department");
		String studyyear= list.get(0).get("Study Year");
				
		profilepage.setCountryResident(country);
		profilepage.setProfession(profession);
		profilepage.setName(profilename);
		profilepage.setMobNumber(mobnumber);		
		profilepage.setAgeGroup(profileage);		
		profilepage.setQualification(qualification);		
		profilepage.setGraduationYear(gradyear);
		profilepage.setlcflag(lcflag);
		profilepage.setstate(state);
		profilepage.setcollegename(college,city,lcflag);
		profilepage.setrollnumber(rollno);
		profilepage.setDegree(degree);
		profilepage.setDepartment(department);
		profilepage.setStudyYear(studyyear);
	}
	
	@Then("^user validates below entered are updated for profession as Student$")
	public void validateProfileStudent(DataTable datatable){
		ProfilePage profilepage = new ProfilePage();
		List<Map<String,String>> list = datatable.asMaps(String.class, String.class);
		String profilename = list.get(0).get("Name");
		String mobnumber = list.get(0).get("Mobile Number");
		String profileage = list.get(0).get("Age Group");
		String profilecountry = list.get(0).get("Country");
		String profession = list.get(0).get("Profession");
		String qualification = list.get(0).get("Qualification");
		String gradyear = list.get(0).get("Graduation Year");
		String lcflag= list.get(0).get("LC Flag");
		String state= list.get(0).get("State");
		String city= list.get(0).get("City");
		String college= list.get(0).get("College");
		String rollno = list.get(0).get("Roll Number");
		String degree= list.get(0).get("Degree");
		String department= list.get(0).get("Department");
		String studyyear= list.get(0).get("Study Year");
		
		
		profilepage.checkName(profilename);
		profilepage.checkMobNumber(mobnumber);
		profilepage.checkagegroup(profileage);
		profilepage.checkcountry(profilecountry);
		profilepage.checkprofession(profession);
		profilepage.checkqualification(qualification);
		profilepage.checkGraduationYear(gradyear);
		profilepage.checklcflag(lcflag);
		profilepage.checkState(state);
		profilepage.checkcollegename(college,city,lcflag);
		profilepage.checkrollnumber(rollno);
		profilepage.checkDegree(degree);
		profilepage.checkDepartment(department);
		profilepage.checkStudyYear(studyyear);
	}


	@When("^user enters profile details for profession as Employed$")
	public void updateProfileEmployed(DataTable datatable){
		
		
		ProfilePage profilepage = new ProfilePage();
		List<Map<String,String>> list = datatable.asMaps(String.class,String.class);
		String profilename = list.get(0).get("Name");
		String mobnumber = list.get(0).get("Mobile Number");
		String profileage = list.get(0).get("Age Group");
		String country = list.get(0).get("Country");
		String profession = list.get(0).get("Profession");
		String qualification = list.get(0).get("Qualification");
		String gradyear = list.get(0).get("Graduation Year");
		String lcflag= list.get(0).get("LC Flag");
		String industrySpoc= list.get(0).get("Industry Spoc");
		
		
		
		profilepage.setCountryResident(country);
		profilepage.setProfession(profession);
		profilepage.setName(profilename);
		profilepage.setMobNumber(mobnumber);
		
		profilepage.setAgeGroup(profileage);
		
		
		profilepage.setQualification(qualification);
		
		profilepage.setGraduationYear(gradyear);
		profilepage.setindustrylcflag(lcflag);		
		profilepage.setIndustrySpoc(industrySpoc);
		
		
			}
	
	@Then("^user validates below entered are updated for profession as Employed$")
	public void validateProfileEmployed(DataTable datatable){
		ProfilePage profilepage = new ProfilePage();
		List<Map<String,String>> list = datatable.asMaps(String.class, String.class);
		String profilename = list.get(0).get("Name");
		String mobnumber = list.get(0).get("Mobile Number");
		String profileage = list.get(0).get("Age Group");
		String country = list.get(0).get("Country");
		String profession = list.get(0).get("Profession");
		String qualification = list.get(0).get("Qualification");
		String gradyear = list.get(0).get("Graduation Year");
		String lcflag= list.get(0).get("LC Flag");
		String industrySpoc= list.get(0).get("Industry Spoc");
		
		profilepage.checkName(profilename);
		profilepage.checkMobNumber(mobnumber);
		profilepage.checkagegroup(profileage);
		profilepage.checkcountry(country);
		profilepage.checkprofession(profession);
		profilepage.checkqualification(qualification);
		profilepage.checkGraduationYear(gradyear);
		profilepage.checkindustrylcflag(industrySpoc);;
		
	}

	
	@When("^user checks Honor Code checkbox and Swayam T&C$")
	public void clickSwayamTC(){
		ProfilePage profilePage = new ProfilePage();
		profilePage.clickTermsAndCondCheckbox();
		profilePage.clickHonorCodeCheckbox();
	}
	
	
	@When("^user enters profile details for profession as Faculty$")
	public void updateProfileFaculty(DataTable datatable){
		
		
		ProfilePage profilepage = new ProfilePage();
		List<Map<String,String>> list = datatable.asMaps(String.class,String.class);
		String profilename = list.get(0).get("Name");
		String mobnumber = list.get(0).get("Mobile Number");
		String profileage = list.get(0).get("Age Group");
		String country = list.get(0).get("Country");
		String profession = list.get(0).get("Profession");
		String qualification = list.get(0).get("Qualification");
		String gradyear = list.get(0).get("Graduation Year");
		String lcflag= list.get(0).get("LC Flag");
		String state= list.get(0).get("State");
		String city= list.get(0).get("City");
		String college= list.get(0).get("College");
		
		String area= list.get(0).get("Area");
		String department= list.get(0).get("Department");
		
		
		
		
		profilepage.setCountryResident(country);
		profilepage.setProfession(profession);
		profilepage.setName(profilename);
		profilepage.setMobNumber(mobnumber);		
		profilepage.setAgeGroup(profileage);		
		profilepage.setQualification(qualification);		
		profilepage.setGraduationYear(gradyear);
		
		profilepage.setlcflag(lcflag);
		profilepage.setstate(state);
		profilepage.setcollegename(college,city,lcflag);
		profilepage.setArea(area);
		profilepage.setFacultyDepartment(department);
		
	}
	
	@Then("^user validates below entered are updated for profession as Faculty$")
	public void validateProfileFaculty(DataTable datatable){
		ProfilePage profilepage = new ProfilePage();
		List<Map<String,String>> list = datatable.asMaps(String.class, String.class);
		String profilename = list.get(0).get("Name");
		String mobnumber = list.get(0).get("Mobile Number");
		String profileage = list.get(0).get("Age Group");
		String country = list.get(0).get("Country");
		String profession = list.get(0).get("Profession");
		String qualification = list.get(0).get("Qualification");
		String gradyear = list.get(0).get("Graduation Year");
		String lcflag= list.get(0).get("LC Flag");
		String state= list.get(0).get("State");
		String city= list.get(0).get("City");
		String college= list.get(0).get("College");
		
		String area= list.get(0).get("Area");
		String department= list.get(0).get("Department");
		
		
		profilepage.checkName(profilename);
		profilepage.checkMobNumber(mobnumber);
		profilepage.checkagegroup(profileage);
		profilepage.checkcountry(country);
		profilepage.checkprofession(profession);
		profilepage.checkqualification(qualification);
		profilepage.checkGraduationYear(gradyear);
		profilepage.checklcflag(lcflag);
		profilepage.checkState(state);
		profilepage.checkcollegename(college,city,lcflag);
		profilepage.checkArea(area);
		profilepage.checkFacultyDepartment(department);
		
	}


	
	
		
	@Then("^user validate the error message \"([^\"]*)\" for both the checkboxes$")
	public void validateErrorHandling(String errormsg){
		ProfilePage profilepage = new ProfilePage();
		profilepage.validateErrorHandling(errormsg);
		
	}
	
	@Then("^user checks one of checkbox$")
	public void ClickHonorCode(){
		ProfilePage profilePage = new ProfilePage();		
		profilePage.clickHonorCodeCheckbox();
	}
	
	@And("^user verifies the checkboex fields have required attribute for validation$")
	public void validateCheckBox(){
		ProfilePage profilePage = new ProfilePage();		
		profilePage.verifyCheckboxValidation();
	}

	@Then("^verifies the text on terms of use pop up$")
	public void verifyTextOnTermsPopup() {
		ProfilePage profilePage = new ProfilePage();
		profilePage.verifyTermsOfUseContent();
	}
	@Then("^verifies the text on honor code pop up$")
	public void verifyTextOnHonorPopup() {
		ProfilePage profilePage = new ProfilePage();
		profilePage.verifyHonorCodeContent();
	}

        @Then("^user choose to edit the profile before joining$")
	public void clickOnEditProfileAndJoin(){
		ProfilePage profilePage = new ProfilePage();
		profilePage.clickOnEditProfileAndJoin();
		
	}
}

