package x.Fib;

import java.util.Random;
import java.util.Scanner;

public class Math2 {

	public static void main(String[] args) {

		Scanner num = new Scanner(System.in);
		Random random = new Random();
		int newNumber;
		int input = -1;
		while (input != 0) {
			System.out.print(
					"Enter task number 1-10\n\t\t\t or 0 if u wanna quit\n");
			input = num.nextInt();
			switch (input) {

			case 1:
				System.out.print("Task 1\n");
				int Size = 1;
				int calcNumber = 20;

				for (int i = 0; i < calcNumber; i++) {
					if ((i % 2) == 0) {
						Size++;
					}
				}

				int[] array = new int[Size];
				int counter = 0;
				for (int i = 0; i <= calcNumber; i++) {
					if ((i % 2) == 0) {
						array[counter] = i;
						counter++;
					}
				}

				for (int i = 1; i < Size; i++) {
					System.out.print(array[i] + " ");
				}
				System.out.println();
				for (int i = 1; i < Size; i++) {
					System.out.println(array[i]);
				}
				break;

			case 2:
				System.out.print("Task 2\n");
				int SizeTwo = 1;
				int calcNumberTwo = 99;

				for (int i = 0; i < calcNumberTwo; i++) {

					if ((i % 2) > 0) {
						SizeTwo++;
						System.out.println(SizeTwo);
					}
				}

				int[] arrayTwo = new int[SizeTwo];
				int counterTwo = 0;
				for (int i = 0; i <= calcNumberTwo; i++) {
					if ((i % 2) > 0) {
						arrayTwo[counterTwo] = i;
						counterTwo++;
					}
				}

				for (int i = 0; i < SizeTwo; i++) {
					System.out.print(arrayTwo[i] + " ");
				}
				System.out.println();
				for (int i = SizeTwo - 1; i >= 0; i--) {
					System.out.print(arrayTwo[i] + " ");
				}
				break;

			case 3:
				System.out.print("Task 3\n");
				int SizeThree = 15;
				int[] arrayThree = new int[SizeThree];

				for (int i = 0; i < SizeThree; i++) {
					newNumber = random.nextInt(10);
					arrayThree[i] = newNumber;
				}

				for (int i = 0; i < SizeThree; i++) {
					System.out.print(arrayThree[i] + " ");
				}
				System.out.println();

				int counterThree = 0;
				for (int i = 0; i < SizeThree; i++) {
					if ((arrayThree[i] % 2) > 0) {
						counterThree++;
					}
				}
				System.out.println(counterThree + " not even numbers in array");
				break;

			case 4:
				System.out.print("Task 4\n");
				int SizeFour = 8;
				int[] arrayFour = new int[SizeFour];

				for (int i = 0; i < SizeFour; i++) {
					newNumber = random.nextInt(9) + 1;
					arrayFour[i] = newNumber;
				}

				for (int i = 0; i < SizeFour; i++) {
					System.out.print(arrayFour[i] + " ");
				}
				System.out.println();

				for (int i = 0; i < SizeFour; i++) {
					if ((i % 2) == 0) {
						arrayFour[i] = 0;
					}
				}

				for (int i = 0; i < SizeFour; i++) {
					System.out.print(arrayFour[i] + " ");
				}
				System.out.println();
				break;

			case 5:
				System.out.print("Task 5\n");
				int SizeArrayFive = 5;
				int[] arrayFiveOne = new int[SizeArrayFive];
				int[] arrayFiveTwo = new int[SizeArrayFive];

				for (int i = 0; i < SizeArrayFive; i++) {
					newNumber = random.nextInt(6);
					arrayFiveOne[i] = newNumber;
				}

				System.out.print("Array One ");
				for (int i = 0; i < SizeArrayFive; i++) {
					System.out.print(arrayFiveOne[i] + " ");
				}
				System.out.println();

				int sumArrayFiveOne = 0;
				int counterArrayFiveOne = 0;
				double averageArrayFiveOne;
				for (int i = 0; i < SizeArrayFive; i++) {
					sumArrayFiveOne += arrayFiveOne[i];
					counterArrayFiveOne++;
				}
				averageArrayFiveOne = (double) sumArrayFiveOne
						/ (double) counterArrayFiveOne;
				System.out.println("Sum of array members for array One "
						+ sumArrayFiveOne);
				System.out.println(
						"Number of array members " + counterArrayFiveOne);
				System.out.println(
						"Average for array One " + averageArrayFiveOne);
				System.out.println();

				for (int i = 0; i < SizeArrayFive; i++) {
					newNumber = random.nextInt(6);
					arrayFiveTwo[i] = newNumber;
				}

				System.out.print("Array Two ");
				for (int i = 0; i < SizeArrayFive; i++) {
					System.out.print(arrayFiveTwo[i] + " ");
				}
				System.out.println();

				int sumArrayFiveTwo = 0;
				int counterArrayFiveTwo = 0;
				double averageArrayFiveTwo;
				for (int i = 0; i < SizeArrayFive; i++) {
					sumArrayFiveTwo += arrayFiveTwo[i];
					counterArrayFiveTwo++;
				}
				averageArrayFiveTwo = (double) sumArrayFiveTwo
						/ (double) counterArrayFiveTwo;
				System.out.println(
						"Sum of array members for array - " + sumArrayFiveTwo);
				System.out.println(
						"Number of array members - " + counterArrayFiveTwo);
				System.out
						.println("Average for array - " + averageArrayFiveTwo);
				System.out.println();

				if (averageArrayFiveTwo == averageArrayFiveOne) {
					System.out.println(
							averageArrayFiveOne + " = " + averageArrayFiveTwo
									+ " Array One average = Array Two average");
				}
				if (averageArrayFiveOne > averageArrayFiveTwo) {
					System.out.println(
							averageArrayFiveOne + " > " + averageArrayFiveTwo
									+ " Array One average > Array Two average");
				}
				if (averageArrayFiveTwo > averageArrayFiveOne) {
					System.out.println(
							averageArrayFiveTwo + " > " + averageArrayFiveOne
									+ " Array Two average > Array One average");
				}
				break;

			case 6:
				System.out.print("Task 6\n");
				int SizeSix = 4;
				int[] arraySix = new int[SizeSix];

				for (int i = 0; i < SizeSix; i++) {
					newNumber = random.nextInt(99) + 10;
					arraySix[i] = newNumber;
				}

				for (int i = 0; i < SizeSix; i++) {
					System.out.print(arraySix[i] + " ");
				}
				System.out.println();

				int tmpSix = 0;
				for (int i = 0; i < SizeSix; i++) {

					int arraySixChek;
					arraySixChek = arraySix[i];
					if (arraySixChek > tmpSix) {
						tmpSix = arraySixChek;
					} else {
						System.out.println("Array isnt increasing sequence");
						break;
					}
					if (i == 3) {
						System.out.println("Array is increasing sequence");
						break;
					}
				}

				System.out.println();
				break;

			case 7:
				System.out.print("Task 7\n");
				int SizeSeven = 20;
				int[] arraySeven = new int[SizeSeven];
				arraySeven[0] = 1;
				arraySeven[1] = 1;

				for (int i = 2; i < SizeSeven; i++) {
					arraySeven[i] = arraySeven[i - 1] + arraySeven[i - 2];
				}

				for (int i = 0; i < SizeSeven; i++) {
					System.out.print(arraySeven[i] + " ");
				}
				break;

			case 8:
				System.out.print("Task 8\n");
				int SizeEight = 12;
				int[] arrayEight = new int[SizeEight];

				for (int i = 0; i < SizeEight;) {
					newNumber = random.nextInt();
					if ((newNumber > -16) && (newNumber < 16)) {
						arrayEight[i] = newNumber;
						i++;
					}
				}

				for (int i = 0; i < SizeEight; i++) {
					System.out.print(arrayEight[i] + " ");
				}
				System.out.println();
				int iMax = 0;
				int tmpEight = 0;
				for (int i = 0; i < SizeEight; i++) {
					if (arrayEight[i] >= tmpEight) {
						tmpEight = arrayEight[i];
						iMax = i;
					}
				}
				System.out.print(arrayEight[iMax] + "[" + iMax + "]");
				System.out.println();
				break;

			case 9:
				System.out.print("Task 9\n");
				int SizeArrayNine = 10;
				int[] arrayNineOne = new int[SizeArrayNine];
				int[] arrayNineTwo = new int[SizeArrayNine];
				double[] arrayNineThree = new double[SizeArrayNine];

				for (int i = 0; i < SizeArrayNine; i++) {
					newNumber = random.nextInt(9) + 1;
					arrayNineOne[i] = newNumber;
				}

				System.out.print("Array One ");
				for (int i = 0; i < SizeArrayNine; i++) {
					System.out.print(arrayNineOne[i] + " ");
				}
				System.out.println();

				for (int i = 0; i < SizeArrayNine; i++) {
					newNumber = random.nextInt(9) + 1;
					arrayNineTwo[i] = newNumber;
				}

				System.out.print("Array Two ");
				for (int i = 0; i < SizeArrayNine; i++) {
					System.out.print(arrayNineTwo[i] + " ");
				}
				System.out.println();

				for (int i = 0; i < SizeArrayNine; i++) {
					newNumber = random.nextInt(9) + 1;
					arrayNineThree[i] = (double) arrayNineOne[i]
							/ (double) arrayNineTwo[i];
				}

				System.out.print("Array Three ");
				for (int i = 0; i < SizeArrayNine; i++) {
					System.out.print(arrayNineThree[i] + " ");
				}
				System.out.println();

				int countNine = 0;
				for (int i = 0; i < SizeArrayNine; i++) {
					if (((double) arrayNineOne[i]
							% (double) arrayNineTwo[i]) == 0) {
						countNine++;
					}
				}
				System.out.print("Amount of integer numbers in array Three = "
						+ countNine);
				System.out.println();

				break;

			case 10:
				System.out.print("Task 10\n");
				int SizeTen = 11;
				int[] arrayTen = new int[SizeTen];
				int Max = 1;
				int Min = -1;

				for (int i = 0; i < SizeTen; i++) {
					newNumber = Min + (int) (Math.random() * ((Max - Min) + 1));
					arrayTen[i] = newNumber;
				}

				for (int i = 0; i < SizeTen; i++) {
					System.out.print(arrayTen[i] + " ");
				}

				int countA = 0;
				int countB = 0;
				int countC = 0;
				for (int i = 0; i < SizeTen; i++) {
					if (arrayTen[i] == -1) {
						countA++;
					}
					if (arrayTen[i] == 0) {
						countB++;
					}
					if (arrayTen[i] == 1) {
						countC++;
					}
				}

				if ((countA > countB) && (countA > countC)) {
					System.out.println("often number is -1");
				}
				if ((countB > countA) && (countB > countC)) {
					System.out.println("often number is 0");
				}
				if ((countC > countA) && (countC > countB)) {
					System.out.println("often number is 1");
				}

				break;

			}
			// num.close();
		}
	}
}
