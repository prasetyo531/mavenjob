package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class productdetail {

	
public RemoteWebDriver driver=null;
	
	By breadcrumbProductDetail=By.cssSelector("#top-page > div.jsx-2093859422.contain-cover > div");
	By getProductName=By.cssSelector("#top-page > div.jsx-2921700402.pd-item > div.jsx-2921700402.pd-itemcol2 > div.jsx-2921700402.pd-titleprod");
	By getBrandName=By.cssSelector("#top-page > div.jsx-2921700402.pd-item > div.jsx-2921700402.pd-itemcol2 > a");
	By getPrice=By.cssSelector("#top-page > div.jsx-2921700402.pd-item > div.jsx-2921700402.pd-itemcol2 > div.jsx-2921700402.pd-price");
	By getAddReviewButton=By.cssSelector("#top-page > div.jsx-2921700402.pd-item > div.jsx-2921700402.pd-itemcol2 > button");
	By getEdEReviewButton=By.cssSelector("#top-page > div.jsx-2921700402.pd-item > div.jsx-2921700402.pd-itemcol2 > button");
	
	By getWishlistButton=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-right > div.jsx-2784532334.sorter-cover > div > button");
	By getTriedtButton=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-right > div.jsx-2784532334.sorter-cover > div > button");
	By getFilterBitutton=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-right > div.jsx-2784532334.sorter-cover > div > button");
	By getFilterHairButton=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-right > div.jsx-2784532334.sorter-cover > div > button");
	By getSortButton=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-right > div.jsx-2784532334.sorter-cover > div > button");
	By getProfileButton=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-right > div.jsx-2784532334.sorter-cover > div > button");
	By getReviewDescButton=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-right > div.jsx-2784532334.sorter-cover > div > button");
	By getpagination=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-right > div.jsx-2784532334.sorter-cover > div > button");
	By getbacktotopButton=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-right > div.jsx-2784532334.sorter-cover > div > button");
	
	//element form review
	By getFieldReview=By.cssSelector("#form-add-review > div.jsx-4114744673.ar-form > textarea");
	By getOverallRat4=By.cssSelector("#form-add-review > div.jsx-4114744673.ar-clicked-cv > div.jsx-4114744673.ar-clicked > div.jsx-4114744673.ar-col1 > div.jsx-4114744673.ar-starlist > i:nth-child(4)");
	By getProductPriceExpensive=By.cssSelector("#form-add-review > div.jsx-4114744673.ar-clicked-cv > div.jsx-4114744673.ar-clicked > div.jsx-4114744673.ar-col1 > div.jsx-4114744673.ar-btn-txt > button:nth-child(3)");
	By getPackageQuality=By.cssSelector("#form-add-review > div.jsx-4114744673.ar-clicked-cv > div.jsx-4114744673.ar-clicked > div.jsx-4114744673.ar-col2 > div:nth-child(2) > button:nth-child(4)");
	By getPurchase=By.cssSelector("#form-add-review > div.jsx-4114744673.ar-clicked-cv > div.jsx-4114744673.ar-clicked > div.jsx-4114744673.ar-col2 > div:nth-child(4) > button.jsx-4114744673.right");
	By getButtonSubmitReview=By.cssSelector("#form-add-review > div.jsx-4114744673.ar-clicked-cv > div.jsx-4114744673.ar-bottom > div.jsx-4114744673.ar-submit > input");

	
	public productdetail(RemoteWebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
	
	public WebElement clickAddReview(){
		
		return driver.findElement(getAddReviewButton);
	}
	
	public WebElement findBreadcrumb(){
		
		return driver.findElement(breadcrumbProductDetail);
	}
	
	public WebElement findProductName(){
		
		return driver.findElement(getProductName);
	}
	
	public WebElement findBrandName(){
		
		return driver.findElement(getBrandName);
	}
	
	//element review form
	public WebElement fillFieldReview(){
		
		return driver.findElement(getFieldReview);
	}
	
	public WebElement chooseRating(){
		
		return driver.findElement(getOverallRat4);
	}
	
	public WebElement chooseProductPrice(){
		
		return driver.findElement(getProductPriceExpensive);
	}
	
	public WebElement choosePackageQuality(){
		
		return driver.findElement(getPackageQuality);
	}
	
	public WebElement chooseRepurchaseThisProduct(){
		
		return driver.findElement(getPurchase);
	}
	
	public WebElement clickSubmitReview(){
		
		return driver.findElement(getButtonSubmitReview);
	}

}