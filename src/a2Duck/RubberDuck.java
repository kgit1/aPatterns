package a2Duck;

public class RubberDuck extends Duck {

	public RubberDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new Sqeeze();
	}

	@Override
	public void display() {
		System.out.println("Rubber Duck");
	}

}
