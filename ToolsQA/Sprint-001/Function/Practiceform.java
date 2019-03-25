package Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Practiceform extends Pagebase{
	
	public Practiceform(WebDriver driver){
		super(driver);
	}

	public Practiceform textbox() throws InterruptedException{
		driver.findElement(By.cssSelector("input[name=firstname]")).sendKeys("Zubaer");
		driver.findElement(By.cssSelector("[name=lastname")).sendKeys("Ahmed");
		Thread.sleep(5000);
		System.out.println("----Textbox filled");
		return new Practiceform(driver);
	}
	
	public LinktestTable linktest() throws InterruptedException{
		driver.findElement(By.cssSelector("div>a>strong")).click();
		Thread.sleep(5000);
		System.out.println("clicked"); 	
		return new LinktestTable(driver);
	}
	
	public Practiceform radiobuttonmale(){
		WebElement radiomale = driver.findElement(By.cssSelector("input[name='sex'][value='Male']"));
		WebElement radiofemale = driver.findElement(By.cssSelector("input[name='sex'][value='Male']"));

		clicked(radiomale);
		radioverification(radiomale, "Male");
		radioverification(radiofemale, "Female");
		
		return new Practiceform(driver);
	}
	
	public Practiceform radiobuttonfemale(){
		WebElement radiomale = driver.findElement(By.cssSelector("input[name='sex'][value='Male']"));
		WebElement radiofemale = driver.findElement(By.cssSelector("input[name='sex'][value='Male']"));

		clicked(radiofemale);
		radioverification(radiofemale, "Female");
		radioverification(radiomale, "Male");
		
		return new Practiceform(driver);
	}
	
	public void clicked(WebElement radio){
		radio.click();
		System.out.println("Radio button Clicked-->"); 
	}
	
	public void radioverification(WebElement radio, String sex){
		boolean x = radio.isDisplayed();
		System.out.println(sex +" radio button Displayed-->"+ x);
		boolean y = radio.isEnabled();
		System.out.println(sex +" radio button Enabled-->"+ y);
		boolean z = radio.isSelected();
		System.out.println(sex +" radio button Selected-->"+ z);
	}
} 


 






 