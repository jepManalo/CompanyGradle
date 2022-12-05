package stepDefinition;

import cucumber.TestContext;
import io.cucumber.java.en.*;
import pages.LandingPage;
import utility.CustomAssertion;

public class LandingPageStep {
	
	private LandingPage landingPage;
	
	public LandingPageStep(TestContext testContext, CustomAssertion customAssert) {
		
		this.landingPage = testContext.getPageObjectManager().getLandingPage();
	}

	@When("the user navigates to Process Analytics Page")
	public void the_user_navigates_to_process_analytics_page() {

		landingPage.clickMoreBtn();
		landingPage.clickProcessAnalytics();
	}	
}