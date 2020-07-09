
/*
 *  Copyright (c) 2019 ZHAW School of Engineering. All rights are reserved.
 */
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

import ch.zhaw.soe.eicw.webserver.SimpleWebserver;

/**
 * Simple secure Web server using the Java SE server @see
 * com.sun.net.httpserver. HTTP Basic Authentication and SSL/TLS are used for
 * authentication and secure communication.
 *
 */
public class MyWebserver {
	private static final String ROOT = "web";
	private static final int PORT = 50443;
	private static final boolean LOG = true;

	public static void main(String[] args) {
		try {
			SimpleWebserver server = new SimpleWebserver(new File(ROOT), PORT, LOG);
			server.start();
			System.out.println(
					"MyWebserver started at " + InetAddress.getLocalHost().getHostAddress() + ":" + PORT + " ...");
			System.out.println("Enter RETURN or Ctrl + C to stop the server.");
			System.in.read();
			System.exit(0);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
