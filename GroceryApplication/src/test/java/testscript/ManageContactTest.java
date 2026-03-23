package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageContactTest extends Base {

	public HomePage homepage;
	public ManageContactPage managecontactpage;
	
	@Test(description = "Verify if the user can update contact details]",groups="regression")
	public void verifyTheUserIsAbleToUpdateContactDetailsAndDisplaysAlert() throws IOException, AWTException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		String phone = ExcelUtility.readIntegerData(0, 0, "ManageContact");//these two fields are going to update
		String email = ExcelUtility.readStringData(1, 0, "ManageContact");
//		String adress = ExcelUtility.readStringData(2, 0, "ManageContact");
//		String deltime = ExcelUtility.readIntegerData(3, 0, "ManageContact");
//		String dellimit = ExcelUtility.readIntegerData(4, 0, "ManageContact");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		//loginpage.enterThePassword(password);
		homepage=loginpage.clickOnSignInButton();
		
		//ManageContactPage managecontactpage = new ManageContactPage(driver);
		
		managecontactpage=homepage.clickOnManageContactMoreInfo();
		managecontactpage.clickOnEditButton().updatePhone(phone).updateEmail(email).clickOnUpdate();
//		managecontactpage.updatePhone(phone);
//		managecontactpage.updateEmail(email);
//		managecontactpage.updateAdress(adress);
//		managecontactpage.updateDeliveryTime(deltime);
//		managecontactpage.updateDeliveryLimit(dellimit);
//		managecontactpage.clickOnUpdate();
		boolean successalert = managecontactpage.isAlertDisplayed();
		Assert.assertTrue(successalert,Constant.UPDATINGCONTACTUSINFORMATIONS);
	}
}
