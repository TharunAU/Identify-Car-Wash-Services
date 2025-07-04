package utilities;


import org.testng.annotations.DataProvider;

public class DataProviders {
	
	public static String path=".\\testData\\Identify-Car-Wash-Services_TestData.xlsx";//taking xl file from testData


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
