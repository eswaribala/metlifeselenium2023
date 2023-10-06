package com.metlife;

import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;
import com.spire.pdf.texts.PdfTextExtractOptions;
import com.spire.pdf.texts.PdfTextExtractor;
import com.spire.pdf.utilities.PdfTable;
import com.spire.pdf.utilities.PdfTableExtractor;
import org.testng.annotations.Test;

import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ResourceBundle;

public class PDFTableDemo {


    @Test
    public void testPDFTables() throws IOException {
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
                        stringBuilder.append("\n");
                    }
                }
            }

            FileWriter fileWriter=new FileWriter(new File("data.txt"));
            fileWriter.write(stringBuilder.toString());
            fileWriter.close();

        }



    }

    @Test
    public void testPDFTextExtraction() throws IOException {
        ResourceBundle resourceBundle=ResourceBundle.getBundle("file");
        String dirName=resourceBundle.getString("userdir");
        String fileName=resourceBundle.getString("pdffilename");
        PdfDocument pdfDocument=new PdfDocument(".\\"+dirName+"\\"+fileName);
        PdfPageBase pdfPageBase=pdfDocument.getPages().get(1);
        PdfTextExtractor pdfTextExtractor=new PdfTextExtractor(pdfPageBase);
        PdfTextExtractOptions pdfTextExtractOptions=new PdfTextExtractOptions();
        Rectangle2D rectangle2D=new Rectangle2D.Float(0,0,1000,400);
        pdfTextExtractOptions.setExtractArea(rectangle2D);
        String text=pdfTextExtractor.extract(pdfTextExtractOptions);
        FileWriter fileWriter=new FileWriter(new File("pdftext.txt"));
        fileWriter.write(text);
        fileWriter.close();
    }
}
