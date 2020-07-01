package u1.tippdestages;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1. Start Server
 * 2. Connect with Telnet: "telnet localhost 4242"
 */
public class TippDesTagesServer {

	String[] tips = {"Nehmen Sie kleinere Bissen zu sich.", "Holen Sie isch die engen Jeans. Nain Sie sehen darin NICHT zu dick aus!"};

	public void los() {
		try	(ServerSocket serverSocket = new ServerSocket(4242)) {
			while (true) {
				Socket sock = serverSocket.accept();
				PrintWriter writer = new PrintWriter(sock.getOutputStream());
				String tipp = getTipp();
				writer.println(tipp);
				writer.close();
				System.out.println(tipp);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	} // los() schliessen

	private String getTipp() {
		int	randon = (int) (Math.random() * tips.length);
		return tips[randon];
	}

	public static void main(String[] args) {
		TippDesTagesServer server = new	TippDesTagesServer();
		server.los();
	}
}
