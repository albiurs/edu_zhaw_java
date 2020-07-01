/*
 *  Copyright (c) 2019 ZHAW School of Engineering. All rights are reserved.
 */
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class Client2 {
	private static final String BASE_URL = "http://localhost:50000/api";
	private static Client client;

	public static void main(String[] args) {
		client = ClientBuilder.newClient();

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

	private static void options(String uri) {
		System.out.println("\n--- OPTIONS " + uri);
		WebTarget target = client.target(uri);
		Response response = target.request().accept(MediaType.WILDCARD_TYPE)
				.options();
		System.out.println(response.readEntity(String.class));
	}

	private static void head(String uri) {
		System.out.println("\n--- HEAD " + uri);
		WebTarget target = client.target(uri);
		Response response = target.request().head();
		status(response);
	}

	private static void get(String uri) {
		System.out.println("\n--- GET " + uri);
		WebTarget target = client.target(uri);
		Response response = target.request().get();
		if (status(response) == 200)
			System.out.println(response.readEntity(String.class));
	}

	private static void post(String uri, String text) {
		System.out.println("\n--- POST " + uri);
		WebTarget target = client.target(uri);
		Entity<String> entity = Entity.entity(text, MediaType.TEXT_PLAIN);
		Response response = target.request().post(entity);
		if (status(response) == 201) {
			String location = response.getLocation().toString();
			System.out.println("Location: " + location);
		}
	}

	private static void put(String uri, String text) {
		System.out.println("\n--- PUT " + uri);
		WebTarget target = client.target(uri);
		Entity<String> entity = Entity.entity(text, MediaType.TEXT_PLAIN);
		Response response = target.request().put(entity);
		status(response);
	}

	private static void delete(String uri) {
		System.out.println("\n--- DELETE " + uri);
		WebTarget target = client.target(uri);
		Response response = target.request().delete();
		status(response);
	}

	private static int status(Response response) {
		int code = response.getStatus();
		String message = response.getStatusInfo().toString();
		System.out.println("Status: " + code + " " + message);
		return code;
	}
}
