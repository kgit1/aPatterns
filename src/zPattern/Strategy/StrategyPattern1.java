package zPattern.Strategy;

/**
 * Java Program to implement Strategy design pattern in Java. Strategy pattern
 * allows you to supply different strategy without changing the Context class,
 * which uses that strategy. You can also introduce new sorting strategy any
 * time. Similar example is Collections.sort() method, which accept Comparator
 * or Comparable which is actually a Strategy to compare objects in Java. *
 */

public class StrategyPattern1 {

	public static void main(String args[]) throws InterruptedException {

		// we can provide any strategy to do the sorting
		int[] var = { 1, 2, 3, 4, 5 };
		Context ctx = new Context(new BubbleSort());
		ctx.arrange(var);

		// we can change the strategy without changing Context class
		ctx = new Context(new QuickSort());
		ctx.arrange(var);
	}

}

class Context {
	// some strategy
	private final Strategy strategy;

	// give needed strategy type
	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	// jvm invokes sort() method of given strategy
	public void arrange(int[] input) {
		strategy.sort(input);
	}
}

// interface to unite different strategies
interface Strategy {
	public void sort(int[] numbers);
}

// type of strategy implementing interface strategy to belong to one pool with
// other strategies
class BubbleSort implements Strategy {
	@Override
	public void sort(int[] numbers) {
		System.out.println("sorting array using bubble sort strategy");
	}

}

// type of strategy implementing interface strategy to belong to one pool with
// other strategies
class InsertionSort implements Strategy {
	@Override
	public void sort(int[] numbers) {
		System.out.println("sorting array using insertion sort strategy");
	}
}

// type of strategy implementing interface strategy to belong to one pool with
// other strategies
class QuickSort implements Strategy {
	@Override
	public void sort(int[] numbers) {
		System.out.println("sorting array using quick sort strategy");
	}
}

// type of strategy implementing interface strategy to belong to one pool with
// other strategies
class MergeSort implements Strategy {
	@Override
	public void sort(int[] numbers) {
		System.out.println("sorting array using merge sort strategy");
	}
}

// Output
// sorting array using bubble sort strategy
// sorting array using quick sort strategy
//
//
// Things to Remember about Strategy Pattern in Java
// Now let's revise what you have learn in this tutorial about strategy design
// pattern :
//
// 1) This pattern defines a set of related algorithm and encapsulate them in
// separated classes, and allows client to choose any algorithm at run time.
//
// 2) It allows to add new algorithm without modifying existing algorithms or
// context class, which uses algorithm or strategies.
//
// 3) Strategy is a behavioral pattern in GOF list.
//
// 4) Strategy pattern is based upon Open Closed design principle of SOLID.
//
// 5) Collections.sort() and Comparator interface is real world example of
// Strategy pattern.
//
// Read more:
// http://www.java67.com/2014/12/strategy-pattern-in-java-with-example.html#ixzz4VlLIT4cq
