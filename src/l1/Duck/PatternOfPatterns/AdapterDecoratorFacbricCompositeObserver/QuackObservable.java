package l1.Duck.PatternOfPatterns.AdapterDecoratorFacbricCompositeObserver;

public interface QuackObservable {

	void registerObserver(Observer observer);

	void notifyObservers();
}
