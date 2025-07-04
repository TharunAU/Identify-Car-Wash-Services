package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	public static String path=".\\testData\\Identify-Car-Wash-Services_TestData.xlsx";//taking xl file from testData

//	@DataProvider(name="LoginData")
//	public String [][] getData() throws IOException
//	{
//		
//		
//		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
//		
//		int totalrows=xlutil.getRowCount("Sheet1");	
//		int totalcols=xlutil.getCellCount("Sheet1",1);
//				
//		String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
//		
//		for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
//		{		
//			for(int j=0;j<totalcols;j++)  //0    i is rows j is col
//			{
//				logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
//			}
//		}
//	return logindata;//returning two dimension array
//				
//	}
	@DataProvider(name="TC001")
	public String[][] TC001(){
		
		ExcelUtilityClass util = new ExcelUtilityClass(path, "Sheet1");
		String data[][] = util.getSheetData(2);
		util.closeWorkbook();
		return data;
	}
	
	@DataProvider(name="TC002")
	public String[][] TC002(){
		
		ExcelUtilityClass util = new ExcelUtilityClass(path, "Sheet2");
		String data[][] = util.getSheetData(1);
		util.closeWorkbook();
		return data;
	}
	
	@DataProvider(name="TC004")
	public String[][] TC004(){
		
		ExcelUtilityClass util = new ExcelUtilityClass(path, "Sheet3");
		String data[][] = util.getSheetData(2);
		util.closeWorkbook();
		return data;
	}
	
	@DataProvider(name="TC005")
	public String[][] TC005(){
		
		ExcelUtilityClass util = new ExcelUtilityClass(path, "Sheet4");
		String data[][] = util.getSheetData(2);
		util.closeWorkbook();
		return data;
	}
	
	@DataProvider(name="TC006")
	public String[][] TC006(){
		
		ExcelUtilityClass util = new ExcelUtilityClass(path, "Sheet5");
		String data[][] = util.getSheetData(1);
		util.closeWorkbook();
		return data;
	}
	
	@DataProvider(name="TC007")
	public String[][] TC007(){
		
		ExcelUtilityClass util = new ExcelUtilityClass(path, "Sheet5");
		String data[][] = util.getSheetData(2);
		util.closeWorkbook();
		return data;
	}
	
}
