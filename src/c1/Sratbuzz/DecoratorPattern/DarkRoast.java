package c1.Sratbuzz.DecoratorPattern;

public class DarkRoast extends Beverage {

	public DarkRoast() {
		description = "DarkRoast - $0.99";
	}

	@Override
	public double cost() {
		return 0.99;
	}
}
