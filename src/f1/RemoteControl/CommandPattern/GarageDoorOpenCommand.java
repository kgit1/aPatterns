package f1.RemoteControl.CommandPattern;

//concrete command object
public class GarageDoorOpenCommand implements Command {

	// device
	GarageDoor garageDoor;

	public GarageDoorOpenCommand(GarageDoor garageDoor) {
		this.garageDoor = garageDoor;
	}

	// invoke method from given device
	@Override
	public void execute() {
		garageDoor.up();
	}

	@Override
	public void undo() {
		garageDoor.down();
	}
}
