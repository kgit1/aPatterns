package a3.StrategyPattern.PaySystem;

public class ApplePay implements PaymentMethod {

	@Override
	public void pay(int cents) {

		System.out.println("Payed : " + cents + " cents using ApplePay");
	}

}
