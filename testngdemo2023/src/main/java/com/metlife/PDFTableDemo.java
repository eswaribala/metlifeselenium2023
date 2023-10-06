package com.metlife;

import com.spire.pdf.PdfDocument;
import com.spire.pdf.utilities.PdfTable;
import com.spire.pdf.utilities.PdfTableExtractor;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

public class PDFTableDemo {


    @Test
    public void testPDFTables(){
        ResourceBundle resourceBundle=ResourceBundle.getBundle("file");
        String dirName=resourceBundle.getString("userdir");
        String fileName=resourceBundle.getString("pdffilename");
        PdfDocument pdfDocument=new PdfDocument(".\\"+dirName+"\\"+fileName);
        PdfTableExtractor pdfTableExtractor=new PdfTableExtractor(pdfDocument);
        PdfTable[] pdfTables=null;
        StringBuilder stringBuilder=new StringBuilder();
        for(int pageIndex=0;pageIndex<pdfDocument.getPages().getCount();pageIndex++){

            pdfTables=pdfTableExtractor.extractTable(pageIndex);

            if(pdfTables!=null && pdfTables.length>0){

                for (PdfTable pdfTable:pdfTables){
                    for(int i=0;i<pdfTable.getRowCount();i++){
                        for(int j=0;j<pdfTable.getColumnCount();j++){

                            stringBuilder.append(pdfTable.getText(i,j)+"|");
                        }
                    }
                }
            }


        }



    }
}
