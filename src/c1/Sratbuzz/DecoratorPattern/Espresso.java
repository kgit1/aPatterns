package c1.Sratbuzz.DecoratorPattern;

public class Espresso extends Beverage {

	public Espresso() {
		description = "Espresso - $1.99";
	}

	@Override
	public double cost() {
		return 1.99;
	}

}
