package j2.GumMachine.StatePattern;

public interface State {

	void insertQuarter();

	void ejectQuarter();

	void turnCrank();

	void dispence();
}
