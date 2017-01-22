package code;

public class Money {

	public static void main(String[] args) {
		int i = calculateYears(1000, 0.05, 0.18, 1100);
		System.out.println(i);
//		i = calculateYears(1000, 0.01625, 0.18, 1200);
//		System.out.println(i);
//		i = calculateYears(1000, 0.05, 0.18, 1000);
//		System.out.println(i);
//		System.out.println(1000 * 0.05 - 1000 * 0.05 * 0.18);
//		System.out.println(1000 * 0.01625);
//		System.out.println( 1000 * 0.01625 * 0.18);
//		System.out.println(1000 * 0.01625- 1000 * 0.01625 * 0.18);
//		System.out.println(200/13.325);
	}

	public static int calculateYears(double principal, double interest,
			double tax, double desired) {
		int y = 0;
		double sum = principal;
		while (sum < desired) {
			sum += principal * interest - principal * interest * tax;
			System.out.println("sum " + sum);
			y++;
		}
		return y;
	}
}
