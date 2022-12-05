package stepDefinition;

import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.*;

public class BaseHooks {
	
	private TestContext testContext;
	
	public BaseHooks(TestContext testContext) {
		
		this.testContext = testContext;
	}
	
	@Before (order = 0)
	public void chromeDriverSetup() throws Exception {
		
		testContext.getWebDriverManager().getDriver();
		testContext.getPageObjectManager().getBasePage().setupExplicitWait();
	}
	
	@Before(order = 2)
	public void otherSetup(Scenario scenario) {
		
		testContext.scenarioContext.setContext(Context.SCENARIO_NAME, scenario.getName());
	}
	
	@After
	public void tearDown() {
		
		testContext.getWebDriverManager().quitSession();
	}

}