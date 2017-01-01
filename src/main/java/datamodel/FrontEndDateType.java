package datamodel;

import java.time.LocalDate;

public class FrontEndDateType {
	private String day;
	private String month;
	private String year;

	private LocalDate date;
	
	
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
		day=Integer.toString(date.getDayOfMonth());
		month=Integer.toString(date.getMonthValue());
		year=Integer.toString(date.getYear());
	}

	public FrontEndDateType() {
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
}