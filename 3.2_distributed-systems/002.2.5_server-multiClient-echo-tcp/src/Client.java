/*
 *  Copyright (c) 2018 ZHAW School of Engineering. All rights are reserved.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Client that generates server requests.
 *
 */
public class Client {
	public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("Usage: java -cp bin Client <ip address> <port>");
      System.exit(1);
    }
    
		String host = args[0];
		int port = Integer.parseInt(args[1]);
		int id = 1;

		for (int i = 0; i < 20; i++) {
			new Handler(host, port, id++).start();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
			}
		}
	}

	// Called for generating a server request
	private static class Handler extends Thread {
		private String host;
		private int port;
		private int id;

		public Handler(String host, int port, int id) {
			this.host = host;
			this.port = port;
			this.id = id;
		}

		public void run() {
			try (Socket socket = new Socket(host, port);
					BufferedReader in = new BufferedReader(
							new InputStreamReader(socket.getInputStream()));
					PrintWriter out = new PrintWriter(socket.getOutputStream(),
							true)) {

				out.println(id);

				String response = in.readLine();
				System.out.println(response);
			} catch (Exception e) {
				System.err.println(e);
			}
		}
	}
}
