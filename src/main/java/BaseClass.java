import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;


public class BaseClass {
	static WebDriver driver;
	Properties pro;
	Email email;
	String cpath=System.getProperty("user.dir")+ "\\src\\main\\java\\config.properties";
	String spath=System.getProperty("user.dir") + "\\Selenium\\Error_Screen\\Error";
	public static Logger logger;
	File file;
	FileInputStream io;
	String browser;
	@BeforeSuite
	public void setup() throws IOException
	{
		logger=Logger.getLogger(Data_methods.class);
		PropertyConfigurator.configure("log4j.properties");

		file= new File(cpath);
		io=new FileInputStream(file);
		pro=new Properties();
		pro.load(io);
		browser=pro.getProperty("browser");
		if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "Driver\\geckodriver.exe");
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
			logger.info("You have selected a invalid browser");
		}
	}
	@BeforeMethod
	void CheckBrowserOpen()
	{
		if(driver.toString().contains("null"))
		{
			String browser=pro.getProperty("browser");
			if(browser.equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "Driver\\geckodriver.exe");
				driver=new FirefoxDriver();	
			}
			else if(browser.equals("chrome"))
			{
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--no-sandbox");
				System.setProperty("webdriver.chrome.driver","Driver\\chromedriver.exe");
				driver=new ChromeDriver();
			}
		}
	}

	@AfterClass
	void EmailMethod() throws EmailException
	{ String emailid=pro.getProperty("Email");
	//System.out.println("The value is" +emailid);
	if(emailid.endsWith("@gmail.com") )
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

	@AfterMethod
	public void fetchMostRecentTestResult(ITestResult result) throws IOException, InterruptedException {

		int status = result.getStatus();
		//System.out.println(result.getStatus());

		switch (status) {
		case ITestResult.SUCCESS:
			logger.info("Your Test case is passed");
			break;
		case ITestResult.FAILURE:
			logger.info("Your Test case is failed");
			ErrorScreenshot();
			break;
		case ITestResult.SKIP:
			logger.info("Your Test case is passed");
			break;
		default:
			throw new RuntimeException("Invalid status");
		}
	}

	public  void ErrorScreenshot() throws IOException, InterruptedException {
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String filename =  new SimpleDateFormat("yyyyMMddhhmmss'.png'").format(new Date());
		File dest = new File(spath + filename);
		FileUtils.copyFile(scr, dest);
	}


	@AfterSuite
	void Teardown()
	{
		driver.quit();
	}
}
