/*
 *  Copyright (c) 2019 ZHAW School of Engineering. All rights are reserved.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Echo server based on TCP sockets.
 *
 */
public class EchoServer {
	private int port;
	private int backlog;
	
  /**
   * Called at program start.
   * 
   * @param args calling parameters.
   */
  public static void main(String[] args) {
    if (args.length == 0 || args.length > 2) {
      System.out.println("Usage: java -cp bin EchoServer <port> [<backlog>]");
      System.exit(1);
    }

    int port = Integer.parseInt(args[0]);
    int backlog = 5;

    if (args.length == 2)
      backlog = Integer.parseInt(args[1]);

    new EchoServer(port, backlog).startServer();
  }

	public EchoServer(int port, int backlog) {
		this.port = port;
		this.backlog = backlog;
	}

	public void startServer() {
		try (ServerSocket serverSocket = new ServerSocket(port, backlog)) {

			System.out.println("EchoServer started at "
					+ serverSocket.getLocalSocketAddress() + " ...");

			process(serverSocket);
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	private void process(ServerSocket server) throws IOException {
	    // Loops for processing client requests
	    while (true) {
			SocketAddress socketAddress = null;

			try (Socket socket = server.accept();
					BufferedReader in = new BufferedReader(
							new InputStreamReader(socket.getInputStream()));
					PrintWriter out = new PrintWriter(socket.getOutputStream(),
							true)) {

				socketAddress = socket.getRemoteSocketAddress();
				System.out.println("Connection to " + socketAddress + " opened");

				out.println("Server is ready ...");

				String input;
				while ((input = in.readLine()) != null) {
		      System.out.println("Received: " + input.length() + " bytes");
					out.println(input);
				}
			} catch (IOException e) {
				System.err.println(e);
			} finally {
				System.out.println("Connecetion to " + socketAddress
						+ " closed");
			}
		}
	}
}
