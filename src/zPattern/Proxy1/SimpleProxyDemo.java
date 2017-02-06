package zPattern.Proxy1;

//proxy pattern - posrednik
public class SimpleProxyDemo {

	// consumer doesn't care real or proxy object to take
	// because they share one interface and consumer takes object to argument by
	// interface
	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("bonobo");
	}

	public static void main(String[] args) {
		consumer(new RealObject());
		// proxy takes real object, invoke self methods, do work, and over it
		// invokes realObject methods
		consumer(new SimpleProxy(new RealObject()));
	}

}

interface Interface {
	void doSomething();

	void somethingElse(String string);
}

class RealObject implements Interface {

	@Override
	public void doSomething() {
		System.out.println("doSomething real");

	}

	@Override
	public void somethingElse(String string) {
		System.out.println("somethingElse real " + string);

	}

}

// our proxy
class SimpleProxy implements Interface {

	// for realObject
	Interface proxied;

	public SimpleProxy(Interface proxied) {
		this.proxied = proxied;
	}

	@Override
	public void doSomething() {
		System.out.println("doSomething proxy");
		proxied.doSomething();

	}

	@Override
	public void somethingElse(String string) {
		System.out.println("somethingElse proxy " + string);
		proxied.somethingElse(string);
	}

}
