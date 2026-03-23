package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	//with page factory
	@FindBy(xpath="//input[@name='username']")WebElement usernamefield;
	@FindBy(xpath="//input[@name='password']")WebElement passwordfield;
	@FindBy(xpath="//button[text()='Sign In']")WebElement signin;
	@FindBy(xpath="//p[text()='Dashboard']")WebElement dashboard;
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")WebElement alert;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public LoginPage enterTheUsername(String username)  //Loginpage means, this method deosn't goes to another page,stays in loginpage
	{													//means classname
		usernamefield.sendKeys(username);
		return this; //returns loginpage itself
	}
	
	public LoginPage enterThePassword(String password)
	{
		passwordfield.sendKeys(password);
		return this;                 //return thismeans,this method doesn't goes to another page.amd stays in the same page.
	}
	
	public HomePage clickOnSignInButton()//goes to homepage when clicking on submit button
	{
		signin.click();
		return new HomePage(driver);
	}
	
	public boolean isDashboardDisplayed()
	{
		return dashboard.isDisplayed(); 
		
	}
	
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
}
