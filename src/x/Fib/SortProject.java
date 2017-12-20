package x.Fib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Random;

public class SortProject {

	public static void main(String[] args) {
		SortProject s = new SortProject();
		s.writeArray(s.arrayGenerator(50, 50));
		int[] arr = s.readArray();
		int[] arr1 = new int[50];
		arr1 = s.readArray();
		int[] arr11 = s.readArray();
		int[] arr111 = s.readArray();
		int[] arr2 = s.readArray();
		int[] arr3 = s.readArray();
		// System.out.println(Arrays.toString(arr));
		// System.out.println(Arrays.toString(arr1));
		s.printAndSort(arr);
		s.printAndSort1(arr1);
		s.printAndSort11(arr11);
		s.printAndSort111(arr111);
		s.printAndSort2(arr2);
		s.printAndSort3(arr3);
		// s.sortInsertion(s.arrayGenerator(50, 50));
	}

	// sort array with Silly Sort
	public void sortSilly(int[] array) {
		int counter = 0;
		boolean end = false;
		while (!end) {
			end = true;
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) {
					counter++;
					int tmp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = tmp;
					end = false;
					break;
				}
			}
		}
		System.out.println("Counter:" + counter + "\t\t\t\tSilly Sort");
	}

	// sort array with Bubble Sort dragging min to start
	public void sortBubble(int[] array) {
		int counter = 0;
		for (int i = 0; i < array.length - 1; i++) {
			int min = array[i];
			for (int j = i + 1; j < array.length; j++) {
				if (min > array[j]) {
					counter++;
					min = array[j];
					int tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
				}
			}
		}
		System.out.println("Counter:" + counter
				+ "\t\t\t\tBubble Sort dragging min to start");
	}

	// sort array with BuBles Sort pushing max to end
	public void sortBubble1(int[] array) {
		int counter = 0;
		for (int i = array.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (array[j] > array[j + 1]) {
					counter++;
					int tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
				}
			}
		}
		System.out.println("Counter: " + counter
				+ "\t\t\t\tBuBles Sort pushing max to end");
	}

	// sort array with BuBles Sort
	private static void sortBubble11(int[] array) {
		boolean end = false;
		int counter = 0;
		while (!end) {
			end = true;
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) {
					counter++;
					int t = array[i];
					array[i] = array[i + 1];
					array[i + 1] = t;
					end = false;
				}
			}
		}
		System.out.println(
				"Counter: " + counter + "\t\t\t\tBuBles Sort experimental");
	}

	// sort array with Selection Sort
	public void sortSelection(int[] array) {
		int counter = 0;
		for (int i = 0; i < array.length - 1; i++) {
			// hold index of minimal number
			int min = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[min]) {
					// if arr[j] < arr[min], assign j to mi
					min = j;
				}
			}
			// if min not equals to min - switch arr[i] with arr[min]
			if (i != min) {
				counter++;
				int tmp = array[min];
				array[min] = array[i];
				array[i] = tmp;
			}
		}
		System.out.println("Counter: " + counter + "\t\t\t\tSelection Sort");
	}

	// sort array with Insertion Sort
	public void sortInsertion(int[] array) {
		int counter = 0;
		for (int i = 1; i < array.length; i++) {
			for (int j = i; j > 0 && array[j - 1] > array[j]; j--) {
				counter++;
				int tmp = array[j - 1];
				array[j - 1] = array[j];
				array[j] = tmp;
			}
		}
		System.out.println("Counter: " + counter + "\t\t\t\tInsertion Sort");
	}

	// print incoming array and sorted version
	public void printAndSort(int[] array) {
		System.out.println("Random array       " + Arrays.toString(array));
		sortSilly(array);
		System.out.println("Random sorted array" + Arrays.toString(array));
	}

	// print incoming array and sorted version
	public void printAndSort1(int[] array) {
		// System.out.println("Random array " + Arrays.toString(array));
		sortBubble(array);
		System.out.println("Random sorted array" + Arrays.toString(array));
	}

	// print incoming array and sorted version
	public void printAndSort11(int[] array) {
		// System.out.println("Random array " + Arrays.toString(array));
		sortBubble1(array);
		System.out.println("Random sorted array" + Arrays.toString(array));
	}

	// print incoming array and sorted version
	public void printAndSort111(int[] array) {
		// System.out.println("Random array " + Arrays.toString(array));
		sortBubble11(array);
		System.out.println("Random sorted array" + Arrays.toString(array));
	}

	// print incoming array and sorted version
	public void printAndSort2(int[] array) {
		// System.out.println("Random array " + Arrays.toString(array));
		sortSelection(array);
		System.out.println("Random sorted array" + Arrays.toString(array));
	}

	// print incoming array and sorted version
	public void printAndSort3(int[] array) {
		// System.out.println("Random array " + Arrays.toString(array));
		sortInsertion(array);
		System.out.println("Random sorted array" + Arrays.toString(array));
	}

	// generate array with random numbers up to "randMax" with size - "size"
	public int[] arrayGenerator(int randMax, int size) {
		int[] array = new int[size];
		Random rand = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(randMax);
		}
		return array;
	}

	// write array to file
	public void writeArray(int[] array) {
		File file = new File("TestArray.txt");
		try {
			FileOutputStream out = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(out);
			oos.writeObject(array);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// get array from file
	public int[] readArray() {
		int[] array = new int[50];
		File file = new File("TestArray.txt");
		try {
			FileInputStream in = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(in);
			array = (int[]) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return array;
	}

	//////// CHECK ==========================================================
	private static void shakeSort(int[] v) {
		boolean end = false;
		while (!end) {
			end = true;
			for (int i = 0; i < v.length - 1; i++) {
				if (v[i] > v[i + 1]) {
					int t = v[i];
					v[i] = v[i + 1];
					v[i + 1] = t;
					end = false;
				}
			}

			for (int i = v.length - 1; i > 0; i--) {
				if (v[i] < v[i - 1]) {
					int t = v[i];
					v[i] = v[i - 1];
					v[i - 1] = t;
					end = false;
				}
			}
		}
	}

	public void coolSort(int[] v) {
		float loadFactor = 1.247f;
		int step = v.length;
		boolean end = false;
		int t;
		while (!end) {
			end = true;
			step /= loadFactor;
			if (step < 1) {
				step = 1;
			}
			for (int i = 0; i < v.length - 1; i++) {
				if ((i + step) < v.length) {
					if (v[i] > v[i + step]) {
						t = v[i];
						v[i] = v[i + step];
						v[i + step] = t;
						end = false;
					}
				} else {
					end = false;
				}

			}

		}
	}

	private void oddNotOddSort(int[] v) {
		boolean end = false;
		while (!end) {
			end = true;
			for (int i = 0; i < v.length - 1; i += 1) {
				if (v[i] > v[i + 1]) {
					int t = v[i];
					v[i] = v[i + 1];
					v[i + 1] = t;
					end = false;
				}
			}

			for (int i = 1; i < v.length - 1; i += 1) {
				if (v[i] > v[i + 1]) {
					int t = v[i];
					v[i] = v[i + 1];
					v[i + 1] = t;
					end = false;
				}
			}
		}
	}

}
