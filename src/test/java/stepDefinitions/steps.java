package stepDefinitions; 
 
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*; 
import pageObjects.LoginPage; 


public class steps {
	
	LoginPage login;
	WebDriver driver; 
	WebDriverWait wait; 
	String browser;    
	

	
	@Before
	public void setup() {
		browser = "chrome";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		login = new LoginPage(driver);

	}
	
	@After
	public void tearDown() {
		driver.quit();
	}   
	
	@Given("I am on the Sauce Demo login page")
	public void onTheSauceDemoLoginPage() {   
		driver.get("https://www.saucedemo.com/"); 
 	}
	 
	@When("I enter username as {string} and password as {string}")
	public void enterCredentials(String username, String password) {
		login.usernameInput(username);
		login.passwordInput(password);
	}
	
	@When("I click the login button")
	public void clickTheLoginButton() {
		login.loginBtn();
	}
	 
	@Then("I should be redirected to the Sauce Demo inventory page")
	public void shouldBeRedirectedToInventory() {
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(currentUrl, expectedUrl);
	} 
	 
	
	@Then("I should see {string}")
	public void shouldSeeExpectedResult(String expectedResult) {
		String currentUrl;
		String expectedUrl;
		switch(expectedResult) {
			case "the inventory page display":  
				currentUrl = driver.getCurrentUrl();
				expectedUrl = "https://www.saucedemo.com/inventory.html";
				Assert.assertEquals(currentUrl, expectedUrl);
				break;
			case "the login page display":
				currentUrl = driver.getCurrentUrl();
				expectedUrl = "https://www.saucedemo.com/";
				Assert.assertEquals(currentUrl, expectedUrl);
				break;
			}
		}
	}
	  