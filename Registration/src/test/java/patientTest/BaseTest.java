package patientTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import patient.MainPage;
import patient.Registration;


public class BaseTest {

	WebDriver driver;
	Properties prop;
	ExtentReports reports;
	ExtentTest test;
	MainPage main;
	Registration registration;
	
	@BeforeClass
	public void initBrowser(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();		
		
		propertiesFile();

		reports = new ExtentReports(System.clearProperty("user.dir")+"\\report.html",true);
		reports.addSystemInfo("Name","Zubaer"); 
		main = new MainPage(driver);
		registration = new Registration(driver); 
	}
//----------------------------------------------------------------------
	public void openBrowser(String url){
		//driver.navigate().refresh();
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);			 
	}
//---------------------------------------------------------------------
	@AfterClass
	public void closeBrowser(){
		driver.close();
	}
//----------------------------------------------------------------------
	public void openAnotherTab(String url){
		((JavascriptExecutor)driver).executeScript("window.open");
		String parent = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for(String handle : handles){
			if(!handle.equals(parent)){
				driver.switchTo().window(handle);
			}
		}
	} 
//----------------------------------------------------------------------	 
	public void propertiesFile(){
		String path = "E:\\Project-oldeclipse\\Registration\\src\\test\\resources\\utilTest\\base.properties";
						
		prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace(); 
		}
	}
//---------------------------------------------------------------------	
	public void takeScreenDuringFail() throws IOException{
		test.log(LogStatus.FAIL,  test.addScreenCapture(capture())+"message");		
	}
//--------------------------------------------------------------------
	public String capture() throws IOException{ 
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destfile = new File("src/Fail"+ System.currentTimeMillis()+".png");
		String errorfile = destfile.getAbsolutePath();
		FileUtils.copyFile(srcfile, destfile);
		return errorfile;
	}
//---------------------------------------------------------------------
}


 

















