package webmodel;

import org.openqa.selenium.By;
import common.IWebPage;
import datamodel.Person;

/*
 * Class to represent the details page.
 */
public class ApplyPage implements IWebPage {

	// Controls.
	// Personal section:
	private static final By cssTitle = By.cssSelector("button[data-id=dependantTitle]");
	private static final By cssTitleId = By.cssSelector("button[data-id=dependantTitle]+[class='dropdown-menu open']>[class='dropdown-menu inner']>[data-original-index='2'");
	private static final By cssFirstName = By.cssSelector("input#firstName");
	private static final By cssLastName = By.cssSelector("input#lastName");
	private static final By cssGenderMale = By.cssSelector("button-switch[name='applicantGender0']>div[data-toggle='buttons']>label:first-child");
	private static final By cssGenderFemale = By.cssSelector("button-switch[name='applicantGender0']>div[data-toggle='buttons']>label+label");
	private static final By cssAddressLine1 = By.cssSelector("input#addressLine1");
	private static final By cssAddressLine2 = By.cssSelector("input#addressLine2");
	private static final By cssAddressLine3 = By.cssSelector("input#addressLine3");
	private static final By cssPostCode = By.cssSelector("input#postCode");
	private static final By cssTelephonePrefix = By.cssSelector("select[name='intPrefixCode']+div>button[type=button]");
	private static final By cssTelephoneCountry = By.cssSelector("select[name='intPrefixCode']+div>button[type=button]+div>div>input[type='text']");
	private static final By cssTelephone = By.cssSelector("input#telephone");
	private static final By cssEmail = By.cssSelector("input#emailAddr");
	private static final By cssHomeCountry = By.cssSelector("select[name='applicantsHomeCountry']+div>button[type=button]");
	private static final By cssHomeCountryId = By.cssSelector("select[name='applicantsHomeCountry']+div>button[type=button]+div>div>input[type='text']");
	private static final By cssOcupation = By.cssSelector("button[data-id='dependantOccupation']");
	private static final By cssOcupationId = By.cssSelector("button[data-id='dependantOccupation']+[class='dropdown-menu open']>[class='dropdown-menu inner']>[data-original-index='1']");
	
			
	// General:
	private static final By cssRequestCallBack = By.cssSelector("button[ng-click='requestCallback()']");
	private static final By cssGoBack = By.cssSelector("button[ng-click='backToQuoteSummary()']");
	private static final By cssSaveforLater = By.cssSelector("button[ng-click='save()']");
	private static final By cssNext = By.cssSelector("button[ng-click='next()']");

	
	// Error messages.
	// Personal section:
	private static final By cssGenericError = By.cssSelector("#id");
		
	
	// Utilities.
	// Waits for the FirstName element to be visible.
	public void waitForPage() throws Exception {
		WebAppManager.getWebApp().GetElementService().waitForElement(cssTitle);
	}
	
	// Populates all required fields.
	public void fillPage(Person person) throws Exception {
		
		if (person.title != null) {
			WebAppManager.getWebApp().GetElementService().ClickElement(cssTitle);
			WebAppManager.getWebApp().GetElementService().ClickElement(cssTitleId);
		}
		
		if ((person.firstName != null) && (!person.firstName.isEmpty())){
			WebAppManager.getWebApp().GetElementService().EnterText(cssFirstName, person.firstName);
		}
		
		if ((person.lastName != null) && (!person.lastName.isEmpty())){
			WebAppManager.getWebApp().GetElementService().EnterText(cssLastName, person.lastName);
		}
		
		if (person.gender != null){
			if (person.gender.toString() == "MALE"){
				WebAppManager.getWebApp().GetElementService().ClickElement(cssGenderMale);
			}
			else if(person.gender.toString() == "FEMALE"){
				WebAppManager.getWebApp().GetElementService().ClickElement(cssGenderFemale);
			}
	 
		}
		
		if ((person.address.getPrincipalAddress1() != null) && (!person.address.getPrincipalAddress1().isEmpty())){
			WebAppManager.getWebApp().GetElementService().EnterText(cssAddressLine1, person.address.getPrincipalAddress1());
		}
		
		if ((person.address.getPrincipalAddress2() != null) && (!person.address.getPrincipalAddress2().isEmpty())){
			WebAppManager.getWebApp().GetElementService().EnterText(cssAddressLine2, person.address.getPrincipalAddress2());
		}
		
		if ((person.address.getPrincipalAddress3() != null) && (!person.address.getPrincipalAddress3().isEmpty())){
			WebAppManager.getWebApp().GetElementService().EnterText(cssAddressLine3, person.address.getPrincipalAddress3());
		}
		
		if ((person.address.getPostCode() != null) && (!person.address.getPostCode().isEmpty())){
			WebAppManager.getWebApp().GetElementService().EnterText(cssPostCode, person.address.getPostCode());
		}

		if (person.telephoneCountry != null) {
			WebAppManager.getWebApp().GetElementService().ClickElement(cssTelephonePrefix);
			WebAppManager.getWebApp().GetElementService().SelectSearchDropDownItem(cssTelephoneCountry, person.telephoneCountry);
		}
		
		if ((person.telephone != null) && (!person.telephone.isEmpty())){
			WebAppManager.getWebApp().GetElementService().EnterText(cssTelephone, person.telephone);
		}
		
		if ((person.email != null) && (!person.email.isEmpty())){
			WebAppManager.getWebApp().GetElementService().EnterText(cssEmail, person.email);
		}
		
		if (person.homeCountryId != null) {
			WebAppManager.getWebApp().GetElementService().ClickElement(cssHomeCountry);
			WebAppManager.getWebApp().GetElementService().SelectSearchDropDownItem(cssHomeCountryId, person.homeCountryId);
		}
		
		if (person.ocupationId != null) {
			WebAppManager.getWebApp().GetElementService().ClickElement(cssOcupation);
			WebAppManager.getWebApp().GetElementService().ClickElement(cssOcupationId);
		}
				
	}
		
	
	// Clicks on the Next button.
	public void goNext() throws Exception {
		WebAppManager.getWebApp().GetElementService().ClickElement(cssNext);
	}
	
	// Clicks on Save for Later button.
	public void saveForLater() throws Exception {
		WebAppManager.getWebApp().GetElementService().ClickElement(cssSaveforLater);
	}
	
	// Gets displayed error message for DOB field.
	public void goBack() throws Exception {
		WebAppManager.getWebApp().GetElementService().ClickElement(cssGoBack);
	}

	

}

