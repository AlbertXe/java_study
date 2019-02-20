package facetest.newtouch.next;

public class ThreadB extends Thread {
	Printer printer;

	public ThreadB(Printer printer) {
		this.printer = printer;
	}

	@Override
	public void run() {
		for (int i = 1; i < 27; i++) {
			printer.print((char) ('a' + i - 1));
		}
	}
}
