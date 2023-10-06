package com.metlife;

import com.aspose.cells.*;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ResourceBundle;

public class ExcelAsposeDemo {

    @Test
    public void testFindOptionInExcel() throws Exception {
        ResourceBundle resourceBundle=ResourceBundle.getBundle("file");
        String dirName=resourceBundle.getString("userdir");
        String fileName=resourceBundle.getString("userfilename");
        File file=new File(dirName,fileName);
        FileInputStream fileInputStream=new FileInputStream(file);
        Workbook workbook=new Workbook(fileInputStream);
        Worksheet sheet=workbook.getWorksheets().get(0);
// Get all the cells in CellCollections
        Cells cells = sheet.getCells();

// Initialize FindOptions
        FindOptions findOptions = new FindOptions();

// Find the cell containing a string value
        findOptions.setLookAtType(LookAtType.ENTIRE_CONTENT);
        Cell cell = cells.find("User38", null, findOptions);

// Show the cell name and its value
        System.out.println("Name of the cell containing String: " + cell.getName());
        System.out.println("the cell value is: " + cell.getValue());

    }
}
