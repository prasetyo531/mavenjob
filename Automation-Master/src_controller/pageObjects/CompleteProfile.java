package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CompleteProfile {
	
	public RemoteWebDriver driver=null;

	//birthdate
	By dob_month=By.xpath("//*[@id='birthday']/div[2]/div/div[1]");
	By dob_date=By.xpath("//*[@id='birthday']/div[2]/div/div[2]");
	By dob_year=By.xpath("//*[@id='birthday']/div[2]/div/div[3]");
	By btdob_next=By.xpath("//*[@id='birthday']/div[2]/button[2]");
	By btdob_back=By.xpath("//*[@id='birthday']/div[2]/button[1]");
	
	//skin_type
	By skintype_normal=By.cssSelector("div[data-value'4']");
	By skintype_dry=By.cssSelector("div[data-value'3']");
	By skintype_combination=By.cssSelector("div[data-value'5']");
	By skintype_oily=By.cssSelector("div[data-value'7']");
	By btstype_back=By.xpath("//*[@id='skin-type']/div[2]/button[1]");
	By btstype_next=By.xpath("//*[@id='skin-type']/div[2]/button[2]");
	
	//skin_tone
	By skintone_light=By.cssSelector("div[data-value'1']");
	By skintone_mediumlight=By.cssSelector("div[data-value'2']");
	By skintone_medium=By.cssSelector("div[data-value'3']");
	By skintone_mediumdark=By.cssSelector("div[data-value'6']");
	By skintone_dark=By.cssSelector("div[data-value'7']");
	By btstone_back=By.xpath("//*[@id='skin-tone']/div[2]/button[1]");
	By btstone_next=By.xpath("//*[@id='skin-tone']/div[2]/button[2]");
	
	//skin_undertone
	By skinundertone_cool=By.cssSelector("div[data-value'1']");
	By skinundertone_neutral=By.cssSelector("div[data-value'2']");
	By skinundertone_warm=By.cssSelector("div[data-value'3']");
	By btsutone_back=By.xpath("//*[@id='skin-undertone']/div[2]/button[1]");
	By btsutone_next=By.xpath("//*[@id='skin-undertone']/div[2]/button[2]");
	
	//hair_type
	By hairtype_wavy=By.cssSelector("div[data-value'1']");
	By hairtype_straight=By.cssSelector("div[data-value'2']");
	By hairtype_curly=By.cssSelector("div[data-value'3']");
	By bthairtype_back=By.xpath("//*[@id='hair-type']/div[2]/button[1]");
	By bthairtype_next=By.xpath("//*[@id='hair-type']/div[2]/button[1]");
	
	//hair_color
	By haircolor_yes=By.cssSelector("div[data-value'1']");
	By haircolor_no=By.cssSelector("div[data-value'2']");
	By bthaircolor_back=By.xpath("//*[@id='colored-hair']/div[2]/button[1]");
	By bthaircolor_next=By.xpath("//*[@id='colored-hair']/div[2]/button[2]");
	
	//hijab
	By hijab_yes=By.cssSelector("div[data-value'1']");
	By hijab_no=By.cssSelector("div[data-value'2']");
	By bthijab_back=By.xpath("//*[@id='hijaber']/div[2]/button[1]");
	By bthijab_next=By.xpath("//*[@id='hijaber']/div[2]/button[2]");
	
	//skin_concerns
	By skincon_acne=By.cssSelector("div[data-value'1']");
	By skincon_scars=By.cssSelector("div[data-value'1']");
	By skincon_bwheads=By.cssSelector("div[data-value'1']");
	By btskincon_back=By.xpath("//*[@id='skin-concern']/div[2]/button[2]");
	By btskincon_next=By.xpath("//*[@id='skin-concern']/div[2]/button[2]");
	
	
	public CompleteProfile(RemoteWebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
	
	public WebElement fillusername(){
		
		return driver.findElement(dob_month);
	}
	
	public WebElement fillpassword(){
		
		return driver.findElement(dob_month);
	}

}
