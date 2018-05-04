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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import resources.support;
import resources.controller;
import pageObjects.AssertElement;
import pageObjects.CategoryPage;
import pageObjects.CheckoutPage;
import pageObjects.ProductPage;

public class checkCpIp extends controller {
	
	public static Logger log =LogManager.getLogger(support.class.getName());
	
	public static RemoteWebDriver driver= null;
	public static WebElement main= null;
	public static Properties prop=null;
	
    //@Test(dataProvider="data",dataProviderClass=datatest.class) 
    //@Test(enable=false) untuk option run sebuah test case atau engga
	//@Test(timeout=45000) untuk kasih timeout
	
	@BeforeMethod
	@Parameters({ "browser" })
	public void setUp(String browser) throws IOException {
		System.out.println("*******************");
		driver = controller.getDriver(browser);
		
	}
	
	@Test
	public void scenario_satu() throws Exception {
		
		support bs= new support();
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
		
		(new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='maincontent']/div[2]/div[2]/div/h2")));
		
        String getheadercatpage = driver.findElement(By.xpath("//*[@id='maincontent']/div[2]/div[2]/div/h2")).getText();
        System.out.println(getheadercatpage);
        
        if(getheadercatpage.equals("Sofa L")){
        	System.out.println("PASS");
        } else {
        	System.out.println("FAIL");
        	driver.close();
        }
        
        //check cp
        String cp = driver.getCurrentUrl();
        System.out.println(cp);
        
        if (cp.contains("cp")){
        	
    	    //crawl product di category page
        	List<WebElement> myList=driver.findElements(By.xpath("//li[@class='item product product-item col-lg-4 col-sm-6 col-12 nopadding']//div")); //get price from array, xpath sampe atributes yg mau diambil
    		List<String> url=new ArrayList<>();

    		for(int i=0; i<myList.size(); i++){

    		url.add(myList.get(i).getAttribute("data-sku"));	//loading text of each element in to array all_elements_text
    		if (myList.get(i).getAttribute("data-sku") != null){	//if there is null, will not printed

    		System.out.println(myList.get(i).getAttribute("data-sku"));	//to print directly
    			}
    		}
    		
    		//selecting product
    		driver.findElement(By.id("product-8602")).click();
        	
    		//check ip
            String ip = driver.getCurrentUrl();
            System.out.println(ip);
            
             if (ip.contains("ip")){
	        
	    	 //click beli sekarang
	    	 (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='product-options-wrapper']/div/div/div/span[2]")));
	    	 driver.findElement(By.id("product-addtocart-button")).click();
	    	 (new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='minicart-content-wrapper']")));
	    		
	    	    //verify cart notification is present
	    	    if(driver.findElement(By.xpath("//*[@id='cart-add-notification']"))!= null){ 
	    	    	System.out.println("Element Cart Notification is Present");
	    	    	}else{
	    	    	System.out.println("Element Cart Notification is Missing");
	    	    	}
	    	    
	    	    //click cart notification 
	    	    (new WebDriverWait(driver, 15)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#product-addtocart-button")));
	    		driver.findElement(By.xpath("html/body/div[3]/header/div[1]/div[1]/a")).click();
	    	    
	    	    //CART PAGE
	    	    (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cart-totals']/div/table/tbody/tr[1]/th")));
	    	    
	    	    List<WebElement> myCart=driver.findElements(By.xpath("//tbody[@class='cart item']//tr//td//a"));
	    		List<String> cart=new ArrayList<>();
	    		
	    		for(int i=0; i<myCart.size(); i++){
	    	
	    	        //loading text of each element in to array all_elements_text
	    			cart.add(myCart.get(i).getAttribute("href"));
	    	    	//if there is null, will not printed
	    	    	if (myCart.get(i).getAttribute("href") != null){
	    	
	    	        //to print directly
	    	        System.out.println(myCart.get(i).getAttribute("href"));
	    	    	}
	    		}
	    	    
	    		//check if cart-summary displaying
	    		if(driver.findElement(By.xpath("//*[@id='maincontent']/div[2]/div/div[3]"))!= null){ 
	    	    	System.out.println("Element Cart Summary is Present");
	    	    	}else{
	    	    	System.out.println("Element Cart Summary is Missing");
	    	    	}
	    			
	    	 	//verify subtotal and total on cart summary should display
	    		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cart-totals']/div/table/tbody/tr[1]/th")));
	    		assertTrue(driver.findElement(By.xpath("//*[@id='cart-totals']/div/table/tbody/tr[1]/th")).getText().matches("Sub Total"));
	    		assertTrue(driver.findElement(By.xpath("//*[@id='cart-totals']/div/table/tbody/tr[3]/th")).getText().contains("Total"));
	    		
	    		driver.findElement(By.xpath("//*[@id='maincontent']/div[2]/div/div[3]/ul/li/button")).click();	//click lanjutkan on cart page
            	
            	} else {
            		tearDown();
            	}
          } else {
        	tearDown();
          }
	}

		@AfterMethod
		public void tearDown() {
			if(driver!=null) {
				System.out.println("Closing browser");
				driver.quit();
			}
		}
	
}