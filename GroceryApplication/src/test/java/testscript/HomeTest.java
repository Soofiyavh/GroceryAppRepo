package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.HomePage;
import utilities.ExcelUtility;

public class HomeTest extends Base {

	public HomePage homepage;
	
	@Test(description = "Verify if the user can logout successfully")
	public void verifyTheUserIsAbleToLogoutSuccessfully() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		//loginpage.enterThePassword(password);
		homepage=loginpage.clickOnSignInButton();
		
		//HomePage homepage = new HomePage(driver);
		homepage.clickOnAdminIcon();
		loginpage=homepage.clickOnLogout();
		
		boolean loginpagelogout = homepage.isSighnButtonDisplayed();
		Assert.assertTrue(loginpagelogout,Constant.LOGOUT);

	}
}
