package config;

import common.BrowserLocations;
import common.BrowserNames;
import common.OSNames;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/*
 * Class to hold all selenium settings
 */
public class SeleniumConfig {
	
	private static final Logger logger = LogManager.getLogger();

	//environment variables
	private static final String cBrowserName = "BROWSER_NAME";
	private static final String cBrowserLocation = "BROWSER_LOCATION";
	private static final String cOperatingSystem = "BROWSER_OS";
	private static final String cBrowserVersion = "BROWSER_VERSION";
	
	//properties files
	private static final String cTimingsConfigFile = "/SeleniumTimings.properties";
	private static final String cGridConfigFile = "/SeleniumGrid.properties";
	
	/*
	 * Gets the name of the browser from env.
	 */
	public static BrowserNames getBrowserName() throws Exception {
		return BrowserNames.valueOf(System.getenv(cBrowserName));
	}
	
	/*
	 * Gets the location of where the browser is to be launched from env.
	 */
	public static BrowserLocations getBrowserLocation() throws Exception {
		return BrowserLocations.valueOf(System.getenv(cBrowserLocation));
	}
	
	/*
	 * Gets the name of the target operating system of the browser
	 */
	public static OSNames getBrowserOS() throws Exception {
		return OSNames.valueOf(System.getenv(cOperatingSystem));
	}
	
	/*
	 * Gets the specified browser version, returns null if not specified
	 */
	public static String getBrowserVersion() throws Exception {
		String version = null;
		try
		{
			version = System.getenv(cBrowserVersion);
		}
		catch (Exception e)
		{
			logger.warn("No browser version is specified");
			version = null;
		}
		return version;
	}
	
	/*
	 * Gets the url of the selenium grid hub, based on the browser location
	 */
	public static URL getHubURL() throws Exception {
		BrowserLocations location = BrowserLocations.valueOf(System.getenv(cBrowserLocation));
		String key = location.toString().toLowerCase() + ".huburl";
		String value = ReadPropertyValue(cGridConfigFile, key);
		return new URL(value);
	}
	
	/*
	 * Gets the script timings setting
	 */
	public static Integer getScriptTimeout() throws Exception {
		BrowserLocations location = BrowserLocations.valueOf(System.getenv(cBrowserLocation));
		String key = location.toString().toLowerCase() + ".scripttimeout";
		String value = ReadPropertyValue(cTimingsConfigFile, key);
		return Integer.parseInt(value);
	}
	
	/*
	 * Gets the page load timings setting
	 */
	public static Integer getPageLoadTimeout() throws Exception {
		BrowserLocations location = BrowserLocations.valueOf(System.getenv(cBrowserLocation));
		String key = location.toString().toLowerCase() + ".pageload";
		String value = ReadPropertyValue(cTimingsConfigFile, key);
		return Integer.parseInt(value);
	}
	
	/*
	 * Gets the element location timings setting
	 */
	public static Integer getElementLocationTimeout() throws Exception {
		BrowserLocations location = BrowserLocations.valueOf(System.getenv(cBrowserLocation));
		String key = location.toString().toLowerCase() + ".elementlocation";
		String value = ReadPropertyValue(cTimingsConfigFile, key);
		return Integer.parseInt(value);
	}
	
	/*
	 * Gets the location of the relevant web driver for browser name and location
	 */
	public static String getDriverLocation() throws Exception {
		BrowserLocations location = BrowserLocations.valueOf(System.getenv(cBrowserLocation));
		BrowserNames browsername = BrowserNames.valueOf(System.getenv(cBrowserName));
		String drivername = null;
		switch (browsername) {
			case Firefox:
				drivername = "geckodriver";
				break;	
			case Chrome:
				drivername = "chromedriver";
				break;			
			case InternetExplorer:
				drivername = "IEDriverServer";
				break;		
		default:
			throw new Exception("Unknown browser driver name");
		}
		String key = location.toString().toLowerCase() + "." + drivername + ".path";
		String value = ReadPropertyValue(cGridConfigFile, key);
		logger.debug("Driver location = " + value);
		return value;
	}
	
	/*
	 * Gets the saucelabs username
	 */
	public static String getSauceLabsUserName() throws Exception {
		String key = "saucelabs.username";
		String value = ReadPropertyValue(cGridConfigFile, key);
		logger.debug("Saucelabs user = " + value);
		return value;
	}
	
	/*
	 * Gets the saucelabs access key
	 */
	public static String getSauceLabsAccessKey() throws Exception {
		String key = "saucelabs.accesskey";
		String value = ReadPropertyValue(cGridConfigFile, key);
		logger.debug("Saucelabs key = " + value);
		return value;
	}
	
	
	// Read value from properties file
	private static String ReadPropertyValue(String file, String key) throws Exception {
		Properties prop = new Properties();
		InputStream input = null;
		String result = null;
		try {
			input = SeleniumConfig.class.getResourceAsStream(file);
			prop.load(input);
			result = prop.getProperty(key);
		} finally {
			if (input != null) {
				input.close();
			}
		}
		return result;
	}
	
}
