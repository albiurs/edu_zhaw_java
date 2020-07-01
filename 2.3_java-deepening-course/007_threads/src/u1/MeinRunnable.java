package u1;

class MeinRunnable implements Runnable {
	@Override
	public void run() {
		try {
			Thread.sleep(1);
			los();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void los() throws InterruptedException {
		tuNochMehr();
	}

	private void tuNochMehr() throws InterruptedException {
		Thread.sleep(1);
		System.out.println("Oben auf den Stack");
	}
}

