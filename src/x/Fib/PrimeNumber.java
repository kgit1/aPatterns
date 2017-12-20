package x.Fib;

// A prime number (or a prime) is a natural number greater than 1 that has
// no positive divisors other than 1 and itself.
public class PrimeNumber {

	public static void main(String[] args) {
		// just counter for output formating and boundaries of cycle
		int counter = 0;
		for (int i = 1; counter < 12 * 14; i++) {
			// check if number prime
			if (prime(i)) {
				counter++;
				String s = "";
				// if number smaller than 10 - add 2 spaces
				if (i / 10 < 1) {
					s = "  ";
					// if smaller than 100 - add 1 space
				} else if (i / 100 < 1) {
					s = " ";
				}
				System.out.print(s + i + " ");
				// go next line if already 12 numbers here
				if (counter % 12 == 0) {
					System.out.println();
				}
			}
		}

	}

	// check number is it Prime
	public static boolean prime(int n) {
		// check if number is greater than 1
		if (n < 2) {
			return false;
		}
		int sqrt = (int) Math.sqrt(n);

		for (int i = 2; i <= sqrt; i++) {
			// check if number can be divide with any number bigger than 1 and
			// smaller than actual number
			// actually smaller than square root of this number
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
