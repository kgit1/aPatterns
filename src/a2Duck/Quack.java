package a2Duck;

public class Quack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("I'm duck and I quack!");
	}
}
