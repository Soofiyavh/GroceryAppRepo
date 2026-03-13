package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base{

	@Test
	public void verifyTheUserIsAbleToLoginUsingValidCredentials() throws IOException
	{
		//String username="admin";
		//String password="admin";
		String username=ExcelUtility.readStringData(1, 0, "LoginPage");
		String password=ExcelUtility.readStringData(1, 1, "LoginPage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickOnSignInButton();
		boolean homepage=loginpage.isDashboardDisplayed();
		Assert.assertTrue(homepage);
	}
	
	@Test
	public void verifyTheUserIsAbleToLoginUsingValidUsernameAndInvalidPassword() throws IOException
	{
		//String username="admin";
		//String password="admin12";
		
		String username=ExcelUtility.readStringData(2, 0, "LoginPage");
		String password=ExcelUtility.readStringData(2, 1, "LoginPage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickOnSignInButton();
		
		boolean alert=loginpage.isAlertDisplayed();
		Assert.assertTrue(alert);
	}
	
	@Test
	public void verifyTheUserIsAbleToLoginUsingInvalidUsernameAndValidPassword() throws IOException
	{
		//String username="admin123564";
		//String password="admin";
		
		String username=ExcelUtility.readStringData(3, 0, "LoginPage");
		String password=ExcelUtility.readStringData(3, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickOnSignInButton();
		
		boolean alert=loginpage.isAlertDisplayed();
		Assert.assertTrue(alert);
	}
	
	@Test
	public void verifyTheUserIsAbleToLoginUsingInvalidUsernameAndInvalidPassword() throws IOException
	{
		//String username="admin1456";
		//String password="admin13";
		
		String username=ExcelUtility.readStringData(4, 0, "LoginPage");
		String password=ExcelUtility.readStringData(4, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickOnSignInButton();
		
		boolean alert=loginpage.isAlertDisplayed();
		Assert.assertTrue(alert);
	}
}
