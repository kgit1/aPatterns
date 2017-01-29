package c1.Sratbuzz.DecoratorPattern;

public class Decaf extends Beverage {

	public Decaf() {
		description = "Decaf - $1.05";
	}

	@Override
	public double cost() {
		return 1.05;
	}
}
