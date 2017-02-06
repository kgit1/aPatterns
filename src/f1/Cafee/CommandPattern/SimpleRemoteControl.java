package f1.Cafee.CommandPattern;

public class SimpleRemoteControl {
	// Command Object
	Command slot;

	public SimpleRemoteControl() {
	}

	// set given Command object
	public void setCommand(Command command) {
		slot = command;
	}

	// invoke execute method from Command object
	public void buttonWasPressed() {
		slot.execute();
	}
}
