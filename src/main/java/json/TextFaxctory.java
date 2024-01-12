package json;

public class TextFaxctory extends DataFactory{

	@Override
	public Data creatData(String type) {
		return new TextData();
	}

}
