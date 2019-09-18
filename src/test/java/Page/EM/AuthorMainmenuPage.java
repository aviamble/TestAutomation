package Page.EM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import Page.BasePage;

public class AuthorMainmenuPage extends BasePage {
	
	@FindBy(xpath="//a[contains(text(), 'Submit New Manuscript')]")
	public static WebElement submitnewmanuscript;

	@FindAll({@FindBy(id = "ctl01_BtnNo")}) 
	public List<WebElement> revisionpopup;
	
	@FindAll({@FindBy(name = "ctl01$ctl00")}) 
	public List<WebElement> multiplerevisionpopup;
	
/*	@FindBy(xpath="//*[id='ctl01_BtnNo']")
	public static WebElement revisionpopup;
	
	@FindBy(xpath="//*[id='ctl01$ctl00']")
	public static WebElement multiplerevisionpopup;*/
	
	//@FindBy(xpath=".//*[@id='ctl01_PnlMoreThanOneOpenAssignments']/div[2]/div[67]/input")
	//public static WebElement multiplerevisionpopup;

	@FindBy(xpath=".//a[contains(text(), 'Logout')]")
	public static WebElement logOutButton;
	
	//@FindBy(xpath=".//a[contains(text(), 'Main Menu')]")
	//public static WebElement mainMenuButton;
	
	
	@FindBy(xpath="html/body/div[2]/div[2]/a[2]")
	public static WebElement mainMenuButton;
	
		
	@Override
	public void verifyPage() {
		// TODO Auto-generated method stub
		waitForPageLoad();
	}

}


