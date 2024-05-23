package com.swayam.pages;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.swayam.base.Util;

public class ProfilePage extends HomePage {

	final static Logger Log = Logger.getLogger(ProfilePage.class.getName());

	@FindBy(id = "form01")
	WebElement profilename;

	@FindBy(id = "mobile_number")
	WebElement mobnumber;

        @FindBy(id = "editProfileBtn")
	WebElement editProfileAndJoin;

	@FindBy(id = "age_group")
	WebElement agegroup;

	@FindBy(id = "country_of_residence")
	WebElement country;

	@FindBy(id = "profession")
	WebElement profession;

	@FindBy(id = "terms")
	WebElement termsCheckbox;

	@FindBy(id = "honor_code")
	WebElement honorCodeCheckbox;

	@FindBy(id = "qualification")
	WebElement qualification;

	@FindBy(id = "graduationyear")
	WebElement graduationyear;

	@FindBy(id = "local_chapter")
	WebElement localchapterflag;

	@FindBy(id = "state_of_residence")
	WebElement stateofresidence;

	@FindBy(id = "local_chapter")
	WebElement lcFlag;

	@FindBy(id = "industry_local_chapter")
	WebElement industrylcFlag;

	@FindBy(id = "state_of_residence")
	WebElement stateResidence;

//	@FindBy(id = "local_chapter_college")
	@FindBy(id = "select2-local_chapter_college-container")
	WebElement localChapterCollege;

	@FindBy(id = "college")
	WebElement collegeByStud;

	@FindBy(id = "city_of_residence")
	WebElement cityofresidence;

	@FindBy(id = "college_roll_no")
	WebElement studrollnumber;

	@FindBy(id = "student_degree")
	WebElement studdegree;

	@FindBy(id = "faculty_area")
	WebElement studarea;

	@FindBy(id = "student_department")
	WebElement studdepartment;

	@FindBy(id = "faculty_department")
	WebElement facultydepartment;

	@FindBy(id = "study_year")
	WebElement studstudyyear;

	@FindBy(id = "industry_local_chapter_employer")
	WebElement industrylc;

	// @FindBy(id = "regFormSubmitLi")
	@FindBy(xpath = "//*[@id='regFormSubmitLi']/div/label")
	WebElement errmsg;
	
	@FindBy(xpath = "//input[@class='select2-search__field']")
	WebElement localChapterSearchbox;
	
	@FindBy(xpath = "//*[@id='select2-local_chapter_college-results']/li[contains(.,'Other')]")
	WebElement resultOther;
	
	@FindBy(xpath = "//*[@id='select2-local_chapter_college-results']/li[contains(.,'NESS WADIA')]")
	WebElement resultCollege;

	public void setName(String name) {
		String updatename = prop.getProperty(name);
		profilename.clear();
		profilename.sendKeys(updatename);
		Log.info("Profile name updated to - " + updatename);
	}

	public void checkName(String name) {
		String expectedname = prop.getProperty(name);
		Assert.assertEquals(expectedname, profilename.getAttribute("value"));
		Log.info("Updated value for profile name has been validated");
	}

	public void setMobNumber(String mobnum) {
		String updatenum = prop.getProperty(mobnum);
		mobnumber.clear();
		mobnumber.sendKeys(updatenum);
		Log.info("Mobile number updated to - " + updatenum);
	}

	public void checkMobNumber(String mobnum) {
		String expectednum = prop.getProperty(mobnum);
		expectednum = expectednum.replaceAll("\\s+", "");
		;
		String actualnum = mobnumber.getAttribute("value").replaceAll("\\s+",
				"");
		;
		Assert.assertEquals(expectednum, actualnum);
		Log.info("Updated value for mobile number has been validated");
	}

	public void setAgeGroup(String agegrp) {
		String updateagegroup = prop.getProperty(agegrp);
		agegroup.sendKeys(updateagegroup);

		Log.info("Age group selected - " + updateagegroup);
	}

