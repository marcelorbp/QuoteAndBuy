package tests;

import java.time.LocalDate;
import org.testng.annotations.Test;
import datamodel.Person;
import junit.framework.Assert;
import webmodel.DetailsPage;


public class ValidationTest extends BaseTest {

	@Test(description="Verify Mandatory trigger and error message for Date of Birth.")
	public void mandatoryDOB() throws Exception {
		
		Person person = new datamodel.Person();
		
		person.firstName = "Automation";
		person.personDateOfBirth.setDay("5");
		person.personDateOfBirth.setMonth("10");
		person.personDateOfBirth.setYear(null);
		person.nationalityCountry = "Spain";
		person.residenceCountry = "Hong Kong";
		person.regionofCover = "Worldwide";
		person.payCurrency = "EUR";
		person.phCover.setOutpatient("Out");
		person.phCover.setMaternity("Mat");
		person.phCover.setDental("Den");
		person.phCover.setRepatriation("Rep");
		person.declaration = true;
		
		// Fill data.
		DetailsPage pageDetails = new DetailsPage();
		pageDetails.fillPage(person);
		
		// Submit page.
		pageDetails.getQuote();
 
		// Assert on error message.
		String apperrortext = pageDetails.getDOBErrorMessage();
		String expectederror = "Mandatory field";
		Assert.assertTrue(apperrortext.contains(expectederror));
		
		
	}
	
	
	@Test(description="Verify Invalid trigger and error message for Date of Birth.")
	public void invalidDOB() throws Exception {
		
		Person person = new datamodel.Person();
		
		person.firstName = "Automation";
		person.personDateOfBirth.setDate(getDateWithYear(-150));
				
		person.nationalityCountry = "Spain";
		person.residenceCountry = "Hong Kong";
		person.regionofCover = "Worldwide";
		person.payCurrency = "EUR";
		person.phCover.setOutpatient("Out");
		person.phCover.setMaternity("Mat");
		person.phCover.setDental("Den");
		person.phCover.setRepatriation("Rep");
		person.declaration = true;
		
		// Fill data.
		DetailsPage pageDetails = new DetailsPage();
		pageDetails.fillPage(person);
		
		// Submit page.
		pageDetails.getQuote();
 
		// Assert on error message.
		String apperrortext = pageDetails.getDOBErrorMessage();
		String expectederror = "Main applicant age must be between 18 and 75.";
		Assert.assertTrue(apperrortext.contains(expectederror));
				
	}


	private LocalDate getDateWithYear(int i) {
		if(i<0){
			return LocalDate.now().minusYears(i);
		}
		else{
			return LocalDate.now().plusYears(i);
		}
	}
		
}