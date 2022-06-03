package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class loadconfigure {
	public Properties prop=new Properties();
	public void readdata() throws IOException {
		FileInputStream f=new FileInputStream("./configure/configuration2.properties");
		System.out.println("this is the configuration properties");
		prop.load(f);
		}
	public String getbrowser() {
		return prop.getProperty("browser");
		
	}
	public String geturl() {
		return prop.getProperty("url");
	}
	public int getpageloadwait() {
		return Integer.parseInt(prop.getProperty("pageloadwait"));
	}
	public int getimplicitwait() {
		return Integer.parseInt(prop.getProperty("implicitwait"));
	}
	public int getexplicitwait() {
		return Integer.parseInt(prop.getProperty("explicitwait"));
				
	}
	public String getconfigure(String key) {
		return prop.getProperty(key);
	}
}
	