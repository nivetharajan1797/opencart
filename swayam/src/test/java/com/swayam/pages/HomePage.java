package com.swayam.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.swayam.base.DriverManager;
import com.swayam.base.TestBase;
import com.swayam.base.Util;

public class HomePage extends TestBase {
	static public WebDriver driver;
	final static Logger Log = Logger.getLogger(HomePage.class.getName());

	@FindBy(xpath = "//a[@class='navbar-brand']/img")
	WebElement swayamLogo;
	@FindBy(xpath = "//a[.='	Sign Up']")
	WebElement signUpBtn;
	@FindBy(className = "dropdown-toggle")
	WebElement categoryDrpdwn;
	@FindBy(xpath = "//a[.='Arts']")
	WebElement artCategory;
	@FindBy(xpath = "//ul[@class='nav navbar-nav navbar-right']/li[3]")
	WebElement userDropdown;

	@FindBy(xpath = "//button[@name='submit']")
	WebElement signInButton;

	@FindBy(xpath = "//*[@class='modal-content']/div/div[contains(.,'Beware of fraudulent phishing emails')]//parent::div/button")
	WebElement cautionaryAdvicePopUp;

	// @FindBy(xpath = "//button[@class='close']")
	// WebElement covidPopUp;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void launchApp() throws InterruptedException {
		Log.info("Opening the Swayam central application");
		loadProp();
		String browserName = System.getProperty("browser");
		driver = DriverManager.getDriver(browserName);
		String url = prop.getProperty("baseURL");
		System.out.println(url);
		System.out.println(driver.getClass().getName());
		// Thread.sleep(3000);
		driver.get(url);
		// Thread.sleep(2000);
		driver.manage().window().maximize();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public boolean isUserOnHomePage() {
		Util util = new Util();
		util.waitForTitleToContain(prop.getProperty("title.homepage"), 20);
		Log.info("Verifying that user is on the Swayam homepage");
		return swayamLogo.getAttribute("alt").equals(prop.getProperty("logo.homepage"))
				&& swayamLogo.getAttribute("src").contains(prop.getProperty("logo.imgsrc"));
	}

	public void clickOnSignUpLink() {
		Log.info("clicking on Signup Link");
		signUpBtn.click();
	}

	public void openCategoriesDropdown() {
		Log.info("Opening Category Dropdown");
		categoryDrpdwn.click();
	}

	public void verifyCategoriesDropdown(List<String> categoriesActual) {
		List<String> catagoriesOption = new ArrayList<String>();
		for (String options : prop.getProperty("homepage.category.options").split(",")) {
			catagoriesOption.add(options);
		}
		if (catagoriesOption.size() == categoriesActual.size())
			Assert.assertTrue(catagoriesOption.equals(categoriesActual), "");
	}

	public void selectCategory(String name) {
		Log.info("selecting a category by its name -" + name);
		Util util = new Util();
		util.clickOnLink(name);
	}

	public void clickOnSigIn(String buttonName) {
		Util util = new Util();
		/* util.clickOnButton(buttonName); */

		if (cautionaryAdvicePopUp.isDisplayed()) {
			util.waitForElementToPresent(cautionaryAdvicePopUp, 10);
			cautionaryAdvicePopUp.click();
			util.WaitForElementToBeClickable(signInButton, 10);
		}

		util.waitForElementToPresent(signInButton, 40);
		Log.info("Clicking on Sign in button" + " On Homepage");
		signInButton.click();

	}

	public void cleanup() {
		if (driver != null) {
			Log.info("Closing the browsers");
			Log.info("************** Test ends here *****************");
			Log.info("***********************************************");
			try {
				driver.close();
				driver.quit();
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
	}

	public void selectAnOptionFromUserDropdown(String linkName) {
		Log.info("Selecting an option from user dropdown" + " On Homepage");
		Util util = new Util();
		WebElement e = driver.findElement(By.xpath(util.getFormatedLocator("generic.link.dropdown", linkName)));
		e.click();
	}

	public void verifyLinkPresentOnHeader(String linkName) {
		Log.info("verifying that link is present on header -" + linkName);
		Util util = new Util();
		WebElement e = driver.findElement(By.xpath(util.getFormatedLocator("generic.link.dropdown", linkName)));
		util.waitForElementToPresent(swayamLogo, 10);
		Log.info("verifying the link present by name as " + linkName + " On Homepage");
		Assert.assertTrue(e.isDisplayed());
	}

	public void verifyLinkIsNotPresentOnHeader(String linkName) {
		Log.info("verifying that link is not present on header -" + linkName + " On Homepage");
		Util util = new Util();
		util.waitForElementToPresent(swayamLogo, 10);
		Assert.assertFalse(
				driver.findElements(By.xpath(util.getFormatedLocator("generic.link.dropdown", linkName))).size() != 0);
	}

	public void openUserDropdown() {
		Log.info("Opening user dropdown on homepage");
		Util util = new Util();
		util.waitForElementToPresent(swayamLogo, 10);
		userDropdown.click();
	}

	public void openUserDropdownOnNode() {
		Log.info("Opening user dropdown on Node");
		Util util = new Util();
		util.waitForElementToPresent(categoryDrpdwn, 10);
		categoryDrpdwn.click();
	}

}
