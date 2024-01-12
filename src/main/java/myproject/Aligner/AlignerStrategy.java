package myproject.Aligner;

import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

public interface AlignerStrategy<T> {
    public T AlignerData(List<T> data);
}
