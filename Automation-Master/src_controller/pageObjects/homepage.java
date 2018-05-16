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
	By searchelement=By.cssSelector("#__next > div > div > div.jsx-746878661.gtmenu > div.jsx-746878661.gtmenu-search-input > form > input");
	By menuBody=By.cssSelector("#__next > div > div > div.jsx-746878661.gtmenu > div.jsx-746878661.gtmenu-menu-main > div.jsx-746878661.gtmenu-menu-left > div > div > div:nth-child(2) > a");
	By menuHair=By.cssSelector("#__next > div > div > div.jsx-746878661.gtmenu > div.jsx-746878661.gtmenu-menu-main > div.jsx-746878661.gtmenu-menu-left > div > div > div:nth-child(1) > a");
	
	
	
	public homepage(RemoteWebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
	
	public WebElement letmejoinletter(){
		
		return driver.findElement(joinletter);
	}
	
	public WebElement getMenuBody(){
		
		return driver.findElement(menuBody);
	}
	
	public WebElement getMenuHair(){
		
		return driver.findElement(menuHair);
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
	
	//search
	public WebElement clickSearch(){
		
		return driver.findElement(searchelement);
	}

}
