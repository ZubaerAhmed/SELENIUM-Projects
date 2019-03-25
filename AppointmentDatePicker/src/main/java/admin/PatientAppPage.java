package admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class PatientAppPage {

	WebDriver driver;
	public PatientAppPage(WebDriver driver){
		this.driver = driver;
	}
	
	public PrescriptionPage clickAddPrescription(){
		driver.findElement(By.xpath("//p[2]/a/input")).click();
		System.out.println("clicked 'Add Prescription' button");
		Reporter.log("clicked 'Add Prescription' button");
		return new PrescriptionPage(driver);
	}
}
