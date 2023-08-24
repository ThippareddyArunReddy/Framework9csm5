package pormPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	//Declration
	@FindBy(xpath="//div[@class='cart_productDetails__pKWBd']/h3")
	private WebElement cartItem;
	
	//Intialization
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public String getcartitem() {
		return cartItem.getText();
	}

}
