package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.BaseClass1;

public class Tasks_PO extends BaseClass1 {
	public Tasks_PO(WebDriver driver) throws IOException {
		this.driver = driver;
	}

	@FindBy(xpath = "//div[text()='Add New']")
	private By addNew_CustomerProject_Button_BY;

	@FindBy(xpath = "//div[text()='Add New']")
	private WebElement addNew_CustomerProject_Button;

	@FindBy(xpath = "(//div[@class='itemsContainer'])[1]//div[contains(@class,'customerNode')][position()=1]//div[@class='text']")
	private WebElement firstCustomer_Link;
	
	@FindBy(xpath = "(//div[@class='itemsContainer'])[1]//div[contains(@class,'customerNode')][position()=2]/preceding-sibling::div[contains(@class,'projectNode')]//div[@class='text']")
	private List<WebElement> projectsUnderfirstCustomer_Link;
	
	@FindBy(xpath = "(//table[@class='taskRowsTable']//tr[contains(@class,'taskRow')])[last()]")
	private WebElement lastTaskUnderTasksTable_Link;
	
	@FindBy(xpath = "//table[@class='taskRowsTable']//tr[contains(@class,'taskRow')]")
	private List<WebElement> allTasksUnderTasksTable_Link;
	
	@FindBy(xpath = "//div[contains(text(),'New Tasks')]")
	private By newTasksUnder_AddNew_Link_BY;
	
	@FindBy(xpath = "//div[contains(text(),'New Tasks')]")
	private WebElement newTasksUnder_AddNew_Link;
	
	@FindBy(xpath = "//div[contains(text(),'Create New Tasks')]")
	private WebElement createNewTask_underPOPUP_header_BY;
	
	@FindBy(xpath = "(//div[@class='comboboxButton'])[1]//div[@class='dropdownButton']")
	private WebElement customerDropDownButton_underPOPUP_DropButton;
	
	@FindBy(xpath = "(//div[@class='searchItemList'][div[contains(text(),'New Customer')]]//div[contains(@class,'cpItemRow')][position()=1]")
	private By firstCompany_underCustomerDropDown_underPOPUP_DropDrop_BY;
	
	@FindBy(xpath = "//div[@class='searchItemList'][div[contains(text(),'New Customer')]]//div[contains(@class,'cpItemRow')][position()=1]")
	private WebElement firstCompany_underCustomerDropDown_underPOPUP_DropDrop;
	
	@FindBy(xpath = "(//div[@class='comboboxButton'])[2]//div[@class='dropdownButton']")
	private By projectDropDownButton_underPOPUP_DropButton_BY;
	
	@FindBy(xpath = "(//div[@class='comboboxButton'])[2]//div[@class='dropdownButton']")
	private WebElement projectDropDownButton_underPOPUP_DropButton;
	
	@FindBy(xpath = "//div[@class='searchItemList'][div[contains(text(),'New Project')]]//div[contains(@class,'cpItemRow')][position()=1]")
	private By firstProject_underCustomerDropDown_underPOPUP_DropDrop_BY;
	
	@FindBy(xpath = "//div[@class='searchItemList'][div[contains(text(),'New Project')]]//div[contains(@class,'cpItemRow')][position()=1]")
	private WebElement firstProject_underCustomerDropDown_underPOPUP_DropDrop;
	
	@FindBy(xpath = "(//td[@class='nameCell first'])[1]//input")
	private WebElement enterFirstTask_underPOPUP_NewTasksTable_TextArea;
	
	@FindBy(xpath = "//div[text()='Create Tasks']")
	private WebElement createTasks_underPOPUP_Button;
	
	@FindBy(xpath = "//span[@class='innerHtml' and contains(text(),'created')]")
	private By createdMessagePopup_Text_BY;
	
	@FindBy(xpath = "//span[@class='innerHtml' and contains(text(),'created')]")
	private WebElement createdMessagePopup_Text;

	public By getAddNew_CustomerProject_Button_BY() {
		return addNew_CustomerProject_Button_BY;
	}

	public WebElement getAddNew_CustomerProject_Button() {
		return addNew_CustomerProject_Button;
	}

	public WebElement getFirstCustomer_Link() {
		return firstCustomer_Link;
	}

	public List<WebElement> getProjectsUnderfirstCustomer_Link() {
		return projectsUnderfirstCustomer_Link;
	}

	public WebElement getLastTaskUnderTasksTable_Link() {
		return lastTaskUnderTasksTable_Link;
	}

	public List<WebElement> getAllTasksUnderTasksTable_Link() {
		return allTasksUnderTasksTable_Link;
	}

	public By getNewTasksUnder_AddNew_Link_BY() {
		return newTasksUnder_AddNew_Link_BY;
	}

	public WebElement getNewTasksUnder_AddNew_Link() {
		return newTasksUnder_AddNew_Link;
	}

	public WebElement getCreateNewTask_underPOPUP_header() {
		return createNewTask_underPOPUP_header_BY;
	}

	public WebElement getCustomerDropDownButton_underPOPUP_DropButton() {
		return customerDropDownButton_underPOPUP_DropButton;
	}

	public By getFirstCompany_underCustomerDropDown_underPOPUP_DropDrop_BY() {
		return firstCompany_underCustomerDropDown_underPOPUP_DropDrop_BY;
	}

	public WebElement getFirstCompany_underCustomerDropDown_underPOPUP_DropDrop() {
		return firstCompany_underCustomerDropDown_underPOPUP_DropDrop;
	}

	public By getProjectDropDownButton_underPOPUP_DropButton_BY() {
		return projectDropDownButton_underPOPUP_DropButton_BY;
	}

	public WebElement getProjectDropDownButton_underPOPUP_DropButton() {
		return projectDropDownButton_underPOPUP_DropButton;
	}

	public By getFirstProject_underCustomerDropDown_underPOPUP_DropDrop_BY() {
		return firstProject_underCustomerDropDown_underPOPUP_DropDrop_BY;
	}

	public WebElement getFirstProject_underCustomerDropDown_underPOPUP_DropDrop() {
		return firstProject_underCustomerDropDown_underPOPUP_DropDrop;
	}

	public WebElement getEnterFirstTask_underPOPUP_NewTasksTable_TextArea() {
		return enterFirstTask_underPOPUP_NewTasksTable_TextArea;
	}

	public WebElement getCreateTasks_underPOPUP_Button() {
		return createTasks_underPOPUP_Button;
	}

	public By getCreatedMessagePopup_Text_BY() {
		return createdMessagePopup_Text_BY;
	}

	public WebElement getCreatedMessagePopup_Text() {
		return createdMessagePopup_Text;
	}

}
