package j2.GumMachineReworked.StatePattern;

public class NoQuarterState implements State {

	@Override
	public void insertQuarter() {
		System.out.println("You inserted a quarter");
	}

	@Override
	public void ejectQuarter() {
		// if quarter inside but process of giving gumball already started
		System.out.println("You haven't isert a quarter");
	}

	@Override
	public void turnCrank() {
		System.out.println("You turned but there's no quarter");
	}

	@Override
	public void dispence() {
		System.out.println("You need to pay first");
	}

}
