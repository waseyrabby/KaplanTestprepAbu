package com.kaplan.pomframework;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name = "dataAsArray")
    public static Object[][]dataProviderAsArray() {
        Object[][]data;
        data =  new Object[][]{
                { "kaplantestabu@gmail.com","9083277874","Aam" },
                { "kaplantestabu@gmail.com","9083277874","Aam"}
              
    };
        return data;
    }
	
	
	@DataProvider(name = "dataAsExcel")
   
    public static Object[][] dataProviderAsExcel(){
        Object[][] data = null;
        
        String dataFile = System.getProperty("user.dir") + "/src/main/java/com/kaplan/pomframework/data.xls";

        File file = new File(dataFile);
        if(file.exists())

            try {
                Workbook workBook = Workbook.getWorkbook(new File(dataFile));

                Sheet sheet = workBook.getSheet("Sheet1");

                data = new Object[sheet.getRows() - 1][sheet.getColumns()];
                String cellData = null;
                for (int j = 0; j < sheet.getColumns(); j++) {
                    for (int i = 1; i < sheet.getRows(); i++) {
                        Cell cell = sheet.getCell(j, i);
                        CellType type = cell.getType();

                        if (type == CellType.LABEL) {
                            cellData = cell.getContents();
                        }
                        else if (type == CellType.NUMBER) {
                            cellData = cell.getContents().toString();
                        }
                        
                        data[i - 1][j] = cellData;
                }
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (BiffException e) {
                e.printStackTrace();
            }
           
        
       
        return data;
    }
	}
