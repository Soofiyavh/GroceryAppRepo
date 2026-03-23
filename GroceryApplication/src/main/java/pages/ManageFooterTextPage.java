package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterTextPage {
	
	public WebDriver driver;

//	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and @class='small-box-footer']")WebElement moreinfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1']")WebElement editbutton;
	@FindBy(xpath="//textarea[@name='address']")WebElement adressfield;
	@FindBy(xpath="//input[@id='email']")WebElement emailfield;
	@FindBy(xpath="//input[@id='phone']")WebElement phonefield;
	@FindBy(xpath="//button[@name='Update']")WebElement updatebutton;
	@FindBy(xpath="//div[contains(@class,'alert-success')]")WebElement alert;
	
	public ManageFooterTextPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	
//	public void clickOnManageFooterTexttMoreInfo()
//	{
//		moreinfo.click();
//	}
	
	public ManageFooterTextPage clickOnEditButton()
	{
		editbutton.click();
		return this;
	}
	
	public ManageFooterTextPage updateAdress(String adress)
	{
		adressfield.clear();
		adressfield.sendKeys(adress);
		return this;
	}
	
	public ManageFooterTextPage updateEmail(String email)
	{
		emailfield.clear();
		emailfield.sendKeys(email);
		return this;
	}
		
	public ManageFooterTextPage updatePhone(String phone)
	{
		phonefield.clear();
		phonefield.sendKeys(phone);
		return this;
	}
	
	public ManageFooterTextPage clickOnUpdate()
	{
		updatebutton.click();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", updatebutton);
		return this;
	}
	
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
}
