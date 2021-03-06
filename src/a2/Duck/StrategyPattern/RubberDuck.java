package a2.Duck.StrategyPattern;

//IS-A - Inheritance
public class RubberDuck extends Duck {

	public RubberDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new Squeak();
	}

	@Override
	public void display() {
		System.out.println("Rubber Duck");
	}
}
