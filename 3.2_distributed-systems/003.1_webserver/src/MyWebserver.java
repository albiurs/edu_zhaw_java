/*
 *  Copyright (c) 2019 ZHAW School of Engineering. All rights are reserved.
 */
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

import ch.zhaw.soe.eicw.webserver.SimpleWebserver;

/**
 * Runs a simple Web server. 
 *
 */
public class MyWebserver {
	private static final String ROOT = "web";
	private static final int PORT = 50000;
	private static final boolean LOG = true;

	public static void main(String[] args) {
		try {
			SimpleWebserver server = new SimpleWebserver(new File(ROOT), PORT,
					LOG);
			server.start();
			System.out.println("MyWebserver started at " + InetAddress.getLocalHost().getHostAddress() 
			    + ":" + PORT + " ...");
			System.out
					.println("Enter RETURN or Ctrl + C to stop the server.");
			System.in.read();
			System.exit(0);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
