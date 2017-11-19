package a3.StrategyPatternWithDifferentFactories.PaySystem;

public class Bitcoin implements PaymentMethod {

	@Override
	public void pay(int cents) {

		System.out.println("Bitcoin: Payed: " + cents + " cents");
	}

}
