/*
 *  Copyright (c) 2019 ZHAW School of Engineering. All rights are reserved.
 */
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
/**
 * Implements the callback interface.
 *
 */
public class CallbackImpl extends UnicastRemoteObject implements Callback {
	private ChatClient client;

	public CallbackImpl(ChatClient client) throws RemoteException {
		this.client = client;
	}

	public void showLogin(String name) {
		client.log(name + " has joined the chat.");
	}

	public void showLogout(String name) {
		client.log(name + " has quitted the chat.");
	}

	public void showMessage(String name, String text) {
		client.log(name + ": " + text);
	}
}