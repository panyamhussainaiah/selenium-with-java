package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class browserfactory {
	public WebDriver startup(WebDriver driver,String browsertype,String url,int pageloadwait,int implicitwait,int explicitwait) {
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
		switch(browsertype) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new  ChromeDriver(dc);
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver(dc);
			break;
		case "opera":
			WebDriverManager.operadriver().setup();
			driver=new OperaDriver(dc);
			break;
			default:
				System.out.println("invalid browsertype");
				
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,explicitwait);
		return driver;
		
	}
	public void quitbrowser(WebDriver driver) {
		driver.quit();
	}
}


		