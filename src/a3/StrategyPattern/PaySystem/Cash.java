package a3.StrategyPattern.PaySystem;

public class Cash implements PaymentMethod{

	@Override
	public void pay(int cents) {
		
		System.out.println("Payed " + cents + " cents using cash");		
	}

}
