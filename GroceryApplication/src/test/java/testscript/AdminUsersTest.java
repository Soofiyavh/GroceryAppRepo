package testscript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUsersTest extends Base{

	@Test
	public void verifyTheUserIsAbleToAddAdminUsersInformationsAndDisplaysAlert() throws IOException
	{
		String username=ExcelUtility.readStringData(1, 0, "LoginPage");
		String password=ExcelUtility.readStringData(1, 1, "LoginPage");
		String adminusername=ExcelUtility.readStringData(1,0, "AdminUsers");
		String adminpassword=ExcelUtility.readStringData(1, 1, "AdminUsers");
		String usertype=ExcelUtility.readStringData(3,0, "AdminUsers");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickOnSignInButton();
		
		AdminUsersPage adminuserspage=new AdminUsersPage(driver);
		adminuserspage.clickOnMoreInfo();
		adminuserspage.clickOnNewButton();
		adminuserspage.enterUsername(adminusername);
		adminuserspage.enterPassword(adminpassword);
		adminuserspage.selectUserType(usertype);
		adminuserspage.clickOnSave();
	    boolean successalert=adminuserspage.isAlertDisplayed();
	    Assert.assertTrue(successalert);		
	}
}
