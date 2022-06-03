package utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class baseclass{
	public WebDriver driver;
	public browserfactory bf=new browserfactory();
	public loadconfigure lc;
	public ExtentReports report;
    public ExtentTest log;
	
	
	@BeforeSuite(alwaysRun=true)
	public void readdata() throws IOException  {
	   
		System.out.println("before suite");
		lc=new loadconfigure();
		lc.readdata();
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File("./report/amazon.html"));
		report=new ExtentReports();
		report.attachReporter(extent);
		System.out.println("after load configure");
		}
	@Parameters("browser")
	@BeforeMethod(alwaysRun=true)
    public WebDriver driverSetup(String browsertype) {
		System.out.println("before test");
		System.out.println("this is the browser "+lc.getbrowser()+"testdata2path:"+lc.getconfigure("testdata2path"));
		driver=bf.startup(driver,browsertype,lc.geturl(),lc.getpageloadwait(),lc.getimplicitwait(),lc.getexplicitwait());
		return driver;
	}
	@AfterMethod(alwaysRun=true)
	public void closebrowser(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			log.fail("the test case is failed",MediaEntityBuilder.createScreenCaptureFromPath("."+screenshotcapture.capturescreenshot(driver)).build());
		}else if(result.getStatus()==ITestResult.SUCCESS) {
			log.pass("the test case is passed");
		}
		
		bf.quitbrowser(driver);
		report.flush();
		
	}
	@DataProvider(name="testdata2")
	public String[][] getdata(Method met) throws IOException{
    System.out.println("this is  testdata2path:"+lc.getconfigure("testdata2path"));
	exceloperations eo=new exceloperations(lc.getconfigure("testdata2path"));
    //String testSheet="AmazonSignIn";
	String testSheet=    met.getName();
	int rowcount=eo.getrowcount(testSheet);
	int columncount=eo.getcolumncount(testSheet);
	System.out.println("this is the rowcount:"+rowcount);
	System.out.println("this is the columncount:"+columncount);
	String[][] celldata=new String [rowcount][columncount];
	for( int i=1;i<=rowcount;i++) {
		for(int j=0;j<columncount;j++) {
			System.out.println(eo.getdata(i,j, testSheet));
			celldata[i-1][j]=eo.getdata(i, j, testSheet);
		}
	}
	return celldata;
	}
//	@DataProvider(name="searchdata")
//	public String[][] searchdata() throws IOException{
//		System.out.println("this is  testdata2path:"+lc.getconfigure("testdata2path"));
//		exceloperations eo=new exceloperations(lc.getconfigure("testdata2path"));
//		String testSheet="searchScenario";
//		int rowcount=eo.getrowcount(testSheet);
//		int columncount=eo.getcolumncount(testSheet);
//		System.out.println("this is the rowcount:"+rowcount);
//		System.out.println("this is the columncount:"+columncount);
//		String[][] celldata=new String [rowcount][columncount];
//		for( int i=1;i<=rowcount;i++) {
//			for(int j=0;j<columncount;j++) {
//				System.out.println(eo.getdata(i,j, testSheet));
//				celldata[i-1][j]=eo.getdata(i, j, testSheet);
//			}
//		}
//		return celldata;
//		
//		
//	}
	
}
