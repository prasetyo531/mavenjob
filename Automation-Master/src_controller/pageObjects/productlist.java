package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class productlist {

	
public RemoteWebDriver driver=null;
	
	By catBalm=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-left > div.jsx-17482050.filter-category-desktop > a:nth-child(3)");
	By catFootCream=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-left > div.jsx-17482050.filter-category-desktop > a:nth-child(3)");
	By brand100pure=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-left > div.jsx-727148539.filter-brand-desktop > div.jsx-727148539.scroll-menu > a.jsx-727148539.filter-brand-desktop-category-active");
	By hoverProductList=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-right > div.jsx-2784532334.ctg-list-item > div:nth-child(1) > a > img");
	By sortoption=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-right > div.jsx-2784532334.sorter-cover > div > button");
	By foundAddReviewButton=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-right > div.jsx-2784532334.ctg-list-item > div:nth-child(1) > a > div > button");
	
	
	public productlist(RemoteWebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
	
	public WebElement clickFootCream(){
		
		return driver.findElement(catFootCream);
	}
	
	public WebElement clickBalm(){
		
		return driver.findElement(catBalm);
	}
	
	public WebElement clickBrand100Pure(){
		
		return driver.findElement(brand100pure);
	}
	
	public WebElement pointAddReviewProdList(){
		
		return driver.findElement(hoverProductList);
	}
	
	public WebElement foundAddReviewProdList(){
		
		return driver.findElement(foundAddReviewButton);
	}
	
	
	public WebElement clickSortProdList(){
		
		return driver.findElement(sortoption);
	}

}