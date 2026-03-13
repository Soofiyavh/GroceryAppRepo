package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AdminUsersPage {

	public WebDriver driver;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement moreinfo;
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newbutton;
	@FindBy(xpath="//input[@name='username']")WebElement usernamefield;
	@FindBy(xpath="//input[@name='password']")WebElement passwordfield;
	@FindBy(xpath="//select[@name='user_type']")WebElement usertypefield;
	@FindBy(xpath="//button[@name='Create']")WebElement save;
	@FindBy(xpath="//h5[contains(text(),'ert!')]")WebElement alert;
	
	public AdminUsersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	
	public void clickOnMoreInfo()
	{
		moreinfo.click();
	}
	
	public void clickOnNewButton()
	{
		newbutton.click();
	}
	
	public void enterUsername(String username)
	{
		usernamefield.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		passwordfield.sendKeys(password);
	}
	
	public void selectUserType(String usertype)
	{
		PageUtility pageutility=new PageUtility();
		pageutility.dropDownVisibleText(usertypefield, usertype);
	}
	
	public void clickOnSave()
	{
		save.click();
	}
	
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
	
}
