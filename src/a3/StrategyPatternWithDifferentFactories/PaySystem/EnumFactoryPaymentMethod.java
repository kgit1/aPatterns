package a3.StrategyPatternWithDifferentFactories.PaySystem;

public enum EnumFactoryPaymentMethod {

	DEBIT("debit") {
		@Override
		public PaymentMethod getPaymentMethod() {
			return new DebitCard();
		}

	},
	CREDIT("credit") {
		@Override
		public PaymentMethod getPaymentMethod() {
			return new CreditCard("Enum John Doe", "4111111111111", "123", "01/22");
		}

	},
	BITCOIN("bitcoin") {
		@Override
		public PaymentMethod getPaymentMethod() {
			return new Bitcoin();
		}

	},
	ANDROIDPAY("androidPay") {
		@Override
		public PaymentMethod getPaymentMethod() {
			return new AndroidPay();
		}

	},
	APPLEPAY("applePay") {
		@Override
		public PaymentMethod getPaymentMethod() {
			return new ApplePay();
		}

	};

	private String type;

	private EnumFactoryPaymentMethod(String type) {

		this.type = type;

	}

	public abstract PaymentMethod getPaymentMethod();

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Type code -> " + type;
	}

}
