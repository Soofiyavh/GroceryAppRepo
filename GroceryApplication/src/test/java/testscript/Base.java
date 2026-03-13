package testscript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class Base {

public WebDriver driver;
	
	@BeforeMethod
	public void browserInitialization()
	{
		driver=new ChromeDriver();        //opens the chrome browser
		driver.get("https://groceryapp.uniqassosiates.com/admin");   //opens the given url
		driver.manage().window().maximize();       //used to maximize the window
		
	}

	//@AfterMethod
	public void browserQuit()
	{
		//driver.close();       //closes current browser window
		driver.quit();        //closes all the browser windows
		
	}
	
}
