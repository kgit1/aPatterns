package xxx.GG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FinalGGPostSendConnectionTest {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://goodgame.ru/ajax/chatlogin");
		Map<String, Object> params = new LinkedHashMap<>();
		params.put("login", "bobbin");
		params.put("password", "qwert111");
		StringBuilder postData = new StringBuilder();
		for (Map.Entry<String, Object> param : params.entrySet()) {
			if (postData.length() != 0)
				postData.append('&');
			postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
			postData.append('=');
			postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
		}
		byte[] postDataBytes = postData.toString().getBytes("UTF-8");

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
		conn.setDoOutput(true);
		conn.getOutputStream().write(postDataBytes);

		Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

		String responceString = "";
		char a;
		for (int c; (c = in.read()) >= 0;) {
			System.out.print((char) c);
			char temp = (char) c;
			responceString += temp;
		}

		ObjectMapper objectMapper = new ObjectMapper();
		HashMap<String, Object> map = objectMapper.readValue(responceString, new TypeReference<Map<String, Object>>() {
		});

		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Entry entry = (Entry) it.next();
			System.out.print(entry.getKey() + " : ");
			System.out.println(entry.getValue());
		}

	}
}