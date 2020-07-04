/*
 *  Copyright (c) 2019 ZHAW School of Engineering. All rights are reserved.
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class QueueInfo {
	private static final String DESTINATION = "myQueue";
	private Connection connection;
	private Session session;
	private QueueBrowser browser;

	public QueueInfo() throws NamingException, JMSException {
		Context ctx = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) ctx
				.lookup("ConnectionFactory");
		Destination queue = (Destination) ctx.lookup(DESTINATION);
		connection = factory.createConnection();
		connection.start();
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		// Create QueueBrowser
		browser = session.createBrowser((Queue) queue);
	}

	public void list() throws JMSException {
		@SuppressWarnings("rawtypes")
		Enumeration e = browser.getEnumeration();
		SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		int cnt = 0;

		while (e.hasMoreElements()) {
			cnt++;

			Message message = (Message) e.nextElement();

			System.out.print(cnt + ".");
			System.out.println("\tDestination: " + message.getJMSDestination());
			System.out.println("\tMessageID: " + message.getJMSMessageID());
			System.out.println("\tTimestamp: "
					+ f.format(new Date(message.getJMSTimestamp())));
			System.out.println("\tPriority: " + message.getJMSPriority());

			long expiration = message.getJMSExpiration();

			if (expiration == 0) {
				System.out.println("\tExpiration: 0");
			} else {
				System.out.println("\tExpiration: "
						+ f.format(new Date(expiration)));
			}

			System.out.println("\tProperties:");

			@SuppressWarnings("rawtypes")
			Enumeration names = message.getPropertyNames();

			while (names.hasMoreElements()) {
				String name = (String) names.nextElement();
				System.out.println("\t\t" + name + " = "
						+ message.getStringProperty(name));
			}

			System.out.println();
		}
	}

	public void close() {
		try {
			if (browser != null)
				browser.close();
			if (session != null)
				session.close();
			if (connection != null)
				connection.close();
		} catch (JMSException e) {
			System.err.println(e);
		}
	}

	public static void main(String[] args) throws Exception {
		QueueInfo info = null;
		try {
			info = new QueueInfo();
			info.list();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			if (info != null)
				info.close();
		}
	}
}
