package a1Duck;

public class RubberDuck extends Duck {

	@Override
	public void quack() {
		System.out.println("I'm RubberDuck and I can't quack!");
	}

	@Override
	public void display() {
		System.out.println("Rubber Duck");
	}

}
