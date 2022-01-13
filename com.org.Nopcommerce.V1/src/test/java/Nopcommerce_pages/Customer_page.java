package Nopcommerce_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

  public class Customer_page {

	
	
	 WebDriver driver;

	    public Customer_page(WebDriver rdriver) {

	        this.driver = rdriver;
	        PageFactory.initElements(rdriver, this);

	    }

	    @FindBy(id = "Email")
	    WebElement txtEmail;
	    
	    @FindBy(id = "FirstName")
	    WebElement txtFirstName;
	    
	    @FindBy(id = "LastName")
	    WebElement txtlastName;
	    
	   // driver.findElement(By.id("Gender_Male")).click();
	    
	    @FindBy(id ="Gender_Male")
	    WebElement Radio_bt1;
	    
	    @FindBy(id ="Gender_Female")
	    WebElement Radio_bt2;
	    
	   // driver.findElement(By.id("DateOfBirth")).sendKeys("values to send");
	    
	    @FindBy(id="DateOfBirth")
	    WebElement txtdate_birth;
	    
	    @FindBy(name="save-continue")
	    WebElement Save_button;
	    
	 //   driver.findElement(By.cssSelector("input#Email")).sendKeys("values to send");
	    
	  //  driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[2]")).click();
	    //driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[2]")).click();
	    //driver.findElement(By.name("save-continue")).click();
	    
	    
	    public void Edit_text(String Email,String Firstname,String Lastname, String Dob)
	    {
	    	txtEmail.clear();
	    	txtEmail.sendKeys(Email);
	    	
	    	txtFirstName.clear();
	    	txtFirstName.sendKeys(Firstname);
	    	
	    	txtlastName.clear();
	    	txtlastName.sendKeys(Lastname);
	    	
	    	txtdate_birth.clear();
	    	txtdate_birth.sendKeys(Dob);
	    	
	    	
	     }
	    
	    public void Radio_btMale()
	    {
	    	Radio_bt1.click();
	    }
	    
	    
	    public void Radio_btFemale()
	    {
	    	Radio_bt2.click();
	    }
	    
	    public void Save_cntinue_bt()
	    {
	    	Save_button.click();
	    }
	    
	    
}

