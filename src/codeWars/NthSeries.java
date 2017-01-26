package codeWars;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class NthSeries {

	public static void main(String[] args) {
		System.out.println(seriesSum(1));
		System.out.println("------------");
		System.out.println(seriesSum(2));
		System.out.println("------------");
		System.out.println(seriesSum1(5));
		System.out.println("------------");
		System.out.println(seriesSum1(6));
		System.out.println("------------");
		System.out.println(seriesSum1(7));
		System.out.println("------------");
		System.out.println(seriesSum2(8));
		System.out.println("------------");
		System.out.println(seriesSum2(9));
		System.out.println("------------");
		System.out.println(seriesSum2(10));
		System.out.println("------------");
		System.out.println(seriesSum2(58));

	}

	// mine
	public static String seriesSum(int n) {
		String s = "";
		float f = 0;
		for (int i = 0; i < n; i++) {
			f += 1.0 / (1 + 3 * i);
		}
		return s += BigDecimal.valueOf(f).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	// better
	public static String seriesSum1(int n) {
		double sum = 0;
		for (int i = 1; i < n * 3; i += 3) {
			sum += 1.0 / i;
		}
		return String.format("%.2f", sum);
	}

	// different
	public static String seriesSum2(int n) {
		DecimalFormat df = new DecimalFormat("0.00");
		double result = 0;
		for (int i = 1; i <= n; i++) {
			result = result + 1.0 / (3 * i - 2);
		}
		return df.format(result);
	}
}
