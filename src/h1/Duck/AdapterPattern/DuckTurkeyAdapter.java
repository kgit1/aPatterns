package h1.Duck.AdapterPattern;

public class DuckTurkeyAdapter implements TurkeyInterface {

	Duck duck;

	public DuckTurkeyAdapter(Duck duck) {
		this.duck = duck;
	}

	@Override
	public void goble() {
		duck.quack();
	}

	@Override
	public void fly() {
		// duck fly much further then turkey, so our duck will fly just one time
		// of 5
		if ((int) (Math.random() * 5) == 0) {
			duck.fly();
		}
	}

}
