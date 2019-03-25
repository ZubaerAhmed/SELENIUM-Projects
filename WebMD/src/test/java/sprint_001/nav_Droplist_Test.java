package sprint_001;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class nav_Droplist_Test extends BaseTest{
	
	@BeforeClass
	public void openBrowser(){ 
		openBrowser(prop.getProperty("url_webmd"));

	}
	@Test(priority=1)
	public void validate_navbar_home(){
		Assert.assertTrue(nav.getNameFromNav("HEALTH")
							.validationNameFronNav("HEALTH"));
	}
	@Test(priority=2)
	public void listOfNav_webMD(){ 
		nav.dropDownListFromNav_Health("HEALTH","Allergies"); 
	}
	

	

}
