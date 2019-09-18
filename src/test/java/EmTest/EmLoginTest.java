package EmTest;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Map.Entry;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



import Page.EM.ArticleSubmissionPage;
import Page.EM.AuthorMainmenuPage;
import Page.EM.LoginPage;
import base.TestBase;
import utility.Utils;

public class EmLoginTest extends TestBase {

	LoginPage loginpage;
	AuthorMainmenuPage authorpage;
	ArticleSubmissionPage submissionpage;
	// private static String filePath = System.getProperty("user.dir") +
	// "\\SuiteFiles\\10557_2016_533_Article.docx";
	//private static String filePath = System.getProperty("user.dir") + "\\SuiteFiles\\10557_2016_61005_Article.docx";

	@BeforeClass
	public void preSuite() throws Exception {

		Utils.NavigatetoLink(getUrl());

	}

//	@Test
//	public void AuthorLogin() throws InterruptedException {
//		loginpage = new LoginPage();
//		authorpage = new AuthorMainmenuPage();
//		Utils.switchToFrame("content");
//		Utils.switchToFrame("login");
//		loginpage.login(loginpage.username, loginpage.password, "amyharw", "amy123", loginpage.authorloginbutton);
//		Utils.waitFor(5);
//		Utils.switchToFrame("content");
//		String text = getDriverInstance().findElement(By.xpath(".//*[@id='twoColumnLayout']/div[1]/h3")).getText();
//		Assert.assertEquals(text, "Author Main Menu");
//		System.out.println("Title Verified");
//	}

