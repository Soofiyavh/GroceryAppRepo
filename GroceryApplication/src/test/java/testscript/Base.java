package testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import utilities.ScreenShotUtility;
import utilities.WaitUtility;

public class Base {

	public WebDriver driver;
	public Properties properties;
	public FileInputStream fileinputstream;

	@BeforeMethod(description = "Url launching for testing", alwaysRun = true)
	@Parameters("browser") // name of parameter and its value assigns to this browser eg:browser=Chrome
	public void browserInitialization(String browser) throws Exception {
		try {
			properties = new Properties();//object of properties class
			fileinputstream = new FileInputStream(Constant.CONFIGFILE);//this object has path of config file
			properties.load(fileinputstream);//loaded that path to properts clss
		}
		catch (Exception e) {
			System.out.println(e);  //prints the name of exception which occured
		}
		
		if (browser.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver(); // opens the chrome browser
		} else if (browser.equalsIgnoreCase("Edge")) 
		{
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("Firefox"))
		{
			driver = new FirefoxDriver();
		} else
		{
			throw new Exception("invalid");
		}

		//driver.get("https://groceryapp.uniqassosiates.com/admin"); // opens the given url
		driver.get(properties.getProperty("url"));//url is the key in the config file
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICITWAIT));// implicit wait
																								// implementation

		driver.manage().window().maximize(); // used to maximize the window

	}

	 @AfterMethod(description="Closes and quit process after testing",alwaysRun=true)
	public void browserQuitAndClose(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == iTestResult.FAILURE) {
			ScreenShotUtility screenshot = new ScreenShotUtility();
			screenshot.getScreenShot(driver, iTestResult.getName()); // method to take srrenshot of failed testcases
																		// before browser close
		}

		driver.quit();
	}

}
