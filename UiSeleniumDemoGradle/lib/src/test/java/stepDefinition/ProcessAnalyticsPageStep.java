package stepDefinition;

import java.text.MessageFormat;

import constants.Constant;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProcessAnalyticsPage;
import utility.CustomAssertion;

public class ProcessAnalyticsPageStep {

	private ProcessAnalyticsPage processAnalyticsPage;
	private CustomAssertion customAssert;
	private TestContext testContext;
	
	public ProcessAnalyticsPageStep(TestContext testContext, CustomAssertion customAssert) {
		
		this.testContext = testContext;
		this.processAnalyticsPage = testContext.getPageObjectManager().getProcessAnalyticsPage();
		this.customAssert = customAssert;
	}
	
	@When("the user navigates to {string} Anaysis")
	public void the_user_navigates_to_order_to_cash_anaysis(String analysisPage) throws Exception {
		
		switch (analysisPage.replace(" ", "")) {
		case Constant.AnalysisConstant.ORDER_TO_CASH:
			processAnalyticsPage.navigateToOrderToCashAnalysis();
			break;
			
		case Constant.AnalysisConstant.PURCHASE_TO_PAY:
			processAnalyticsPage.navigateToPurchaseToPayAnalysis();
			break;
			
		case Constant.AnalysisConstant.SERVICE_NOW_TICKETING:
			processAnalyticsPage.navigateToServiceNowTicketingAnalysis();
			break;
			
		default:
			throw new Exception("Invalid Analysis dashboard used");
		}
		
		testContext.scenarioContext.setContext(Context.EXAMPLE_NAME, analysisPage);
	}
	
	@Then("the user can verify {string} Analysis is displayed")
	public void the_user_can_verify_order_to_cash_analysis_is_displayed(String analysisName) throws Exception {

		boolean analysisExisting = processAnalyticsPage.getAnalysisExisting(analysisName);
		boolean workspaceExisting = processAnalyticsPage.getWorkSpaceExisting(analysisName);
		boolean urlCorrect = processAnalyticsPage.getActualUrlResult("ProcessAnalyticsPage");
		
		customAssert.assertEquals(analysisExisting, true, MessageFormat.format("Analysis: {0} is not displayed", analysisName));
		customAssert.assertEquals(workspaceExisting, true, MessageFormat.format("Workpace: {0} is not displayed", analysisName));
		customAssert.assertEquals(urlCorrect, true, "Url is incorrect");
		customAssert.assertAll();
	}
}