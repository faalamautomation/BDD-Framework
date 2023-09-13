package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
public WebDriver ldriver;
	
	public  HomePage(WebDriver cdriver)
	{
		ldriver=cdriver;
		PageFactory.initElements(ldriver,this);
	}
	
	@FindBy(id="qa-HOME_NOTE_WIDGET_CREATE_NOTE")
	@CacheLookup
	WebElement createNote;
	
	@FindBy(css="iframe[title='Note Editor']")
	@CacheLookup
	WebElement noteEditor;

	@FindBy(css="textarea[placeholder='Title']")
	@CacheLookup
	WebElement noteTitle;

	@FindBy(css="div[class='para']")
	@CacheLookup
	WebElement notePara;

	@FindBy(css=".O_cOhBpiRJTtr_RB3iHv ._XcEIsaGBBJH_IurgV81")
	@CacheLookup
	WebElement onlyYou;

	@FindBy(css=".bJ19E_Xfh2OPLfJUi7zT._Abul9rIGNKoXu6MD4l0")
	@CacheLookup
	WebElement noteSelect;

	@FindBy(className="AZVFJ")
	@CacheLookup
	WebElement noteTitleText;

	@FindBy(css="[id='en-note'] .para")
	@CacheLookup
	WebElement noteParaText;
	
	@FindBy(id="qa-NAV_USER")
	@CacheLookup
	WebElement uNavigate;
	
	@FindBy(id="qa-ACCOUNT_DROPDOWN_LOGOUT")
	@CacheLookup
	WebElement uLogout;
	
	public void noteCreation(String title, String para) throws InterruptedException
	{
		createNote.click();
		Thread.sleep(5000);
		ldriver.switchTo().frame(noteEditor);
		noteTitle.sendKeys(title);
		notePara.sendKeys(para);
		Thread.sleep(5000);
		ldriver.switchTo().defaultContent();
		onlyYou.click();
		Thread.sleep(3000);
	}
	
	public void noteSelection() throws InterruptedException
	{
		noteSelect.click();
		Thread.sleep(15000);
		
	}
	
	public String verifyTitle() throws InterruptedException
	{
		
		ldriver.switchTo().frame(noteEditor);
		Thread.sleep(3000);
		String noteTitletext=noteTitleText.getAttribute("innerHTML");
		return noteTitletext;
	}
	
	public String verifyNotePara()
	{
	   
		String notetext=noteParaText.getAttribute("innerHTML");
	    return notetext;
	}

	
	
	public void clickLogout() throws InterruptedException
	{
		uNavigate.click();
		Thread.sleep(3000);
		uLogout.click();
	}
}