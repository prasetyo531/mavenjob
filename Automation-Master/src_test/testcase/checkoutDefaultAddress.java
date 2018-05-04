package testcase;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import resources.support;
import resources.controller;
import pageObjects.AssertElement;
import pageObjects.CategoryPage;
import pageObjects.ProductPage;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;

public class checkoutDefaultAddress extends controller {
	
public static Logger log =LogManager.getLogger(support.class.getName());
	
	public static RemoteWebDriver driver= null;
	public static WebElement main= null;
	public static Properties prop=null;
	
	@BeforeTest
	@Parameters({ "browser" })
	public void setUp(String browser) throws IOException {
		System.out.println("*******************");
		driver = controller.getDriver(browser);
		
	}
	
	@Test(dataProvider="existingCust")
	public void scenario_satu(String email,String password,String alamat,String telepon) throws Exception {
		
		support supp= new support();
		AssertElement asser = new AssertElement(driver);
		CategoryPage cat = new CategoryPage(driver);
		ProductPage prod = new ProductPage(driver);
		CartPage cpage = new CartPage(driver);
		CheckoutPage checkout = new CheckoutPage(driver);
		
		prop= new Properties();
		FileInputStream fis=new FileInputStream("//Users//mac//Downloads//kerja//fabelio//automatio-fabelio-branch1//automatio-fabelio-branch1//Automation-Master//src_controller//resources/data.properties");
		prop.load(fis);
		String testenv=prop.getProperty("testlocation");
		
		if(testenv.equalsIgnoreCase("prod")){
        	driver.navigate().to("http://fabelio.com/");  //https://dev.uangteman.com/a/NHeHv
             driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	} else {
        		driver.navigate().to("http://" +testenv + ".fabelio.com/");  //https://dev.uangteman.com/a/NHeHv
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	}
		
		driver.manage().window().maximize();
		String strPageTitle = driver.getTitle();
		System.out.println(strPageTitle);
		
		//go to sofa l
		main = driver.findElement(By.cssSelector("div[class='page-wrapper']"));
		main = driver.findElement(By.cssSelector("div[class='sections nav-sections']"));
		main = driver.findElement(By.cssSelector("div[class='section-items nav-sections-items']"));
		main = driver.findElement(By.cssSelector("div[id='store.menu']"));
		main = driver.findElement(By.cssSelector("nav[class='navigation']"));
		main = driver.findElement(By.cssSelector("ul[id='ui-id-1']"));
		main = driver.findElement(By.cssSelector("li[class='level0 nav-1 first level-top parent ui-menu-item']"));
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ui-id-2']/span[2]")));
		WebElement getmenu= driver.findElement(By.xpath("//*[@id='ui-id-2']/span[2]")); //xpath megamenu nya
		  
		Actions act = new Actions(driver);
		act.moveToElement(getmenu).perform();
		
		(new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sofa L")));

		WebElement clickElement= driver.findElement(By.linkText("Sofa L"));//xpath sub megamenu nya
		act.moveToElement(clickElement).click().perform();
		
		asser.assertcatheader();
		//(new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='maincontent']/div[2]/div[2]/div/h2")));
		
		asser.asserttextsofal();
        
	    //crawl product di category page
		asser.getdatasku();
		
		//selecting product
		driver.findElement(By.id("product-8602")).click();
        
		//assert beli is enable to click
	    asser.assertbelienable();
		
	    //click beli sekarang
	    main = prod.clickbeli();
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", main);
		
	    asser.assertbeliclicked();
	    
	    //click cart notification 
	    asser.assertcartnotif();
	    prod.clickcartnotif().click();
	    
	  //CART PAGE
	    asser.assertuntiltotal();
	    asser.getlinksku();
	    
	    asser.checkproductqtycart(); //check qty product in cart element
			
		asser.assertsubtotal(); //verify subtotal and total on cart summary should display
		asser.asserttotal();
		
		cpage.lanjutkanCart().click(); //click lanjutkan
		
		//CHECKOUT PAGE
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		asser.waitgoogle();
		
		checkout.emailId().sendKeys(email); // isi email
		
		asser.waitcheckbtnemail(); //check btn email clickable
		
		main = driver.findElement(By.xpath("//*[@id='btn-checkemail']")); //next after fill email
	    ((JavascriptExecutor)driver).executeScript("arguments[0].click();", main);
	    
	    asser.waitcheckbtnpassword(); //wait check button passwor
	    
	    checkout.password().sendKeys(password, Keys.ENTER); //fill password
	    
	    asser.waitbtnpasswordenable(); //wait button password enable
	    
	    //next section 1
	    main = driver.findElement(By.id("next-step"));
	    ((JavascriptExecutor)driver).executeScript("arguments[0].click();", main);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		asser.checkdefaultaddress();  //check default addresss
		
	        //next section 2
	        main = driver.findElement(By.cssSelector("div[class='page-wrapper']"));
	        main = driver.findElement(By.cssSelector("main[id='maincontent']"));
	        main = driver.findElement(By.cssSelector("div[id='checkout']"));
	        main = driver.findElement(By.cssSelector("div[class='aw-onestep aw-onestep-main']"));
	        main = driver.findElement(By.cssSelector("ul[class='aw-onestep-groups']"));
	        main = driver.findElement(By.cssSelector("li[id='section-shipping-address']"));
	        main = driver.findElement(By.cssSelector("div[class='group-content section-shipping-address showHide']"));
	        main = driver.findElement(By.cssSelector("div[class='onestep-shipping-address']"));
	        main = driver.findElement(By.cssSelector("div[id='btn-next-address']"));
	        main = driver.findElement(By.cssSelector("div[class='primary']")); 
	        main = driver.findElement(By.cssSelector("button[class='button action continue primary']")); 
	        
	        asser.waitbtnnextsec2();
	        
	        main = driver.findElement(By.cssSelector("#btn-next-address > div:nth-child(1) > button:nth-child(1)"));
	        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", main);
	        
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        
	        if( driver.findElement(By.id("discount-code")).isDisplayed()){ //check discount code
	        	System.out.println("Element Voucher is Visible");
	        	}else{
	        	System.out.println("Element Voucher is InVisible");
	        	}
	
	        //edd
			(new WebDriverWait(driver, 40)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#btn-next-orderreview > div > button")));
	        String edd = driver.findElement(By.cssSelector("#section-order-review > div.group-content.section-order-review > div.onestep-order-review > div.aw-sidebar-product-card > div.aw-sidebar-product-description-container > div.aw-sidebar-product-description.row > div.aw-sidebar-product-name.col-lg-4.col-12 > span:nth-child(3) > small > span:nth-child(2)")).getText();
		    System.out.println(edd);
	        
	        //click next section 3
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        
	        (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#btn-next-orderreview > div > button")));
	        main = driver.findElement(By.cssSelector("#btn-next-orderreview > div:nth-child(1) > button:nth-child(1)"));
	        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", main);
	        
			//get dom section 4
	        main = driver.findElement(By.cssSelector("div[class='page-wrapper']"));
	        main = driver.findElement(By.cssSelector("main[id='maincontent']"));
	        main = driver.findElement(By.cssSelector("div[id='checkout']"));
	        main = driver.findElement(By.cssSelector("div[class='aw-onestep aw-onestep-main']"));
	        main = driver.findElement(By.cssSelector("ul[class='aw-onestep-groups']"));
	        main = driver.findElement(By.cssSelector("li[id='section-payment-method']"));
	        main = driver.findElement(By.cssSelector("div[class='group-content section-payment-method']"));
	        main = driver.findElement(By.cssSelector("div[data-bind='if:isAddressSelected']"));
	        main = driver.findElement(By.cssSelector("div[class='payment-methods-box']"));
	        main = driver.findElement(By.cssSelector("div[class='row']"));
	        supp.waitSeconds(2);
	        checkout.snap().click(); //select payment method is snap
			(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.aw-onestep-sidebar-block:nth-child(3) > div:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > th:nth-child(1)")));
			
			//get dom place order
		    main = driver.findElement(By.cssSelector("div[class='page-wrapper']"));
		    main = driver.findElement(By.cssSelector("main[id='maincontent']"));
		    main = driver.findElement(By.cssSelector("div[id='checkout']"));
		    main = driver.findElement(By.cssSelector("div[class='aw-onestep aw-onestep-main']"));
		    main = driver.findElement(By.cssSelector("ul[class='aw-onestep-groups']"));
		    main = driver.findElement(By.cssSelector("li[id='section-payment-method']"));
		    main = driver.findElement(By.cssSelector("div[class='group-content section-payment-method']"));
		    main = driver.findElement(By.cssSelector("div[data-bind='if:isAddressSelected']"));
		    main = driver.findElement(By.cssSelector("div[class='aw-onestep-sidebar-block aw-sidebar-summary']"));
		    main = driver.findElement(By.cssSelector("div[class='aw-onestep-sidebar-block_content']"));
		     
		    asser.assertsection4();
		    
		    main = driver.findElement(By.cssSelector("div[class='page-wrapper']"));
		    main = driver.findElement(By.cssSelector("main[id='maincontent']"));
		    main = driver.findElement(By.cssSelector("div[id='checkout']"));
		    main = driver.findElement(By.cssSelector("div[class='aw-onestep aw-onestep-main']"));
		    main = driver.findElement(By.cssSelector("ul[class='aw-onestep-groups']"));
		    main = driver.findElement(By.cssSelector("li[id='section-payment-method']"));
		    main = driver.findElement(By.cssSelector("div[class='group-content section-payment-method']"));
		    main = driver.findElement(By.cssSelector("div[data-bind='if:isAddressSelected']"));
		    main = driver.findElement(By.cssSelector("div[class='actions-toolbar']"));
		    
		    asser.waitplaceorder();
		    
		    //click place order
		    checkout.placeOrder().click();
			supp.getResponse();
			
			String orderNo= driver.findElement(By.xpath("//*[@id='maincontent']/div[3]/div/div[2]/div/div[1]/label")).getText();
		    System.out.println(orderNo);
		    
		}

		@AfterMethod
		public void tearDown() {
			if(driver!=null) {
				System.out.println("Closing browser");
				driver.quit();
			}
		}
		
		@DataProvider	  
		public Object[][] existingCust() throws Exception {
		     
		FileInputStream filepath = new FileInputStream("//Users//mac//Downloads//kerja//fabelio//automatio-fabelio-branch1//automatio-fabelio-branch1//Automation-Master//Workbook1.xls");

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