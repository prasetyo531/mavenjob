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
import java.util.Random;
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

import assertObject.assertHome;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import pageObjects.cartPage;
import pageObjects.categoryPage;
import pageObjects.checkoutPage;
import pageObjects.ProductPage;
import pageObjects.addproductpage;
import pageObjects.homepage;
import pageObjects.login;
import pageObjects.productdetail;
import pageObjects.productlist;
import resources.controller;
import resources.support;
import resources.ConnectDB;

public class addProductEditBrand extends controller {
	
	String productName = "testing";
	String brandName = "wardah";
	private static final char[] characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	 private static final Random random = new Random(new Date().getTime());
	
	public static Logger log =LogManager.getLogger(support.class.getName());
	
	public static RemoteWebDriver driver= null;
	public static WebElement main= null;
	public static Properties prop=null;
	
	public String UrlLogin = null;
	public String UrlPageDetail = null;
	
	 private static String createRandomString(int length) {
	        final StringBuffer stringBuffer = new StringBuffer();
	        for (int i = 0; i < length; i++) {
	            String randomValue;
	            if (random.nextInt(2) == 1) {
	                randomValue = String.valueOf(random.nextInt(10));
	            } else {
	                randomValue = Character.toString(characters[random.nextInt(26)]);
	            }
	            stringBuffer.append(randomValue);
	        }
	        return stringBuffer.toString();
	    }
	
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
		productdetail proddet = new productdetail(driver);;
		
		assertHome asser = new assertHome(driver);
		categoryPage cat = new categoryPage(driver);
		ProductPage prod = new ProductPage(driver);
		cartPage cpage = new cartPage(driver);
		checkoutPage checkout = new checkoutPage(driver);
		
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
		
		home.clickLogin().click();
		UrlLogin = driver.getCurrentUrl();
		Assert.assertEquals(UrlLogin, "http://account.femaledaily.net/" );
		
		logpro.fillusername().sendKeys("putwid");
		logpro.fillpassword().sendKeys("tester123");
		logpro.clickbuttonlogin().click();
		
		asser.welcomingpopup();
		
		//click hamburger
		home.closeTooltip().click();
		home.Hamburger().click();;
		
		home.clickMenuReview().click();
		asser.waitNewestReview();
		
		WebElement getmenu= home.getAddProduct(); //xpath megamenu nya  
		Actions act = new Actions(driver);
		act.moveToElement(getmenu).perform();
		
		asser.addproducttodisplay();
		WebElement clickElement= home.clickAddProduct(); //xpath sub megamenu nya
		act.moveToElement(clickElement).click().perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		asser.modalAddproduct();
		
		//on page add product
		productpage.clickCloseModal().click();
		
		//step 1
		productpage.clickUploadPhoto().click();
		
