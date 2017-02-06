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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RegisteredFactory {
	HashMap<String, Integer> listOfParts = new HashMap<>();
	HashMap<Class<?>, Integer> parts = new HashMap<>();
	List<Part> list = new ArrayList<>();

	public static void main(String[] args) {
		RegisteredFactory rf = new RegisteredFactory();
		for (int i = 0; i < 20; i++) {
			Part part = Part.createRandom();
			rf.CounterItemsPutToMap1(part);
			rf.CounterItemsPutToMap(part.getClass().getSimpleName());
			rf.list.add(part);
		}
		System.out.println(rf.list);
		System.out.println(rf.listOfParts);
		System.out.println("Map");
		System.out.println(rf.parts);
	}

	public void CounterItemsPutToMap(String obj) {
		Integer quantity = listOfParts.get(obj);
		// System.out.println(obj);
		if (quantity == null) {
			listOfParts.put(obj, 1);
		} else {
			listOfParts.put(obj, quantity + 1);
		}
	}

	public void CounterItemsPutToMap1(Object obj) {
		Class<?> type = obj.getClass();

		// System.out.println(type);
		if (parts.get(type) == null) {
			parts.put(type, 1);
		} else {
			parts.put(type, parts.get(type) + 1);
		}
	}

}

// create interface Factory with generic T - means T equals any type we give
// to method
interface Factory<T> {
	// same T for method return type, T - means any glass we giving
	T create();
}

// create class part - parent for our classes
class Part {
	// overrided method toString() to get names from our part(classes)
	public String toString() {
		return getClass().getSimpleName();
	}

	// create static List of classes which extending from Part class
	static List<Factory<? extends Part>> partFactories = new ArrayList<>();
	// make static initialization
	// will initialize our list with different parts
	static {
		partFactories.add(new FuelFilter.Factory());
		partFactories.add(new AirFilter.Factory());
		partFactories.add(new CabinFilter.Factory());
		partFactories.add(new OilFilter.Factory());
		partFactories.add(new FanBelt.Factory());
		partFactories.add(new GeneratorBelt.Factory());
		partFactories.add(new PowerSteeringBelt.Factory());
	}

	private static Random rand = new Random(47);

	// method creates instance of random Class
	// by taking random item from our list of parts
	// than that random item invokes method create
	// (every of our classes which presents in list - are children of Part
	// and has overloaded create method)
	// JVM gets type of that random Class - and search create() method which
	// returns same type of Class and invokes this method
	public static Part createRandom() {
		int n = rand.nextInt(partFactories.size());
		return partFactories.get(n).create();
	}
}

class Filter extends Part {
}

class FuelFilter extends Filter {
	public static class Factory
			implements zPattern.Factory.Factory<FuelFilter> {
		public FuelFilter create() {
			return new FuelFilter();
		}
	}
}

class AirFilter extends Filter {
	public static class Factory implements zPattern.Factory.Factory<AirFilter> {
		public AirFilter create() {
			return new AirFilter();
		}
	}
}

class CabinFilter extends Filter {
	public static class Factory
			implements zPattern.Factory.Factory<CabinFilter> {
		public CabinFilter create() {
			return new CabinFilter();
		}
	}
}

class OilFilter extends Filter {
	public static class Factory implements zPattern.Factory.Factory<OilFilter> {
		public OilFilter create() {
			return new OilFilter();
		}
	}
}

class Belt extends Part {
}

class FanBelt extends Belt {
	public static class Factory implements zPattern.Factory.Factory<FanBelt> {
		public FanBelt create() {
			return new FanBelt();
		}
	}
}

class GeneratorBelt extends Belt {
	public static class Factory
			implements zPattern.Factory.Factory<GeneratorBelt> {
		public GeneratorBelt create() {
			return new GeneratorBelt();
		}
	}
}

class PowerSteeringBelt extends Belt {
	public static class Factory
			implements zPattern.Factory.Factory<PowerSteeringBelt> {
		public PowerSteeringBelt create() {
			return new PowerSteeringBelt();
		}
	}
}
