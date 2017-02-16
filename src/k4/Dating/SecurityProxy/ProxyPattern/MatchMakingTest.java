package k4.Dating.SecurityProxy.ProxyPattern;

import java.lang.reflect.Proxy;

public class MatchMakingTest {

	public static void main(String[] args) {

		MatchMakingTest test = new MatchMakingTest();

	}

	public MatchMakingTest() {
		initializeDatabase();
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
			e.printStackTrace();
		}
		System.out.println("Rating is : " + ownerProxy.getHotOrNotRating());

		PersonBean nonOwnerProxy = getNonOwnerProxy(joe);

		System.out.println("Name is : " + nonOwnerProxy.getName());
		try {
			nonOwnerProxy.setInterests("bowling,go");
		} catch (Exception e) {
			System.out.println("Can't set interests from nonOwnProxy");
			e.printStackTrace();
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
	public static PersonBean getOwnerProxy(PersonBean person) {
		return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(),
				person.getClass().getInterfaces(), new OwnerInvocationHandler(person));
	}

	public static PersonBean getNonOwnerProxy(PersonBean person) {
		return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(),
				person.getClass().getInterfaces(), new NonOwnerInvocationHandler(person));
	}

}
