import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class KeywordDefn extends BaseClass	  {
	WebElement we;
	public String navigate(WebDriver driver ,String url)
	{
		if(url.equals(""))
		{
			logger.info("Url of the application is not accessible");
		}
		else
		{
			driver.get(url);
		}
		return null;	
	}
	public  String send_keys(WebDriver driver,String locator,String data,String value3)
	{
		switch (value3) { 
		case "xpath":{
			driver.findElement(By.xpath(locator)).sendKeys(data);
			break;
		}
		case "name":{
			driver.findElement(By.name(locator)).sendKeys(data);
			break;
		}
		case "id":
		{
			driver.findElement(By.id(locator)).sendKeys(data);
			break;
		}
		}
		return null;
	}
	public  String click(WebDriver driver, String lvalue, String locator)
	{
		switch (locator) { 
		case "xpath":
		{
			WebElement we=driver.findElement(By.xpath(lvalue));
			we.click();
			break;
		}
		case "name":{
			WebElement we=driver.findElement(By.id(lvalue));
			we.click();
			break;
		}
		case "id":
		{
			WebElement we=driver.findElement(By.id(lvalue));
			we.click();
			break;
		}
		}
		return null;
	}
	public  String Close(WebDriver driver)
	{
		driver.close();
		return null;
	}
	public  String quit(WebDriver driver)
	{
		driver.quit();
		return null;
	}
	public  String Select(WebDriver driver, String value,String value2,String value4)
	{
		switch (value4)
		{
		case "id":
		{
			Select select=new Select(driver.findElement(By.id(value2)));
			select.selectByVisibleText(value);
			break;
		}
		case "name":
		{
			Select select=new Select(driver.findElement(By.name(value2)));
			select.selectByVisibleText(value);
			break;
		}
		}
		return null;
	}
	public  String deSelect(WebDriver driver, String value,String value2,String value4)
	{
		switch (value4)
		{
		case "id":
		{
			Select select=new Select(driver.findElement(By.id(value2)));
			select.deselectByVisibleText(value);
			break;
		}
		case "name":
		{
			Select select=new Select(driver.findElement(By.name(value2)));
			select.deselectByVisibleText(value);
			break;
		}
		}
		return null;
	}
	public  String IWait(WebDriver driver,String data) 
	{
		int time=Integer.parseInt(data);
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		return null;
	}


	public String Ewait(WebDriver driver, String locator, String time, String lvalue)
	{
		int times=Integer.parseInt(time);
		WebDriverWait wait= new WebDriverWait(driver,times);

		switch(lvalue)
		{
		case "xpath": {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		}
		case "id": {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
		}
		case "name": {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locator)));
		}
		}
		return null;

	}
	public  String gettext(WebDriver driver,String locator,String value)
	{
		switch(locator)
		{
		case "xpath":
		{
			driver.findElement(By.xpath(value)).getText();
		}
		case "id":
		{
			driver.findElement(By.id(value)).getText();
		}
		}
		return null;
	}
	public  String submit(WebDriver driver,String locator)
	{
		we=driver.findElement(By.xpath(locator));
		we.click();
		return null;
	}
	public  String forward(WebDriver driver)
	{
		driver.navigate().forward();
		return null;
	}
	public  String back(WebDriver driver)
	{
		driver.navigate().back();
		return null;
	}
	public  String Title(WebDriver driver)
	{
		driver.getTitle();
		return null;
	}
	public  String curl(WebDriver driver)
	{
		driver.getCurrentUrl();
		return null;
	}
	public  String radiob(WebDriver driver,String locator)
	{
		we=driver.findElement(By.id(locator));
		we.click();
		return null;
	}
	public  String checkbox(WebDriver driver,String locator)
	{
		we=driver.findElement(By.id(locator));
		we.click();
		return null;
	}
}