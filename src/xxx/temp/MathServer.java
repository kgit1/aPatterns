package xxx.temp;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MathServer extends UnicastRemoteObject implements MathInterface {
	
	public MathServer() throws RemoteException {
		System.out.println("Initializing Server");
	}

	public int add(int a, int b) {
		return (a + b);
	}

	public int subt(int a, int b) {
		return (a - b);
	}

	public int mult(int a, int b) {
		return (a * b);
	}

	public int div(int a, int b) {
		return (a / b);
	}

	public static void main(String args[]) {
		try {
			MathServer ms = new MathServer();
			java.rmi.Naming.rebind("MathServ", ms);
			System.out.println("Server Ready");
		} catch (RemoteException RE) {
			System.out.println("Remote Server Error:" + RE.getMessage());
			System.exit(0);
		} catch (MalformedURLException ME) {
			System.out.println("Invalid URL!!");
		}
	}
}
