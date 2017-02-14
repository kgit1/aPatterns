package k2.GumMachineMonitor.ProxyPattern;

import java.rmi.Naming;
import java.rmi.RemoteException;

public class GumballMonitorTest {

	public static void main(String[] args) throws RemoteException {

		args = new String[2];
		args[0] = "127.0.0.1";

		String[] location = { "rmi://127.0.0.1"
//				,
//				"rmi://boulder.mightygumball.com/gumballmachine", "rmi://seattle.mightygumball.com/gumballmachine"
				};

		if (args.length >= 0) {
			location = new String[1];
			location[0] = "rmi://" + args[0] + "/gumballmachine";
		}

		GumballMonitor[] monitor = new GumballMonitor[location.length];

		for (int i = 0; i < location.length; i++) {
			try {
				GumballMachineRemote machine = (GumballMachineRemote) Naming.lookup(location[i]);
				monitor[i] = new GumballMonitor(machine);
				System.out.println(monitor[i]);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		for (int i = 0; i < monitor.length; i++) {
			monitor[i].report();
		}
	}
}
