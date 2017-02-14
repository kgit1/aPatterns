package k2.GumMachineMonitor.ProxyPattern;

import java.rmi.Naming;
import java.rmi.RemoteException;

public class GumballMachineTest {

	public static void main(String[] args) throws RemoteException {
		
		args = new String[2];
		args[0]= "seatle 100";

		GumballMachineRemote gumballMachine = null;
		int count;
		if (args.length < 2) {
			System.out.println("GumballMachine <name> <inventory>");
			System.exit(1);
		}

		try {
			count = Integer.parseInt(args[1]);

			gumballMachine = new GumballMachine(args[0], count);
			Naming.rebind("//" + args[0] + "/gumballmachine", gumballMachine);
		} catch (Exception e) {
			e.printStackTrace();
		}

//		GumballMachine gumballMachine = new GumballMachine("Colorado", 15);

//		System.out.println(gumballMachine);
//
//		gumballMachine.insertQuarter();
//		gumballMachine.turnCrank();
//		System.out.println(gumballMachine);
//
//		System.out.println("---------------------");
//		for (int i = 0; i < 10; i++) {
//			gumballMachine.insertQuarter();
//			gumballMachine.turnCrank();
//			System.out.println(gumballMachine);
//		}
//		System.out.println("---------------------");
//
//		gumballMachine.insertQuarter();
//		gumballMachine.turnCrank();
//		gumballMachine.insertQuarter();
//		gumballMachine.turnCrank();
//		gumballMachine.ejectQuarter();
//		System.out.println(gumballMachine);
//
//		gumballMachine.insertQuarter();
//		gumballMachine.insertQuarter();
//		gumballMachine.turnCrank();
//		gumballMachine.insertQuarter();
//		gumballMachine.turnCrank();
//		gumballMachine.insertQuarter();
//		gumballMachine.turnCrank();
//		System.out.println(gumballMachine);
//
//		GumballMonitor monitor = new GumballMonitor(gumballMachine);
//		monitor.report();
	}
}
