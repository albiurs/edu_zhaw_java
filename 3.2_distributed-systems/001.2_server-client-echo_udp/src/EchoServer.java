
/*
 *  Copyright (c) 2019 ZHAW School of Engineering. All rights are reserved.
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Stream;

public class EchoServer {
	private static final int BUFSIZE = 508;
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

	/**
	 * Called at program start.
	 * 
	 * @param args calling parameters
	 */
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage: java -cp bin EchoServer <port>");
			System.exit(1);
		}

		int port = Integer.parseInt(args[0]);

		try (DatagramSocket socket = new DatagramSocket(port)) {
			// Packets for receiving and sending data
			DatagramPacket packetIn = new DatagramPacket(new byte[BUFSIZE], BUFSIZE);
			DatagramPacket packetOut = new DatagramPacket(new byte[BUFSIZE], BUFSIZE);

			// Print starting info on console
			System.out.println(LocalDateTime.now().format(formatter) + " - Server started at "
					+ socket.getLocalSocketAddress() + " ...");
			System.out.println("Shutdown server by pressing ctrl + C");

			while (true) {
				// Receive packet
				Arrays.fill(packetIn.getData(),(byte)0); 
				socket.receive(packetIn);
				// Print timestamp and datagram on console
				System.out.println(LocalDateTime.now().format(formatter) + " - Received and resend: "
						+ packetIn.getLength() + " bytes from " + packetIn.getSocketAddress());
				System.out.println("Hex dump of datagram");
				System.out.println(HexDumpUtil.formatHexDump(packetIn.getData(), 0, packetIn.getLength()));
				// Store data and length of receiving package
				packetOut.setData(packetIn.getData());
				packetOut.setLength(packetIn.getLength());
				// Set address and port of target host
				packetOut.setSocketAddress(packetIn.getSocketAddress());
				// Send answer package
				socket.send(packetOut);
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}
