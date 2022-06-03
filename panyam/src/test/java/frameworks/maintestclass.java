package frameworks;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pagerepository.amazonhomepage;
import pagerepository.searchpage;
import utilities.baseclass;

public class maintestclass extends baseclass{
	
@Test(dataProvider="testdata2",groups="Regression")
	public void AmazonSignIn(String name,String password) throws InterruptedException {
		amazonhomepage ahp=PageFactory.initElements(driver,amazonhomepage.class);
		log=report.createTest(Thread.currentThread().getStackTrace()[1].getMethodName());
	    ahp.SignIn(driver,name,password);
	    log.info("test started");
	    Thread.sleep(5000);
	    SoftAssert sa=new SoftAssert();
	    System.out.println("1");
	    log.info("before Assertion");
	   // Assert.assertEquals(driver.getTitle(),"Amazon.com. Spend less. Smile more.");
	    //sa.assertTrue(driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1' and contains(text(),'Hello,')]")).isDisplayed());
		System.out.println("after assertion");
		//sa.assertAll();
		}
@Test(dataProvider="testdata2",groups= {"Regression","Sanity"})
public void searchScenario(String name) {
	searchpage sp=PageFactory.initElements(driver, searchpage.class);
	log=report.createTest("default report");
    sp.searchaction(name);
    log.info("test started");
   // Assert.assertEquals(12, 14);
	
}
@Test(groups="Regression")
public void demo() {
	System.out.println("this is the my demo testcase");
}
@Test(groups="Sanity")
public void demmy() {
	System.out.println("this is the my dummy testcase");
}


	}
	

