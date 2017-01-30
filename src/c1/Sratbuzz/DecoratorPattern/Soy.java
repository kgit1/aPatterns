package c1.Sratbuzz.DecoratorPattern;

public class Soy extends CondimentDecorator {
	Beverage beverage;

	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ",\nSoy - $0.15";
	}

	@Override
	public double cost() {
		return 0.10 + beverage.cost();
	}
}
