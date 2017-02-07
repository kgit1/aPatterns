package f1.RemoteControl.CommandPattern;

//concrete command object
public class KitchenLightOffCommand implements Command {

	// device
	Light light;

	public KitchenLightOffCommand(Light light) {
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
