/*
 *  Copyright (c) 2019 ZHAW School of Engineering. All rights are reserved.
 */
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Consumer2 implements MessageListener {
	private static final String DESTINATION = "myQueue";
	private Connection connection;
	private Session session;
	private MessageConsumer messageConsumer;

	public Consumer2() throws NamingException, JMSException {
		// Create JNDI-Context
		Context ctx = new InitialContext();

		// Read ConnectionFactory by using the naming service
		ConnectionFactory factory = (ConnectionFactory) ctx
				.lookup("ConnectionFactory");

		// Read target address
		Destination queue = (Destination) ctx.lookup(DESTINATION);

		// Establish connection
		connection = factory.createConnection();

		// Create session 
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		// Create receiver
		messageConsumer = session.createConsumer(queue);

		// Set MessageListener
		messageConsumer.setMessageListener(this);

		// Start receiving Messages
		connection.start();
	}

	// Message are received by callback (push principle)
	public void onMessage(Message message) {
		try {
			if (message instanceof TextMessage) {
				TextMessage textMessage = (TextMessage) message;
				System.out.println(textMessage.getText());
			}
		} catch (JMSException e) {
			System.err.println(e);
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

	public static void main(String[] args) throws Exception {
		Consumer2 consumer = null;
		try {
			long timeout = Long.parseLong(args[0]); // in ms
			consumer = new Consumer2();
			Thread.sleep(timeout);
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			if (consumer != null)
				consumer.close();
		}
	}
}
