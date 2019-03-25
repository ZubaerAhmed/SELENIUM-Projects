package Function;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Element.ButtonElements;

public class Button extends Pagebase{

	public Button(WebDriver driver){
		super(driver);
	}
	
	public Button clickbutton(){
		ButtonElements.elements(driver, "home").click();
		System.out.println("----click home button");
		return new Button(driver);
	}
//====================================================
/*	public int buttonsize(){
		int count = 0;
		for(int i=1; i<100; i++){
				String web = driver.findElement(By.xpath("//nav/ul/li["+i+"]/a/span/span")).getText();
				count=count + 1; 
				if(web==null){
					System.out.println("size of Navbar is: "+count);
					//return count;
				}
		}	
		return count;
	}*/
//======================================================================	
	public Button linkOfNavbar(){
		List<WebElement> list = driver.findElements(By.xpath("//nav/ul/li"));
		int size = list.size();
		for(int i=1; i<=size; i++){
				String link = driver.findElement(By.xpath("//nav/ul/li["+i+"]/a")).getAttribute("href");
				if(link==null){
					link = "--> This is Dropdown";
				}
				System.out.println(i + " : " + link);
		}
		return new Button(driver); 
	}	 
//======================================================================
	public Button getAllValueButton(){	

		List<WebElement> list2 = driver.findElements(By.xpath("//nav/ul/li"));
		List<WebElement> list = driver.findElements(By.cssSelector("nav ul li"));

		System.out.println("   size is with xpath: " + list2.size());
		System.out.println("   size is with cssSelector: " + list.size()); 

		 for(WebElement web : list2){ 
		 System.out.println( web.getText() );
		 }
		 
		return new Button(driver); 
	}
//=======================================================================
	
	public Button getValueButton(){
		String homeText = ButtonElements.elements(driver, "home").getText();
		System.out.println("   Text is " + homeText);
		return new Button(driver);
	}
	
	public Button getattribute(){
		String attri = driver.findElement(By.xpath("//nav/ul/li[1]/a")).getAttribute("href");
		//String attri = driver.findElement(By.tagName("a"));
		System.out.println("Link for HOME is: " + attri); 
		return new Button(driver);
	}
//======================================================================
	
/*	public Button linkworking(){
	List<WebElement> allLinks = driver.findElements(By.tagName("a"));
    for (WebElement w : allLinks)
    {
        w.click();
        if (driver.findElement(By.xpath("Element on the page")).isDisplayed())
        {
            System.out.println("Link:"+w.getText()+"is working");
        }
        else
        {
            System.out.println("Link:"+w.getText()+"is not working");
        }
        driver.navigate().back();//To come back to the Home screen
    }
    return new Button(driver);
    }*/
}

 
//html/body/div[1]/div[1]/header/nav/ul/li[1]/a/span/span

//html/body/div[1]/div[1]/header/nav/ul/li[2]/a/span/span






