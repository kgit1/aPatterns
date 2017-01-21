package a2Duck;

public class ColoredDuck extends Duck {
	
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
		System.out.println("Colored Duck");
	}

}
