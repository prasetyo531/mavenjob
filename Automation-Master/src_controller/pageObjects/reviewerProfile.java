package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class reviewerProfile {
	
public static RemoteWebDriver driver=null;
	
	By catBalm=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-left > div.jsx-17482050.filter-category-desktop > a:nth-child(3)");
	
	
	public reviewerProfile(RemoteWebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
	
	public WebElement clickFootCream(){
		
		return driver.findElement(catBalm);
	}

}
