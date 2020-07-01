
/*
 *  Copyright (c) 2018 ZHAW School of Engineering. All rights are reserved.
 */
import ch.zhaw.soe.eicw.tcpframework.TCPServer;

/**
 * Implementation of a parallel echo server by using a thread pool. Shows also
 * how to implement a simple framework for TCP servers.
 */
public class EchoServer {
  public static void main(String[] args) throws Exception {
    if (args.length != 1) {
      System.out.println("Usage: java -cp bin EchoServer <port>");
      System.exit(1);
    }

    int port = Integer.parseInt(args[0]);

    TCPServer server = new TCPServer(port, EchoHandler.class);

    server.start();
    System.out.println("EchoServer is started ...");
    System.out.println("RETURN stops the server.");

    System.in.read();

    server.stopServer();
    System.out.println("EchoServer has been stopped.");
  }
}
