package a3.StrategyPatternWithDifferentFactories.PaySystem;

public class AndroidPay implements PaymentMethod{

	@Override
	public void pay(int cents) {
		
		System.out.println("AndroidPay: Payed: " + cents + " cents");	
		
	}

}
