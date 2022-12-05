package cucumber;

import managers.PageObjectManager;
import managers.WebDriverManager;

public class TestContext {
	
	private WebDriverManager webDriverManager;
	private PageObjectManager pageObjectManager;
	public ScenarioContext scenarioContext;
	
	public TestContext() throws Exception{
		
		webDriverManager = new WebDriverManager();
		pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
		scenarioContext = new ScenarioContext();
	}
	
	public WebDriverManager getWebDriverManager() {
		
		return webDriverManager;
	}
	
	public PageObjectManager getPageObjectManager() {
		
		return pageObjectManager;
	}
	
	public ScenarioContext getScenarioContext() {
		
		return scenarioContext;
	}
}