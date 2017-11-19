package a3.StrategyPatternWithDifferentFactories.PaySystem;

public class ApplePay implements PaymentMethod {

	@Override
	public void pay(int cents) {

		System.out.println("ApplePay: Payed : " + cents + " cents");
	}

}
