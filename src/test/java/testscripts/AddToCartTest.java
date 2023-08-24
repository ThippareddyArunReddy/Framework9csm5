package testscripts;

import java.util.Map;

import org.testng.annotations.Test;

import genericLibraries.BaseClass;

public class AddToCartTest extends BaseClass {
	@Test
	public void addToCartTest() throws InterruptedException {
		Map<String, String>map=excel.getdata("Sheet1","Add Adress");
		welcome.clickLoginButton();
		login.loginToApp(map.get("Email"),map.get("Password"));
		Thread.sleep(2000);
		
	}

}
