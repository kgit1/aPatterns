package l1.Duck.PatternOfPatterns.AdapterDecoratorFacbricCompositeObserver;

public class DuckFactory extends AbstractDuckFactory {

	@Override
	public Quackable createMallardDuck() {
		return new MallardDuck();
	}

	@Override
	public Quackable createRedheadDuck() {
		return new RedheadDuck();
	}

	@Override
	public Quackable createDuckCall() {
		return new DuckCall();
	}

	@Override
	public Quackable createRubberDuck() {
		return new RubberDuck();
	}

	public Quackable createDecoy() {
		return new DecoyDuck();
	}
}
