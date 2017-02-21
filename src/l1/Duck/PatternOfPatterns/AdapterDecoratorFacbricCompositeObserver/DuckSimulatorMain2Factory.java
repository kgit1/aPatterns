package l1.Duck.PatternOfPatterns.AdapterDecoratorFacbricCompositeObserver;

public class DuckSimulatorMain2Factory {

	public static void main(String[] args) {
		DuckSimulatorMain2Factory simulator = new DuckSimulatorMain2Factory();
		AbstractDuckFactory factory = new CountingDuckFactory();
		simulator.simulate(factory);
	}

	void simulate(AbstractDuckFactory factory ) {
		Quackable mallardDuck = factory.createMallardDuck();
		Quackable redheadDuck = factory.createRedheadDuck();
		Quackable duckCall = factory.createDuckCall();
		Quackable rubberDcuk = factory.createRubberDuck();
		Quackable goose = new QuackCounter(new GooseAdapter(new Goose()));

		System.out.println("\nDuck Simulator");

		simulate(mallardDuck);
		simulate(redheadDuck);
		simulate(duckCall);
		simulate(rubberDcuk);
		simulate(goose);
		System.out.println(QuackCounter.getQuacks());
	}

	void simulate(Quackable quackable) {
		quackable.quack();
	}
}
