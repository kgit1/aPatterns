package x.Fib;

import java.util.Arrays;

// Java program to sort an array using Insertion sort algorithm. * Insertion
//sort works great with already sorted, small arrays but not suitable for *
//large array with random order. * * @author Javin Paul
public class xInsertionSort {
	public static void main(String args[]) {
		// getting unsorted integer array for sorting
		int[] randomOrder = getRandomArray(9);
		System.out.println("Random Integer array before Sorting : " + Arrays.toString(randomOrder));
		// sorting array using insertion sort in Java
		insertionSort(randomOrder);
		System.out.println("Sorted array uisng insretion sort : " + Arrays.toString(randomOrder));
		// one more example of sorting array using insertion sort randomOrder =
		getRandomArray(7);
		System.out.println("Before Sorting : " + Arrays.toString(randomOrder));
		insertionSort(randomOrder);
		System.out.println("After Sorting : " + Arrays.toString(randomOrder));
		// Sorting String array using Insertion Sort in Java
		String[] cities = { "London", "Paris", "Tokyo", "NewYork", "Chicago" };
		System.out.println("String array before sorting : " + Arrays.toString(cities));
		insertionSort(cities);
		System.out.println("String array after sorting : " + Arrays.toString(cities));
	}

	public static int[] getRandomArray(int length) {
		int[] numbers = new int[length];
		for (int i = 0; i < length; i++) {
			numbers[i] = (int) (Math.random() * 100);
		}
		return numbers;
	}

	// Java implementation of insertion sort algorithm to sort * an integer
	// array.
	public static void insertionSort(int[] array) {
		// System.out.println(" " + Arrays.toString(array));
		// insertion sort starts from second element
		for (int i = 1; i < array.length; i++) {
			// numberToInsert = i (second element)
			int numberToInsert = array[i];
			// compare index = i(second element position)
			int compareIndex = i;
			// if compare index>0 and if previous to checked element bigger than
			// checked
			// we shift elements and decrease compareIndex by 1
			while (compareIndex > 0 && array[compareIndex - 1] > numberToInsert) {
				// shifting element
				array[compareIndex] = array[compareIndex - 1];
				// moving backwards, towards index 0
				compareIndex--;
				// System.out.println("while switch " + Arrays.toString(array));
			}
			// compareIndex now denotes proper place for number to be sorted
			array[compareIndex] = numberToInsert;
			// System.out.println("after switch " + Arrays.toString(array));
		}
	}

	/*
	 * * Method to Sort String array using insertion sort in Java. * This can
	 * also sort any object array which implements * Comparable interface.
	 */
	public static void insertionSort(Comparable[] objArray) {
		// insertion sort starts from second element
		for (int i = 1; i < objArray.length; i++) {
			Comparable objectToSort = objArray[i];
			int j = i;
			while (j > 0 && objArray[j - 1].compareTo(objectToSort) > 1) {
				objArray[j] = objArray[j - 1];
				j--;
			}
			objArray[j] = objectToSort;
		}
	}
}

// Output:
// Random Integer
// array before Sorting:[74,87,27,6,25,94,53,91,15]
// Sorted array
// using insertion sort:[6,15,25,27,53,74,87,91,94]
// Before Sorting:[71,5,60,19,4,78,42]
// After Sorting:[4,5,19,42,60,71,78]
// String array
// before sorting:[London,Paris,Tokyo,NewYork,Chicago]
// String array
// after sorting:[Chicago,London,NewYork,Paris,Tokyo]
