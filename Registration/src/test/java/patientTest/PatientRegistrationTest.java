package patientTest;


import org.testng.annotations.Test;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class PatientRegistrationTest extends BaseTest{

	
	@BeforeClass
	public void open_with_url(){
		openBrowser(prop.getProperty("urlPatient"));  
	}	 
	
	@Test(priority=1,enabled=true, description="TC_001, Validate Patient-Login Button")
	public void validate_patient_login(){ 
		boolean bool = main.validateNav("Patient Login"); 
		AssertJUnit.assertTrue("Patient Login Button Not present", bool); 
	}
	
	@Test(priority=2,enabled=true, description="TC_002, Validate registration page")
	public void click_patient_login() throws InterruptedException{ 
		main.clickPatientLogin("Patient Login")
				.clickLogin();
//				.validateRegistrtion("Patient");
//		AssertJUnit.assertTrue("Registration page displayed", bool);
	}
	
	@Parameters({"username", "password" })
	@Test(priority=3,enabled=false, description="TC_003, Validation write registration form")
	public void writeRegistration(String username, String password){
		registration
		.clickRegister()
		.register(username,password); 

	} 

}
 