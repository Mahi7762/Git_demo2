package Nopcommerce_test;

import org.testng.annotations.Test;

public class Addnew_customer extends Basetest {

	@Test(priority = 1)
	public void login() throws Exception {

		lp.enterUserName("admin@yourstore.com");
		lp.enterPassword("admin");
		logger = extent.createTest("To verify login functinality using correct credentials");

		lp.clickLoginButton();
		log.info("Login functionality verified..");

	}

	@Test(priority = 2)
	public void customer_sec() throws Exception {
		lp.clickon_customer_list();
		lp.clickon_customers();
		lp.Addnew_customer_bt();

		logger = extent.createTest("To verify Customer Section functions");

	}

	@Test(priority = 3)
	public void Add_new_customer() {
		String ext = randomestring() + "@gmail.com";

		cp.Edit_text(con.Email_id() + ext, con.First_name(), con.Last_name(), con.DOB());
		cp.Radio_btMale();
		logger = extent.createTest("To verify adding First customer in customer page");
		cp.Save_cntinue_bt();
		log.info("New customer added successfully");

	}

	@Test(priority = 4)
	public void Add_new_customer1() {
		String ext = randomestring() + "@gmail.com";
		cp.Edit_text(con.Email_id1() + ext, con.First_name1(), con.Last_name1(), con.DOB1());
		cp.Radio_btFemale();
		logger = extent.createTest("To verify adding second customer in customer page");
		cp.Save_cntinue_bt();
		log.info("Second customer added successfully");
	}

	@Test(priority = 5)
	public void logout() {
		
		logger = extent.createTest("To verify Logout functionality");
		
		lp.clickLogout();
		
	}

}
