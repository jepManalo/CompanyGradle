package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends BasePage {

	private WebDriverWait wait;
	
	@FindBy(xpath = "//button[@class = 'ce-cloud-header-link'][@icon = 'overflow-menu-horizontal']")
	private WebElement moreBtn;
	
	@FindBy(xpath = "//*[contains(text(), 'Process Analytics')]")
	private WebElement processAnalytics;
	
	@FindBy(xpath = "//*[@id = 'cdk-overlay-0']")
	private WebElement morePanel;
	
	public LandingPage(WebDriver driver) {
		
		super(driver);
		
		wait = getExplicitWait();
		PageFactory.initElements(driver, this);
	}	
	
	public void clickMoreBtn() {
		
		wait.until(ExpectedConditions.elementToBeClickable(moreBtn));
		moreBtn.click();
		wait.until(ExpectedConditions.visibilityOf(morePanel));
	}
	
	public void clickProcessAnalytics() {
		
		wait.until(ExpectedConditions.visibilityOf(processAnalytics));
		wait.until(ExpectedConditions.elementToBeClickable(processAnalytics));
		processAnalytics.click();
		wait.until(ExpectedConditions.invisibilityOf(morePanel));
	}
	
	public void navigateToProcessAnalytics () throws InterruptedException {
		
		clickMoreBtn();
		clickProcessAnalytics();
		
		waitForPageToLoad(30);
	}
}