package adminTests;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import patient.PatientMainPage;
import admin.HomePage;
import admin.LoginPage;
import admin.PatientAppPage;
import admin.PatientsPage;
import admin.PrescriptionPage;
import util.ExcelUtil;

public class BaseTest {

	protected WebDriver driver;
	Properties prop = new Properties();
	LoginPage login;
	HomePage home;
	PatientsPage patient;
	PatientAppPage patientApp;
	PrescriptionPage prescription;
	protected PatientMainPage mainpage;

	@BeforeClass
	public void openbrowser() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		
		adminProperties();
		login = new LoginPage(driver);
		home = new HomePage(driver);
		patient = new PatientsPage(driver);
		patientApp = new PatientAppPage(driver);
		prescription = new PrescriptionPage(driver);
		mainpage = new PatientMainPage(driver);
	}

	public void openurl(String url){
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
	}
	
	@AfterClass
	public void closebrowser() {
		driver.close();
	}
	
	public void adminProperties() throws IOException {
		String path = "E:/Project LUNA eclipse/Project/assignment_02_17/src/test/resources/admin.properties";
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
	}

	@DataProvider
	public Object[][] getData() {
	//https://examples.javacodegeeks.com/enterprise-java/testng/testng-dataprovider-example/
		return new Object[][] { { 5, "five" }, { 6, "six" } };
	}

	 @DataProvider//(name="dat")
	 public Object[][] importDataFromExcel() throws IOException {
	 Object[][] data = ExcelUtil.readExcel();
	 return data;
	 }

}
