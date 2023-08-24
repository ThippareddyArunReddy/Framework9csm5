package pormPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;

public class AddressFormPage {
	//Declration
	
	@FindBy(id="Name")
	private WebElement nameTF;
	
	@FindBy(id="House/Office Info")
	private WebElement houseInfoTF;
	
	@FindBy(id="Street Info")
	private WebElement streetInfoTF;
	
	@FindBy(id="Street Info")
	private WebElement landmarkTF;
	
	@FindBy(id="Country")
	private WebElement countryDropdown;
	
	@FindBy(id="State")
	private WebElement stateDropdown;
	
	@FindBy(id="City")
	private WebElement cityDropdown;
	
	@FindBy(id="Pincode")
	private WebElement pincodeTF;
	
	@FindBy(id="Phone Number")
	private WebElement phoneNUmberTF;
	
	@FindBy(xpath="//button[text()='Add Address']")
	private WebElement addAdressbutton;
	
	//intialization
	public AddressFormPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilization
	public void addadressDetails(WebDriverUtility web,String name,String houseInfo,String street,String landmark,
			String country,String state,String city,String pincode,String phonenum) {
		nameTF.sendKeys(name);
		houseInfoTF.sendKeys(houseInfo);
		streetInfoTF.sendKeys(street);
		landmarkTF.sendKeys(landmark);
		web.selectFromDropdown(country, countryDropdown);
		web.selectFromDropdown(state, stateDropdown);
		web.selectFromDropdown(city, cityDropdown);
		pincodeTF.sendKeys(pincode);
		phoneNUmberTF.sendKeys(phonenum);
		addAdressbutton.click();
	}
	

}
