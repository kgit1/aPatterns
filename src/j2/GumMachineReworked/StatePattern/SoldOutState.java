package j2.GumMachineReworked.StatePattern;

public class SoldOutState implements State {

	GumballMachine gumballMachine;

	public SoldOutState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		// if machine state - SOLD(when coin already inside and machine in
		// process of giving gumball)
		System.out.println("You can't insert a quarter, the machine is sold out");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("You can't eject, yo haven't iserted coin yet");
	}

	@Override
	public void turnCrank() {
		System.out.println("You turned, but there's no gumballs");
	}

	@Override
	public void dispence() {
		System.out.println("No gumball dispensed");
	}
	
	public String toString() {
		return "sold out";
	}
}
