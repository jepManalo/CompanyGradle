package utility;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;

import cucumber.TestContext;
import enums.Context;
import pages.BasePage;

public class CustomAssertion extends SoftAssert {
	
	private WebDriver driver;
	private TestContext testContext;
	
	public CustomAssertion(TestContext testContext) throws Exception {
		
		this.testContext = testContext;
		driver = testContext.getWebDriverManager().getDriver();
	}
	
	@Override
	public void onAssertFailure(IAssert<?> assertCommand, AssertionError ex) {
		
		String exampleName = (String)testContext.scenarioContext.getContext(Context.EXAMPLE_NAME);
		String folderName = (String)testContext.scenarioContext.getContext(Context.SCENARIO_NAME);
		
		BasePage bp = new BasePage(driver);
		
		if (exampleName != null) {
			bp.takeScreenshot(folderName, exampleName);
		} else {
			bp.takeScreenshot(folderName, "");
		}
	}

}