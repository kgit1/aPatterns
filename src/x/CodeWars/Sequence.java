package x.CodeWars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Sequence {

	public static void main(String[] args) {
		// dbl_linear(12);
		System.out.println("\n=====" + dbl_linear2(10));
		// dbl_linear2(10);
		System.out.println("/////////////////////////////////////////////////////////////");
		System.out.println("\n=====" + dbl_linear2(20));
		// dbl_linear2(20);
		System.out.println("/////////////////////////////////////////////////////////////");
		System.out.println("\n=====" + dbl_linear2(30));
		// dbl_linear2(30);
		System.out.println("/////////////////////////////////////////////////////////////");
		System.out.println("\n=====" + dbl_linear2(50));
		// dbl_linear2(50);

	}

	public static int dbl_linear(int n) {
		Set<Integer> sequence = new TreeSet<>();
		sequence.add(1);

		for (int i = 0; sequence.size() < n * 2; i++) {
			List<Integer> temp = new ArrayList<>(sequence);
			sequence.add((2 * temp.get(i)) + 1);
			sequence.add((3 * temp.get(i)) + 1);
			// System.out.println("i: " + i + " " + temp.toString());

		}
		// for (Integer integer : sequence) {
		// System.out.print(integer + " ");
		// }
		// System.out.println("sequence last: " sequence.last());
		List<Integer> ret = new ArrayList<Integer>(sequence);
		// System.out.println(ret.toString());
		return ret.get(n);
	}

	public static int dbl_linear1(int n) {
		Set<Integer> sequence = new TreeSet<>();
		sequence.add(1);

		for (int i = 0; sequence.size() < n * 2; i++) {
			List<Integer> temp = new ArrayList<>(sequence);
			sequence.add((2 * temp.get(i)) + 1);
			sequence.add((3 * temp.get(i)) + 1);

		}
		Iterator iterator = sequence.iterator();
		int temp1 = 0;
		int temp2 = 0;
		while (temp1 <= n) {
			temp2 = (int) iterator.next();
			System.out.println(temp2);
			temp1++;
		}
		return temp2;
	}

	public static int dbl_linear2(int n) {
		List<Integer> sequence = new ArrayList<>();
		sequence.add(1);

		for (int i = 0; sequence.size() < n * 2; i++) {
			// System.out.println("i :"+i+" "+sequence.get(i));
			if (!sequence.contains((2 * sequence.get(i)) + 1)) {
				// System.out.println("if 1");
				sequence.add((2 * sequence.get(i)) + 1);
			}
			if (!sequence.contains((3 * sequence.get(i)) + 1)) {
				// System.out.println("if 2");
				sequence.add((3 * sequence.get(i)) + 1);
			}
			Collections.sort(sequence);
		}
		 System.out.println(sequence.toString());
		return sequence.get(n);
	}
	
	public static int dbl_linear3(int n) {
		List<Integer> list = new ArrayList<Integer>();
        int x = 0;
        int y = 0;

        list.add(1);
        for (;list.size() < n + 1;) {
            int a = 2 * list.get(x) + 1;
            int b = 3 * list.get(y) + 1;

            if (a < b) {
                list.add(a);
                x ++;
            } else if (a > b) {
                list.add(b);
                y ++;
            } else {
                list.add(b);
                x ++;
                y ++;
            }
        }
        return list.get(n);
	}
}

// Consider a sequence u where u is defined as follows:
//
// The number u(0) = 1 is the first one in u.
// For each x in u, then y = 2 * x + 1 and z = 3 * x + 1 must be in u too.
// There are no other numbers in u.
// Ex: u = [1, 3, 4, 7, 9, 10, 13, 15, 19, 21, 22, 27, ...]
//
// 1 gives 3 and 4, then 3 gives 7 and 10, 4 gives 9 and 13, then 7 gives 15 and
// 22 and so on...
//
// Task:
//
// Given parameter n the function dbl_linear (or dblLinear...) returns the
// element u(n) of the ordered (with <) sequence u.
//
// Example:
//
// dbl_linear(10) should return 22