package webmodel;

import org.openqa.selenium.By;
import common.IWebPage;
import datamodel.Person;

/*
 * Class to represent the details page.
 */
public class DetailsPage implements IWebPage {

	// Controls.
	// Personal section:
	private static final By cssFirstName = By.cssSelector("input#firstName");
	private static final By cssDay = By.cssSelector("awc-date#applicantsAge select#day");
	private static final By cssMonth = By.cssSelector("awc-date#applicantsAge select#month");	
	private static final By cssYear = By.cssSelector("awc-date#applicantsAge #year");
	private static final By cssNationality = By.cssSelector("button[title='Nationality']");	
	private static final By cssNationalityCountry = By.cssSelector("button[title='Nationality']+[class='dropdown-menu open']>[class='bs-searchbox']>[type='text']");
	private static final By cssDependant = By.cssSelector("button[ng-click='addDependant()']");
	private static final By cssRelationship = By.cssSelector("button[title='Relationship']");
	private static final By cssRelationshipType = By.cssSelector("button[title='Relationship']+[class='dropdown-menu open']>[class='dropdown-menu inner']>[data-original-index='1']");
	private static final By cssDepDay = By.cssSelector("select#dependantAge1 #day");
	private static final By cssDepMonth = By.cssSelector("select#dependantAge1 #monnth");
	private static final By cssDepYear = By.cssSelector("input#dependantAge1 #year");
	
	// Cover section:
	private static final By cssResidence = By.cssSelector("button[title='Country of residence']");
	private static final By cssResidenceCountry = By.cssSelector("button[title='Country of residence']+[class='dropdown-menu open']>[class='bs-searchbox']>[type='text']");
	private static final By cssStartDate = By.cssSelector("input#policyStartDate");
	private static final By cssRegionofCover = By.cssSelector("button[title='Area of Cover']");
	private static final By cssRegionofCoverId = By.cssSelector("button[data-id='geoAreaCover']+[class='dropdown-menu open']>[class='dropdown-menu inner']>[data-original-index='2']");
	private static final By cssPayCurrency = By.cssSelector("button[title='Payment currency']");
	private static final By cssPayCurrencyId = By.cssSelector("button[title='Payment currency']+[class='dropdown-menu open']>[class='dropdown-menu inner']>[data-original-index='3']");
	
	// Extras section:
	private static final By cssOutpatient = By.cssSelector("toggle-switch[popover-element-id='extraPopover0']>div[ng-click='toggle()']");
	private static final By cssMaternity = By.cssSelector("toggle-switch[popover-element-id='extraPopover1']>div[ng-click='toggle()']");
	private static final By cssDental= By.cssSelector("toggle-switch[popover-element-id='extraPopover2']>div[ng-click='toggle()']");
	private static final By cssRepatriation = By.cssSelector("toggle-switch[popover-element-id='extraPopover3']>div[ng-click='toggle()']");
	
	// General:
	private static final By cssDeclaration = By.cssSelector("input#declaration+span[class='ng-scope']");
	private static final By cssGetQuote = By.cssSelector("button[ng-click='submitQuoteRequest()']");
	private static final By cssClearDetails = By.cssSelector("button[ng-click='clearQuoteDetails()']");
	private static final By cssPromoCode = By.cssSelector("input#promoCode");
	private static final By cssRequestCallBack = By.cssSelector("button[ng-click='requestCallback()']");
	

	// Error messages.
	// Personal section:
	private static final By cssGenericDOBError = By.cssSelector("div[ng-show='riskInfoFormIsSubmitted || riskInfoForm.applicantsAge.$touched']");
		
	
	public void waitForPage() throws Exception {		
		WebAppManager.getWebApp().GetElementService().waitForElement(cssFirstName);
	}
	
	
	public void fillPage(Person person) throws Exception {
		if ((person.firstName != null) && (!person.firstName.isEmpty())){
			WebAppManager.getWebApp().GetElementService().EnterText(cssFirstName, person.firstName);
		}
		
		
		if (person.personDateOfBirth.getDay() != null) {
			WebAppManager.getWebApp().GetElementService().SelectDropDownItem(cssDay, person.personDateOfBirth.getDay());
		}
		
		
		if (person.personDateOfBirth.getMonth() != null) {
			WebAppManager.getWebApp().GetElementService().SelectDropDownItem(cssMonth, person.personDateOfBirth.getMonth());
		}
		
		
		if ((person.personDateOfBirth.getYear() != null) && (!person.personDateOfBirth.getYear().isEmpty())) {
			WebAppManager.getWebApp().GetElementService().EnterText(cssYear, person.personDateOfBirth.getYear().toString());
		}
		
		
		if (person.nationalityCountry != null) {
			WebAppManager.getWebApp().GetElementService().ClickElement(cssNationality);
			WebAppManager.getWebApp().GetElementService().SelectSearchDropDownItem(cssNationalityCountry, person.nationalityCountry);
		}
		
		
		if (person.residenceCountry != null) {
			WebAppManager.getWebApp().GetElementService().ClickElement(cssResidence);
			WebAppManager.getWebApp().GetElementService().SelectSearchDropDownItem(cssResidenceCountry, person.residenceCountry.toString());
		}
		
		
		if (person.regionofCover != null) {
			WebAppManager.getWebApp().GetElementService().ClickElement(cssRegionofCover);
			WebAppManager.getWebApp().GetElementService().ClickElement(cssRegionofCoverId);
		}
		
		
		if (person.payCurrency != null) {
			WebAppManager.getWebApp().GetElementService().ClickElement(cssPayCurrency);
			WebAppManager.getWebApp().GetElementService().ClickElement(cssPayCurrencyId);
		}
		
		
		if (person.phCover.getOutpatient() != null) {
			WebAppManager.getWebApp().GetElementService().SetCoverButtonState(cssOutpatient, person.phCover.getOutpatient());
		}
		
			
		if (person.phCover.getMaternity() != null) {
			WebAppManager.getWebApp().GetElementService().SetCoverButtonState(cssMaternity, person.phCover.getMaternity());
		}
		
		
		if (person.phCover.getDental() != null) {
			WebAppManager.getWebApp().GetElementService().SetCoverButtonState(cssDental, person.phCover.getDental());
		}
		
		
		if (person.phCover.getRepatriation() != null) {
			WebAppManager.getWebApp().GetElementService().SetCoverButtonState(cssRepatriation, person.phCover.getRepatriation());
		}
		
		
		if (person.declaration != null) {
			WebAppManager.getWebApp().GetElementService().ClickElement(cssDeclaration);
		}
				
		
	}
		
	
	// Clicks on the Get Quote button.
	public void getQuote() throws Exception {
		WebAppManager.getWebApp().GetElementService().ClickElement(cssGetQuote);
	}
	
	
	// Clicks on the Clear Details button.
	public void clearDetails() throws Exception {
		WebAppManager.getWebApp().GetElementService().ClickElement(cssClearDetails);
	}
	
	
	// Gets displayed error message for DOB field.
	public String getDOBErrorMessage() throws Exception {
		return WebAppManager.getWebApp().GetElementService().GetElementText(cssGenericDOBError);
	}

	
	
}

