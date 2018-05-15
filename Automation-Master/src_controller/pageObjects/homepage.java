package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class homepage {
	
	public RemoteWebDriver driver=null;
	
	By joinletter=By.cssSelector("body > div:nth-child(6) > div > div > div.jsx-3828308350.modal-join-content-right > p:nth-child(3) > a");
	By pointaddproduct=By.cssSelector("#__next > div > div > div.jsx-550002916.gbheader > div.jsx-550002916.gbheader-right > div.gbheader-add-area");
	By clickaddproduct=By.linkText("Add Product");
	
	By clicklogin=By.cssSelector("#__next > div > div > div.jsx-550002916.gbheader > div.jsx-550002916.gbheader-right > div.jsx-1624868303.gbheader-login");
	
	public homepage(RemoteWebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
	
	public WebElement letmejoinletter(){
		
		return driver.findElement(joinletter);
	}
	
	public WebElement getAddProduct(){
		
		return driver.findElement(pointaddproduct);
	}
	
	public WebElement clickAddProduct(){
		
		return driver.findElement(clickaddproduct);
	}
	
	//login
	public WebElement clickLogin(){
		
		return driver.findElement(clicklogin);
	}

}
