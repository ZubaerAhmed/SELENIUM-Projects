package Test;

import org.testng.annotations.Test;

import Function.Practiceform;

public class Testform extends Testbase{
	
	@Test
	public void form() throws InterruptedException{
		
		Practiceform practice = new Practiceform(driver);
		practice
		.textbox()
		.radiobuttonmale()
		//.radiobuttonfemale()
		.linktest()
		.verifyTablepage();
		
	}

}
