/*
 *  Copyright (c) 2019 ZHAW School of Engineering. All rights are reserved.
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;

public class StreamThread extends Thread {
	private static final int BUFFER_SIZE = 8192;

	private InputStream from;
	private OutputStream to;
	private OutputStream log;

	public StreamThread(InputStream from, OutputStream to, OutputStream log) {
		this.from = from;
		this.to = to;
		this.log = log;
	}

	@Override
	public void run() {
		try {
			byte[] buffer = new byte[BUFFER_SIZE];
			int bytesRead;
			while ((bytesRead = from.read(buffer)) != -1) {
				to.write(buffer, 0, bytesRead);
				to.flush();
				log.write(buffer, 0, bytesRead);
				log.flush();
			}
		} catch (SocketException e) {
		} catch (IOException e) {
			System.err.println("StreamThread::run " + e);
		} finally {
			try {
				from.close();
				to.close();
			} catch (IOException e) {
			}
		}
	}
}
