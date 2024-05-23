package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	
	}
	
	@FindBy(xpath="//span[contains(text(),'My Account')]")
	WebElement MyAccount;
	
	@FindBy(xpath="//a[contains(text(),'Register')]")
	WebElement Register;
	
	public void clickMyAccount()
	{
		MyAccount.click();
		
	}
	public void clickonRegister()
	{
		Register.click();
	}

}
