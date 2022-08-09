package test;

import org.testng.annotations.Test;

import driverManager.Base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;

public class Robotexample extends Base {
 
  @BeforeClass
  public void beforeClass() {
	  setUp("chrome", "https://tinypng.com/");
  }
  @Test
  public void upload() throws InterruptedException, AWTException {
	  driver.findElement(By.xpath("//*[@class='icon']")).click();
	  Robot robo = new Robot();
	 String path = "C:\\PPort\\SkillMileCon\\LeveragingTech_article";
	
	 StringSelection stringpath = new StringSelection(path);
	 
	 Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
	  clip.setContents(stringpath, stringpath);
	  Thread.sleep(3000);
	  robo.keyPress(KeyEvent.VK_CONTROL);
	  robo.keyPress(KeyEvent.VK_V);
	  robo.keyPress(KeyEvent.VK_TAB);
	  robo.keyPress(KeyEvent.VK_TAB);
	  robo.keyPress(KeyEvent.VK_ENTER);
  }

}
