package a2.Duck.StrategyPattern;

public class FlyRocketPower implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("I'm flying with a rocket!");
	}
}
