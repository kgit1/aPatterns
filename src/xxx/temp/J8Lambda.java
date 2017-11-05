package xxx.temp;

interface Execute {
	// Lambda Expressions are always associated with interfaces that have a
	// single method.
	// In Java 8, if we've got an interface that just has a single method
	// (for example, our Runner interface here), then we call that a functional
	// interface
	void exec();

}

interface Execute1 {

	int exec();

}

interface Execute2 {

	int exec(int value);

}

class Runner {

	public void run(Execute ex) {

		ex.exec();

	}

	public void run(Execute1 ex) {

		ex.exec();

	}

	public void run(int a, Execute2 ex) {

		int value = ex.exec(a);
		System.out.println("Return value is: " + value);

	}

}

public class J8Lambda {

	public static void main(String[] args) {

		Runner runner = new Runner();

		// OLD WAY - before LAMBDA
		runner.run(new Execute() {

			@Override
			public void exec() {
				System.out.println("I'm running executor's exec! - no lambda");

			}
		});

		// NEW WAY - with LAMBDA
		// passing one code block
		runner.run(() -> System.out.println("I'm running executor's exec! - lambda"));

		// passing multi code block
		runner.run(() -> {
			System.out.println("I'm running executor's exec! - lambda one");
			System.out.println("I'm running executor's exec! - lambda two");
			System.out.println("I'm running executor's exec! - and lambda three!");
		});

		// if we want return value
		// OLD WAY
		// Let's look at how our anonymous class version of this code would have
		// to change. We'll make it return a value.

		runner.run(new Execute1() {
			public int exec() {
				System.out.println("Hello there      - no lambda");
				System.out.println("And hello again  - no lambda");
				return 7;
			}
		});
		// NEW WAY
		// With the lambda expression we can just put it in a return value. We
		// don’t need to specify the return type anymore, and in fact there’s no
		// way to do that. All we’ve got to do is just literally return a value.
		// Java knows what the return type is going to be, because it knows what
		// the corresponding interface looks like.

		runner.run(() -> {
			System.out.println("Hello there      - lambda");
			System.out.println("And hello again  - lambda");
			return 7;
		});

		// Now, sometimes all you want to return is either a literal value, or
		// more likely, the results of a method call that returns a value. If
		// you’ve just got a single expression, which could even be a literal
		// value, you don’t even need a return statement.

		runner.run(() -> 7);

		// Lambda Expression Parameters
		// Let’s say make our interface accept a parameter.

		runner.run(12, new Execute2() {

			@Override
			public int exec(int value) {

				return value * 34;
			}
		});

		runner.run(12, a -> {
			System.out.println("Return value is: " + a);
			return 222;
		});
		
//		 This simple program demonstrates how to use Lambda expressions to create
//		  and run threads.	 
//		 @author www.codejava.net
		 
		        System.out.println(Thread.currentThread().getName() + ": RunnableTest");
		 
		        // Anonymous Runnable
		 
		        Runnable task1 = new Runnable(){
		 
		          @Override
		          public void run(){
		            System.out.println(Thread.currentThread().getName() + " is running");
		          }
		        };
		 
		 
		        // Passing a Runnable when creating a new thread
		        Thread thread2 = new Thread(new Runnable() {
		            @Override
		            public void run(){
		                System.out.println(Thread.currentThread().getName() + " is running");
		            }
		        });
		 
		 
		        // Lambda Runnable
		        Runnable task3 = () -> {
		            System.out.println(Thread.currentThread().getName() + " is running");
		        };
		 
		        Thread thread1 = new Thread(task1);
		 
		        thread1.start();
		        thread2.start();
		 
		        new Thread(task3).start();
		 
		    }

	}	

//Java 8: Lambda Expressions
// Passing Code with Anonymous Classes; A Review

// Let's start by creating a class. We'll call it "Runner", just to give it a
// name. I'm going to give this method which I'll call “run”. Now let's imagine
// that for some reason we want to pass a block of code to "run".
//
// class Runner {
// public void run() {
//
// }
// }

