package myproject;

import org.apache.poi.ss.usermodel.Workbook;

import myproject.DATA.BlockingStrategy;

public class ReadData {

	TypeData td;
	public ReadData() {
		// TODO Auto-generated constructor stub
	}

	public TypeData  getBs() {
		return td;
	}
	public void setBs(TypeData td) {
		this.td = td;
	}
	public Workbook applyReader(String filePath) {
		System.out.println("aa");
		return null;
	}

}
