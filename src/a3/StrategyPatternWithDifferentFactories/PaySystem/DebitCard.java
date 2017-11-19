package a3.StrategyPatternWithDifferentFactories.PaySystem;

public class DebitCard extends Card {

	private static String nameOnCard = "John Doe";
	private static String number = "511111111111";
	private static String cvv = "234";
	private static String expirationDate = "02/23";

	public DebitCard() {
		super(DebitCard.nameOnCard, DebitCard.number, DebitCard.cvv, DebitCard.expirationDate);
	}

	@Override
	protected String getType() {
		return "debit";
	}

	@Override
	protected void executeTransaction(int cents) {
		System.out.println(getClass().getSimpleName() + ": transaction executed: Payed " + cents + ", " + this.toString());
	}

}
