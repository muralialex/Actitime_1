package common_tests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.BaseClass1;

public class CommonTest extends BaseClass1{
	@BeforeMethod
	public void setUpTestCase(Method methodName) {
		test= extent.createTest(methodName.getName())
				.assignAuthor("Murali Sukumar").assignCategory("Regression").assignDevice("Windows");
	}
	
	@Test (groups= {"Regression"})
	public void login_ActiTime() throws InterruptedException, IOException {
		if(login_Page.getLogin_button().isDisplayed()==true) {
			System.out.println("We navigated to SignIn Page");
		}
		login_Page.getUsername_tbox().sendKeys(property.getProperty("admin_username"));
		login_Page.getPassword_tbox().sendKeys(property.getProperty("admin_password"));
		login_Page.getKeepLogin_cbox().click();
		login_Page.getLogin_button().click();
//		wait.until(ExpectedConditions.visibilityOf(enterTimeTrack_PO.getEnterTimeTrack_Header()));
		Assert.assertEquals("Enter Time-Track fo r", enterTimeTrack_PO.getEnterTimeTrack_Header().getText());
		if(enterTimeTrack_PO.getEnterTimeTrack_Header().isDisplayed()==true) {
			System.out.println("We navigated to Home Page");
		}
	}
}
