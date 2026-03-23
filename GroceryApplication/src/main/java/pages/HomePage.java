package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;
	//with page factory
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")WebElement managenewsmoreinfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']")WebElement managecategorymoreinfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class='small-box-footer']")WebElement managecontactmoreinfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and @class='small-box-footer']")WebElement managefootertextmoreinfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement adminusersmoreinfo;
	
	
	@FindBy(xpath="//a[@data-toggle='dropdown']")WebElement adminicon;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/logout' and @class='dropdown-item']")WebElement logouticon;
	@FindBy(xpath="//button[text()='Sign In']")WebElement signin;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public AdminUsersPage clickOAdminUsersnMoreInfo()
	{
		adminusersmoreinfo.click();
		return new AdminUsersPage(driver);
	}
	public ManageNewsPage clickOnManageNewsMoreInfo()
	{
		managenewsmoreinfo.click();
		return new ManageNewsPage(driver);
	}
	public ManageCategoryPage clickOnManageCetegoryMoreInfo()
	{
		managecategorymoreinfo.click();
		return new ManageCategoryPage(driver);
	}
	
	public ManageContactPage clickOnManageContactMoreInfo()
	{
		managecontactmoreinfo.click();
		return new ManageContactPage(driver);
	}
	public ManageFooterTextPage clickOnManageFooterTexttMoreInfo()
	{
		managefootertextmoreinfo.click();
		return new ManageFooterTextPage(driver);
	}
	
	
	
	public HomePage clickOnAdminIcon()
	{
		adminicon.click();
		return this;
	}
	
	public LoginPage clickOnLogout()
	{
		logouticon.click();
		return new LoginPage(driver);
	}
	
	public boolean isSighnButtonDisplayed()
	{
		return signin.isDisplayed(); 
		
	}
	
}
