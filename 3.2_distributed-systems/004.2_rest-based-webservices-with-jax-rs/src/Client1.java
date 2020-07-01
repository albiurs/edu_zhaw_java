/*
 *  Copyright (c) 2019 ZHAW School of Engineering. All rights are reserved.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Client1 {
	private static final String BASE_URL = "http://localhost:50000/api";

	public static void main(String[] args) throws IOException {
		post(BASE_URL + "/messages", "Message A");
		post(BASE_URL + "/messages", "Message B");
		post(BASE_URL + "/messages", "Message C");
		
		get(BASE_URL + "/messages");
		get(BASE_URL + "/messages/1");
		
		head(BASE_URL + "/messages");
		head(BASE_URL + "/messages/1");
		
		put(BASE_URL + "/messages/1", "Message AA");
		get(BASE_URL + "/messages/1");
		
		delete(BASE_URL + "/messages/2");
		get(BASE_URL + "/messages");
		
		delete(BASE_URL + "/messages");
		get(BASE_URL + "/messages");
		
		options(BASE_URL + "/messages");
		options(BASE_URL + "/messages/1");
	}
	
	private static void options(String uri) throws IOException {
		System.out.println("\n--- OPTIONS " + uri);
		URL url = new URL(uri);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("OPTIONS");
		connection.setRequestProperty("Accept", "*/*");
		output(connection);
	}
	
	private static void head(String uri) throws IOException {
		System.out.println("\n--- HEAD " + uri);
		URL url = new URL(uri);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("HEAD");
		status(connection);
	}
	
	private static void get(String uri) throws IOException {
		System.out.println("\n--- GET " + uri);
		URL url = new URL(uri);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		if (status(connection) == 200)
			output(connection);
	}

	private static void post(String uri, String text) throws IOException {
		System.out.println("\n--- POST " + uri);
		URL url = new URL(uri);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		connection.setDoOutput(true);
		connection.setRequestProperty("Content-Type", "text/plain");
		write(connection, text);
		if (status(connection) == 201) {
			String location = connection.getHeaderField("Location");
			System.out.println("Location: " + location);
		}
	}

	private static void put(String uri, String text) throws IOException {
		System.out.println("\n--- PUT " + uri);
		URL url = new URL(uri);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("PUT");
		connection.setDoOutput(true);
		connection.setRequestProperty("Content-Type", "text/plain");
		write(connection, text);
		status(connection);
	}

	private static void delete(String uri) throws IOException {
		System.out.println("\n--- DELETE " + uri);
		URL url = new URL(uri);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("DELETE");
		status(connection);
	}

	private static int status(HttpURLConnection connection) throws IOException {
		int code = connection.getResponseCode();
		String message = connection.getResponseMessage();
		System.out.println("Status: " + code + " " + message);
		return code;
	}
	
	private static void output(HttpURLConnection connection) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				connection.getInputStream()));
		String line = reader.readLine();
		while (line != null) {
			System.out.println(line);
			line = reader.readLine();
		}
		reader.close();
	}
	
	private static void write(HttpURLConnection connection, String text) throws IOException {
		PrintWriter out = new PrintWriter(connection.getOutputStream());
		out.print(text);
		out.close();
	}
}
