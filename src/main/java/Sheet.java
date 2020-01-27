import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Sheet {
	File file;
	FileInputStream str;
	public HSSFWorkbook wb;
	public HSSFSheet ws;
	int rowcount;
	int colcount;
	public HSSFCell cell;
	public HSSFRow row;
	String Data[]=new String[10];
	String fpath=System.getProperty("user.dir") + "\\" + "TestCasesSheet.xls";
	public String[]  getSheetName() throws Exception 
	{
		file=new File(fpath);
		str=new FileInputStream(file);
		wb=new HSSFWorkbook(str);
		ws=wb.getSheetAt(0);
		rowcount=ws.getLastRowNum();
		colcount=ws.getRow(0).getLastCellNum();

		for(int i=1;i<rowcount+1;i++)
		{
			cell=ws.getRow(i).getCell(1);
			Data[i]=cell.toString();
		}

		return Data;

	}


}