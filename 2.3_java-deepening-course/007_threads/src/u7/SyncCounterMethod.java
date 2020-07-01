package u7;


public class SyncCounterMethod {
	public static void main(String... args) {
		Counter counter = new Counter();
		for (int i = 0; i < 10; i++)
			new Worker(counter).start();
	}
}

class Worker extends Thread {
	Counter counter;

	Worker(Counter counter) {
		this.counter = counter;
	}

	public void run() {
		System.out.println("Thread " + this.getName() + " started!");

		while (true) {
			for (int i = 0; i < Counter.LIMIT; i++)
				counter.up(this.getName());
			for (int i = 0; i < Counter.LIMIT; i++)
				counter.down(this.getName());
		}
	}
}

class Counter {

	private int count = 0;
	public final static int LIMIT = 5;

	synchronized void up(String threadName) {
		if (count < LIMIT)
			count++;
		if (count > LIMIT)
			System.out.println(threadName + " counter overflow: " + count);
	}

	synchronized void down(String threadName) {
		if (count > 0)
			count--;
		if (count < 0)
			System.out.println(threadName + " counter underrun: " + count);
	}

}
