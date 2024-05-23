package com.swayam.pages;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.swayam.base.Util;

public class CentralAdminPage extends HomePage {
	final static Logger Log = Logger.getLogger(CentralAdminPage.class.getName());

	Util util = new Util();

	@FindBy(id = "menu-group__analytics")
	WebElement manageMenu;

	@FindBy(id = "menu-group__organization")
	WebElement organizationMenu;

	@FindBy(id = "menu-group__settings")
	WebElement settingMenu;

	@FindBy(id = "menu-item__analytics__local_chapters")
	WebElement localChapterMenu;

	@FindBy(id = "menu-item__organization__instructor")
	WebElement instructorMenu;

	@FindBy(id = "menu-item__analytics__instructors")
	WebElement instructorMenuFromManage;

	@FindBy(xpath = "//h3")
	WebElement pageSubHeader;

	@FindBy(name = "code")
	WebElement localChapterCode;
	
	@FindBy(xpath = "//div[@class='inputEx-UneditableField-wrapper']")
	WebElement LCCode;
	
	@FindBy(name = "name")
	WebElement localChapterName;

	@FindBy(name = "city")
	WebElement city;

	@FindBy(name = "country")
	WebElement country;

	@FindBy(id = "gcb-footer")
	WebElement footer;

	@FindBy(name = "state")
	WebElement state;

	@FindBy(name = "org_type")
	WebElement orgType;

	@FindBy(name = "spoc_emails[0]")
	WebElement spocEmail;

	@FindBy(className = "inputEx-List-link")
	WebElement spocEmailAdd;

	@FindBy(className = "inputEx-UneditableField-wrapper")
	WebElement instructorCode;

	@FindBy(id = "menu-item__analytics__spoc_global_student_list")
	WebElement spocGlobalStudentList;

	@FindBy(className = "google-visualization-table-table")
	WebElement studentTable;

	public CentralAdminPage() {
		super();
	}

	public void openManageMenu() {
		Log.info("openning manage option on admin side");
		util.waitForElementToPresent(manageMenu, 20);
		util.WaitForElementToBeClickable(manageMenu, 20);
		manageMenu.click();
		Log.info("opened manage option on admin side");
		// util.waitForElementToPresent(spocGlobalStudentList, 30);
	}

	public void openOrgMenu() {
		Log.info("openning organization option on admin side");
		util.waitForElementToPresent(organizationMenu, 10);
		organizationMenu.click();
	}

	public void openSettingMenu() {
		Log.info("openning settings option on admin side");
		util.waitForElementToPresent(settingMenu, 10);
		settingMenu.click();
	}

	public void openLCpage() {
		Log.info("openning LC page from manage->Local Chapters");
		 openManageMenu();
		
		 try {
		 Thread.sleep(30000);
		 } catch (InterruptedException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }

		util.waitForElementToPresent(localChapterMenu, 20);
		localChapterMenu.click();
	}

	public void verifyLocalChapterPage() {
		Log.info("verifying Local Chapters page using page header");
		util.waitForElementToPresent(footer, 30);
		util.waitForElementToPresent(pageSubHeader, 30);
		Assert.assertEquals(pageSubHeader.getText(), prop.getProperty("lc.subHeader"));

	}

