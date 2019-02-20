package facetest.newtouch.next2;

public class Main {
	public static void main(String[] args) {
		Object object = new Object();
		new Thread1(object).start();
		new Thread2(object).start();
	}
}
