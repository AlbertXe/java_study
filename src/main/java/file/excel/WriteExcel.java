package file.excel;

import java.awt.event.InputEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jxl.read.biff.BiffException;
import jxl.read.biff.PasswordException;


public class WriteExcel {
	private final static String XLS = "xls";
	private final static String XLSX = "xlsx";
	
	public static void main(String[] args) {
		Map<String, String> map = new HashedMap<>();
		map.put("name", "name");
		map.put("address", "address");
		map.put("phone", "Iphobe");
		List<Map> datas = new ArrayList<>();
		datas.add(map);
		try {
			write(datas, 3, "E:/name.xls");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void write(List<Map> datas,int columnSum ,String path) throws Exception{
		OutputStream out = null;
		int columnNum = columnSum;
		File file = new File(path);
		Workbook book = getWorkBook(file);
		
		Sheet sheet = book.getSheetAt(0);
		int rowNo = sheet.getLastRowNum(); // 行号
		for (int i = 1; i < rowNo; i++) {
			sheet.removeRow(sheet.getRow(i)); // 删除除第0 行外所有
		}
		
		try {
			out = new FileOutputStream(file);//文件输出流，输出电子表格
			book.write(out);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < datas.size(); i++) { //  表格内循环
			Row row = sheet.getRow(i+1);
			if (row == null) {
				row = sheet.createRow(i+1);
			}
			Map map = datas.get(i);
			String name = map.get("name").toString();
			String address = map.get("address").toString();
			String phone = map.get("phone").toString();
			
			for (int j = 0; j < columnNum; j++) { // 行内循环
				Cell first = row.createCell(0);
				first.setCellValue(name);
				Cell second = row.createCell(1);
				second.setCellValue(address);
				Cell third = row.createCell(2);
				third.setCellValue(phone);
			}
			out = new FileOutputStream(file);
			book.write(out);
		}
	}
	
	public static void read(File file){
		try {
			InputStream is = new FileInputStream(file);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 根据后缀 创建工作薄
	 * @param file
	 * @return
	 */
	private static Workbook getWorkBook(File file) {
		Workbook book = null;
		
		try {
			FileInputStream fis = new FileInputStream(file);
			if (file.getName().endsWith(XLS)) {
				book = new HSSFWorkbook(fis);
			}else if (file.getName().endsWith(XLSX)) {
				book = new XSSFWorkbook(fis);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return book;
	}
}
