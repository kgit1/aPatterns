package c1.Sratbuzz.DecoratorPattern;

public class HouseBlend extends Beverage {

	public HouseBlend() {
		description = "HouseBlend - $0.89";
	}

	@Override
	public double cost() {
		return 0.89;
	}
}
