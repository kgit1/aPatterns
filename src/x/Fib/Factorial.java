package x.Fib;

public class Factorial {
	// the factorial of a non-negative integer n, denoted by n!, is the product
	// of all positive integers less than or equal to n. For example,
	// 5!=5* 4* 3* 2* 1=120
	public static void main(String[] args) {
		System.out.println(factorial(10));

	}

	public static int factorial(int arg) {
		if (arg == 0) {
			System.out.println(arg);
			return 1;
		} else {
			System.out.println(arg);
			return arg * factorial(arg - 1);
		}
	}
}
