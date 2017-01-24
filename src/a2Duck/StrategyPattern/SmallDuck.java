package a2Duck.StrategyPattern;

//IS-A - Inheritance
public class SmallDuck extends Duck {

	public SmallDuck() {
		flyBehavior = new FlyWithWings();
		quackBehavior = new Quack();
	}

	public void fly() {
		flyBehavior.fly();
	}

	public void quack() {
		quackBehavior.quack();
	}

	@Override
	public void display() {
		System.out.println("Small Duck");
	}
}
