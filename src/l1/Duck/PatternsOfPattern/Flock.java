package l1.Duck.PatternsOfPattern;

import java.util.ArrayList;
import java.util.Iterator;

// composite pattern is a partitioning design pattern.The composite pattern describes that a group 
//of objects is to be treated in the same way as a single instance of an object.The intent of a composite 
//is to"compose"objects into tree structures to represent part-whole hierarchies.Implementing the composite 
//pattern lets clients treat individual objects and compositions uniformly
public class Flock implements Quackable {

	ArrayList<Quackable> quackers = new ArrayList<>();

	public void add(Quackable quacker) {
		quackers.add(quacker);
	}

	@Override
	public void quack() {
		Iterator iterator = quackers.iterator();
		while (iterator.hasNext()) {
			Quackable quacker = (Quackable) iterator.next();
			quacker.quack();
		}
	}

	@Override
	// observer registered with help of object Observable
	public void registerObserver(Observer observer) {
		Iterator iterator = quackers.iterator();
		while (iterator.hasNext()) {
			Quackable quacker = (Quackable) iterator.next();
			quacker.registerObserver(observer);
		}
	}

	@Override
	// observer notified with help of object Observable
	public void notifyObservers() {
	}

	public String toString() {
		return "Flock of Ducks";
	}
}
