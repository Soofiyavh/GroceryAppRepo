package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;

public class LogoutTest extends Base{

	@Test
	public void verifyTheUserIsAbleToAddAdminUsersInformationsAndDisplaysAlert() throws IOException
	{
		String username=ExcelUtility.readStringData(1, 0, "LoginPage");
		String password=ExcelUtility.readStringData(1, 1, "LoginPage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickOnSignInButton();
		
		LogoutPage logout=new LogoutPage(driver);
		logout.clickOnAdminIcon();
		logout.clickOnLogout();
		boolean loginpagelogout=logout.isSighnButtonDisplayed();
		Assert.assertTrue(loginpagelogout);
	    
}
}
