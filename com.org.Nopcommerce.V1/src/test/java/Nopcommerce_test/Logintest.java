package Nopcommerce_test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Logintest extends Basetest {
	
	

  
	
	   @Test(priority = 1)
	    public void login() throws Exception {

	        lp.enterUserName("admin@yourstore.com");
	        lp.enterPassword("admin");
	        logger = extent.createTest("To verify cresedentials are getting added in Textbox");
	        
	        lp.clickLoginButton();
	        log.info("Login functionality verified..");
	     
	       }

	    @Test(priority = 4)
	    public void logout() {
	    	logger=extent.createTest("To verify Logout functionality");
	        lp.clickLogout();

	    }

	    @Test(priority = 2)
	    public void verifyTitle() throws InterruptedException {

	        Assert.assertTrue(lp.getAppTitle().contains(""), "validation of application title");
	        Thread.sleep(2000);
	        logger = extent.createTest("To verify Application Title");
	        log.info("Title of the Application get verified");
	    }

	    @Test(priority = 3)
	    public void verifyLogo() {
             
	        Assert.assertTrue(lp.verifyAppLogo(), "validation of application Logo");
	        logger=extent.createTest("to verify logo of the Application");
	        log.info("Logo of the Apllication verified");
	    }
	    
	  
	  
	    
}
