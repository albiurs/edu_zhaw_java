/*
 *  Copyright (c) 2017 ZHAW School of Engineering. All rights are reserved.
 */
package ch.zhaw.soe.eicw.tcpframework;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * A simple framework for implementing a TCP server using thread pooling. 
 * For using a thread pool @see java.util.concurrent.Executors 
 *
 */
public class TCPServer extends Thread {
	private AbstractHandler handler;
	private ServerSocket serverSocket;
	private ExecutorService pool;

	/**
	 * Implements a parallel TCP server.
	 * 
	 * @param port port to use
	 * @param handlerClass class implementing the @see AbstractHandler
	 * @throws Exception any exception
	 */
	public TCPServer(int port, Class<?> handlerClass) throws Exception {
		handler = (AbstractHandler) handlerClass.newInstance();
		serverSocket = new ServerSocket(port);
		pool = Executors.newCachedThreadPool();
	}
	
  /**
   * Implements a parallel TCP server.
   * 
   * @param port
   *          port to use
   * @param handlerClass
   *          object implementing the @see AbstractHandler
   * @throws Exception
   *           any exception
   */
	public TCPServer(int port, Object handlerObject) throws IOException {
		handler = (AbstractHandler) handlerObject;
		serverSocket = new ServerSocket(port);
		pool = Executors.newCachedThreadPool();
	}

  /**
   * Accepts incoming client connections forward them to a handler. 
   */
	public void run() {
		try {
			while (true) {
				Socket socket = serverSocket.accept();
				handler.handle(socket, pool);
			}
		} catch (SocketException e) {
			// When calling stopServer() a SocketException can be thrown.
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	/**
	 * Stops the server and cleans up the used resources.
	 */
	public void stopServer() {
		try {
			serverSocket.close();
		} catch (IOException e) {
		}

		pool.shutdown();
	}
}
