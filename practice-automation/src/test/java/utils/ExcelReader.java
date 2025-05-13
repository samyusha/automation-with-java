package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {
    private static final String FILE_PATH = "TestAutomationSample.xlsx"; // File in src/test/resources/

    public static List<Object[]> readExcelData(String sheetName) throws IOException {
        List<Object[]> data = new ArrayList<>();
        System.out.println(ExcelReader.class.getClassLoader().getResource(FILE_PATH));
        try (InputStream inputStream = ExcelReader.class.getClassLoader().getResourceAsStream(FILE_PATH)) {
            if (inputStream == null) {
                throw new IOException("Excel file not found in classpath: " + FILE_PATH);
            }
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheet(sheetName);

            // Skip header row
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                List<String> rowData = new ArrayList<>();
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    rowData.add(cell.toString());
                }
                data.add(rowData.toArray());
            }
            workbook.close();
            return data;
        }
    }
}