package xx.WebSocket;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TestSocketConnect {

	public static void main(String[] args) throws URISyntaxException, InterruptedException {
		
		
		
		// create uri
		URI endpointURI = new URI("ws://chat.goodgame.ru:8081/chat/websocket");
//		URI endpointURI = new URI("http://api2.goodgame.ru/oauth");

		// open webSocket
		ClientEndPoint clientEndpoint = new ClientEndPoint(endpointURI);

		// add listener
		clientEndpoint.addMessagehandler(new ClientEndPoint.MessageHandler() {
			@Override
			public void handleMessage(String message) {
				System.out.println(message);
			}
		});

		Thread.sleep(5000);

		String message = "";
		Scanner scan = new Scanner(System.in);

		while (true) {

			message = scan.nextLine();
			if(message!=""){
				System.out.println("=============");
			clientEndpoint.sendMessage(message);
			message="";
			}
		}
	}
	
//	{"type":"get_channels_list","data":{"start":0,"count": 50}}
	
	
//	public static void jsonEncode(String type, String... data){
//		ObjectMapper objectMapper = new ObjectMapper();
//		Map<String,Object> map = new HashMap<>();
//		
//		map.put("type", type);
//		map.put("data", data);
//		objectMapper.wrtev
//	}
	
	public static void jsonDecode(){}
	
	
}
