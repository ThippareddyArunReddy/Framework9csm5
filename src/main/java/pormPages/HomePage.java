package pormPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//Declration
	
	@FindBy(xpath="//button[@aria-label='Account settings']")
	private WebElement profileButton;
	
	@FindBy(xpath="//li[.='My Profile']")
	private WebElement myProfile;
	
	@FindBy(xpath="//li[.='Logout']")
	private WebElement logout;
	
	@FindBy(xpath="//a[text()='Electronic']")
	private WebElement electronicsTab;
	
	@FindBy(xpath="//a[text()='Headphones']")
	private WebElement HeadPhones;
	
	//intialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public void clickProfileButton() {
		profileButton.click();
	}
	public void selectMyProfile() {
		myProfile.click();
	}
	public void clickLogout() {
		//TODO Auto-generated method stub
	}

}
