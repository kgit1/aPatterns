package j2.GumMachineReworked.StatePattern;

public class GumballMonitor {

	GumballMachine gumballMachine;

	public GumballMonitor(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	public void report() {
		System.out.println("Gumball Machine : " + gumballMachine.getLocation());
		System.out.println("Current inventory : " + gumballMachine.getCount() + " gumballs");
		System.out.println("Current state : " + gumballMachine.getState());
	}

}
