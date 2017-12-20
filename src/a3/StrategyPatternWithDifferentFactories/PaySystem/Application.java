package a3.StrategyPatternWithDifferentFactories.PaySystem;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class Application {

	static long startTime;
	static long endTime;

	public static void main(String[] args) {

		Bill bill = new Bill();

		bill.addLineItem(new LineItem("Milk", 200));
		bill.addLineItem(new LineItem("Butter", 300));
		bill.addLineItem(new LineItem("Sugar", 180));

		billPaySimpleFactory(bill);

		billPayReflectionFactory(bill);

		billPayPropertiesFactory(bill);

		billPayEnumFactory(bill);

	}

	private static void billPaySimpleFactory(Bill bill) {

		billSeparator("Factory");
		startTime();
		bill.pay(PaymentMethodFactory.getPaymentMethod("debit"));
		endTime();
		startTime();
		bill.pay(PaymentMethodFactory.getPaymentMethod("credit"));
		endTime();
		startTime();
		bill.pay(PaymentMethodFactory.getPaymentMethod("cash"));
		endTime();
		startTime();
		bill.pay(PaymentMethodFactory.getPaymentMethod("bitcoin"));
		endTime();
		startTime();
		bill.pay(PaymentMethodFactory.getPaymentMethod("androidPay"));
		endTime();
		startTime();
		bill.pay(PaymentMethodFactory.getPaymentMethod("applePay"));
		endTime();
	}

	private static void billPayReflectionFactory(Bill bill) {

		billSeparator("RunTimeFactory");
		startTime();
		String className = "a3.StrategyPatternWithDifferentFactories.PaySystem.DebitCard";
		reflectionFactoryPayment(bill, className);
		endTime();

		startTime();
		className = "a3.StrategyPatternWithDifferentFactories.PaySystem.CreditCard";
		reflectionFactoryPayment(bill, className);
		endTime();

		startTime();
		className = "a3.StrategyPatternWithDifferentFactories.PaySystem.Cash";
		reflectionFactoryPayment(bill, className);
		endTime();

		startTime();
		className = "a3.StrategyPatternWithDifferentFactories.PaySystem.Bitcoin";
		reflectionFactoryPayment(bill, className);
		endTime();

		startTime();
		className = "a3.StrategyPatternWithDifferentFactories.PaySystem.AndroidPay";
		reflectionFactoryPayment(bill, className);
		endTime();

		startTime();
		className = "a3.StrategyPatternWithDifferentFactories.PaySystem.ApplePay";
		reflectionFactoryPayment(bill, className);
		endTime();
	}

	private static void reflectionFactoryPayment(Bill bill, String className) {

		Optional<PaymentMethod> paymentMethod = RunTimeReflectionPaymentMethodFactory.getPaymentMethod(className);
		paymentMethod.ifPresent(method -> bill.pay(method));
	}

	private static void billPayPropertiesFactory(Bill bill) {

		billSeparator("PropertiesReflectionTimeFactory");
		startTime();
		Optional<PaymentMethod> paymentMethod = PropertiesReflectionPaymentMethodFactory.getPaymentMethod();
		paymentMethod.ifPresent(method -> bill.pay(method));
		endTime();
	}

	private static void billPayEnumFactory(Bill bill) {

		billSeparator("ENUMS");
		startTime();
		bill.pay(EnumFactoryPaymentMethod.CREDIT.getPaymentMethod());
		endTime();
		startTime();
		bill.pay(EnumFactoryPaymentMethod.DEBIT.getPaymentMethod());
		endTime();
		startTime();
		bill.pay(EnumFactoryPaymentMethod.BITCOIN.getPaymentMethod());
		endTime();
		startTime();
		bill.pay(EnumFactoryPaymentMethod.ANDROIDPAY.getPaymentMethod());
		endTime();
		startTime();
		bill.pay(EnumFactoryPaymentMethod.APPLEPAY.getPaymentMethod());
		endTime();
	}

	private static void billSeparator(String methodName) {

		StringBuilder separator = new StringBuilder("************************************************************");
		separator.append("\n" + methodName);
		int additionalAsterics = separator.length() - methodName.length() * 2;

		if (additionalAsterics > 0) {

			for (int i = 0; i < additionalAsterics - 1; i++) {

				separator.append("=");
			}
		}

		System.out.println(separator);
	}

	private static void startTime() {

		startTime = System.nanoTime();
	}

	private static void endTime() {

		endTime = System.nanoTime();
		long duration = endTime - startTime;
		double shortDuration = (double) duration / 1000000000.0;
		// double shortDuration = TimeUnit.SECONDS.convert(duration,
		// TimeUnit.NANOSECONDS);
		System.out.println(shortDuration + ": " + startTime + " - " + endTime + " = " + duration);

	}

}
