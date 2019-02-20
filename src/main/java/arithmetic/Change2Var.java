package arithmetic;

public class Change2Var {
	public void changeBytemp(int a, int b) {
		int temp;
		temp = a;
		a = b;
		b = temp;
	}

	public void changeByBit(int a, int b) {
		a = a ^ b; // a = a^b;
		b = a ^ b; // b = a^b^b = a;
		a = a ^ b; // a= a^b^a = b; 一个数对另一个数 异或两次 该数不变。
	}

	public void changeByPlus(int a, int b) {
		a = a + b;
		b = a - b; // b =a+b-b =a ;
		a = a - b; // a = a+b -a =b;
	}
}
