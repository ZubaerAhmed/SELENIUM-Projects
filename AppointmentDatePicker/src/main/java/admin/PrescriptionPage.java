package admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PrescriptionPage {

	WebDriver driver;
	public PrescriptionPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void prescriptionDetails(){
		WebElement element = driver.findElement(By.cssSelector("#app_date"));
		Select select = new Select(element);
		select.selectByValue("1816");
		driver.findElement(By.cssSelector("#exampleInputcardnumber1")).sendKeys("Ria");
		driver.findElement(By.cssSelector(".form-control")).sendKeys("Two Aspirin tablet during headache");
		
		//driver.findElement(By.cssSelector(" form > input[type='submit']")).click();
		driver.findElement(By.xpath("//form/input")).click();
		System.out.println("prescription submitted");
		String message = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println("Message: "+message);
	}
}





//