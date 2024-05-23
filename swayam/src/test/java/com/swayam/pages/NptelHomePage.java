package com.swayam.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.swayam.base.Util;

public class NptelHomePage extends HomePage {

	final static Logger Log = Logger.getLogger(NptelHomePage.class.getName());
	String openWindowHandle = null;
	Util Util = new Util();
	@FindBy(xpath = "//a[.='Login']")
	WebElement loginLink;

	@FindBy(xpath = "//a[.='Dashboard']")
	WebElement dashboardLink;

	@FindBy(id = "controls")
	WebElement usernameText;

	public NptelHomePage() {
		super();
	}

	public boolean isNptelHomePagePresent() {
		Util.waitForElementToPresent(loginLink, 10);
		return loginLink.isDisplayed();
	}

	public void clickOnLogin(String link) {
		Util.clickOnLink(link);
	}

	public NodeAdminPage clickOnDashboard(String link) {
		Util.clickOnLink(link);
		return PageFactory.initElements(driver, NodeAdminPage.class);
	}

	public void gotoNode(String nodeName) {
		Log.info("navigating to url :" + prop.getProperty(nodeName));
		driver.get(prop.getProperty(nodeName));
	}

	public void closeTab() {
		if (driver.getWindowHandles().size() > 1) {
			driver.close();
			driver.switchTo().window(openWindowHandle);
		}
	}

	public String getUsernameText() {
		return usernameText.getText();
	}

	public void verifyUserNameOnHeader(String username) {
		Assert.assertTrue(getUsernameText()
				.contains(prop.getProperty(username)));
	}
}
