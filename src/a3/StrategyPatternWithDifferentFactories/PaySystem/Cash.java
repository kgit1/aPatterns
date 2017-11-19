package a3.StrategyPatternWithDifferentFactories.PaySystem;

public class Cash implements PaymentMethod {

	@Override
	public void pay(int cents) {

		System.out.println("Cash: Payed: " + cents + " cents");
	}

}
