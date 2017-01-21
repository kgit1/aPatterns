package a2Duck;

public class BigDuck extends Duck {

	FlyBehavior flyBehavior = new FlyBehavior();
	QuackBehavior quackBehavior = new QuackBehavior();

	public void fly() {
		flyBehavior.fly();
	}

	public void quack() {
		quackBehavior.quack();
	}

	@Override
	public void display() {
		System.out.println("Big Duck");

	}

}
