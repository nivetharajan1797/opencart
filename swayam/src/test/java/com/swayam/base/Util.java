package com.swayam.base;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.swayam.pages.HomePage;

public class Util extends HomePage {
	private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyz_";
	private static final int RANDOM_STRING_LENGTH = 5;
	static String openWindowHandle = null;
	final static Logger Log = Logger.getLogger(HomePage.class.getName());

	public void getScreenshot() throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(src.toPath(), new File("c:\\temp\\test.png").toPath());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void waitForElementToPresent(WebElement e, long timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(e));
	}

	public void waitForChildElementToPresent(WebElement select, long timeout) {
		new WebDriverWait(driver, timeout)
				.until(ExpectedConditions.presenceOfNestedElementLocatedBy(select, By.tagName("option")));
	}

	public void waitForPageTitleToContainText(String title, long timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.titleContains(title));
	}

	public void waitForElementsToPresent(List<WebElement> e, long timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfAllElements(e));
	}

	public void waitForElementsToPresent(By by, long timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
	}

	public void waitForAjax() {
		new WebDriverWait(driver, 180).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				return (Boolean) js.executeScript("return jQuery.active == 0");
			}
		});
	}

	public void waitTextNotToBePresentInElement() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = driver.findElement(By.id("foo"));
		wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(element, "No Credits")));
	}

	public void waitForElementToNotPresent(By locator, long timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public void waitForTitleToContain(String title, long timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.titleContains(title));
	}

	public void waitForUserToLoggedIn(long timeout) {
		new WebDriverWait(driver, timeout)
				.until(ExpectedConditions.invisibilityOfElementWithText(By.id("next"), "Sign in"));
		new WebDriverWait(driver, timeout).until(ExpectedConditions
				.or(ExpectedConditions.titleContains("Course Builder"), ExpectedConditions.titleContains("Central")));
	}

	public WebElement waitForElementToPresent(String locator, long timeout) {
		return new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}

	public WebElement waitForElementToPresent(By locator, long timeout) {
		return new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void WaitForButtonToBeClickable(String buttonName, long timeout) {
		WebElement element = driver.findElement(By.xpath(getFormatedLocator("generic.button", buttonName)));
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
	}

	public void WaitForElementToBeClickable(WebElement element, long timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
	}

	public void WaitForElementTo(WebElement element, long timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
	}

	public void WaitForElementTextToBePresent(WebElement element, String text, long timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	public void waitForConfirmationMessage(String msg) {

		By locatorby = By.xpath(String.format("//div[@id='gcb-butterbar-top']/p[.='%s.']", msg));
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(locatorby));

	}

	public void waitForFrameToAvailableAndSwitch(By locator, int timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}

	public void waitForFrameToAvailableAndSwitch(WebElement frameLocator, int timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}

	public void openDatePickerByLabel(String labelName) {
		WebElement element = driver.findElement(By.xpath(getFormatedLocator("node.datepicker.by.label", labelName)));
		WaitForElementToBeClickable(element, 15);
		element.click();
	}

	public void openNavigationLinkByName(String linkName) {
		WebElement element = driver.findElement(By.xpath(getFormatedLocator("node.left.navigation.link", linkName)));
		WaitForElementToBeClickable(element, 15);
		element.click();
	}

	public void clickOnLink(String linkName) {
		String locator = getFormatedLocator("generic.link", linkName);
		Log.info("clicking on " + linkName + " link");
		WebElement e = waitForElementToPresent(locator, 10);
		WaitForElementToBeClickable(e, 20);
		e.click();
	}

	public WebElement getElementUsingLabelText(String key, String text) {
		String locator = getFormatedLocator(key, text);
		return waitForElementToPresent(locator, 10);

	}

	public void clickOnUserLink(String linkName) {
		Log.info("opening the user dropdown from header");
		String locator = getFormatedLocator("user.dropdown.menu", linkName);
		WebElement e = waitForElementToPresent(locator, 10);
		WaitForElementToBeClickable(e, 20);
		e.click();
	}

	public String getFormatedLocator(String key, String formatString) {

		return String.format(prop.getProperty(key), formatString);
	}

	public String getFormatedLocator(String key, String formatSting1, String formatSting2) {
		return String.format(prop.getProperty(key), formatSting1, formatSting2);
	}

	public void clickOnButton(String buttonName) {
		String locator = getFormatedLocator("generic.button", buttonName);
		WebElement e = waitForElementToPresent(locator, 10);
		e.click();
	}

	public void clickCourseUrl(String courseName) {
		String locator = getFormatedLocator("course.LC.url", courseName);
		WebElement e = waitForElementToPresent(locator, 10);
		e.click();
	}
	
	public void clickCourseUrlIndustry(String courseName) {
		String locator = getFormatedLocator("course.LC.url.industry", courseName);
		WebElement e = waitForElementToPresent(locator, 10);
		e.click();
	}

	public void clickOnCourse(String courseName) {
		String locator = getFormatedLocator("central.course.card", courseName);
		WebElement courseLink = waitForElementToPresent(locator, 20);
		WaitForElementToBeClickable(courseLink, 20);
		courseLink.click();
	}

	public void clickAnAssessmenToUnit(String unitName) {

		String locator = getFormatedLocator("node.course.create.assessment", unitName);
		WebElement e = waitForElementToPresent(locator, 10);
		e.click();
	}

	public void clickAnEntityToUnit(String entityName, String unitName) {
		Log.info("selecting course entity " + entityName + " from course outline");
		switch (entityName.toUpperCase()) {
		case "LESSON":
			entityName = "+Lesson";
			break;
		case "ASSESSMENT":
			entityName = "+Assessment";
			break;
		case "PROGRAMMING ASSIGNMENT":
			entityName = "+Programming Assignments";
			break;

		case "SUBJECTIVE ASSIGNMENT":
			entityName = "+Subjective Assignment";
			break;
		default:

			break;
		}
		String locator = getFormatedLocator("node.course.create.entity", unitName, entityName);
		WebElement e = waitForElementToPresent(locator, 10);
		e.click();
	}

	public boolean selectCourseCheckBoxByURL(String URL) {
		String locator = getFormatedLocator("node.course.checkbox", URL);
		WebElement e = waitForElementToPresent(locator, 10);
		e.click();
		return e.isSelected();
	}

	public void cLickCourseURL(String courseName) {
		String locator = getFormatedLocator("node.course.name", courseName);
		WebElement e = waitForElementToPresent(locator, 10);
		WaitForElementToBeClickable(e, 20);
		e.click();
	}

	public void clickUsingJavaScript(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].click();", e);
	}

	public String getCurrentTimeStamp() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// dd/MM/yyyy
		Date now = new Date();
		String strDate = sdfDate.format(now);
		return strDate;
	}

	/**
	 * This method generates random string
	 * 
	 * @return
	 */
	public String generateRandomString() {
		StringBuffer randStr = new StringBuffer();
		for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {
			int number = getRandomNumber();
			char ch = CHAR_LIST.charAt(number);
			randStr.append(ch);
		}
		return randStr.toString();
	}

	/**
	 * This method generates random numbers
	 * 
	 * @return int
	 */
	private int getRandomNumber() {
		int randomInt = 0;
		Random randomGenerator = new Random();
		randomInt = randomGenerator.nextInt(CHAR_LIST.length());
		if (randomInt - 1 == -1) {
			return randomInt;
		} else {
			return randomInt - 1;
		}
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void openAppNewTab(String nodeName) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.open()");
		openWindowHandle = getDriver().getWindowHandle();
		Set<String> handles = getDriver().getWindowHandles();
		for (String currentWindowHandle : handles) {
			if (!currentWindowHandle.equals(openWindowHandle)) {
				getDriver().switchTo().window(currentWindowHandle);
				getDriver().get(prop.getProperty(nodeName));
			}
		}
	}

	public void closeTab() {
		if (getDriver().getWindowHandles().size() > 1) {
			getDriver().close();
			getDriver().switchTo().window(openWindowHandle);
		}
	}

	public List<String> getRowRecordsFromWebTable(String fName) {
		// To locate table.
		// prop.setProperty("course.name", fName); // need to remove this
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
		}

		WebElement mytable = getDriver()
				.findElement(By.xpath("//div[@class='table-scroller']/table[@id='courses_list']"));
		waitForElementToPresent(mytable, 30);
		// To locate rows of table.
		List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
		// To calculate no of rows In table.
		int rows_count = rows_table.size();
		// Loop will execute till the last row of table.
		for (int row = 1; row < rows_count - 1; row++) {
			// To locate columns(cells) of that specific row.
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
			// To calculate no of columns(cells) In that specific row.
			// int columns_count = Columns_row.size();
			// Loop will execute till the last cell of that specific row.
			for (int column = 0; column < 2; column++) {
				// To retrieve text from that specific cell.
				String celtext = Columns_row.get(column).getText();
				if (celtext.equals(fName)) {
					List<String> rowRecords = new ArrayList<String>();
					for (WebElement e : Columns_row) {
						rowRecords.add(e.getText());
					}
					return rowRecords;
				}
			}
		}
		return null;
	}

	public List<String> getRowRecordsFromTable(String fName) {
		// To locate table.

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
		}

		WebElement mytable = getDriver().findElement(By.xpath("//table/tbody"));
		waitForElementToPresent(mytable, 30);
		// To locate rows of table.
		List<WebElement> rows_table = mytable.findElements(By.xpath("//tr"));
		// To calculate no of rows In table.
		int rows_count = rows_table.size();
		// Loop will execute till the last row of table.
		for (int row = 1; row < rows_count - 1; row++) {
			// To locate columns(cells) of that specific row.
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
			// To calculate no of columns(cells) In that specific row.
			int columns_count = Columns_row.size();
			// Loop will execute till the last cell of that specific row.
			for (int column = 0; column < columns_count; column++) {
				// To retrieve text from that specific cell.
				String celtext = Columns_row.get(column).getText();
				if (celtext.equals(fName)) {
					List<String> rowRecords = new ArrayList<String>();
					for (WebElement e : Columns_row) {
						rowRecords.add(e.getText());
					}
					return rowRecords;
				}
			}
		}
		return null;
	}

	public void selectAnOption(WebElement dropdwnElement, String visibleText) {
		waitForElementToPresent(dropdwnElement, 30);
		dropdwnElement.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Select select = new Select(dropdwnElement);
		select.selectByVisibleText(visibleText);
	}

	public void getAllOptionsFromSelect(WebElement dropdwnElement) {
		waitForElementToPresent(dropdwnElement, 30);
		Select select = new Select(dropdwnElement);
		for (WebElement strEle : select.getOptions()) {
			System.out.println("---" + strEle.getText() + "---");

		}

	}

	public boolean isOptionPresentInDropdown(WebElement dropdwnElement, String optionName) {
		waitForElementToPresent(dropdwnElement, 30);
		Select select = new Select(dropdwnElement);
		for (WebElement e : select.getOptions()) {
			if (e.getText().equals(optionName))
				return true;
		}
		return false;

	}

	public String getSelctedOption(WebElement dropdwnElement) {
		waitForElementToPresent(dropdwnElement, 20);
		Select select = new Select(dropdwnElement);
		WebElement option = select.getFirstSelectedOption();
		return option.getText();
	}

	public void handleAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void closeNotificationBar() {
		try {
			if (isElementPresentById("gcb-butterbar-close")) {
				WebElement notificationCloseIcon = driver.findElement(By.id("gcb-butterbar-close"));
				WaitForElementToBeClickable(notificationCloseIcon, 60);
				notificationCloseIcon.click();
			}
		} catch (ElementClickInterceptedException e) {
			Log.info("butter bar close before clicking...");
		}
	}

	public void datePicker(String date, String monthStatus) {

		if (monthStatus.equalsIgnoreCase("Future")) {

			driver.findElement(By.cssSelector(".yui3-u.yui3-calendarnav-nextmonth")).click();
		}

		else if (monthStatus.equalsIgnoreCase("Past")) {

			driver.findElement(By.cssSelector(".yui3-u.yui3-calendarnav-prevmonth")).click();
		}

		List<WebElement> allDates = driver.findElements(By.xpath(
				"//table//td[substring(@class,string-length(@class) - string-length('-calendar-day') +1)= '-calendar-day' or substring(@class,string-length(@class) - string-length('-calendar-day ') +1)= '-calendar-day ']"));
		for (WebElement ele : allDates) {
			String dateValue = ele.getText();
			if (dateValue.equalsIgnoreCase(date)) {
				ele.click();
				break;
			}

		}

	}

	public void openNewTab(String url) {
		String nodeURL = prop.getProperty(url);
		prop.setProperty("node.name", nodeURL);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.open()");
		openWindowHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String currentWindowHandle : handles) {
			if (!currentWindowHandle.equals(openWindowHandle)) {
				driver.switchTo().window(currentWindowHandle);
				driver.get(nodeURL);
			}
		}
	}

	public void goToApp() {
		driver.close();
		driver.switchTo().window(openWindowHandle);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {

		}
		driver.navigate().refresh();
	}

	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void clearCacheChrome() {
		driver.get(prop.getProperty("chrome.clear.cache"));
		try {
			driver.switchTo().activeElement().submit();
		} catch (Exception e) {
			driver.switchTo().activeElement().sendKeys(Keys.ENTER);
		}
		waitForElementToNotPresent(By.id("clearBrowsingDataConfirm"), 15);
	}

	public void clearChromeCache() {
		openNewTab("chrome.clear.cache");
		try {
			driver.switchTo().activeElement().submit();
		} catch (Exception e) {
			driver.switchTo().activeElement().sendKeys(Keys.ENTER);
		}
		waitForElementToNotPresent(By.id("clearBrowsingDataConfirm"), 15);
		goToApp();
	}

	public void clearChromeData() {

	}

	public boolean isElementPresent(String elementName) {
		return driver.findElements(By.xpath(getFormatedLocator("generic.link", elementName))).size() != 0;
	}

	public boolean isElementPresentById(String elementid) {
		return driver.findElements(By.id(elementid)).size() != 0;
	}

	public boolean isElementPresentByXpath(String elementXpath) {
		return driver.findElements(By.xpath(elementXpath)).size() != 0;
	}

	public boolean isElementPresentByClassname(String elementClassname) {
		return driver.findElements(By.className(elementClassname)).size() != 0;
	}

	public boolean isUserPresent(String userid) {
		return driver.findElements(By.xpath(getFormatedLocator("user.Spoclist.enrolled", userid))).size() != 0;
	}

	public void selectCheckboxByName(String labelName) {
		WebElement checkBox = driver.findElement(By.xpath(getFormatedLocator("admin.label.checkbox", labelName)));
		if (!checkBox.isSelected())
			checkBox.click();
	}

	public boolean isCheckboxSelected(String labelName) {
		WebElement checkBox = driver.findElement(By.xpath(getFormatedLocator("admin.label.checkbox", labelName)));
		return checkBox.isSelected();
	}

	public void browserBack() {
		driver.navigate().back();

	}

	public void clickUsingPartialText(String linkName) {
		WebElement element = waitForElementToPresent(By.xpath(getFormatedLocator("generic.link.dropdown", linkName)),
				20);
		WaitForElementToBeClickable(element, 10);

		element.click();
	}

	public void fillRichTextField2(String locatorId) {
		WebElement iframe = driver.findElement(By.id(locatorId));
		driver.switchTo().frame(iframe);
		driver.findElement(By.tagName("Body")).clear();
		driver.findElement(By.tagName("Body")).sendKeys("test Question");
		driver.switchTo().defaultContent();
	}

	public void fillRichTextField(String locatorId, String text) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waitForElementToPresent(By.id(locatorId), 50);
		waitForFrameToAvailableAndSwitch(By.id(locatorId), 50);
		driver.findElement(By.tagName("Body")).clear();
		driver.findElement(By.tagName("Body")).sendKeys(text);
		driver.switchTo().parentFrame();
	}

	public void fillRichTextField(WebElement iframe, String text) {
		waitForElementToPresent(iframe, 50);
		waitForFrameToAvailableAndSwitch(iframe, 50);
		WebElement body = waitForElementToPresent(By.tagName("Body"), 20);
		WaitForElementToBeClickable(body, 20);
		body.clear();
		body.sendKeys(text);
		driver.switchTo().parentFrame();
	}

	public String getValueOfRichTextField(String locatorId) {
		String actualValue = "";
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waitForFrameToAvailableAndSwitch(By.id(locatorId), 30);
		actualValue = driver.findElement(By.tagName("Body")).getText();
		driver.switchTo().defaultContent();
		return actualValue;
	}

	public String getInputFieldValueUsingJS(WebElement inputElement) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", inputElement);
	}

	public void clickOnButtonContains(String buttonName) {
		String locator = getFormatedLocator("generic.button.contains", buttonName);
		WebElement e = waitForElementToPresent(locator, 10);
		e.click();
	}

	public void clickOnLinkUsingProp(String linkProp) {
		String linkName = prop.getProperty(linkProp);
		String locator = getFormatedLocator("generic.link", linkName);
		Log.info("clicking on " + linkName + " link");
		WebElement e = waitForElementToPresent(locator, 10);
		WaitForElementToBeClickable(e, 20);
		e.click();
	}

	public byte[] getScreenshotinByte() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

	}