// How would you do that in previous versions of Java? Well, the answer is,
// first you need to define an interface. Let's do that; I'll call it
// "Executable". We need to give this interface a method, and this method would
// be the place where we put the code we want to run.
//
//
// interface Executable {
// int execute();
// }
//
// Now we can make the Runner class accept an object that implements the
// Executable interface. It's going to get something that implements this
// interface and its going to know that that object, whatever it is, has an
// execute method.
//
//
//
// class Runner {
// public void run(Executable e) {
// e.execute();
// }
// }
//
// I've made the Runner class call the "execute" method of whatever object
// implements "Executable".
//
// Now to actually use this, we need an instance of the Runner class. In
// previous versions of Java, to actually pass it some block of code we've got
// to somehow have an object that implements this interface, and we can do that
// using an anonymous class syntax.
//
// Let's take a look at the completed code. If we now run this program, it says
// "hello there".
//
//
// interface Executable {
// void execute();
// }
//
// class Runner {
// public void run(Executable e) {
// e.execute();
// }
// }
//
// public class App {
//
// public static void main(String[] args) {
// Runner runner = new Runner();
// runner.run(new Executable() {
// public void execute() {
// System.out.println("Hello there.");
// }
// });
// }
// }
//
//
// The whole point of this is just to pass in some code to the run() method.
// Then this method can and do what it likes with it, and in this case it’s just
// executing the code that we passed it in the execute() method. So this is a
// lot of text purely just to pass a code block. Let's have a look at how we can
// do that with lambda expressions in Java 8.
//
//
// Basic Lambda Expressions
//
//
// By the way, the term “lambda expression” apparently comes from mathematics
// where the Greek letter lambda has been historically associated with some kind
// of analogous situation, passing a function to a function, or some such thing
// ....
//
// The same functionality can be replicated with a lambda expression in Java 8
// that looks like this:
//
//
// interface Executable {
// void execute();
// }
//
// class Runner {
// public void run(Executable e) {
// e.execute();
// }
// }
//
// public class App {
//
// public static void main(String[] args) {
// Runner runner = new Runner();
// runner.run( () -> System.out.println("Hello there.") );
//
// }
// }
//
//
// If you run this program, you'll see that it does the same thing as the
// unwieldy syntax above that we had in previous versions of Java.
//
// It's really important to keep in mind that all this is, is a way of passing a
// block of code that the run() method here is going to execute. Blocks of
// codes, of course, might have return values and might also accept parameters.
// We're going to look at how we can do that with a lambda expression.
//
// So firstly, let's ask what we’re going to do if we don't want just one
// expression like the System.out.println above; what about if we want multiple
// lines or blocks of code? Well, we might guess we can put curly brackets in
// here. Now we can't just have an expression in there, we’ve got to have
// complete statements and statements have got to end in semi-colons.
//
//
//
// public class App {
//
// public static void main(String[] args) {
// Runner runner = new Runner();
// runner.run( () -> {
// System.out.println("Hello there.");
// System.out.println("And hello again.");
//
//
// });
// }
// }
//
//
// Again we're executing a block of code. The lambda expression by itself is
// just a way of passing the code to our Runner object here. It just so happens
// in this case, the run() method we defined, happens to execute that code, but
// of course we could do whatever we like with it.
//
//
// Functional Interfaces
//
//
// Lambda Expressions are always associated with interfaces that have a single
// method. Java 8 doesn't introduce any new syntax for specifying that your
// method parameter is expecting a block of code. You still have to use
// interfaces, just like you did in previous versions of Java. The thing that’s
// new, is that we've got a simplified syntax for passing in the actual block of
// code.
//
// Java 8 also introduces some new terminology. In Java 8, if we've got an
// interface that just has a single method (for example, our Runner interface
// here), then we call that a functional interface. So, a functional interface
// is an interface that just has one single method. Other examples of this would
// be the Comparable interface or the Runnable interface in Java, but we've just
// rolled our own here and defined our own functional interface.
//
// If you're anything like me, you’ll sort of probably get gradually lost as
// you're going through this tutorial. But as long as you already understand
// anonymous classes and how to implement them, and if you understand
// interfaces, it's only a question of typing this stuff out a bit yourself to
// get it into your head. It’s not really as complicated as it first appears.
//
//
// Return Values in Lambda Expressions
//
//
// So what about if we want a return value from the block of code that we want
// to pass to a method to execute. In previous versions of Java, and also in
// Java 8, what we have to do is change the interface. Often you’ll just be
// using lambda expressions rather than defining the code that works with them.
// In this tutorial we're also looking at defining the code that uses lambda
// expressions, but most often you just want to create a button or a thread, and
// you'll only need to know how to define the lambda expression itself.
//
// Let's modify our interface here so that it returns an int.
//
//
// interface Executable {
// int execute();
// }
//
// Let's look at how our anonymous class version of this code would have to
// change. We'll make it return a value.
//
//
// Runner runner = new Runner();
// runner.run(new Executable() {
// public int execute() {
// System.out.println("Hello there.");
// System.out.println("And hello again.");
// return 7;
// }
// });
//
// With the lambda expression we can just put it in a return value. We don’t
// need to specify the return type anymore, and in fact there’s no way to do
// that. All we’ve got to do is just literally return a value. Java knows what
// the return type is going to be, because it knows what the corresponding
// interface looks like.
//
//
// runner.run( () -> {
// System.out.println("Hello there.");
// System.out.println("And hello again.");
// return 7;
// });
//
//
// Now, sometimes all you want to return is either a literal value, or more
// likely, the results of a method call that returns a value. If you’ve just got
// a single expression, which could even be a literal value, you don’t even need
// a return statement.
//
//
// runner.run( () -> 7);
//
// We don’t need the curly brackets if we just want to return the result of a
// single expression or just return a literal value.
//
//
// Lambda Expression Parameters
//
//
// Another thing that you often want to do is to allow the the block of code
// that you want to pass, to accept some parameters. Remember, we don’t want to
// pass in literal values with our block of code. We’ll be passing a block of
// code, and the method that you pass it to would then supply the parameters to
// the block of code, if there are any.
//
// Let’s say make our interface accept a parameter. Just for simplicity, I’ll
// just make it an integer, but it could be anything -- a double, an object or
// whatever. I'll call the parameter "a", although of course you'd usually give
// your parameters more descriptive names. The actual method that you pass that
// block of code to is going to have to supply a value for that parameter. We'll
// modify the old anonymous class syntax too. Let's also make our code blocks do
// something with the parameter; we'll make them add 7 to it and return it.
//
// If we supply only one parameter to our lambda expression, we can omit the
// round brackets before the arrow.
//
//
// interface Executable {
// void execute(int a);
// }
//
// class Runner {
// public int run(Executable e) {
// int value = e.execute("Hello");
// System.out.println("Return value is: " + value);
// }
// }
//
// public class App {
//
// public static void main(String[] args) {
// Runner runner = new Runner();
//
// // Anonymous class
// runner.run(new Executable() {
// public int execute(int a) {
// System.out.println("Hello there.");
// System.out.println("And hello again.");
// return 7 + a;
// }
// });
//
// // Lambda expression
// runner.run( a -> {
// System.out.println("Hello there.");
// System.out.println("And hello again.");
// return 7 + a;
// });
//
// }
// }
//
//
// The lambda expression is really simple. Remember, we're passing a block of
// code; it could have parameters and it could have a return value. Our lambda
// expression only needs to give the parameter a name; the type can usually be
// inferred from the interface.
//
// You can, of course, specify multiple parameters if you want. We only need to
// list them in the round brackets of the lambda expression. Note that if you
// have multiple parameters, you must surround them with round brackets.
//
//
// interface Executable {
// void execute(int a, int b);
// }
//
// class Runner {
// public int run(Executable e) {
// int value = e.execute("Hello");
// System.out.println("Return value is: " + value);
// }
// }
//
// public class App {
//
// public static void main(String[] args) {
// Runner runner = new Runner();
//
// // Anonymous class
// runner.run(new Executable() {
// public int execute(int a, int b) {
// System.out.println("Hello there.");
// System.out.println("And hello again.");
// return a + b;
// }
// });
//
// // Lambda expression
// runner.run( (a, b) -> {
// System.out.println("Hello there.");
// System.out.println("And hello again.");
// return a + b;
// });
//
// }
// }
//
//
//
// Resolving Parameter Ambiguity
//
//
// Sometimes you do need to specify the type of the parameters in the lambda
// expression. Let's take a look at an example of that. We'll create another
// interface and give the Runner class another method. In this case, Java
// doesn't know which method in the Runner class we intend to call with our
// lambda expression. To disambiguate, we need to specify the parameter types in
// the lambda expression. If one of the Runner methods happened to take two
// parameters and the other one, then the ambiguity would go away and again we
// wouldn't need to specify parameter types.
//
//
// interface Executable {
// void execute(int a);
// }
//
// interface StringExecutable {
// int execute(String a);
// }
//
//
// class Runner {
// public int run(Executable e) {
// e.execute(7);
// }
//
// public void run(StringExecutable e) {
// System.out.println("Executing code block ...");
// int value = e.execute("Hello");
// System.out.println("Return value is: " + value);
// }
//
// }
//
// public class App {
//
// public static void main(String[] args) {
// Runner runner = new Runner();
//
// // Anonymous class
// runner.run(new Executable() {
// public int execute(int a) {
// System.out.println("Hello there.");
// System.out.println("And hello again.");
// return a + 7;
// }
// });
//
// // Lambda expression
// runner.run( (int a) -> {
// System.out.println("Hello there.");
// System.out.println("And hello again.");
// return a + 7;
// });
//
// }
// }
//
//
//
// Lambda Expressions and Scope; "Effectively Final"
//
//
// What if you want to use variables from your calling method in the block of
// code that you want to pass to a method?
//
// In JDK7, if you use a local variable in an anonymous class, you had to
// declare it final, but in JDK8, the “final” is no longer necessary -- provided
// we assign our local variable a value when we declare it and then don't change
// that value.
//
//
//
// public class App {
//
// public static void main(String[] args) {
//
// int c = 9;
//
// // Can use c in our anonymous class methods and lambda expressions
// // as long as we don't change its value after assigning.
// // We say it's "effectively final"
//
// Runner runner = new Runner();
//
// // Anonymous class
// runner.run(new Executable() {
// public int execute(int a, int b) {
// System.out.println("Hello there.");
// System.out.println("And hello again.");
// return a + b + c;
// }
// });
//
// // Lambda expression
// runner.run( (a, b) -> {
// System.out.println("Hello there.");
// System.out.println("And hello again.");
// return a + b + c;
// });
//
// }
// }
//
//
// Our variable "c" here is not “final”, but we say it is “effectively final”.
// In JDK 8, we're allowed to use effectively final variables in methods of
// anonymous classes, and we can also use them in lambda expressions.
//
// So we can happily use local variables within our lambda expression as long as
// they are effectively final, or for that matter actually final.
//
// Unlike the anonymous class method, the lambda expression inherits the scope
// of the enclosing method. Look at what happens if we define a local variable
// in our main method and define the same variable in our anonymous class
// method.
//
//
//
// public class App {
//
// public static void main(String[] args) {
//
// int c = 9;
//
// // Can use c in our anonymous class methods and lambda expressions
// // as long as we don't change its value after assigning.
// // We say it's "effectively final"
//
// int d = 11;
//
// Runner runner = new Runner();
//
// // Anonymous class
// runner.run(new Executable() {
// public int execute(int a, int b) {
// int d = 24; // This is a completely new "d"!
// System.out.println("Hello there.");
// System.out.println("And hello again.");
// return a + b + c;
// }
// });
// }
// }
//
//
// Here, the second "d" is new variable that shadows the "d" declared earlier in
// the main method. The variable defined in the main method is no longer
// accessible in the anonymous class method -- at least not directly.
//
// Let's try that with our lambda expression.
//
//
//
// public class App {
//
// public static void main(String[] args) {
//
// int c = 9;
//
// // Can use c in our anonymous class methods and lambda expressions
// // as long as we don't change its value after assigning.
// // We say it's "effectively final"
//
// int d = 11;
//
// Runner runner = new Runner();
//
// // Lambda expression
// runner.run( (a, b) -> {
// int d = 7; // SYNTAX ERROR!
// System.out.println("Hello there.");
// System.out.println("And hello again.");
// return a + b + c;
// });
//
// }
// }
//
//
//
// Lambda Expressions are Objects!
//
//
//
// We get a compilation error now. The error is “lambda expression local
// variable d cannot declare another local variable defined in an enclosing
// scope”. The lambda expression inherits the calling method's scope, and we
// can't declare a variable that's already defined in the calling method.
//
// Lambda expressions took me a little while to get my head around, but once you
// realise that they are purely a new alternative to methods of anonymous
// classes, they are quite simple. Lambda expressions work a bit differently
// under the hood, but from the programmer’s point of view, it is just a new way
// of doing the same thing that we did before with anonymous classes, but
// they're a bit shorter and a lot simpler. You have to keep in mind that you
// are passing a block of code, and that block of code may have parameters and
// it may have a return value.
//
// There’s been a certain amount of excitement around lambda expressions because
// people are saying they open the door to functional programming -- where
// you’re passing around functions just like variables. The lambda expression is
// actually, in fact, an object.
//
// To me they're not so exciting; after all, we could do this in previous
// versions of Java. It’s just that we had to use more unwieldy syntax. We still
// don’t have a more succinct way of specifying that a method expects a block of
// code; we’ve still got to work with interfaces, so they do not really
// represent a radical overhaul, yet.
//
// What is nice is that if you’re passing some code to a button or a thread or
// something, you can do it without typing out a lot of unnecessary stuff.
//
// We can store the lambda expression in a variable of the interface type if we
// want.
//
//
//
// Executable ex = (a,b) -> {
// System.out.println("Hello there.");
// return a+b;
// };
//
// runner.run(ex);
//
//
// If you want to assign it to an object or you want to assign it to some
// superclass of the interface, then you need a cast in there.
//
//
//
// Object codeblock = (Executable)(a,b) -> {
// return a + b;
// };
//
//
//
// runner.run(ex);
//
//
// We can do that but we need to put a cast in to Executable like that.
//
// A really use of lambda expressions to implement the Comparable interface. In
// previous versions of Java, ArrayLists didn’t have a sort method, but now they
// do. You can pass the sort() method of ArrayList a lambda expression that
// specifies how to sort the list, which is rather nice.
//
// But let's wrap up this tutorial, because it's already a bit on the long side
// :)
//
// Happy coding!
