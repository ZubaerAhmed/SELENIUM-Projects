package sprint_001;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class navTest extends BaseTest{
	
	@BeforeClass
	public void openBrowser(){
		openBrowser(prop.getProperty("url"));
	}
	
	@Test(priority=1)
	public void validate_date_newYorkTimes(){
		Assert.assertTrue(main.dateOfNewsPaper()); 
	}
	
	@Test(priority=2)
	public void validate_nav_Travel() { 
		Assert.assertTrue(main.validateNav("Travel"));  
	}
	
	@Test(priority=3,enabled=true)
	public void clicking_nav_Travel()throws Exception{
		main.clickNav("Travel"); 
	}
	
	//This is news paper. this link will FAIL tomorrow
	@Test(priority=5,enabled=false)
	public void validate_link_byTrain(){
		//main.clickLink(el); 
	}
	
 
}
