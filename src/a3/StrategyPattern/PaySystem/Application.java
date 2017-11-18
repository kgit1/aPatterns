package a3.StrategyPattern.PaySystem;

import java.util.Optional;

public class Application {

	public static void main(String[] args) {

		Bill bill = new Bill();

		bill.addLineItem(new LineItem("Milk", 200));
		bill.addLineItem(new LineItem("Butter", 300));

		bill.pay(PaymentMethodFactory.getPaymentMethod("debit"));
		bill.pay(PaymentMethodFactory.getPaymentMethod("credit"));
		bill.pay(PaymentMethodFactory.getPaymentMethod("cash"));

		// Bitcoin bitcoin = new Bitcoin();
		// System.out.println(bitcoin.getClass().getName());

		Optional<PaymentMethod> paymentMethod1 = RunTimeReflectionPaymentMethodFactory
				.getPaymentMethod("a3.StrategyPattern.PaySystem.Bitcoin");
		paymentMethod1.ifPresent(method -> bill.pay(method));

		Optional<PaymentMethod> paymentMethod2 = RunTimeReflectionPaymentMethodFactory
				.getPaymentMethod("a3.StrategyPattern.PaySystem.AndroidPay");
		paymentMethod2.ifPresent(method -> bill.pay(method));

		Optional<PaymentMethod> paymentMethod3 = StaticReflectionPaymentMethodFactory.getPaymentMethod();
		paymentMethod3.ifPresent(method -> bill.pay(method));

	}

}
