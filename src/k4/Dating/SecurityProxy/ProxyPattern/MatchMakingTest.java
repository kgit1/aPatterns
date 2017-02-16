package k4.Dating.SecurityProxy.ProxyPattern;

import java.lang.reflect.Proxy;

public class MatchMakingTest {

	public static void main(String[] args) {

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
