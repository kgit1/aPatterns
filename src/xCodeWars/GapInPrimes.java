package xCodeWars;

import java.util.Arrays;

public class GapInPrimes {

	public static void main(String[] args) {
		// for (int i = 3; i < 200; i++) {
		// // System.out.println(i);
		// if (prime(i)) {
		// System.out.println(i + " prime");
		// }
		// ;
		// }
		// gap(2, 5, 7);
		System.out.println(Arrays.toString(gap(2, 5, 7)));
		System.out.println("===========================");
		System.out.println(Arrays.toString(gap(2, 5, 5)));
		System.out.println("===========================");
		System.out.println(Arrays.toString(gap(4, 130, 200)));
		System.out.println("===========================");
		System.out.println(Arrays.toString(gap(6, 100, 110)));

		// assertEquals("[101, 103]",
		// Arrays.toString(GapInPrimes.gap(2,100,110)));
		// assertEquals("[103, 107]",
		// Arrays.toString(GapInPrimes.gap(4,100,110)));
		// assertEquals(null, GapInPrimes.gap(6,100,110));
		// assertEquals("[359, 367]",
		// Arrays.toString(GapInPrimes.gap(8,300,400)));
		// assertEquals("[337, 347]",
		// Arrays.toString(GapInPrimes.gap(10,300,400)));
		System.out.println("===========================");
		System.out.println(Arrays.toString(gap(2, 100, 110)));
		System.out.println("===========================");
		System.out.println(Arrays.toString(gap(4, 100, 110)));
		System.out.println("===========================");
		System.out.println(Arrays.toString(gap(8, 300, 400)));
		System.out.println("===========================");
		System.out.println(Arrays.toString(gap(10, 300, 400)));
	}

	public static long[] gap(int g, long m, long n) {
		long[] arr = { 0, 0 };
		long prime1 = m;
		long prime2 = prime1 + 1;
		for (long i = m; i < n; i++) {
			if (prime(prime1)) {
				if (prime(prime2)) {
					if (prime2 - prime1 == g) {
						arr[0] = prime1;
						arr[1] = prime2;
						return arr;
					} else {
						prime1 = prime2;
						prime2 = prime1 + 1;
					}
				} else {
					prime2++;
				}
			} else {
				prime1++;
			}
		}
		return arr;
	}

	public static boolean prime(long number) {
		for (int i = 2; i <= (int) Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	// WORKING ZONE!!!!!!!!!!!!!!!!!!!!!

	public static long[] gap1(int g, long m, long n) {
		long[] arr = { 0, 0 };
		long prime1 = m;
		long prime2 = prime1 + 1;
		for (long i = m; i < n; i++) {
			// System.out.println(prime1);
			// System.out.println(prime(prime1));

			if (prime1(prime1)) {
				// System.out.println("prime1 " + prime1);
				// System.out.println("prime2 " + prime2);
				if (prime1(prime2)) {
					// System.out.println("------");
					// System.out.println("prime2 " + prime2);
					// System.out.println(
					// "prime 2 - prime 1 = " + (prime2 - prime1));
					if (prime2 - prime1 == g) {
						// System.out.println("*************");
						arr[0] = prime1;
						arr[1] = prime2;
						// System.out.println("ARR" + Arrays.toString(arr));
						return arr;
					} else {
						prime1 = prime2;
						prime2 = prime1 + 1;
						// System.out.println("AAAAAAAAAAAAAAAAAAAAAA");
					}
				} else {
					prime2++;
				}
			} else {
				prime1++;
			}
		}
		return arr;
	}

	public static boolean prime1(long number) {
		for (int i = 2; i <= (int) Math.sqrt(number); i++) {
			if (number % i == 0) {
				// System.out.println(i + " " + number + " not prime");
				return false;
			}
		}
		return true;
	}
}
