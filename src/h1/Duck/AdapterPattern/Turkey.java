package h1.Duck.AdapterPattern;

public class Turkey implements TurkeyInterface {

	public void goble() {
		System.out.println("Goble goble");
	}

	public void fly() {
		System.out.println("I'm flying a little");
	}
}
