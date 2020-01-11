import java.io.IOException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
public class Data_methods extends BaseClass {
	//static WebDriver driver;	
	static KeywordDefn key=new KeywordDefn();
	static Utility util=new Utility();

	@Test
	public static void DataMethod() throws IOException,NullPointerException,ArrayIndexOutOfBoundsException, InterruptedException	{
		
			//util.Utilities();
			for(int j=0;j<util.sheetcount;j++)
			{
				String Data[][]=util.readData(j);
				for(int i=1;i<util.rowCount+1;i++)
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
						key.Wait(driver);
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
						logger.info("you have entered a incorrect keyword");
					}

					}
				}

			}
		}
		
	
	
}