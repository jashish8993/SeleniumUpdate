import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


public class BaseClass {
	static WebDriver driver;
	Properties pro;
	Email email;
	
	@BeforeSuite
	public void setup() throws IOException
	{
		File file= new File("C:\\Users\\ashishj\\workspace\\Hybrid\\src\\main\\java\\config.properties");
		FileInputStream io=new FileInputStream(file);
		pro=new Properties();
		pro.load(io);
		String browser=pro.getProperty("browser");
		if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\ashishj\\workspace\\Hybrid\\geckodriver.exe");
			driver=new FirefoxDriver();	
		}
		else if(browser.equals("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-sandbox");
			System.setProperty("webdriver.chrome.driver","Driver\\chromedriver.exe");
			driver=new ChromeDriver();
			}
		else
		{
			System.out.println("You have selected a invalid browser");
		}
	}
	
	@BeforeClass
	void EmailMethod() throws EmailException
	{ String emailid=pro.getProperty("Email");
		if(emailid != null)
		{
		String user=pro.getProperty("user");
		String password=pro.getProperty("password");
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(user, password));
		email.setSSLOnConnect(true);
		email.setFrom("jashish8993@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ");
		email.addTo("jashish8993@gmail.com");
		email.send();
		}
	}

}