	public void checkagegroup(String profileage) {
		String expectedagegroup = prop.getProperty(profileage);

		Assert.assertEquals(expectedagegroup, agegroup.getAttribute("value"));

		Log.info("Updated value for age group has been validated");

	}

	public void setCountryResident(String countryname) {
		String updatecountry = prop.getProperty(countryname);
		country.sendKeys(updatecountry);
	}

	public void checkcountry(String profilecountry) {
		String expectedcountry = prop.getProperty(profilecountry);
		Assert.assertEquals(expectedcountry.toLowerCase(), country
				.getAttribute("value").toLowerCase());
		Log.info("Updated value for country name has been validated");
	}

	public void setProfession(String prof) {
		String updateprofession = prop.getProperty(prof);
		profession.sendKeys(updateprofession);
		Log.info("Profession selected is - " + updateprofession);
	}

	public void checkprofession(String prof) {
		String expectedprofession = prop.getProperty(prof);
		Assert.assertEquals(expectedprofession.toLowerCase(), profession
				.getAttribute("value").toLowerCase());
		Log.info("Updated value for profession has been validated");
	}

	public void setQualification(String qual) {
		String updatequal = prop.getProperty(qual);
		qualification.sendKeys(updatequal);
		Log.info("Qualifcations selected is - " + updatequal);
	}

	public void checkqualification(String qual) {
		String expectedqualification = prop.getProperty(qual);
		Select select = new Select(qualification);
		Assert.assertEquals(expectedqualification.toLowerCase(), select
				.getFirstSelectedOption().getText().toLowerCase());

		Log.info("Updated value for qualification has been validated");
	}

	public void setGraduationYear(String gradyear) {
		String updategrad = prop.getProperty(gradyear);
		graduationyear.sendKeys(updategrad);
		Log.info("Graduation year selected is- " + updategrad);
	}

	public void checkGraduationYear(String gradyear) {
		String expectedyearofgraduation = prop.getProperty(gradyear);
		Assert.assertEquals(expectedyearofgraduation,
				graduationyear.getAttribute("value"));
		Log.info("Updated value for gradution year has been validated");
	}

	public void setStateofResidence(String stateresidence) {
		String updatestate = prop.getProperty(stateresidence);
		stateofresidence.sendKeys(updatestate);
		Log.info("State of residence is - " + updatestate);
	}

	public void checkstateofresidence(String stateresidence) {
		String expectedstateofresidence = prop.getProperty(stateresidence);
		Assert.assertEquals(expectedstateofresidence,
				stateofresidence.getAttribute("value"));
		Log.info("Updated value for state of residence have been validated");
	}

	public void setLCCollege(String collegename) {
		String updatelccollege = prop.getProperty(collegename);
		localChapterCollege.sendKeys(updatelccollege);

		Log.info("College name selected is - " + updatelccollege);
	}

	public void checkcollege(String collegename) {
		String expectedcollegename = prop.getProperty(collegename);
		Assert.assertEquals(expectedcollegename,
				localChapterCollege.getAttribute("value"));

		Log.info("Updated value for college name has been validated");
	}

	public void setlcflag(String lcflag) {
		String flag = prop.getProperty(lcflag);
		lcFlag.sendKeys(flag);

		Log.info("lc flag has been set to : " + flag);
	}

	public void checklcflag(String flag) {
		String expectedflag = prop.getProperty(flag);
		Select select = new Select(localchapterflag);

		Assert.assertEquals(expectedflag.toLowerCase(), select
				.getFirstSelectedOption().getText().toLowerCase());

		Log.info("Updated value for LC Flag has been validated");
	}

	public void setindustrylcflag(String lcflag) {
		String flag = prop.getProperty(lcflag);
		industrylcFlag.sendKeys(flag);

		Log.info("industry lc flag has been set to : " + flag);
	}

	public void checkindustrylcflag(String flag) {
		String expectedflag = prop.getProperty(flag);
		Select select = new Select(industrylc);

		Assert.assertEquals(expectedflag.toLowerCase(), select
				.getFirstSelectedOption().getText().toLowerCase());

		Log.info("Updated value for industry LC Flag has been validated"
				+ expectedflag);
	}

