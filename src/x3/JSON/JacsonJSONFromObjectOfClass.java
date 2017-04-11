package x3.JSON;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacsonJSONFromObjectOfClass {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		// ObjectMapper provides functionality for reading and writing JSON,
		// either to and from basic POJOs (Plain Old Java Objects), or to and
		// from a general-purpose JSON Tree Model (JsonNode), as well as related
		// functionality for performing conversions. 
		ObjectMapper objectMapper = new ObjectMapper();
		
		//create person objects for input to json file
		Person person1 = new Person();
		person1.setName("Roger1");
		person1.setCity("LasVegas1");
		person1.setMobile("185756374");
		person1.setFriends(new ArrayList<String>(Arrays.asList("Marry1", "Poppy1", "Biron1")));
		Person person2 = new Person();
		person2.setName("Roger2");
		person2.setCity("LasVegas2");
		person2.setMobile("285756374");
		person2.setFriends(new ArrayList<String>(Arrays.asList("Marry2", "Poppy2", "Biron2")));
		Person person3 = new Person();
		person3.setName("Roger3");
		person3.setCity("LasVegas3");
		person3.setMobile("385756374");
		person3.setFriends(new ArrayList<String>(Arrays.asList("Marry3", "Poppy3", "Biron3")));
		
		//put persons together to one array
		List<Person> listOfPersons = new ArrayList<>();
		listOfPersons.add(person1);
		listOfPersons.add(person2);
		listOfPersons.add(person3);
		
		//put array into json file
		objectMapper.writeValue(new File("arrayPersons.json"), listOfPersons);

	}

}
