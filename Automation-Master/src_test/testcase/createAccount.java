package testcase;

import static org.testng.Assert.assertTrue;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import pageObjects.CompleteProfile;
import pageObjects.AssertElement;
import pageObjects.CartPage;
import pageObjects.CategoryPage;
import pageObjects.CheckoutPage;
import pageObjects.ProductPage;
import pageObjects.addproductpage;
import pageObjects.homepage;
import pageObjects.login;
import pageObjects.productdetail;
import pageObjects.productlist;
import resources.ConnectDB;
import resources.controller;
import resources.support;

public class createAccount extends controller {
	
	/*
	 * please make sure
	 * 1. you already created the email in mailinator for data in xls
	 * 2. ensure username is new
	 */
	
	String productName = "testing";
	String brandName = "wardah";
	
	public static Logger log =LogManager.getLogger(support.class.getName());
	
	public static RemoteWebDriver driver= null;
	public static WebElement main= null;
	public static Properties prop=null;
	
	public String UrlLogin = null;
	public String UrlPageDetail = null;
	public String emailCreator = null;
	public String usernameCreator = null;
	public String passCreator = null;
	public String conPassCreator = null;
	
	@BeforeTest
	@Parameters({ "browser" })
	public void setUp(String browser) throws IOException {
		System.out.println("*******************");
		driver = controller.getDriver(browser);
		
	}
	
	@Test(dataProvider="existingCust")
	public void scenario_satu(String email,String password,String confirm_password,String username) throws Exception {
		
		support supp= new support();
		homepage home = new homepage(driver);
		login logpro = new login(driver);
		addproductpage productpage = new addproductpage(driver);
		productlist prodlist = new productlist(driver);
		productdetail proddet = new productdetail(driver);;
		
		CompleteProfile comprof = new CompleteProfile(driver);
		AssertElement asser = new AssertElement(driver);
		CategoryPage cat = new CategoryPage(driver);
		ProductPage prod = new ProductPage(driver);
		CartPage cpage = new CartPage(driver);
		CheckoutPage checkout = new CheckoutPage(driver);
		
		prop= new Properties();
		FileInputStream fis=new FileInputStream("//Users//mac//Documents//Automation//mavenjob//Automation-Master//src_controller//resources//data.properties");
		prop.load(fis);
		String testenv=prop.getProperty("testlocation");
		
		if(testenv.equalsIgnoreCase("prod")){
        	driver.navigate().to("http://femaledaily.com/");  //https://dev.uangteman.com/a/NHeHv
             driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	} else {
        		driver.navigate().to("http://femaledaily.net/");  //https://dev.uangteman.com/a/NHeHv
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	}
		
		driver.manage().window().maximize();
		String strPageTitle = driver.getTitle();
		System.out.println(strPageTitle);
		
		//login page
		home.clickLogin().click();
		UrlLogin = driver.getCurrentUrl();
		Assert.assertEquals(UrlLogin, "http://account.femaledaily.net/");
		
		logpro.clickCreateAccount().click();
		
		//register page
		logpro.fillEmail().sendKeys(email);
		logpro.fillUsername().sendKeys(username);
		logpro.fillPassword().sendKeys(password);
		logpro.fillConfirmPasword().sendKeys(confirm_password);
		logpro.tickAggrement().click();
		logpro.clickCreateAccountRe().click();
		
		asser.registerIsSuccess();
		
		//check beaut points after signup = 10
		Integer beautyPoints =  (Integer) ConnectDB.get_dataPoint("select user_total_point FROM nubr_userappos ORDER BY usrapo_id DESC LIMIT 1", "staging");
		
		if(beautyPoints.equals(10)){
			System.out.println("signup point is correct the points="+""+beautyPoints);
		}
		
		comprof.fillmonthdob().click();
		
		String dobsummonth = driver.findElement(By.xpath("//*[@id='birthday']/div[2]/div/div[1]/div/div[2]")).getText();
		if(dobsummonth.contains("January")){
			System.out.println(dobsummonth);
			comprof.filldatedob().click();
			String dobsumdate = driver.findElement(By.xpath("//*[@id='birthday']/div[2]/div/div[2]/div/div[2]")).getText();
				if(dobsumdate.contains("1")){
				System.out.println(dobsumdate);
				comprof.fillyeardob().click();
				String dobsumyear = driver.findElement(By.xpath("//*[@id='birthday']/div[2]/div/div[3]/div/div[2]")).getText();
				System.out.println(dobsumyear);
					if(dobsumyear.contains("1940")){
				    comprof.clicknextdob();
					}else{
						driver.close();
					}
				}else{
					driver.close();
				}
				
		}else{
			driver.close();
		}
		
		comprof.clicknextdob().click();
		
		//skin_type page
		comprof.choosenormal().click();
		comprof.clicknextskin_type().click();
		
		//skin_tone page
		comprof.chooselight().click();
		comprof.clicknextskin_tone().click();
		
		//skin_undertone
		comprof.choosecool().click();
		comprof.clicknextskin_undertone().click();
		
		//hair_type
		comprof.choosewavy().click();
		comprof.clicknexthair_type().click();
		
		//hair_color
		comprof.choosecoloredhair_yes().click();
		comprof.clicknexthair_color().click();
		
		//hijab
		comprof.choosewearhijab_yes().click();
		comprof.clicknexthijab().click();
		
	
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver!=null) {
			System.out.println("Closing browser");
			//driver.close();
		}
	}
	
	public void ExtractJSLogs() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
        }
    }
	
	@DataProvider	  
	public Object[][] existingCust() throws Exception {
	     
		FileInputStream filepath = new FileInputStream("//Users//mac//Documents//Automation//mavenjob//Automation-Master//Workbook1.xls");

		Workbook wb = Workbook.getWorkbook(filepath);
		Sheet sheet = wb.getSheet("Create account success");

		int row = sheet.getRows();
		System.out.println("number of rows"+row);
		int column = sheet.getColumns();
		System.out.println("number of columns"+column);
		String Testdata[][] = new String[row-1][column];
		int count=0;

		     for (int i = 1; i < row; i++)
		     	{
		    	 for (int j = 0; j < column; j++)
		    	 {
		    		 Cell cell = sheet.getCell(j, i);
		    		 Testdata[count][j] = cell.getContents();
		     	}
		    	 count++;
		       }
		     filepath.close();
		     return Testdata;
		     }
}
