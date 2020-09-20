/**
 * MyThread
 *
 * @author created by Urs Albisser, on 2020-09-20
 * @version 0.1
 */
public class MyThread extends Thread {

	private String message;
	private static Object lock = new Object();

	public MyThread(String message) {
		this.message = message;
	}

	public void run() {									// t1 startet
		synchronized(lock) {							// kritischer Abschnitt mit "lock"
			while(true) {
				System.out.println(message);
				lock.notify();							// t1 weckt t2
				try {
					Thread.sleep(1000);			// Pause von 1 Sekunde
					lock.wait();						// t1 geht schlafen --> t2 startet
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
