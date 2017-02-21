package l1.Duck.PatternsOfPattern.AdapterDecoratorFacbricCompositeObserver;

public class DuckSimulatorMain2Factory2Composite {

	public static void main(String[] args) {
		DuckSimulatorMain2Factory2Composite simulator = new DuckSimulatorMain2Factory2Composite();
		AbstractDuckFactory factory = new CountingDuckFactory();
		simulator.simulate(factory);
	}

	void simulate(AbstractDuckFactory factory) {
		Quackable mallardDuck = factory.createMallardDuck();
		Quackable redheadDuck = factory.createRedheadDuck();
		Quackable duckCall = factory.createDuckCall();
		Quackable rubberDcuk = factory.createRubberDuck();
		Quackable goose = new QuackCounter(new GooseAdapter(new Goose()));

		Flock flockOfDucks = new Flock();
		flockOfDucks.add(mallardDuck);
		flockOfDucks.add(redheadDuck);
		flockOfDucks.add(duckCall);
		flockOfDucks.add(rubberDcuk);
		flockOfDucks.add(goose);

		Flock flockOfMallards = new Flock();
		flockOfMallards.add(factory.createMallardDuck());
		flockOfMallards.add(factory.createMallardDuck());
		flockOfMallards.add(factory.createMallardDuck());
		flockOfMallards.add(factory.createMallardDuck());
		flockOfMallards.add(factory.createMallardDuck());
		flockOfMallards.add(factory.createMallardDuck());

		System.out.println("\nDuck Simulator");

		simulate(flockOfDucks);
		simulate(flockOfMallards);
		System.out.println(QuackCounter.getQuacks());
	}

	void simulate(Quackable quackable) {
		quackable.quack();
	}
}
