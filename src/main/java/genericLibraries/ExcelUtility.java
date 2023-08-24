package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	private Workbook workbook;
	private String excelpath;
	public void excelInit(String excelpath)
	{
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook=WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public Map<String, String>getdata(String sheetNmae, String expectedTest){
		Map<String, String> map=new HashMap<String, String>();
		DataFormatter df=new DataFormatter();
		Sheet sheet=workbook.getSheet(sheetNmae);
		 for(int i=0;i<=sheet.getLastRowNum();i++)
		 {
			 if(df.formatCellValue(sheet.getRow(i).getCell(1)).equals(expectedTest))
			 {
				 for(int j=i;j<=sheet.getLastRowNum();j++)
				 {
					 map.put(df.formatCellValue(sheet.getRow(j).getCell(2)),
							 df.formatCellValue(sheet.getRow(j).getCell(3)));
					 if(df.formatCellValue(sheet.getRow(j).getCell(2)).equals("####"))
						 
					 break;
				 }
				 break;
			 }
			 
		 }
		 return map;
	}


public void writeToExcel(String sheetName, String expectedtest,String status,String excelpath) {
	DataFormatter df=new DataFormatter();
	Sheet sheet=workbook.getSheet(sheetName);
	for(int i=0;i<=sheet.getLastRowNum();i++) {
		if(df.formatCellValue(sheet.getRow(i).getCell(1)).equals(expectedtest))
		{
			Cell cell=sheet.getRow(i).getCell(4);
			cell.setCellValue(status);
			break;
		}			
	}
	FileOutputStream fos=null;
	try
	{
		fos=new FileOutputStream(excelpath);
	}
	catch(FileNotFoundException e)
	{
		e.printStackTrace();
	}
	try {
	workbook.write(fos);
	}
	catch(IOException e) {
		e.printStackTrace();
	}
}
public void closeExcel() {
	try {
		workbook.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}

		

	
	


