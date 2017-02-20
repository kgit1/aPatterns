package l1.Duck.PatternsOfPattern;

//extend Quackable interface with interface QuackObservable
//now Quackable interface will ask to overrider methods for both Quackable and 
//QuackObservable interfaces
public interface Quackable extends QuackObservable {

	void quack();
}
