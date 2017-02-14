package k1.GumMachineMonitor;

public class GumballMachineTest {

	public static void main(String[] args) {

		GumballMachine gumballMachine = new GumballMachine("Colorado", 15);

		System.out.println(gumballMachine);

		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		System.out.println(gumballMachine);

		System.out.println("---------------------");
		for (int i = 0; i < 10; i++) {
			gumballMachine.insertQuarter();
			gumballMachine.turnCrank();
			System.out.println(gumballMachine);
		}
		System.out.println("---------------------");

		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		gumballMachine.ejectQuarter();
		System.out.println(gumballMachine);

		gumballMachine.insertQuarter();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		System.out.println(gumballMachine);

		GumballMonitor monitor = new GumballMonitor(gumballMachine);
		monitor.report();
	}
}
