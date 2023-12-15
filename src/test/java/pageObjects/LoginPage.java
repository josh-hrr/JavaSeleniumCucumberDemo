package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css=".login_logo")
	WebElement loginLogo;
	
	@FindBy(css="#user-name")
	WebElement username;
	
	@FindBy(css="#password")
	WebElement password;
	
	@FindBy(xpath ="//input[@id='login-button']")
	WebElement loginBtn;
	
	public WebElement loginLogo() {
		return loginLogo;
	}
	
	public void usernameInput(String usernameInput) {
		username.sendKeys(usernameInput);
	} 
	public void passwordInput(String passwordInput) {
		password.sendKeys(passwordInput);
	} 
	public void loginBtn() {
		loginBtn.click();
	}
	
}
