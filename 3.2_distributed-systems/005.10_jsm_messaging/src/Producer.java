/*
 *  Copyright (c) 2019 ZHAW School of Engineering. All rights are reserved.
 */
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Producer {
	private static final String DESTINATION = "myQueue";
	private Connection connection;
	private Session session;
	private MessageProducer messageProducer;
	private String text;
	private long expiration;

	public Producer(String text, long expiration) throws NamingException,
			JMSException {
		this.text = text;
		this.expiration = expiration;

		// Create JNDI-Context
		Context ctx = new InitialContext();

		// Read ConnectionFactory by using the naming service
		ConnectionFactory factory = (ConnectionFactory) ctx
				.lookup("ConnectionFactory");

		// Read target queue by using the naming service
		Destination queue = (Destination) ctx.lookup(DESTINATION);

		// Establish connection
		connection = factory.createConnection();

		// Create session
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		// create sender
		messageProducer = session.createProducer(queue);
	}

	// Create message and send
	public void sendMessage() throws JMSException {
		TextMessage message = session.createTextMessage();
		message.setText(text);
		message.setStringProperty("Status", "test message");
		messageProducer.setTimeToLive(expiration);
		messageProducer.send(message);
  }

	// Release message
	public void close() {
		try {
			if (messageProducer != null)
				messageProducer.close();
			if (session != null)
				session.close();
			if (connection != null)
				connection.close();
		} catch (JMSException e) {
			System.err.println(e);
		}
	}

	public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Usage: java -cp \"bin;lib/*\" Producer <message>  [<time to live> in ms]");
      System.exit(1);
    }
	  
	  Producer producer = null;
		try {
			String text = args[0];
			long expiration = (args.length == 2) ? Long.parseLong(args[1]) : 0;
			producer = new Producer(text, expiration);
			producer.sendMessage();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			if (producer != null)
				producer.close();
		}
	}
}
