package com.employeeMSMS.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.employeeMSMS.entity.Excel;

public class Helpere {
	
	public static boolean chekExcelFromat(MultipartFile file) {
		String contentType=file.getContentType();
		
		if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return true;
		}else {
			return false;
		}
	}
	
	public static List<Excel> converExcelToList(InputStream is){
		
		List<Excel> list=new ArrayList<>();
		try {
			
			XSSFWorkbook workbook=new XSSFWorkbook(is);
			
			XSSFSheet sheet=workbook.getSheet("data");
			
			int rowNumber=0;
			Iterator<Row> iterator=sheet.iterator();
			
			while(iterator.hasNext()) {
				Row row=iterator.next();
				
				if(rowNumber==0) {
					rowNumber++;
					continue;
				}
				Iterator<Cell> cells=row.iterator();
				
				int cid=0;
				Excel d=new Excel();
				
				while(cells.hasNext()) {
					Cell cell=cells.next();
					switch(cid) {
					case 0:d.setProductName(cell.getStringCellValue());
					
					case 1:d.setProductDesc(cell.getStringCellValue());
					
					case 2:d.setProductPrice(cell.getStringCellValue());
					
					default:break;
					}
					cid++;
					
				}
				list.add(d);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
		
	}

}
