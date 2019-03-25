package functions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Nav_Droplist {
	
	WebDriver driver;
	WebElement element;
	Logger LOG =  Logger.getLogger(Nav_Droplist.class);  
	
//-------------------------------------------------------
	public Nav_Droplist(WebDriver driver){
		this.driver = driver;
	}
//-------------------------------------------------------	
	public WebElement linkOfNavbar(String expected){
		List<WebElement> list = driver.findElements(By.xpath("//li[@class='global-nav-links-link']"));
		int size = list.size();
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		for(int i=0; i<size; i++){
			String actual = list.get(i).getText().trim();
			if(actual.contains(expected)){
			element = list.get(i);
			}
		}
		return element; 
	}	 
//---------------------------------------------------------
	public Nav_Droplist getNameFromNav(String expected){  // HEALTH
		String name = linkOfNavbar(expected).getText().trim();
		LOG.info("\n"+expected+" displayed as expected");
		return new Nav_Droplist(driver); 
	}
//---------------------------------------------------------
	public boolean validationNameFronNav(String expected){  //  HEALTH
		boolean result = false;
		String actual = linkOfNavbar(expected).getText().trim(); 
		if(actual.contains(expected)){
			result = true;
		}
		LOG.info("\n"+expected+" is--> "+result); 
		return result;
	}
	
//---------------expected-"HEALTH", expected2-"Allergies"-----------------
	public void dropDownListFromNav_Health(String expected,String expected2){
		List<WebElement> list = driver.findElements(By.xpath("//li[@class='global-nav-links-link']"));
		int size = list.size();

		for(int i=0; i<size; i++){
			String actual = list.get(i).getText().trim();
			//LOG.info(list.get(i).getText()); 
			if(actual.contains(expected)){
		 
			WebElement dropdown = list.get(i);
			//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			List<WebElement> options = dropdown.findElements(By.xpath("//li/a"));
			for(int j=0; j<options.size(); j++){
				String actual2 = options.get(j).getText();
				if(actual2.contains(expected2)){
					LOG.info("\n"+actual2+" <--is displayed as expected"); 
					break; 
				} 
			}//for loop
			}//if 
		}//for loop	
	}//method
//--------------------------------------------------------------


} //end of class
