package functions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checking {

	static WebDriver driver;
	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.get("https://www.webmd.com/"); 
		driver.findElement(By.xpath("//*[@id='webmdHoverClose']")).click();
		System.out.println("browser open");
		
//		Alert alert = driver.switchTo().alert();
//		System.out.println(alert.getText());  
//		alert.dismiss();
		
		driver.close(); 
		System.out.println("browser close");
	} 

}
