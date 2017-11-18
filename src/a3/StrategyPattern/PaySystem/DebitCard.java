package a3.StrategyPattern.PaySystem;

public class DebitCard extends Card {

	public DebitCard(String nameOnCard, String number, String cvv, String expirationDate) {
		super(nameOnCard, number, cvv, expirationDate);
	}

	@Override
	protected String getType() {
		return "debit";
	}

	@Override
	protected void executeTransaction(int cents) {
		System.out.println(cents + ": " + this.toString() + ": debit transaction executed");
	}

}
