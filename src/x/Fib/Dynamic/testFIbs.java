package x.Fib.Dynamic;

import java.util.concurrent.TimeUnit;

public class testFIbs {

	public static void main(String[] args) {

		// System.out.println(fibonachiBottomUp(26));
		//
		// System.out.println();
		// System.out.println(fibonachiRecursive(26));
		//
		// System.out.println();
		//
		// for (int i = 1; i < 27; i++) {
		// System.out.print(fibonachiRecursiveMemoized(i, new int[i + 1]) + " ");
		// }

		weightFibonachiBottomUp(10);
		weightFibonachiBottomUp(100);
		weightFibonachiBottomUp(1000);
		weightFibonachiBottomUp(10000);

		System.out.println("==========");

		weightFibonachiRecursiveMemoized(10);
		weightFibonachiRecursiveMemoized(100);
		weightFibonachiRecursiveMemoized(1000);
		weightFibonachiRecursiveMemoized(10000);

		System.out.println("==========");

		weightFibonachiRecursive(10);
		weightFibonachiRecursive(20);
		weightFibonachiRecursive(30);
		weightFibonachiRecursive(50);

		System.out.println();
		System.out.println("1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584");
		System.out.println("test - 46368");

	}

	private static void weightFibonachiBottomUp(int fibNumber) {
		long start = System.nanoTime();

		System.out.println(fibonachiBottomUp(fibNumber));

		long duration = System.nanoTime() - start;
		System.out.print(" " + (double) duration / 1000000000.0);
		System.out.print("(" + TimeUnit.SECONDS.convert(duration, TimeUnit.NANOSECONDS) + ")\n");
	}

	private static void weightFibonachiRecursive(int fibNumber) {
		long start = System.nanoTime();

		System.out.println(fibonachiRecursive(fibNumber));

		long duration = System.nanoTime() - start;
		System.out.print(" " + (double) duration / 1000000000.0);
		System.out.print("(" + TimeUnit.SECONDS.convert(duration, TimeUnit.NANOSECONDS) + ")\n");
	}

	private static void weightFibonachiRecursiveMemoized(int fibNumber) {
		long start = System.nanoTime();

		System.out.println(fibonachiRecursiveMemoized(fibNumber, new long[fibNumber + 1]));

		long duration = System.nanoTime() - start;
		System.out.print(" " + (double) duration / 1000000000.0);
		System.out.print("(" + TimeUnit.SECONDS.convert(duration, TimeUnit.NANOSECONDS) + ")\n");
	}

	private static long fibonachiBottomUp(int n) {
		long[] numbers = new long[n + 1];

		if (n > 0) {

			numbers[1] = 1;

		}
		if (n > 1) {

			numbers[2] = 1;

		}
		if (n > 2) {

			for (int i = 3; i < numbers.length; i++) {
				numbers[i] = numbers[i - 1] + numbers[i - 2];
			}

		}

		return numbers[n];
	}

	private static long fibonachiRecursive(int n) {
		long result = 0;

		if (n == 1 || n == 2) {

			return 1;

		} else if (n > 2) {

			result = fibonachiRecursive(n - 1) + fibonachiRecursive(n - 2);

		}

		return result;
	}

	private static long fibonachiRecursiveMemoized(int n, long[] memo) {

		long fibValue = 0;

		if (n == 0) {

			return 0;
		}
		if (n == 1) {

			return 1;
		} else if (memo[n] != 0) {
			return memo[n];
		} else {

			fibValue = fibonachiRecursiveMemoized(n - 1, memo) + fibonachiRecursiveMemoized(n - 2, memo);
			memo[n] = fibValue;
			return fibValue;
		}
	}
}
