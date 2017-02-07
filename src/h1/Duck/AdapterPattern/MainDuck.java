package h1.Duck.AdapterPattern;

public class MainDuck {

	public static void main(String[] args) {
		Duck mallardDuck = new MallardDuck();

		Turkey turkey = new Turkey();
		TurkeyDuckAdapter turkeyDuck = new TurkeyDuckAdapter(turkey);

		System.out.println(mallardDuck.getClass().getSimpleName());
		doIt(mallardDuck);
		System.out.println(turkeyDuck.getClass().getSimpleName());
		doIt(turkeyDuck);
	}

	public static void doIt(Duck duck) {
		duck.quack();
		duck.fly();
	}

}
