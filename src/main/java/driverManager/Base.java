package driverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	// write code to launch browser
	// intall testng plugin in eclipse
	public WebDriver driver;

	public void setUp(String browser, String url) {

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Automation\\WS\\SeleniumTestNGJuly\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Automation\\WS\\SeleniumTestNGJuly\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\Automation\\WS\\SeleniumTestNGJuly\\drivers\\msedgedriver_102.exe");
			driver = new EdgeDriver();
		} else {
			System.out.println("this is not relevant browser");
			System.exit(0);
		}
		// launch url

		if (url != "") {
			driver.get(url);
		} else {
			driver.get("about:blank");
		}
				driver.manage().window().maximize();
				
				//implicti wait page level wiat
				driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	}
//Explict wait locator level element level wait
public void waitforElement(WebElement ele) {
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOf(ele));
}
	
public WebElement locator(By locatortype) {
	waitforElement(driver.findElement(locatortype));
	WebElement ele =driver.findElement(locatortype);
	return ele;
}
public void jshighlight(WebElement ele) throws InterruptedException {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	js.executeScript("arguments[0].style.border='2px solid Red'", ele);
	Thread.sleep(3000);
  }
public void jshighscrollintoview(WebElement ele) throws InterruptedException {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	js.executeScript("arguments[0].scrollIntoView();", ele);
	Thread.sleep(3000);
  }	

public void jshighclick(WebElement ele) throws InterruptedException {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	js.executeScript("arguments[0].click();", ele);
	Thread.sleep(3000);
  }	
	public void teardown() {
		System.out.println("I am closing the browser");
		driver.quit();
		// driver.close();
	}

	
	
}
