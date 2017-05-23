package xxx.temp;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpURLConnectionCelebs {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://www.imdb.com/list/ls052283250");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.addRequestProperty("User-Agent", "Mozilla/4.76");
		InputStream in = con.getInputStream();
		InputStreamReader reader = new InputStreamReader(in);
		int data = reader.read();
		StringBuilder result = new StringBuilder();
		while (data > -1) {
			char temp = (char) data;
			// System.out.println(temp);
			result.append(temp);
			data = reader.read();
		}
		// System.out.println("============");
		// System.out.println(result.length());
		// System.out.println(result);

		// String[] splitString = result.toString().split("<div
		// class=\"list_item");
		// for(int i =0;i<splitString.length;i++){
		// System.out.println("---------------");
		// System.out.println(splitString[i]);
		// }
		// System.out.println(Arrays.toString(splitString));

		// use regex code to split string by patterns
		// this expression will find in string - one, than - two - and than
		// return all what between them
		// create pattern with regex equation
		// Pattern p = Pattern.compile("one(.*?)two");
		// after pattern - create matcher and match p(patter) - with our string
		// in brackets
		// pattern ->p.matcher(result)<- string to check for pattern
		// Matcher m = p.matcher(result);

		/////////////////////////////////////////////////////////////

		// pattern for person names
		Pattern p1 = Pattern.compile("alt=\"Image of " + "(.*?)" + "\" class=\"zero-z-index\"");

		// add pattern to matcher
		// System.out.println(result);
		Matcher m1 = p1.matcher(result);
		ArrayList<String> names = new ArrayList<String>();
		int counter = 0;
		// find matches
		while (m1.find()) {
			// add matches to resulted string
			names.add(m1.group(1));
			// counter++;
			// System.out.println("res - " + m1.group(1));
		}

		// pattern for after load persons
		// Pattern p2 = Pattern.compile("title=\"Image of " + "(.*?)" + "\"");
		Pattern p2 = Pattern.compile("alt=\"Image of " + "(.*?)" + "\" title");

		// special matcher for second part of persons which loads lately and
		// parsing only pattern which happens twice, so skip every second match
		// by calling find() in a row
		Matcher m2 = p2.matcher(result);
		while (m2.find()) {
			// counter++;
			m2.find();
			names.add(m2.group(1));
			// System.out.println("res - " + m2.group(1));
		}

		for (String name : names) {
			System.out.println(name);
		}

		////////////////////////////////////////////////////////////////

		// System.out.println(cutResult);

		// create pattern for images matcher to cut urls
		Pattern p3 = Pattern.compile("src=\"https://images-na.ssl-images-amazon.com/images" + "(.*?)" + "209_.jpg\"");
		ArrayList<String> imageUrls = new ArrayList<>();
		int counter2 = 0;
		m1 = p3.matcher(result);
		while (m1.find()) {
			imageUrls.add("https://images-na.ssl-images-amazon.com/images" + m1.group(1) + "209_.jpg");
			counter2++;
			System.out.println(
					counter2 + " " + "https://images-na.ssl-images-amazon.com/images" + m1.group(1) + "209_.jpg");
		}
		// System.out.println(result);
	}
}

// You can't parse [X]HTML with regex. Because HTML can't be parsed by regex.
// Regex is not a tool that can be used to correctly parse HTML. As I have
// answered in HTML-and-regex questions here so many times before, the use of
// regex will not allow you to consume HTML. Regular expressions are a tool that
// is insufficiently sophisticated to understand the constructs employed by
// HTML. HTML is not a regular language and hence cannot be parsed by regular
// expressions. Regex queries are not equipped to break down HTML into its
// meaningful parts. so many times but it is not getting to me. Even enhanced
// irregular regular expressions as used by Perl are not up to the task of
// parsing HTML. You will never make me crack. HTML is a language of sufficient
// complexity that it cannot be parsed by regular expressions. Even Jon Skeet
// cannot parse HTML using regular expressions. Every time you attempt to parse
// HTML with regular expressions, the unholy child weeps the blood of virgins,
// and Russian hackers pwn your webapp. Parsing HTML with regex summons tainted
// souls into the realm of the living. HTML and regex go together like love,
// marriage, and ritual infanticide. The <center> cannot hold it is too late.
// The force of regex and HTML together in the same conceptual space will
// destroy your mind like so much watery putty. If you parse HTML with regex you
// are giving in to Them and their blasphemous ways which doom us all to inhuman
// toil for the One whose Name cannot be expressed in the Basic Multilingual
// Plane, he comes.
