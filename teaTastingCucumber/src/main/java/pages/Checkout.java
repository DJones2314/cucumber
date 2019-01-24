package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Checkout {

	@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000451990420\"]/div/pre/strong/span")
	private WebElement billingInfo;
	
	public String checkThatCheck(WebDriver driver) {
		return billingInfo.getText();
	}
	
}
