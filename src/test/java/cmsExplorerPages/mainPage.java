package cmsExplorerPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Page.BasePage;
import base.TestBase;

public class mainPage extends BasePage {
	
	@FindBy(xpath=".//div[@class='header_wrapper']//span[contains(text(),'QA')]")
	public static WebElement selectQaEnvironmentButton;
    
	@FindBy(id="ui-datepicker-div")
	public static WebElement selectDate;
	
	@Override
	public void verifyPage() {
		// TODO Auto-generated method stub
		waitForPageLoad();
	}
	
	public void SelectDateFromCalendar(String day)
			throws InterruptedException {

		By calendarXpath = By.xpath("//td[not(contains(@class,'ui-datepicker-other-month'))]/a[text()='"+day+"']");
		
		WebDriverWait wait = new WebDriverWait(TestBase.getDriverInstance(), 300);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[not(contains(@class,'ui-datepicker-other-month'))]/a[text()='"+day+"']")));
		JavascriptExecutor js = (JavascriptExecutor)TestBase.getDriverInstance();
		js.executeScript("arguments[0].scrollIntoView(true);arguments[0].click()", calendarXpath);
		//getDriverInstance().findElement(calendarXpath).click();
		Thread.sleep(2000);
	}


}
