package f1.RemoteControl.CommandPattern;

//concrete command object
public class LightOnCommand implements Command {

	// device
	Light light;

	public LightOnCommand(Light light) {
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
