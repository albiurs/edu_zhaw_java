package u8;


// Stopping von Threads mittels Polling 

class StopThread extends Thread {
	private boolean stopped = false;

	public StopThread() {
		start();
	}

	public synchronized void stopThread() {
		stopped = true;
	}

	public synchronized boolean isStopped() {
		return stopped;
	}

	public void run() {
		int i = 0;
		while (!isStopped()) {
			i++;
			System.out.println("Hallo Welt (" + i + ")");
		}
		System.out.println("Thread endet jetzt ...");
	}

}

public class StartStopThread {

	public static void main(String[] args) {
		StopThread st = new StopThread();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		System.out.println("Main task sleep over");
		st.stopThread();
		
		try {
			st.join();
		} catch (InterruptedException e) {
			
		}
		System.out.println("StopThread terminated");
	}
}

