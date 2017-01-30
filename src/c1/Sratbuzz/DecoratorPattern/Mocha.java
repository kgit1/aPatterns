package c1.Sratbuzz.DecoratorPattern;

public class Mocha extends CondimentDecorator {
	Beverage beverage;

	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ",\nMocha - $0.20";
	}

	@Override
	public double cost() {
		return 0.20 + beverage.cost();
	}
}
