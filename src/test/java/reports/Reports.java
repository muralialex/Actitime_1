package reports;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.BaseClass1;

public class Reports extends BaseClass1{

	@BeforeMethod
	public void setUpTestCase(Method methodName) {
		test= extent.createTest(methodName.getName())
				.assignAuthor("Murali Sukumar").assignAuthor("Chandan")
				.assignCategory("Regression").assignCategory("Sanity")
				.assignDevice("Windows");
	}
	
	@Test(groups= {"Regression","Sanity"})
	public void report() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class='content reports']//div[@id='container_reports']")).click();
		Assert.assertEquals("Reports Dashboard", driver.findElement(By.xpath("//div[text()='Reports Dashboard']")).getText() ,
		"Report dashboard text not displayed");
		driver.findElement(By.xpath("//div[contains(@class, 'components-Dropdown-trigger--1w6PGjU6')]//div//span[2]")).click();
		driver.findElement
		(By.xpath("//li[contains(@class, 'components-SelectableListItem-listItem--1LT4sdPD')]//span//span//span[contains(text(), 'Shortcuts')]")).click();
		Assert.assertEquals("Quick Shortcuts to Reports & Charts", driver.findElement
		(By.xpath("//div[contains(text(), 'Quick Shortcuts to Reports & Charts')]")).getText(), "The text not displayed");
		driver.findElement(By.xpath("//div//div//div//span//span[contains(text(),'Custom Fields Report')]")).click();
		Assert.assertEquals("Custom Fields Report", driver.findElement
		(By.xpath("//div//div[@class='containers-CustomFieldsReport-title--2v110BXG' and contains(text(), 'Custom Fields Report')]")).getText(), "not display text");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div//button//div//span//span[contains(text(), 'All customers & projects')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div//div[3]//label//span[@class='components-TruncatedText-oneLine--Jmk2Gxm5' and text()='Selected']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span//span[contains(text(), 'Big Bang Company')]")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='components-Buttons-text--1m8z0MdM' and contains(text(), 'Apply')]")).click();
		
		
		
		//div[@class='components-GroupedMultiSelector-groupRow--2NJfOTC9']//label//span[contains(@class, 'components-Checkbox-checkbox')]
}
}
