package pages;

import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;

public class ManageCategoryPage {

public WebDriver driver;
	
	//@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']")WebElement moreinfo;
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newbutton;
	@FindBy(xpath="//input[@id='category']")WebElement categoryfield;
	@FindBy(xpath="//li[@id='134-selectable']")WebElement discountfield;
	@FindBy(xpath="//input[@id='main_img']")WebElement choosefile;
	@FindBy(xpath="//button[text()='Save']")WebElement savebutton;
	@FindBy(xpath="//div[contains(@class,'alert-success')]']")WebElement alert;
	
	public ManageCategoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	
//	public void clickOnManageCetegoryMoreInfo()
//	{
//		moreinfo.click();
//	}
	
	public ManageCategoryPage clickOnManageCategoryNewButton()
	{
		newbutton.click();
		return this;
	}
	
	public ManageCategoryPage enterTheCategory(String category)
	{
		categoryfield.sendKeys(category);
		return this;	
	}
	
	public ManageCategoryPage clickOnDiscount()
	{
		discountfield.click();
		return this;
	}
	
	public ManageCategoryPage chooseFile() throws AWTException
	{
		FileUploadUtility fileuploadutility=new FileUploadUtility();
		fileuploadutility.fileUploadUsingSendkeys(choosefile,Constant.CATEGORYIMAGE);
		return this;
	}
	
	public ManageCategoryPage clickOnSave()
	{
		//savebutton.click();
		PageUtility pageutility=new PageUtility();
		pageutility.javascriptexecuterForClick(driver, savebutton);
		return this;
	}
	
	
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
}
