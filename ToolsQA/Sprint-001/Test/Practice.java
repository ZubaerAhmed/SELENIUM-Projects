package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Practice {

	
	WebDriver driver;
	@Test
	public void openbrowser() throws InterruptedException{
			
			System.setProperty("webdrivergecodriver.driver", "\\chromedriver.exe");
//			driver = new FirefoxDriver();
			
//			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://www.toolsqa.com");
			Thread.sleep(5000);
			System.out.println("----Browser open----");
			
			driver.close();
		}
	}

