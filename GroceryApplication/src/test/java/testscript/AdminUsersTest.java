package testscript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base {

	public HomePage homepage;
	public AdminUsersPage adminuserspage;
	
	@Test(description = "verify a user can able to add new adminusers informations successfully",retryAnalyzer=retry.Retry.class)
	public void verifyTheUserIsAbleToAddAdminUsersInformationsAndDisplaysAlert() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
//		String adminusername = ExcelUtility.readStringData(1, 0, "AdminUsers");
//		String adminpassword = ExcelUtility.readStringData(1, 1, "AdminUsers");
		String usertype = ExcelUtility.readStringData(3, 0, "AdminUsers");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		//loginpage.enterThePassword(password);
		homepage=loginpage.clickOnSignInButton();
		
		//AdminUsersPage adminuserspage = new AdminUsersPage(driver); //driver is passing alreday in adminuserspage
		FakerUtility fakerutility=new FakerUtility();
		String adminusername=fakerutility.createRandomFirstName();
		String adminpassword=fakerutility.createRandomLastName();
		
		adminuserspage=homepage.clickOAdminUsersnMoreInfo();//clicking adminusersmoreinfor goes to adminusersoage
		adminuserspage.clickOnAdminUsersNewButton().enterUsername(adminusername).enterPassword(adminpassword).selectUserType().clickOnSave();
//		adminuserspage.enterUsername(adminusername);
//		adminuserspage.enterPassword(adminpassword);
//		adminuserspage.selectUserType();
//		adminuserspage.clickOnSave();
		boolean successalert = adminuserspage.isAlertDisplayed();
		Assert.assertTrue(successalert,Constant.ADDINGADMINUSERSINFORMATIONS);
	}
}
