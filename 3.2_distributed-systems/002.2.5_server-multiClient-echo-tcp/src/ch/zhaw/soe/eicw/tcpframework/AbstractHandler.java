/*
 *  Copyright (c) 2017 ZHAW School of Engineering. All rights are reserved.
 */
package ch.zhaw.soe.eicw.tcpframework;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.concurrent.ExecutorService;

/**
 * Handles a request. An implementation has to implement the method runTask().
 *
 */
public abstract class AbstractHandler {
  /**
   * Processes a request.
   * 
   * @param socket
   *          client socket
   * @param pool
   *          thread pool
   */
  public void handle(final Socket socket, ExecutorService pool) {
    pool.execute(new Runnable() {
      @Override
      public void run() {
        SocketAddress socketAddress = socket.getRemoteSocketAddress();
        System.out.println("Connection to " + socketAddress + " opened.");

        runTask(socket);

        try {
          if (socket != null)
            socket.close();
        } catch (IOException e) {
        }

        System.out.println("Connection to " + socketAddress + " opened.");
      }
    });
  }

  /**
   * Implement this method to do your own request processing.
   */
  public abstract void runTask(Socket socket);
}
