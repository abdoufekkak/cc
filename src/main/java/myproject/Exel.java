package myproject;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exel implements TypeData{

	public Exel() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Workbook Reader(String filePath) {
		Workbook workbook = null;
        try (FileInputStream file = new FileInputStream(filePath)) {
            if (filePath.endsWith(".xlsx")) {
                workbook = new XSSFWorkbook(file);
            } else if (filePath.endsWith(".xls")) {
                workbook = new HSSFWorkbook(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return workbook;
	}

}
