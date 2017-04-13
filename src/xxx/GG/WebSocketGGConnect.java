package xxx.GG;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WebSocketGGConnect {

	public static void main(String[] args) throws URISyntaxException, InterruptedException {

		// create uri
		URI endpointURI = new URI("ws://chat.goodgame.ru:8081/chat/websocket");

		// open webSocket
		ClientEndPoint clientEndpoint = new ClientEndPoint(endpointURI);

		// add listener
		clientEndpoint.addMessageHandler(new ClientEndPoint.MessageHandler() {
			@Override
			public void handleMessage(String responceMessage) {
				jsonDecode(responceMessage);
				// System.out.println(responceMessage);
			}
		});

		Thread.sleep(5000);

//		String commandMessage = "{\"type\":\"get_channels_list\",\"data\":{\"start\":0,\"count\":200}}";
//		 clientEndpoint.sendMessage(commandMessage);
//		 commandMessage = "";

		String commandMessage="";
		Scanner scan = new Scanner(System.in);

		while (true) {

			commandMessage = scan.nextLine();
			if (commandMessage != "") {
				System.out.println("=============");
				clientEndpoint.sendMessage(commandMessage);
				commandMessage = "";
			}
		}
	}

	//channels list max 50
	// {"type":"get_channels_list","data":{"start":0,"count": 50}}
	//{"type":"auth","data":{"user_id":"123","token":"123123fhjdhfjd"}}

	public static void jsonEncode() {
	}

	public static void jsonDecode(String responceMessage) {

		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = objectMapper.readValue(responceMessage, new TypeReference<Map<String, Object>>() {
			});
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("=================");

		Iterator<Entry<String, Object>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, Object> entry = it.next();
			if (entry.getKey().equals("data")) {
				Iterator<Entry<String, Object>> it2 = ((Map<String, Object>) entry.getValue()).entrySet().iterator();
				while (it2.hasNext()) {
					Entry<String, Object> entry2 = it2.next();
					if (entry2.getKey().equals("channels")) {
						
						ArrayList<LinkedHashMap<String,String>> list = (ArrayList<LinkedHashMap<String, String>>) entry2.getValue();
						for (LinkedHashMap<String, String> linkedHashMap : list) {
							System.out.println(linkedHashMap.toString());
						}
						
//						Iterator<Entry<String, Object>> it3 = ((Map<String, Object>) entry2.getValue()).entrySet()
//								.iterator();
//						while (it3.hasNext()) {
//							Entry<String, Object> entry3 = it3.next();
//							System.out.println(entry3.getKey() + " : " + entry3.getValue());
//						}
					} else {
						System.out.println(entry2.getKey() + " : " + entry2.getValue());
					}
				}
			} else {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}

		System.out.println("=======================");

		// for (Entry entry : map.entrySet()) {
		// System.out.println(entry.getKey() + " : " + entry.getValue());
		// }

	}

}
