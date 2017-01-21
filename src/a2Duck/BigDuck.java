package a2Duck;

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
