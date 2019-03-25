package patientTests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import adminTests.BaseTest;

public class PatientRegistrationTest extends BaseTest{

	@BeforeClass
	public void openWithUrl(){
		openurl("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/");
	}
	
	@Test(priority=1, description="TC_001, Validate Patient-Login Button")
	public void validatePatientButton(){ 
		boolean bool = mainpage.PatientLoginButton("Patient Login");
		Assert.assertTrue(bool, "Patient Login Button Not present"); 
	}
	
	@Test(priority=2, description="TC_002, Validate registration button")
	public void validateRegistrationButton(){
		
		System.out.println("working");
	}
}
