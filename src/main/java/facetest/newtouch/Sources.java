package facetest.newtouch;

public class Sources {
	int length = 52;
	private int[] numbers;
	private char[] characters;

	public Sources(int[] numbers, char[] characters) {
		super();
		this.numbers = numbers;
		this.characters = characters;
	}

	public int[] getNumbers() {
		return numbers;
	}

	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}

	public char[] getCharacters() {
		return characters;
	}

	public void setCharacters(char[] characters) {
		this.characters = characters;
	}

}
