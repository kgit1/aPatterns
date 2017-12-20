package x.Fib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Java Program sort an integer array using radix sort algorithm.
 * input: [80, 50, 30, 10, 90, 60, 0, 70, 40, 20, 50]
 * output: [0, 10, 20, 30, 40, 50, 50, 60, 70, 80, 90]
 * 
 * Time Complexity of Solution:
 *     Best Case O(n); Average Case O(n); Worst Case O(n^2).
 * 
 */

//Program to implement Bucket sort in Java
public class SortProjectBucketSort {

  public static void main(String[] args) {

    System.out.println("Bucket sort in Java");
    int[] input = { 80, 50, 30, 10, 90, 60, 0, 70, 40, 20, 50 };

    System.out.println("integer array before sorting");
    System.out.println(Arrays.toString(input));

    // sorting array using radix Sort Algorithm
    bucketSort(input);

    System.out.println("integer array after sorting using bucket sort algorithm");
    System.out.println(Arrays.toString(input));

  }

  /**
   * 
   * @param input
   */
  public static void bucketSort(int[] input) {
    // get hash codes
    final int[] code = hash(input);
    
    // create and initialize buckets to ArrayList: O(n)
    List<Integer>[] buckets = new List[code[1]];
    for (int i = 0; i < code[1]; i++) {
      buckets[i] = new ArrayList();
    }
    
    // distribute data into buckets: O(n)
    for (int i : input) {
      buckets[hash(i, code)].add(i);
    }
    
    // sort each bucket O(n)
    for (List bucket : buckets) {
      Collections.sort(bucket);
    }
    
    int ndx = 0;
    // merge the buckets: O(n)
		for (int b = 0; b < buckets.length; b++) {
			for (int v : buckets[b]) {
				input[ndx++] = v;
			}
		}
  }

  /**
   * 
   * @param input
   * @return an array containing hash of input
   */
  private static int[] hash(int[] input) {
    int m = input[0];
    for (int i = 1; i < input.length; i++) {
      if (m < input[i]) {
        m = input[i];
      }
    }
    return new int[] { m, (int) Math.sqrt(input.length) };
  }

  /**
   * 
   * @param i
   * @param code
   * @return
   */
  private static int hash(int i, int[] code) {
    return (int) ((double) i / code[0] * (code[1] - 1));
  }

}


//Output
//Bucket sort in Java
//integer array before sorting
//[80, 50, 30, 10, 90, 60, 0, 70, 40, 20, 50]
//integer array after sorting using bucket sort algorithm
//[0, 10, 20, 30, 40, 50, 50, 60, 70, 80, 90]
//
//
//
//
//Bucket Sort - Important points to remember
//
//Here are some important points about bucket sort you should remember, this is useful from both interview and understanding point of view and Interviewer expects that you know about them when you say that you know bucket sort.
//
//1) Bucket Sort is also known as bin sort because you create bins or buckets to sort inputs.
//
//2) Bucket sort is only useful when the input is uniformly distributed over a range e.g. coins, numbers 1 to 100 etc.
//
//3) You can use a linked list or array as a bucket. The choice of data structure will affect the insertion time e.g. if you use linked list then adding on the head could take O(1) time. You can also use hash tables as buckets.
//
//4) The bucket sort is one of the rare O(n) sorting algorithm i.e. time complexity of Bucket sort is the liner in best and average case and not NLogN like Quicksort or Mergesort.
//
//5) Bucket sort is not a stable sorting algorithm because in a stable algorithm if two input is same they retain their place in sorted order and in the bucket it depends upon how you sort the individual bucket. Though, bucket sort can be made stable, known as radix sort, which we'll see in future articles.
//
//6) You can sort the elements inside individual buckets either by recursively calling the bucket sort or using a separate sorting algorithm e.g. insertion sort, bubble sort, or quick sort.
//
//7) Is bucket sort an in-place sorting algorithm? No, it's not an in-place sorting algorithm. The whole idea is that input sorts themselves as they are moved to the buckets. In the worst of the good cases (sequential values, but no repetition) the additional space needed is as big as the original array.
//
//8) The worst case complexity of bucket sort, when all elements will end up in the same bucket is O(n^2) because then it has to be sorted by a different sorting algorithm.
//
//9) The space complexity of bucket sort is O(n) because even to sort sequential values, without repetition, you need an array as big as the original array.
//
//Read more: http://javarevisited.blogspot.com/2017/01/bucket-sort-in-java-with-example.html#ixzz4W3S41Yc2
