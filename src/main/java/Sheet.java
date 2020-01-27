import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.testng.annotations.Test;

public class Sheet {
	File file;
	FileInputStream str;
	public HSSFWorkbook wb;
	public HSSFSheet ws;
	int rowcount;
	int colcount;
	public HSSFCell cell;
	public HSSFRow row;
	String Data[]=new String[3];
String fpath=System.getProperty("user.dir") + "\\" + "New Microsoft Excel Worksheet.xls";
	public String[]  sheetname() throws Exception 
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