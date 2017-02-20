package l1.Duck.PatternsOfPattern;

public interface QuackObservable {

	void registerObserver(Observer observer);

	void notifyObservers();
}
