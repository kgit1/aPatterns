package l1.Duck.PatternOfPatterns.AdapterDecoratorFacbricCompositeObserver;

public abstract class AbstractDuckFactory {

	public abstract Quackable createMallardDuck();

	public abstract Quackable createRedheadDuck();

	public abstract Quackable createDuckCall();

	public abstract Quackable createRubberDuck();

	public abstract Quackable createDecoy();
}
