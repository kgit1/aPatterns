package x.Fib;

import java.util.Random;

public class Start {
	public static void main(String[] args) {

		int arr2[] = new int[5];
		arr2[0] = 150;
		arr2[1] = 32;
		arr2[2] = 1050;
		arr2[3] = -18;
		arr2[4] = 0;

		Random r = new Random();

		int[][] mass = new int[5][10];

		for (int i = 0; i < mass.length; i++) {
			for (int j = 0; j < mass[i].length; j++) {
				mass[i][j] = new Random().nextInt(50);
				System.out.print(mass[i][j] + " ");

			}
			System.out.println();
		}

		int[][] mx = { { 5, 8, 6 }, { 1, 5, 8, 9, 9 },
				{ 20, 5, 7, 4, 0, 5, 8, 7 } };

	}
}
