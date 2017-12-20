package x.Fib;

import java.util.Arrays;
import java.util.Random;

public class ArrayMixer {
	public static int count = 0;
	public static int countString = 0;

	public static void main(String[] args) {
		Random rnd = new Random();
		int[] array1 = new int[3];
		for (int k = 0; k < array1.length; k++) {
			array1[k] = rnd.nextInt(10) + 1;
		}
		// mixer(new int[]{1,2,3},3);
		arrayMixer(array1, array1.length);
		String s = "Ranch";
		stringMixer(s);

	}

	public static void arrayMixer(int[] arr, int size) {
		if (size < 2) {
			count++;
			System.out.print(count);
			System.out.println(Arrays.toString(arr));
		} else {
			for (int k = 0; k < size; k++) {
				swap(arr, k, size - 1);
				arrayMixer(arr, size - 1);
				swap(arr, k, size - 1);
			}
		}
	}

	public static void stringMixer(String s) {
		int length = s.length();
		char[] chars = s.toCharArray();
		stringMixer(chars, length);
	}

	private static void stringMixer(char[] arr, int size) {
		if (size < 2) {
			countString++;
			System.out.print(countString);
			System.out.println(Arrays.toString(arr));
		} else {
			for (int k = 0; k < size; k++) {
				swapChar(arr, k, size - 1);
				stringMixer(arr, size - 1);
				swapChar(arr, k, size - 1);
			}
		}
	}

	public static void swap(int[] arr, int index1, int index2) {
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	}

	public static void swapChar(char[] arr, int index1, int index2) {
		char tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	}
}
