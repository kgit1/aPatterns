package a3.StrategyPattern.PaySystem;

public class AndroidPay implements PaymentMethod{

	@Override
	public void pay(int cents) {
		
		System.out.println("Payed " + cents + " cents using AndroidPay");	
		
	}

}
