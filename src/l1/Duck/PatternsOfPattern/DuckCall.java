package l1.Duck.PatternsOfPattern;

public class DuckCall implements Quackable {

	// every realization of observable objects has object Observable
	Observable observable;

	public DuckCall() {
		// create object Observable and give him reference to object MallardDuck
		observable = new Observable(this);
	}

	@Override
	public void quack() {
		System.out.println("Kwak");
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
		return "DuckCall";
	}
}
