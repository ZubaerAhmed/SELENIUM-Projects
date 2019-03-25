package admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
	}
	
	public PatientsPage clickPatient(){
		driver.findElement(By.xpath("//ul/li[5]/a/span")).click();
		System.out.println("Clicked Patient button");
		return new PatientsPage(driver);
	}
	
	

}

