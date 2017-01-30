package a2.Duck.StrategyPattern;

//strategy pattern (also known as the policy pattern) is a behavioral 
//software design pattern that enables an algorithm's behavior 
//to be selected at runtime. The strategy pattern
//
//defines a family of algorithms, encapsulates each algorithm, and
//makes the algorithms interchangeable within that family.
//Strategy lets the algorithm vary independently from clients that use it.

//we have family of algorithms, each algorithm encapsulated and interchangeable
//flyBehaviour and quackBehaviour separated from duck, and are interchangeable 
//and can change Duck behavior "on the fly"
public class Main {

	public static void main(String[] args) {
		Duck duck1 = new SmallDuck();
		Duck duck2 = new BigDuck();
		Duck duck3 = new ColoredDuck();
		Duck duck4 = new RubberDuck();
		Duck duck5 = new WoodenDuck();
		duckInvoker(duck1);
		duckInvoker(duck2);
		duckInvoker(duck3);
		duckInvoker(duck4);
		duckInvoker(duck5);
		duck5.setFlyBehavior(new FlyRocketPower());
		duckInvoker(duck5);
	}

	public static void duckInvoker(Duck duck) {
		duck.display();
		duck.quack();
		duck.fly();
		duck.swim();
	}
}
