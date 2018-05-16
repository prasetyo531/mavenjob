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
	By getAddEditReviewButton=By.cssSelector("#top-page > div.jsx-2921700402.pd-item > div.jsx-2921700402.pd-itemcol2 > button");
	By getWishlistButton=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-right > div.jsx-2784532334.sorter-cover > div > button");
	By getTriedtButton=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-right > div.jsx-2784532334.sorter-cover > div > button");
	By getFilterButton=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-right > div.jsx-2784532334.sorter-cover > div > button");
	By getFilterHairButton=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-right > div.jsx-2784532334.sorter-cover > div > button");
	By getSortButton=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-right > div.jsx-2784532334.sorter-cover > div > button");
	By getProfileButton=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-right > div.jsx-2784532334.sorter-cover > div > button");
	By getReviewDescButton=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-right > div.jsx-2784532334.sorter-cover > div > button");
	By getpagination=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-right > div.jsx-2784532334.sorter-cover > div > button");
	By getbacktotopButton=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-right > div.jsx-2784532334.sorter-cover > div > button");

	
	
	public productdetail(RemoteWebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
	
	public WebElement clickAddReview(){
		
		return driver.findElement(getAddEditReviewButton);
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

}