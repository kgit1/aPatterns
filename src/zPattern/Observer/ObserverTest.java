package zPattern.Observer;

import java.util.ArrayList;

//What is Observer design Pattern?
//Observer design pattern in Java Code ExampleObserver design pattern in Java 
//is very important pattern and as name suggest it's used to observe things. 
//Suppose you want to notify for change in a particular object than you 
//observer that object and changes are notified to you. Object which is 
//being observed is refereed as Subject and classes which observe subject 
//are called Observer. This is beautiful pattern and used heavily along with 
//Model View Controller Design pattern where change in model is propagated to 
//view so that it can render it with modified information. Observer pattern is 
//also a very popular Java interview questions and mostly asked on Senior or 
//mid senior level.

public class ObserverTest {

	public static void main(String args[]) {
		// this will maintain all loans information
		Newspaper printMedia = new Newspaper();
		Internet onlineMedia = new Internet();

		Loan personalLoan = new Loan("Personal Loan", 12.5f,
				"Standard Charterd");
		personalLoan.registerObserver(printMedia);
		personalLoan.registerObserver(onlineMedia);
		personalLoan.setInterest(3.5f);
	}
}

interface Observer {
	public void update(float interest);
}

interface Subject {
	public void registerObserver(Observer observer);

	public void removeObserver(Observer observer);

	public void notifyObservers();
}

class Loan implements Subject {
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private String type;
	private float interest;
	private String bank;

	public Loan(String type, float interest, String bank) {
		this.type = type;
		this.interest = interest;
		this.bank = bank;
	}

	public float getInterest() {
		return interest;
	}

	public void setInterest(float interest) {
		this.interest = interest;
		notifyObservers();
	}

	public String getBank() {
		return this.bank;
	}

	public String getType() {
		return this.type;
	}

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);

	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);

	}

	@Override
	public void notifyObservers() {
		for (Observer ob : observers) {
			System.out.println(
					"Notifying Observers on change in Loan interest rate");
			ob.update(this.interest);
		}

	}

}

class Newspaper implements Observer {
	@Override
	public void update(float interest) {
		System.out.println(
				"Newspaper: Interest Rate updated, new Rate is: " + interest);
	}
}

class Internet implements Observer {
	@Override
	public void update(float interest) {
		System.out.println(
				"Internet: Interest Rate updated, new Rate is: " + interest);
	}
}
