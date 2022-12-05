package managers;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import enums.DriverType;
import enums.EnvironmentType;

public class WebDriverManager {
	
	private WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;

	public WebDriverManager() {
		
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
	}

	public WebDriver getDriver() throws Exception {
		
		if (driver == null) {
			driver = createDriver();
		}
		
		return driver;
	}

	private WebDriver createDriver() throws Exception {
		
		switch (environmentType) {
		case LOCAL : 
			driver = createLocalDriver();
			break;
			
		case REMOTE : 
			driver = createRemoteDriver();
			break;
			
		default:
			throw new Exception ("Environment Type is not available");
		}
		
		return driver;
	}

	private WebDriver createRemoteDriver() {
		
		throw new RuntimeException("To be implemented in the future");
	}

	private WebDriver createLocalDriver() throws Exception {
		
        switch (driverType) {
        case FIREFOX : 
        	driver = new FirefoxDriver();
	    	break;
	    	
        case CHROME : 
        	driver = new ChromeDriver();
    		break;
    		
        case INTERNET_EXPLORER : 
        	driver = new InternetExplorerDriver();
    		break;
    		
    	default:
    		throw new Exception ("Driver Type is not yet available");
        }

        if (FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) {
        	driver.manage().window().maximize();
        }
        
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(
        		Duration.ofSeconds(
        		FileReaderManager.getInstance().getConfigReader().getImplicitWait()));
        
		return driver;
	}	

	public void quitSession() {
		
		driver.close();
		driver.quit();
	}
}