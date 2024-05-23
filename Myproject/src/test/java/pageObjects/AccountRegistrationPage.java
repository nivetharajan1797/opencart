package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement FirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement LastName;

	@FindBy(xpath="//input[@id='input-email']")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement phone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement Password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement ConfirmPassword;
	
	@FindBy(xpath="//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]")
	WebElement Privacypolicy;
	
	@FindBy(xpath="//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[2]")
	WebElement Continue;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
		
//	
//	@FindBy(xpath="")
//	WebElement 
    
	public void setfirstName(String fname)
	{
		FirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		LastName.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		Email.sendKeys(email);
	}
	public void setphone(String tel)
	{
		phone.sendKeys(tel);
	}
	public void setPassword(String pwd)
	{
		Password.sendKeys(pwd);
	}
	public void setConfirmPassword(String cpwd)
	{
		ConfirmPassword.sendKeys(cpwd);
	}
	public void privacyPolicy()
	{
		Privacypolicy.click();
	}
	public void btncontinue()
	{
		Continue.click();
	}
	public String confirmMessage()
	{
		try {
			return(msgConfirmation.getText());
		}
		catch(Exception e){
			return(e.getMessage());
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
}
