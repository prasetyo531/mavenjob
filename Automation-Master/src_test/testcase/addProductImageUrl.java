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
import org.openqa.selenium.Alert;
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
import pageObjects.homepage;
import pageObjects.login;
import resources.controller;
import resources.support;

public class addProductImageUrl extends controller {
	
public static Logger log =LogManager.getLogger(support.class.getName());
	
	public static RemoteWebDriver driver= null;
	public static WebElement main= null;
	public static Properties prop=null;
	
	public String UrlLogin = null;
	
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
	
		//on browser
		asser.waithomepagemodal();
		asser.javascriptletmejoin();
		home.letmejoinletter().click();
		
		home.clickLogin().click();
		UrlLogin = driver.getCurrentUrl();
		Assert.assertEquals(UrlLogin, "http://account.femaledaily.net/" );
		
		logpro.fillusername().sendKeys("putwid");
		logpro.fillpassword().sendKeys("tester123");
		logpro.clickbuttonlogin().click();
		
		asser.loggedin();
		
		WebElement getmenu= home.getAddProduct(); //xpath megamenu nya  
		Actions act = new Actions(driver);
		act.moveToElement(getmenu).perform();
		
		asser.addproducttodisplay();
		WebElement clickElement= home.clickAddProduct(); //xpath sub megamenu nya
		act.moveToElement(clickElement).click().perform();
		
		System.out.println(UrlLogin);
		
		//step 1
		WebElement focusInputUrl= productpage.insertUrl(); //insert invalid url
	    Actions onfocusInputUrl = new Actions(driver);
	    onfocusInputUrl.moveToElement(focusInputUrl).click();
	    onfocusInputUrl.sendKeys("https://i.kinja-img.com/kampret/image/upload/s--nncnCKWW--/c_scale,f_auto,fl_progressive,q_80,w_800/17hyh5lm9yhjvjpg.jpg");
	    onfocusInputUrl.build().perform();
	    
	    productpage.clickShowLinkImage().click();
	    
	    (new WebDriverWait(driver, 15)).until(ExpectedConditions.alertIsPresent()); //find alert
	    Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
	    
	    onfocusInputUrl.moveToElement(focusInputUrl).click();	//insert valid url
	    onfocusInputUrl.sendKeys("https://i.kinja-img.com/gawker-media/image/upload/s--nncnCKWW--/c_scale,f_auto,fl_progressive,q_80,w_800/17hyh5lm9yhjvjpg.jpg");
	    onfocusInputUrl.build().perform();
		
		productpage.clickShowLinkImage().click();
       
//       JavascriptExecutor js = (JavascriptExecutor) driver;
//       js.executeScript("window.scrollBy(0,1000)");
       
       productpage.nextStep1().click();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       
       //step 2
       WebElement focusbrand= productpage.selectBrand(); //xpath megamenu nya  
       Actions onfocusbrand = new Actions(driver);
       onfocusbrand.moveToElement(focusbrand).click();
       onfocusbrand.sendKeys("warda", Keys.ENTER);
       onfocusbrand.build().perform();
       
       WebElement focusprodcat= productpage.selectProductCat(); //xpath megamenu nya  
       Actions onfocusprodcat = new Actions(driver);
       onfocusprodcat.moveToElement(focusprodcat).click();
       onfocusprodcat.sendKeys("frag", Keys.ENTER);
       onfocusprodcat.build().perform();

       WebElement focusProductSubCat= productpage.insertProductSubCat(); //xpath megamenu nya  
       Actions onfocusProductSubCat = new Actions(driver);
       onfocusProductSubCat.moveToElement(focusProductSubCat).click();
       onfocusProductSubCat.sendKeys("edp", Keys.ENTER);
       onfocusProductSubCat.build().perform();
       
       WebElement focusProductName= productpage.insertProductName(); //xpath megamenu nya  
       Actions onfocusProductName = new Actions(driver);
       onfocusProductName.moveToElement(focusProductName).click();
       onfocusProductName.sendKeys("testing");
       onfocusProductName.build().perform();
       
       WebElement focusProductShade= productpage.insertProductShade(); //xpath megamenu nya  
       Actions onfocusProductShade = new Actions(driver);
       onfocusProductShade.moveToElement(focusProductShade).click();
       onfocusProductShade.sendKeys("female");
       onfocusProductShade.build().perform();
       
       productpage.nextStep2().click();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       
       //step 3
       productpage.chooseRating().click();
       productpage.choosePackagequality().click();
       productpage.chooseRepurchase().click();
       productpage.inputWritereview().sendKeys("review by qa, barang barang barang barang barang barang barang barang barang barang barang barang barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus");
       productpage.nextStep3().click();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       
       //step 4
       productpage.inputPrice().click();
       productpage.inputPrice().sendKeys("100000");
       productpage.inputDescription().click();
       
       WebElement focusProductDesc= productpage.inputDescription(); //xpath megamenu nya  
       Actions onfocusProductDesc = new Actions(driver);
       onfocusProductDesc.moveToElement(focusProductDesc).click();
       onfocusProductDesc.sendKeys("description of test");
       onfocusProductDesc.build().perform();
       
       //productpage.inputDescription().sendKeys("huba huba");
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       
       productpage.clickSubmit().click();

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