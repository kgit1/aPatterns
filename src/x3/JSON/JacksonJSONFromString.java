package x3.JSON;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonJSONFromString {

	public static void main(String[] args) {
		// ObjectMapper provides functionality for reading and writing JSON,
		// either to and from basic POJOs (Plain Old Java Objects), or to and
		// from a general-purpose JSON Tree Model (JsonNode), as well as related
		// functionality for performing conversions. It is also highly
		// customizable to work both with different styles of JSON content, and
		// to support more advanced Object concepts such as polymorphism and
		// Object identity. ObjectMapper also acts as a factory for more
		// advanced ObjectReader and ObjectWriter classes. Mapper (and
		// ObjectReaders, ObjectWriters it constructs) will use instances of
		// JsonParser and JsonGenerator for implementing actual reading/writing
		// of JSON. Note that although most read and write methods are exposed
		// through this class, some of the functionality is only exposed via
		// ObjectReader and ObjectWriter: specifically, reading/writing of
		// longer sequences of values is only available through
		// ObjectReader.readValues(InputStream) and
		// ObjectWriter.writeValues(OutputStream).
		ObjectMapper objectMapper = new ObjectMapper();

		// create new map object, currently hashMap
		Map<String, Object> mapObject = new HashMap<>();

		// put data to map
		mapObject.put("name", "John");
		mapObject.put("city", "London");
		mapObject.put("mobile", 847339282);

		// create array and fill with data
		List<Object> friends = new ArrayList<>();
		friends.add("Rick");
		friends.add("Morty");
		friends.add("Germiona");

		// put array to map too
		mapObject.put("friends", friends);

		try {
			// with help of writeValue() method put map object with all data
			// to json file by passing to writeValue()  method of the ObjectMapper
			// object - file object and our map object
			objectMapper.writeValue(new File("map.json"), mapObject);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// String sorting = "{\"state\":\"desc\"}";
	// JSONObject filter = new JSONObject(sorting);
	//
	// Map<String,String> map = new HashMap<String,String>();
	// Iterator iter = filter.keys();
	// while(iter.hasNext()){
	// String key = (String)iter.next();
	// String value = filter.getString(key);
	// map.put(key,value);
	// }

}
