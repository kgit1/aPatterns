package a2Duck;

//IS-A - Inheritance
public class BigDuck extends Duck {

	public BigDuck() {
		flyBehavior = new FlyWithWings();
		quackBehavior = new Quack();
	}

	@Override
	public void display() {
		System.out.println("Big Duck");

	}
}
