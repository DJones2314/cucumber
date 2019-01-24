package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Menu {

	@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000453230000\"]/div/p/span/span/strong")
	private WebElement greenTea;
	
	@FindBy(xpath = "//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[5]/a")
	private WebElement checkoutButton;
	
	public String checkTheMenu(WebDriver driver) {
		
		return greenTea.getText();

	}
	public void clickTheCheckout(WebDriver driver) {
		
		checkoutButton.click(); 
		
	}

	
	
	
}
