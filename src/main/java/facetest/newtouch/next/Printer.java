package facetest.newtouch.next;

public class Printer {
	private int index = 1;

	public synchronized void print(int n) {
		while (index % 3 == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.print(n + " ");
		index++;
		notifyAll();
	}

	public synchronized void print(char c) {
		while (index % 3 != 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		index++;
		System.out.print(c + " ");
		notifyAll();
	}
}
