package x.Fib;

public class EvenOrOdd {

	// An integer is even if it is 'evenly divisible' by two (the old-fashioned
	// term "evenly divisible" is now almost always shortened to "divisible")
	// and odd if it is not even
	public static void main(String[] args) {
		System.out.println("455 is even = " + isEven(455));
		System.out.println("455 is even = " + isOdd(455));

	}

	public static boolean isEven(int k) {
		if (k == 0) {
			return true;
		} else {
			return isOdd(k - 1);
		}
	}

	public static boolean isOdd(int k) {
		if (k == 0) {
			return false;
		} else {
			return isEven(k - 1);
		}
	}
}
