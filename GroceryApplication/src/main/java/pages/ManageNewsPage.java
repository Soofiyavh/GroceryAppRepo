package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {

public WebDriver driver;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")WebElement moreinfo;
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newbutton;
	@FindBy(xpath="//textarea[@id='news']")WebElement newnews;
	@FindBy(xpath="//button[@type='submit']")WebElement save;
	@FindBy(xpath="//a[@type='button']")WebElement cancel;
	@FindBy(xpath="//h5[contains(text(),'ert!')]")WebElement alert;
	
	public ManageNewsPage(WebDriver driver) {
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
	
	public void enterTheNews(String news)
	{
		newnews.sendKeys(news);
	}
	
	public void clickOnSave()
	{
		save.click();
	}
	
	public void clickOnCancelButton()
	{
		cancel.click();
	}
	
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
}
