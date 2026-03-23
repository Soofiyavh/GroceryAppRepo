package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AdminUsersPage {

	public WebDriver driver;
	
	//@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement moreinfo;
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newbutton;
	@FindBy(xpath="//input[@name='username']")WebElement usernamefield;
	@FindBy(xpath="//input[@name='password']")WebElement passwordfield;
	@FindBy(xpath="//select[@name='user_type']")WebElement usertypefield;
	@FindBy(xpath="//button[@name='Create']")WebElement save;
	@FindBy(xpath="//div[contains(@class,'alert-success')]")WebElement alert;
	
	public AdminUsersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	
//	public void clickOAdminUsersnMoreInfo()
//	{
//		moreinfo.click();
//	}
//	
	public AdminUsersPage clickOnAdminUsersNewButton()
	{
		newbutton.click();
		return this;
	}
	
	public AdminUsersPage enterUsername(String username)
	{
		usernamefield.sendKeys(username);
		return this;
	}
	
	public AdminUsersPage enterPassword(String password)
	{
		passwordfield.sendKeys(password);
		return this;
	}
	
	public AdminUsersPage selectUserType()
	{
		PageUtility pageutility=new PageUtility();
		pageutility.dropDownVisibleText(usertypefield, "Staff");
		return this;
	}
	
	public AdminUsersPage clickOnSave()
	{
		save.click();
		return this;
	}
	
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
	
}
