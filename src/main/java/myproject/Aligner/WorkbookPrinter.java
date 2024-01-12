package myproject.Aligner;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class WorkbookPrinter {
	public static List<List<String>> convertWorkbookToList(Workbook workbook) {
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            Sheet sheet = workbook.getSheetAt(i);
            boolean isFirstRow = true;

            for (Row row : sheet) {
                // Ignorer la première ligne (en-tête)
                if (isFirstRow) {
                    isFirstRow = false;
                    continue;
                }

                List<String> rowData = new ArrayList<>();
                for (Cell cell : row) {
                    rowData.add(getCellValueAsString(cell));
                }
                result.add(rowData);
            }
        }
        return result;
    }

    private static String getCellValueAsString(Cell cell) {
        DataFormatter formatter = new DataFormatter(); // Utilisé pour obtenir la valeur de la cellule sous forme de chaîne
        return formatter.formatCellValue(cell);
    }    
}
