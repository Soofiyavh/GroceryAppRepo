package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageContactPage {
	
	public WebDriver driver;

	//@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class='small-box-footer']")WebElement moreinfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1']")WebElement editbutton;
	@FindBy(xpath="//input[@id='phone']")WebElement phonefield;
	@FindBy(xpath="//input[@id='email']")WebElement emailfield;
	@FindBy(xpath="//textarea[@name='address']")WebElement addressfield;
	@FindBy(xpath="//textarea[@name='del_time']")WebElement deltimefield;
	@FindBy(xpath="//input[@name='del_limit']")WebElement dellimitfield;
	@FindBy(xpath="//button[@name='Update']")WebElement updatebutton;
	@FindBy(xpath="//div[contains(@class,'alert-success')]")WebElement alert;
	
	public ManageContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	
//	public void clickOnManageContactMoreInfo()
//	{
//		moreinfo.click();
//	}
//	
	public ManageContactPage clickOnEditButton()
	{
		editbutton.click();
		return this;
	}
	
	public ManageContactPage updatePhone(String phone)
	{
		phonefield.clear();
		phonefield.sendKeys(phone);
		return this;
	}
	
	public ManageContactPage updateEmail(String email)
	{
		emailfield.clear();
		emailfield.sendKeys(email);
		return this;
	}
	
	public ManageContactPage updateAdress(String adress)
	{
		addressfield.clear();
		addressfield.sendKeys(adress);
		return this;
	}
	
	public ManageContactPage updateDeliveryTime(String deltime)
	{
		deltimefield.clear();
		deltimefield.sendKeys(deltime);
		return this;
	}
	
	public ManageContactPage updateDeliveryLimit(String dellimit)
	{
		dellimitfield.clear();
		dellimitfield.sendKeys(dellimit);
		return this;
	}
	
	public ManageContactPage clickOnUpdate()
	{
		//updatebutton.click();        //not working
		PageUtility pageutility=new PageUtility();
		pageutility.javascriptexecuterForClick(driver, updatebutton);
		return this;		
	}
	
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
	
}
