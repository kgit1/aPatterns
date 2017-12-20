package x.Fib;

//A prime number is a natural number that has exactly two distinct natural 
//number divisors: 1 and itself.
//sieve of Erathosthenes - resheto eratosfena
//every not prime number - can be divided by one of previous prime numbers
public class PrimeNumberEratosthenes2 {

	public static void main(String[] args) {
		printArray(sieveOfErathosthenes(100));

	}

	public static boolean[] sieveOfErathosthenes(int max) {
		boolean[] flags = new boolean[max + 1];
		int prime = 3;
		init(flags);
		while (prime <= (int) Math.sqrt(max)) {
			crossOffNotPrime(flags, prime);
			prime = getNextPrime(flags, prime);
		}
		return flags;
	}

	// init 2 and all odd with true
	// only odd numbers except 2 can be prime
	// so initialize all odd numbers with true
	public static void init(boolean[] flags) {
		// 2 = true
		flags[2] = true;
		// every odd number = true
		for (int i = 3; i < flags.length; i += 2) {
			flags[i] = true;
		}
	}

	// cross off all not prime items
	// every non prime item is result of multiplication of prime number
	// so cross off all items which are results of multiplication of given prime
	public static void crossOffNotPrime(boolean[] flags, int prime) {
		for (int i = prime * prime; i < flags.length; i += prime) {
			flags[i] = false;
		}
	}

	// get next prime item
	public static int getNextPrime(boolean[] flags, int prime) {
		// add 1 to given prime
		int next = prime + 1;
		// if next marked false and still in range of array - add 1 to next and
		// check one more time
		while (next < flags.length && !flags[next]) {
			next++;
		}
		return next;
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
