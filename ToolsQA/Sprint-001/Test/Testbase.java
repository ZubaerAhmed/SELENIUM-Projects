package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Function.Button;

public class Testbase {
	
	WebDriver driver;
	Button button; 

	@BeforeMethod
	public void openbrowser(){
		driver = new FirefoxDriver();
		driver.get("https://www.toolsqa.com/automation-practice-form/");
		
		System.out.println("------Toolsqa open in browser-----");
		button = new Button(driver);	
	}
	
/*	@Parameters({"url","title"})
	@BeforeMethod
	public void verifyTitle(String url,String title)
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new FirefoxDriver();
		driver.get(url);
		String actual = driver.getTitle();
		String expected=title;
		Assert.assertEquals(actual,expected); 
		
		System.out.println(url + " -->open in browser");
		button = new Button(driver);
	}
*/
	@AfterMethod
	public void quitbrowser(){
		driver.quit();
	}
}
 