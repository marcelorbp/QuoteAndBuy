package common;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import com.google.common.base.Function;
import config.SeleniumConfig;

public class ElementService {

	private static final Logger logger = LogManager
			.getLogger(WebDriverFactory.class);
	private WebDriver _driver;

	public ElementService(WebDriver driver) {
		this._driver = driver;
	}

	/*
	 * Gets a WebElement for the current page, waits for visibility first
	 */
	public void waitForElement(final By locator) throws Exception {

		logger.debug("Waiting for element with locator : " + locator.toString());
		Integer timeout = SeleniumConfig.getElementLocationTimeout();
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(_driver)
				.withTimeout(timeout, TimeUnit.SECONDS).pollingEvery(500,
						TimeUnit.MILLISECONDS);
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					WebElement element = driver.findElement(locator);
					return element.isDisplayed();
				} catch (Exception e) {
					return false;
				}
			}
		});
	}

	/*
	 * Enters text on an element
	 */
	public void EnterText(final By locator, final String value)
			throws Exception {
		logger.debug("Setting text : " + value + ", on element : "
				+ locator.toString());
		Integer timeout = SeleniumConfig.getElementLocationTimeout();
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(_driver)
				.withTimeout(timeout, TimeUnit.SECONDS).pollingEvery(500,
						TimeUnit.MILLISECONDS);
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					WebElement element = driver.findElement(locator);
					element.clear();
					element.sendKeys(value);
					return true;
				} catch (Exception e) {
					return false;
				}

			}
		});
	}

	/*
	 * Selects an item in a drop down list
	 */
	public void SelectDropDownItem(final By locator, final String value)
			throws Exception {
		logger.debug("Selecting drop down item text " + value
				+ " on element : " + locator.toString());
		Integer timeout = SeleniumConfig.getElementLocationTimeout();
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(_driver)
				.withTimeout(timeout, TimeUnit.SECONDS).pollingEvery(500,
						TimeUnit.MILLISECONDS);
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					WebElement element = driver.findElement(locator);
					Select dropdown = new Select(element);
					dropdown.selectByValue(value);
					return true;
				} catch (Exception e) {
					return false;
				}
			}
		});
	}

	/*
	 * Search and selects an item in a drop down list
	 */
	public void SelectSearchDropDownItem(final By locator, final String value)
			throws Exception {
		logger.debug("Selecting Searching drop down item text " + value
				+ " on element : " + locator.toString());
		Integer timeout = SeleniumConfig.getElementLocationTimeout();
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(_driver)
				.withTimeout(timeout, TimeUnit.SECONDS).pollingEvery(500,
						TimeUnit.MILLISECONDS);
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					WebElement element = driver.findElement(locator);
					element.clear();
					element.sendKeys(value);
					element.sendKeys(Keys.RETURN);
					return true;
				} catch (Exception e) {
					return false;
				}
			}
		});
	}

	/*
	 * Clicks on an element
	 */
	public void ClickElement(final By locator) throws Exception {
		logger.debug("Clicking on element : " + locator.toString());
		Integer timeout = SeleniumConfig.getElementLocationTimeout();
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(_driver)
				.withTimeout(timeout, TimeUnit.SECONDS).pollingEvery(500,
						TimeUnit.MILLISECONDS);
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					WebElement element = driver.findElement(locator);
					element.click();
					return true;
				} catch (Exception e) {
					return false;
				}
			}
		});
	}

	/*
	 * Set Cover Switch value
	 */
	public void SetCoverButtonState(final By locator, final String cover)
			throws Exception {
		logger.debug("Setting radio button state to : " + cover.toString()
				+ ", on element : " + locator.toString());
		Integer timeout = SeleniumConfig.getElementLocationTimeout();
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(_driver)
				.withTimeout(timeout, TimeUnit.SECONDS).pollingEvery(500,
						TimeUnit.MILLISECONDS);
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					WebElement element = driver.findElement(locator);
					String currentstate = element.getClass().toString();
					if (currentstate != "switch switch-sm is-active"
							&& cover != null) {
						element.click();
					}
					return true;
				} catch (Exception e) {
					return false;
				}
			}
		});
	}

	/*
	 * Get Element error message.
	 */
	public String GetElementText(final By locator) throws Exception {
		logger.debug("Getting text for element : " + locator.toString());
		Integer timeout = SeleniumConfig.getElementLocationTimeout();
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(_driver)
				.withTimeout(timeout, TimeUnit.SECONDS).pollingEvery(500,
						TimeUnit.MILLISECONDS);
		String text = wait.until(new Function<WebDriver, String>() {
			public String apply(WebDriver driver) {
				try {
					WebElement element = driver.findElement(locator);
					return element.getText();
				} catch (Exception e) {
					return null;
				}
			}
		});
		return text;
	}

}
