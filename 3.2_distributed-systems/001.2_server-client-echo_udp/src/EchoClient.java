
/*
 *  Copyright (c) 2019 ZHAW School of Engineering. All rights are reserved.
 */
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;

public class EchoClient {
	private static final int BUFSIZE = 508;
	private static final int TIMEOUT = 5000;

	/**
	 * Called at program start.
	 * 
	 * @param args calling parameters
	 */
	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("Usage: java -cp bin EchoClient <ip address> <port> <message>");
			System.exit(1);

		}

		String host = args[0];
		int port = Integer.parseInt(args[1]);
		byte[] data = args[2].getBytes();
		System.out.println(args[2]);

		try (DatagramSocket socket = new DatagramSocket()) {
			// Maximal TIMEOUT in ms for waiting of target host
			socket.setSoTimeout(TIMEOUT);

			// Send packet
			InetAddress addr = InetAddress.getByName(host);
			DatagramPacket packetOut = new DatagramPacket(data, data.length, addr, port);
			socket.send(packetOut);

			// Receive packet
			DatagramPacket packetIn = new DatagramPacket(new byte[BUFSIZE], BUFSIZE);
			socket.receive(packetIn);
			String received = new String(packetIn.getData(), 0, packetIn.getLength());
			System.out.println("Received: " + received + " from " + packetIn.getSocketAddress());

			// Catch exceptions if something goes wrong
		} catch (SocketTimeoutException e) {
			System.err.println("Timeout: " + e.getMessage());
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
