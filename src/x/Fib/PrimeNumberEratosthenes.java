package x.Fib;

import java.util.Arrays;

//A prime number is a natural number that has exactly two distinct natural 
//number divisors: 1 and itself.
//sieve of Erathosthenes - resheto eratosfena
//every not prime number - can be divided by one of previous prime numbers
public class PrimeNumberEratosthenes {

	public static void main(String[] args) {
		boolean[] a = new boolean[10000];
		a = sieveOfErathosthenes(a);
		printArray(a);
	}

	//sieve of Erathosthenes - resheto eratosfena
	public static boolean[] sieveOfErathosthenes(boolean[] flags) {
		// primary array initiated with all false numbers
		// all prime numbers except 2 is odd
		// so first we change all odd numbers with true
		init(flags);
		// try to divide item with true on previously found prime numbers
		// starting with 2
		prime(flags);
		return flags;
	}

	// initializes all odd indexes with true, because even numbers except 2
	// can't be prime
	public static void init(boolean[] flags) {
		flags[2] = true;
		for (int i = 3; i < flags.length; i++) {
			// if i can't be divided with 2
			if (i % 2 != 0) {
				flags[i] = true;
			}
		}
	}

	// took array with odd numbers marked true, and check number is it prime
	public static void prime(boolean[] flags) {
		for (int i = 4; i < flags.length; i++) {
			// if flags[i] = true
			// check is number - prime, by trying divide it on another prime
			// numbers found before, because every not prime number - can be
			// divided on one of previous prime numbers
			if (flags[i]) {
				int sqrt = (int) Math.sqrt(i);
				for (int j = 2; j <= sqrt; j++) {
					if (flags[j]) {
						if (i % j == 0) {
							flags[i] = false;
						}
					}
				}
			}
		}
	}

	// print matrix with items from boolean array
	// if index true - print index
	// after 12 printed numbers - change to next line
	public static void printArray(boolean[] flags) {
		int count = 0;
		for (int i = 0; i < flags.length; i++) {
			if (flags[i]) {
				count++;
				String s = "";
				// if number smaller than 10 - add 2 spaces
				if (i / 10 < 1) {
					s = "  ";
					// if smaller than 100 - add 1 space
				} else if (i / 100 < 1) {
					s = " ";
				}
				System.out.print(s + i + " ");
				if (count % 12 == 0) {
					System.out.println();
				}
			}
		}
	}

}
