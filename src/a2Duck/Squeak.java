package a2Duck;

public class Squeak implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("I'm rubber duck and I squeak!");
	}
}
