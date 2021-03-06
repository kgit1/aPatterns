package f1.RemoteControl.CommandPattern;

//concrete command object
public class LivingRoomLightOffCommand implements Command {

	// device
	Light light;

	public LivingRoomLightOffCommand(Light light) {
		this.light = light;
	}

	// invoke method from given device
	@Override
	public void execute() {
		light.off();
	}

	@Override
	public void undo() {
		light.on();
	}

}
