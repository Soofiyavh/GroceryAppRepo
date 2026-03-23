package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class ManageNewsPage {

public WebDriver driver;
	
	//@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")WebElement managenewsmoreinfo;
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newbutton;
	@FindBy(xpath="//textarea[@id='news']")WebElement newnews;
	@FindBy(xpath="//button[@type='submit']")WebElement save;
	@FindBy(xpath="//a[@type='button']")WebElement cancel;
	@FindBy(xpath="//div[contains(@class,'alert-success')]")WebElement alert;
	
	public ManageNewsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	
//	public void clickOnManageNewsMoreInfo()
//	{
//		managenewsmoreinfo.click();
//	}
	
	public ManageNewsPage clickOnManageNewsNewButton()
	{
		newbutton.click();
		return this;
	}
	
	public ManageNewsPage enterTheNews(String news)
	{
		newnews.sendKeys(news);
		return this;
	}
	
	public ManageNewsPage clickOnSave()
	{
		//WaitUtility waitutility=new WaitUtility();    //explicit wait implementation.not uses for every elemnt. 
		//waitutility.waitForElementToBeClickable(driver, save); //uses for element which takes time to load during runtime
		save.click();
		return this;
	}
	
	public ManageNewsPage clickOnCancelButton()
	{
		cancel.click();
		return this;
	}
	
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
}
