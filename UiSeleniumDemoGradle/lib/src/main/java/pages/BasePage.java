package pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.Constant;
import managers.FileReaderManager;

public class BasePage {
	
	private WebDriverWait wait;
	private WebDriver driver;
	
	public BasePage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void takeScreenshot(String folderName, String screenshotName) {
			
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constant.BasePageConstant.DATE_FORMAT);
		LocalDateTime dateTime = LocalDateTime.now();
		
		if (screenshotName.equals("")) {
			screenshot(folderName, dateTime.format(formatter));
		} else {
			screenshot(folderName, screenshotName + "-" + dateTime.format(formatter));
		}
	}
	
	public void screenshot(String scenario, String screenshotName) {
		
		TakesScreenshot ss = (TakesScreenshot) driver;
		File file = ss.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(file, 
					new File("./failedTests/" + scenario + "/" + screenshotName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public WebDriverWait getExplicitWait() {
		
		if (wait == null) {
			wait = setupExplicitWait();
		}
		
		return wait;
	}
	
	public WebDriverWait setupExplicitWait() {
		
		wait = new WebDriverWait(driver, 
				Duration.ofSeconds(FileReaderManager.getInstance().getConfigReader().getExplicitWait()));
		
		return wait;
	}
	
	public void waitForPageToLoad(Integer iteration) throws InterruptedException {
		
		JavascriptExecutor jScript = (JavascriptExecutor) driver;
		
		wait.until((ExpectedCondition<Boolean>) wd ->
			((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
		
		Integer count = 0;
		
        if ((Boolean) jScript.executeScript("return window.jQuery != undefined")) {
            while (!(Boolean) jScript.executeScript("return jQuery.active == 0")) {
				Thread.sleep(1000);
				
				if(count > iteration) {
					break;
				}
				
				count++;
            }
        }
	}
	
	public void scrollToViewElementBy(By by) {
		
		WebElement element = driver.findElement(by);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void scrollToViewElement(WebElement element) {
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public boolean getActualUrlResult (String page) {
		
		boolean actualUrlResult;
		
		String extension = 	page.replaceAll(" ", "").equalsIgnoreCase("ProcessAnalyticsPage") 
							? "process-mining/ui"
							: "process-mining/analysis";
		
		try {
			wait.until(ExpectedConditions.urlContains(extension));
			
			actualUrlResult = true;
		} catch (Exception e) {
			actualUrlResult = false;
		}
		
		return actualUrlResult;
	}
}