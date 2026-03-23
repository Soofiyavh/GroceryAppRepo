package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageNewsTest extends Base {

	public HomePage homepage;
	public ManageNewsPage managenewspage;
	
	@Test(description = "Verify if the user can add new news in manage news",retryAnalyzer=retry.Retry.class)
	public void verifyTheUserIsAbleToAddNewNewsAndDisplaysAlert() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		//String news = ExcelUtility.readStringData(0, 0, "ManageNews");//fakerutily is used to add new news

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		//loginpage.enterThePassword(password);
		homepage=loginpage.clickOnSignInButton();
		
		
		//ManageNewsPage managenewspage = new ManageNewsPage(driver);
		FakerUtility fakerutility=new FakerUtility();
		String news=fakerutility.createRandomFirstName();
		
		managenewspage=homepage.clickOnManageNewsMoreInfo();
		managenewspage.clickOnManageNewsNewButton().enterTheNews(news).clickOnSave();
//		managenewspage.enterTheNews(news);
//		managenewspage.clickOnSave();
		boolean successalert = managenewspage.isAlertDisplayed();
		Assert.assertTrue(successalert,Constant.ADDINGNEWSTOMANAGENEWS);//this prints if testcase fails
	}
}
