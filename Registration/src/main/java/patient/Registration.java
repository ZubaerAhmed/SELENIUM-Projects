package patient;


import java.util.HashMap;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Registration extends RegistrationUtilMethods{
	
	WebDriver driver;
	WebElement e;
	public static HashMap<String, String> hash = new HashMap<String, String>();
	
	public Registration(WebDriver driver){
		this.driver = driver;
	}
	public boolean validateRegistrtion(String value){
		String actual = driver.findElement(By.cssSelector("#h12")).getText();
		String expected = value ; // "Patient";
		boolean bool = false;
		if(actual.contains(expected)){
			bool = true;
		}
		System.out.println("Registration page displayed--> "+bool); 
		return bool;
	}
	public RegistrationForm clickRegister(){
		driver.findElement(By.cssSelector("input[type='button']")).click();
		System.out.println("clicked register button");
		return new RegistrationForm(driver);
	}
	public void patientLoginSubmit(String username, String password){
		driver.findElement(By.cssSelector("#username")).sendKeys(username);
		driver.findElement(By.cssSelector("#password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='submit' ")).click();
		System.out.println("Patient portal Login done");
	}
	
	
	
	
	
	
	
	
	/*public HashMap<String, String> register(String emailUsername,String password){
		firstName("Zubaer");
		lastName("Ahmed");
		dateOfBirth();
		license();
		ssn();
		state();
		city();
		address();
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
		question();
		answer("no name");
		clickSave();
		//System.out.println(Arrays.asList(hash));
		//System.out.println(Collections.singletonList(hash));
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
		
		//Person person = new Person();
		//System.out.println("==> " + e.getAttribute("value")); 
		//person.setName(e.getAttribute("value"));
		//System.out.println(person.getName());
		//System.out.println("==>" + hash.get("firstName")); 
	}
	public static void checking(){
//		Person person = new Person();
//		String name = person.getName();
		System.out.println("==>" + hash.get("firstName")); 
//		System.out.println("==> "+name); 
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
		//e.sendKeys("13468906"); 
		//e.sendKeys(String.valueOf(createLicense()));
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
	public void address(){
		e = driver.findElement(By.cssSelector("#address"));
		e.sendKeys("396 street");
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
		hash.put("pharmacyAddress", e.getAttribute("value")); 
	}
	public void email(String name){	 
		e = driver.findElement(By.cssSelector("#email"));
		e.sendKeys(createEmail(name));
		hash.put("email", e.getAttribute("value"));
	}
	public void passWord(String pass){
		e = driver.findElement(By.cssSelector("#password"));
		e.sendKeys(pass);
		hash.put("passWord", e.getAttribute("value")); 
	}
	public void userName(String name){
		e = driver.findElement(By.cssSelector("#username"));
		e.sendKeys(createUsername(name));
		hash.put("userName", e.getAttribute("value")); 
	}
	public void confirmPassword(String confirm){
		e = driver.findElement(By.cssSelector("#confirmpassword"));
		e.sendKeys(confirm);
		hash.put("confirmPassword", e.getAttribute("value")); 
	}
	public void question(){
		Select e = new Select(driver.findElement(By.cssSelector("#security")));
		e.selectByVisibleText("what is your pet name");		
		hash.put("question", "what is your pet name"); 
	}
	public void answer(String answer){
		driver.findElement(By.cssSelector("#answer")).sendKeys(answer);
		hash.put("answer", answer); 
	}
	public void clickSave(){
		driver.findElement(By.cssSelector("input[type='submit' ")).click();
		System.out.println("Registration done and submit SAVE");
		
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		alert.accept();
		System.out.println("Patient Login--> "+text);
	}*/
	
	
}








