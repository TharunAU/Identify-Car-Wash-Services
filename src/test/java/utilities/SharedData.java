package utilities;

import java.io.IOException;
import java.util.HashMap;

public class SharedData {
    private static final String filePath = System.getProperty("user.dir") + "\\testData\\Identify-Car-Wash-Services_TestData.xlsx";
    public static HashMap<String, String> rowData;

    public static void loadTestRow(String sheetName, int rowIndex) throws IOException {
        DataReader reader = new DataReader(filePath, sheetName);
        rowData = reader.getRowData(rowIndex);
        reader.close();
    }

    public static String get(String key) {
        if (rowData == null || !rowData.containsKey(key)) {
            return null;
        }
        return rowData.get(key).trim();
    }
}
