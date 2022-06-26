package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.BaseClass1;

public class EnterTimeTrack_PO extends BaseClass1{
	public EnterTimeTrack_PO(WebDriver driver) throws IOException {
		this.driver = driver;
	}
	
	@FindBy(xpath="//*[text()='Enter Time-Track for']")
	private WebElement enterTimeTrack_Header;
	
	@FindBy(linkText="Logout")
//	@FindBys({
//		@FindBy(id="books-wrapper"),
//		@FindBy(xpath="userName-value")
//	})
	private WebElement logoutLink;
	
	@FindBy(xpath="//a[div[text()='Tasks']]")
	private WebElement tasks_HeaderLink;

	public WebElement getEnterTimeTrack_Header() {
		return enterTimeTrack_Header;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public WebElement getTasks_HeaderLink() {
		return tasks_HeaderLink;
	}
	
}
