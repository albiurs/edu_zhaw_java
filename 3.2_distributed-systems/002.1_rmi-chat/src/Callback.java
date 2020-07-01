/*
 *  Copyright (c) 2019 ZHAW School of Engineering. All rights are reserved.
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Callback interface for allowing the server to call the client on an event. 
 *
 */
public interface Callback extends Remote {
	/**
	 * Shows the user who logged in on a client.
	 * @param name nickname of the user
	 * @throws RemoteException
	 */
	void showLogin(String name) throws RemoteException;
	/**
	 * Shows the user who logged out on a client.
	 * @param name nickname of the user
	 * @throws RemoteException
	 */
	void showLogout(String name) throws RemoteException;
	/**
	 * Shows the message which was contributed by a user on a client.
	 * @param name nickname of the user
	 * @throws RemoteException
	 */
	void showMessage(String name, String text) throws RemoteException;
}