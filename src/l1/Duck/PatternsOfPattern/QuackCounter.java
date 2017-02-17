package l1.Duck.PatternsOfPattern;

//Pattern Decorator
public class QuackCounter implements Quackable {
	Quackable quackable;
	static int quacks;

	public QuackCounter(Quackable quackable) {
		super();
		this.quackable = quackable;
	}

	@Override
	public void quack() {
		quackable.quack();
		quacks++;

	}

	public static int getQuacks() {
		return quacks;
	}
}
