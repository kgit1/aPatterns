package x3.JSON;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonJSONFromStringDeep {

	public static void main(String[] args) {
		// ObjectMapper provides functionality for reading and writing JSON,
		// either to and from basic POJOs (Plain Old Java Objects), or to and
		// from a general-purpose JSON Tree Model (JsonNode), as well as related
		// functionality for performing conversions.
		ObjectMapper objectMapper = new ObjectMapper();

		// create map to hold map objects
		Map<String, Object> mapOutside = new HashMap<>();
		// create inner map to hold map objects
		Map<String, Object> mapInside = new HashMap<>();

		// fill inner map object with map object containing data
		mapInside.put("person1", putInsideMap("John", "London", 88803522,
				new ArrayList<Object>(Arrays.asList("Ron", "Garry", "Germiona"))));
		mapInside.put("person2", putInsideMap("John2", "London2", 88822522,
				new ArrayList<Object>(Arrays.asList("Ron2", "Garry2", "Germiona2"))));
		mapInside.put("person3", putInsideMap("John3", "London3", 88855522,
				new ArrayList<Object>(Arrays.asList("Ron3", "Garry3", "Germiona3"))));

		// put inner map to outer map
		mapOutside.put("Database", mapInside);

		try {
			// with help of writeValue() method put outer map object with all
			// inside maps and data
			// to json file by passing to method writeValue of th ObjectMapper
			// object - file object and our map object
			objectMapper.writeValue(new File("mapDeep.json"), mapOutside);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Map<String, Object> putInsideMap(String name, String city, int mobile, List<Object> friends) {
		Map<String, Object> mapInsideInside = new HashMap<>();
		mapInsideInside.put("name", name);
		mapInsideInside.put("city", city);
		mapInsideInside.put("mobile", mobile);
		mapInsideInside.put("friends", friends);
		return mapInsideInside;
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
