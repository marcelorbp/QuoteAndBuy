package common;

/*
 * Enum of operating systems
 */
public enum OSNames {
	Windows10 ("Windows 10"),
	Windows7 ("Windows 7"),
	Linux ("Linux");
	
	private final String capabilityname;
	
	private OSNames(String text) {
		this.capabilityname = text;
	}
	
	public String getCapability() {
		return capabilityname;
	}
}
