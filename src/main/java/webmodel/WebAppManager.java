package webmodel;

import java.util.concurrent.ConcurrentHashMap;

import common.IWebApp;

/*
 * Class to manage multiple IWebApp instances.
 */
public class WebAppManager {

	// Instances of web apps, indexed by thread.
	private static ConcurrentHashMap<Long, IWebApp> _instances = new ConcurrentHashMap<Long,IWebApp>();
	
	// Get WebApp instance for the thread.
	public static IWebApp getWebApp() throws Exception {
		//get thread id
		Long id = Thread.currentThread().getId();
		//check created for thread
		if (_instances.containsKey(id)) {
			return _instances.get(id);
		}
		//create new instance
		IWebApp instance = new QuoteAndBuyApp();
		_instances.put(id, instance);
		return instance;
	}
	
}
