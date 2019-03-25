package Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Withmain {

	static WebDriver driver;

	public static void main(String[] args) {
		driver = new FirefoxDriver();
		driver.get("https://www.toolsqa.com/automation-practice-form/");
		
		Withmain w = new Withmain();
		w.getAllValueButton();
		driver.quit();
	}
 
	public void getAllValueButton() {

		List<WebElement> list2 = driver.findElements(By.xpath("//nav/ul/li"));
		List<WebElement> list = driver.findElements(By.cssSelector("nav ul li"));

		System.out.println("   size is with xpath: " + list2.size());
		System.out.println("   size is with cssSelector: " + list.size()); 

		 for(WebElement web : list2){ 
		 System.out.println( web.getText() );
		 }	
	}
}
