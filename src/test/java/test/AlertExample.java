package test;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import driverManager.Base;






public class AlertExample extends Base {
  @Test
  public void alerttest() throws InterruptedException {
	  Thread.sleep(3000);
driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
Thread.sleep(3000);
driver.switchTo().alert().accept();

locator(By.xpath("//button[@onclick='jsConfirm()']")).click();
Thread.sleep(3000);
driver.switchTo().alert().dismiss();

locator(By.xpath("//button[@onclick='jsPrompt()']")).click();
Thread.sleep(3000);
driver.switchTo().alert().sendKeys("Pooja");

  }
 
  
  
  @BeforeClass
  public void beforeClass() {
	  setUp("firefox", "https://the-internet.herokuapp.com/javascript_alerts");
  }

  @AfterClass
  public void afterClass() {
  teardown();
  }

}
