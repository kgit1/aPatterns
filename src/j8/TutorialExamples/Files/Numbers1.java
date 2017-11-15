package j8.TutorialExamples.Files;

public class Numbers1 {

	public static void main(String[] args) {

		testUnsignedInt();
		testUnsignedIntError();
		testMathExact();
	}

	// Java 8 adds additional support for working with unsigned numbers. Numbers in
	// Java had always been signed. Let's look at Integer for example:
	//
	// An int represents a maximum of 2³² binary digits. Numbers in Java are per
	// default signed, so the last binary digit represents the sign (0 = positive, 1
	// = negative).
	// Thus the maximum positive signed int is 2³¹ - 1 starting with the decimal
	// zero.
	//
	// You can access this value via Integer.MAX_VALUE:

	private static void testUnsignedInt() {

		try {

			Integer.parseUnsignedInt("-123", 10);

		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}

		long maxUnsignedInt = (1l << 32) - 1;
		System.out.println("(1l << 32) - 1: " + maxUnsignedInt);

		// As you can see it's now possible to parse the maximum possible unsigned
		// number 2³² - 1 into an integer. And you can also convert this number back
		// into
		// a string representing the unsigned number.
		String string = String.valueOf(maxUnsignedInt);
		int unsignedInt = Integer.parseUnsignedInt(string, 10);
		String string2 = Integer.toUnsignedString(unsignedInt, 10);
		System.out.println("Integer.toUnsignedString(unsignedInt, 10): " + string2);
	}

	private static void testUnsignedIntError() {

		long maxUnsignedInt = (1l << 32) - 1;
		String string = String.valueOf(maxUnsignedInt);

		// This wasn't possible before with parseInt as this example demonstrates, the
		// number
		// is not parseable as a signed int because it exceeds the maximum of 2³¹ - 1
		try {

			Integer.parseInt(string, 10);

		} catch (NumberFormatException e) {
			System.out.println("Error: could not parse signed int of " + maxUnsignedInt);
		}
	}

	// The utility class Math has been enhanced by a couple of new methods for
	// handling number overflows.
	private static void testMathExact() {

		System.out.println("Integer.MAX_VALUE: " + Integer.MAX_VALUE);
		System.out.println("Integer.MAX_VALUE + 1: " + (Integer.MAX_VALUE + 1));

		try {

			Math.addExact(Integer.MAX_VALUE, 1);

		} catch (ArithmeticException e) {
			System.out.println("Math.addExact(Integer.MAX_VALUE, 1): " + e.getMessage());
		}

		try {

			Math.toIntExact(Long.MAX_VALUE);

		} catch (ArithmeticException e) {
			System.out.println("Math.toIntExact(Long.MAX_VALUE): " + e.getMessage());
		}
	}

}
