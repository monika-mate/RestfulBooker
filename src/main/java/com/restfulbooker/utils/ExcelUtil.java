package com.restfulbooker.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtil {
static Workbook workBook;
static Sheet sheet;
public static String Sheet_Name = System.getProperty("user.dir") + "/src/main/java/com/restfulbooker/resources/TestData.xlsx";


    public static Object[][] getTestDataFromExcel(String sheetname) throws IOException {
        FileInputStream file = null;
        file = new FileInputStream(Sheet_Name);
        workBook = WorkbookFactory.create(file);
        sheet = workBook.getSheet(sheetname);

        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i <sheet.getLastRowNum() ; i++) {
            for (int j = 0; j <sheet.getRow(0).getLastCellNum() ; j++) {
                data[i][j] = sheet.getRow(i+1).getCell(j).toString();

            }
        }

        return data;
    }


    @DataProvider
    public Object[][] getData() throws IOException {
    return getTestDataFromExcel("Sheet1");
}




}
