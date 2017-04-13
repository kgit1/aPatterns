package xxx.GG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
//import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

//import javax.net.ssl.HttpsURLConnection;
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.TrustManager;

//import javax.net.ssl.HostnameVerifier;
//import javax.net.ssl.HttpsURLConnection;
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.SSLSession;
//import javax.net.ssl.TrustManager;
//import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

public class PostRequest {
	private final static String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {

//		URL url = new URL("http://goodgame.ru/ajax/chatlogin");
//		URLConnection conn = url.openConnection();
//		conn.setDoOutput(true);
//		OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
//
//		writer.write("login=kirtt&password=qwert111");
//		writer.flush();
//		String line;
//		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//		while ((line = reader.readLine()) != null) {
//			System.out.println(line);
//		}
//		writer.close();
//		reader.close();



	// // /* Start of Fix */
	// // TrustManager[] trustAllCerts = new TrustManager[] { new
	// // X509TrustManager() {
	// // public java.security.cert.X509Certificate[] getAcceptedIssuers() {
	// // return null; }
	// // public void checkClientTrusted(X509Certificate[] certs, String
	// // authType) { }
	// // public void checkServerTrusted(X509Certificate[] certs, String
	// // authType) { }
	// //
	// // } };
	// //
	// // SSLContext sc = SSLContext.getInstance("SSL");
	// // sc.init(null, trustAllCerts, new java.security.SecureRandom());
	// // HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	// //
	// // // Create all-trusting host name verifier
	// // HostnameVerifier allHostsValid = new HostnameVerifier() {
	// // public boolean verify(String hostname, SSLSession session) { return
	// // true; }
	// // };
	// // // Install the all-trusting host verifier
	// // HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
	// // /* End of the fix*/
	//
	// // //====Another fix===============
	// // TrustManager[] trustAllCerts = new TrustManager[]{
	// // new X509TrustManager() {
	// // public java.security.cert.X509Certificate[] getAcceptedIssuers() {
	// // return null;
	// // }
	// // public void checkClientTrusted(
	// // java.security.cert.X509Certificate[] certs, String authType) {
	// // }
	// // public void checkServerTrusted(
	// // java.security.cert.X509Certificate[] certs, String authType) {
	// // }
	// // }};
	// //
	// // try {
	// // SSLContext sc = SSLContext.getInstance("SSL");
	// // sc.init(null, trustAllCerts, new java.security.SecureRandom());
	// // HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	// // } catch (Exception e) {
	// // }
	// // //////end
	//
	// String data = "";
	// String request = "https://api2.goodgame.ru/oauth";
	// // URL url = new URL(request);
	//
	// HttpClient client = HttpClientBuilder.create().build();
	// HttpPost post = new HttpPost(request);
	//
	// // List<String> list = new ArrayList<>();
	// // list.add(new BasicNameValuePair)
	//
	// post.setHeader("kirtt", "qwert111");
	// // post.setEntity(new UrlEncodedFormEntity(parameters, charset));
	// HttpResponse response = client.execute(post);
	//
	// BufferedReader reader = new BufferedReader(new
	// InputStreamReader(response.getEntity().getContent()));
	//
	// String line = "";
	// while ((line = reader.readLine()) != null) {
	// System.out.println(line);
	// }
	//
	// // HttpURLConnection connection = (HttpURLConnection)
	// // url.openConnection();
	// // connection.setRequestMethod("POST");
	// // connection.getOutputStream().write(b);
	//
	// // connection.getOutputStream().write(postDataBytes);
	// // {"name":"myname","age":"20"}

	 System.out.println("\nTesting 2 - Send Http POST request");
	 sendPost();}

	 // HTTP POST request
	 private static void sendPost() throws Exception {
	
	 String url = "http://api2.goodgame.ru/oauth";
	
	 HttpClient client = new DefaultHttpClient();
	 HttpPost post = new HttpPost(url);
	
	 // add header
	 post.setHeader("User-Agent", USER_AGENT);
	
	 List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
	 urlParameters.add(new BasicNameValuePair("login", "kirtt"));
	 urlParameters.add(new BasicNameValuePair("password", "qwert111"));
//	 List<String> urlParameters = new ArrayList<>();
//	 urlParameters.add("kirtt");
//	 urlParameters.add("qwert111");
	
	 post.setEntity(new UrlEncodedFormEntity(urlParameters));
	
	 HttpResponse response = client.execute(post);
	 System.out.println("\nSending 'POST' request to URL : " + url);
	 System.out.println("Post parameters : " + post.getEntity());
	 System.out.println("Response Code : " +
	 response.getStatusLine().getStatusCode());
	
	 BufferedReader rd = new BufferedReader(new
	 InputStreamReader(response.getEntity().getContent()));
	
	 StringBuffer result = new StringBuffer();
	 String line = "";
	 while ((line = rd.readLine()) != null) {
	 result.append(line);
	 }
	 
	 System.out.println("result");
	
	 System.out.println(result.toString());
	
	 }

}
