package l1.Duck.PatternOfPatterns.AdapterDecoratorFacbricCompositeObserver;

public class RubberDuck implements Quackable {

	// every realization of observable objects has object Observable
	Observable observable;

	public RubberDuck() {
		// create object Observable and give him reference to object MallardDuck
		observable = new Observable(this);
	}

	@Override
	public void quack() {
		System.out.println("Squeak");
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
		return "RubberDuck";
	}
}
