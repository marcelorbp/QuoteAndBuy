package tests;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import common.IWebApp;
import webmodel.WebAppManager;


/*
 * Base class of all test case classes
 */
public class BaseTest {
	
	@BeforeMethod
	public void BeforeTest(Method method) throws Exception {
		//create web app instance in manager
		IWebApp app = WebAppManager.getWebApp();
		//open app specifying test method name
		app.OpenApp(method.getName());
	}
	
	@AfterMethod
	public void AfterTest() throws Exception {
		IWebApp app = WebAppManager.getWebApp();
		app.CloseApp();
	}

}
