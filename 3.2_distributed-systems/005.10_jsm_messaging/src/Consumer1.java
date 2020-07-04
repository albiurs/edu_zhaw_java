/*
 *  Copyright (c) 2019 ZHAW School of Engineering. All rights are reserved.
 */
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Consumer1 {
	private static final String DESTINATION = "myQueue";
	private Connection connection;
	private Session session;
	private MessageConsumer messageConsumer;
	private long timeout; // in ms

	public Consumer1(long timeout) throws NamingException, JMSException {
		this.timeout = timeout;

		// Create JNDI-Context
		Context ctx = new InitialContext();

		// Read ConnectionFactory by using the naming service
		ConnectionFactory factory = (ConnectionFactory) ctx
				.lookup("ConnectionFactory");

		// Read target address by using the naming service
		Destination queue = (Destination) ctx.lookup(DESTINATION);

		// Establish connection
		connection = factory.createConnection();

		// Create Session
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		// Create receiver
		messageConsumer = session.createConsumer(queue);

		// Start receiving messages
		connection.start();
	}

	// Busy waiting of messages (pull principle)
	public void receiveMessage() throws JMSException {
		Message message;

		while ((message = messageConsumer.receive(timeout)) != null) {
			if (message instanceof TextMessage) {
				TextMessage textMessage = (TextMessage) message;
				System.out.println(textMessage.getText());
			}
		}
	}

	// Release resources
	public void close() {
		try {
			if (messageConsumer != null)
				messageConsumer.close();
			if (session != null)
				session.close();
			if (connection != null)
				connection.close();
		} catch (JMSException e) {
			System.err.println(e);
		}
	}

	public static void main(String[] args) {
		Consumer1 consumer = null;
		try {
			long timeout = Long.parseLong(args[0]);
			consumer = new Consumer1(timeout);
			consumer.receiveMessage();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			if (consumer != null)
				consumer.close();
		}
	}
}
