package f1.RemoteControl.CommandPattern;

public class RemoteControlSimple {
	// Command Object
	Command slot;

	public RemoteControlSimple() {
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
