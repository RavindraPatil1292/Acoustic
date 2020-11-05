package pom_HomePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseClass;

public class LoginPage extends BaseClass{

	@FindBy(xpath="//input[@id='userName']")
	WebElement userName;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginButton;
	
	public LoginPage() {
		PageFactory.initElements(factory, this);
	}
	
	public void login() {
		type(userName, urlPropertyFile.getProp("username"));
		type(password, urlPropertyFile.getProp("password"));
		click(loginButton);
	}
}
