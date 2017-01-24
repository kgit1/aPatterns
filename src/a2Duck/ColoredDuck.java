package a2Duck;

//IS-A - Inheritance
public class ColoredDuck extends Duck {

	public ColoredDuck() {
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
		System.out.println("Colored Duck");
	}
}
