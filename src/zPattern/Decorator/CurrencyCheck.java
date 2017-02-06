package zPattern.Decorator;

//Component on Decorator design pattern
//We have some objects and need to change behavior of one of them
//So we use decorator on it
//Now its time to check currency.
public class CurrencyCheck {

	public static void main(String[] args) {

		// without adding decorators
		Currency curr = new Rupee();
		System.out.println(curr.getDescription() + ", " + curr.cost(1.1));
		Currency curr1 = new Dollar();
		System.out.println(curr1.getDescription() + ", " + curr1.cost(2.0));

		// adding decorators
		Currency curr2 = new AUDDecorator(new Dollar());
		System.out.println(curr2.getDescription() + ", " + curr2.cost(3.0));

		Currency curr3 = new SGDDecorator(new Dollar());
		System.out.println(curr3.getDescription() + ", " + curr3.cost(4.0));
	}
}

abstract class Currency {
	String description = "Unknown currency";

	public String getDescription() {
		return description;
	}

	public abstract double cost(double value);
}

// Concrete Component
// First example class
class Rupee extends Currency {
	double value;

	public Rupee() {
		description = "Indian Rupees";
	}

	public double cost(double v) {
		value = v;
		return value;
	}
}

// Another Concrete Component
// Second example class which we want to change with come decore
class Dollar extends Currency {
	double value;

	public Dollar() {
		description = "Dollar";
	}

	public double cost(double v) {
		value = v;
		return value;
	}
}

// Decorator
abstract class Decorator extends Currency {
	public abstract String getDescription();
}

// Concrete Decorator

// we use composition
// create instance of some dollar
// and change it name and value to our new currency australian dollar
class AUDDecorator extends Decorator {
	Dollar currency;

	public AUDDecorator(Dollar currency) {
		this.currency = currency;
	}

	public String getDescription() {
		return currency.getDescription() + ", it's Australian Dollar";
	}

	@Override
	public double cost(double value) {
		return currency.cost(value) * 1.332;
	}
}

// Another Concrete Decorator
// create instance of some dollar
// and change it name and value to our new currency singapore dollar
class SGDDecorator extends Decorator {
	Dollar currency;

	public SGDDecorator(Dollar currency) {
		this.currency = currency;
	}

	public String getDescription() {
		return currency.getDescription() + ", it's Singapore Dollar";
	}

	@Override
	public double cost(double value) {
		return currency.cost(value) * 1.42;
	}
}
// Explanation of the code:
//
// We can understand this in following term;
// 1. Component Interface: In our example Currency interface is component which
// used on its own or we need decorator for that.
// 2. Concrete Component: it implements Component and we add new behavior to
// this object at dynamically. Dollar and Rupee are the concrete implementation
// of currency.
// 3. Decorator: Decorator contains a HAS a Relationship in simple word we can
// say it has a instance variable that holds reference for component they
// implement same component which they are going to decorate. Here a Decorator
// is an abstract class which extends the currency.
// 4. Concrete Decorator: it's an implementation of Decorator So USD Dollar and
// SGD Dollar are the implementation of Decorator contains instance variable for
// component interface or the thing which they are going to decorate.
//
// Advantage of Decorator design Pattern in Java
//
// In brief we see what the main advantages of using decorator design patterns
// are.
// 1. Decorator Pattern is flexible than inheritance because inheritance add
// responsibilities at compile time and it will add at run-time.
// 2. Decorator pattern enhance or modify the object functionality
//
// Disadvantage
//
// Main disadvantage of using Decorator Pattern in Java is that the code
// maintenance can be a problem as it provides a lot of similar kind of small
// objects (each decorator).
//
// That's all on decorator design pattern in Java. To get mastery on decorator
// pattern I suggest looking inside JDK library itself and finding what classes
// are decorated, why they are decorated. Also think of scenario where
// inheritance is impractical and you look more flexibility and try to use
// decorator pattern in Java there.
//
//
// Read more:
// http://javarevisited.blogspot.com/2011/11/decorator-design-pattern-java-example.html#ixzz4VgKeEea8
