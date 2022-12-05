package stepDefinition;

import org.openqa.selenium.WebDriver;

import constants.Constant;
import cucumber.TestContext;
import io.cucumber.java.en.*;
import managers.FileReaderManager;
import pages.OrderToCashPage;
import pages.PurchaseToPayPage;
import pages.ServiceNowTicketingPage;
import utility.CustomAssertion;
import dataProvider.ConfigFileReader;

public class CommonStep {
	
	private WebDriver driver;
	private OrderToCashPage orderToCashPage;
	private PurchaseToPayPage purchaseToPayPage;
	private ServiceNowTicketingPage serviceNowTicketingPage;
	private CustomAssertion customAssert;
	
	public CommonStep(ConfigFileReader configFile, TestContext testContext,
			CustomAssertion customAssert) throws Exception {
		
		this.driver = testContext.getWebDriverManager().getDriver();
		this.orderToCashPage = testContext.getPageObjectManager().getOrderToCashPage();
		this.purchaseToPayPage = testContext.getPageObjectManager().getPurchaseToPayPage();
		this.serviceNowTicketingPage = testContext.getPageObjectManager().getServiceNowTicketingPage();
		this.customAssert = customAssert;
	}
	
	@Given("the user navigates to Celonis Login Page {string}")
	public void TheUserIsInCelonisLoginPage(String url) throws Throwable {
		
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		
		Thread.sleep(6000);
	}
	
	@Then("the user can verify {string} Analysis elements are displayed")
	public void the_user_can_verify_analysis_elements_are_displayed(String page) throws Exception {

		String actualLoadResult;
		
		switch (page.replace(" ", "")) {
		case Constant.AnalysisConstant.ORDER_TO_CASH:
			actualLoadResult = orderToCashPage.getActualLoadResultOrderToCash();
			break;
			
		case Constant.AnalysisConstant.PURCHASE_TO_PAY:
			actualLoadResult = purchaseToPayPage.getActualLoadResultPurchaseToPay();
			break;
			
		case Constant.AnalysisConstant.SERVICE_NOW_TICKETING:
			actualLoadResult = serviceNowTicketingPage.getActualLoadResultServiceNowTicketing();
			break;
		
		default:
			throw new Exception("Invalid Analysis dashboard used");
		}
		
		boolean actualUrlResult = orderToCashPage.getActualUrlResult(page);
		
		customAssert.assertEquals(actualLoadResult, "true", "Element Inconsistency is found on the webPage! " + actualLoadResult);
		customAssert.assertEquals(actualUrlResult, true, "Url is incorrect");
		customAssert.assertAll();
	}
}