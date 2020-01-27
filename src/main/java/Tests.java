import java.util.Arrays;

import org.testng.annotations.Test;

public class Tests extends BaseClass{
	Sheet s=new Sheet();

	Utility util=new Utility();
	@Test
	public void Testing() throws Exception{
		String fpath1;
		//System.out.println(str);
		String[] str1=s.sheetname();

		for(int i=1;i<str1.length;i++)
		{

			fpath1=System.getProperty("user.dir")+ "\\DataFiles\\" + str1[i];
			//System.out.println(fpath1);
			util.Utilities(fpath1);
		}

	}
}
