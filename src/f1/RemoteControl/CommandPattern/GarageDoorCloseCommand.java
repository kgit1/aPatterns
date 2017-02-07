package f1.RemoteControl.CommandPattern;

//concrete command object
public class GarageDoorCloseCommand implements Command {

	// device
	GarageDoor garageDoor;

	public GarageDoorCloseCommand(GarageDoor garageDoor) {
		this.garageDoor = garageDoor;
	}

	// invoke method from given device
	@Override
	public void execute() {
		garageDoor.down();
	}

	@Override
	public void undo() {
		garageDoor.up();
	}
}
