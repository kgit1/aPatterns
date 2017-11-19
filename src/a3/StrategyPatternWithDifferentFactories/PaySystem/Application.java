package a3.StrategyPatternWithDifferentFactories.PaySystem;

import java.util.Optional;

public class Application {

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
		bill.pay(PaymentMethodFactory.getPaymentMethod("debit"));
		bill.pay(PaymentMethodFactory.getPaymentMethod("credit"));
		bill.pay(PaymentMethodFactory.getPaymentMethod("cash"));
	}

	private static void billPayReflectionFactory(Bill bill) {

		billSeparator("RunTimeFactory");
		String className = "a3.StrategyPatternWithDifferentFactories.PaySystem.DebitCard";
		reflectionFactoryPayment(bill, className);

		className = "a3.StrategyPatternWithDifferentFactories.PaySystem.CreditCard";
		reflectionFactoryPayment(bill, className);

		className = "a3.StrategyPatternWithDifferentFactories.PaySystem.Cash";
		reflectionFactoryPayment(bill, className);

		className = "a3.StrategyPatternWithDifferentFactories.PaySystem.Bitcoin";
		reflectionFactoryPayment(bill, className);

		className = "a3.StrategyPatternWithDifferentFactories.PaySystem.AndroidPay";
		reflectionFactoryPayment(bill, className);

		className = "a3.StrategyPatternWithDifferentFactories.PaySystem.ApplePay";
		reflectionFactoryPayment(bill, className);
	}

	private static void reflectionFactoryPayment(Bill bill, String className) {

		Optional<PaymentMethod> paymentMethod = RunTimeReflectionPaymentMethodFactory.getPaymentMethod(className);
		paymentMethod.ifPresent(method -> bill.pay(method));
	}

	private static void billPayPropertiesFactory(Bill bill) {

		billSeparator("PropertiesReflectionTimeFactory");
		Optional<PaymentMethod> paymentMethod = PropertiesReflectionPaymentMethodFactory.getPaymentMethod();
		paymentMethod.ifPresent(method -> bill.pay(method));
	}

	private static void billPayEnumFactory(Bill bill) {

		billSeparator("ENUMS");
		bill.pay(EnumFactoryPaymentMethod.CREDIT.getPaymentMethod());
		bill.pay(EnumFactoryPaymentMethod.DEBIT.getPaymentMethod());
		bill.pay(EnumFactoryPaymentMethod.BITCOIN.getPaymentMethod());
		bill.pay(EnumFactoryPaymentMethod.ANDROIDPAY.getPaymentMethod());
		bill.pay(EnumFactoryPaymentMethod.APPLEPAY.getPaymentMethod());
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

}
