package json;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonData implements Data{

	@Override
	public Object ReadData(String path) {
		// TODO Auto-generated method stub
		try {
            // Specify the path to your JSON file
            String filePath = "src/json/dwsample1-json.json";

            // Create an ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON file and parse it into a JsonNode
            JsonNode jsonNode = objectMapper.readTree(new File(filePath));

            // Process the JSON data as needed
            System.out.println("JSON content:\n" + jsonNode.toString());
        

        } catch (IOException e) {
            e.printStackTrace();
        }
		return null;
	}

}
