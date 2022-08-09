package test;

import org.testng.annotations.Test;

import driverManager.Base;

import org.testng.annotations.BeforeClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class SelectExample extends Base {
 
  @BeforeClass
  public void beforeClass() {
	  setUp("chrome", "https://www.facebook.com/");
  }
//  @Test
  public void select() throws InterruptedException {
	  waitforElement( driver.findElement(By.xpath("//a[starts-with(@id,'u_') and contains(text(),'account')]")));
	  driver.findElement(By.xpath("//a[starts-with(@id,'u_') and contains(text(),'account')]")).click();
	  
	  //I hve to select date of birth 1. chek the filed 2. selct the date 
	 WebElement month= driver.findElement(By.id("month"));
	 Assert.assertTrue(month.isDisplayed()==true, "Month dd is not displayed");
	 //select class to choose value
	 Select slcmonth = new Select(month);
	 slcmonth.selectByIndex(1);
	 Thread.sleep(3000);
	  
	 WebElement Date= driver.findElement(By.id("day"));
	 Assert.assertTrue(Date.isDisplayed()==true, "Month dd is not displayed");
	 
	 Select slcday = new Select(Date);
	 slcday.selectByValue("9");
	  
	 
	 WebElement year= driver.findElement(By.id("year"));
	 Assert.assertTrue(Date.isDisplayed()==true, "year dd is not displayed");
	 
	 Select slcyear = new Select(year);
	 slcyear.selectByVisibleText("1991");
	  
	  //css
	 driver.findElement(By.cssSelector(".css-1lxthnz.e1xoeh2i4"));
	 //input#email tagname and id
  }
  @Test
  public void Selectgetoptions() throws InterruptedException {
	  Thread.sleep(3000);
	  //this will select values from dd one by one
	  WebElement month= driver.findElement(By.id("month"));
	  Select slc = new Select(month);
	List <WebElement>  lst = slc.getOptions();
	for (int i = 0; i < lst.size(); i++) {
		String str =lst.get(i).getText();
		System.out.println(str);
		if (str.contains("Feb")) {
			lst.get(i).click();
		}
		}
		
	  
  }
  
  @AfterClass
  public void afterClass() {
	  teardown();
  }

}
