package gopufftests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import gopuffpageobject.GoPuffSearchPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class goPuffSearchFunctionalityTest 
{
	
	String driverpath ="C:\\chromedriver.exe";
	WebDriver driver;
	WebDriverWait wait;
	GoPuffSearchPageObject gopuffsearchpage;
	
	@BeforeTest
	public void setUp() throws InterruptedException 
	{		
		    System.setProperty("webdriver.chrome.driver", driverpath);
			driver= new ChromeDriver();
			wait = new WebDriverWait(driver,120);
			driver.get("https://gopuff.com/home");
			driver.findElement(By.xpath("//button[contains(text(),'Order now!')]")).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='mapAddAdddress']")));
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@id='mapAddAdddress']")).click();
			driver.findElement(By.xpath("//button[contains(text(),'confirm address')]")).click();
			Thread.sleep(1000);
	} 
	 @Test
	 public void verifyingGopuffSearchFunctionality() throws InterruptedException 
	 {
		    gopuffsearchpage = new GoPuffSearchPageObject (driver);
			gopuffsearchpage.enterproductintosearchbox("Gatorade");
			Thread.sleep(10000);
			gopuffsearchpage.clickelementtab();
			Thread.sleep(10000);
			for(WebElement searchresults:gopuffsearchpage.returnsearchresults())
			{
				System.out.println(searchresults.getText());
			    wait.until(ExpectedConditions.visibilityOf(searchresults));
				Assert.assertTrue(searchresults.getText().contains("Gatorade"),"Error search result does not contain Gatorade");
			}
		  
	 }
	

	 @AfterTest
	 public void tearDown()
	 {driver.quit();
	 }
}
