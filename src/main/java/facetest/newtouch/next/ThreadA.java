package facetest.newtouch.next;

public class ThreadA extends Thread {
	Printer printer;

	public ThreadA(Printer printer) {
		this.printer = printer;
	}

	@Override
	public void run() {
		for (int i = 1; i < 53; i++) {
			printer.print(i);
		}
	}
}
