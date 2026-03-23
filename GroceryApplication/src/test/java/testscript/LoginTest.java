package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {

	public HomePage homepage;
	
	@Test(description = "Verify whether the user is able to login successfully")
	public void verifyTheUserIsAbleToLoginUsingValidCredentials() throws IOException {
		// String username="admin";
		// String password="admin";
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		//loginpage.enterThePassword(password);
		homepage=loginpage.clickOnSignInButton();
		boolean homepage = loginpage.isDashboardDisplayed();
		Assert.assertTrue(homepage,Constant.LOGINWITHVALIDUSERNAMEANDPASSWORD);
	}

	@Test(description = "verify if the user can login with valid username and invalid password")
	public void verifyTheUserIsAbleToLoginUsingValidUsernameAndInvalidPassword() throws IOException {
		// String username="admin";
		// String password="admin12";

		String username = ExcelUtility.readStringData(2, 0, "LoginPage");
		String password = ExcelUtility.readStringData(2, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		//loginpage.enterThePassword(password);
		homepage=loginpage.clickOnSignInButton();

		boolean alert = loginpage.isAlertDisplayed();
		Assert.assertTrue(alert, Constant.LOGINWITHINVALIDPASSWORD);// this meessage prints when testcase fails means homepge
																	// loaded with incorrect pswd
	}

	@Test(description = "verify if the user can login with invalid username and valid password")
	public void verifyTheUserIsAbleToLoginUsingInvalidUsernameAndValidPassword() throws IOException {
		// String username="admin123564";
		// String password="admin";

		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		//loginpage.enterThePassword(password);
		homepage=loginpage.clickOnSignInButton();

		boolean alert = loginpage.isAlertDisplayed();
		Assert.assertTrue(alert, Constant.LOGINWITHINVALIDUSERNAME);// this meessage prints when testcase fails means hp
																	// loaded with incorrect username
	}

	@Test(description = "verify if the user can login with invalid username and invalid password")
	public void verifyTheUserIsAbleToLoginUsingInvalidUsernameAndInvalidPassword() throws IOException {
		// String username="admin1456";
		// String password="admin13";

		String username = ExcelUtility.readStringData(4, 0, "LoginPage");
		String password = ExcelUtility.readStringData(4, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		//loginpage.enterThePassword(password);
		homepage=loginpage.clickOnSignInButton();

		boolean alert = loginpage.isAlertDisplayed();
		Assert.assertTrue(alert, Constant.LOGINWITHINVALIDUSERNAMEANDPASSWORD);// this message prints when hompage is
																				// loaded with invalid usernameand paswd
	}
}
