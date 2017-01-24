package a2Duck.StrategyPattern;

public class FlyNoWay implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("Can't fly!");
	}
}
