package a3.StrategyPatternWithDifferentFactories.PaySystem;

public class PaymentMethodFactory {

	public static PaymentMethod getPaymentMethod(String type) {

		switch (type) {
		case "credit":
			return createCreditCard();
		case "debit":
			return createDebitCard();
		case "cash":
			return createCash();
		case "bitcoin":
			return createBitcoin();
		case "androidPay":
			return createAndroidPay();
		case "applePay":
			return createApplePay();
		}

		throw new IllegalArgumentException();
	}

	private static CreditCard createCreditCard() {
		return new CreditCard("John Doe", "4111111111111", "123", "01/22");
	}

	private static DebitCard createDebitCard() {
		return new DebitCard();
	}

	private static Cash createCash() {
		return new Cash();
	}

	private static PaymentMethod createBitcoin() {
		return new Bitcoin();
	}

	private static PaymentMethod createAndroidPay() {
		return new AndroidPay();
	}

	private static PaymentMethod createApplePay() {
		return new ApplePay();
	}

}
