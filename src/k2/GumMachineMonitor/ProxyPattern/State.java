package k2.GumMachineMonitor.ProxyPattern;

import java.io.Serializable;

public interface State extends Serializable {

	void insertQuarter();

	void ejectQuarter();

	void turnCrank();

	void dispence();
}
