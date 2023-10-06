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
        Cell cell = cells.find("User66", null, findOptions);

// Show the cell name and its value
        System.out.println("Name of the cell containing String: " + cell.getName());
        System.out.println("the cell value is: " + cell.getValue());



// Define it as Regex
        findOptions.setRegexKey(true);
        findOptions.setLookAtType(LookAtType.ENTIRE_CONTENT);
        findOptions.setLookInType(LookInType.VALUES);
        cell = cells.find("[A-Za-z0-9]{5,25}", cell, findOptions);
        System.out.println("Name of the cell containing String: " + cell.getName());
        System.out.println("the cell value is: " + cell.getValue());

//cell range
        fileName=resourceBundle.getString("employeefilename");
        file=new File(dirName,fileName);
        fileInputStream=new FileInputStream(file);
        workbook=new Workbook(fileInputStream);
        sheet=workbook.getWorksheets().get(0);
        CellArea cellArea=new CellArea();
        cellArea.StartRow=14;
        cellArea.EndRow=40;
        cellArea.StartColumn=1;
        cellArea.EndColumn=4;
        findOptions.setRange(cellArea);
        findOptions.setCaseSensitive(true);
      //  findOptions.setLookAtType(LookAtType.START_WITH);
        cells=sheet.getCells();
        Cell nextCell=null;
        do{

            nextCell=sheet.getCells().find("2021",nextCell,findOptions);
            if(nextCell==null)
                break;
            else
                System.out.println(nextCell.getValue().toString().trim());

        }
        while(true);

    }
}
