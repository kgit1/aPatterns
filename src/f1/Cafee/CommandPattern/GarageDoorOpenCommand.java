package f1.Cafee.CommandPattern;

//concrete command object
public class GarageDoorOpenCommand implements Command {
	
	//device
	GarageDoor garageDoor;

	public GarageDoorOpenCommand(GarageDoor garageDoor) {
		this.garageDoor = garageDoor;
	}

	//invoke method from given device
	@Override
	public void execute() {
		garageDoor.up();
	}
}
