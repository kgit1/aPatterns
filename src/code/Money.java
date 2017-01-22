package code;

public class Money {

	public static void main(String[] args) {
		int i = calculateYearsRefactored(1000, 0.05, 0.18, 1100);
		System.out.println(i);
		i = calculateYearsRefactored(1000, 0.01625, 0.18, 1200);
		System.out.println(i);
		i = calculateYearsRefactored(1000, 0.05, 0.18, 1000);
		System.out.println(i);
	}

	public static int calculateYears(double principal, double interest,
			double tax, double desired) {
		int y = 0;
		double sum = principal;
		while (sum < desired) {
			sum += sum * interest - sum * interest * tax;
			y++;
		}
		return y;
	}

	public static int calculateYearsRefactored(double principal,
			double interest, double tax, double desired) {
		int years = 0;
		while (principal < desired) {
			principal += principal * interest * (1 - tax);
			years++;
		}
		return years;
	}
}
