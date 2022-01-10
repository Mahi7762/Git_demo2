package window_handle;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Irctc_example {
    
	WebDriver driver;
	
	@BeforeTest
	public void setup() throws InterruptedException
	{
		 System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
         driver =new ChromeDriver();
	     driver.get("https://www.irctc.co.in/nget/train-search");
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}  
	    
    @Test
	public void Irctc_test() throws InterruptedException
	 {
	     
	     driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
	     
	     driver.findElement(By.xpath("(//label[text()='HOTELS'])[2]")).click();
	     
	     Set<String> AllWindows = driver.getWindowHandles();
	     
	     String Main_window = (String)AllWindows.toArray()[0];
	     String Child_window = (String)AllWindows.toArray()[1];
	   
	     driver.switchTo().window(Child_window);
	     WebElement login_bt = driver.findElement(By.xpath("//a[text()='Login']"));
	   
	     JavascriptExecutor js = (JavascriptExecutor)driver;
	     js.executeScript("arguments[0].click();", login_bt);
	   
	     Thread.sleep(3000);
	     WebElement Username = driver.findElement(By.xpath("//input[@name='username']"));
	     Username.sendKeys("Admin");
	 
	     WebElement Passwd = driver.findElement(By.xpath("//input[@name='password']"));
	     Passwd.sendKeys("admin123");
	 
	     WebElement Logn_btn = driver.findElement(By.xpath("//button[@type='submit']"));
	     Logn_btn.click();
	     Thread.sleep(7000);
	     
	     //WebDriverWait wait= new WebDriverWait(driver, 30);
	  	// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[@class='text-center  mb-3'])[1]"))); 
	     String Txt_msg = driver.findElement(By.xpath("(//p[@class='text-center  mb-3'])[1]")).getText();
	     System.out.println("Error message is : "+Txt_msg);

	     String Actualtext = Txt_msg;
	     String Expectedtext = "Invalid User details";
	     Assert.assertEquals(Actualtext, Expectedtext);
	   
	     driver.switchTo().window(Main_window);
	     Thread.sleep(2000);
	     WebElement cntc_bt = driver.findElement(By.xpath("//a[contains(@aria-label,'contact us popup')]"));
	     js.executeScript("arguments[0].click();",cntc_bt );
	   
	 }
    
    @AfterTest
     public void teardown() throws InterruptedException
     {
    	 Thread.sleep(4000);
    	 driver.quit();
    	 
     }
	
}
