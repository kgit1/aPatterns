package x.CodeWars;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SortArrayByMultipleIndex {

	@Test
	public void randomTests() {
		for (int r = 0; r < 20; r++) {
			// create random array
			int n = (int) (Math.random() * 20 + 1);
			int[] array = new int[n];
			// fill with random numbers
			for (int j = 0; j < n; j++) {
				array[j] = (int) (Math.random() * 60 - 30);
			}
			System.out.println(Arrays.toString(array) + " randomed array");

			// create 2 dimensional array
			// fell with numbers of first array and their multiplication by
			// index
			int[][] arrayWithProd = new int[array.length][];
			for (int i = 0; i < array.length; i++) {
				arrayWithProd[i] = new int[2];
				arrayWithProd[i][0] = array[i];
				arrayWithProd[i][1] = (i + 1) * array[i];
			}

			for (int h = 0; h < arrayWithProd.length; h++) {
				for (int i = 0; i < arrayWithProd.length - 1; i++) {
					// System.out.println(arrayWithProd[i][0]+" 1????????");
					if (arrayWithProd[i][1] > arrayWithProd[i + 1][1]) {
						int[] temp = arrayWithProd[i];
						arrayWithProd[i] = arrayWithProd[i + 1];
						arrayWithProd[i + 1] = temp;
					}
					// System.out.println(arrayWithProd[i][0]+" 2????????");
				}
			}

			int[] expected = new int[array.length];
			for (int i = 0; i < arrayWithProd.length; i++) {
				expected[i] = arrayWithProd[i][0];
			}

			System.out.println(Arrays.toString(expected) + " expected array");

			int[] actual = SortArrayByMultipleIndex.sortByValueAndIndex(array);
			System.out.println(Arrays.toString(actual) + " our array");
			System.out.println("===========================");

			String message = "Your result:\n" + arrayToString(actual) + "\n\nExpected result:\n"
					+ arrayToString(expected) + "\n\n";
			assertEquals(message, arrayToString(expected), arrayToString(actual));
		}
	}

	public static int[] sortByValueAndIndex(int[] array) {
		int[] multipliedArray = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			multipliedArray[i] = array[i] * (i + 1);
		}

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (multipliedArray[j] > multipliedArray[j + 1]) {
					int temp1 = multipliedArray[j];
					multipliedArray[j] = multipliedArray[j + 1];
					multipliedArray[j + 1] = temp1;
					int temp2 = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp2;
				}
			}
		}
		return array;
	}

	// doesn't handle duplicates
	// public static int[] sortByValueAndIndex1(int[] array) {
	// int[] multipliedArray = new int[array.length];
	// for (int i = 0; i < array.length; i++) {
	// multipliedArray[i] = array[i] * (i + 1);
	// }
	// int[] sortedMultipliedArray = Arrays.copyOf(multipliedArray,
	// array.length);
	// Arrays.sort(sortedMultipliedArray);
	//
	// int[] indexArray = new int[array.length];
	// for (int i = 0; i < array.length; i++) {
	// for (int j = 0; j < array.length; j++) {
	// if (multipliedArray[i] == sortedMultipliedArray[j]) {
	// indexArray[i] = j;
	// }
	// }
	// }
	//
	// int[] temp = new int[array.length];
	// for (int i = 0; i < array.length; i++) {
	// temp[indexArray[i]] = array[i];
	// }
	// return temp;
	// }

	private String arrayToString(int[] array) {
		return Arrays.toString(array);
	}

}
