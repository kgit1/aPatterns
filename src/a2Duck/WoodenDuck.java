package a2Duck;

public class WoodenDuck extends Duck {

	public WoodenDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new Silent();
	}

	public void fly() {
		flyBehavior.fly();
	}

	public void quack() {
		quackBehavior.quack();
	}

	@Override
	public void display() {
		System.out.println("Wooden Duck");
	}
}