//	public void clickoncourse() {
//		String courseName = prop.getProperty("course.name");
//		if (courseName == null) {
//			System.out.println("SO prop giving null");
//			courseName = System.getProperty("course.name");
//		}
//		System.out.println("----" + courseName);
//		WebElement course = waitForElementToPresent(By.xpath(String.format(
//				"//a[contains(.,'%s')]/../preceding-sibling::td", courseName)),
//				120);
//		WaitForElementToBeClickable(course, 30);
//		course.click();
//	}

	public void clickoncourse() {
		String courseName = prop.getProperty("course.name");
		if (courseName == null) {
			System.out.println("prop giving null");
			courseName = System.getProperty("course.name");
		}
		System.out.println("----" + courseName);
		/**
		 * The first thing to note is that the select2 is NOT a select element. They
		 * have created an HTML snippet which behaves like a select but is actually a
		 * collection of span, ul, li and javascript. The elements for a select2 aren't
		 * associated with the select2 and visible until you open the selector. So the
		 * first step would be to click the arrow which expands the select2
		 * Once the select2 is open the elements appear in the DOM and can be interacted with!
		 */
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		driver.findElement(By.cssSelector(".select2-selection__arrow")).click();
		WebElement courseDrpdwnEle = waitForElementToPresent(By.className("select2-results"), 10);
		WebElement courseSearchFieldEle = waitForElementToPresent(By.className("select2-search__field"), 10);
		courseSearchFieldEle.sendKeys(courseName);
		List<WebElement> searchResults = driver.findElements(By.xpath("//ul[@id='select2-course_name-results']/li"));

		System.out.println("searchResults -" + searchResults.size());
		WebElement courseFromDrpdown = searchResults.get(0);
		System.out.println("searchResults  -" + searchResults.get(0).getText());
		courseFromDrpdown.click();

		WebElement courseEnteredFieldEle = waitForElementToPresent(By.className("select2-selection__rendered"), 10);
		System.out.println("Selected Course  -" + courseEnteredFieldEle.getText());

		WebElement filterButton = waitForElementToPresent(By.xpath("//div/button[@class='gcb-button gcb-icon-button']"),
				10);

		filterButton.click();

		WebElement course = waitForElementToPresent(
				By.xpath(String.format("//a[contains(.,'%s')]/../preceding-sibling::td", courseName)), 120);

		WaitForElementToBeClickable(course, 30);
		course.click();
	}

	public boolean isCoursePresentOnDashboard() {
		String courseName = prop.getProperty("course.name");
		if (courseName == null)
			courseName = System.getProperty("course.name");

		return isElementPresentByXpath(String.format("//a[contains(.,'%s')]/../preceding-sibling::td", courseName));
	}

	public void clickOnLinkByProperty(String linkName) {
		linkName = prop.getProperty(linkName);
		String locator = getFormatedLocator("generic.link", linkName);
		WebElement e = waitForElementToPresent(locator, 10);
		WaitForElementToBeClickable(e, 20);
		e.click();

	}

	public void storePageURL(String key) {
		Log.info("stroring page url to key: " + key + " as value :" + driver.getCurrentUrl());
		prop.setProperty(key, driver.getCurrentUrl());
	}

	public boolean isProd() {
		return driver.getCurrentUrl().contains("swayam.gov.in");

	}

	public void storeDebugPageURL(String key) {
		Log.info("stroring page url to key: " + key + " as value :" + driver.getCurrentUrl());
		prop.setProperty(key, "https://swayam-node1-qa.appspot.com/urlevgfs/dashboard?action=outline");

	}

	public void enterTextIntoCodeMirror(WebElement editor, String textToBeEntered) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].CodeMirror.setValue('" + textToBeEntered + "');", editor);

	}

	public void clickOnTheCourseByNameOnAdminDashboard(String courseName) {
		WebElement courseNameLink = driver.findElement(By.xpath(getFormatedLocator("course.link.name", courseName)));
		courseNameLink.click();
	}

	public void goToAdminHomePage() {
		driver.findElement(By.xpath("//h1")).click();

	}

	public void logoutFromUserSide() {
	//	driver.findElement(By.xpath("//a[@class='dropdown-toggle'][@href='#']")).click();
	//	driver.findElement(By.xpath("//a[@class='dropdown-toggle'][@href='/profile']")).click();
		driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
		clickUsingPartialText("SIGN-OUT");
	}

	public boolean isElementHavingRequiredAttritute(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (Boolean) js.executeScript("return arguments[0].required;", e);
	}

	public String getValueOfRichTextField(WebElement iframe) {
		String actualValue = "";
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waitForFrameToAvailableAndSwitch(iframe, 30);
		actualValue = driver.findElement(By.tagName("Body")).getText();
		driver.switchTo().defaultContent();
		return actualValue;
	}

}
