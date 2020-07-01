
/*
 *  Copyright (c) 2018 ZHAW School of Engineering. All rights are reserved.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import ch.zhaw.soe.eicw.tcpframework.AbstractHandler;

/**
 * Implements the handler for processing a request from a echo client.
 */
public class EchoHandler extends AbstractHandler {
  public void runTask(Socket socket) {
    try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

      out.println("Server is ready ...");

      String input;
      while ((input = in.readLine()) != null) {
        out.println(input);
      }
    } catch (IOException e) {
      System.err.println(e);
    }
  }
}
