package k1.GumMachineMonitor;

public interface State {

	void insertQuarter();

	void ejectQuarter();

	void turnCrank();

	void dispence();
}
