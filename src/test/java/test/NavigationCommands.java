package test;

import org.testng.annotations.Test;

import driverManager.Base;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class NavigationCommands extends Base {
  
  @BeforeClass
  public void beforeClass() {
 //will be executed at the beginning
    setUp("chrome","https://www.facebook.com/");
  }

  @Test(priority=1)
  public void vaidateurl() {
	//validation
		 String actualurl=driver.getCurrentUrl();
		 String expectedurl="https://www.facebook.com/";
		 Assert.assertEquals(actualurl,expectedurl);
		 System.out.println("This is my url >> "+ actualurl); 
  }
  
  
  @Test (priority=2)
  public void naviagtioncommands() throws InterruptedException {
	  
	 //navigation to you tube
	 driver.navigate().to("https://www.youtube.com/");
	 //validaate youtube title
	 String actualtitle=driver.getTitle();
	 String expectedTitle="YouTube";
	// Assert.assertEquals(actualtitle,expectedTitle);
	 Assert.assertTrue(actualtitle.contains(expectedTitle), "This is not a correct title");
	 System.out.println("This is my url >> "+ actualtitle);
	 //navitage  back to facebook
	 driver.navigate().back();
	 Thread.sleep(3000);
	 driver.navigate().refresh();
	 
  }
  //loactorstaregy
  @Test
  public void boolenacommands() {
	  //8 locators Statndard attributes>> id, name ,class, tag name  > links> partial link text, link text >> xpath and Css
	  //1. id
	  driver.findElement(By.id("email")).click();
	  driver.findElement(By.name("pass")).sendKeys("test@123");
	  driver.findElement(By.className("_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy")).click();
	  driver.findElement(By.tagName("button"));
	  driver.findElement(By.linkText("Watch"));
	  driver.findElement(By.partialLinkText("Page"));
	  driver.findElement(By.xpath(""));
	//input[@onfocus='autoComplete()']
	  //with index
	 // (//div[@class='slick-list draggable']//img)[7]
			  //xpath with contains text
			  //tagname[contains(text(),'')]
			//h2[contains(text(),'Deals of the Day            ')]
			  //xpath with and or conditions
			  //tagname[starts-with(@id,'')]
			//a[starts-with(@id,'u_')]
			//a[starts-with(@id,'u_') and contains(text(),'account')]
			//a[starts-with(@id,'u_') or contains(text(),'account')]
			//input[@aria-required='true' and @aria-label='New password' ]
			  
	  //xpath > > 
	  //tagname[@attribute='']
	  //a[@class='xyz']
	  

//xpath and css 
  }
  
  @AfterClass
  public void afterClass() {
	  //will be executed at the end
	  teardown();
	  
  }

}
 