package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class addproductpage {
	
	public RemoteWebDriver driver=null;
	
	//step1
	By uploadphoto=By.cssSelector("#top-page > div.jsx-434510772 > div.jsx-434510772.ap-accord > form > div.jsx-434510772.ap-section1 > div.jsx-434510772.ap-image-action > div.jsx-434510772.ap-btn-upload > button");
	By inserturlphoto=By.cssSelector("#top-page > div.jsx-3686042703 > div.jsx-3686042703.ap-accord > form > div.jsx-3686042703.ap-section1 > div.jsx-3686042703.ap-image-action > div.jsx-3686042703.ap-image-url > input");
	By croparea=By.cssSelector("#modal-crop-showed > div > div.ReactCrop.ReactCrop--fixed-aspect > img");
	By crop=By.cssSelector("#modal-crop-showed > div > div.jsx-434510772.modal-crop-button > button.jsx-434510772.modal-button.crop-button");
	By show=By.cssSelector("#top-page > div.jsx-3686042703 > div.jsx-3686042703.ap-accord > form > div.jsx-3686042703.ap-section1 > div.jsx-3686042703.ap-image-action > div.jsx-3686042703.ap-image-url > button");
	By nextstep1=By.cssSelector("#top-page > div.jsx-3686042703 > div.jsx-3686042703.ap-accord > form > div.jsx-3686042703.ap-btn-next > input");
	
	//step2
	By brandname=By.cssSelector("#react-select-2--value > div.Select-placeholder");
	By productcat=By.cssSelector("#react-select-3--value > div.Select-placeholder");
	By productsubcat=By.cssSelector("#react-select-4--value > div.Select-placeholder");
	By productname=By.cssSelector("#top-page > div.jsx-573540586 > div.jsx-573540586.ap-accord > form > div.jsx-573540586.ap-section2 > div:nth-child(7) > input");
	By productshade=By.cssSelector("#top-page > div.jsx-573540586 > div.jsx-573540586.ap-accord > form > div.jsx-573540586.ap-section2 > div:nth-child(9) > input");
	By nextstep2=By.cssSelector("#top-page > div.jsx-573540586 > div.jsx-573540586.ap-accord > form > div.jsx-573540586.ap-btn-next > input");
	
	//step3
	By rating=By.cssSelector("#top-page > div.jsx-4237973997 > div.jsx-4237973997.ap-accord > form > div.jsx-4237973997.ap-section2 > div.jsx-4237973997.ap-starlist > i:nth-child(5)");
	By packagequality=By.cssSelector("#top-page > div.jsx-4237973997 > div.jsx-4237973997.ap-accord > form > div.jsx-4237973997.ap-section2 > div:nth-child(6) > button.jsx-4237973997.selected");
	By repurchase=By.cssSelector("#top-page > div.jsx-4237973997 > div.jsx-4237973997.ap-accord > form > div.jsx-4237973997.ap-section2 > div:nth-child(8) > button.jsx-4237973997.right");
	By writereview=By.cssSelector("#top-page > div.jsx-4237973997 > div.jsx-4237973997.ap-accord > form > div.jsx-4237973997.ap-section2 > textarea");
	By nextstep3=By.cssSelector("#top-page > div.jsx-4237973997 > div.jsx-4237973997.ap-accord > form > div.jsx-4237973997.ap-btn-next > input");
	
	//step4
	By matauang=By.cssSelector("#react-select-5--value > div.Select-value");
	By price=By.cssSelector("#top-page > div.jsx-2147195116 > div.jsx-2147195116.ap-accord > form > div.jsx-2147195116.ap-section2 > div:nth-child(2) > input[type='text']");
	By descr=By.cssSelector("#top-page > div.jsx-2147195116 > div.jsx-2147195116.ap-accord > form > div.jsx-2147195116.ap-section2 > textarea");
	By producttags=By.cssSelector("#react-select-6--value > div.Select-placeholder");
	By submit=By.cssSelector("#top-page > div.jsx-2147195116 > div.jsx-2147195116.ap-accord > form > div.jsx-2147195116.ap-btn-next > input");
	
	//header label
	By header1=By.cssSelector("#top-page > div.jsx-434510772 > div.jsx-434510772.ap-title > span");
	By header2=By.cssSelector("#top-page > div.jsx-573540586 > div.jsx-573540586.ap-title > span");
	By header3=By.cssSelector("#top-page > div.jsx-4237973997 > div.jsx-4237973997.ap-title > span");

	
	public addproductpage(RemoteWebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
	
	//=================================STEP 1======================================//
	
	public WebElement clickUploadPhoto(){
		
		return driver.findElement(uploadphoto);
	}
	
	public WebElement insertUrl(){
		
		return driver.findElement(inserturlphoto);
	}
	
	public WebElement findCropArea(){
		
		return driver.findElement(croparea);
	}
	
	
	public WebElement cropPicture(){
		
		return driver.findElement(crop);
	}
	
	public WebElement clickShowLinkImage(){
		
		return driver.findElement(show);
	}
	
	public WebElement nextStep1(){
		
		return driver.findElement(nextstep1);
	}
	
	//=================================STEP 2======================================//
	
	public WebElement selectBrand(){
		
		return driver.findElement(brandname);
	}
	
	public WebElement selectProductCat(){
		
		return driver.findElement(productcat);
	}
	
	public WebElement insertProductSubCat(){
		
		return driver.findElement(productsubcat);
	}
	
	public WebElement insertProductName(){
		
		return driver.findElement(productname);
	}
	
	public WebElement insertProductShade(){
		
		return driver.findElement(productshade);
	}
	
	public WebElement nextStep2(){
		
		return driver.findElement(nextstep2);
	}
	
	//=================================STEP 3======================================//
	
	public WebElement chooseRating(){
		
		return driver.findElement(rating);
	}
	
	public WebElement choosePackagequality(){
		
		return driver.findElement(packagequality);
	}
	
	public WebElement chooseRepurchase(){
		
		return driver.findElement(repurchase);
	}
	
	public WebElement inputWritereview(){
		
		return driver.findElement(writereview);
	}
	
	public WebElement nextStep3(){
		
		return driver.findElement(nextstep3);
	}
	
	//=================================STEP 4======================================//
	
	public WebElement selectCurency(){
		
		return driver.findElement(matauang);
	}
	
	public WebElement inputPrice(){
		
		return driver.findElement(price);
	}
	
	public WebElement inputDescription(){
		
		return driver.findElement(descr);
	}
	
	public WebElement inputTags(){
		
		return driver.findElement(producttags);
	}
	
	public WebElement clickSubmit(){
		
		return driver.findElement(submit);
	}
	
	//=================================edit step======================================//
	
	public WebElement editStep1(){
		
		return driver.findElement(header1);
	}
	
	public WebElement editStep2(){
		
		return driver.findElement(header2);
	}
	
	public WebElement editStep3(){
		
		return driver.findElement(header3);
	}
	
}
