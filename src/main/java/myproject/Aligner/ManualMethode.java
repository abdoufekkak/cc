package myproject.Aligner;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManualMethode implements AlignerStrategy<Workbook> {

    private Map<String, String> columnMappings; // To store column correspondences

    @Override
    public Workbook AlignerData(List<Workbook> data) {
        if (data == null || data.size() < 2) {
            throw new IllegalArgumentException("Two workbooks are required for alignment");
        }

        Workbook workbookOne = data.get(0);
        Workbook workbookTwo = data.get(1);
        Workbook mergedWorkbook = new XSSFWorkbook();

        Sheet sheet1 = workbookOne.getSheetAt(0);
        Sheet sheet2 = workbookTwo.getSheetAt(0);
        Sheet mergedSheet = mergedWorkbook.createSheet("Merged");

        copyRowsToMergedSheet(sheet1, mergedSheet, 0);
        int startRowForSecondSheet = mergedSheet.getLastRowNum()-1 ;
        copyRowsToMergedSheet(sheet2, mergedSheet, startRowForSecondSheet);

        return mergedWorkbook;
    }

    private static void copyRowsToMergedSheet(Sheet sourceSheet, Sheet destinationSheet, int startRow) {
    	int k;
    	if(startRow==0) {
    		k=0;
    	}
    	else {
    		k=1;
    	}
        for (int i = k; i <= sourceSheet.getLastRowNum(); i++) {
            Row sourceRow = sourceSheet.getRow(i);
            Row newRow = destinationSheet.createRow(i + startRow);

            if (sourceRow != null) {
                copyRow(sourceRow, newRow, destinationSheet.getWorkbook());
            }
        }
    }

    private static void copyRow(Row sourceRow, Row destinationRow, Workbook destinationWorkbook) {
        for (int j = 0; j < sourceRow.getLastCellNum(); j++) {
            Cell oldCell = sourceRow.getCell(j);
            Cell newCell = destinationRow.createCell(j);

            if (oldCell != null) {
                copyCell(oldCell, newCell, destinationWorkbook);
            }
        }
    }

    private static void copyCell(Cell oldCell, Cell newCell, Workbook destinationWorkbook) {
        CellStyle newCellStyle = destinationWorkbook.createCellStyle();
        newCellStyle.cloneStyleFrom(oldCell.getCellStyle());
        newCell.setCellStyle(newCellStyle);

        switch (oldCell.getCellType()) {
            case STRING:
                newCell.setCellValue(oldCell.getStringCellValue());
                break;
            case NUMERIC:
                newCell.setCellValue(oldCell.getNumericCellValue());
                break;
            case BOOLEAN:
                newCell.setCellValue(oldCell.getBooleanCellValue());
                break;
            case FORMULA:
                newCell.setCellFormula(oldCell.getCellFormula());
                break;
            case BLANK:
                newCell.setCellType(CellType.BLANK);
                break;
            case ERROR:
                newCell.setCellErrorValue(oldCell.getErrorCellValue());
                break;
            default:
                break;
        }
    }
}
