package j2.GumMachineReworked.StatePattern;

public class HasQuarterState implements State {

	@Override
	public void insertQuarter() {
		// if machine state - SOLD_OUT(when count of gumballs equals ZERO)
		System.out.println("You can't insert another quarter");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("Quarter returned");
	}

	@Override
	public void turnCrank() {
		System.out.println("You turned...");
		dispence();
	}

	@Override
	public void dispence() {
		System.out.println("No gumball dispensed");
	}
}
