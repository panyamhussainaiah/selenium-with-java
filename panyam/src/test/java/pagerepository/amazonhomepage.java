package pagerepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class amazonhomepage {
	@FindBy(xpath="//span[@class='nav-line-2 'and text()='Account & Lists']")WebElement account;
	@FindBy(xpath="//span[@class='nav-action-inner' and text()='Sign in']")WebElement signin;
	@FindBy(id="ap_email")WebElement email;
	@FindBy(id="continue")WebElement continuebtn;
	@FindBy(id="ap_password")WebElement password;
	@FindBy(id="signInSubmit")WebElement signInbtn;
	
	
	public void SignIn(WebDriver driver,String phonenumber,String pswd) {
		Actions a=new Actions(driver);
	 a.moveToElement(account).build().perform();
	 signin.click();
	 email.sendKeys(phonenumber);
	 continuebtn.click();
	 password.sendKeys(pswd);
	 signInbtn.click();
	}
	}




