package json;

public class JsonFactory extends DataFactory{

	@Override
	public Data creatData(String type) {
		return new JsonData();
	}

}
