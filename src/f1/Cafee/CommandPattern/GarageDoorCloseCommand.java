package f1.Cafee.CommandPattern;

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
}
