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

public class PurchaseToPayPage extends BasePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	//KPI
	@FindBy(xpath = "//*[contains(text(), 'KPIs')]/ancestor::*[@class = 'fullscreen-app__section']")
	private WebElement mostCommonPathKpiSection;
	
	@FindBy(xpath = "//*[contains(text(), 'Edit KPI')]/..")
	private WebElement mostCommonPathKpiEditKpi;
	
	@FindBy(xpath = "//*[contains(text(), 'Case count')]/ancestor::*[@kpi-value = 'kpiTile.kpiValue']")
	private WebElement mostCommonPathKpiCaseCount;
	
	@FindBy(xpath = "//*[contains(text(), 'Activities count')]/ancestor::*[@kpi-value = 'kpiTile.kpiValue']")
	private WebElement mostCommonPathKpiActivitiesCount;
	
	@FindBy(xpath = "//*[contains(text(), 'Case count')]/ancestor::*[@kpi-value = 'kpiTile.kpiValue']//*[@class = 'tile__body ng-scope']")
	private WebElement mostCommonPathKpiCaseCountNum;
	
	@FindBy(xpath = "//*[contains(text(), 'Activities count')]/ancestor::*[@kpi-value = 'kpiTile.kpiValue']//*[@class = 'tile__body ng-scope']")
	private WebElement mostCommonPathKpiActivitiesCountNum;
	
	
	//MOST COMMON PATH
	@FindBy(xpath = "//*[contains(text(), 'Most common path')]/ancestor::*[@class = 'col-sm-3 padding-right--lg']")
	private WebElement mostCommonPathSection;
	
	@FindBy(xpath = "//*[@ng-if = 'activateCasesDropdown']")
	private WebElement mostCommonPathCasesDropDown;
	
	@FindBy(xpath = "//*[contains(text(), 'Most common path')]/parent::*/following-sibling::*//*[@class = 'happypath--vertical ng-scope']")
	private WebElement mostCommonPathCasesProcessFlow;
	
	
	//DETECTED DEVIATIONS
	@FindBy(xpath = "//*[contains(text(), 'Detected Deviations')]/ancestor::*[@class = 'fullscreen-app__section']")
	private WebElement detectedDeviationsSection;
	
	@FindBy(xpath = "//*[contains(text(), 'Detected Deviations')]/ancestor::*[@class = 'fullscreen-app__section']//*[@class = 'row']/*")
	private WebElement[] detectedDeviationsTiles;
	
	@FindBy(xpath = "//*[contains(text(), 'Detected Deviations')]/ancestor::*[@class = 'fullscreen-app__section']//*[@class = 'row']/*//*[contains(@class, 'tile__header')]")
	private WebElement[] detectedDeviationsTilesTileHeader; 
	
	@FindBy(xpath = "//*[contains(text(), 'Detected Deviations')]/ancestor::*[@class = 'fullscreen-app__section']//*[@class = 'row']/*//*[@title = 'Case count']")
	private WebElement[] detectedDeviationsTilesCaseCount;
	
	@FindBy(xpath = "//*[contains(text(), 'Detected Deviations')]/ancestor::*[@class = 'fullscreen-app__section']//*[@class = 'row']/*//*[@title = 'Activities count']")
	private WebElement[] detectedDeviationsTilesActivityCount;
		
	@FindBy(xpath = "//*[contains(text(), 'Detected Deviations')]/ancestor::*[@class = 'fullscreen-app__section']//*[@class = 'flex-center']/*[@ng-click = 'ctrl.goToPrev()']")
	private WebElement detectedDeviationsPrevBtn;
	
	@FindBy(xpath = "//*[contains(text(), 'Detected Deviations')]/ancestor::*[@class = 'fullscreen-app__section']//*[@class = 'flex-center']/*[@ng-click = 'ctrl.goToNext()']")
	private WebElement detectedDeviationsNextBtn;
	
	@FindBy(xpath = "//*[contains(text(), 'Detected Deviations')]/ancestor::*[@class = 'fullscreen-app__section']//*[@class = 'flex-center']//span")
	private WebElement detectedDeviationsPageLabel;
	
	@FindBy(xpath = "//*[contains(text(), 'Detected Deviations')]/../following-sibling::*//label")
	private WebElement detectedDeviationsSortingLabel;
	
	@FindBy(xpath = "//*[contains(text(), 'Detected Deviations')]/../following-sibling::*//select")
	private WebElement detectedDeviationsCaseCountDropDown;
	
	@FindBy(xpath = "//*[contains(text(), 'Detected Deviations')]/../following-sibling::*/*[@class = 'input-group']")
	private WebElement detectedDeviationsSearchField;
	
	
	//POSSIBLE ROOT CAUSE
	@FindBy(xpath = "//*[contains(text(), 'root causes')]/ancestor::*[@class = 'fullscreen-app__section']")
	private WebElement possibleRootCauseSection;
	
	@FindBy(xpath = "//*[contains(text(), 'root causes')]/ancestor::*[@class = 'fullscreen-app__section']//*[contains(@class, 'icon')]")
	private WebElement possibleRootCauseSectionIcon;
	
	@FindBy(xpath = "//*[contains(text(), 'root causes')]/ancestor::*[@class = 'fullscreen-app__section']//*[@class = 'main']//div[@class = 'ng-scope']")
	private WebElement possibleRootCauseSectionLink;
	
	@FindBy(xpath = "//*[contains(text(), 'root causes')]/ancestor::*[@class = 'fullscreen-app__section']/following-sibling::*")
	private WebElement rootCauseAnalysisSection;
	
	@FindBy(xpath = "//*[contains(text(), 'root causes')]/ancestor::*[@class = 'fullscreen-app__section']/following-sibling::*//*[@class = 'main']//*[@class = 'icon icon-pi']")
	private WebElement rootCauseAnalysisSectionIcon;
	
	@FindBy(xpath = "//*[contains(text(), 'root causes')]/ancestor::*[@class = 'fullscreen-app__section']/following-sibling::*//*[@class = 'main']//button")
	private WebElement rootCauseAnalysisSectionButton;

	public PurchaseToPayPage(WebDriver driver) {
		
		super(driver);
		
		this.driver = driver;
		wait = getExplicitWait();
		PageFactory.initElements(driver, this);
	}	
	
	public String getActualLoadResultPurchaseToPay() throws Exception {
		
		String getActualLoadResult;
		
		try {
			wait.until(ExpectedConditions.visibilityOf(mostCommonPathKpiSection));	
			wait.until(ExpectedConditions.elementToBeClickable(mostCommonPathKpiEditKpi));	
			wait.until(ExpectedConditions.visibilityOf(mostCommonPathKpiCaseCount));	
			wait.until(ExpectedConditions.visibilityOf(mostCommonPathKpiActivitiesCount));	
			wait.until(ExpectedConditions.visibilityOf(mostCommonPathKpiCaseCountNum));	
			wait.until(ExpectedConditions.visibilityOf(mostCommonPathKpiActivitiesCountNum));	
			
			wait.until(ExpectedConditions.visibilityOf(mostCommonPathSection));	
			wait.until(ExpectedConditions.elementToBeClickable(mostCommonPathCasesDropDown));
			wait.until(ExpectedConditions.visibilityOf(mostCommonPathCasesProcessFlow));	
			
			wait.until(ExpectedConditions.visibilityOf(detectedDeviationsSection));	
			wait.until(ExpectedConditions.visibilityOf(detectedDeviationsPrevBtn));
			wait.until(ExpectedConditions.elementToBeClickable(detectedDeviationsNextBtn));
			wait.until(ExpectedConditions.visibilityOf(detectedDeviationsPageLabel));
			wait.until(ExpectedConditions.visibilityOf(detectedDeviationsSortingLabel)); 
			wait.until(ExpectedConditions.elementToBeClickable(detectedDeviationsCaseCountDropDown));
			wait.until(ExpectedConditions.elementToBeClickable(detectedDeviationsSearchField));
			
			scrollToViewElement(rootCauseAnalysisSectionButton);
			wait.until(ExpectedConditions.visibilityOf(possibleRootCauseSection));
			wait.until(ExpectedConditions.visibilityOf(possibleRootCauseSectionIcon));
			wait.until(ExpectedConditions.elementToBeClickable(possibleRootCauseSectionLink));
			wait.until(ExpectedConditions.visibilityOf(rootCauseAnalysisSection));
			wait.until(ExpectedConditions.visibilityOf(rootCauseAnalysisSectionIcon));
			wait.until(ExpectedConditions.elementToBeClickable(rootCauseAnalysisSectionButton));
			
			verifyAllTileElementsDisplayed();
			getActualLoadResult = getResultIsPreviousBtnNotClickable().equals("true") 
								  ? "true" 
								  : "DetectedDeviationsPrevBtn is clickable in Initial state.";
		} catch (TimeoutException e) {
			getActualLoadResult = e.getMessage();
		}
		
		return getActualLoadResult;
	}
	
	public void verifyAllTileElementsDisplayed() throws Exception {
		
		List<WebElement> listOfTiles = driver.findElements(By.xpath(
				Constant.PurchaseToPayConstant.METRICS_TILE_XPATH));
		List<String> elementExtXpath = List.of(Constant.PurchaseToPayConstant.TILE_HEADER_XPATH_EXT, 
											   Constant.PurchaseToPayConstant.CASE_COUNT_XPATH_EXT, 
											   Constant.PurchaseToPayConstant.ACTIVITIES_COUNT_XPATH_EXT);
			
		for (int x = 1; x <= listOfTiles.size(); x++) {
			if (x > 4) {
				throw new Exception("There are more than 4 tiles displayed in Detected Devitions section");
			}
			
			String tileXpath = "(" + Constant.PurchaseToPayConstant.METRICS_TILE_XPATH + ")[" + x + "]";
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tileXpath)));
			
			for (String extXpath : elementExtXpath) {
				
				String newXpath = tileXpath + extXpath;
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(newXpath)));
			}
		}
	}
	
	public String getResultIsPreviousBtnNotClickable() {
		
		String result;
		
		try {
			wait.until(ExpectedConditions.elementToBeClickable(detectedDeviationsPrevBtn));
			
			result = "false";
		} catch (TimeoutException e) {
			result = "true";
		}
		
		return result;		
	}
}