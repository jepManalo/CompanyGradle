package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
	
	private WebDriverWait wait;
	private WebDriver driver;
	
	@FindBy(id = "ce-input-0")
	private WebElement usernameTextField;
	
	@FindBy(id = "ce-input-1")
	private WebElement passwordTextField;
	
	@FindBy(xpath = "//*[contains(text(), 'Sign in')]/parent::button")
	private WebElement signInBtn;
	
	@FindBy(xpath = "//*[@class = 'ce-main-layout__header']")
	private WebElement leftNavigationPanel;
	
	@FindBy(xpath = "//*[@class = 'ce-main-layout__content']")
	private WebElement contentPanel;
	
	@FindBy(xpath = "//*[text() = 'Email or password are incorrect.']")
	private WebElement invalidLoginErrorMessage;
	
	@FindBy(xpath = "//*[text() = 'Password cannot be empty']")
	private WebElement invalidLoginErrorMessageWithoutPass;
	
	@FindBy(xpath = "//*[text() = 'Email address cannot be empty']")
	private WebElement invalidLoginErrorMessageWithoutUser;
	
	@FindBy(xpath = "//*[text() = 'Email and password cannot be empty']")
	private WebElement invalidLoginErrorMessageWithoutUserAndPass;
	
	public LoginPage(WebDriver driver) {
		
		super(driver);
		
		this.driver = driver;
		wait = getExplicitWait();
		PageFactory.initElements(driver, this);
	}
	
	public String getURL() {
		
		return driver.getCurrentUrl();
	}
	
	public void enterUsername(String username) {
		
		wait.until(ExpectedConditions.elementToBeClickable(usernameTextField));
		usernameTextField.clear();
		usernameTextField.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		
		wait.until(ExpectedConditions.elementToBeClickable(passwordTextField));
		passwordTextField.clear();
		passwordTextField.sendKeys(password);
	}
	
	public void clickSignInBtn() throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(signInBtn));
		signInBtn.click();
		
		waitForPageToLoad(30);
	}
	
	public String getActualResultUiUserLoggedIn() {
		
		String actualResultUI;
		
		try {
			wait.until(ExpectedConditions.visibilityOf(leftNavigationPanel));
			wait.until(ExpectedConditions.visibilityOf(contentPanel));
			
			actualResultUI = "true";
		} catch (TimeoutException e) {
			actualResultUI = e.getMessage();
		}
		
		return actualResultUI;
	}
	
	public String getActualResultUiUserNotLoggedIn(String username, String password) {
		
		String result;
		WebElement toBeTested;
		
		if (username != "" && password != "") {
			toBeTested = invalidLoginErrorMessage;
		} else if (username == "" && password != "") {
			toBeTested = invalidLoginErrorMessageWithoutUser;
		} else if (username != "" && password == "") {
			toBeTested = invalidLoginErrorMessageWithoutPass;
		} else {
			toBeTested = invalidLoginErrorMessageWithoutUserAndPass;
		}
		
		try {
			wait.until(ExpectedConditions.visibilityOf(toBeTested));
			
			result = "true";
		} catch (TimeoutException e) {
			result = e.getMessage();
		}
		
		return result;
	}
	
	public String getActualResultUrlUserLoggedIn() {
		
		String actualResultUrl;
		
		try {
			wait.until(ExpectedConditions.urlContains("package-manager"));
			
			actualResultUrl = "true";
		} catch (TimeoutException e) {
			actualResultUrl = e.getMessage();
		}
		
		return actualResultUrl;
	}
	
	public String getActualResultUrlUserNotLoggedIn() {
		
		String result;
		
		try {
			wait.until(ExpectedConditions.urlContains("login"));
			
			result = "true";
		} catch (TimeoutException e) {
			result = e.getMessage();
		}
		
		return result;
	}
}