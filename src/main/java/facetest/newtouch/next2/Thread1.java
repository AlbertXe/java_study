package facetest.newtouch.next2;

public class Thread1 extends Thread {
	Object object;

	public Thread1(Object object) {
		this.object = object;
	}

	@Override
	public void run() {
		synchronized (object) {
			for (int i = 1; i < 53; i++) {
				System.out.print(i + " ");
				if (i % 2 == 0) {
					object.notifyAll();
					try {
						object.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		}
	}

}
