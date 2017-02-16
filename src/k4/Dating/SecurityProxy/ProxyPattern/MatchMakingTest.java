package k4.Dating.SecurityProxy.ProxyPattern;

import java.lang.reflect.Proxy;
import java.util.HashMap;

public class MatchMakingTest {
	HashMap<String, PersonBean> db = new HashMap<>();

	public static void main(String[] args) {

		MatchMakingTest test = new MatchMakingTest();
		test.drive();
	}

	public MatchMakingTest() {
		initializeDatabase();
	}

	public void initializeDatabase() {
		PersonBean joe = new PersonBeanImpl();
		joe.setName("Joe Javabean");
		joe.setInterests("cars, computers, music");
		joe.setHotOrNotRating(7);
		db.put(joe.getName(), joe);

		PersonBean kelly = new PersonBeanImpl();
		kelly.setName("Kelly Klosure");
		kelly.setInterests("ebay, movies, music");
		kelly.setHotOrNotRating(6);
		db.put(kelly.getName(), kelly);
	}

	public PersonBean getPersonFromDatabase(String name) {
		return db.get(name);
	}

	public void drive() {
		PersonBean joe = getPersonFromDatabase("Joe Javabean");
		PersonBean ownerProxy = getOwnerProxy(joe);
		System.out.println("Name is " + ownerProxy.getName());
		ownerProxy.setInterests("bowling, Go");
		System.out.println("Interests set from owner proxy");

		try {
			ownerProxy.setHotOrNotRating(10);
		} catch (Exception e) {
			System.out.println("Can't set rating from own proxy");
			// e.printStackTrace();
		}
		System.out.println("Rating is : " + ownerProxy.getHotOrNotRating());

		PersonBean nonOwnerProxy = getNonOwnerProxy(joe);

		System.out.println("Name is : " + nonOwnerProxy.getName());
		try {
			nonOwnerProxy.setInterests("bowling,go");
		} catch (Exception e) {
			System.out.println("Can't set interests from nonOwnProxy");
			// e.printStackTrace();
		}
		nonOwnerProxy.setHotOrNotRating(3);
		System.out.println("Rating set from nonOwnProxy");
		System.out.println("Rating is : " + nonOwnerProxy.getHotOrNotRating());
	}

	// Proxy provides static methods for creating dynamic proxy
	// classes and instances, and it is also the superclass of all
	// dynamic proxy classes created by those methods.
	// To create a proxy for some interface Foo:
	// Foo f = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(),
	// new Foo.class, handler);
	public PersonBean getOwnerProxy(PersonBean person) {
		return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(),
				person.getClass().getInterfaces(), new OwnerInvocationHandler(person));
	}

	public PersonBean getNonOwnerProxy(PersonBean person) {
		return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(),
				person.getClass().getInterfaces(), new NonOwnerInvocationHandler(person));
	}
}
