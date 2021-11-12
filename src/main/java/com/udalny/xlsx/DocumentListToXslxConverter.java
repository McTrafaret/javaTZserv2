package com.udalny.xlsx;

import com.udalny.entity.Document;
import com.udalny.filenamegenerator.FileNameGenerator;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

@Service
public class DocumentListToXslxConverter
        implements DocumentListToSpreadsheetConverter {

    private static final Logger logger = LoggerFactory.getLogger(DocumentListToXslxConverter.class);

    private static final String[] columnNames = {
            "Номер документа",
            "Дата документа",
            "Сумма документа",
            "Наименование плательщика",
            "БИК банка плательщика",
            "Наименование получателя",
            "БИК банка получателя"
    };

    @Value("${xlsx.save.path}")
    private String savePath;

    @Autowired
    private FileNameGenerator fileNameGenerator;

    @Override
    public void convert(List<Document> docs) {
        XSSFWorkbook workbook = createWorkbook(docs);
        String filename = fileNameGenerator.generate();
        try {
            OutputStream out = new FileOutputStream(String.format("%s/%s", savePath, filename));
            workbook.write(out);
        } catch (Exception ex) {
            logger.error("Failed to create file", ex);
        }
    }

    private void addDocument(CellStyle dateStyle, Row row, Document doc) {
        Cell dateCell = row.createCell(1);
        dateCell.setCellValue(doc.getDocDate());
        dateCell.setCellStyle(dateStyle);
        row.createCell(0).setCellValue(doc.getDocNum());
        row.createCell(2).setCellValue(doc.getAmountOut().doubleValue());
        row.createCell(3).setCellValue(doc.getPayer().getCname());
        row.createCell(4).setCellValue(doc.getPayerBank().getBic());
        row.createCell(5).setCellValue(doc.getReceiver().getCname());
        row.createCell(6).setCellValue(doc.getReceiverBank().getBic());
    }

    private XSSFWorkbook createWorkbook(List<Document> docs) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet mainSheet = workbook.createSheet("main");
        Row row = mainSheet.createRow(0);
        for (int i = 0; i < columnNames.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(columnNames[i]);
        }
        int i = 1;
        CreationHelper helper = workbook.getCreationHelper();
        CellStyle style = workbook.createCellStyle();
        style.setDataFormat(helper.createDataFormat().getFormat("mm/dd/yyyy hh:mm:ss"));
        for (Document doc : docs) {
           row = mainSheet.createRow(i);
           addDocument(style, row, doc);
           i++;
        }
        return workbook;
    }
}
