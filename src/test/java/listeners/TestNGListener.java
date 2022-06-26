package listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utilities.BaseClass1;

public class TestNGListener extends BaseClass1 implements ITestListener {
		
	public void onStart(ITestContext context) {
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("target/spark.html");
		extent.setSystemInfo("os", "Windows");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("ActiTime Test Report");
		spark.config().setReportName("Extent Reports");
		extent.attachReporter(spark);
//		context.setAttribute("WebDriver", this.driver);
	}

	public void onFinish(ITestContext context) {
		
		test.info("Executed all Testcases " + context.getName());
		test.info("Passed Tests=> "+context.getPassedTests());
		test.info("Failed Tests=> "+context.getFailedTests());
		test.info("Failed Tests=> "+context.getSkippedTests());
		test.info("Failed Tests %=> "+context.getFailedButWithinSuccessPercentageTests());
		extent.flush();
	}
	
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart=> "+ result.getName());
		test.info(result.getName() + " test is starting.");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess => "+ result.getMethod().getMethodName());
		test.log(Status.PASS," Testcase passed => "+result.getName());
	}

	public void onTestFailure(ITestResult result){
		String screenshotPath = null;
		try {
			screenshotPath = getScreenhot(driver, result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.log(Status.FAIL, result.getThrowable());
		test.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	}

	public void onTestSkipped(ITestResult result) {
		String screenshotPath = null;
		try {
			screenshotPath = getScreenhot(driver, result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.skip("Testcase Skipped => "+result.getName());
		test.skip(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public String getScreenhot(WebDriver driver, ITestResult result) throws IOException {
		String screenshotPath= System.getProperty("user.dir")+"\\src\\main\\resources\\screenshots\\"+ System.currentTimeMillis();
		screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(screenshotPath));
		return screenshotPath;
	}

}
