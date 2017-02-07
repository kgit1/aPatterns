package h1.Duck.AdapterPattern;

//adapter class has inside object of adapted class and shares interface with class to which will adapt
//and invokes methods of adapted class in overrides methods of implemented interface shared with class to which 
//will be adapted

//adapter implements interface of class to which will be adapted
//public class TurkeyDuckAdapter implements Duck {
//
//	// object of class which will be adapted
//	Turkey turkey;
//
//	public TurkeyDuckAdapter(Turkey turkey) {
//		this.turkey = turkey;
//	}
//
//	// overrides methods from implemented interface
//	@Override
//	public void quack() {
//		// invoke method of adapted class
//		turkey.goble();
//	}
//
//	// overrides methods from implemented interface
//	@Override
//	public void fly() {
//		for (int i = 0; i < 5; i++) {
//			// invoke method of adapted class
//			turkey.fly();
//		}
//	}
//}
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
