package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageCategoryTest extends Base {

	public HomePage homepage;
	public ManageCategoryPage managecategorypage;
	
	@Test(description = "Verify if the user can add new category  details",retryAnalyzer=retry.Retry.class)
	public void verifyTheUserIsAbleToAddNewCategoryAndDisplaysAlert() throws IOException, AWTException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		// String category = ExcelUtility.readStringData(0, 0, "AddCategory");//faker
		// utilty used to create new category name for next execution

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		//loginpage.enterThePassword(password);
		homepage=loginpage.clickOnSignInButton();

		//ManageCategoryPage managecategorypage = new ManageCategoryPage(driver);
		FakerUtility fakerutility = new FakerUtility();
		String category = fakerutility.createRandomFirstName();
		
		managecategorypage=homepage.clickOnManageCetegoryMoreInfo();
		managecategorypage.clickOnManageCategoryNewButton().enterTheCategory(category).clickOnDiscount().chooseFile().clickOnSave();
//		managecategorypage.enterTheCategory(category);
//		managecategorypage.clickOnDiscount();
//		managecategorypage.chooseFile();
//		managecategorypage.clickOnSave();
		boolean successalert = managecategorypage.isAlertDisplayed();
		Assert.assertTrue(successalert, Constant.ADDINGCATEGORIESTOCATEGORYLIST);
	}
}
