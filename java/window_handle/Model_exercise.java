package window_handle;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Model_exercise {

	WebDriver driver;
	
	@Test
	public void setup() throws InterruptedException
	
	{
		// ChromeOptions option = new ChromeOptions();
		 //option.addArguments("--headless");
		 System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		 
         
	     driver.get("http://www.uitestpractice.com/Students/Switchto");
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	     
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
	     Thread.sleep(2000);
	     String Actual_text1 = driver.findElement(By.cssSelector("h4.modal-title")).getText();
	     String Expected_text1 = "Modal window demo";
	     
	     System.out.println("Model Alert Title is : "+Actual_text1);
	     Assert.assertEquals(Actual_text1, Expected_text1);
	     
	     Thread.sleep(2000);
	   String Body_text = driver.findElement(By.xpath("//div[@class='modal-body']")).getText();
	   
	   System.out.println("Model text is : "+Body_text);  
	   
	 //  String Expected_body_text = "A modal dialog is a window that forces the user to interact with it before they can go back to using the parent application. It can be gmail or facebook authentication window also. "; 
	   Thread.sleep(2000);
	   Assert.assertTrue(true, Body_text);
	  // driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
	   
	   driver.close();
	   
	   
	     
	}  
}
