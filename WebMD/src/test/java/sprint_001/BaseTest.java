package sprint_001;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import functions.Nav_Droplist;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {

	public WebDriver driver;
	Properties prop;
	Nav_Droplist nav;
	Logger LOG =  Logger.getLogger(BaseTest.class);  
	
	
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
		PropertyConfigurator.configure("log4j.properties");
		
		nav = new Nav_Droplist(driver); 
	}
//-----------------------------------------------
	public void openBrowser(String url){
		driver.get(url); 
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='webmdHoverClose']")).click();  
		LOG.info("\nbrowser open properly with url--> "+url.substring(8,21)); // https://www.webmd.com/
	}
//-----------------------------------------------
	@AfterClass
	public void closeBrowser() throws InterruptedException{
		Thread.sleep(2000); 
		driver.close(); 
		LOG.info("\nbrowser close properly ");
	}
//------------------------------------------------
	public void propertiesFile() throws IOException{
		String path = "E:\\Project-oldeclipse\\WebMD\\src\\test\\resources\\utilities\\browser.properties";
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis); 
	} 
//-------------------------------------------------
	public void popup(){
		Alert alert = driver.switchTo().alert();
		LOG.info(alert.getText()); 
		alert.dismiss();
	}
}
