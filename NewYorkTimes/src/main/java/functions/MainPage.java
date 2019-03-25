package functions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
	
	WebDriver driver;
	List<WebElement> lists;
	
	Logger LOG =  Logger.getLogger(MainPage.class); 
	public MainPage(WebDriver driver){
		this.driver = driver;
	}
//---------------------------------------
	public void clickNav(String expected) throws InterruptedException{  
		lists = driver.findElements(By.xpath("//header/div/ul/li"));
		
		System.out.println("Size--> " + lists.size()); 
		for(int i=0; i<lists.size(); i++){
			String actual = lists.get(i).getText().trim();
			if(actual.contains(expected)){ //Travel
			 LOG.info("Name of actual: "+actual);
			// System.out.println(actual);
			 
			 lists.get(i).click();//it's not working
			 
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 //Thread.sleep(5000);
 			 LOG.debug("Clicked nav"); 
			 //System.out.println("-> "+actual); 
	 		}
		}
	}  
//--------------------------------------- 
	public boolean validateNav(String expected){ 
		lists = driver.findElements(By.xpath("//header/div/ul/li"));
		boolean bool = false;
		
		for(int i=0; i<lists.size(); i++){
			String actual = lists.get(i).getText().trim();
			if(actual.contains(expected)){
			bool = true; 
			System.out.println(actual +" "+bool);
	 		}
		}
		LOG.info(expected+"--> "+bool); 
		return bool;
	}
//-----------------------------------------------------
	public boolean dateOfNewsPaper(){
		String actual = driver.findElement(By.xpath("//div[@class='css-bpgv3s ea53akk0']")).getText();
		String expected = "2019";
		boolean result = false;
		if(actual.contains(expected)){
			result = true;
			LOG.info("Name: "+actual+" --> "+result); 
			System.out.println("Name: "+actual+" --> "+result);    
		}
		return result;   
	}	
//-------------------------------------------------------	
	public void clickLink(WebElement el){
		el.click();
		LOG.info("Clicked Link");
	}
}



