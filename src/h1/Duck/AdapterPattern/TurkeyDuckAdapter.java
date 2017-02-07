package h1.Duck.AdapterPattern;

//adapter implements interface of class to which will be adapted
public class TurkeyDuckAdapter implements Duck {

	// object of class which will be adapted
	Turkey turkey;

	public TurkeyDuckAdapter(Turkey turkey) {
		this.turkey = turkey;
	}

	// overrides methods from implemented interface
	@Override
	public void quack() {
		// invoke method of adapted class
		turkey.goble();
	}

	// overrides methods from implemented interface
	@Override
	public void fly() {
		for (int i = 0; i < 5; i++) {
			// invoke method of adapted class
			turkey.fly();
		}
	}
}
