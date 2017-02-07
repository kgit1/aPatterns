package h1.Duck.AdapterPattern;

public class TurkeyDuckAdapter implements Duck {

	Turkey turkey;

	public TurkeyDuckAdapter(Turkey turkey) {
		this.turkey = turkey;
	}

	@Override
	public void quack() {
		turkey.goble();
	}

	@Override
	public void fly() {
		for (int i = 0; i < 5; i++) {
			turkey.fly();
		}
	}

}
