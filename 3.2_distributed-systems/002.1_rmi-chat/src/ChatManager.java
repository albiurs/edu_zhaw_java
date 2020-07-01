/*
 *  Copyright (c) 2019 ZHAW School of Engineering. All rights are reserved.
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface for the client for calling the chat server. 
 *
 */
public interface ChatManager extends Remote {
	/**
	 * Allows a user to join the chat.
	 * @param name nickname of the user
	 * @param c reference to the client
	 * @throws RemoteException
	 */
	boolean login(String name, Callback c) throws RemoteException;
	/**
	 * Allows a user to leave the chat.
	 * @param name nickname of the user
	 * @param c reference to the client
	 * @throws RemoteException
	 */	
	void logout(String name, Callback c) throws RemoteException;
	/**
	 * Allows a user to contribute a message to the chat
	 * @param name nickname of the user
	 * @param text message
	 * @throws RemoteException
	 */
	void notifyClients(String name, String text) throws RemoteException;
}