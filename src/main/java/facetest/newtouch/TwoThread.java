package facetest.newtouch;

import java.util.Arrays;

public class TwoThread {

	public static void main(String[] args) {
		// 1-52
		// a-z
		int[] numbers = new int[52];
		char[] characters = new char[26];
		for (int i = 1; i < 53; i++) {
			numbers[i - 1] = i;
			if (i % 2 == 0)
				characters[i / 2 - 1] = (char) ('a' + i / 2 - 1);
		}
		System.out.println(Arrays.toString(numbers));
		System.out.println(Arrays.toString(characters));

		Sources sources = new Sources(numbers, characters);
		new Thread(new ThreadA(sources)).start();
		new Thread(new ThreadB(sources)).start();

	}
}

class ThreadA implements Runnable {
	int[] numbers;
	Sources sources;

	public ThreadA(Sources sources) {
		this.sources = sources;
		this.numbers = sources.getNumbers();
	}

	@Override
	public void run() {
		synchronized (sources) {
			for (int i = 0; i < sources.length; i++) {
				if (i % 3 == 2) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println(numbers[i]);
					notifyAll();
				}
		}
		}
	}
}

class ThreadB implements Runnable {
	private char[] characters;
	Sources sources;

	public ThreadB(Sources sources) {
		this.characters = sources.getCharacters();
		this.sources = sources;
	}

	@Override
	public synchronized void run() {
		synchronized (sources) {

			for (int i = 0; i < sources.length; i++) {
				if (i % 3 == 2) {
					System.out.println(characters[i]);
					notifyAll();
				} else {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}