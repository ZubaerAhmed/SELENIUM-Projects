package patientModule;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PatientPortalPage {
	
	WebDriver driver;
	
	public PatientPortalPage(WebDriver driver){
		this.driver = driver;
	}
	
	public boolean validatePatientTable(String value) throws InterruptedException{	
		//Thread.sleep(3000);
		List<WebElement> list = driver.findElements(By.cssSelector("tr > th"));
		boolean bool = false;
		for(int i=0; i<list.size(); i++){
			String actual = list.get(i).getText();
			if(actual.contains(value)){
				//System.out.println(list.get(i).getText()); 
				bool = true;
			}	
		}
		return bool; 
	}
  
}
