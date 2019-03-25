package Element;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Function.Pagebase;

public class ButtonElements extends Pagebase{
	
	WebDriver driver;
	static WebElement element;
	static List list;
	
	
	public ButtonElements(WebDriver driver){
		super(driver);
	}
	
	public static WebElement elements(WebDriver driver, String name){
		switch (name){
		case "home":
			element = driver.findElement(By.xpath("//nav/ul/li[1]/a/span/span"));
			return element;
		case "val-url":
			element = driver.findElement(By.xpath("//nav/ul/li[1]/a"));
		
		}
		return element; 
		
	}
	public static List lists(WebDriver driver, String name){
		switch(name){
		case "nav":
			list = driver.findElements(By.xpath("//nav"));
			return list;
		}
			
		return list;
	}
}
//   nav/ul/li[2]/a/span/span
//   .navigation > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)

