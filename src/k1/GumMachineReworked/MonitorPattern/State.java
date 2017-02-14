package k1.GumMachineReworked.MonitorPattern;

public interface State {

	void insertQuarter();

	void ejectQuarter();

	void turnCrank();

	void dispence();
}
