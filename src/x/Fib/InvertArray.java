package x.Fib;

import java.util.Arrays;

public class InvertArray {
	public static void main(String[] args) {
		int[] data = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		arrayInvert(data);
		System.out.println(Arrays.toString(data));
		String s = "Demolition Ranch";
		System.out.println(s);
		System.out.println(arrayInvertString(s));

	}

	public static void arrayInvert(int[] data) {
		for (int i = data.length / 2; i >= 0; i--) {
			swap(data, i, data.length - 1 - i);
		}
	}

	public static String arrayInvertString(String s) {
		char[] chars = s.toCharArray();
		String s1 = "";
		for (int i = chars.length / 2; i >= 0; i--) {
			swap(chars, i, chars.length - 1 - i);
		}
		for (int i = 0; i < chars.length; i++) {
			s1 += chars[i];
		}
		return s1;
	}

	public static void swap(int[] arr, int index1, int index2) {
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	}

	public static void swap(char[] arr, int index1, int index2) {
		char tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	}
}
