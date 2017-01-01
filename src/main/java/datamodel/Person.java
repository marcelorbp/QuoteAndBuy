package datamodel;

import java.util.concurrent.ThreadLocalRandom;

/*
 * Class that represents a quote to generate
 */
public class Person {
	
	public String firstName;
	public FrontEndDateType personDateOfBirth = new FrontEndDateType();
	public String nationality;
	public String nationalityCountry;
	public String dependant;
	public String relationship;
	public String relationshipType;
	
	public FrontEndDateType depDateOfBirth = new FrontEndDateType();
	
	public String residence;
	public String residenceCountry;	
	public String startDate;
	public String regionofCover;
	public String payCurrency;
	
	public CoverCombo phCover = new CoverCombo();	
	
	public Boolean declaration;
	public Title title;
	public String lastName;
	public Gender gender;
	public String genderFemale;
	public Address address= new Address();
	public String telephonePrefix;
	public String telephoneCountry;
	public String telephone;
	public String email;
	public String homeCountry;
	public String homeCountryId;
	public String ocupation;
	public String ocupationId;
	
	// Applicant gender.
	public enum Gender {
		MALE,
		FEMALE
	}
	
	// Applicant title.
	public enum Title {
		DR,
		MR,
		MRS,
		MS
	}
	
	
	// Applicant day DOB. 
	public class Day {

		private String _value;
		
		public Day() {
			int min = 1, max = 28;
			Integer randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
			_value = randomNum.toString();
		}
		
		public String getDay() {
			return _value;
		}
		
		public void setDay(String value) {
			this._value = value;
		}
	}
	
	
	// Applicant month DOB. 
	public enum Month {
		Jan ("1"),
		Feb ("2"),
		Mar ("3"),
		Apr ("4"),
		May ("5"),
		Jun ("6"),
		Jul ("7"),
		Aug ("8"),
		Sep ("9"),
		Oct ("10"),
		Nov ("11"),
		Dec ("12");
		
		private final String _month;
		private Month(String text) {
			this._month = text;
		}
			
		@Override
		public String toString() {
			return _month;
		}
	}

	
	// Applicant year DOB. 	
	public class Year {

		private String _value;
		
		public Year() {
			int min = 1920, max = 2000;
			Integer randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
			_value = randomNum.toString();
		}
		
		public String getYear() {
			return _value;
		}
		
		public void setYear(String value) {
			this._value = value;
		}
		
	}
	
	
}
