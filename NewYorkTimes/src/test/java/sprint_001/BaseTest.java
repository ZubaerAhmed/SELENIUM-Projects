package sprint_001;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import functions.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {

	WebDriver driver;
	Properties prop;
	MainPage main;
	
	@BeforeClass 
	public WebDriver driver() throws IOException{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		initialization();
		return driver;
	}
//----------------------------------------------- 
	public void initialization() throws IOException{  
		propertiesFile();
		main = new MainPage(driver);
		PropertyConfigurator.configure("log4j.properties");
	}
//-----------------------------------------------
	public void openBrowser(String url){
		driver.get(url); 
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	}
//-----------------------------------------------
	@AfterClass
	public void closeBrowser() throws InterruptedException{
		Thread.sleep(2000); 
		driver.close(); 
	}
//------------------------------------------------
	public void propertiesFile() throws IOException{
		String path = "E:\\Project-oldeclipse\\NewYorkTimes\\src\\test\\resources\\utilities\\browser.properties";
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis); 
	} 
}
