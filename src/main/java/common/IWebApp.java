package common;

public interface IWebApp {

	public void OpenApp(String testname) throws Exception;
	public void CloseApp();
	public ElementService GetElementService();

}