	public void verifySPOCAdminPage() {
		Log.info("verifying Spoc Admin page using page header");
		// util.waitForElementToPresent(pageSubHeader, 10);
		// Assert.assertEquals(pageSubHeader.getText(),
		// prop.getProperty("spocAdmin.subHeader"));

		// Properties prop = new Properties();

		// prop.getProperty("firstNode");
		// try {
		// prop.load(CentralAdminPage.class.getClassLoader().getResourceAsStream("environment.properties"));
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		String firstNode = prop.getProperty("firstNode");

		// System.out.println("Link of firstNode is :" + firstNode);

		firstNode = firstNode.replace("modules/admin", "");

		// System.out.println(firstNode);

		firstNode = firstNode.concat("spoc");

		// System.out.println(firstNode);

		driver.get(firstNode);

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void verifyInstructorPage() {
		Log.info("verifying Instructor page using page header");
		util.waitForElementToPresent(footer, 30);
		util.waitForElementToPresent(pageSubHeader, 30);
		Assert.assertEquals(pageSubHeader.getText(), prop.getProperty("instructor.subHeader"));

	}

	public void verifyIndustrySPOCAdminPage() {
		Log.info("verifying Spoc Admin page using page header");
		util.waitForElementToPresent(pageSubHeader, 10);
		System.out.println("PageSubHeader is :: " + pageSubHeader);
		Assert.assertEquals(pageSubHeader.getText(), prop.getProperty("spocAdmin.subHeader.industry"));
	}

	public void clickCourseUrl(String courseName) {
		Log.info("clicking on course URL");
		courseName = prop.getProperty(courseName);
		// courseName= "test2019-05-31 10:49:29";
		util.clickCourseUrl(courseName);
	}
	
	public void clickCourseUrlIndustry(String courseName) {
		Log.info("clicking on course URL");
		courseName = prop.getProperty(courseName);
		// courseName= "test2019-05-31 10:49:29";
		util.clickCourseUrlIndustry(courseName);
	}

	/*
	 * public void enterLCFieldValue(List lcData) {
	 * 
	 * }
	 */

	public void enterLCCode(String code) {
		code = prop.getProperty(code);
		Log.info("entering LC Code as -" + code);
		util.waitForElementToPresent(localChapterCode, 10);
		localChapterCode.sendKeys(code);

	}

	public void enterLCName(String name) {
		name = prop.getProperty(name);
		Log.info("entering LC Name as " + name);
		util.waitForElementToPresent(localChapterName, 10);
		localChapterName.sendKeys(name);

	}

	public void enterLCCity(String cityName) {
		cityName = prop.getProperty(cityName);
		Log.info("entering LC city name as " + cityName);
		util.waitForElementToPresent(city, 10);
		city.sendKeys(cityName);

	}

	public void enterLCCountry(String countryName) {
		countryName = prop.getProperty(countryName);
		Log.info("entering LC country name as " + countryName);
		util.waitForElementToPresent(country, 10);
		util.selectAnOption(country, countryName);
	}

	public void enterLCState(String stateName) {
		stateName = prop.getProperty(stateName);
		Log.info("entering LC state name as " + stateName);
		util.waitForElementToPresent(state, 30);
		util.selectAnOption(state, stateName);
	}

	public void enterLCOrgType(String orgName) {
		orgName = prop.getProperty(orgName);
		Log.info("entering LC org name as " + orgName);
		util.waitForElementToPresent(orgType, 10);
		util.selectAnOption(orgType, orgName);
	}

	public void enterLCSPOCEmail(String email) {
		email = prop.getProperty(email);
		Log.info("entering LC email address as " + email);
		spocEmailAdd.click();
		util.waitForElementToPresent(spocEmail, 10);
		spocEmail.sendKeys(email);
	}

	public void verifyValueOfLCCode(String expectedCode) {
		expectedCode = prop.getProperty(expectedCode);
		Log.info("veriying LC code value on saved LC as " + expectedCode);
	//	util.waitForElementToPresent(localChapterCode, 10);
		util.waitForElementToPresent(LCCode, 10);
	//	Assert.assertEquals(localChapterCode.getAttribute("value"), expectedCode);
		Assert.assertEquals(LCCode.getText(), expectedCode);
	}

	public void verifyValueOfLCName(String expectedLcName) {
		expectedLcName = prop.getProperty(expectedLcName);
		Log.info("veriying LC name value on saved LC as " + expectedLcName);
		util.waitForElementToPresent(localChapterName, 10);
		Assert.assertEquals(localChapterName.getAttribute("value"), expectedLcName);
	}

	public void verifyValueOfLCCity(String expectedCity) {
		expectedCity = prop.getProperty(expectedCity);
		Log.info("veriying LC name city on saved LC as " + expectedCity);
		util.waitForElementToPresent(city, 10);
		Assert.assertEquals(city.getAttribute("value"), expectedCity);

	}

	public void verifyValueOfLCState(String expectedState) {
		expectedState = prop.getProperty(expectedState);
		Log.info("veriying LC state city on saved LC as " + expectedState);
		util.waitForElementToPresent(state, 10);
		Assert.assertEquals(util.getSelctedOption(state), expectedState);
	}

	public void verifyValueOfLCCountry(String expectedCountry) {
		expectedCountry = prop.getProperty(expectedCountry);
		Log.info("veriying LC country on saved LC ass " + expectedCountry);
		util.waitForElementToPresent(country, 10);
		Assert.assertEquals(util.getSelctedOption(country), expectedCountry);
	}

	public void verifyValueOfLCOrgType(String expectedOrgType) {
		expectedOrgType = prop.getProperty(expectedOrgType);
		Log.info("veriying LC org type on saved LC as " + expectedOrgType);
		util.waitForElementToPresent(orgType, 10);
		Assert.assertEquals(util.getSelctedOption(orgType), expectedOrgType);

	}

	public void verifyValueOfLCSPOCEmail(String expectedSpocEmail) {
		expectedSpocEmail = prop.getProperty(expectedSpocEmail);
		Log.info("veriying LC email address on saved LC as " + expectedSpocEmail);
		util.waitForElementToPresent(spocEmail, 10);
		Assert.assertEquals(spocEmail.getAttribute("value"), expectedSpocEmail);

	}

	public void verifyUserOnSPOCEnrolledUserList(String userid) {
		userid = prop.getProperty(userid);
		Log.info("veriying user " + userid + ", is present on enrolled User list under spoc dashboard page");
		util.waitForElementToPresent(studentTable, 25);
		util.waitForElementToPresent(studentTable, 25);
		Assert.assertTrue(util.isUserPresent(userid));
	}

	public boolean isCourseListedUnderSpocLearnerCourseList(String email, String courseName) {
		boolean flag = false;
		Util util = new Util();
		List<WebElement> joinedCourseList = driver
				.findElements(By.xpath(util.getFormatedLocator("spoc.learner.course.list", email)));
		for (WebElement courseElement : joinedCourseList) {
			if (courseElement.getText().equals(courseName)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public void verifySpocLearnerCourseList(String email, String courseName) {
		email = prop.getProperty(email);
		courseName = prop.getProperty(courseName);

		Log.info("verifying that course " + courseName + ", listed on spoc course list under spoc dashbaord");
		Assert.assertTrue(isCourseListedUnderSpocLearnerCourseList(email, courseName),
				"course is not found on the course list");
	}

	public void gotoAllLocalChapterPage() {
		 openManageMenu();
		 try {
		 Thread.sleep(3000);
		 } catch (InterruptedException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
		util.waitForElementToPresent(spocGlobalStudentList, 20);
		util.WaitForElementToBeClickable(spocGlobalStudentList, 20);
		spocGlobalStudentList.click();
		util.waitForElementToPresent(pageSubHeader, 10);
		Assert.assertTrue(pageSubHeader.getText().contains(prop.getProperty("all.local.chapter.members")));

	}

	public void removeLocalChapter(String code) {
		code = prop.getProperty(code);
		Log.info("deleting an existing local chapter with id as " + code);
		if (util.isElementPresent(code)) {
			util.clickOnLink(code);
		//	util.waitForElementToPresent(localChapterCode, 60);
			util.waitForElementToPresent(LCCode, 60);
			util.clickOnLink("Delete");
			util.handleAlert();
		}

	}

	public void openInstructorpage() {
		Log.info("openning Instructor page from organization->Instructor");
		openOrgMenu();
		util.waitForElementToPresent(instructorMenu, 10);
		instructorMenu.click();
	}

	public void verifyAddInstructorPage() {
		Log.info("verifying Add Instructor page using page header");
		util.waitForElementToPresent(footer, 30);
		util.waitForElementToPresent(instructorCode, 30);
		Assert.assertTrue(instructorCode.getText().contains("i_"));
	}

	public void openInstructorpageOnNode() {
		Log.info("openning Instructor page from Manage->Instructor");
		// openManageMenu();
		util.waitForElementToPresent(instructorMenuFromManage, 10);
		instructorMenuFromManage.click();
	}

}
