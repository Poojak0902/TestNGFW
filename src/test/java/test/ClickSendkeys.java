package test;

import org.testng.annotations.Test;

import driverManager.Base;

import org.testng.annotations.BeforeClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class ClickSendkeys extends Base{
 
  @BeforeClass
  public void beforeClass() {
	  setUp("chrome", "https://www.youtube.com/");
  }
  //@Test
  public void clickexamples() throws InterruptedException {
	// Thread.sleep(3000);
	  waitforElement( driver.findElement(By.xpath("//a[starts-with(@id,'u_') and contains(text(),'account')]")));
	  driver.findElement(By.xpath("//a[starts-with(@id,'u_') and contains(text(),'account')]")).click();
	  Thread.sleep(3000);
	  waitforElement(driver.findElement(By.xpath("//input[@type='radio' and @value='1']")));
	  WebElement ele= driver.findElement(By.xpath("//input[@type='radio' and @value='1']"));
	  boolean b1=ele.isDisplayed();
	 ele.isEnabled();
	 Assert.assertTrue(b1==true, "This is not Displayed >> "+ b1);
	 Assert.assertTrue(ele.isEnabled()==true , "This is not endbled >> "+ ele.isEnabled() );
	 
	 ele.click();
	 Thread.sleep(3000);
  }
  
 // @Test
  public void sendkeys() throws InterruptedException {
	 WebElement Fn =driver.findElement(By.xpath("//input[@aria-label='First name']")); 
	 Assert.assertTrue(Fn.isDisplayed()==true, "Firstname is not dispalyed");
	 Assert.assertTrue(Fn.isEnabled()==true, "Firstname is not Enabled ");
	 Fn.sendKeys("Pooja");
	 Thread.sleep(3000);
  }
  
 // @Test 
  public void validateAlllinks() throws InterruptedException {
	  List <WebElement> lst =driver.findElements(By.tagName("a"));
	  for (int i = 0; i < lst.size(); i++) {
		String str= lst.get(i).getText();
		System.out.println(str);
		if (str.contains("Sign Up")) {
			lst.get(i).click();
			Thread.sleep(3000);
		break;
		}
	}
	  
	  
	  //javascript executor 
	 }
  @Test
  public void validatescrollintoview() {
	 WebElement ele = driver.findElement(By.xpath("//*[@class='ytp-inline-preview-ui']"));
	  try {
		jshighscrollintoview(ele);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  @AfterClass
  public void afterClass() {
	  teardown();
  }

}
