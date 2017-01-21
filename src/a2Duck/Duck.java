package a2Duck;

public abstract class Duck {
	
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;

	public void fly() {
		flyBehavior.fly();
	}

	public void quack() {
		quackBehavior.quack();
	}
	
	public void swim() {
		System.out.println("Smimming");
	};

	public abstract void display();
}
