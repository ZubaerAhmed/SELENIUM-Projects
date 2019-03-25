package admin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PatientsPage {

	WebDriver driver;
	
	public PatientsPage(WebDriver driver){
		this.driver = driver;
	}
	
	public PatientAppPage patientsNameClick(){
		driver.findElement(By.cssSelector(".tftextinput")).sendKeys("ria");
		driver.findElement(By.cssSelector(".tfbutton")).click();
		
		//Added implicit wait because it needed time for the search to bring out the list
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//This worked after adding the implicit wait.
		driver.findElement(By.xpath(".//*[@id='show']//a[contains(text(),'Ria')]")).click();	
		System.out.println("Patient name clicked");
		return new PatientAppPage(driver);
	}
}



