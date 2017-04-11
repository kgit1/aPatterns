package x3.JSON;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonJSONToStringByProjectClass2 {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		// ObjectMapper provides functionality for reading and writing JSON,
		// either to and from basic POJOs (Plain Old Java Objects), or to and
		// from a general-purpose JSON Tree Model (JsonNode), as well as related
		// functionality for performing conversions.
		ObjectMapper objectMapper = new ObjectMapper();

		// create persons array and initialize with data from json file with
		// help of readValue() method, which takes
		// file and type reference to create needed type of data by pattern
		// (like map, or array) - from json file
		PersonsArray persons = objectMapper.readValue(new File("arrayPersons.json"), PersonsArray.class);

		for (Person person : persons) {
			System.out.println(person);
		}
	}
}
