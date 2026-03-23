package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class FileUploadUtility {

	public void fileUploadUsingSendkeys(WebElement element,String path)
	{
		element.sendKeys(path);
	}
	
	public void fileUploadUsingRobotClass(WebElement element,String path) throws AWTException
	{
		element.click();
		StringSelection stringselection=new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null); //copy action copies location of pdf to object
		Robot robot =new Robot();             //file upload steps
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_CONTROL);  //action for ctrl v
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
}
