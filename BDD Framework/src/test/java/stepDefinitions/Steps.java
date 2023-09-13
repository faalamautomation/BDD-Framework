package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;

import pageObjects.HomePage;
import pageObjects.LoginPage;


public class Steps {

		public WebDriver driver;
		public LoginPage lp;
		public HomePage hp;
	

	@Given("User opens URL {string}")
	public void user_opens_url(String url){
	//	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
		WebDriverManager.chromedriver().setup(); 
		driver=new ChromeDriver();
		lp=new LoginPage(driver);
		hp=new HomePage(driver);
	    driver.get(url);
	    driver.manage().window().maximize();
	    //Thread.sleep(8000);
	}

	@When("User clicks on login link")
	public void user_clicks_on_login_link() {
     lp.clickLoginLink();
     
	}

	@Then("User lands on {string}")
	public void user_lands_on(String url) {
		String expectedUrl="https://www.evernote.com/Login.action";
		Assert.assertEquals(url,expectedUrl);

	}

	@When("User enters the invalid email as {string}")
	public void user_enters_the_invalid_email_as(String string) {
         lp.setUserName("fahadalamgirpsd@gmail.com");
	}
	
	@When("User enters the valid email as {string}")
	public void user_enters_the_valid_email_as(String string) {
         lp.setUserName("fahadalamgircsd@gmail.com");
	}

	@When("User clicks on login button")
	public void clicks_on_login_button() throws InterruptedException {
          lp.clickLogin();
          Thread.sleep(15000);
	}

	@Then("{string} message should be displayed on the login page")
	public void message_is_displayed_on_the_login_page(String string) {
		String expectedMessage="There is no account for the username or email you entered.";
		Assert.assertEquals(expectedMessage,lp.errorMessage());
		driver.close();
	}
	
	@When("User enters the password as {string}")
	public void user_enters_the_password_as(String string) {
	  lp.setUserPassword("Mountain@5goat");
	}

	@Then("homepage of the application should be displayed")
	public void homepage_of_the_application_should_be_displayed() {
	    String homeExpectedTitle="Home - Evernote";
	    String actualHomeTitle=driver.getTitle();
	    Assert.assertEquals(homeExpectedTitle,actualHomeTitle);

	}
	
	@When("User clicks on create a new note tab and notespage of the application is displayed and User writes a note")
	public void user_clicks_on_create_a_new_note_tab_and_notespage_of_the_application_is_displayed() throws InterruptedException {
		hp.noteCreation("Videos Slots Title","This is a video slot note for QA Test");
	    String notesExpectedTitle="Notes - Evernote";
	    String notesActualTitle=driver.getTitle();
	    Assert.assertEquals(notesExpectedTitle, notesActualTitle);
	}

	@When("User clicks on the written note tab")
	public void user_clicks_on_the_written_note_tab() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    hp.noteSelection();
	}

	@And("written note title and paragragh is verified")
	public void written_note_title_and_paragragh_is_verified() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	      hp.verifyTitle();
	      hp.verifyNotePara();
	}

	@When("User clicks on logout button from the menu")
	public void user_clicks_on_logout_button_from_the_menu() throws InterruptedException {
      hp.clickLogout();
	}

}