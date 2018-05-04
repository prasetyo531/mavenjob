package testcase;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class junit {
	
	@Test
	public void testing(){
		System.setProperty("webdriver.chrome.driver", "/Users/mac/Downloads/kerja/fabelio/automatio-fabelio-branch1/automatio-fabelio-branch1/chromedriver2");
		WebDriver driver= new ChromeDriver();
		driver.get("http://fabelio.com");
		
		String strPageTitle = driver.getTitle();
		System.out.print(strPageTitle);
		
		assertEquals("Toko Furniture Online, Minimalis & Murah | Fabelio.com ®", strPageTitle);
		
		
		
	}

}
