package k2.GumMachineMonitor.ProxyPattern;

public class HasQuarterState implements State {

	transient GumballMachine gumballMachine;

	public HasQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		// if machine state - SOLD_OUT(when count of gumballs equals ZERO)
		System.out.println("You can't insert another quarter");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("Quarter returned");
		gumballMachine.setState(gumballMachine.getNoQuarterState());
	}

	@Override
	public void turnCrank() {
		System.out.println("You turned...");
		int randomWinner = (int) (Math.random() * 10);
		System.out.println("RANDOM " + randomWinner + " <----------------------");
		if (randomWinner == 0 && gumballMachine.getCount() > 1) {
			gumballMachine.setState(gumballMachine.getWinnerState());
		} else {
			gumballMachine.setState(gumballMachine.getSoldState());
		}
	}

	@Override
	public void dispence() {
		System.out.println("No gumball dispensed");
	}
	
	public String toString() {
		return "waiting for turn of crank";
	}
}
