package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver ldriver;
	
	public LoginPage(WebDriver cdriver)
	{
		ldriver=cdriver;
		PageFactory.initElements(ldriver,this);
	}
	
	@FindBy(css=".utility-nav :nth-child(2) > a")
	@CacheLookup
	WebElement loginLink;
	
	@FindBy(id="username")
	@CacheLookup
	WebElement testusername;

	@FindBy(id="loginButton")
	@CacheLookup
	WebElement loginButton;

	@FindBy(id="password")
	@CacheLookup
	WebElement testpassword;

	@FindBy(id="responseMessage")
	@CacheLookup
	WebElement loginMessage;	
	
	
	public void clickLoginLink()
	{
	  loginLink.click();
	}
	
	public void setUserName(String uname)
	{
		testusername.clear();
		testusername.sendKeys(uname);
	}
	
	public void setUserPassword(String pwd)
	{
		testpassword.clear();
		testpassword.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		loginButton.click();
	}
	
	public String errorMessage()
	{
		return "There is no account for the username or email you entered.";
	}
	

}
