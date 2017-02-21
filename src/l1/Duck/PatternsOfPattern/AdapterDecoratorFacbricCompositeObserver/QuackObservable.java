package l1.Duck.PatternsOfPattern.AdapterDecoratorFacbricCompositeObserver;

public interface QuackObservable {

	void registerObserver(Observer observer);

	void notifyObservers();
}
