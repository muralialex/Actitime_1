package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass1;

public class Login_PO extends BaseClass1{
		
	public Login_PO(WebDriver driver) throws IOException {
		this.driver = driver;
	}

	@FindBy(id="username")
	private WebElement username_tbox;
	
	@FindBy(name="pwd")
	private WebElement password_tbox;
	
	@FindBy(id="keepLoggedInCheckBox")
	private WebElement keepLogin_cbox;
	
	@FindBy(id="loginButton")
	private WebElement login_button;

	public WebElement getUsername_tbox() {
		return username_tbox;
	}

	public WebElement getPassword_tbox() {
		return password_tbox;
	}

	public WebElement getKeepLogin_cbox() {
		return keepLogin_cbox;
	}

	public WebElement getLogin_button() {
		return login_button;
	}

	
}
