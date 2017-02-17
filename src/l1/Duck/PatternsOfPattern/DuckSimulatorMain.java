package l1.Duck.PatternsOfPattern;

public class DuckSimulatorMain {

	public static void main(String[] args) {
		DuckSimulatorMain simulator = new DuckSimulatorMain();
		simulator.simulate();
	}

	void simulate() {
		Quackable mallardDuck = new MallardDuck();
		Quackable redheadDuck = new RedheadDuck();
		Quackable duckCall = new DuckCall();
		Quackable rubberDcuk = new RubberDuck();

		System.out.println("\nDuck Simulator");

		simulate(mallardDuck);
		simulate(redheadDuck);
		simulate(duckCall);
		simulate(rubberDcuk);
	}

	void simulate(Quackable quackable) {
		quackable.quack();
	}
}
