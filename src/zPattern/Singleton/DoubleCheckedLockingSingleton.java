package zPattern.Singleton;

//Why Singleton is Anti pattern 
//
//With more and more classes calling getInstance() the code gets more and more 
//tightly coupled, monolithic, not testable and hard to change and hard to reuse 
//because of not configurable, hidden dependencies. Also, there would be no need 
//for this clumsy double checked locking if you call getInstance less 
//often (i.e. once).

public class DoubleCheckedLockingSingleton {
	// We are only creating instance one time
	// We are creating instance lazily at the time of the first request comes.
	// A write to a volatile field happens-before every subsequent read of that
	// same field, known as Volatile variable rule.
	private volatile DoubleCheckedLockingSingleton INSTANCE;

	private DoubleCheckedLockingSingleton() {
	}

	public DoubleCheckedLockingSingleton getInstance() {
		if (INSTANCE == null) {
			synchronized (DoubleCheckedLockingSingleton.class) {
				// double checking Singleton instance
				if (INSTANCE == null) {
					INSTANCE = new DoubleCheckedLockingSingleton();
				}
			}
		}
		return INSTANCE;
	}
}
