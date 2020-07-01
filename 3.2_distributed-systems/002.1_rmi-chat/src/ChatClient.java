/*
 *  Copyright (c) 2019 ZHAW School of Engineering. All rights are reserved.
 */
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
/**
 * Client program  for chatting with other users. 
 *
 */
public class ChatClient extends JFrame implements ActionListener {
	private final static int width = 500;
	private final static int hight = 400;

	// RMI Interfaces
	private ChatManager cm;
	private Callback c;

	private JLabel label;
	private JTextArea area;
	private JTextField text;
	private JButton button;
	private boolean login = false;
	private String name;
	private static String host;

	static public void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage: java -cp bin ChatClient <ip address>");
      System.exit(1);
    }
    
    try {
      String host = (System.getProperty("java.rmi.server.hostname") == null) ? InetAddress.getLocalHost().getHostAddress()
          : System.getProperty("java.rmi.server.hostname");
      System.out.println("ChatClient started at " + host + " ...");
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
	  
		// Required for initializing RMI
		host = args[0];
		
		// Client
		final ChatClient client = new ChatClient();

		client.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				client.destroy();
				System.exit(0);
			}
		});

		client.init();
		client.setSize(width, hight);
		client.setVisible(true);
	}

	public ChatClient() {
		super("ChatClient");
		
		label = new JLabel(" ");
		JPanel top = new JPanel();
		top.add(label);

		area = new JTextArea();
		area.setFont(new Font("Monospaced", Font.PLAIN, 14));
		area.setLineWrap(true);
		area.setEditable(false);

		text = new JTextField(48);
		text.setFont(new Font("Monospaced", Font.PLAIN, 14));
		text.setEnabled(false);
		text.addActionListener(this);

		button = new JButton("Login");
		button.setEnabled(false);
		button.addActionListener(this);

		JPanel input = new JPanel();
		input.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		input.add(text);
		input.add(button);

		Container c = getContentPane();
		c.add(top, BorderLayout.NORTH);
		c.add(new JScrollPane(area), BorderLayout.CENTER);
		c.add(input, BorderLayout.SOUTH);
	}

	// Establish connection to server.
	public void init() {
		try {
			cm = (ChatManager) Naming.lookup("//" + host + "/chat");
			c = new CallbackImpl(this);

			text.setEnabled(true);
			text.requestFocus();
			button.setEnabled(true);
		} catch (Exception e) {
			log(e.getMessage());
		}
	}

	// Process the required user action. 
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String cmd = e.getActionCommand();

		try {
			if (obj == button) {
				if (cmd.equals("Login")) {
					name = text.getText();
					if (name.length() != 0) {
						login();
					}
				} else {
					destroy();
				}
			}

			if (obj == text) {
				if (login) {
					cm.notifyClients(name, text.getText());
				}
			}
		} catch (Exception ex) {
			log(ex.getMessage());
		} finally {
			text.setText("");
			text.requestFocus();
		}
	}

	// Login at server 
	private void login() throws RemoteException {
		if (!cm.login(name, c)) {
			log(String.format("Nickname %s already in use.", name));
			return;
		};
		login = true;
		label.setText(name);
		button.setText("Logout");
	}

	// Logout at server  
	public void destroy() {
		if (login) {
			try {
				login = false;
				label.setText(" ");
				button.setText("Login");
				if (cm != null)
					cm.logout(name, c);
			} catch (RemoteException e) {
			   log(e.getMessage());
			}
		}
	}

	// Writes s into the chat area 
	public void log(final String s) {
		try {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					area.append(s + "\n");
				}
			});
		} catch (Exception e) {
	    log(e.getMessage());
		}
	}
}
