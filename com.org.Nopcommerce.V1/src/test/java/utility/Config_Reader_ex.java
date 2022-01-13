package utility;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class Config_Reader_ex {
          
	Properties prop;
	
	public Config_Reader_ex() throws IOException {
		
        FileInputStream file = new FileInputStream(".\\test-data\\config.properties");
		
		 prop =new Properties();
		prop.load(file);
		
	}
	
	public String getAppurl()
	{
		return prop.getProperty("url");
		
	}
	
	public String getAdminuser()
	{
		return prop.getProperty("admin_User");
		
	}
	
	public String getPasswd()
	{
		return prop.getProperty("admin_passwd");
	}
	
	public String First_name()
	{
		return prop.getProperty("FirstName");
		
	}
	
	public String Last_name()
	{
		return prop.getProperty("LastName");
		
	}
	
	public String Email_id()
	{
		return prop.getProperty("Email");
		
	}
	
	
	public String DOB()
	{
		return prop.getProperty("dob");
		
	}
	
	
	
	
	public String First_name1()
	{
		return prop.getProperty("FirstName1");
		
	}
	
	public String Last_name1()
	{
		return prop.getProperty("LastName1");
		
	}
	
	public String Email_id1()
	{
		return prop.getProperty("Email1");
		
	}
	
	
	public String DOB1()
	{
		return prop.getProperty("dob1");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
