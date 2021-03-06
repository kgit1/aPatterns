package f1.RemoteControl.CommandPattern;

//concrete command object
public class KitchenLightOnCommand implements Command {

	// device
	Light light;

	public KitchenLightOnCommand(Light light) {
		this.light = light;
	}

	// invoke method from given device
	@Override
	public void execute() {
		light.on();
	}

	@Override
	public void undo() {
		light.off();
	}

}
