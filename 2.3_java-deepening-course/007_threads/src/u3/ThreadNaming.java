package u3;


public class ThreadNaming {
	public static void main(String[] args) {
		
		// Lambda
		new Thread(() -> {
			System.out.println("Lambda");
			for (int i = 0; i < 50; i++) {
				String name = Thread.currentThread().getName();
				System.out.println("Thread " + name + " hat Nummer " + i + " verarbeitet");
			}

		}, "Lambda").start();
		
		
		
		Runnable bla = () -> {
			System.out.println("Lambda");
			for (int i = 0; i < 50; i++) {
				String name = Thread.currentThread().getName();
				System.out.println("Thread " + name + " hat Nummer " + i + " verarbeitet");
			}

		};
		
		
		Thread t1 = new Thread(new MyThread());
		Thread t2 = new Thread(new MyThread());
		t1.setName("Eins");
		t2.setName("Zwei");
		t1.start();
		t2.start();
		System.out.println(Thread.currentThread().getName());

		// alles in einer Zeile
		new Thread(new MyThread(), "Drei").start();
		
		
		// Instanz Runnable
		Runnable runner = () -> System.out.println("Hallo Welt");
		new Thread(runner, "runner").start();
		new Thread(runner, "runner2").start();


	}
}