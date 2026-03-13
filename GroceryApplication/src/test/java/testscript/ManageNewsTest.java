package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base{

	@Test
	public void verifyTheUserIsAbleToAddNewNewsAndDisplaysAlert() throws IOException
	{
		String username=ExcelUtility.readStringData(1, 0, "LoginPage");
		String password=ExcelUtility.readStringData(1, 1, "LoginPage");
		String news=ExcelUtility.readStringData(0, 0, "ManageNews");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickOnSignInButton();
		
		ManageNewsPage managenewspage=new ManageNewsPage(driver);
		managenewspage.clickOnMoreInfo();
	    managenewspage.clickOnNewButton();
	    managenewspage.enterTheNews(news);
	    managenewspage.clickOnSave();
	    boolean successalert=managenewspage.isAlertDisplayed();
	    Assert.assertTrue(successalert);		
	}
}
