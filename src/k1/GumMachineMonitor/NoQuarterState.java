package k1.GumMachineMonitor;

public class NoQuarterState implements State {

	GumballMachine gumballMachine;

	public NoQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		System.out.println("You inserted a quarter");
		gumballMachine.setState(gumballMachine.getHasQuarterState());
	}

	@Override
	public void ejectQuarter() {
		// if quarter inside but process of giving gumball already started
		System.out.println("You haven't isert a quarter");
	}

	@Override
	public void turnCrank() {
		System.out.println("You turned, but there's no quarter");
	}

	@Override
	public void dispence() {
		System.out.println("You need to pay first");
	}

	public String toString() {
		return "waiting for quarter";
	}
}
