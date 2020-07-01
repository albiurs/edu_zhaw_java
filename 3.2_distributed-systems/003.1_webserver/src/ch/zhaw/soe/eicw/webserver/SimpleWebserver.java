/*
 *  Copyright (c) 2019 ZHAW School of Engineering. All rights are reserved.
 */
package ch.zhaw.soe.eicw.webserver;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * A simple Web server.
 */
public class SimpleWebserver extends Thread {
	private static final String LOG_FILE = "http.log";
	private static final int SOCKET_TIMEOUT = 30000;
	private File root;
	private boolean log;
	private ServerSocket serverSocket;

	/**
	 * Creates a simple Web server.
	 * 
	 * @param root directory for web content
	 * @param port listing port
	 * @param log if true logs calls
	 * @throws IOException if root is not as directory
	 */
	public SimpleWebserver(File root, int port, boolean log) throws IOException {
		this.root = root.getCanonicalFile();
		this.log = log;

		if (!root.isDirectory()) {
			throw new IOException("No directory");
		}

		if (log)
			HttpLog.initializeLogger(new File(LOG_FILE));

		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				shutdown();
			}
		});

		serverSocket = new ServerSocket(port);
	}

  /**
   * Accepts client connections and forwards the request to a handler.
   */
  @Override
  public void run() {
    while (true) {
      try {
        Socket socket;
        try {
          socket = serverSocket.accept();
        } catch (SocketException e) {
          break;
        }

        socket.setSoTimeout(SOCKET_TIMEOUT);

        Request request = new Request(socket, root, log);
        request.start();
      } catch (IOException e) {
        System.err.println(e);
      }
    }
  }

  /**
   * Shutdowns the server properly even if ctrl + C was pressed. 
   */	
	public void shutdown() {
		try {
			if (serverSocket != null) {
				serverSocket.close();
			}
			
			if (HttpLog.logger != null) {
				HttpLog.logger.close();
			}
		} catch (IOException e) {
		}
	}
}
