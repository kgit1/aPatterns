package h1.Duck.AdapterPattern;

public class MainDuck {

	public static void main(String[] args) {
		Duck mallardDuck = new MallardDuck();

		Turkey turkey = new Turkey();
		TurkeyDuckAdapter turkeyDuck = new TurkeyDuckAdapter(turkey);
		DuckTurkeyAdapter duckTurkey = new DuckTurkeyAdapter(mallardDuck);

		System.out.println(mallardDuck.getClass().getSimpleName());
		doIt(mallardDuck);
		System.out.println(turkeyDuck.getClass().getSimpleName());
		doIt(turkeyDuck);

		doIt(duckTurkey);

	}

	public static void doIt(Duck duck) {
		duck.quack();
		duck.fly();
	}

	public static void doIt(TurkeyInterface turkey) {
		turkey.goble();
		turkey.fly();
	}

}
