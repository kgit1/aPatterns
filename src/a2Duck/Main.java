package a2Duck;

public class Main {

	public static void main(String[] args) {
		Duck duck1 = new SmallDuck();
		Duck duck2 = new BigDuck();
		Duck duck3 = new ColoredDuck();
		Duck duck4 = new RubberDuck();
		Duck duck5 = new WoodenDuck();
		duckInvoker(duck1);
		duckInvoker(duck2);
		duckInvoker(duck3);
		duckInvoker(duck4);
		duckInvoker(duck5);
		duck5.setFlyBehavior(new FlyRocketPower());
		duckInvoker(duck5);
	}

	public static void duckInvoker(Duck duck) {
		duck.display();
		duck.quack();
		duck.fly();
		duck.swim();
	}
}
