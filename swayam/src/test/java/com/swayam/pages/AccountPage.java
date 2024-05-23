package com.swayam.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.swayam.base.Util;

public class AccountPage extends HomePage {

	final static Logger Log = Logger.getLogger(AccountPage.class.getName());

	Util Util = new Util();
	@FindBy(xpath = "//div[@class='container']//a[@class='dropdown-toggle go-text-right']/b")
	WebElement userNameNav;

	@FindBy(xpath = "//div[@class='container']//a[contains(.,'Logout')]")
	WebElement logoutOption;

	@FindBy(xpath = "//div[@class='container']//ul[@class='dropdown-menu']")
	WebElement optionNav;

	@FindBy(xpath = "//div[@class='row']//h3")
	WebElement welcomeMessage;

	public boolean isUserLoggerIn() {
		Util.waitForTitleToContain(prop.getProperty("title.homepage"), 10);
		return welcomeMessage.getText().contains(
				prop.getProperty("user.fullname"));
	}

	public void openUserMenu() {
		Log.info("opening user menu ");
		userNameNav.click();
		Util.waitForElementToPresent(optionNav, 5);
	}

	public void clickOnLogout() {
		logoutOption.click();
	}

	public LoginPage logout() {
		openUserMenu();
		clickOnLogout();
		return new LoginPage();
	}

}
