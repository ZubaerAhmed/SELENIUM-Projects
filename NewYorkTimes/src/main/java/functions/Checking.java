package functions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checking {

	static WebDriver driver;
	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.get("https://www.washingtonpost.com/?noredirect=on"); 
		
		List<WebElement> lists = driver.findElements(By.xpath("//ul[@class='inline-list thin-style ad-none']/li"));
				
		for(int i=0; i<lists.size(); i++){
			String expected = "Fox News";
			String actual = lists.get(i).getText().trim();
			if(actual.contains(expected)){
				System.out.println(actual);
				lists.get(i).click();
				System.out.println("-> Clicked");
				System.out.println("-> "+actual); 
	 		}
		}
		
		driver.quit(); 
	} 

}
