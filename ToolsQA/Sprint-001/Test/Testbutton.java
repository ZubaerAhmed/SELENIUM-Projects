package Test;

import org.testng.annotations.Test;

public class Testbutton extends Testbase{

	
	@Test(priority=1,description="Open Toolsqa and list for links in Navbar")
	public void toolsqa(){	
		button
		.getValueButton()
		.getattribute()     // get attribute for href of 'HOME'
		.linkOfNavbar()
		.clickbutton();     //list for links 
	}


	@Test(priority=2,description="Print NAVBAR text")
	public void navbarSize(){
		button
		.getAllValueButton();//list of NAVBAR "

	}
}
