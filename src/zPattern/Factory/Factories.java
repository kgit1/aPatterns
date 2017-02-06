package zPattern.Factory;

//pattern Factory - creational pattern that uses factory methods to deal
//with problem of creating objects without having to specify exact class
//of the object that will be created
//we give some object as argument and method knows on his own what to 
//do when get object of that class

//When to use Factory design pattern in Java
//Static Factory methods are common in frameworks where library code needs 
//to create objects of types which may be sub classed by applications using 
//the framework.Some or all concrete products can be created in multiple ways,
//or we want to leave open the option that in the future there may be new ways 
//to create the concrete product.Factory method is used when Products don't need 
//to know how they are created.We can use factory pattern where we have to 
//create an object of any one of sub-classes depending on the data provided

public class Factories {

	public static void main(String[] args) {
		serviceConsumer(new Implementation1Factory());
		System.out.println("=================");
		serviceConsumer(new Implementation2Factory());
	}
	
	public static void serviceConsumer(ServiceFactory factory) {
		Service service = factory.getService();
		service.method1();
		service.method2();
	}
}

interface Service {
	void method1();
	void method2();
}

interface ServiceFactory {
	Service getService();
}

class Implementation1 implements Service {

	@Override
	public void method1() {
		System.out.println("Implementation 1 method1");
	}

	@Override
	public void method2() {
		System.out.println("Implementation 1 method2");
	}
}

class Implementation2 implements Service {

	@Override
	public void method1() {
		System.out.println("Implementation 2 method1");
	}

	@Override
	public void method2() {
		System.out.println("Implementation 2 method1");
	}
}

class Implementation1Factory implements ServiceFactory {

	@Override
	public Service getService() {
		return new Implementation1();
	}
}

class Implementation2Factory implements ServiceFactory {

	@Override
	public Service getService() {
		return new Implementation2();
	}
}