package a2Duck.StrategyPattern;

public class FlyWithWings implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("I can fly!");		
	}
}
