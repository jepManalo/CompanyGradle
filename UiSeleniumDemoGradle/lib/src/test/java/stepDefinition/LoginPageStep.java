package stepDefinition;

import cucumber.TestContext;
import io.cucumber.java.en.*;
import managers.FileReaderManager;
import pages.LoginPage;
import utility.CustomAssertion;

public class LoginPageStep {
	
	private LoginPage loginPage;
	private CustomAssertion customAssert;
	private String username;
	private String password;
	
	public LoginPageStep(TestContext testContext, CustomAssertion customAssert) {
		
		this.loginPage = testContext.getPageObjectManager().getLoginPage();
		this.customAssert = customAssert;
	}
	
	@When("the user enters a valid username and password")
	public void theUserEntersAValidUsernameAndPassword() throws InterruptedException {
		
		loginPage.enterUsername(FileReaderManager.getInstance().getConfigReader().getUserName());
		loginPage.enterPassword(FileReaderManager.getInstance().getConfigReader().getPassword());
		
		loginPage.clickSignInBtn();
	}
	
	@Given("the user successfully logs in to EMS")
	public void the_user_successfully_logs_in_to_ems() throws InterruptedException {
		
		theUserEntersAValidUsernameAndPassword();
	}
	
	@When("the user enters a invalid {string} and {string}")
	public void the_user_enters_a_invalid_and(String username, String password) throws InterruptedException {
		
		this.username = username;
		this.password = password;
		
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickSignInBtn();
	}
	
	@Then("the user is {string} Logged In")
	public void the_user_is_unsuccessfully_logged_in(String expected) throws InterruptedException {
				
		String actualResultUI = expected.equalsIgnoreCase("successfully") 
								? loginPage.getActualResultUiUserLoggedIn() 
								: loginPage.getActualResultUiUserNotLoggedIn(username, password);
		
		String actualResultURL = expected.equalsIgnoreCase("successfully") 
								 ? loginPage.getActualResultUrlUserLoggedIn() 
								 : loginPage.getActualResultUrlUserNotLoggedIn();
		
		customAssert.assertEquals(actualResultUI, "true", "Pls check Screenshot to verify if user is logged in.");
		customAssert.assertEquals(actualResultURL, "true", "Pls check URL: " + loginPage.getURL());
		customAssert.assertAll();
	}
}