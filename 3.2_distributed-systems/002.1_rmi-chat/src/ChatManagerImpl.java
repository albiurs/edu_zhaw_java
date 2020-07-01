
/*
 *  Copyright (c) 2019 ZHAW School of Engineering. All rights are reserved.
 */
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
/**
 * Implements the chat manager interface.
 *
 */
public class ChatManagerImpl extends UnicastRemoteObject implements ChatManager {
	private Map<String, Callback> clients = new HashMap<String, Callback>();

	public ChatManagerImpl() throws RemoteException {
	}

	public synchronized boolean login(String name, Callback c) {

		if (clients.containsKey(name))
			return false;
		clients.put(name, c);
		showLoginToAll(name);
		System.out.println("Login: " + name);
		return true;
	}

	public synchronized void logout(String name, Callback c) {
		showLogoutToAll(name);
		clients.remove(name);
		System.out.println("Logout: " + name);
	}

	public synchronized void notifyClients(String name, String text) {
		showMessageToAll(name, text);
	}

	private void showLoginToAll(String name) {
		clients.forEach((n, c) -> {
			try {
				c.showLogin(name);

			} catch (RemoteException e) {
				clients.remove(n);
			}
		});
	}

	private void showLogoutToAll(String name) {
		clients.forEach((n, c) -> {
			try {
				c.showLogout(name);

			} catch (RemoteException e) {
				clients.remove(n);
			}
		});
	}

	private void showMessageToAll(String name, String text) {
		clients.forEach((n, c) -> {
			try {
				c.showMessage(name, text);

			} catch (RemoteException e) {
				clients.remove(n);
			}
		});
	}
}