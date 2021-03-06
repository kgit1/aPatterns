package k2.GumMachineMonitor.ProxyPattern;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GumballMachine extends UnicastRemoteObject implements GumballMachineRemote {

	State soldOutState;
	State noQuarterState;
	State hasQuarterState;
	State soldState;
	State winnerState;
	String location;

	State state = soldOutState;
	int count = 0;

	public GumballMachine(String location, int numberOfGumBalls) throws RemoteException {
		this.location = location;
		soldOutState = new SoldOutState(this);
		noQuarterState = new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this);
		soldState = new SoldState(this);
		winnerState = new WinnerState(this);
		if (numberOfGumBalls > 0) {
			state = noQuarterState;
		}
		count = numberOfGumBalls;
	}

	// method for inserting coin to the machine
	public void insertQuarter() {
		state.insertQuarter();
	}

	// method for ejecting coin, if buyer trying to return coin
	public void ejectQuarter() {
		state.ejectQuarter();
	}

	// method for turning the crank
	public void turnCrank() {
		state.turnCrank();
		state.dispence();
	}

	// releaseBall method
	public void releaseBall() {
		System.out.println("A gymball comes rolling out the slot..");
		if (count != 0) {
			count -= 1;
		}
	}

	public String getLocation() {
		return location;
	}

	public void refill(int count) {
		this.count = count;
		state = noQuarterState;
	}

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\nMighty Gumball, Inc.");
		result.append("\nJava-enabled Standing Gumball Model #2004\n");
		result.append("Inventory: " + count + " gumball");
		if (count != 1) {
			result.append("s");
		}
		result.append("\nMachine is ");
		if (state instanceof SoldOutState) {
			result.append("sold out");
		} else if (state instanceof NoQuarterState) {
			result.append("waiting for quarter");
		} else if (state instanceof HasQuarterState) {
			result.append("waiting for turn of crank");
		} else if (state instanceof SoldState) {
			result.append("delivering a gumball");
		}
		result.append("\n");
		return result.toString();
	}

	public void setState(State state) {
		this.state = state;
	}

	public State getSoldOutState() {
		return soldOutState;
	}

	public State getNoQuarterState() {
		return noQuarterState;
	}

	public State getHasQuarterState() {
		return hasQuarterState;
	}

	public State getSoldState() {
		return soldState;
	}

	public State getState() {
		return state;
	}

	public State getWinnerState() {
		return winnerState;
	}

	public int getCount() {
		return count;
	}

}
