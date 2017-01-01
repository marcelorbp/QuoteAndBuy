package tests;

import java.time.LocalDate;
import webmodel.ApplyPage;
import webmodel.DetailsPage;
import webmodel.QuotePage;
import org.testng.annotations.Test;
import datamodel.Person;

public class SimpleQuote extends BaseTest {

	@Test(description="Attempts to enter a quote")
	public void oneMemberQuote() throws Exception {
		
		Person person = new datamodel.Person();

		person.firstName = "Automation";
		person.personDateOfBirth.setDate(LocalDate.now().minusYears(30));
		person.nationalityCountry = "Spain";
		person.residenceCountry = "Hong Kong";
		person.regionofCover = "Worldwide";
		person.payCurrency = "EUR";
		person.phCover.setOutpatient("Out");
		person.phCover.setMaternity("Mat");
		person.phCover.setDental("Den");
		person.phCover.setRepatriation("Rep");
		person.declaration = true;
		person.title = Person.Title.DR;
		person.lastName = "Smith";
		person.gender = Person.Gender.MALE;
		person.address.setPrincipalAddress1("Street 1");
		person.address.setPrincipalAddress2("Street 2");
		person.address.setPrincipalAddress3("Street 3");
		person.address.setPostCode("Dublin 2");
		person.telephoneCountry = "Germany";
		person.telephone = "12345678";
		person.email = "test@email.com";
		person.homeCountryId = "Portugal";
		person.ocupationId = "Administrative"; 
		
				
		// Fill data.
		DetailsPage pageDetails = new DetailsPage();
		pageDetails.fillPage(person);
		
		// Submit page.
		pageDetails.waitForPage();
		pageDetails.getQuote();

		// Quote Page loads. 
		QuotePage pageQuote = new QuotePage();
		pageQuote.waitForPage();
		
		// Change quote.
		pageQuote.changeCover();
		
		// Apply for quote.
		pageQuote.waitForPage();
		pageQuote.applyforQuote();
		
		// Apply Page loads. 
		ApplyPage pageApply = new ApplyPage();
		pageApply.waitForPage();
		
		// Fill data.
		pageApply.fillPage(person);
	
		pageApply.goNext();
		
		
	}

}