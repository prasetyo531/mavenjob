package testcase;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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
import pageObjects.AssertElement;
import pageObjects.CartPage;
import pageObjects.CategoryPage;
import pageObjects.CheckoutPage;
import pageObjects.ProductPage;
import pageObjects.addproductpage;
import pageObjects.brandPage;
import pageObjects.homepage;
import pageObjects.login;
import pageObjects.productdetail;
import pageObjects.productlist;
import pageObjects.profileDetail;
import resources.ConnectDB;
import resources.controller;
import resources.support;

public class sortBrand extends controller {
	
public static Logger log =LogManager.getLogger(support.class.getName());
	
	public static RemoteWebDriver driver= null;
	public static WebElement main= null;
	public static Properties prop=null;
	
	public String UrlLogin = null;
	public String UrlReviewerProfDetail = null;
	public String nameReviewer = null;
	public String countFollower = null;
	public String coungFollowing = null;
	
	@BeforeTest
	@Parameters({ "browser" })
	public void setUp(String browser) throws IOException {
		System.out.println("*******************");
		driver = controller.getDriver(browser);
		
	}
	
	@Test(dataProvider="existingCust")
	public void scenario_satu(String email,String password,String alamat,String telepon) throws Exception {
		
		support supp= new support();
		homepage home = new homepage(driver);
		login logpro = new login(driver);
		addproductpage productpage = new addproductpage(driver);
		productlist prodlist = new productlist(driver);
		productdetail proddet = new productdetail(driver);
		profileDetail profdet = new profileDetail(driver);
		brandPage brand = new brandPage(driver);
		ConnectDB conn = new ConnectDB();
		
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
		
		String handle= driver.getWindowHandle(); //get window 1
		System.out.println(handle);
	
		//on browser
		asser.waithomepagemodal();
		asser.javascriptletmejoin();
		home.letmejoinletter().click();
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", home.clickBrandFooter());
		Thread.sleep(4000);
		
		home.clickBrandFooter().click();
		
		Set handles = driver.getWindowHandles();
		 
        System.out.println(handles);
        
        for (String handle1 : driver.getWindowHandles()) {
        	 System.out.println(handle1);
        	 driver.switchTo().window(handle1);
        	 String page2 = driver.getCurrentUrl();
             System.out.println(page2);
        	}
        
        asser.waitBrandPage();
        
        brand.clickNivea().click();
        asser.waitBrandDetailPage();
        
        String UrlBrand1 = driver.getCurrentUrl();
        Assert.assertEquals(UrlBrand1, "http://reviews.femaledaily.net/brands/nivea?tab=products&page=1");
        
        brand.clickLogoHome().click(); //go bck to homepage
        asser.waithomepagemodal();
		asser.javascriptletmejoin();
		home.letmejoinletter().click();
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", home.clickBrandFooter());
		Thread.sleep(4000);
		
		home.clickBrandFooter().click();
		
		Set handles2 = driver.getWindowHandles();
		
		System.out.println(handles2);
        
        for (String handle2 : driver.getWindowHandles()) {
        	 System.out.println(handle2);
        	 driver.switchTo().window(handle2);
        	 String page3 = driver.getCurrentUrl();
             System.out.println(page3);
        	}
        
        asser.waitBrandPage();
        	
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", brand.clickSortBrand());
        
        //verify most product
        String mostProductFromA = (String) conn.getfromDatabaseBrands_brandsItem("SELECT brands_item FROM nubr_brands WHERE brands_item LIKE'A%' ORDER BY brands_total_product DESC LIMIT 1;", "staging");
        System.out.println("database"+" "+mostProductFromA);
	    
	    String matchMostProduct = brand.getTextBrandMosProductFromA().getText();
	    System.out.println(matchMostProduct);
	    		
	    Assert.assertEquals(matchMostProduct, mostProductFromA);

	    brand.getTextBrandMosProductFromA().click();
	    asser.waitBrandDetailPage();
	    
	    String mostPopularProductBrand = (String) conn.getfromDatabaseBrands_productType("SELECT b.prod_item FROM nubr_reviews AS c INNER JOIN nubr_products AS b ON c.review_prod_id=b.prod_id INNER JOIN nubr_brands AS a ON c.review_brand_id=a.brands_id WHERE c.review_brand_id=2 ORDER BY c.review_num DESC LIMIT 1;", "staging");
        System.out.println("database"+" "+mostPopularProductBrand);
        
        String matchPopularProductBrand = brand.getAlwaysFirstProduct().getText();
	    System.out.println(matchPopularProductBrand);
	    
	    Assert.assertEquals(matchPopularProductBrand, mostPopularProductBrand); 
	    
	    brand.clicksortBrandList().click();
	    brand.chooseNewestSort().click();
	    
	    String mostNewestProductBrand = (String) conn.getfromDatabaseBrands_productType("SELECT b.prod_item FROM nubr_reviews AS c INNER JOIN nubr_products AS b ON c.review_prod_id=b.prod_id INNER JOIN nubr_brands AS a ON c.review_brand_id=a.brands_id WHERE c.review_brand_id=2 ORDER BY c.review_date DESC LIMIT 1;", "staging");
        System.out.println("database"+" "+mostNewestProductBrand);
        
        String matchNewestProductBrand = brand.getAlwaysFirstProductNewest().getText();
	    System.out.println(matchNewestProductBrand);
	    
	    Assert.assertEquals(matchNewestProductBrand, mostNewestProductBrand); 
	    
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
		Sheet sheet = wb.getSheet("existing");

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