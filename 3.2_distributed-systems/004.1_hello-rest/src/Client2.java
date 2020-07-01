/*
 *  Copyright (c) 2019 ZHAW School of Engineering. All rights are reserved.
 */
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class Client2 {
  private static final String BASE_URL = "http://localhost:50000/api";
	private static Client client;

	public static void main(String[] args) {
		client = ClientBuilder.newClient();
		String uri = BASE_URL + "/hello";

		get(uri, MediaType.TEXT_PLAIN);
		get(uri, MediaType.TEXT_HTML);
		get(uri, MediaType.APPLICATION_XML);
		get(uri, MediaType.APPLICATION_JSON);
	}

	private static void get(String uri, String mediaType) {
		WebTarget target = client.target(uri);
		Response result = target.request().accept(mediaType).get();
		System.out.println(result.readEntity(String.class));
	}
}

		