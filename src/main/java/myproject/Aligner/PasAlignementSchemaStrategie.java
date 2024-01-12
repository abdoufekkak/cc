package myproject.Aligner;

import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

public class PasAlignementSchemaStrategie implements AlignerStrategy<Workbook>{

	public PasAlignementSchemaStrategie() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Workbook AlignerData(List<Workbook> data) {
		// pas d'alignement car 1 schema utilizer
		return data.get(0);
	}

}
