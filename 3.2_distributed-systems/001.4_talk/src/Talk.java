/*
 *  Copyright (c) 2019 ZHAW School of Engineering. All rights are reserved.
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Implements a simple point to point chat between two users with UDP sockets. 
 * 
 */
public class Talk implements ActionListener, Runnable {
	private static final int BUFSIZE = 508;

	private String user;
	private int localPort = 50000;
	private String remoteHost;
	private int remotePort = 50000;

	private DatagramSocket socket;
	private DatagramPacket packetOut;
	private JTextField input;
	private JTextArea output;

  /**
   * Called at program start.
   * 
   * @param args calling parameters
   */
  public static void main(String[] args) {
    JFrame frame = new JFrame();

    try {
      new Talk(args, frame);
    } catch (Exception e) {
      System.err.println(e.getMessage());
      System.exit(1);
    }

    frame.pack();
    frame.setVisible(true);
  }

	/**
	 * Handles the talk. 
	 * 
	 * @param args calling parameters
	 * @param frame chat window
	 * @throws Exception if something goes wrong
	 */
	// Handles the talk
	public Talk(String[] args, JFrame frame) throws Exception {
		setParameter(args);
		if (user == null || remoteHost == null || localPort == 0 || remotePort == 0)
		{
			System.out.println("Usage: java -cp bin Talk -user <name> [-localPort <port>] -remoteHost <ip address> [-remotePort <port>]");
			System.exit(1);
			
		}
	
		InetAddress remoteAddr = InetAddress.getByName(remoteHost);

		frame.setTitle("Talk - " + user);

		socket = new DatagramSocket(localPort);
		packetOut = new DatagramPacket(new byte[BUFSIZE], BUFSIZE, remoteAddr,
				remotePort);

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if (socket != null)
					socket.close();
				System.exit(0);
			}
		});

		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
		input = new JTextField(40);
		input.addActionListener(this);
		input.setFont(new Font("Monospaced", Font.PLAIN, 16));
		panel.add(input);
		JButton send = new JButton("Send");
		send.addActionListener(this);
		panel.add(send);
		frame.add(panel, BorderLayout.NORTH);

		output = new JTextArea(10, 45);
		output.setFont(new Font("Monospaced", Font.PLAIN, 16));
		output.setLineWrap(true);
		output.setWrapStyleWord(true);
		output.setEditable(false);
		frame.add(new JScrollPane(output), BorderLayout.CENTER);

		// Thread for receiving and sending messages
		Thread t = new Thread(this);
		t.start();
	}

	
	/**
	 * Loops for receiving messages.
	 */
	public void run() {
		DatagramPacket packetIn = new DatagramPacket(new byte[BUFSIZE], BUFSIZE);

		while (true) {
			try {
				receive(packetIn);
			} catch (IOException e) {
				break;
			}
		}
	}

  /**
   * Processes a received message.
   * 
   * @param packetIn receiving datagram
   * @throws IOException if something goes wrong
   */
  private void receive(DatagramPacket packetIn) throws IOException {
    socket.receive(packetIn);
    final String text = new String(packetIn.getData(), 0, packetIn.getLength());

    try {
      EventQueue.invokeLater(new Runnable() {
        public void run() {
          output.append(text);
          output.append("\n");
        }
      });
    } catch (Exception e) {
    }
  }

	/**
	 * Sends the entered message when send or return is pressed.   
	 */
	public void actionPerformed(ActionEvent e) {
		try {			
			if (input.getText().length() == 0)
				return;			
			String message = user + ": " + input.getText();
			byte[] data = message.getBytes();
			packetOut.setData(data);
			packetOut.setLength(data.length);
			socket.send(packetOut);
			input.setText("");
			input.requestFocus();
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}

	// Processes the parameters when called
	private void setParameter(String[] args) {
		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-user"))
				user = args[i + 1];
			else if (args[i].equals("-localPort"))
				localPort = Integer.parseInt(args[i + 1]);
			else if (args[i].equals("-remoteHost"))
				remoteHost = args[i + 1];
			else if (args[i].equals("-remotePort"))
				remotePort = Integer.parseInt(args[i + 1]);
		}
	}
}
