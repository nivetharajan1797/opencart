package day1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class day2 extends day1{

	@Test
	void search()
	{
		
		driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active']")).sendKeys("Leave");
		driver.findElement(By.xpath("//*[@class='oxd-icon oxd-menu-icon']")).click();
;			
	}
	void AdvanceSearch()
	{
		driver.findElement(By.xpath("//*[@class='oxd-text oxd-text--span oxd-main-menu-item--name']")).click();

	}
	
	
}
