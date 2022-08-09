package test;

import org.testng.annotations.Test;

import driverManager.Base;

import org.testng.annotations.BeforeClass;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;

public class WindowHandling extends Base{
  @Test
  public void windowhandles() throws InterruptedException {
	  //current id of parent win
	  String parentwindwo=driver.getWindowHandle();
  locator(By.partialLinkText("documentation issue")).click();
  Thread.sleep(3000);
  Set <String >set =driver.getWindowHandles();
  
 Iterator<String >it = set.iterator();
 while (it.hasNext()) {
	String string = it.next();
	driver.switchTo().window(string);
	String str=driver.getTitle();
	System.out.println(str);
	
}
  driver.switchTo().window(parentwindwo);
  Thread.sleep(3000);
  locator(By.partialLinkText("W3C Recommendation")).click();
  
  }
  
  
  
  @BeforeClass
  public void beforeClass() {
	  setUp("chrome","https://www.selenium.dev/documentation/webdriver/");
  }

  @AfterClass
  public void afterClass() {
	  teardown();
  }

}
