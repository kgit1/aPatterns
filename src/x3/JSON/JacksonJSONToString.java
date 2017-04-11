package x3.JSON;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonJSONToString {

	public static void main(String[] args) {
		// ObjectMapper provides functionality for reading and writing JSON,
		// either to and from basic POJOs (Plain Old Java Objects), or to and
		// from a general-purpose JSON Tree Model (JsonNode), as well as related
		// functionality for performing conversions.
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			// create new file object with file path
			File jsonFile = new File("map.json");

			// create persons array and initialize with data from json file with
			// help of readValue() method, which takes
			// file and type reference to create needed type of data by pattern
			// (like map, or array) - from json file
			Map<String, Object> mapObject = objectMapper.readValue(jsonFile, new TypeReference<Map<String, Object>>() {
			});
			System.out.println("name: " + mapObject.get("name"));
			System.out.println("city: " + mapObject.get("city"));
			System.out.println("mobile: " + mapObject.get("mobile"));
			System.out.println("friends: ");
			List<Object> list = (List<Object>) mapObject.get("friends");

			for (Object object : list) {
				System.out.println("\t" + object);
			}

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
