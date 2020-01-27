import org.testng.annotations.Test;

public class TestCases extends BaseClass{
	Sheet s=new Sheet();

	Utility util=new Utility();
	@Test
	public void Testing() throws Exception{
		try {
			String fpath1;
			String[] str1=s.getSheetName();
			for(int i=1;i<str1.length;i++)
			{

				fpath1=System.getProperty("user.dir")+ "\\DataFiles\\" + str1[i];
				if(str1[i]==null)
				{

				}
				else {
					util.Utilities(fpath1);
				}
			}
		}  catch (Exception e) {
			e.printStackTrace();
		}

	}
}
