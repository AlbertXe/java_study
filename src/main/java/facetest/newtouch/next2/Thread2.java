package facetest.newtouch.next2;

public class Thread2 extends Thread {
	Object object;

	public Thread2(Object object) {
		this.object = object;
	}

	@Override
	public void run() {
		synchronized (object) {
			for (int i = 0; i < 26; i++) {
				System.out.print((char) ('a' + i));
				object.notifyAll();
				try {
					if (i != 25) {
						object.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
