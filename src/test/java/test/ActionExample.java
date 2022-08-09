package test;

import org.testng.annotations.Test;

import driverManager.Base;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class ActionExample extends Base {
 // @Test
  public void mousehover() throws InterruptedException {
	  locator(By.xpath("(//*[contains(text(),'Allow')])[1]")).click();
	  
	  Actions act = new Actions(driver);
	  act.moveToElement(locator(By.xpath("//a[contains(text(),'WOMEN')]"))).build().perform();
	  Thread.sleep(3000);
	 // locator(By.xpath("//*[contains(text(),'Oral Care')]")).click();
	  Thread.sleep(3000);
	  act.contextClick(locator(By.xpath("//a[contains(text(),'WOMEN')]"))).build().perform();
	  Thread.sleep(3000);
  }
 
 @Test
 public void copyPaste() throws InterruptedException {
	 
	WebElement ele = locator(By.id("firstName"));
	ele.sendKeys("Pooja");
	Thread.sleep(3000);
	 Actions act = new Actions(driver);
	 act.moveToElement(ele).doubleClick().build().perform();
	 ele.sendKeys(Keys.CONTROL,"c");
	 Thread.sleep(3000);
	 locator(By.id("lastName")).sendKeys(Keys.CONTROL,"v");
	 Thread.sleep(3000);
	 
 }
  
  
  
  
  @BeforeClass
  public void beforeClass() {
	  setUp("chrome", "https://www.walmart.ca/create-account");
  }

  @AfterClass
  public void afterClass() {
	  teardown();
  }

}
