package l1.Duck.PatternsOfPattern.AdapterDecoratorFacbricCompositeObserver;

//Pattern Adapter
public class GooseAdapter implements Quackable {

	// every realization of observable objects has object Observable
	Observable observable;

	Goose goose;

	public GooseAdapter(Goose goose) {
		this.goose = goose;
		// create object Observable and give him reference to object MallardDuck
		observable = new Observable(this);
	}

	@Override
	public void quack() {
		goose.honk();
		// observers notified
		notifyObservers();
	}

	@Override
	// observer registered with help of object Observable
	public void registerObserver(Observer observer) {
		observable.registerObserver(observer);
	}

	@Override
	// observer notified with help of object Observable
	public void notifyObservers() {
		observable.notifyObservers();
	}

	@Override
	public String toString() {
		return "Goose";
	}

}
