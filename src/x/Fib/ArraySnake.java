package x.Fib;

public class ArraySnake {
	int n = 5;
	int[][] arr = new int[n][n];

	public int[][] arrayGenerateSnake() {

		for (int count = 0; count < n * n; count++) {
			for (int i = 0; i < n; i++) {

				if (i == 0 || i % 2 == 0) {
					for (int j = 0; j < n; j++) {
//						System.out.println(
//								"i: " + i + " j: " + j + " count: " + count);
						arr[i][j] = count++;
					}
				} else {
					for (int j = n - 1; j >= 0; j--) {
//						System.out.println(
//								"i: " + i + " j: " + j + " count: " + count);
						arr[i][j] = count++;
					}
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		ArraySnake aS = new ArraySnake();
		int[][] arr = aS.arrayGenerateSnake();
		for (int i = 0; i < aS.n; i++) {
			for (int j = 0; j < aS.n; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
}