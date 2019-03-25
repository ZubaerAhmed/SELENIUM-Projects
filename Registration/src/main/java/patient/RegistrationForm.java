package patient;


import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationForm extends RegistrationUtilMethods{
	
	WebDriver driver;
	WebElement e;
	public HashMap<String, String> hash = new HashMap<String, String>(); 

	public RegistrationForm(WebDriver driver){
		this.driver = driver;
	}

	public HashMap<String, String> register(String emailUsername,String password){

		firstName(emailUsername);
		lastName("Ahmed");
		dateOfBirth();
		license();
		ssn();
		state();
		city();
		address("396 street"); 
		
		zipcode();
		age();
		height();
		weight();
		pharmacy("CVS");
		pharmacyAddress("USA");		
		email(emailUsername);
		passWord(password);
		
		userName(emailUsername);
		
		confirmPassword(password);
		question("what is your pet name" );
		answer("no name");
		clickSave();

		System.out.println("\n===Registration Form Details========");
		for (Object objectName : hash.keySet()) {
			   System.out.println(objectName+"--> "+hash.get(objectName));
			 }
		System.out.println();
		System.out.println();
		return hash;
	}
	
	public void firstName(String name){
		e = driver.findElement(By.cssSelector("#firstname"));
		e.sendKeys(randomNameWithParameter(name));
		hash.put("firstName", e.getAttribute("value"));
	}
	public void lastName(String name){
		e = driver.findElement(By.cssSelector("#lastname"));
		e.sendKeys(randomNameWithParameter(name));
		hash.put("lastName", e.getAttribute("value")); 
	}
	public void dateOfBirth(){
		e = driver.findElement(By.cssSelector("#datepicker"));
		e.sendKeys(createRandomDOB(1970, 1995));
		hash.put("dateOfBirth", e.getAttribute("value")); 
	}
	public void license(){
		e = driver.findElement(By.cssSelector("#license"));
		e.sendKeys(createLicense());
		hash.put("license", e.getAttribute("value")); 
	}
	public void ssn(){
		e = driver.findElement(By.cssSelector("#ssn"));
		e.sendKeys(createRandomSSN());
		hash.put("ssn", e.getAttribute("value")); 
	}
	public void state(){
		e = driver.findElement(By.cssSelector("#state"));
		e.sendKeys(createState());
		hash.put("state", e.getAttribute("value")); 
	}
	public void city(){
		e = driver.findElement(By.cssSelector("#city"));
		e.sendKeys(createCity());
		hash.put("city", e.getAttribute("value")); 
		}
	public void address(String address){
		e = driver.findElement(By.cssSelector("#address"));
		e.sendKeys(address);
		hash.put("address", e.getAttribute("value")); 
	}
	public void zipcode(){
		e = driver.findElement(By.cssSelector("#zipcode"));
		e.sendKeys(randomIntString(10000,99999));
		hash.put("zipcode", e.getAttribute("value")); 
		}
	public void age(){
		e = driver.findElement(By.cssSelector("#age"));
		e.sendKeys(randomIntString(20,45));
		hash.put("age", e.getAttribute("value")); 
	}
	public void height(){
		e = driver.findElement(By.cssSelector("#height"));
		e.sendKeys(randomIntString(150, 180));
		hash.put("height", e.getAttribute("value")); 
	}
	public void weight(){
		e = driver.findElement(By.cssSelector("#weight"));
		e.sendKeys(randomIntString(45, 70));
		hash.put("weight", e.getAttribute("value")); 
	}
	public void pharmacy(String pharmacy){
		e = driver.findElement(By.cssSelector("#pharmacy"));
		e.sendKeys(pharmacy);
		hash.put("pharmacy", e.getAttribute("value")); 
	}
	public void pharmacyAddress(String pharma_adress){
		e = driver.findElement(By.cssSelector("#pharma_adress"));
		e.sendKeys(pharma_adress);
		hash.put("pharma_adress", e.getAttribute("value")); 
	}
	public void email(String email){	 
		e = driver.findElement(By.cssSelector("#email"));
		e.sendKeys(createEmail(email));
		hash.put("email", e.getAttribute("value"));  
	}
	public void passWord(String pass){
		e = driver.findElement(By.cssSelector("#password"));
		e.sendKeys(pass);
		hash.put("passWord", e.getAttribute("value")); 
	}
	public void userName(String username){
		e = driver.findElement(By.cssSelector("#username"));
		e.sendKeys(createUsername(username));
		hash.put("userName", e.getAttribute("value")); 
	}
	public void confirmPassword(String confirm){
		e = driver.findElement(By.cssSelector("#confirmpassword"));
		e.sendKeys(confirm);
		hash.put("confirmPassword", e.getAttribute("value")); 
	}
	public void question(String question){
		Select e = new Select(driver.findElement(By.cssSelector("#security")));
		e.selectByVisibleText(question);		
		hash.put("question", question); 
	}
	public void answer(String answer){
		driver.findElement(By.cssSelector("#answer")).sendKeys(answer);
		hash.put("answer", answer); 
	}
	
	public void clickSave(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		driver.findElement(By.cssSelector("input[type='submit' ")).click();
		System.out.println("Registration done and submit SAVE");
	}
	
	public boolean allertPopup(){
		Alert alert = driver.switchTo().alert();
		String actual = alert.getText();
		System.out.println("Alert message--> "+actual);
		String expected = "Thank you for registering";
		alert.accept();
		boolean bool = false;
		if(actual.contains(expected)){
			bool = true;
		}
		System.out.println("Alert excepted with OK");
		return bool;
	}
}









