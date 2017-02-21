package l1.Duck.PatternOfPatterns.AdapterDecoratorFacbricCompositeObserver;

import java.util.ArrayList;
import java.util.Iterator;

public class Observable implements QuackObservable {

	// list of observers
	ArrayList<Observer> observers = new ArrayList<>();
	// observable object
	QuackObservable duck;

	public Observable(QuackObservable duck) {
		this.duck = duck;
	}

	@Override
	// add new observer to list
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	// iterate through list of observers and invoke
	public void notifyObservers() {
		Iterator iterator = observers.iterator();
		while (iterator.hasNext()) {
			Observer observer = (Observer) iterator.next();
			// invoke update method for each observer
			observer.update(duck);
		}
	}
}
