package assertObject;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class assertCompProfile {
	
public RemoteWebDriver driver= null;
	
	public assertCompProfile(RemoteWebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
	
	//register warning
	public void waitWarningRegister(){
		(new WebDriverWait(driver, 50)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#__next > div > div > div.jsx-3296557956._1jmxl8o.register > form > div.jsx-3296557956.register-warning > p")));
	}
	
	//register success
	public void registerIsSuccess(){
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='birthday']/div[2]/div/div[1]/div")));
	}
	
	//female daily
	//complete profile
	//skin_type
	public void waitskintypeload(){
		(new WebDriverWait(driver, 50)).until(ExpectedConditions.urlContains("/completing-profile?step=skin_type"));
	}
		
		//skin_tone
	public void waitskintoneload(){
		(new WebDriverWait(driver, 50)).until(ExpectedConditions.urlContains("/completing-profile?step=skin_tone"));
	}
		
	//skin_undertone
	public void waitskinundertoneload(){
		(new WebDriverWait(driver, 50)).until(ExpectedConditions.urlContains("/completing-profile?step=skin_undertone"));
	}
		
	//hair_type
	public void waithairtypeload(){
		(new WebDriverWait(driver, 50)).until(ExpectedConditions.urlContains("/completing-profile?step=hair_type"));
	}
		
	//hair_color
	public void waithaircolorload(){
		(new WebDriverWait(driver, 50)).until(ExpectedConditions.urlContains("/completing-profile?step=hair_color"));
	}
		
	//hijab
	public void waithijabload(){
		(new WebDriverWait(driver, 50)).until(ExpectedConditions.urlContains("/completing-profile?step=hijab"));
	}
		
	//skin_concerns
	public void waitskinconcernsload(){
		(new WebDriverWait(driver, 50)).until(ExpectedConditions.urlContains("/completing-profile?step=skin_concerns"));
	}
		
	//body_concerns
	public void waitbodyconcernsload(){
		(new WebDriverWait(driver, 50)).until(ExpectedConditions.urlContains("/completing-profile?step=body_concerns"));
	}
		
	//hair_concerns
	public void waithair_concernsload(){
		(new WebDriverWait(driver, 50)).until(ExpectedConditions.urlContains("/completing-profile?step=hair_concerns"));
	}
		
	//summary page
	public void waitsummaryload(){
		(new WebDriverWait(driver, 50)).until(ExpectedConditions.urlContains("/completing-profile?step=summary"));
	}
		
	//follow
	public void waitsuggestfollowload(){
		(new WebDriverWait(driver, 50)).until(ExpectedConditions.urlContains("/completing-profile?step=find_friends"));
	}
		
	//start my beuty journey
	public void waitbeautyjourneyload(){
		(new WebDriverWait(driver, 50)).until(ExpectedConditions.urlContains("/completing-profile?step=last_step"));
	}

}
