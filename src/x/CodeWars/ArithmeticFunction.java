package x.CodeWars;

public class ArithmeticFunction {
	// Given two numbers and an arithmetic operator (the name of it, as a
	// string), return the result of the two numbers having that operator used
	// on them.
	//
	// The four operators are "add", "subtract", "divide", "multiply".
	//
	// All inputs will be integers, and a will always be the first number in the
	// operation, and b always the second.
	//
	// A few examples:
	//
	// arithmetic(5, 2, "add") should return 7
	//
	// arithmetic(5, 2, "subtract") should return 3
	//
	// arithmetic(5, 2, "multiply") should return 10
	//
	// arithmetic(5, 2, "divide") should return 2.5
	//
	// Try to do it without using if (or switch) statements!

	public static float arithmetic(int a, int b, String operator) {
		float result = 0;
		switch (operator) {
		case "add":
			result = a + b;
			break;
		case "subtract":
			result = a - b;
			break;
		case "multiply":
			result = a * b;
			break;
		case "divide":
			result = a / b;
			break;
		default:
			System.out.println(operator + " is wrong operator");
			break;
		}
		return result;
	}

}
