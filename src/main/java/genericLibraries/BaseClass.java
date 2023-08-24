package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pormPages.CartPage;
import pormPages.HeadphonePage;
import pormPages.HomePage;
import pormPages.MyAddressPage;
import pormPages.MyProfilePage;
import pormPages.ShopperLoginPage;
import pormPages.SignUp;
import pormPages.WelcomePage;

public class BaseClass {
	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected JavaUtility jutil;
	protected WebDriverUtility webUtil;
	public static WebDriver driver;
	public static WebDriver sdriver;
	
	protected WelcomePage welcome;
	protected ShopperLoginPage login;
	protected SignUp home;
	protected SignUp signUp;
	protected MyProfilePage myProfile;
	protected MyAddressPage myAddress;
	protected HeadphonePage hedHeadphone;
	protected CartPage cart;
	protected MyAddressPage address;
	
	//@BeforeSuite
	//BeforeTest
	
	@BeforeClass
	public void classConfiguration() {
		property=new PropertiesUtility();
		excel=new ExcelUtility();
		jutil=new JavaUtility();
		webUtil=new WebDriverUtility();
		property.propertiesInit(IConstantPath.PROPERTIES_PATH);
		excel.excelInit(IConstantPath.EXCEL_PATH);
	}
	@BeforeMethod
	public void methodConfiguration() {
		driver=webUtil.navigateToApp(property.getdata("browser"), property.getdata("url"), Long.parseLong(property.getdata("time")));
		sdriver=driver;
		welcome=new WelcomePage(driver);
		login=new ShopperLoginPage(driver);
		home=new SignUp(driver);
		myProfile=new MyProfilePage(driver);
		myAddress = new MyAddressPage(driver);
		hedHeadphone=new HeadphonePage(driver);
		cart=new CartPage(driver);
		address=new MyAddressPage(driver);	
	}
	@AfterMethod
	public void methodTeardown() {
		home.clickLogout();
		webUtil.closeAllBrowsers();
	}
	@AfterClass
	public void classTeardown() {
		excel.closeExcel();
	}
	//@AfterTest
	  //AfterSuite
	
	
	
	

}
