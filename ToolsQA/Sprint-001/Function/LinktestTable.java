package Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LinktestTable extends Pagebase{
	
	public LinktestTable(WebDriver driver){
		super(driver);
	}
	
	
	public LinktestTable verifyTablepage(){
		//driver.findElement(By.cssSelector("div>a>strong")).click();
		//String text = driver.findElement(By.cssSelector("#page > div[4] > div >div[1] > h1")).getText();
		
		String text = driver.findElement(By.xpath("//*[@id='page']/div[4]/div/div[1]/h1")).getText();
		System.out.println(text); 
		
		return new LinktestTable(driver); 
	}

}
