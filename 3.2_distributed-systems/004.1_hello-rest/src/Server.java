/*
 *  Copyright (c) 2018 ZHAW School of Engineering. All rights are reserved.
 */
import java.net.URI;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import demo.hello.MyApplication;

public class Server {
	public static void main(String[] args) throws Exception {
		final String BASE_URL = "http://localhost:50000/api";

		URI endpoint = new URI(BASE_URL);
		ResourceConfig rc = ResourceConfig
				.forApplicationClass(MyApplication.class);
		JdkHttpServerFactory.createHttpServer(endpoint, rc);
		System.out.println("Server started at: " + BASE_URL);
    System.out.println("Press Ctrl + C to stop the server.");
	}
}
