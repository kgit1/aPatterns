package l1.Duck.PatternOfPatterns.AdapterDecoratorFacbricCompositeObserver;

//Pattern Decorator
//decorating object of Quackable
//adds counter of quacks, method to show this counter
//invokes methods of given Quackable objects, but add new responsibility to quack() method, 
//to spin counter of quacks
public class QuackCounter implements Quackable {

	Quackable duck;
	// decorating
	static int numberOfQuacks;

	public QuackCounter(Quackable duck) {
		this.duck = duck;
	}

	public void quack() {
		duck.quack();
		// decorating
		numberOfQuacks++;
	}

	// decorating
	public static int getQuacks() {
		return numberOfQuacks;
	}

	public void registerObserver(Observer observer) {
		duck.registerObserver(observer);
	}

	public void notifyObservers() {
		duck.notifyObservers();
	}

	public String toString() {
		return duck.toString();
	}
}
