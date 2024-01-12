package myproject.Aligner;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

import myproject.ReadData;

public class AlignerData<T> {
    AlignerStrategy<T> as;
    List<T> data;

    public AlignerData(AlignerStrategy<T> as) {
        data = new ArrayList<>();
        this.as = as;
    }

    public void addData(T data) {
        this.data.add(data);
    }

    public T applyAlignerStrategy() {
        if (data.size() > 1 && as instanceof PasAlignementSchemaStrategie) {
            throw new Error("There is more than one data here; should modify strategy to use");
        } else if (data.size() <= 1 && !(as instanceof PasAlignementSchemaStrategie)) {
            throw new Error("There is only one data here; should modify strategy to use");
        }
        return as.AlignerData(this.data);
    }
}

