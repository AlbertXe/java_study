package arithmetic;

import java.util.Stack;

public class Reverse {
	public static void main(String[] args) {
		Reverse re = new Reverse();
		re.doRev("abcdefg");
	}

	private String out = "";
	public void doRev(String input) {
		StringBuffer sb = new StringBuffer();
		sb.reverse();
		Stack stack = new Stack();
		for (int i = 0; i < input.length(); i++) {
			stack.push(input.charAt(i));
		}
		for (int i = 0; i < input.length(); i++) {
			out += stack.pop();
		}
		System.out.println(out);

	}
}
