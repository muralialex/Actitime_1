package enter_TimeTrack;

import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dataProviders.DataExcel;
import utilities.BaseClass1;

public class CreateCustomer extends BaseClass1{
	
	@BeforeMethod
	public void setUpTestCase(Method methodName) {
		test= extent.createTest(methodName.getName())
				.assignAuthor("Murali Sukumar").assignCategory("Regression").assignDevice("Windows");
	}
	@BeforeClass
	public void be_in_Tasks() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(enterTimeTrack_PO.getTasks_HeaderLink()));
		enterTimeTrack_PO.getTasks_HeaderLink().click();
	}
	
	@Test (groups= {"Regression","Smoke"}, dataProvider="createTask", dataProviderClass=DataExcel.class)
	public void createTasks(String taskName) throws InterruptedException {
//		test= extent.createTest(new Object(){}.getClass().getEnclosingMethod().getName()).
//				assignAuthor("Ankita").assignCategory("Regression").assignCategory("Smoke").assignDevice("Windows");		
		wait.until(ExpectedConditions.visibilityOf(tasks_PO.getAddNew_CustomerProject_Button()));
//		tasks_PO.getAddNew_CustomerProject_Button().click();
		Assert.assertEquals("Add New", 
				tasks_PO.getAddNew_CustomerProject_Button().getText(), "Home page not displayed after Login");
		
		String firstCompany= tasks_PO.getFirstCustomer_Link().getText();
		List<WebElement> projects_first= tasks_PO.getProjectsUnderfirstCustomer_Link();
		for(WebElement ele:projects_first) {
			System.out.println(ele.getText());
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", tasks_PO.getLastTaskUnderTasksTable_Link());
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", tasks_PO.getLastTaskUnderTasksTable_Link());
		Thread.sleep(2000);
		List<WebElement> tasksCount_first= tasks_PO.getAllTasksUnderTasksTable_Link();
		System.out.println("tasksCount_first.size()==> "+ tasksCount_first.size());
		tasks_PO.getAddNew_CustomerProject_Button().click();
		wait.until(ExpectedConditions.visibilityOf(tasks_PO.getNewTasksUnder_AddNew_Link()));
		tasks_PO.getNewTasksUnder_AddNew_Link().click();
		wait.until(ExpectedConditions.visibilityOf(tasks_PO.getCreateNewTask_underPOPUP_header()));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", tasks_PO.getCustomerDropDownButton_underPOPUP_DropButton());
		
		wait.until(ExpectedConditions.visibilityOf(tasks_PO.getFirstCompany_underCustomerDropDown_underPOPUP_DropDrop()));
		tasks_PO.getFirstCompany_underCustomerDropDown_underPOPUP_DropDrop().click();
		
		wait.until(ExpectedConditions.visibilityOf(tasks_PO.getProjectDropDownButton_underPOPUP_DropButton()));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", tasks_PO.getProjectDropDownButton_underPOPUP_DropButton());
		
		wait.until(ExpectedConditions.visibilityOf(tasks_PO.getFirstProject_underCustomerDropDown_underPOPUP_DropDrop()));
		tasks_PO.getFirstProject_underCustomerDropDown_underPOPUP_DropDrop().click();
		
		Date date = new Date();
        System.out.println(new Timestamp(date.getTime()));
		tasks_PO.getEnterFirstTask_underPOPUP_NewTasksTable_TextArea().sendKeys(taskName+new Timestamp(date.getTime()).toString());
		tasks_PO.getCreateTasks_underPOPUP_Button().click();
		wait.until(ExpectedConditions.visibilityOf(tasks_PO.getCreatedMessagePopup_Text()));
		String successMessage= tasks_PO.getCreatedMessagePopup_Text().getText();
		Assert.assertTrue(successMessage.contains("created"), "Task is not created");
			
	}
}
