/**
 * 
 */
package prjframework.sunaynatalreja.dataprovider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import prj.sunaynatalreja.readdatautil.ReadExcelData;
import prjframework.sunaynatalreja.framework.cache.Cache;



/**
 * @author Sunayna Talreja
*/
public class DataProviderClass {
	
	/**
	 * Gets excel book and sheet details 
	 * from testng xml 
	 * and calls method to read excel data
	 */
	@DataProvider(name="updateUser")
	public static Object[][] updateUser(ITestContext context) throws IOException
	{
		
		Object[][] obj=null;
		String workBookName=context.getCurrentXmlTest().getParameter("workbook");
		String sheetName=context.getCurrentXmlTest().getParameter("sheetUpdateUser");
		obj=readFromExcel(workBookName,sheetName);
		return obj;
	}
	
	
	/**
	 * Gets excel book and sheet details 
	 * from testng xml 
	 * and calls method to read excel data
	 */
	@DataProvider(name="deleteUser")
	public static Object[][] deleteUser(ITestContext context) throws IOException
	{
		
		Object[][] obj=null;
		String workBookName=context.getCurrentXmlTest().getParameter("workbook");
		String sheetName=context.getCurrentXmlTest().getParameter("sheetDeleteUser");
		obj=readFromExcel(workBookName,sheetName);
		return obj;
	}
	
	/**
	 * Gets excel book and sheet details 
	 * from testng xml 
	 * and calls method to read excel data
	 * 
	 */
	@DataProvider(name="getSingleUserData")
	public static Object[][] getSingleUserData(ITestContext context) throws IOException
	{

		Object[][] obj=null;
		String workBookName=context.getCurrentXmlTest().getParameter("workbook");
		String sheetName=context.getCurrentXmlTest().getParameter("sheetSingleUser");
		obj=readFromExcel(workBookName,sheetName);
		return obj;
	}
	
	/**
	 * Gets excel book and sheet details 
	 * from testng xml 
	 * and calls method to read excel data
	 * 
	 */
	@DataProvider(name="getCreateData")
	public static Object[][] getCreateData(ITestContext context) throws IOException
	{

		Object[][] obj=null;
		String workBookName=context.getCurrentXmlTest().getParameter("workbook");
		String sheetName=context.getCurrentXmlTest().getParameter("sheetCreate");
		obj=readFromExcel(workBookName,sheetName);
		return obj;
	}
	
	/**
	 * Gets excel book and sheet details 
	 * from testng xml 
	 * and calls method to read excel data
	 * 
	 */
	@DataProvider(name="getDataRegisterSuccess")
	public static Object[][] getDataRegisterSuccess(ITestContext context) throws IOException
	{

		Object[][] obj=null;
		String workBookName=context.getCurrentXmlTest().getParameter("workbook");
		String sheetName=context.getCurrentXmlTest().getParameter("sheet");
		obj=readFromExcel(workBookName,sheetName);
		return obj;
	}

	/**
	 * Reads the excelData 
	 * and return key value pair of the values present in the sheet 
	 * in the form of 2D object array
	 * 
	 */
	public static Object[][] readFromExcel(String workbookName,String sheetName) throws IOException
	{
		
		Object[][] obj=null;
		String filename=Cache.getInstance().getVal("ExcelFile");
		ReadExcelData readExcelData=new ReadExcelData();
		XSSFSheet sheet=readExcelData.getSheet(filename,workbookName, sheetName);
		ArrayList<String> headers=readExcelData.getHeaders(sheet);
		Map<String,String> testData=null;
		int lastRowNum=sheet.getLastRowNum();
		obj=new Object[lastRowNum][1];
		for(int row=1;row<=lastRowNum;row++)
		{
			testData=new HashMap<>();
			for(int icell=0;icell<headers.size();icell++)
			{
				DataFormatter formatter=new DataFormatter();
				XSSFCell cell=sheet.getRow(row).getCell(icell);
				String tempValue=formatter.formatCellValue(cell);
				testData.put(headers.get(icell), tempValue);
			}
			obj[row-1][0]=testData;
		}
		
		
		return obj;
		
	}

}
