package a2Duck.StrategyPattern;

public class Silent implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("<<Silent>>");
	}
}