	public void setstate(String state) {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String statevalue = prop.getProperty(state);
		stateResidence.sendKeys(statevalue);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.info("lc flag has been set to : " + statevalue);

	}

	public void checkState(String state) {
		String expectedstate = prop.getProperty(state);
		Assert.assertEquals(expectedstate, stateResidence.getAttribute("value"));

		Log.info("Updated state has been validated");
	}

	public void setcollegename(String college, String city, String lcflag) {

		String collegevalue = prop.getProperty(college);
		String flag = prop.getProperty(lcflag);
		
		Util util = new Util();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (flag.compareToIgnoreCase("Yes") == 0) {
		//	localChapterCollege.sendKeys(collegevalue);
			
			util.waitForElementToPresent(localChapterCollege, 20);
			localChapterCollege.click();
			util.waitForElementToPresent(localChapterSearchbox, 30);
			localChapterSearchbox.clear();
			localChapterSearchbox.sendKeys(collegevalue);
			resultCollege.click();
		}
			
		else {
			
			util.waitForElementToPresent(localChapterCollege, 20);
			localChapterCollege.click();
			util.waitForElementToPresent(localChapterSearchbox, 30);
			localChapterSearchbox.clear();
		//	localChapterCollege.sendKeys("other");
			localChapterSearchbox.sendKeys("Other");
			resultOther.click();
			util.waitForElementToPresent(cityofresidence, 20);
			cityofresidence.clear();
			String cityvalue = prop.getProperty(city);
			cityofresidence.sendKeys(cityvalue);
			collegeByStud.clear();
			collegeByStud.sendKeys(collegevalue);
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Log.info("College name has been set to : " + collegevalue);
	}

	public void checkcollegename(String college, String city, String lcflag) {

		String expectedcollege = prop.getProperty(college);
		String flag = prop.getProperty(lcflag);
		String expectedcity = prop.getProperty(city);

		if (flag.compareToIgnoreCase("Yes") == 0) {
		//	Select select = new Select(localChapterCollege);
		//	Assert.assertEquals(expectedcollege.toLowerCase(), select
		//			.getFirstSelectedOption().getText().toLowerCase());
			Assert.assertEquals(expectedcollege.toLowerCase(), localChapterCollege
					.getText().toLowerCase());
			Log.info("Updated college name has been validated");
		} else {
			Assert.assertEquals(expectedcity.toLowerCase(), cityofresidence
					.getAttribute("value").toLowerCase());
			Assert.assertEquals(expectedcollege.toLowerCase(), collegeByStud
					.getAttribute("value").toLowerCase());
			Log.info("Updated college name has been validated");
		}
	}

	public void setrollnumber(String rollno) {
		String rnum = prop.getProperty(rollno);
		studrollnumber.clear();
		studrollnumber.sendKeys(rnum);
		Log.info("Student roll number has been set to : " + rnum);

	}

	public void checkrollnumber(String rollno) {
		String expectedcollege = prop.getProperty(rollno);
		Assert.assertEquals(expectedcollege,
				studrollnumber.getAttribute("value"));

		Log.info("Updated student roll number has been validated");
	}

	public void setDegree(String degree) {
		String degreevalue = prop.getProperty(degree);
		studdegree.sendKeys(degreevalue);
		Log.info("Student education-degree has been selected as : "
				+ degreevalue);

	}

	public void checkDegree(String degree) {
		String expected = prop.getProperty(degree);
		Assert.assertEquals(expected.toLowerCase(),
				studdegree.getAttribute("value").toLowerCase());

		Log.info("Updated student degree has been validated");
	}

	public void setArea(String area) {
		String areavalue = prop.getProperty(area);
		studarea.sendKeys(areavalue);
		Log.info("Faculty area has been selected as : " + areavalue);

	}

	public void checkArea(String area) {
		String expected = prop.getProperty(area);
		Assert.assertEquals(expected.toLowerCase(),
				studarea.getAttribute("value").toLowerCase());

		Log.info("Updated area has been validated");
	}

	public void setDepartment(String dept) {
		String setdept = prop.getProperty(dept);
		studdepartment.sendKeys(setdept);
		Log.info("Student education-department has been selected as : "
				+ setdept);

	}

	public void setFacultyDepartment(String dept) {
		String setdept = prop.getProperty(dept);
		facultydepartment.sendKeys(setdept);
		Log.info("Faculty education-department has been selected as : "
				+ setdept);

	}

	public void checkDepartment(String dept) {
		String expected = prop.getProperty(dept);
		Assert.assertEquals(expected, studdepartment.getAttribute("value"));

		Log.info("Updated student department has been validated");
	}

	public void checkFacultyDepartment(String dept) {
		String expected = prop.getProperty(dept);
		Assert.assertEquals(expected, facultydepartment.getAttribute("value"));

		Log.info("Updated faculty department has been validated");
	}

	public void setStudyYear(String year) {
		String setyear = prop.getProperty(year);
		studstudyyear.sendKeys(setyear);
		Log.info("Study year has been selected as : " + setyear);

	}

	public void checkStudyYear(String year) {
		String expected = prop.getProperty(year);
		Select select = new Select(studstudyyear);
		Assert.assertEquals(expected.toLowerCase(), select
				.getFirstSelectedOption().getText().toLowerCase());

		Log.info("Updated student study year has been validated");
	}

	public void setIndustrySpoc(String industrySpoc) {
		String spoc = prop.getProperty(industrySpoc);
		industrylc.sendKeys(spoc);

		Log.info("Industry Spoc has been set as : " + spoc);

	}

	public void clickTermsAndCondCheckbox() {
		Log.info("clicking on terms and condition checkbox");
		termsCheckbox.click();
	}

	public void clickHonorCodeCheckbox() {
		Log.info("clicking on honor code checkbox");
		honorCodeCheckbox.click();
	}

	public void validateErrorHandling(String errormsg) {

		String actualerrmsg = errmsg.getText();
		String expectedmsg = prop.getProperty(errormsg);
		Assert.assertEquals(expectedmsg, actualerrmsg);
	}

	public void verifyCheckboxValidation() {
		Util util = new Util();
		boolean termsStatus = util
				.isElementHavingRequiredAttritute(termsCheckbox);
		Assert.assertEquals(true, termsStatus);
		boolean honorCodeStatus = util
				.isElementHavingRequiredAttritute(honorCodeCheckbox);
		Assert.assertEquals(true, honorCodeStatus);
	}

	public void verifyTermsOfUseContent() {
		Log.info("verifying terms of use pop up content");
		By termsLoc = By
				.xpath("//iframe[@src='/modules/nptel/assets/html/terms.html']");
		File file = new File("./resources/testdata/termsOfUse.txt");
		verifyPopupContent(termsLoc, file);

	}
	
	public void verifyHonorCodeContent() {
		Log.info("verifying honor code pop up content");
		By termsLoc = By
				.xpath("//iframe[@src='/modules/nptel/assets/html/honor_code.html']");
		File file = new File("./resources/testdata/honorCode.txt");
		verifyPopupContent(termsLoc, file);
	}


	public void verifyPopupContent(By by, File file) {
		Util util = new Util();
		util.waitForFrameToAvailableAndSwitch(by, 10);
		String actualContent = driver.findElement(By.tagName("body")).getText()
				.replace("\n", "").replaceAll("\r", "");
		System.out.println("######################################");
		System.out.println(driver.findElement(By.tagName("body")).getText());
		System.out.println("######################################");
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//div[@class='visiblePopupDiv gcb-aside']//a[@class='closeXButton']")).click();
		String expectedContent = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String st;
			while ((st = br.readLine()) != null) {
				expectedContent = expectedContent + st;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals(expectedContent.trim(), (actualContent.trim()));

	}

          public void clickOnEditProfileAndJoin() {
		Util util = new Util();
		util.waitForElementToPresent(editProfileAndJoin, 10);
		editProfileAndJoin.click();
	}

}
