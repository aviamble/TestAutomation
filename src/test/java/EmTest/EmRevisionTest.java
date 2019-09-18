package EmTest;

import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Page.EM.ArticleSubmissionPage;
import Page.EM.AuthorMainmenuPage;
import Page.EM.EditorMainMenuPage;
import Page.EM.LoginPage;
import base.TestBase;
import utility.Utils;

public class EmRevisionTest extends TestBase{
	
	LoginPage loginpage;
	EditorMainMenuPage editorpage;
	
	@BeforeClass
	public void preSuite() throws Exception {
	 
	  Utils.NavigatetoLink(getUrl());
	  
	}
	
	@Test
	public void EditorLogin() throws InterruptedException
	{		
		loginpage= new LoginPage();
		
		Utils.switchToFrame("content");
		Utils.switchToFrame("login");
		
		
		loginpage.login(loginpage.username, loginpage.password, "joeharw", "joe123", loginpage.editorloginbutton);
		Utils.waitFor(5);
		
		Utils.switchToFrame("content");
		Utils.waitFor(5);
		
		String Mainmenu = editorpage.text.getText();
		Utils.waitFor(5);
		System.out.println("Title Verified"+Mainmenu);
		
		AssertJUnit.assertEquals(Mainmenu, "JEO Assistant ACDC Main Menu");
		System.out.println("Title Verified");
		
	}
	

	@Test
	public void NewSubmission() throws InterruptedException, IOException
	{
		loginpage= new LoginPage();
		editorpage = new EditorMainMenuPage();
		
		editorpage.newsubmission.click();
		
		Utils.waitFor(5);
		
		String SubmissionPage=editorpage.verifysubmission.getText();
		
		AssertJUnit.assertEquals(SubmissionPage, "New Submissions - * Joe Assistant");
		System.out.println("New submission page verified");
      
		//String display = new Select (getDriverInstance().findElement(By.id("size1"))).getFirstSelectedOption().getText();
		//editorpage.techcheck.click();
		//Utils.waitFor(5);
		
	
		
	
}
	@Test
	public void TechnicalCheck() throws InterruptedException, IOException
	{
		editorpage = new EditorMainMenuPage();
	
	HashMap<String, WebElement> map1 = new HashMap<>();
	int i=0;
	for (i=1;i<11;i++)
	{
   		
	String manuScriptNum=getDriverInstance().findElement(By.xpath("//*[@id='row"+i+"']/td[2]")).getText();
	
	System.out.println(manuScriptNum);
	
	WebElement technicalcheck=getDriverInstance().findElement(By.xpath("//*[@id='menu"+i+"']/div[2]/a"));
	//System.out.println(output1);
	
	map1.put(manuScriptNum, technicalcheck);
	
	
	Utils.waitFor(5);
	}
	
	map1.get("HARWBeta150-D-18-00446").click();
	
	Utils.waitFor(5);
	
	Set<String> handles = getDriverInstance().getWindowHandles();
	 System.out.println(handles);
	 String firstWinHandle = getDriverInstance().getWindowHandle(); 
	 handles.remove(firstWinHandle);
	 System.out.println(handles);
	 
	 
	 
	 /*String winHandle=(String) handles.iterator().next();
	 System.out.println(winHandle);
	 
	 if (newWindow!=firstWinHandle){
	 String secondWinHandle = winHandle;*/ 
	 
	 for(String handle : handles)
		{
			System.out.println("Switching to window - > " + handle);
			
			 getDriverInstance().switchTo().window(handle); //Switch to the desired window first and then execute commands using driver
			 //getDriverInstance().findElement(By.xpath(".//*[@id='ChkTechCheckComplete']")).click();
			 editorpage.techcheck.click();
			 Utils.waitFor(5);
			 
			 editorpage.save.click();
			 Utils.waitFor(5);
			 //getDriverInstance().findElement(By.xpath("html/body/div[2]/div[3]/div/button[1]")).click();
			 editorpage.ok.click();
			 Utils.waitFor(5);
		}
	 System.out.println(handles);
	 getDriverInstance().switchTo().window(firstWinHandle);
	 String currentWindowHandle= getDriverInstance().getWindowHandle();
	 System.out.println("Current window"+currentWindowHandle);
	 getDriverInstance().switchTo().window(firstWinHandle);
	 
	
	}

	
@Test
public void ProductionTask() throws InterruptedException, IOException
{
	getDriverInstance().switchTo().defaultContent();
	 Utils.switchToFrame("menuPage");
	 WebElement mainmenu=getDriverInstance().findElement(By.xpath(".//*[@id='mainMenuLink']"));
			 mainmenu.click();
			 Utils.waitFor(5);
			 
			 //getDriverInstance().findElements(By.name("iframe"));
			 //Utils.switchToFrame("implMessage");
			 //Utils.switchToFrame("proxy");
			 //getDriverInstance().switchTo().frame(0);
			 getDriverInstance().switchTo().defaultContent();
			Utils.switchToFrame("content");
			 Utils.waitFor(5);
			 //WebElement prodTask=getDriverInstance().findElement(By.linkText("Production Tasks"));
			 WebElement prodTask=getDriverInstance().findElement(By.xpath(".//*[@id='ctl00_ProductionMenuLink']"));
			 prodTask.click();
			 Utils.waitFor(5);
			 
			 
			 
			 getDriverInstance().findElement(By.xpath("html/body/div/div[3]/fieldset[1]/div/a[1]")).click();
			 WebElement ManuscriptName=getDriverInstance().findElement(By.xpath(".//*[@id='Value0']"));
			 ManuscriptName.sendKeys("HARWBeta150-D-18-00446");
			  System.out.println(ManuscriptName.getText());
			  
			  getDriverInstance().findElement(By.xpath(".//*[@id='btnCurrentSearch']")).click();
			  Utils.waitFor(5);
			  
			  getDriverInstance().findElement(By.xpath(".//*[@id='row1']/td[1]/a[10]")).click();
			  
			  Utils.waitFor(5);
			 WebElement element = getDriverInstance().findElement(By.xpath(".//tbody/tr[2]/td[1]/input"));
			  WebDriverWait wait = new WebDriverWait(getDriverInstance(), 30);
			  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//tbody/tr[2]/td[1]/input")));
			  JavascriptExecutor js = (JavascriptExecutor)TestBase.getDriverInstance();
			  js.executeScript("arguments[0].scrollIntoView(true);arguments[0].click()", element);
			  //JavascriptExecutor js = (JavascriptExecutor) getDriverInstance();  
			  //js.executeScript("arguments[0].click();", element);
			 // getDriverInstance().findElement(By.xpath(".//tbody/tr[2]/td[1]/input")).click();
			  
			  //getDriverInstance().findElement(By.xpath(".//tbody/tr[2]/td[1]/input")).click();
	 /*getDriverInstance().switchTo().window(handles);
	 }
	String  handle= getDriverInstance().getWindowHandle();
	System.out.println(handle);
	getDriverInstance().switchTo().window(handle);*/
	
	//WebElement save=getDriverInstance().findElement(By.xpath(".//*[@id='BtnSaveAndClose']"));
	//save.click();
}

}
