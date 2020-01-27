import java.io.IOException;
import org.testng.annotations.Test;
public class Data_methods extends BaseClass {
	static KeywordDefn key=new KeywordDefn();
	static Utility util=new Utility();

	
	public  void DataMethod() throws IOException,NullPointerException,ArrayIndexOutOfBoundsException, InterruptedException	{
		//System.out.println("the data is  "+util.readData());	
		String Data[][]=util.readData();
			for(int i=1;i<util.rowCount+1;i++)
			{
				logger.info("Currently performing \t : " + Data[i][0]);
				switch(Data[i][1])
				{
				case "Navigate"  : 
				{
					//System.out.println(Data[i][3]);
					key.navigate(driver,Data[i][3]);
					break;
				}
				case "InputText" : 
				{
					key.send_keys(driver,Data[i][2],Data[i][3],Data[i][4]);
					break;
				}
				case "Click" :
				{
					key.click(driver,Data[i][2],Data[i][4]);
					break;
				}
				case "Quit" :
				{
					key.quit(driver);
					break;
				}
				case "Select":
				{
					key.Select(driver,Data[i][3],Data[i][2],Data[i][4]);
					break;
				}
				case "IWait":
				{
					key.IWait(driver, Data[i][3]);
					break;
				}
				case "Close":
				{
					key.Close(driver);
					break;
				}
				case "Gettext":
				{
					key.gettext(driver,Data[i][4],Data[i][2]);
					break;
				}
				case "Submit":
				{
					key.submit(driver,Data[i][2]);
					break;
				}
				case "Forward":
				{
					key.forward(driver);
					break;
				}
				case "Back":
				{
					key.back(driver);
					break;
				}
				case "Title":
				{
					key.Title(driver);
					break;
				}
				case "Currenturl":
				{
					key.curl(driver);
					break;
				}
				case "Radiobutton":
				{
					key.radiob(driver,Data[i][2]);
					break;
				}
				case "Checkbox":
				{
					key.checkbox(driver,Data[i][2]);
					break;
				}
				case "EWait":
				{
					key.Ewait(driver,Data[i][2],Data[i][3],Data[i][4]);
				}

				default:
				{
					logger.info("you have entered a incorrect keyword");
				}

				}
			}

		}
	}
