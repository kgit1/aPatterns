package a2.Duck.StrategyPattern;

public class Quack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("I'm duck and I quack!");
	}
}
