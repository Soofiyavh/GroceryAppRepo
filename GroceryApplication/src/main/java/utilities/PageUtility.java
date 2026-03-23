package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	public void dropDownVisibleText(WebElement element,String text)
	{
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	
	public void dropDownIndex(WebElement element,int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	public void dropDownValue(WebElement element,String value)
	{
		Select select=new Select(element);
		select.selectByValue(value);
	}
	
	public void javascriptexecuterForClick(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public void javascriptexecuterForSendkeys(WebDriver driver,WebElement element,String value)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='value';",element);
	}
	
	public void actionRightClick(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
	}
	
	public void actionMoveToElement(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	public void actionClick(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.click(element).perform();
	}
	
	public void actionDoubeClick(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();
	}
	
	public void actionDragAndDrop(WebDriver driver,WebElement drag,WebElement drop)
	{
		Actions action=new Actions(driver);
		action.dragAndDrop(drag, drop).perform();
	}
	
	public void alertSimpleAlert(WebDriver driver)
	{
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	
	public void alertConfirmationAlertAccept (WebDriver driver)
	{
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	
	public void alertConfirmationAlertDismiss(WebDriver driver)
	{
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
	}
	
	
	public void alertPromptAlertaccept(WebDriver driver)
	{
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	
	public void alertPromptAlertDismiss(WebDriver driver)
	{
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
	}
	
	public void alertPromptAlertSendKeys(WebDriver driver,String text)
	{
		Alert alert=driver.switchTo().alert();
		alert.sendKeys(text);
	}
}
