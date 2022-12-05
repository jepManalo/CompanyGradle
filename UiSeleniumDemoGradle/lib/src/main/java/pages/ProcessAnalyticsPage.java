package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.Constant;

public class ProcessAnalyticsPage extends BasePage {
	
	private WebDriverWait wait;
	
	@FindBy(xpath = "//*[contains(text(), 'Order to Cash')]/ancestor::*[@class = 'workspaces__section ng-star-inserted']")
	private WebElement orderToCashAnalysis;
	
	@FindBy(xpath = "//*[contains(text(), 'Purchase to Pay') and not(contains(text(), 'TEMP'))]/ancestor::*[@class = 'workspaces__section ng-star-inserted']")
	private WebElement puchaseToPayAnalysis;
	
	@FindBy(xpath = "//*[contains(text(), 'ServiceNow Ticketing')]/ancestor::*[@class = 'workspaces__section ng-star-inserted']")
	private WebElement serviceNowTicketingAnalysis;
	
	@FindBy(xpath = "//*[contains(@title, 'Order to Cash')]")
	private WebElement orderToCashWorkspace;
	
	@FindBy(xpath = "//*[contains(@title, 'Purchase to Pay') and not(contains(@title, 'TEMP'))]")
	private WebElement puchaseToPayWorkspace;
	
	@FindBy(xpath = "//*[contains(@title, 'ServiceNow Ticketing')]")
	private WebElement serviceNowTicketingWorkspace;
	
	@FindBy(xpath = "//*[contains(text(), 'Order to Cash')]/ancestor::*[@class = 'ce-section__header']/following-sibling::*//*[contains(@class, 'ce-tile-column')]")
	private WebElement orderToCashAnalysisBtn;
	
	@FindBy(xpath = "//*[contains(text(), 'Purchase to Pay')]/ancestor::*[@class = 'ce-section__header']/following-sibling::*//*[contains(@class, 'ce-tile-column')]")
	private WebElement purchaseToPayAnalysisBtn;
	
	@FindBy(xpath = "//*[contains(text(), 'ServiceNow Ticketing')]/ancestor::*[@class = 'ce-section__header']/following-sibling::*//*[contains(@class, 'ce-tile-column')]")
	private WebElement serviceNowTicketingAnalysisBtn;
	
	public ProcessAnalyticsPage(WebDriver driver) {
		
		super(driver);
		
		wait = getExplicitWait();
		PageFactory.initElements(driver, this);
	}	
	
	public boolean getAnalysisExisting(String analysisName) throws Exception {
		
		boolean analysisExisting;
		WebElement analysis;
		
		switch (analysisName.replace(" ", "")) {			
		case Constant.AnalysisConstant.ORDER_TO_CASH:
			analysis = orderToCashAnalysis;
			break;
		
		case Constant.AnalysisConstant.PURCHASE_TO_PAY:
			analysis = puchaseToPayAnalysis;
			break;
			
		case Constant.AnalysisConstant.SERVICE_NOW_TICKETING:
			analysis = serviceNowTicketingAnalysis;
			break;
		
		default:
			throw new Exception("Name provided is not existing in Process Analytics Page");
		}
		
		try {
			waitForPageToLoad(30);
			scrollToViewElement(analysis);
			wait.until(ExpectedConditions.visibilityOf(analysis));
			
			analysisExisting = true;
		} catch (Exception e) {
			analysisExisting = false;
		}
		
		return analysisExisting;		
	}
	
	public boolean getWorkSpaceExisting(String analysisName) throws Exception {
		
		boolean workSpaceExisting;
		WebElement workspace;
		
		switch (analysisName.replace(" ", "")) {
		case Constant.AnalysisConstant.ORDER_TO_CASH:
			workspace = orderToCashWorkspace;
			break;
		
		case Constant.AnalysisConstant.PURCHASE_TO_PAY:
			workspace = puchaseToPayWorkspace;
			break;
			
		case Constant.AnalysisConstant.SERVICE_NOW_TICKETING:
			workspace = serviceNowTicketingWorkspace;
			break;
			
		default:
			throw new Exception("Name provided is not existing in Process Analytics Page");
		}
		
		try {
			waitForPageToLoad(30);
			scrollToViewElement(workspace);
			wait.until(ExpectedConditions.visibilityOf(workspace));
			
			workSpaceExisting = true;
		} catch (Exception e) {
			workSpaceExisting = false;
		}
		
		return workSpaceExisting;		
	}
	
	public void navigateToOrderToCashAnalysis() throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(orderToCashWorkspace));
		orderToCashWorkspace.click();
		wait.until(ExpectedConditions.visibilityOf(orderToCashAnalysis));
		orderToCashAnalysisBtn.click();
		
		waitForPageToLoad(30);
	}
	
	public void navigateToPurchaseToPayAnalysis() throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(puchaseToPayWorkspace));
		puchaseToPayWorkspace.click();
		wait.until(ExpectedConditions.visibilityOf(puchaseToPayAnalysis));
		purchaseToPayAnalysisBtn.click();
		
		waitForPageToLoad(30);
	}
	
	public void navigateToServiceNowTicketingAnalysis() throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(serviceNowTicketingWorkspace));
		serviceNowTicketingWorkspace.click();
		wait.until(ExpectedConditions.visibilityOf(serviceNowTicketingAnalysis));
		serviceNowTicketingAnalysisBtn.click();
		
		waitForPageToLoad(30);
	}
}