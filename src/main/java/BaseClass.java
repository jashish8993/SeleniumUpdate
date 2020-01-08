import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
static WebDriver driver;
Properties pro;
	@BeforeMethod
	public void setup() throws IOException
	{
		File file= new File("C:\\Users\\ashishj\\workspace\\Hybrid\\src\\main\\java\\config.properties");
		FileInputStream io=new FileInputStream(file);
		pro=new Properties();
		pro.load(io);
		String browser=pro.getProperty("browser");
		if(browser.equals("firefox"))
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\ashishj\\workspace\\Hybrid\\geckodriver.exe");
		driver=new FirefoxDriver();	
	}
	
}
