import org.testng.annotations.Test;

public class TestCases extends BaseClass{
	Sheet s=new Sheet();

	Utility util=new Utility();
	@Test
	public void Testing() throws Exception{
		String fpath1;
		//System.out.println(str);
		String[] str1=s.getSheetName();
		//logger.info("Total number of sheets are  "+str1.length);
		for(int i=1;i<str1.length;i++)
		{

			fpath1=System.getProperty("user.dir")+ "\\DataFiles\\" + str1[i];
			//System.out.println(fpath1);
			if(str1[i]==null)
			{

			}
			else {
				util.Utilities(fpath1);
			}}

	}
}
