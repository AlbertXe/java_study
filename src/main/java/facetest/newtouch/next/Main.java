package facetest.newtouch.next;

public class Main {
	public static void main(String[] args) {
		Printer printer = new Printer();
		new ThreadA(printer).start();
		new ThreadB(printer).start();

	}
}
