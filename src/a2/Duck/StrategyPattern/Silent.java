package a2.Duck.StrategyPattern;

public class Silent implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("<<Silent>>");
	}
}