	@Test
	public void SubmitNewManuscript() throws InterruptedException, IOException {
		loginpage = new LoginPage();
		authorpage = new AuthorMainmenuPage();
		submissionpage = new ArticleSubmissionPage();
		
		
		HashMap<String,String> inputTestDataFilesInfo = new HashMap <String,String>();
		String FileName,FilePath = null;
		
		
		
		String directoryPath="D:\\Workspace\\TestAutomation\\TestData";
	    inputTestDataFilesInfo=Utils.listFilesAndFilesSubDirectories(directoryPath);
	    Set<Entry<String, String>> inputFilesEntrySet = inputTestDataFilesInfo.entrySet();
	    
	    System.out.println(inputFilesEntrySet);
	    
	    
	   
	    
	        Utils.switchToFrame("content");
			Utils.switchToFrame("login");
			loginpage.login(loginpage.username, loginpage.password, "amyharw", "amy123", loginpage.authorloginbutton);
			Utils.waitFor(5);
			Utils.switchToFrame("content");

			 for (Entry<String, String> FilesInfo : inputFilesEntrySet)	
			    {
			    	FileName=FilesInfo.getKey();
			        FilePath=FilesInfo.getValue();
			        
			        
	        //authorpage.submitnewmanuscript.click();
			        Utils.waitForPresenceAndClick("//a[contains(text(), 'Submit New Manuscript')]",
							authorpage.submitnewmanuscript);
			        
	        
		if (Utils.isPresent(authorpage.revisionpopup)) {
			authorpage.revisionpopup.get(0).click();
		}

		if (Utils.isPresent(authorpage.multiplerevisionpopup)) {
			authorpage.multiplerevisionpopup.get(0).click();
		}

		// Utils.waitForPresenceAndClick(".//*[@id='ctl01_PnlMoreThanOneOpenAssignments']/div[2]/div[67]/input",
		// authorpage.multiplerevisionpopup);

		// authorpage.multiplerevisionpopup.click();

		submissionpage.selectArticleType(submissionpage.articletype, "Original Article");

		submissionpage.proceedbtnarticletype.click();

		Utils.waitForElement(submissionpage.browsefiles, 10);

		//Utils.DropFile(new File(FilePath), submissionpage.browsefiles, 0, 0);
		submissionpage.browsefiles.click();
		
		Thread.sleep(2000);
		
		System.out.println("Processing file: "+FilePath);
		
		Utils.uploadFileWithRobot(FilePath);

		//Utils.waitFor(5);
		
		//Utils.uploadFileWithRobot(filePath);
		
		//Runtime.getRuntime().exec("D:\\Workspace\\TestAutomation\\SuiteFiles\\FileUploadNew.exe"+" "+FilePath);

		//System.out.println("Uploading files...");

		WebDriverWait wait = new WebDriverWait(getDriverInstance(), 30);

		JavascriptExecutor js = (JavascriptExecutor) getDriverInstance();
		
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//a[contains(text(),'Download')]")));

		Utils.waitForPresenceAndClick(".//a[contains(text(),'Download')]", submissionpage.proceedbtnbrowsefiles);

		Thread.sleep(5000);

		//System.out.println("Files uploaded...");

		Utils.waitForPresenceAndClick(".//div[@id='NavButtonPanel']/button[@id='proceedButton']",
				submissionpage.proceedbtnreviewpreferences);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='QR1_1_Q3_RSP_3']")));

		Select answer = new Select(submissionpage.selectanswer);

		answer.selectByVisibleText("My manuscript has associated data in a data repository");

		Utils.waitForPresenceAndClick(".//div[@id='navButtonPanel']/div[@id='Panel1']/button[@id='proceedButton']",
				submissionpage.proceedbtnadditionalinfo);

		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(".//div[@id='NavButtonPanel']/button[@id='proceedButton']")));

		submissionpage.comment.sendKeys("Test");

		js.executeScript("arguments[0].scrollIntoView(true);arguments[0].click()", submissionpage.proceedbtncomments);

		//System.out.println("Comments done");

		waitForPageLoad();

		if (Utils.isPresent(submissionpage.enterDataManually)) {
			js.executeScript("arguments[0].scrollIntoView(true);arguments[0].click()",
					submissionpage.enterDataManually.get(0));
			js.executeScript("arguments[0].scrollIntoView(true);arguments[0].click()",
					submissionpage.confirmManualDataInsertion.get(0));

			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath(".//*[@id='ui-id-2']/div/table[4]/tbody/tr/td/button")));

			submissionpage.insertTitle.sendKeys("Dummy Title");

			js.executeScript("arguments[0].scrollIntoView(true);arguments[0].click()", submissionpage.titleNext);

			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath(".//*[@id='ui-id-4']/div/table[2]/tbody/tr/td/button")));

			submissionpage.insertAbstract.sendKeys("Dummy Abstract");

			js.executeScript("arguments[0].scrollIntoView(true);arguments[0].click()", submissionpage.abstractNext);

			Utils.waitForPresenceAndClick(".//*[@id='authorsNext']/button", submissionpage.authorNext);

			Thread.sleep(5000);
		} else {

			Utils.waitForPresenceAndClick(".//*[@id='ui-id-2']/div/table[4]/tbody/tr/td/button",
					submissionpage.titleNext);

			Utils.waitForPresenceAndClick(".//*[@id='ui-id-4']/div/table[2]/tbody/tr/td/button",
					submissionpage.abstractNext);

			Utils.waitForPresenceAndClick(".//*[@id='authorsNext']/button", submissionpage.authorNext);

		}

		Thread.sleep(5000);

		js.executeScript("arguments[0].scrollIntoView(true);arguments[0].click()", submissionpage.fundingInfo);

		Utils.waitForPresenceAndClick(".//span[contains(text(),'Build PDF for Approval')]", submissionpage.buildPdf);

		Utils.waitForPresenceAndClick(".//td[contains(text(), 'Dummy Title')]/ancestor::tr/td/a[2]",
				submissionpage.viewSubmission);

		//System.out.println("View submission");

		Thread.sleep(5000);

		Utils.waitForPresenceAndClick(".//td[contains(text(), 'Dummy Title')]/ancestor::tr/td/a[4]",
				submissionpage.approveSubmission);

		//System.out.println("Approve submission");

		Thread.sleep(5000);

		Utils.waitForPresenceAndClick(".//span[contains(text(), 'Proceed without ORCID iD')]",
				submissionpage.proceedWithoutOrcId);

		//System.out.println("Proceed without ORCID");

		Thread.sleep(5000);
		
		

		Utils.waitForPresenceAndClick(".//span[contains(text(), 'Warning')]",
				submissionpage.confirmProceedWithoutOrcId);

		
		Utils.waitForPresenceAndClick("html/body/div[2]/div[2]/a[2]",
				authorpage.mainMenuButton);
		
		//Utils.waitForPresenceAndClick(".//a[contains(text(), 'Logout')]",
		//		authorpage.logOutButton);


	}
	    
	}
}
