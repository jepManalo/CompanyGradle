package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderToCashPage extends BasePage {
	
	private WebDriverWait wait;
	
	//MAIN PAGE
	@FindBy(xpath = "//div[@export-png-id = 'PROCESS_EXPLORER']")
	private WebElement processExplorerPanel;
	
	@FindBy(xpath = "//div[@class = 'pe-standalone__controls']")
	private WebElement rightNavigationBarPanel;
	
	
	//PROCESS EXPLORER PANEL
	@FindBy(xpath = "//*[@class = 'canvas']")
	private WebElement processExplorerPanelProcessFlow;
	
	@FindBy(xpath = "//*[@class = 'pe-tools ng-scope']//*[@ce-kpi-selection]")
	private WebElement processExplorerPanelKpiSelectionBtn;
	
	@FindBy(xpath = "//*[@class = 'pe-tools ng-scope']//*[@ce-animation-selection]")
	private WebElement processExplorerPanelAnimationSelectionBtn;
	
	@FindBy(xpath = "//*[@class = 'pe-tools ng-scope']//*[@ce-pe-activity-selection]")
	private WebElement processExplorerPanelActivitySelectionBtn;
	
	@FindBy(xpath = "//*[contains(@class, 'pe-zoom-controls')]//*[@title = 'Zoom out']")
	private WebElement processExplorerPanelZoomOutBtn;
	
	@FindBy(xpath = "//*[contains(@class, 'pe-zoom-controls')]//*[@title = 'Zoom in']")
	private WebElement processExplorerPanelZoomInBtn;
	
	@FindBy(xpath = "//*[contains(@class, 'pe-zoom-controls')]//*[@title = 'Reset zoom']")
	private WebElement processExplorerPanelResetZoomBtn;
	
	@FindBy(xpath = "//div[contains(@class, 'fa-cog')]/parent::*[@title = 'Settings']")
	private WebElement processExplorerPanelSettingsBtn;
	
	
	//RIGHT NAVIGATION BAR ACTIVITIES PANEL
	@FindBy(xpath = "//*[text() = 'Activities']/ancestor::div[@class = 'pe-standalone__control pe-standalone__control--activities flex-vertical']")
	private WebElement rightNavigationBarActivities;
	
	@FindBy(xpath = "//*[text() = 'Activities']/../../div[@class = 'pe-controls__header']//button[text() = 'List view']")
	private WebElement rightNavigationBarActivitiesListViewBtn;
	
	@FindBy(xpath = "//*[text() = 'Activities']/../../div[@class = 'pe-controls__header']//*[contains(@class, 'icon-activity')]")
	private WebElement rightNavigationBarActivitiesIcon;
	
	@FindBy(xpath = "//*[text() = 'Activities']/../../div//*[@class = 'pe-slider']")
	private WebElement rightNavigationBarActivitiesSlider;
	
	@FindBy(xpath = "//*[text() = 'Activities']/../../div//*[@class = 'pe-metrics']")
	private WebElement rightNavigationBarActivitiesMetrics;
	
	@FindBy(xpath = "//*[text() = 'Activities']/../../div//*[@class = 'pe-metrics']//*[@class = 'pe-metrics__chart']")
	private WebElement rightNavigationBarActivitiesMetricsChart;
	
	@FindBy(xpath = "//*[text() = 'Activities']/../../div//*[@class = 'pe-metrics']//button[text() = 'Reset']")
	private WebElement rightNavigationBarActivitiesResetBtn;
	
	@FindBy(xpath = "//*[text() = 'Activities']/../../div//*[@class = 'pe-metrics']//button[text() = 'Less']")
	private WebElement rightNavigationBarActivitiesLessBtn;
	
	@FindBy(xpath = "//*[text() = 'Activities']/../../div//*[@class = 'pe-metrics']//button[text() = 'More']")
	private WebElement rightNavigationBarActivitiesMoreBtn;
	
	
	//RIGHT NAVIGATION BAR CONNECTIONS PANEL
	@FindBy(xpath = "//*[text() = 'Connections']/ancestor::div[@class = 'pe-standalone__control pe-standalone__control--connections flex-vertical']")
	private WebElement rightNavigationBarConnections;
	
	@FindBy(xpath = "//*[text() = 'Connections']/../../div[@class = 'pe-controls__header']//button[text() = 'List view']")
	private WebElement rightNavigationBarConnectionsListViewBtn;
	
	@FindBy(xpath = "//*[text() = 'Connections']/../../div[@class = 'pe-controls__header']//*[contains(@class, 'icon-connection')]")
	private WebElement rightNavigationBarConnectionsIcon;
	
	@FindBy(xpath = "//*[text() = 'Connections']/../../div//*[@class = 'pe-slider']")
	private WebElement rightNavigationBarConnectionsSlider;
	
	@FindBy(xpath = "//*[text() = 'Connections']/../../div//*[@class = 'pe-metrics']")
	private WebElement rightNavigationBarConnectionsMetrics;
	
	@FindBy(xpath = "//*[text() = 'Connections']/../../div//*[@class = 'pe-metrics']//*[@class = 'pe-metrics__chart']")
	private WebElement rightNavigationBarConnectionsMetricsChart;
	
	@FindBy(xpath = "//*[text() = 'Connections']/../../div//*[@class = 'pe-metrics']//button[text() = 'Reset']")
	private WebElement rightNavigationBarConnectionsResetBtn;
	
	@FindBy(xpath = "//*[text() = 'Connections']/../../div//*[@class = 'pe-metrics']//button[text() = 'Less']")
	private WebElement rightNavigationBarConnectionsLessBtn;
	
	@FindBy(xpath = "//*[text() = 'Connections']/../../div//*[@class = 'pe-metrics']//button[text() = 'More']")
	private WebElement rightNavigationBarConnectionsMoreBtn;
	
	@FindBy(xpath = "//*[text() = 'Connections']/../../div//*[@class = 'pe-metrics']//button[text() = 'Fixed layout']")
	private WebElement rightNavigationBarConnectionsFixedLayoutBtn;	

	public OrderToCashPage(WebDriver driver) {
		
		super(driver);
		
		wait = getExplicitWait();
		PageFactory.initElements(driver, this);
	}	
	
	public String getActualLoadResultOrderToCash() throws Exception {
			
		String actualLoadResult;
		
		try {
			wait.until(ExpectedConditions.visibilityOf(processExplorerPanel));
			wait.until(ExpectedConditions.visibilityOf(rightNavigationBarPanel));
			
			wait.until(ExpectedConditions.visibilityOf(processExplorerPanelProcessFlow));
			wait.until(ExpectedConditions.elementToBeClickable(processExplorerPanelKpiSelectionBtn));
			wait.until(ExpectedConditions.elementToBeClickable(processExplorerPanelAnimationSelectionBtn));
			wait.until(ExpectedConditions.elementToBeClickable(processExplorerPanelActivitySelectionBtn));
			wait.until(ExpectedConditions.elementToBeClickable(processExplorerPanelZoomOutBtn));
			wait.until(ExpectedConditions.elementToBeClickable(processExplorerPanelZoomInBtn));
			wait.until(ExpectedConditions.elementToBeClickable(processExplorerPanelResetZoomBtn));
			wait.until(ExpectedConditions.elementToBeClickable(processExplorerPanelSettingsBtn));
			
			wait.until(ExpectedConditions.visibilityOf(rightNavigationBarActivities));
			wait.until(ExpectedConditions.elementToBeClickable(rightNavigationBarActivitiesListViewBtn));
			wait.until(ExpectedConditions.visibilityOf(rightNavigationBarActivitiesIcon));
			wait.until(ExpectedConditions.elementToBeClickable(rightNavigationBarActivitiesSlider));
			wait.until(ExpectedConditions.visibilityOf(rightNavigationBarActivitiesMetrics));
			wait.until(ExpectedConditions.visibilityOf(rightNavigationBarActivitiesMetricsChart));
			wait.until(ExpectedConditions.elementToBeClickable(rightNavigationBarActivitiesResetBtn));
			wait.until(ExpectedConditions.elementToBeClickable(rightNavigationBarActivitiesLessBtn));
			wait.until(ExpectedConditions.elementToBeClickable(rightNavigationBarActivitiesMoreBtn));
			
			wait.until(ExpectedConditions.visibilityOf(rightNavigationBarConnections));
			wait.until(ExpectedConditions.elementToBeClickable(rightNavigationBarConnectionsListViewBtn));
			wait.until(ExpectedConditions.visibilityOf(rightNavigationBarConnectionsIcon));
			wait.until(ExpectedConditions.elementToBeClickable(rightNavigationBarConnectionsSlider));
			wait.until(ExpectedConditions.visibilityOf(rightNavigationBarConnectionsMetrics));
			wait.until(ExpectedConditions.visibilityOf(rightNavigationBarConnectionsMetricsChart));
			wait.until(ExpectedConditions.elementToBeClickable(rightNavigationBarConnectionsResetBtn));
			wait.until(ExpectedConditions.elementToBeClickable(rightNavigationBarConnectionsLessBtn));
			wait.until(ExpectedConditions.elementToBeClickable(rightNavigationBarConnectionsMoreBtn));
			wait.until(ExpectedConditions.elementToBeClickable(rightNavigationBarConnectionsFixedLayoutBtn));	
			
			actualLoadResult = "true";
		} catch (TimeoutException e) {
			actualLoadResult = e.getMessage();
		}
		
		return actualLoadResult;
	}
}