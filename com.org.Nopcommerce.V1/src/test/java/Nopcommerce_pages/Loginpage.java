package Nopcommerce_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	
	 WebDriver driver;

	    public Loginpage(WebDriver rdriver) {

	        this.driver = rdriver;
	        PageFactory.initElements(rdriver, this);

	    }

	   

	    // Method2 - PageFactory

	    @FindBy(id = "Email")
	    WebElement txtEmail;
	    
	    
	    //Migrating from tool to another tool
	//  @IdentifyBy(id = "Email")
	//  IWebElement txt_Email;

	    // Method3
	    @FindBy(how = How.NAME, using = "Password")
	    WebElement txtPass;

	    // Ruto- utility

	    @FindBy(how = How.TAG_NAME, using = "button") 
	    private WebElement btnLogIn;

	    @FindBy(xpath="(//i[@class='right fas fa-angle-left '])[4]")
	    WebElement customer_section; 
	    
	    @FindBy(xpath="//p[text()=' Customers']")
	    WebElement customer; 
	    
	    
	    @FindBy(xpath = "//a[contains(@href,'logout')]")
	    WebElement btnLogout;
 
	   // driver.findElement(By.xpath("(//img[@alt='logo.png'])[2]")).click();
	    
	    @FindBy(xpath = "(//img[@alt='logo.png'])[2]") 
	    WebElement lblDashBoard;
	    
	    
	    @FindBy(xpath= "//a[@class='btn btn-primary']")
	    WebElement Add_new_bt;

	    public void enterUserName(String email) {

	        txtEmail.clear();
	        txtEmail.sendKeys(email);

	    }

	    public void enterPassword(String pwd) {

	        txtPass.clear();
	        txtPass.sendKeys(pwd);

	    }

	    public void clickLoginButton() throws Exception {

	        btnLogIn.click();
	        Thread.sleep(2000);

	    }

	    public String getAppTitle() {

	        return driver.getTitle();
	    }

	    public boolean verifyAppLogo() {

	        return lblDashBoard.isDisplayed();
	    }

	    public void clickLogout() {

	        btnLogout.click();

	    }
	    
	    public void Addnew_customer_bt()
	    {
	    	Add_new_bt.click();
	    }
	    

	   public void clickon_customers()
	    {
	    	customer.click();
	    }

		public void clickon_customer_list() {
			
			customer_section.click();
		}

	
}
