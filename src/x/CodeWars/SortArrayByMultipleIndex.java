package x.CodeWars;

import java.util.Arrays;

public class SortArrayByMultipleIndex {

	public static void main(String[] args) {
		// int[] array1 = { 2, 3, 7, 55, 22, 4, 6 };
		// sortByValueAndIndex(array1);
		// System.out.println("=====================");
		// int[] array2 = { 1, 2, 3, 4, 5 };
		// sortByValueAndIndex(array2);
		// System.out.println("[1, 2, 3, 4, 5] " + " expected");
		//
		// System.out.println("=====================");
		// int[] array3 = { 23, 2, 3, 4, 5 };
		// sortByValueAndIndex(array3);
		// System.out.println("[2, 3, 4, 23, 5]" + " expected");
		//
		// System.out.println("=====================");
		// int[] array4 = { 26, 2, 3, 4, 5 };
		// sortByValueAndIndex(array4);
		// System.out.println("[2, 3, 4, 5, 26]" + " expected");

//		System.out.println("=====================");
//		int[] array5 = { 9, 5, 1, 4, 3 };
//		System.out.println(Arrays.toString(sortByValueAndIndex(array5)) + " actual");
//		System.out.println("[1, 9, 5, 3, 4] " + " expected");
		
		System.out.println("=====================");
		int[] array5 = { -29, -24, -28, -21, -18, -14, -8, -7, -8, -1, 24, 4, 15, 29, 24, 11, 23 };
		System.out.println(Arrays.toString(sortByValueAndIndex(array5)) + " actual");
		System.out.println("[-29, -24, -28, -21, -18, -14, -8, -7, -8, -1, 24, 4, 15, 29, 24, 11, 23] " + " expected");

	}

	// public static int[] sortByValueAndIndexDirty(int[] array) {
	// System.out.println(Arrays.toString(array) + " initial array");
	// int[] multipliedArray = new int[array.length];
	//
	// // make new array with multiplied values
	// for (int i = 0; i < array.length; i++) {
	// multipliedArray[i] = array[i] * (i + 1);
	// }
	// System.out.println(Arrays.toString(multipliedArray) + " unsorted " +
	// multipliedArray);
	//
	// // sort multiplied array
	// int[] sortedMultipliedArray = Arrays.copyOf(multipliedArray,
	// multipliedArray.length);
	// // Arrays.copyOf(multipliedArray, multipliedArray.length);
	//
	// for (int i = 0; i < sortedMultipliedArray.length - 1 - i; i++) {
	// for (int j = 0; j < sortedMultipliedArray.length - 1 - i; j++) {
	// // System.out.println(sortedMultipliedArray[j] + " i");
	// // System.out.println(sortedMultipliedArray[j + 1] + " i+1");
	// if (sortedMultipliedArray[j] > sortedMultipliedArray[j + 1]) {
	// int temp = sortedMultipliedArray[j];
	// sortedMultipliedArray[j] = sortedMultipliedArray[j + 1];
	// sortedMultipliedArray[j + 1] = temp;
	// }
	// }
	// }
	// System.out.println(Arrays.toString(multipliedArray) + " unsorted2 " +
	// multipliedArray);
	// System.out.println(Arrays.toString(sortedMultipliedArray) + " sorted " +
	// sortedMultipliedArray);
	//
	// // find new indexes for array members
	// // indexArray - position means old index - number means new index
	// int[] indexArray = new int[array.length];
	// for (int i = 0; i < array.length; i++) {
	// for (int j = 0; j < array.length; j++) {
	// // System.out.println(multipliedArray[i] + " ::: " +
	// // sortedMultipliedArray[j]);
	// if (multipliedArray[i] == sortedMultipliedArray[j]) {
	// // System.out.println(i + " : " + j);
	// indexArray[i] = j;
	// }
	// }
	// }
	//
	// System.out.println(Arrays.toString(indexArray) + " index");
	//
	// int[] temp = new int[array.length];
	// for (int i = 0; i < array.length; i++) {
	//// array[i]=>temp[indexAraay[i]]
	// temp[indexArray[i]] = array[i];
	// System.out.println(i +" :i "+indexArray[i]+" :index
	// "+array[indexArray[i]]+" new value");
	// }
	// System.out.println(Arrays.toString(temp) + " new sorted indexed etc");
	// return temp;
	// }

	public static int[] sortByValueAndIndex(int[] array) {
		int[] multipliedArray = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			multipliedArray[i] = array[i] * (i + 1);
		}
		int[] sortedMultipliedArray = Arrays.copyOf(multipliedArray, array.length);
		Arrays.sort(sortedMultipliedArray);

		int[] indexArray = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (multipliedArray[i] == sortedMultipliedArray[j]) {
					indexArray[i] = j;
				}
			}
		}

		int[] temp = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			temp[indexArray[i]] = array[i];
		}
		return temp;
	}

	// public static int[] sortByValueAndIndex(int[] array) {
	// int[] multipliedArray = new int[array.length];
	// for (int i = 0; i < array.length; i++) {
	// multipliedArray[i] = array[i] * (i + 1);
	// }
	// int[] sortedMultipliedArray = Arrays.copyOf(multipliedArray,
	// multipliedArray.length);
	//
	// for (int i = 0; i < sortedMultipliedArray.length - 1 - i; i++) {
	// for (int j = 0; j < sortedMultipliedArray.length - 1 - i; j++) {
	// if (sortedMultipliedArray[j] > sortedMultipliedArray[j + 1]) {
	// int temp = sortedMultipliedArray[j];
	// sortedMultipliedArray[j] = sortedMultipliedArray[j + 1];
	// sortedMultipliedArray[j + 1] = temp;
	// }
	// }
	// }
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

}
