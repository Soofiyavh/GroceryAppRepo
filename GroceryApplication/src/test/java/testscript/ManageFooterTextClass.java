package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtility;

public class ManageFooterTextClass extends Base {

	public HomePage homepage;
	public ManageFooterTextPage managefootertextpage;
	
	@Test(description = "Verify if the user can update footer text informations")
	public void verifyTheUserIsAbleToUpdateContactDetailsAndDisplaysAlert() throws IOException, AWTException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		String adress = ExcelUtility.readStringData(0, 0, "ManageFooterText");
		String email = ExcelUtility.readStringData(1, 0, "ManageFooterText");
		//String phone = ExcelUtility.readIntegerData(2, 0, "ManageFooterText");//in case no need to uodae phone number

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		//loginpage.enterThePassword(password);
		homepage=loginpage.clickOnSignInButton();

		//ManageFooterTextPage managefootertextpage = new ManageFooterTextPage(driver);
		managefootertextpage=homepage.clickOnManageFooterTexttMoreInfo();
		managefootertextpage.clickOnEditButton().updateAdress(adress).updateEmail(email).clickOnUpdate();
//		managefootertextpage.updateAdress(adress);
//		managefootertextpage.updateEmail(email);
//		//managefootertextpage.updatePhone(phone);
//		managefootertextpage.clickOnUpdate();
		boolean successalert = managefootertextpage.isAlertDisplayed();
		Assert.assertTrue(successalert,Constant.UPDATINGFOOTERTEXTINFORMATIONS);
	}
}
