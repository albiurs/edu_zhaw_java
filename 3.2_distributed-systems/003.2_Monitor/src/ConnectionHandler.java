/*
 *  Copyright (c) 2019 ZHAW School of Engineering. All rights are reserved.
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ConnectionHandler extends Thread {
	private static final int SOCKET_TIMEOUT = 30000;
	
	private Socket client;
	private String host;
	private int serverPort;
	private OutputStream logRequest;
	private OutputStream logResponse;

	public ConnectionHandler(Socket client, String host, int serverPort,
			OutputStream logRequest, OutputStream logResponse) {
		
		this.client = client;
		this.host = host;
		this.serverPort = serverPort;
		this.logRequest = logRequest;
		this.logResponse = logResponse;
	}

	@Override
	public void run() {
		try (InputStream fromClient = client.getInputStream();
				OutputStream toClient = client.getOutputStream();
				Socket server = new Socket(host, serverPort);
				InputStream fromServer = server.getInputStream();
				OutputStream toServer = server.getOutputStream()) {
			
			client.setSoTimeout(SOCKET_TIMEOUT);
			server.setSoTimeout(SOCKET_TIMEOUT);

			Thread forward = new StreamThread(fromClient, toServer, logRequest);
			Thread reverse = new StreamThread(fromServer, toClient, logResponse);

			forward.start(); 
			reverse.run();

			forward.join();
		} catch (InterruptedException e) {
		} catch (IOException e) {
			System.err.println("ConnectionHandler::run: " + e);
		}
	}
}
