package a1Duck;

public class Main {
	Duck duck1 = new SmallDuck();
	Duck duck2 = new BigDuck();
	Duck duck3 = new ColoredDuck();

	public static void main(String[] args) {
		duckInvoker(new Main().duck1);
		duckInvoker(new Main().duck2);
		duckInvoker(new Main().duck3);
	}

	public static void duckInvoker(Duck duck) {
		duck.display();
		duck.quack();
		duck.swim();
	}

}
