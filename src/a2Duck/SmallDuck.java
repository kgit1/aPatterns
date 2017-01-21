package a2Duck;

public class SmallDuck extends Duck {

	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;

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
