package testscripts;

import java.util.Map;

import org.testng.annotations.Test;

import genericLibraries.BaseClass;

public class AddAddressTest extends BaseClass {
	@Test
	public void addAddressTest() throws InterruptedException {
		Map<String, String>map=excel.getdata("Sheet1", "Add Adress");
		welcome.clickLoginButton();
		login.loginToApp(map.get("Email"),map.get("Password"));
		Thread.sleep(2000);
		home.clickProfileButton();
		Thread.sleep(2000);
		
	}

}
