package pagerepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class searchpage {
	@FindBy(id="twotabsearchtextbox")WebElement text;
	@FindBy(id="nav-search-submit-button")WebElement searchbtn;
    public void searchaction(String textsearched) {
    	text.sendKeys(textsearched);
    	searchbtn.click();
    }
	
    
  }
	
	
