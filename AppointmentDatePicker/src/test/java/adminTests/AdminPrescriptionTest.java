package adminTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class AdminPrescriptionTest extends BaseTest {

	 @BeforeClass
	 public void beforeClass() throws InterruptedException {
	 //get url in browser from property file
	 driver.get(prop.getProperty("admin_url"));
	 Thread.sleep(4000);
	 }
 
	@Test(priority = 1,enabled=false, dataProvider="importDataFromExcel", description ="TC_001, practice data provider")
	public void practice(String a, String b) {
		System.out.println(a + " \n "+b);
	}
	@Test(priority = 1, enabled=true, description = "TC_001, verify admin login")
	// dataProvider="data"
	public void adminLoginPage() throws InterruptedException {
		boolean bool = login.adminLogin("Kevin_001", "Kevin_002")
				.verifyAdminLogin("Admin");
		Assert.assertTrue(bool, "Login not successful");
	}

	@Test(priority = 2, enabled=false, description = "TC_002, write prescription in admin module")
	public void prescriptionPageTest() {
		home.clickPatient().patientsNameClick().clickAddPrescription()
				.prescriptionDetails();
	}

	@Test(priority = 3, enabled = false, description = "verify prescription in patient module")
	public void verifyPrescription() {
		System.out.println("NO CODE WRITTEN");
	}

	@AfterClass
	public void afterClass() {
	}

}
