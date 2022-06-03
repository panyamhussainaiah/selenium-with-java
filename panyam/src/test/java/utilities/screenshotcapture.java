package utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class screenshotcapture {
	public static String capturescreenshot(WebDriver driver) throws IOException {
		String path="./screenshot1/AmazonSignIn"+System.currentTimeMillis()+".jpeg";
		File f=((TakesScreenshot)driver).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		FileHandler.copy(f,new File(path));
		return path;
		
	}

}
