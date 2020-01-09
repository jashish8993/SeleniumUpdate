import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;

public class Data_methods extends Utility {
	//static WebDriver driver;	
	static KeywordDefn key=new KeywordDefn();

	@Test
	public static void DataMethod() throws IOException,NullPointerException,ArrayIndexOutOfBoundsException, InterruptedException	{
		
			Utilities();
			for(int j=0;j<sheetcount;j++)
			{
				String Data[][]=readData(j);
				for(int i=1;i<rowCount+1;i++)
				{
					System.out.println("Currently performing \t : " + Data[i][1]);
					switch(Data[i][1])
					{
					case "navigate" : 
					{
						System.out.println(Data[i][3]);
						key.navigate(driver,Data[i][3]);
						break;
					}
					case "send_keys" : 
					{
						key.send_keys(driver,Data[i][2],Data[i][3],Data[i][4]);
						break;
					}
					case "click" :
					{
						key.click(driver,Data[i][2],Data[i][4]);
						break;
					}
					case "quit" :
					{
						key.quit(driver);
						break;
					}
					case "Select":
					{
						key.Select(driver,Data[i][3],Data[i][2],Data[i][4]);
						break;
					}
					case "Wait":
					{
						key.Wait(driver,Data[i][3]);
						break;
					}
					case "close":
					{
						key.Close(driver);
						break;
					}
					case "gettext":
					{
						key.gettext(driver,Data[i][4],Data[i][2]);
						break;
					}
					case "submit":
					{
						key.submit(driver,Data[i][2]);
						break;
					}
					case "forward":
					{
						key.forward(driver);
						break;
					}
					case "back":
					{
						key.back(driver);
						break;
					}
					case "Title":
					{
						key.Title(driver);
						break;
					}
					case "currenturl":
					{
						key.curl(driver);
						break;
					}
					case "radiob":
					{
						key.radiob(driver,Data[i][2]);
						break;
					}
					case "checkbox":
					{
						key.checkbox(driver,Data[i][2]);
						break;
					}
					default:
					{
						System.out.println("you have entered a incorrect keyword");
					}

					}
				}

			}
		}
		
	
	public static void ErrorScreenshot() throws IOException, InterruptedException {
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String filename =  new SimpleDateFormat("yyyyMMddhhmmss'.png'").format(new Date());
		File dest = new File("C:\\Users\\ashish\\Desktop\\Selenium\\error_screen\\error" + filename);
		FileUtils.copyFile(scr, dest);
	}
}