package x.Fib;

import java.util.Arrays;

/**
* Java program to Sort integer array using QuickSort algorithm using recursion.
* Recursive QuickSort algorithm, partitioned list into two parts by a pivot,
* and then recursively sorts each list.
* @author Javin Paul
*/
public class SortProjectQuikSort{

    public static void main(String args[]) {

        int[] input = { 23, 31, 1, 21, 36, 72};
        System.out.println("Before sorting : " + Arrays.toString(input));
        quickSort(input); // sort the integer array using quick sort algorithm
        System.out.println("After sorting : " + Arrays.toString(input));
     
        // input with duplicates
        int[] withDuplicates = { 11, 14, 16, 12, 11, 15};
        System.out.println("Before sorting : " + Arrays.toString(withDuplicates));
        quickSort(withDuplicates); // sort the integer array using quick sort algorithm
        System.out.println("After sorting : " + Arrays.toString(withDuplicates));
    }

    /**
     * public method exposed to client, sorts given array using QuickSort
     * Algorithm in Java
     * @param array
     */
    public static void quickSort(int[] array) {
        recursiveQuickSort(array, 0, array.length - 1);
    }

    /**
     * Recursive quicksort logic
     *
     * @param array input array
     * @param startIdx start index of the array
     * @param endIdx end index of the array
     */
    public static void recursiveQuickSort(int[] array, int startIdx, int endIdx) {
     
        int idx = partition(array, startIdx, endIdx);

        // Recursively call quicksort with left part of the partitioned array
        if (startIdx < idx - 1) {
            recursiveQuickSort(array, startIdx, idx - 1);
        }

        // Recursively call quick sort with right part of the partitioned array
        if (endIdx > idx) {
            recursiveQuickSort(array, idx, endIdx);
        }
    }

    /**
     * Divides array from pivot, left side contains elements less than
     * Pivot while right side contains elements greater than pivot.
     *
     * @param array array to partitioned
     * @param left lower bound of the array
     * @param right upper bound of the array
     * @return the partition index
     */
    public static int partition(int[] array, int left, int right) {
        int pivot = array[left]; // taking first element as pivot

        while (left <= right) {
            //searching number which is greater than pivot, bottom up
            while (array[left] < pivot) {
                left++;
            }
            //searching number which is less than pivot, top down
            while (array[right] > pivot) {
                right--;
            }

            // swap the values
            if (left <= right) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;

                //increment left index and decrement right index
                left++;
                right--;
            }
        }
        return left;
    }
}

//Output:
//Before sorting : [23, 31, 1, 21, 36, 72]
//After sorting : [1, 21, 23, 31, 36, 72]
//Before sorting : [11, 14, 16, 12, 11, 15]
//After sorting : [11, 11, 12, 14, 15, 16]
//
//
//Things to know about QuickSort Algorithm in Java
//As I said, QuickSort is one of the most popular sorting algorithms between programmers, may be just next to Bubble sort, which is ironically worst algorithm to sort a large list of numbers. But one thing is common between QuickSort and Bubble Sort, do you know what? In worst case both have the complexity of O(n^2).
//
//1) QuickSort is a divide and conquer algorithm, which means it sort a large array of numbers by dividing them into a smaller array and then individually sorting them (conquer).
//
//2) Average case complexity of Quicksort is O(n log(n)) and worst case complexity of Quicksort is O(n²).
//
//3) Quicksort is a comparison sort and, in efficient implementations, it's not a stable sort, which means equal numbers may not retain their original position after sorting.
//
//4) Quicksort algorithm can be implemented in-place, which means no additional space will be required. This makes it suitable to sort the large array of numbers.
//
//5) Arrays.sort() method in Java use quicksort to sort an array of primitives e.g. array of integers or float and uses Mergesort to sot objects e.g. array of String.
//
//
//Read more: http://www.java67.com/2014/07/quicksort-algorithm-in-java-in-place-example.html#ixzz4W3UPdpvt