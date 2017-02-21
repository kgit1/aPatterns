package l1.Duck.PatternOfPatterns.AdapterDecoratorFacbricCompositeObserver;

public class DuckSimulatorMain {

	public static void main(String[] args) {
		DuckSimulatorMain simulator = new DuckSimulatorMain();
		simulator.simulate();
	}

	void simulate() {
		Quackable mallardDuck = new QuackCounter(new MallardDuck());
		Quackable redheadDuck = new QuackCounter(new RedheadDuck());
		Quackable duckCall = new QuackCounter(new DuckCall());
		Quackable rubberDcuk = new QuackCounter(new RubberDuck());
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
