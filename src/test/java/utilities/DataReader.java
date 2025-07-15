package utilities;

import java.util.HashMap;

public class DataReader {

    private final ExcelUtilityClass excel;

    public DataReader(String filePath, String sheetName) {
        this.excel = new ExcelUtilityClass(filePath, sheetName);
    }

    // Returns key-value pair from a specific row
    public HashMap<String, String> getRowData(int rowIndex) {
        HashMap<String, String> rowData = new HashMap<>();
        int colCount = excel.getColumnCount();

        for (int colIndex = 0; colIndex < colCount; colIndex++) {
            String key = excel.getCellData(0, colIndex); // header
            String value = excel.getCellData(rowIndex, colIndex); // data at rowIndex
            rowData.put(key.trim(), value.trim());
        }

        return rowData;
    }

    // Ensures workbook is properly closed
    public void close() {
        excel.closeWorkbook();
    }
}
