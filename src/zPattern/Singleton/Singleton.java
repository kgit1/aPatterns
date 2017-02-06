package zPattern.Singleton;

//Why Singleton is Anti pattern 
//
//With more and more classes calling getInstance() the code gets more and more 
//tightly coupled, monolithic, not testable and hard to change and hard to reuse 
//because of not configurable, hidden dependencies. Also, there would be no need 
//for this clumsy double checked locking if you call getInstance less 
//often (i.e. once).

public class Singleton {
	// initailzed during class loading
	private static final Singleton INSTANCE = new Singleton();

	// to prevent creating another instance of Singleton
	private Singleton() {
	}

	public static Singleton getSingleton() {
		return INSTANCE;
	}
}
