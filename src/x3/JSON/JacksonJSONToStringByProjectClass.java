package x3.JSON;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonJSONToStringByProjectClass {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		Persons persons = objectMapper.readValue(new File("mapDeep.json"), Persons.class);
		
		HashMap<String, Person> projects=persons.get("Database");
		
		Iterator it = projects.entrySet().iterator();
		for (Entry entry : projects.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		

	}

}
