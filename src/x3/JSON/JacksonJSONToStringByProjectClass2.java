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
		ObjectMapper objectMapper = new ObjectMapper();
		PersonsArray persons = objectMapper.readValue(new File("arrayPersons.json"), PersonsArray.class);
		
		for (Person person : persons) {
			System.out.println(person);
		}
	}
}
