/*
 *  Copyright (c) 2019 ZHAW School of Engineering. All rights are reserved.
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * A simple monitor that works as a proxy between client and web server in order 
 * to protocol requests and responses. 
 */
public class Monitor extends Thread {
	private static OutputStream logRequest;
	private static OutputStream logResponse;
	private static ServerSocket srv;

	public static void main(String[] args) {
    if (args.length != 5) {
      System.out
          .println("Usage: java -cp bin Monitor <localPort> <remoteHost> <remotePort> <logRequest> <logResponse>");
      System.exit(1);
    }

    int localPort = Integer.parseInt(args[0]);
    final String host = args[1];
    final int serverPort = Integer.parseInt(args[2]);
    String request = args[3];
    String response = args[4];

    Runtime.getRuntime().addShutdownHook(new Thread() {
      public void run() {
        try {
          if (logRequest != null) {
            logRequest.close();
          }
          if (logResponse != null) {
            logResponse.close();
          }
          if (srv != null)
            srv.close();
        } catch (IOException e) {
        }
      }
    });

    try {
      logRequest = new FileOutputStream(request);
      logResponse = new FileOutputStream(response);
      srv = new ServerSocket(localPort);
      System.out.println("Monitor started at " + srv.getInetAddress().getHostAddress() 
          + ":" + localPort + " forwarding to " + host + ":" + serverPort + " ...");
      System.out
          .println("Enter Ctrl + C to stop the monitor.");
 
      while (true) {
        Socket client = srv.accept();
        new ConnectionHandler(client, host, serverPort, logRequest, logResponse).start();

      }
    } catch (SocketException e) {
    } catch (IOException e) {
      System.err.println("Monitor::main: " + e);
    }
  }
}
