package e2.ChocolateBoiler.ThreadSafe.SingletonPattern;

public class Singleton {
	private volatile static Singleton uniqueInstance;

	private Singleton() {
	}

	public static Singleton getInstance() {
		if (uniqueInstance == null) {
			synchronized (Singleton.class) {
				return new Singleton();
			}
		}
		return uniqueInstance;
	}
}
