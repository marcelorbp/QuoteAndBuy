package webmodel;

import org.openqa.selenium.By;
import common.IWebPage;

/*
 * Class to represent the details page.
 */
public class QuotePage implements IWebPage {

	// Controls.
	private static final By cssRequestCallback = By.cssSelector("button[ng-click='requestCallback()']");
	private static final By cssBestMatch = By.cssSelector("div[ng-click='bestMatchClick()']");
	private static final By cssChangeCover = By.cssSelector("div[ng-click='buildQuoteClick()']");
	private static final By cssCore = By.cssSelector("div[ng-click='buildQuoteClick()']");	
	
	private static final By cssApply = By.cssSelector("button[ng-click='apply()']");
	private static final By cssSaveQuote = By.cssSelector("div[ng-click='saveQuote()']");
	private static final By cssBack = By.cssSelector("div[ng-click='backToRiskDetails(false)']");
	private static final By cssPrintQuote = By.cssSelector("div[ng-click='openPrintableViewAndPrint()']");
	

	
	// Error messages.
	private static final By cssFirstNameErrorMessage = By.cssSelector("span#firstnamemessage");
	private static final By cssLastNameErrorMessage = By.cssSelector("span#lastnamemessage");
	private static final By cssTitleErrorMessage = By.cssSelector("span#titlemessage");
	private static final By cssAgeErrorMessage = By.cssSelector("span#AgeMessage");
	private static final By cssEmailErrorMessage = By.cssSelector("span#email1message");
	
	public void waitForPage() throws Exception {
		// Waits for the FirstName element to be visible.
		WebAppManager.getWebApp().GetElementService().waitForElement(cssRequestCallback);
	}
	
	// Clicks on the Apply button.
	public void applyforQuote() throws Exception {
		WebAppManager.getWebApp().GetElementService().ClickElement(cssApply);
	}
	
	// Clicks on the Change Cover button.
	public void changeCover() throws Exception {
		WebAppManager.getWebApp().GetElementService().ClickElement(cssChangeCover);
	}
	
	
}


