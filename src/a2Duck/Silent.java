package a2Duck;

public class Silent implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("<<Silent>>");
	}
}
