package e1.ChocolateBoiler.SingletonPattern;

//not thread safe!
public class Singleton {
	private static Singleton uniqueInstance;

	private Singleton() {
	}

	public static Singleton getInstance() {
		if (uniqueInstance == null) {
			return new Singleton();
		}
		return uniqueInstance;
	}

}

// thread safe 1
// public class Singleton {
// private static Singleton uniqueInstance;
//
// private Singleton() {
// }
//
// but synchronized slows execution drasticaly in 100 or more times, so if we
// gets instance many times - it will slow our app
// public static synchronized Singleton getInstance() {
// if (uniqueInstance == null) {
// return new Singleton();
// }
// return uniqueInstance;
// }
// }

// thread safe 2
// public class Singleton {
// java creates instance of object by herself before any threads run, but if
// our object big - it can slow app
// private static Singleton uniqueInstance = new Singleton();
//
// private Singleton() {
// }
//
// public static Singleton getInstance() {
// return uniqueInstance;
// }
// }

// thread safe 3
// public class Singleton {
// private volatile static Singleton uniqueInstance;
//
// private Singleton() {
// }
// public static Singleton getInstance() {
// if (uniqueInstance == null) {
// synchronized(Singleton.class){
// return new Singleton();
// }
// }
// return uniqueInstance;
// }
// }
