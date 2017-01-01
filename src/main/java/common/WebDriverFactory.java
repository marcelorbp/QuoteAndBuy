package common;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import config.SeleniumConfig;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/*
 * Class to create and configure a WebDriver instance
 */
public class WebDriverFactory {
	
	 private static final Logger logger = LogManager.getLogger(WebDriverFactory.class);

	/*
	 * Creates a web driver instance
	 */
	public static WebDriver GetWebDriver(String testname) throws Exception {
		logger.debug("Creating webdriver instance for test : " + testname);
		WebDriver result = null;
		switch (SeleniumConfig.getBrowserLocation()) {
			case Local:
				result = GetLocalDriver();
				break;
			case LocalGrid:
				result = GetGridDriver(testname);
				break;
			case SauceLabs:
				result = GetGridDriver(testname);
				break;
			default:
				throw new Exception("Unknown browser location");
		}
		//set timings
		result.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		result.manage().timeouts().setScriptTimeout(SeleniumConfig.getScriptTimeout(), TimeUnit.SECONDS);
		//result.manage().timeouts().pageLoadTimeout(SeleniumConfig.getPageLoadTimeout(), TimeUnit.SECONDS);
		
		return result;
		
	}
	
	/*
	 * Creates a web driver for local execution
	 */
	private static WebDriver GetLocalDriver() throws Exception {
		WebDriver result = null;
		switch (SeleniumConfig.getBrowserName()) {
			case Firefox:
				System.setProperty("webdriver.gecko.driver", SeleniumConfig.getDriverLocation());
				result = new FirefoxDriver();
				break;
			case Chrome:
				System.setProperty("webdriver.chrome.driver", SeleniumConfig.getDriverLocation());
				result = new ChromeDriver();
				break;
			case InternetExplorer:
				System.setProperty("webdriver.ie.driver", SeleniumConfig.getDriverLocation());
				result = new InternetExplorerDriver();
				break;	
			default:
				throw new Exception("Browser not supported for local execution");
		}
		return result;
	}
	
	/*
	 * Creates a new remote web driver for selenium grid
	 */
	private static RemoteWebDriver GetGridDriver(String testname) throws Exception {
		RemoteWebDriver result = null;
		DesiredCapabilities capabilities = null;
		switch (SeleniumConfig.getBrowserName()) {
			case Firefox:
				capabilities = DesiredCapabilities.firefox();
				break;
			case Chrome:
				capabilities = DesiredCapabilities.chrome();
				break;
			case InternetExplorer:
				capabilities = DesiredCapabilities.internetExplorer();
				break;
//			case Edge:
//				capabilities = DesiredCapabilities.edge();
			default:
				throw new Exception("Unknown browser name");
		}
		URL huburl = SeleniumConfig.getHubURL();
		//additional saucelabs setup
		BrowserLocations location = SeleniumConfig.getBrowserLocation();
		if (location == BrowserLocations.SauceLabs) {
			switch (SeleniumConfig.getBrowserOS()) {
				case Windows10:
					capabilities.setCapability("platform", OSNames.Windows10.getCapability());
					break;
				case Windows7:
					capabilities.setCapability("platform", OSNames.Windows7.getCapability());
					break;
				case Linux:
					capabilities.setPlatform(Platform.LINUX);
					break;
				default:
					throw new Exception("Unknown OS name");
			}
			String username = SeleniumConfig.getSauceLabsUserName();
			String accesskey = SeleniumConfig.getSauceLabsAccessKey();
			String browserversion = SeleniumConfig.getBrowserVersion();
			if (browserversion == null) throw new Exception("No browser version to pass to saucelabs");
			capabilities.setCapability("version", browserversion);
			capabilities.setCapability("username", username);
			capabilities.setCapability("accessKey", accesskey);
			capabilities.setCapability("name", testname);
		}
		result = new RemoteWebDriver(huburl, capabilities);
		return result;
	}
	
}
