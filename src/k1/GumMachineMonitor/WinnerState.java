package k1.GumMachineMonitor;

public class WinnerState implements State {

	GumballMachine gumballMachine;

	public WinnerState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		// and finally if machine state - NO_QUARTER(when machine in waiting
		// mode and changing own state to HAS_QUARTER and starts process of
		// giving gumball)
		System.out.println("Please wait, we're already giving you a gumball");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("Sorry, you already turned the crank");
		// if machine empty, doesn't taking coins so can't be any inside
	}

	@Override
	public void turnCrank() {
		System.out.println("Turning twice doesn't get you another gumball!");
	}

	@Override
	public void dispence() {
		System.out.println("YOU'RE THE WINNER! YOu get two gumbaslls for your quarter=====================");
		gumballMachine.releaseBall();
		if (gumballMachine.getCount() == 0) {
			gumballMachine.setState(gumballMachine.soldOutState);
		}
		if (gumballMachine.getCount() > 0) {
			gumballMachine.releaseBall();
			gumballMachine.setState(gumballMachine.getNoQuarterState());
		} else {
			System.out.println("Ooops, out of gumballs");
			gumballMachine.setState(gumballMachine.getSoldOutState());
		}
	}
}
