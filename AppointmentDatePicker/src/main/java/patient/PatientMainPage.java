package patient;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class PatientMainPage {
	
	WebDriver driver;

	public PatientMainPage(WebDriver driver){
		this.driver = driver;
	}
	
	public boolean PatientLoginButton(String value){
		boolean result = false; 
		//List<WebElement> menubar = driver.findElements(By.xpath("//ul[@id='navigation']//a"));
		//	By.cssSelector("ul[id='navigation'] a")
		List<WebElement> menubar = driver.findElements(By.cssSelector("ul a"));
		System.out.println("Navbar Size--> " + menubar.size()); 

		for(int i=0; i<menubar.size(); i++){
			if((menubar.get(i).getText()).contains(value)){
				result = true;
			}	
		}
		System.out.println(value +" present --> " + result);
		Reporter.log(value +" present --> " + result); 
		return result;
	}
	

	
}







