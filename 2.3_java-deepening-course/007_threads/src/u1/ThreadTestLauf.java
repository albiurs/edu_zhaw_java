package u1;

public class ThreadTestLauf {
	public static void main(String[] args) {
		Runnable threadJob = new MeinRunnable();
		Thread meinThread = new Thread(threadJob);
		meinThread.start();
		try {
			// meinThread.sleep(1);
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("zurück in main");
	}
}