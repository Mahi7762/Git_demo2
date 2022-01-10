package window_handle;

import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Multiple_WindowHandle {
           
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		 System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
         driver =new ChromeDriver();
	     driver.get("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
	     driver.manage().window().maximize();
	     
	} 
	
	@Test
	public void Window_handle_test() throws InterruptedException
	{
		driver.findElement(By.xpath("//a/b[text()='Open New Page']")).click();
		
		Set<String> All_window_handles = driver.getWindowHandles();
		
		String Main_window = (String)All_window_handles.toArray()[0];
		String Child_window = (String)All_window_handles.toArray()[1];
		
		driver.switchTo().window(Child_window);
		
		driver.findElement(By.id("fname")).sendKeys("Lucifer");
		driver.findElement(By.xpath("//input[@value='Car']")).click();
		driver.findElement(By.xpath("//input[@value='Bike']")).click();
		driver.findElement(By.xpath("//input[@value='Boat']")).click();
		
		driver.switchTo().window(Main_window);
		driver.findElement(By.id("radio1")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Show Me Confirmation')]")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
		driver.switchTo().window(Main_window);
		
		
	}
	
	@AfterTest
	public void teardown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
	

}
