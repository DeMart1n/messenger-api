package com.simcafe.messengerapi;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    public static List<Contact> readExcel(String filePath) throws Exception {
        List<Contact> contacts = new ArrayList<>();
        FileInputStream file = new FileInputStream(new File(filePath));

        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            String name = row.getCell(0).getStringCellValue();
            String phoneNumber = row.getCell(1).getStringCellValue();
            String message = row.getCell(2).getStringCellValue();

            contacts.add(new Contact(name, phoneNumber, message));
        }

        workbook.close();
        file.close();

        return contacts;
    }
}
