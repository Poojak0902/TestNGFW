package test;

import org.testng.annotations.Test;

import driverManager.Base;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class IframesHandlind extends Base {
  @Test
  public void iframeexample() throws InterruptedException {
	 WebElement iframe= locator(By.id("iframeResult"));
	 driver.switchTo().frame(iframe);
	 Thread.sleep(3000);
	 locator(By.tagName("button")).click();
	 Thread.sleep(3000);
	 driver.switchTo().alert().accept();
	 
	 driver.switchTo().defaultContent();
	 locator(By.partialLinkText(" website")).click();
	 Thread.sleep(3000);  
	  
  }
  
  //java script exte and other try catch and test NG
  @BeforeClass
  public void beforeClass() {
	  setUp("Chrome", "https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
  }

  @AfterClass
  public void afterClass() {
	  teardown();
  }

}
