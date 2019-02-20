package facetest.test0130;

public class Reverse {
	public static void main(String[] args) {
		String s = "abcdefg";
		StringBuilder sb = new StringBuilder(s);
		StringBuilder ss = sb.reverse();
		System.out.println(ss);
		String r = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(s.length() - 1 - i);
			r = r + c;
		}
		System.out.println(r);


	}
}
