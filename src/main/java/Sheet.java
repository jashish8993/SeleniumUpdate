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

	public String[]  sheetname() throws Exception 
	{
			file=new File("C:\\Users\\jashi\\Desktop\\New Microsoft Excel Worksheet.xls");
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

	private String cellToString(HSSFCell cell) {
		CellType type;
		Object result;
		if(cell==null)
			return null;
		type = cell.getCellType();	
		//System.out.println(type);

		switch (type){
		case NUMERIC :
			if (DateUtil.isCellDateFormatted(cell)) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				result = dateFormat.format(cell.getDateCellValue());
			} else {
				Double value = cell.getNumericCellValue();
				Long longValue = value.longValue();
				result = new String(longValue.toString());
			}
			break;
		case STRING : 
			result = cell.getStringCellValue();
			break;
		case BOOLEAN:
			result=cell.getBooleanCellValue();
			break;
		case BLANK:
			result=cell.getColumnIndex();
			break;
		case FORMULA:
			result=cell.getCellFormula();
			break;
		default :
			//System.out.println(cell.getCellStyle());
			throw new RuntimeException("We have encountered an Unsupportd cell and Cell type is " + cell.getCellType());			
		}
		return result.toString();
	}
}