package pom_HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import baseClass.BaseClass;

public class HomePage extends BaseClass{
	/*@FindBy(xpath="//div[@class='ui-select-region-asia']")
	WebElement regionAsia;
	
	@FindBy(xpath="//div[@class='ui-select-region-NAmerica']")
	WebElement regionNorthAmerica;
	
	@FindBy(xpath="//div[@class='ui-select-region-africa']")
	WebElement regionAfrica;
	
	@FindBy(xpath="//div[@class='ui-select-region-SAmerica']")
	WebElement regionSouthAmerica;
	
	@FindBy(xpath="//div[@class='ui-select-region-europe']")
	WebElement regionEurope;
	*/
	WebElement reg;
	String parentWindow;
	
	@FindBy(xpath="//button[contains(text(),'Photos')]")
	WebElement photos;
	@FindBy(xpath="//button[contains(text(),'Tourist Places')]")
	WebElement touristPlaces;
	
	@FindBy(xpath="//div[@class='alert-custom']")
	WebElement error;
	
	public HomePage() {
		PageFactory.initElements(factory, this);
		parentWindow = driver.getWindowHandle();
	}

	public void selectRegion(String region) { 
		reg = driver.findElement(By.xpath("//div[@class='ui-select-region-"+region+"']"));
		click(reg);
	}
	
	public void selectCountry(String country) {
		Select sel = new Select(reg);
		sel.selectByVisibleText(country);
	}
	
	public String viewPhotos() {
		click(photos);
		return driver.getTitle();
		
	}
	public String viewTouristPlaces() {
		click(touristPlaces);
		return driver.getTitle();	
	}
	
	public void verifyErrorExist() {
		error.isDisplayed();
	}
	
	public void switchToDefault() {
		driver.switchTo().window(parentWindow);
	}
}
