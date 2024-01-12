package json;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData implements Data{

	@Override
	public Object ReadData(String path) {
		Workbook workbook = null;
        try (FileInputStream file = new FileInputStream(path)) {
            if (path.endsWith(".xlsx")) {
                workbook = new XSSFWorkbook(file);
            } else if (path.endsWith(".xls")) {
                workbook = new HSSFWorkbook(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return workbook;
	}

}
