package datamodel;

public class CoverCombo {

	private String Outpatient;
	private String Dental;
	private String Maternity;
	private String Repatriation;

	public CoverCombo() {
	}

	public void setCoverCombo(String outpatient, String dental, String maternity, String repatriation) {
		Outpatient = outpatient;
		Dental = dental;
		Maternity = maternity;
		Repatriation = repatriation;
	}

	public String getOutpatient() {
		return Outpatient;
	}

	public void setOutpatient(String outpatient) {
		Outpatient = outpatient;
	}

	public String getDental() {
		return Dental;
	}

	public void setDental(String dental) {
		Dental = dental;
	}

	public String getMaternity() {
		return Maternity;
	}

	public void setMaternity(String maternity) {
		Maternity = maternity;
	}

	public String getRepatriation() {
		return Repatriation;
	}

	public void setRepatriation(String repatriation) {
		Repatriation = repatriation;
	}

}
