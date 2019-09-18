package Page.EM;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import Page.BasePage;

public class ArticleSubmissionPage extends BasePage {

	@FindBy(xpath=".//input[@id='btnChooseFiles']")
	public static WebElement browsefiles;
	
	@FindBy(xpath=".//*[@id='ddlArticleType']")
	public static WebElement articletype;
	
	@FindBy(xpath=".//div[@id='NavButtonPanel']/button[@id='proceedButton']")
	public static WebElement proceedbtnarticletype;
	
	@FindBy(xpath=".//div[@id='navButtonPanel']/div[@id='Panel1']/button[@id='proceedButton']")
	public static WebElement proceedbtnbrowsefiles;
	
	@FindBy(xpath=".//a[contains(text(),'Download')]")
	public static WebElement downloadlink;
	
	@FindBy(xpath=".//div[@id='NavButtonPanel']/button[@id='proceedButton']")
	public static WebElement proceedbtnreviewpreferences;
	
	
	@FindBy(xpath=".//div[@id='navButtonPanel']/div[@id='Panel1']/button[@id='proceedButton']")
	public static WebElement proceedbtnadditionalinfo;
	
	@FindBy(xpath=".//*[@id='QR1_1_Q3_RSP_3']")
	public static WebElement selectanswer;
	
	@FindBy(xpath=".//*[@id='btnUpdateFileOrder']")
	public static WebElement updateFileOrder;
	
	@FindBy(xpath=".//div[@id='NavButtonPanel']/button[@id='proceedButton']")
	public static WebElement proceedbtncomments;
	
	@FindBy(xpath=".//*[@id='ui-id-2']/div/table[4]/tbody/tr/td/button")
	public static WebElement titleNext;
	
	@FindBy(xpath=".//*[@id='ui-id-4']/div/table[2]/tbody/tr/td/button")
	public static WebElement abstractNext;
	
	@FindBy(xpath=".//*[@id='txtComments']")
	public static WebElement comment;
	
	@FindAll({@FindBy(id = "cancelExtractedButton")}) 
	public List<WebElement> enterDataManually;
	
	@FindAll({@FindBy(id = "cancelConfirm")}) 
	public List<WebElement> confirmManualDataInsertion;
	
	@FindBy(xpath=".//*[@id='authorsNext']/button")
	public static WebElement authorNext;
	
	@FindBy(xpath=".//*[@id='FundingInfoNotAvailable']")
	public static WebElement fundingInfo;
	
	@FindBy(xpath=".//span[contains(text(),'Build PDF for Approval')]")
	public static WebElement buildPdf;
	
	@FindBy(xpath=".//*[@id='txtFullTitle']")
	public static WebElement insertTitle;
	
	@FindBy(xpath=".//*[@id='txtAbstract']")
	public static WebElement insertAbstract;
	
	@FindBy(xpath=".//td[contains(text(), 'Dummy Title')]/ancestor::tr/td/a[2]")
	public static WebElement viewSubmission;
	
	@FindBy(xpath=".//td[contains(text(), 'Dummy Title')]/ancestor::tr/td/a[4]")
	public static WebElement approveSubmission;
	
	@FindBy(xpath=".//span[contains(text(), 'Proceed without ORCID iD')]")
	public static WebElement proceedWithoutOrcId;
	
	@FindBy(xpath=".//div[contains(text(),'Are you sure you want to approve this submission?')]/../div[3]/div/button[1]/span")
	public static WebElement confirmProceedWithoutOrcId;
	
	public static void selectArticleType(WebElement articleType, String type)
	{
		articleType.click();
		Select article = new Select(articleType);
		article.selectByVisibleText(type);
		
	}
	
	@Override
	public void verifyPage() {
		// TODO Auto-generated method stub
		waitForPageLoad();
}
}