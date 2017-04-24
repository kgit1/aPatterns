package x.CodeWars;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TryCatchURLConnect {

	public static void main(String[] args) {

		URL url;
		InputStream in;
		InputStreamReader reader;
		int data = 0;
		String result = "";

		try {
			url = new URL(
					"http://javarevisited.blogspot.com/2017/04/recursive-binary-search-algorithm-in-java-example.html");
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

			in = httpURLConnection.getInputStream();

			reader = new InputStreamReader(in);

			data = reader.read();

			while (data > -1) {
				char temp = (char) data;
				// System.out.println(temp);
				result += temp;

				data = reader.read();
			}
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(result);

	}

}
