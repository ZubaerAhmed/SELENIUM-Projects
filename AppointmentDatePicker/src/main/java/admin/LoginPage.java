package admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		
	}
	
	public LoginPage adminLogin(String username, String password) throws InterruptedException{

		driver.findElement(By.cssSelector("#username")).sendKeys(username);
		driver.findElement(By.cssSelector("#password")).sendKeys(password);
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("input[name='admin'] ")).click();		 
		System.out.println("Login done");
		Reporter.log("Login done");  		
		return new LoginPage(driver);
	} 
	
	public boolean verifyAdminLogin(String name){
		//For the Admin title, use the xpath contain text
//		WebElement title = driver.findElement(By.xpath("//h1[contains(text(),'Admin Login')]"));
//		System.out.println(title.getText());
		String actual = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText();
		System.out.println(actual); 
		String modified = actual.substring(0, 12);
		System.out.println("value is===>"+ modified);
		
		String expected = name;  //	Admin 
		boolean bool = actual.contains(expected);
		return bool;
	}
}



