package x.Fib;

import java.util.Arrays;

public class ReversString {

	public static void main(String[] args) {
		// write your code here
		String s = "abba babbak";

		System.out.println(s);
		s = reverse(s);
		System.out.println(s);
		s = reverse1(s);
		System.out.println(s);
		s = reverse2(s);
		System.out.println(s);
		s = new StringBuilder(s).reverse().toString();
		System.out.println(s);

	}

	public static String reverse(String s) {
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length / 2; i++) {
			char tmp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = tmp;
		}
		s = String.valueOf(arr);
		return s + 1;
	}

	public static String reverse1(String s) {
		String reverse = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			reverse += s.charAt(i);
		}
		return reverse + 1;
	}

	public static String reverse2(String s) {
		return new StringBuilder(s).reverse().toString() + 2;
	}
}
