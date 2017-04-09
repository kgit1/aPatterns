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
		ObjectMapper objectMapper = new ObjectMapper();
		System.out.println();

		try {
			File jsonFile = new File("map.json");
			Map<String, Object> mapObject = objectMapper.readValue(jsonFile, new TypeReference<Map<String, Object>>() {
			});
			System.out.println("name: " + mapObject.get("name"));
			System.out.println("city: " + mapObject.get("city"));
			System.out.println("mobile: " + mapObject.get("mobile"));
			System.out.println("friends: ");
			List<Object> list = (List<Object>) mapObject.get("friends");

			for (Object object : list) {
				System.out.println("\t"+object);
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
