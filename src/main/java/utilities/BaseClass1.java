package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pages.EnterTimeTrack_PO;
import pages.Login_PO;
import pages.Tasks_PO;

public class BaseClass1 {
	public static FileInputStream fis_reader = null;
	public static FileInputStream extent_reader = null;
	public static Properties property = null;
	public static Properties extentProperty = null;
	public static WebDriver driver = null;
	public static Login_PO login_Page= null;
	public static EnterTimeTrack_PO enterTimeTrack_PO= null;
	public static Tasks_PO tasks_PO= null;
	public static WebDriverWait wait= null;
	public static ExtentReports extent = null;
	public static ExtentSparkReporter  spark = null;
	public static ExtentTest test= null;
	public static File screenshot= null;
	public static Date date = new Date();
	public static File file = null;
	public static POIFSFileSystem fs = null;
	public static HSSFWorkbook wb = null;
	public static HSSFSheet sheet = null;
	public static HSSFRow row = null;
	public static HSSFCell cell = null;
	

	@BeforeSuite
	public void initialSetUp() throws IOException {
		fis_reader = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
		extent_reader = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\extent.properties");
		property = new Properties();
		extentProperty = new Properties();
		property.load(fis_reader);
		property.load(extent_reader);
		file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\testData.xls");
		fs = new POIFSFileSystem(new FileInputStream(file));
		wb = new HSSFWorkbook(fs);
	    HSSFRow row;
	    HSSFCell cell;
	    
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver_102.exe");
		driver = new ChromeDriver();
		wait= new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(property.getProperty("URL"));
		driver.manage().window().maximize();
		
	}
	
	@BeforeTest
	public void setUp() throws IOException {
		login_Page= PageFactory.initElements(driver, Login_PO.class);
		enterTimeTrack_PO= PageFactory.initElements(driver, EnterTimeTrack_PO.class);
		tasks_PO= PageFactory.initElements(driver, Tasks_PO.class);
	}
	
	@AfterSuite
	public void closeConnection() throws IOException, InterruptedException {
		Thread.sleep(5000);
		enterTimeTrack_PO.getLogoutLink().click();
		if(login_Page.getLogin_button().isDisplayed()==true) {
			System.out.println("We navigated to SignIn Page");
		}
		driver.close();
		fis_reader.close();
	}
}
