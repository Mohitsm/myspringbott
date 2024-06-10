package com.employeeMSMS.helper;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Component;

import com.employeeMSMS.entity.Employees;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class ExcelParser {

    public static List<Employees> parse(InputStream inputStream) throws IOException {
        List<Employees> employees = new ArrayList<>();

        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0); // Assuming the data is in the first sheet

        Iterator<Row> rowIterator = sheet.iterator();
        // Skip header row if needed
        if (rowIterator.hasNext()) {
            rowIterator.next(); // Skip header row
        }

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Employees employee = new Employees();
            employee.setFirstName(row.getCell(0).getStringCellValue());
            employee.setLastName(row.getCell(1).getStringCellValue());
            // Set other properties as needed
            employees.add(employee);
        }

        workbook.close();
        return employees;
    }
}
