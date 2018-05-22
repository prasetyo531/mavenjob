package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class login {
	
	public RemoteWebDriver driver=null;

	By username=By.cssSelector("#__next > div > div > div.jsx-1965109485._1jmxl8o.login > form > div:nth-child(2) > input");
	By password=By.cssSelector("#__next > div > div > div.jsx-1965109485._1jmxl8o.login > form > div:nth-child(3) > input");
	By rememberme=By.cssSelector("#__next > div > div > div.jsx-1965109485._1jmxl8o.login > form > div.jsx-1965109485.remember-forgot > div.jsx-1965109485.remember-forgot-left > div > span");
	By forgotPassword=By.cssSelector("#__next > div > div > div.jsx-1965109485._1jmxl8o.login > form > div.jsx-1965109485.remember-forgot > div.jsx-1965109485.remember-forgot-right > p > a");
	By buttonlogin=By.cssSelector("#__next > div > div > div.jsx-1965109485._1jmxl8o.login > form > div.jsx-1965109485.login-button-login > div > input");
	By buttonloginFb=By.cssSelector("#__next > div > div > div.jsx-1965109485._1jmxl8o.login > form > div.jsx-1965109485.login-button-login-facebook > div > input");
	
	
	By createaccount=By.cssSelector("#__next > div > div > div.jsx-1965109485._1jmxl8o.login > form > p > a");
	By emailReg=By.cssSelector("#__next > div > div > div.jsx-3296557956._1jmxl8o.register > form > div:nth-child(2) > input");
	By usernameReg=By.cssSelector("#__next > div > div > div.jsx-3296557956._1jmxl8o.register > form > div:nth-child(3) > input");
	By passwordReg=By.cssSelector("#__next > div > div > div.jsx-3296557956._1jmxl8o.register > form > div:nth-child(4) > input");
	By confirmPasswordReg=By.cssSelector("#__next > div > div > div.jsx-3296557956._1jmxl8o.register > form > div:nth-child(5) > input");
	By checklistAgree=By.cssSelector("#__next > div > div > div.jsx-3296557956._1jmxl8o.register > form > div.jsx-3296557956.register-text-extra > span");
	By syaratKondisi=By.cssSelector("#__next > div > div > div.jsx-3296557956._1jmxl8o.register > form > div.jsx-3296557956.register-text-extra > p > a");
	By createAccountRegisterPage=By.cssSelector("#__next > div > div > div.jsx-3296557956._1jmxl8o.register > form > div.jsx-3296557956.register-button-login > div > input");
	
	By clicklogin=By.cssSelector("#__next > div > div > div.jsx-550002916.gbheader > div.jsx-550002916.gbheader-right > div.jsx-1624868303.gbheader-login");
	
	public login(RemoteWebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
	
	public WebElement fillusername(){
		
		return driver.findElement(username);
	}
	
	public WebElement fillpassword(){
		
		return driver.findElement(password);
	}
	
	public WebElement clickbuttonlogin(){
		
		return driver.findElement(buttonlogin);
	}
	
	
}
