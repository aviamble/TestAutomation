package Page.EM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Page.BasePage;

public class EditorMainMenuPage extends BasePage{
	
	@FindBy(xpath=".//*[@id='ctl00_Folders_NewSubmissions_FolderLink']")
	public static WebElement newsubmission;
	
	@FindBy(xpath=".//*[@id='size1']")
	public static WebElement resultsperpage;
	
	@FindBy(xpath=".//*[@id='HeaderMainMenu']")
	public static WebElement text;
	
	@FindBy(xpath=".//*[@id='tableContainer']/legend")
	public static WebElement verifysubmission;
	
	@FindBy(xpath=".//*[@id='BtnSaveAndClose']")
	public static WebElement save;
	
	@FindBy(xpath=".//*[@id='ChkTechCheckComplete']")
	public static WebElement techcheck;
	
	@FindBy(xpath="html/body/div[2]/div[3]/div/button[1]")
	public static WebElement ok;
	
	
	
	@Override
	public void verifyPage() {
		// TODO Auto-generated method stub
		waitForPageLoad();
	}

}
