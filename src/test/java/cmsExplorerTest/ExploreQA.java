package cmsExplorerTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import cmsExplorerPages.mainPage;
import utility.Utils;

public class ExploreQA extends TestBase {
	
	mainPage mainpage;

	
	@BeforeClass
	public void preSuite() throws Exception {

		Utils.NavigatetoLink(getUrl());

	}

	@Test(priority = 0)
	public void selectQA() throws InterruptedException
	{
		mainpage= new mainPage();
		Utils.waitForPresenceAndClick(".//div[@class='header_wrapper']//span[contains(text(),'QA')]", mainpage.selectQaEnvironmentButton);
		//mainpage.selectQaEnvironmentButton.click();
		Thread.sleep(5000);
	}
	
	@Test(priority = 1)
	public void selectCalendar() throws InterruptedException
	{
		
		mainpage= new mainPage();
		
		WebDriverWait wait = new WebDriverWait(getDriverInstance(), 30);

		JavascriptExecutor js = (JavascriptExecutor) getDriverInstance();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ui-datepicker-div")));

		js.executeScript("arguments[0].scrollIntoView(true);arguments[0].click()", mainpage.selectDate);
		
		mainpage.SelectDateFromCalendar("5");
		
		Thread.sleep(10000);
	}
	
}
