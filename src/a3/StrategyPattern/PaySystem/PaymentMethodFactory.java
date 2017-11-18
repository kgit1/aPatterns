package a3.StrategyPattern.PaySystem;

public class PaymentMethodFactory {

	public static PaymentMethod getPaymentMethod(String type) {

		switch (type) {
		case "credit":
			return createCreditCard();
		case "debit":
			return createDebitCard();
		case "cash":
			return createCash();
		}

		throw new IllegalArgumentException();
	}

	private static CreditCard createCreditCard() {
		return new CreditCard("John Doe", "4111111111111", "123", "01/22");
	}

	private static DebitCard createDebitCard() {
		return new DebitCard("John Doe", "511111111111", "234", "02/23");
	}

	private static Cash createCash() {
		return new Cash();
	}

}
