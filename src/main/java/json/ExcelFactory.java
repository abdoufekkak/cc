package json;

public class ExcelFactory extends DataFactory{

	@Override
	public Data creatData(String type) {
		return (Data) new ExcelData();
	}

}
