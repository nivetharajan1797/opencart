package com.swayam.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {
	static WebDriver driver;

	public static WebDriver getDriver(String browserName) {
		browserName = browserName.toUpperCase();
		switch (browserName) {
		case "CHROME":
			// System.setProperty("webdriver.chrome.logfile",
			// "./log/chromedriver.log");
			System.setProperty("webdriver.chrome.driver",
					"./resources/drivers/chromedriver.exe");
			System.setProperty("webdriver.chrome.args", "--disable-logging");
			System.setProperty("webdriver.chrome.silentOutput", "true");
			/*
			 * ChromeOptions options = new ChromeOptions();
			 * options.addArguments("headless");
			 * options.addArguments("window-size=1200x600");
			 */
			driver = new ChromeDriver();
			break;
		case "FIREFOX":
			System.setProperty("webdriver.gecko.driver",
					"./resources/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "EDGE":
			System.setProperty("webdriver.edge.driver",
					"./resources/drivers/MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			break;

		case "REMOTE":

			URL url = null;
			try {
				url = new URL("http://localhost:4444/wd/hub");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless");
			chromeOptions.addArguments("--disable-gpu");
			chromeOptions.addArguments("--window-size=1280,1024");
			
			//Added by Shrirang on 29-Jun-2020 to avoid timeout on node1 login page after 300 seconds 
			
		//	chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
			
			//Change completed
			
			DesiredCapabilities desiredCapabilities = DesiredCapabilities
					.chrome();
			desiredCapabilities.setCapability(ChromeOptions.CAPABILITY,
					chromeOptions);
			driver = new RemoteWebDriver(url, desiredCapabilities);

		default:
			break;

		case "IE":
			System.setProperty("webdriver.edge.driver",
					"./resources/drivers/MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			break;

		}
		return driver;
	}
}
