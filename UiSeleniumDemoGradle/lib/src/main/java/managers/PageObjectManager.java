package managers;

import org.openqa.selenium.WebDriver;

import pages.BasePage;
import pages.LandingPage;
import pages.LoginPage;
import pages.OrderToCashPage;
import pages.ProcessAnalyticsPage;
import pages.PurchaseToPayPage;
import pages.ServiceNowTicketingPage;

public class PageObjectManager {
	
	private WebDriver driver;
	private LoginPage loginPage;
	private LandingPage landingPage;
	private ProcessAnalyticsPage processAnalyticsPage;
	private OrderToCashPage orderToCashPage;
	private PurchaseToPayPage purchaseToPayPage;
	private ServiceNowTicketingPage serviceNowTicketingPage;
	private BasePage basePage;
	
	public PageObjectManager(WebDriver driver) {

		this.driver = driver;
	}
	
	public LoginPage getLoginPage() {

		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
	}
	
	public LandingPage getLandingPage() {

		return (landingPage == null) ? landingPage = new LandingPage(driver) : landingPage;
	}
	
	public ProcessAnalyticsPage getProcessAnalyticsPage() {

		return (processAnalyticsPage == null) 
				? processAnalyticsPage = new ProcessAnalyticsPage(driver) 
				: processAnalyticsPage;
	}
	
	public OrderToCashPage getOrderToCashPage() {

		return (orderToCashPage == null) 
				? orderToCashPage = new OrderToCashPage(driver) 
				: orderToCashPage;
	}
	
	public PurchaseToPayPage getPurchaseToPayPage() {

		return (purchaseToPayPage == null) 
				? purchaseToPayPage = new PurchaseToPayPage(driver) 
				: purchaseToPayPage;
	}
	
	public ServiceNowTicketingPage getServiceNowTicketingPage() {

		return (serviceNowTicketingPage == null) 
				? serviceNowTicketingPage = new ServiceNowTicketingPage(driver) 
				: serviceNowTicketingPage;
	}
	
	public BasePage getBasePage() {

		return (basePage == null) ? basePage = new BasePage(driver) : basePage;
	}
}