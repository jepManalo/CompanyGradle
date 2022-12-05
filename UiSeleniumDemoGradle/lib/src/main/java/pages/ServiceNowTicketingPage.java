package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.Constant;

public class ServiceNowTicketingPage extends BasePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	//LNB
	@FindBy(xpath = "//*[@class = 'responsive-nav']")
	private WebElement leftNavigationBarSection;
	
	@FindBy(xpath = "//*[@class = 'responsive-nav']//*[text() = 'Overview']")
	private WebElement leftNavigationBarOverview;
	
	@FindBy(xpath = "//*[@class = 'responsive-nav']//*[text() = 'Throughput times']")
	private WebElement leftNavigationBarThroughPut;
	
	@FindBy(xpath = "//*[@class = 'responsive-nav']//*[text() = 'Activities']")
	private WebElement leftNavigationBarActivities;

	
	//OVERVIEW - MAIN PANEL - GLOBAL FILTERS
	@FindBy(xpath = "//*[contains(@filter-name, 'Case Start')]")
	private WebElement mainPanelFilterSection;
	
	@FindBy(xpath = "//*[text() = 'Timeframe']/..")
	private WebElement mainPanelFilterTimeFrameDropDown;
	
	@FindBy(xpath = "//*[text() = 'Start date']/..")
	private WebElement mainPanelFilterStartDatePicker;
	
	@FindBy(xpath = "//*[text() = 'End date']/..")
	private WebElement mainPanelFilterEndDatePicker;
	
	@FindBy(xpath = "//*[@class = 'aside']")
	private WebElement mainPanelFilterSettingsBtn;
	
	
	//OVERVIEW - MAIN PANEL - METRICS
	@FindBy(xpath = "//*[text() = 'Metrics']/ancestor::*[@class = 'fullscreen-app__section']")
	private WebElement mainPanelMetricsSection;
	
	@FindBy(xpath = "//*[text() = 'Metrics']/ancestor::*[@class = 'fullscreen-app__section']//*[@class = 'fullscreen-app__section__header']")
	private WebElement mainPanelMetricsSectionHeader;
	
	@FindBy(xpath = "//*[text() = 'Metrics']/ancestor::*[@class = 'fullscreen-app__section']//*[@class = 'fullscreen-app__section__body']")
	private WebElement mainPanelMetricsSectionBody;
	
	
	//OVERVIEW - MAIN PANEL - HAPPY PATH
	@FindBy(xpath = "//*[text() = 'Happy path']/ancestor::*[@class = 'fullscreen-app__section']")
	private WebElement mainPanelHappyPathSection;
	
	@FindBy(xpath = "//*[text() = 'Happy path']/ancestor::*[@class = 'fullscreen-app__section']//*[contains(@class, 'fullscreen-app__section__header')]")
	private WebElement mainPanelHappyPathSectionHeader;
	
	@FindBy(xpath = "//*[text() = 'Happy path']/ancestor::*[@class = 'fullscreen-app__section']//*[@class = 'fullscreen-app__section__body']")
	private WebElement mainPanelHappyPathSectionBody;
	
	
	//OVERVIEW - MAIN PANEL - OTHER FREQUENT ACTIVITIES
	@FindBy(xpath = "//*[contains(text(), 'Other frequent')]/ancestor::*[@class = 'fullscreen-app__section']")
	private WebElement mainPanelOtherFrequentActSection;
	
	@FindBy(xpath = "//*[contains(text(), 'Other frequent')]/ancestor::*[@class = 'fullscreen-app__section']//*[@class = 'fullscreen-app__section__header']")
	private WebElement mainPanelOtherFrequentActSectionHeader;
	
	@FindBy(xpath = "//*[contains(text(), 'Other frequent')]/ancestor::*[@class = 'fullscreen-app__section']//*[@class = 'fullscreen-app__section__body']")
	private WebElement mainPanelOtherFrequentActSectionBody;

	public ServiceNowTicketingPage(WebDriver driver) {
		
		super(driver);
		
		this.driver = driver;
		wait = getExplicitWait();
		PageFactory.initElements(driver, this);
	}	
	
	public String getActualLoadResultServiceNowTicketing() throws Exception {
		
		String ActualLoadResult;
		
		try {
			wait.until(ExpectedConditions.visibilityOf(leftNavigationBarSection));
			wait.until(ExpectedConditions.elementToBeClickable(leftNavigationBarOverview));
			wait.until(ExpectedConditions.elementToBeClickable(leftNavigationBarThroughPut));
			wait.until(ExpectedConditions.elementToBeClickable(leftNavigationBarActivities));
			
			wait.until(ExpectedConditions.visibilityOf(mainPanelFilterSection));
			wait.until(ExpectedConditions.elementToBeClickable(mainPanelFilterTimeFrameDropDown));
			wait.until(ExpectedConditions.elementToBeClickable(mainPanelFilterStartDatePicker));
			wait.until(ExpectedConditions.elementToBeClickable(mainPanelFilterEndDatePicker));
			wait.until(ExpectedConditions.elementToBeClickable(mainPanelFilterSettingsBtn));
			
			wait.until(ExpectedConditions.visibilityOf(mainPanelMetricsSection));
			wait.until(ExpectedConditions.visibilityOf(mainPanelMetricsSectionHeader));
			wait.until(ExpectedConditions.visibilityOf(mainPanelMetricsSectionBody));
			
			wait.until(ExpectedConditions.visibilityOf(mainPanelHappyPathSection));
			wait.until(ExpectedConditions.visibilityOf(mainPanelHappyPathSectionHeader));
			wait.until(ExpectedConditions.visibilityOf(mainPanelHappyPathSectionBody));
			
			wait.until(ExpectedConditions.visibilityOf(mainPanelOtherFrequentActSection));
			wait.until(ExpectedConditions.visibilityOf(mainPanelOtherFrequentActSectionHeader));
			wait.until(ExpectedConditions.visibilityOf(mainPanelOtherFrequentActSectionBody));
			
			verifyAllMetricsTileElementsDisplayed();
			verifyAllHappyPathTileElementsDisplayed();
			verifyAllOtherFreqActTileElementsDisplayed();
			
			ActualLoadResult = "true";
		} catch (TimeoutException e) {
			ActualLoadResult = e.getMessage();
		}
		
		return ActualLoadResult;
	}
	
	public void verifyAllMetricsTileElementsDisplayed() throws Exception {
		
		List<WebElement> listOfTiles = driver.findElements(By.xpath(
				Constant.ServiceNowTicketingConstant.METRICS_TILE_XPATH));
		
		for (int x = 1; x <= listOfTiles.size(); x++) {
			if (x > 4) {
				throw new Exception ("There are more than 4 tiles displayed in Main Panel - Metrics section");
			} else if (x != 4) {
				List<String> elementExtXpath = List.of(Constant.ServiceNowTicketingConstant.TILE_HEADER_XPATH_EXT, 
				   		   							   Constant.ServiceNowTicketingConstant.TILE_BODY_XPATH_EXT, 
				   		   							   Constant.ServiceNowTicketingConstant.TILE_FOOTER_XPATH_EXT);
				String tileXpath = "(" + Constant.ServiceNowTicketingConstant.METRICS_TILE_XPATH 
								   + ")[" + x + "]";
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(tileXpath)));
				
				for (String extXpath : elementExtXpath) {
					String newXpath = tileXpath + extXpath;
					
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(newXpath)));
				}
			} else {
				List<String> elementExtXpath = List.of(Constant.ServiceNowTicketingConstant.TILE_HEADER_XPATH_EXT, 
											   		   Constant.ServiceNowTicketingConstant.TILE_BODY_XPATH_EXT, 
											   		   Constant.ServiceNowTicketingConstant.TILE_FOOTER_XPATH_EXT);
				String tileXpath = "(" + Constant.ServiceNowTicketingConstant.METRICS_TILE_XPATH 
						   		   + ")[" + x + "]";
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tileXpath)));
				
				for(String extXpath : elementExtXpath) {
					String newXpath = tileXpath + extXpath;
					
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(newXpath)));
				}
			}
		}
	}
	
	public void verifyAllHappyPathTileElementsDisplayed() throws Exception {
		
		List<WebElement> listOfTiles = driver.findElements(By.xpath(
				Constant.ServiceNowTicketingConstant.HAPPY_PATH_TILE_XPATH));
		
		for (int x = 1; x <= listOfTiles.size(); x++) {
			if (x > 4) {
				throw new Exception ("There are more than 4 tiles displayed in Main Panel - Happy Path section");
			}
				
			List<String> elementExtXpath = List.of(Constant.ServiceNowTicketingConstant.TILE_HEADER_XPATH_EXT, 
			   		   							   Constant.ServiceNowTicketingConstant.TILE_BODY_XPATH_EXT, 
			   		   							   Constant.ServiceNowTicketingConstant.TILE_FOOTER_XPATH_EXT); //tile__footer is just blank space
			String tileXpath = "(" + Constant.ServiceNowTicketingConstant.HAPPY_PATH_TILE_XPATH 
							   + ")[" + x + "]";
			
			scrollToViewElementBy(By.xpath(tileXpath));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tileXpath)));
			
			for(String extXpath : elementExtXpath) {
				String newXpath = tileXpath + extXpath;
				
				scrollToViewElementBy(By.xpath(newXpath));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(newXpath)));
			}
		}
	}
	
	public void verifyAllOtherFreqActTileElementsDisplayed() throws Exception {
		
		List<WebElement> listOfTiles = driver.findElements(By.xpath(
				Constant.ServiceNowTicketingConstant.OTHER_FREQ_TILE_XPATH));
		
		for (int x = 1; x <= listOfTiles.size(); x++) {
			List<String> elementExtXpath = List.of(Constant.ServiceNowTicketingConstant.TILE_HEADER_XPATH_EXT, 
						   						   Constant.ServiceNowTicketingConstant.TILE_BODY_XPATH_EXT, 
						   						   Constant.ServiceNowTicketingConstant.TILE_FOOTER_XPATH_EXT); //tile__footer is just blank space
			String tileXpath = "(" + Constant.ServiceNowTicketingConstant.OTHER_FREQ_TILE_XPATH 
							   + ")[" + x + "]";
			
			scrollToViewElementBy(By.xpath(tileXpath));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(tileXpath)));
			
			for (String extXpath : elementExtXpath) {
				String newXpath = tileXpath + extXpath;
				
				scrollToViewElementBy(By.xpath(newXpath));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(newXpath)));
			}
		}
	}
}