/*
 *  Copyright (c) 2018 ZHAW. All rights are reserved.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Multithreaded server using a thread pool. 
 *
 */
public class Server {
	private int port;
	private ExecutorService pool;
	
	 // Main thats starts the server
  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage: java -cp bin Server <port>");
      System.exit(1); 
    }
    
    int port = Integer.parseInt(args[0]);
    new Server(port).startServer();
  }

	public Server(int port) {
		this.port = port;
	}

	// Starts the server and handles client requests
	public void startServer() {
		try (ServerSocket server = new ServerSocket(port)) {

			System.out.println("Server started ...");

			pool = Executors.newCachedThreadPool();

			while (true) {
				Socket socket = server.accept();
				pool.execute(new Task(socket));
			}
		} catch (IOException e) {
			System.err.println(e);
			pool.shutdown();
		}
	}

	// Called task for a client request
	private class Task implements Runnable {
		private Socket socket;

		public Task(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			try (BufferedReader in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
					PrintWriter out = new PrintWriter(socket.getOutputStream(),
							true)) {

				String input = in.readLine();

				if (input != null) {
					int delay = 3000 + (int) (Math.random() * 7000);

					long begin = System.currentTimeMillis();
					System.out.printf("Start task %3s: %tT, Thread; %s%n", input,
							new Date(begin), Thread.currentThread().getName());
					Thread.sleep(delay);
					long end = System.currentTimeMillis();
					System.out.printf("Finished task %3s: %tT, Thread; %s%n", input,
							new Date(end), Thread.currentThread().getName());

					out.printf("task %3s, start: %tT, finished: %tT%n", input,
							new Date(begin), new Date(end));
				}
			} catch (Exception e) {
				System.err.println(e);
			}
		}
	}
}
