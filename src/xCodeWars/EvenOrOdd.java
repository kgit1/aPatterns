package xCodeWars;

public class EvenOrOdd {

	public static void main(String[] args) {
		System.out.println(even_or_odd(6));
		System.out.println(even_or_odd(7));
		System.out.println("0 " + even_or_odd1(0));
		System.out.println(even_or_odd(0));
		System.out.println("6 " + even_or_odd1(6));
		System.out.println("7 " + even_or_odd1(7));
		System.out.println("8 " + even_or_odd1(8));
		System.out.println("9 " + even_or_odd1(9));
		System.out.println("10 " + even_or_odd1(10));
		System.out.println("11 " + even_or_odd1(11));

	}

	public static String even_or_odd(int number) {
		if (number % 2 == 0) {
			return "Even";
		}
		return "Odd";
	}

	public static String even_or_odd1(int number) {
		return (number % 2 == 0) ? "Even" : "Odd";
	}

}
