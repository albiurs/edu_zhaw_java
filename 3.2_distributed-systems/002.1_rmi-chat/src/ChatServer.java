
/*
 *  Copyright (c) 2019 ZHAW School of Engineering. All rights are reserved.
 */
import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.Remote;

/**
 * Main program for starting the chat server.
 *
 */
public class ChatServer {
  public static void main(String args[]) throws Exception {
    Remote remote = new ChatManagerImpl();
    Naming.rebind("chat", remote);
    String host = (System.getProperty("java.rmi.server.hostname") == null) ? InetAddress.getLocalHost().getHostAddress()
        : System.getProperty("java.rmi.server.hostname");
    System.out.println("ChatServer started at " + host + " ...");
    System.out.println("Shutdown by pressing Ctrl + C");
  }
}