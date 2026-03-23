package testscript;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ScreenShotUtility;
import utilities.WaitUtility;

public class Base {

public WebDriver driver;
	
	@BeforeMethod(description="Url launching for testing",alwaysRun=true)
	@Parameters("browser") //name of parameter and its value assigns to this browser eg:browser=Chrome
	public void browserInitialization(String browser) throws Exception
	{
		if(browser.equalsIgnoreCase("Chrome"))
		{
		driver=new ChromeDriver(); //opens the chrome browser
		}
		else if(browser.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
	        driver=new FirefoxDriver();
		}
		else
		{
			throw new Exception("invalid");
		}
		        
		driver.get("https://groceryapp.uniqassosiates.com/admin");   //opens the given url
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICITWAIT));//implicit wait implementation
				
		driver.manage().window().maximize();       //used to maximize the window
		
	}

	//@AfterMethod(description="Closes and quit process after testing",alwaysRun=true)
	public void browserQuitAndClose(ITestResult iTestResult) throws IOException {
		if(iTestResult.getStatus()==iTestResult.FAILURE) {
			ScreenShotUtility screenshot=new ScreenShotUtility();
			screenshot.getScreenShot(driver, iTestResult.getName()); //method to take srrenshot of failed testcases before browser close
		}
		
		driver.quit();
	}
	
}
