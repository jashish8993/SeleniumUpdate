import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
//import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;

public class Utility  extends BaseClass {
	public static String fpath=System.getProperty("user.dir") + "\\ashish.xls";
	HSSFCell Data1;
	static FileInputStream files=null;
	static HSSFWorkbook wb=null;
	static HSSFSheet ws=null;
	int rowCount;
	public  int sheetcount;
	public  int colCount;

	public  Utility() throws NullPointerException
	{
		try {
			files=new FileInputStream(fpath);
			wb=new HSSFWorkbook(files);
			sheetcount=wb.getNumberOfSheets();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	public  String[][] readData(int index) throws IOException,NullPointerException	 {	
		ws=wb.getSheetAt(index);
		rowCount=ws.getLastRowNum();
		//System.out.println(rowCount);
		colCount=ws.getRow(0).getLastCellNum();
		//System.out.println(colCount);
		String[][] Data=new String[rowCount+1][colCount];
		for(int i=1;i<=rowCount;i++)
		{
			HSSFRow row = ws.getRow(i);
			for(int j=0;j<colCount;j++)
			{

				if(row==null){
					Data[i][j] = "";
				}
				else {
					HSSFCell Data1=row.getCell(j);
					if(Data1==null)
						Data[i][j] = "";
					else 
					{
						String value=cellToString(Data1);
						if(value==null)
							return null;
						Data[i][j]=value;
						if(Data[i][j]==null)
							return null;
						//System.out.println(Data[i][j]);

					}
				}
			}
		}	
		return Data;
	}
	public static String cellToString(HSSFCell cell)
	{
		CellType type;
		Object result;
		if(cell==null)
			return null;
		type = cell.getCellType();	
		System.out.println(type);

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