		File file1 = new File("/Users/mac/Documents/multimedia/background/product-test.jpg");
        StringSelection stringSelection1= new StringSelection(file1.getAbsolutePath());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection1, null);
		
        Robot robot1 = new Robot();
        
        // Cmd + Tab is needed since it launches a Java app and the browser looses focus
       
       robot1.keyPress(KeyEvent.VK_META);
       robot1.keyPress(KeyEvent.VK_TAB);
       robot1.keyRelease(KeyEvent.VK_META);
       robot1.keyRelease(KeyEvent.VK_TAB);
       robot1.delay(800);
       //Open Goto window
       robot1.keyPress(KeyEvent.VK_META);
       robot1.keyPress(KeyEvent.VK_SHIFT);
       robot1.keyPress(KeyEvent.VK_G);
       robot1.keyRelease(KeyEvent.VK_META);
       robot1.keyRelease(KeyEvent.VK_SHIFT);
       robot1.keyRelease(KeyEvent.VK_G);
       //Paste the clipboard value
       robot1.keyPress(KeyEvent.VK_META);
       robot1.keyPress(KeyEvent.VK_V);
       robot1.keyRelease(KeyEvent.VK_META);
       robot1.keyRelease(KeyEvent.VK_V);
       //Press Enter key to close the Goto window and Upload window
       robot1.keyPress(KeyEvent.VK_ENTER);
       robot1.keyRelease(KeyEvent.VK_ENTER);
       robot1.delay(800);
       robot1.keyPress(KeyEvent.VK_ENTER);
       robot1.keyRelease(KeyEvent.VK_ENTER);
       Thread.sleep(5000);
       
       Actions crop = new Actions(driver);
       WebElement trycrop = driver.findElementByCssSelector("#modal-crop-showed > div > div.ReactCrop.ReactCrop--fixed-aspect > img");

       //Move to the desired co-ordinates of the image element, In the code below I am staring from bottom left corner of the image
       crop.moveToElement(productpage.findCropArea(),0,0);

       //locate the co-ordinates of image you want to move by and perform the click   and hold which mimics the crop action 
       crop.clickAndHold().moveByOffset(196,238).release().build().perform();
       
       productpage.cropPicture().click();
       
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
       onfocusProductName.sendKeys(createRandomString(8));
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
       productpage.inputWritereview().sendKeys("barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus barang bagus");
       productpage.nextStep3().isEnabled();
       productpage.nextStep3().click();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       
       //step 4
       productpage.inputPrice().click();
       productpage.inputPrice().sendKeys("100000");
       productpage.inputDescription().click();
       productpage.inputDescription().sendKeys("add product edit brand");
       
       //edit step 2
       productpage.editStep2().click();
       WebElement focuseditbrand= productpage.editBrand(); //xpath megamenu nya  
       Actions onfocuseditbrand = new Actions(driver);
       onfocusbrand.moveToElement(focuseditbrand).click();
       onfocusbrand.sendKeys("goldwell", Keys.ENTER);
       onfocusbrand.build().perform();
       
       //click next step 2
       productpage.nextStep2().click();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       
       //click next step 3
       productpage.nextStep3().click();
       
       productpage.clickSubmit().click();
       
       asser.waitPageDetail();
       
       UrlPageDetail = driver.getCurrentUrl();
       System.out.println(UrlPageDetail);
       if (UrlPageDetail.contains("/fragrance/edp/goldwell")) {//asert contain expected text
    	   System.out.println("pass");
       } else {
    	   System.out.println("fail");
       }
       
//       String breadcrumb = proddet.findBreadcrumb().getText();
//       System.out.println(breadcrumb);
//       assertTrue(driver.findElement(By.cssSelector("#top-page > div.jsx-2093859422.contain-cover > div")).getText().contains("EDP"));
//       
//       String pname = proddet.findProductName().getText();
//       System.out.println(pname);
//       assertTrue(proddet.findProductName().getText().contains(pname));
//       
//       String bname = proddet.findBrandName().getText();
//       System.out.println(bname);
//       assertTrue(proddet.findBrandName().getText().contains(bname));
//       
//       //query check product name terkahir
//       String matchesAddedProductName = (String) ConnectDB.db_productItem("SELECT nubr_products.prod_item FROM nubr_reviews INNER JOIN nubr_products ON nubr_reviews.review_prod_id=nubr_products.prod_id ORDER BY nubr_reviews.review_date DESC LIMIT 1", "staging");
//       Assert.assertEquals(matchesAddedProductName, pname);
//       
//       //query check brands terkahir
//       String matchesAddedBrandsName = (String) ConnectDB.db_brandsItem("SELECT nubr_brands.brands_item FROM nubr_reviews INNER JOIN nubr_brands ON nubr_reviews.review_brand_id=nubr_brands.brands_id ORDER BY nubr_reviews.review_date DESC LIMIT 1", "staging");
//       Assert.assertEquals(matchesAddedBrandsName, bname);
       

	}
	
	@AfterMethod
	public void tearDown() {
		if(driver!=null) {
			System.out.println("Closing browser");
//			driver.close();
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
