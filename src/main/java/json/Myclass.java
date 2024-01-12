package json;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import matching.DistanceJaccard;
import matching.FunctionMatching;
import matching.MatchingStrategy;
import matching.Naive;
import matching.SimilariteChaine;
import matching.StrategyLogique;
import myproject.Exel;
import myproject.ReadData;
import myproject.Aligner.AlignerData;
import myproject.Aligner.ManualMethode;
import myproject.Aligner.WorkbookPrinter;
import myproject.DATA.BlockingStrategy;
import myproject.DATA.DataFilter;
import myproject.DATA.HashBlocking;
import myproject.DATA.QGramsBlocking;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.core.async.BlockingQueueFactory;
import org.apache.poi.ss.usermodel.Workbook;
public class Myclass {
	
	public static void main(String[] args) {
		/*
		 * Data d = new JsonData(); d.ReadData();
		 */
		List<Boolean> l=new ArrayList<Boolean>();
		l.add(true);
		l.add(true);
		l.add(true);
		SimilariteChaine sa = new DistanceJaccard();
		double sueil=0.1;
		MatchingStrategy m = new StrategyLogique(sa, l,sueil);
		
		
		
		
		DataFactory d =new ExcelFactory();
		Data dd = d.creatData("excel");
		AlignerData ad = new AlignerData(new ManualMethode());
		ad.addData((Workbook)dd.ReadData("C:\\\\atelierHafidi.xlsx"));
		ad.addData((Workbook)dd.ReadData("C:\\\\atelierHafidi.xlsx"));
	Workbook data = (Workbook) ad.applyAlignerStrategy();
	

		BlockingStrategy b = new QGramsBlocking();
	DataFilter f = new DataFilter();
		f.setBs(b);
		
//		String[] s = {"a","b","c"};
		Map<String,Workbook> ss = f.getBs().BlockingData(data);
for(int i=0;i<ss.size();i++) {
	List<List<String>> gf =	WorkbookPrinter.convertWorkbookToList(ss.get(i));

	System.out.println(gf.size());
	FunctionMatching ff = new Naive(m,gf);
		ff.matchung();
			
		System.out.println(gf.size());

}
//		
//List<List<String>> gf =	WorkbookPrinter.convertWorkbookToList(data);
//
//System.out.println(gf.size());
//FunctionMatching ff = new Naive(m,gf);
//	ff.matchung();
//		
//	System.out.println(gf.size());

		
		
    }
}
