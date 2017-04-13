package xxx.GG;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Test {
	
	public static void main(String args[]) throws Exception{
	    URL url = new URL("http://api2.goodgame.ru/oauth");
	    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	    connection.setConnectTimeout(5000);//5 secs
	    connection.setReadTimeout(5000);//5 secs

	    connection.setRequestMethod("POST");
	    connection.setDoOutput(true);
	    connection.setRequestProperty("Content-Type", "application/json");

	    List<String> list = new ArrayList<>();
	    list.add("kirtt");
	    list.add("qwert111");
	    
	    
	    OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());  
	    out.write("{\"login\":\"kirtt\",\"password\":\"qwert111\"}"    		
//	            "[ " +
//	            "\"kirtt\"," +
//	            "\"qwert111\" " +
//	            "]"
	            );
	    System.out.println(out.toString());
	    out.flush();
	    out.close();

	    int res = connection.getResponseCode();

	    System.out.println(res);


	    InputStream is = connection.getInputStream();
	    BufferedReader br = new BufferedReader(new InputStreamReader(is));
	    String line = null;
	    while((line = br.readLine() ) != null) {
	        System.out.println(line);
	    }
	    connection.disconnect();

	}

}
