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

	// @Override
	// public double cost() {
	// double cost = beverage.cost();
	// if (getSize() == Beverage.TALL) {
	// cost += 0.10;
	// }
	// if (getSize() == Beverage.GRANDE) {
	// cost += 0.15;
	// }
	// if (getSize() == Beverage.VENTI) {
	// cost += 0.20;
	// }
	// return cost;
	// }
}
