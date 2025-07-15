package utilities;

import java.util.HashMap;

public class DataReader {

    private final ExcelUtilityClass excel;

    public DataReader(String filePath, String sheetName) {
        this.excel = new ExcelUtilityClass(filePath, sheetName);
    }

    public HashMap<String, String> getRowData(int rowIndex) {
        HashMap<String, String> rowData = new HashMap<>();
        int colCount = excel.getColumnCount();

        for (int colIndex = 0; colIndex < colCount; colIndex++) {
            String key = excel.getCellData(0, colIndex);      // header
            String value = excel.getCellData(rowIndex, colIndex); // actual data
            rowData.put(key.trim(), value.trim());
        }

        return rowData;
    }

    public void close() {
        excel.closeWorkbook();
    }
}
