package patientModuleTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;


public class MainPageTest extends Base_2_Test{
	
	patientModule.PatientPortalPage portal;
	
	@BeforeClass
	public void report(){
		//driver.get(prop.getProperty("urlPatient"));
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/");
		test = reports.startTest("RegistrationPageTest"); 
		portal = new patientModule.PatientPortalPage(driver);
	}
	@Test(priority=1,description="TC_001")
	public void validatePatientLogin(){
		System.out.println("validate: Patient-login button");
		Assert.assertTrue("Not working",main.navList2("Patient Login"));
	}
	
	@Test(priority=2,description="TC_002,click patient-login")
	public void clickPatientLogin() throws InterruptedException{	
		main.navList("Patient Login"); 
		} 
	
	@Test(priority=3,description="TC_003, validate LOGIN button")
	public void validatelogin() {
		Assert.assertTrue("Not LOGIN", main.validateClickLogin()); 
	}
	 
	@Test(priority=4,description="004, click login and enter credintial")
	public void clickLoginAndEnterData() throws InterruptedException{
		main.clickLogin();
		main.enterValueForLogin();
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(portal.validatePatientTable("Date"),"Date not displayed");
		sa.assertTrue(portal.validatePatientTable("Time"),"Time not displayed");
		sa.assertTrue(portal.validatePatientTable("Appointment"),"Appointment not displayed");
		sa.assertTrue(portal.validatePatientTable("Doctor"),"Doctor not displayed");
		sa.assertAll();
		System.out.println("Table displayed--> " + portal.validatePatientTable("Date"));
	}
	 
	@AfterMethod
	public void reportClose(){ 
		reports.endTest(test);
		reports.flush();
	} 
}
