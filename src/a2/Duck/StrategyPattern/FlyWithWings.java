package a2.Duck.StrategyPattern;

public class FlyWithWings implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("I can fly!");		
	}
}
