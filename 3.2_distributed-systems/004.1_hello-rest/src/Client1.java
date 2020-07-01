/*
 *  Copyright (c) 2019 ZHAW School of Engineering. All rights are reserved.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Client1 {
	private static final String BASE_URL = "http://localhost:50000/api";

	public static void main(String[] args) throws IOException {
		String uri = BASE_URL + "/hello";

		get(uri, "text/plain");
		get(uri, "text/html");
		get(uri, "application/xml");
		get(uri, "application/json");
	}

	private static void get(String uri, String mediaType) throws IOException {
		URL url = new URL(uri);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Accept", mediaType);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				connection.getInputStream()));
		String line = reader.readLine();
		while (line != null) {
			System.out.println(line);		
			line = reader.readLine(); 
		}
		reader.close();
	}
}
