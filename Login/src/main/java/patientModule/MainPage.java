package patientModule;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

	WebDriver driver;
	@FindBy(css="ul a") public WebElement nav;
	@FindBy(how=How.CSS,using="ul a") public List<WebElement> navlist; 
	@FindBy(xpath="//a[text()='Login' and @class='button button-alt']") public WebElement login;
	//@FindBy(xpath="//a[@href='portal/login.php']") public WebElement login;
	@FindBy(css="span[id='h12']") public WebElement loginvalid;
	@FindBy(name="username") public WebElement username;
	@FindBy(name="password") public WebElement password;
	@FindBy(css="input[name=submit]") public WebElement submit;
	
	public MainPage(WebDriver driver){
		PageFactory.initElements(driver, this); 
		this.driver = driver;
	}
	
//----------------------------------------------------------	
		public boolean navList2(String value){	
			List<WebElement> navlist = driver.findElements(By.cssSelector("ul a"));
			String string = null;
			boolean bool = false;
			for(int i=0; i<navlist.size(); i++){
				string = navlist.get(i).getText();
				if(string.contains(value)){				
					bool = true;
					System.out.println("Boolean--> "+bool);
				}
			}
			return bool;
		}
//------------------------------------------------------------
	public MainPage navList(String value) throws InterruptedException{  //Patient Login
		String home = nav.getText(); 
		//System.out.println("=> "+home);	
		
		List<WebElement> list = navlist; 
		System.out.println("Size nav--> "+ list.size()); 
		String string = null;
		for(int i=0; i<list.size(); i++){
			string = list.get(i).getText();
			if(string.contains(value)){			
				list.get(i).click();
				Thread.sleep(2000);
				System.out.println("clicked--> "+string);
			}
		}
		return new MainPage(driver);
	}
//-----------------------------------------------------	
	public boolean validateClickLogin(){
		String actual = login.getText();
		boolean bool = false;
		if(actual.contains("Login")){
			bool = true;
			System.out.println("validation Login page=> "+bool+"->"+actual);
		}
		return bool;		 
	}
//---------------------------------------------------
	public MainPage clickLogin() throws InterruptedException{
		login.click();
		Thread.sleep(2000);
		System.out.println("clicked Login button");
		return new MainPage(driver);		 
	}
//---------------------------------------------------	
	public PatientPortalPage enterValueForLogin() throws InterruptedException{
		username.sendKeys("ria1");
		password.sendKeys("Ria12345");
		Thread.sleep(3000);
		
		submit.click();
		System.out.println("submitted");
		return new PatientPortalPage(driver);
	}
} 













