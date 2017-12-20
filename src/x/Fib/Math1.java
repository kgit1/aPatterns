package x.Fib;

public class Math1 {
	public static void main(String[] args) {
		sumAndDif(3, 5);
		squareRootOfSumOfSquareDif(3, 5, 7, 2);
		System.out.print("Enter task number 1-21\n");
		// Scanner num = new Scanner(System.in);
		// int input = num.nextInt();
		// switch (input) {
		// case 1:
		// System.out.print("Task 1: ");
		// System.out.print("x + y and x - y \n");
		// System.out.print("Enter numbers x & y\n");
		//
		// int x;
		// int y;
		// x = num.nextInt();
		// y = num.nextInt();
		//
		// System.out.println("x" + " = " + x);
		// System.out.println("y" + " = " + y);
		// System.out.println("x" + " + " + "y" + " = " + x + " + " + y
		// + " = " + (x + y));
		// System.out.println("x" + " - " + "y" + " = " + x + " - " + y
		// + " = " + (x - y));
		// break;
		//
		// case 2:
		// System.out.print("Task 2: ");
		// System.out.println("\u221a((x1-x2)\u00b2 + (y1-y2)\u00b2)");
		// System.out.print("Enter numbers x1, x2, y1, y2\n");
		//
		// int x1;
		// int x2;
		// int y1;
		// int y2;
		// x1 = num.nextInt();
		// x2 = num.nextInt();
		// y1 = num.nextInt();
		// y2 = num.nextInt();
		// int n = 2;
		// int xA = x1 - x2;
		// int yA = y1 - y2;
		// double z = java.lang.Math.sqrt(java.lang.Math.pow(xA, n) +
		// java.lang.Math.pow(yA, n));
		//
		// System.out.println("x1" + " = " + x1);
		// System.out.println("x2" + " = " + x2);
		// System.out.println("y1" + " = " + y1);
		// System.out.println("y2" + " = " + y2);
		// System.out.println("\u221a((" + x1 + " - " + x2 + " )\u00b2 + ("
		// + y1 + " - " + y2 + ")\u00b2)" + " = " + "\u221a(("
		// + java.lang.Math.pow(xA, n) + " + " + java.lang.Math.pow(yA, n) + ")"
		// + " = "
		// + z);
		// break;
		//
		// case 3:
		// System.out.print("Task 3: ");
		// System.out.print("Ring's acreage\n");
		// System.out
		// .print("Enter radius of the ring and of the hole, R and r\n");
		//
		// int R;
		// int r;
		// R = num.nextInt();
		// r = num.nextInt();
		//
		// if (R <= r) {
		// System.out
		// .println("Radius of the hole cant be bigger or equal to the radios of
		// the ring");
		// } else {
		// System.out.println("Acreage of the ring S = "
		// + "\u03c0(R\u00b2 - r\u00b2) = " + "\u03c0("
		// + java.lang.Math.pow(R, 2) + " - " + java.lang.Math.pow(r, 2) + ") =
		// "
		// + (java.lang.Math.PI * (java.lang.Math.pow(R, 2) -
		// java.lang.Math.pow(r, 2))));
		// }
		// break;
		//
		// case 4:
		// System.out.print("Task 4: ");
		// System.out.print("Discount\n");
		// System.out.print("Enter cost of purchase\n");
		//
		// int moneyAmount;
		// double discount = 0.9;
		// moneyAmount = num.nextInt();
		//
		// if (moneyAmount < 1000) {
		// System.out.println("Discount only for sum 1000+");
		// } else {
		// System.out.println("Cost with discount = "
		// + (moneyAmount * discount));
		// }
		// break;
		//
		// case 5:
		// System.out.print("Task 5: ");
		// System.out.print("Even number\n");
		// System.out.print("Enter number\n");
		//
		// int numberC;
		//
		// numberC = num.nextInt();
		// int numberCheck = numberC % 2;
		// if (numberCheck > 0) {
		// System.out.println(numberC + " isn't an even number");
		// } else {
		// System.out.println(numberC + " is an even number");
		// }
		// break;
		//
		// case 6:
		// System.out.print("Task 6: ");
		// System.out.print("Divide by 3\n");
		// System.out.print("Enter number\n");
		//
		// int numberIn;
		// numberIn = num.nextInt();
		// int numberCheckBy3 = numberIn % 3;
		//
		// if (numberCheckBy3 > 0) {
		// System.out.println(numberIn + " can't be divided by 3");
		// } else {
		// System.out.println(numberIn + " can be divided by 3");
		// }
		// break;
		//
		// case 7:
		// System.out.print("Task 7: ");
		// System.out.print("Min/Max number\n");
		// System.out.print("Enter 3 numbers\n");
		//
		// int numberOne;
		// int numberTwo;
		// int numberThree;
		// numberOne = num.nextInt();
		// numberTwo = num.nextInt();
		// numberThree = num.nextInt();
		//
		// if (numberOne > numberTwo && numberOne > numberThree) {
		// System.out.println("Max = " + numberOne);
		// }
		// if (numberTwo > numberOne && numberTwo > numberThree) {
		// System.out.println("Max = " + numberTwo);
		// }
		// if (numberThree > numberOne && numberThree > numberTwo) {
		// System.out.println("Max = " + numberThree);
		// }
		// if (numberOne < numberTwo && numberOne < numberThree) {
		// System.out.println("Min = " + numberOne);
		// }
		// if (numberTwo < numberOne && numberTwo < numberThree) {
		// System.out.println("Min = " + numberTwo);
		// }
		// if (numberThree < numberOne && numberThree < numberTwo) {
		// System.out.println("Min = " + numberThree);
		// }
		// break;
		//
		// case 8:
		// System.out.print("Task 8: ");
		// System.out.print("Min -> Max 3 numbers\n");
		// System.out.print("Enter 3 numbers\n");
		//
		// int numberOneA;
		// int numberTwoA;
		// int numberThreeA;
		// int Max = 0;
		// int Middle = 0;
		// int Min = 0;
		// numberOneA = num.nextInt();
		// numberTwoA = num.nextInt();
		// numberThreeA = num.nextInt();
		//
		// if (numberOneA > numberTwoA && numberOneA > numberThreeA) {
		// Max = numberOneA;
		// }
		// if (numberTwoA > numberOneA && numberTwoA > numberThreeA) {
		// Max = numberTwoA;
		// }
		// if (numberThreeA > numberOneA && numberThreeA > numberTwoA) {
		// Max = numberThreeA;
		// }
		// if (numberOneA < numberTwoA && numberOneA < numberThreeA) {
		// Min = numberOneA;
		// }
		// if (numberTwoA < numberOneA && numberTwoA < numberThreeA) {
		// Min = numberTwoA;
		// }
		// if (numberThreeA < numberOneA && numberThreeA < numberTwoA) {
		// Min = numberThreeA;
		// }
		// if (numberOneA < Max && numberOneA > Min) {
		// Middle = numberOneA;
		// }
		// if (numberTwoA < Max && numberTwoA > Min) {
		// Middle = numberTwoA;
		// }
		// if (numberThreeA < Max && numberThreeA > Min) {
		// Middle = numberThreeA;
		// }
		// System.out.println(Min + " " + Middle + " " + Max);
		// break;
		//
		// case 9:
		// System.out.print("Task 9: ");
		// System.out.print("Check and Change two numbers\n");
		// System.out.print("Enter 2 numbers\n");
		//
		// int numberA;
		// int numberB;
		// int sumA = 0;
		// numberA = num.nextInt();
		// numberB = num.nextInt();
		//
		// if (numberA != numberB) {
		// sumA = numberA + numberB;
		//
		// } else {
		// numberA = 0;
		// numberB = 0;
		// }
		// System.out.println("numberA = " + sumA + "\nnumberB = " + sumA);
		// break;
		//
		// case 10:
		// System.out.print("Task 10: ");
		// break;
		//
		// case 11:
		// System.out.print("Task 11: ");
		// break;
		//
		// case 12:
		// System.out.print("Task 12: ");
		// break;
		//
		// case 13:
		// System.out.print("Task 13: factorail - n!\n");
		// System.out.print("Enter n\n");
		//
		// int nFactorial = num.nextInt();
		// int resultFactorial = 1;
		//
		// while (nFactorial > 1) {
		// resultFactorial *= nFactorial;
		// nFactorial--;
		// }
		// System.out.println(resultFactorial);
		// break;
		//
		// case 14:
		// System.out.print("Task 14: multiplication");
		// System.out.print("Enter multiplier n\n");
		//
		// int nMul = num.nextInt();
		// int resultMul = 1;
		// int iMul = 1;
		//
		// while (nMul > iMul) {
		// resultMul *= (1 + (1 / java.lang.Math.pow(iMul, 2)));
		// iMul++;
		// }
		// System.out.println(resultMul);
		// break;
		//
		// case 15:
		// System.out.print("Task 15: multiplication (sin)");
		// System.out.print("Enter multiplier n\n");
		//
		// int nMulS = num.nextInt();
		// double resultMulS = 0;
		// int iMulS = 1;
		//
		// if ((nMulS >= 1) && (nMulS <= 100)) {
		// while (nMulS > iMulS) {
		// double iS = 0;
		// iS += java.lang.Math.sin(iMulS);
		// resultMulS += (1 / iS);
		// iMulS++;
		// }
		// System.out.println(resultMulS);
		// }
		// break;
		//
		// case 16:
		// System.out.print("Task 16: 1 > 100 sum equal mult\n");
		//
		// double iEqual = 1;
		//
		// while (iEqual < 99) {
		// iEqual++;
		// double jEqual = 1 + 1 / (iEqual - 1);
		// System.out.println(iEqual + " " + jEqual);
		//
		// }
		// break;
		//
		// case 17:
		// System.out
		// .print("Task 17: a=b\u00b2+c\u00b2+d\u00b2, for 1 to n\n");
		// System.out.println("Enter n");
		// int nNat = num.nextInt();
		//
		// for (int aNat = 1; aNat < nNat; aNat++) {
		// for (int bNat = 1; bNat < nNat; bNat++) {
		// for (int cNat = 1; cNat < nNat; cNat++) {
		// for (int dNat = 1; dNat < nNat; dNat++) {
		// if (aNat == ((java.lang.Math.pow(bNat, 2))
		// + (java.lang.Math.pow(cNat, 2)) + (java.lang.Math.pow(dNat, 2)))) {
		// System.out.println(aNat + " = " + bNat
		// + "\u00b2" + " + " + cNat + "\u00b2"
		// + " + " + dNat + "\u00b2");
		// }
		// }
		// }
		// }
		// }
		// break;
		//
		// case 18:
		// System.out.print("Task 18: Even calc for n\n");
		// System.out.println("Enter n");
		// int nCalc = num.nextInt();
		// int nCalcChek = 0;
		//
		// while (nCalc >= 1) {
		// if ((nCalc % 2) > 0) {
		// nCalcChek++;
		// }
		// nCalc--;
		// }
		// System.out.println(nCalcChek);
		// break;
		//
		// case 19:
		// System.out.print("Task 19: MiddleMath fo a-b\n");
		// System.out.println("Enter a and b");
		//
		// int nAMiddleMath = num.nextInt();
		// int nBMiddleMath = num.nextInt();
		// int iMiddleMath = 1;
		// double sumMiddleMath = nAMiddleMath;
		//
		// while (nAMiddleMath < nBMiddleMath) {
		// iMiddleMath++;
		// nAMiddleMath++;
		// sumMiddleMath += nAMiddleMath;
		// }
		// System.out.println(sumMiddleMath / iMiddleMath);
		// break;
		// case 20:
		// System.out.print("Task 20: multiplication table 2-9\n");
		//
		// int multTable = 2;
		// for (int i = 2; i < 10; i++) {
		// for (int j = 2; j < 10; j++) {
		// multTable = i * j;
		// System.out.println(i + " X " + j + " = " + multTable);
		// }
		// }
		// break;
		//
		// case 21:
		// System.out.print("Task 21: Matrix\n");
		//
		// char charA = '\u25A1';
		// char charB = '\u25A0';
		//
		// for (int i = 0; i < 8; i++) {
		// for (int j = 0; j < 15; j++) {
		// System.out.print(charA);
		// }
		// System.out.print("\n");
		// }
		// System.out.print("\n");
		//
		//
		// for (int i = 0; i < 8; i++) {
		// for (int j = 0; j < 3; j++) {
		// System.out.print(charA);
		// }
		// for (int j = 0; j < 3; j++) {
		// System.out.print(charB);
		// }
		// for (int j = 0; j < 3; j++) {
		// System.out.print(charA);
		// }
		// for (int j = 0; j < 3; j++) {
		// System.out.print(charB);
		// }
		// for (int j = 0; j < 3; j++) {
		// System.out.print(charA);
		// }
		// System.out.print("\n");
		// }
		// System.out.print("\n");
		//
		//
		// for (int i = 0; i < 2; i++) {
		// for (int j = 0; j < 14; j++) {
		// System.out.print(charA);
		// }
		// System.out.print("\n");
		// }
		// for (int i = 0; i < 2; i++) {
		// for (int j = 0; j < 14; j++) {
		// System.out.print(charB);
		// }
		// System.out.print("\n");
		// }
		// for (int i = 0; i < 2; i++) {
		// for (int j = 0; j < 14; j++) {
		// System.out.print(charA);
		// }
		// System.out.print("\n");
		// }
		// for (int i = 0; i < 2; i++) {
		// for (int j = 0; j < 14; j++) {
		// System.out.print(charB);
		// }
		// System.out.print("\n");
		// }
		// for (int i = 0; i < 2; i++) {
		// for (int j = 0; j < 14; j++) {
		// System.out.print(charA);
		// }
		// System.out.print("\n");
		// }
		// System.out.print("\n");
		//
		//
		//
		// for (int i = 0; i < 4; i++) {
		// for (int j = 0; j < 7; j++) {
		// System.out.print(charA);
		// }
		// for (int j = 0; j < 7; j++) {
		// System.out.print(charB);
		// }
		// System.out.print("\n");
		// }
		// for (int i = 0; i < 4; i++) {
		// for (int j = 0; j < 7; j++) {
		// System.out.print(charB);
		// }
		// for (int j = 0; j < 7; j++) {
		// System.out.print(charA);
		// }
		// System.out.print("\n");
		// }
		// System.out.print("\n");
		//
		//
		// for (int i = 0; i < 4; i++) {
		// for (int j = 0; j < 7; j++) {
		// System.out.print(charB);
		// }
		// for (int j = 0; j < 7; j++) {
		// System.out.print(charA);
		// }
		// System.out.print("\n");
		// }
		// for (int i = 0; i < 4; i++) {
		// for (int j = 0; j < 7; j++) {
		// System.out.print(charA);
		// }
		// for (int j = 0; j < 7; j++) {
		// System.out.print(charB);
		// }
		// System.out.print("\n");
		// }
		// System.out.print("\n");
		//
		//
		//
		// int max = 7;
		//
		// for (int i = 0; i < max; i++) {
		// String white = "\u25A1";
		// String black = "\u25A0";
		// for (int j = 1; j < max - i; j++)
		// white += "\u25A1";
		// for (int j = 1; j < 2 * i + 1; j++)
		// black += "\u25A0";
		// for (int j = 1; j < max - i; j++)
		// white += "\u25A1";
		// System.out.println(white + black);
		// }
		// System.out.print("\n");
		//
		// for (int i = 0; i < max; i++) {
		// String white = "\u25A1";
		// String black = "\u25A0";
		// for (int j = 1; j < max - i; j++)
		// black += "\u25A0";
		// for (int j = 1; j < 2 * i + 1; j++)
		// white += "\u25A1";
		// for (int j = 1; j < max - i; j++)
		// black += "\u25A0";
		// System.out.println(black + white);
		// }
		// System.out.print("\n");
		//
		// for (int i = 0; i < max; i++) {
		// String white = "\u25A1";
		// String black = "\u25A0";
		// for (int j = 1; j < max - i; j++)
		// white += "\u25A1";
		// for (int j = 1; j < 2 * i + 1; j++)
		// black += "\u25A0";
		// for (int j = 1; j < max - i; j++)
		// white += "\u25A1";
		// System.out.println(black + white);
		// }
		// System.out.print("\n");
		//
		// for (int i = 0; i < max; i++) {
		// String white = "\u25A1";
		// String black = "\u25A0";
		// for (int j = 1; j < max - i; j++)
		// black += "\u25A0";
		// for (int j = 1; j < 2 * i + 1; j++)
		// white += "\u25A1";
		// for (int j = 1; j < max - i; j++)
		// black += "\u25A0";
		// System.out.println(white + black);
		// }
		// System.out.print("\n");
		//
		//
		// break;
		//
		// default:
		// System.out.print("ERROR: Wrong task number! Programm terminated\n");
		// break;
		// }
		// num.close();
		// }
	}

	public static void sumAndDif(int x, int y) {
		System.out.println("x" + " = " + x);
		System.out.println("y" + " = " + y);
		System.out.println(
				"x" + " + " + "y" + " = " + x + " + " + y + " = " + (x + y));
		System.out.println(
				"x" + " - " + "y" + " = " + x + " - " + y + " = " + (x - y));
	}

	public static void squareRootOfSumOfSquareDif(int x1, int x2, int y1,
			int y2) {
		int n = 2;
		int xA = x1 - x2;
		int yA = y1 - y2;
		double z = java.lang.Math
				.sqrt(java.lang.Math.pow(xA, n) + java.lang.Math.pow(yA, n));

		System.out.println("x1" + " = " + x1);
		System.out.println("x2" + " = " + x2);
		System.out.println("y1" + " = " + y1);
		System.out.println("y2" + " = " + y2);
		System.out.println("\u221a((" + x1 + " - " + x2 + " )\u00b2 + (" + y1
				+ " - " + y2 + ")\u00b2)" + " = " + "\u221a("
				+ java.lang.Math.pow(xA, n) + " + " + java.lang.Math.pow(yA, n)
				+ ")" + " = " + z);
	}

}
