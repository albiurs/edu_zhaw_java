/*
 *  Copyright (c) 2018 ZHAW School of Engineering. All rights are reserved.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Implements a client for the echo server.
 *
 */
public class EchoClient {
  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("Usage: java -cp bin EchoClient <ip address> <port>");
      System.exit(1);

    }

    String host = args[0];
    int port = Integer.parseInt(args[1]);

    try (Socket socket = new Socket(host, port);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {

      String msg = in.readLine();
      System.out.println(msg);

      String line;
      while (true) {
        line = input.readLine();
        if (line == null || line.equals("q"))
          break;
        out.println(line);
        System.out.println(in.readLine());
      }
    } catch (Exception e) {
      System.err.println(e);
    }
  }
}
