package commonFunctionPackage;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class utility_Common_Function {

	public static void evidencefilecreator(String filename,String requestBody,String responseBody) throws IOException {
		File newfile=new File("D:\\ABC\\"+filename+".txt");
		System.out.println("a new text file created to record request and response of API :"+newfile.getName());
		
		FileWriter datawrite=new FileWriter(newfile);
		datawrite.write("request body :" +requestBody+"\n\n");
		datawrite.write("response body :" +responseBody);
		datawrite.close();
		System.out.println("request body and response body are saved in :"+newfile.getName());
}
	public static ArrayList<String> readdataexcel(String sheetname, String testcasename) throws IOException {
		ArrayList<String> arrayData=new ArrayList<String>();
		FileInputStream fis = new FileInputStream("D:\\ABC\\testdata.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		int countofsheet=workbook.getNumberOfSheets();
		for (int i=0;i<countofsheet;i++)
		{
			String filesheetname=workbook.getSheetName(i);
			
			if(filesheetname.equalsIgnoreCase(sheetname))
			{
				//step4 access the row from where the data is suppose to fetch
				//XSSFSheet sheet=workbook.getSheetAt(i);
				XSSFSheet sheet=workbook.getSheetAt(i);
				Iterator<Row>rows = sheet.iterator();
			
					//Row r=rows.next();
	    	   
				while(rows.hasNext())
				{
					Row r2=rows.next();
					if(r2.getCell(0).getStringCellValue().equalsIgnoreCase(testcasename))
					{
						Iterator<Cell> cellvalues=r2.cellIterator();
						while(cellvalues.hasNext()) {
							String testdata=cellvalues.next().getStringCellValue();
							arrayData.add(testdata);
						}
					}
					
						}
				
					}
				}
		workbook.close();
		return arrayData;	
	}
	}

