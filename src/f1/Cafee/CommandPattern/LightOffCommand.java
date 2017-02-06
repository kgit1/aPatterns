package f1.Cafee.CommandPattern;

//concrete command object
public class LightOffCommand implements Command {

	// device
	Light light;

	public LightOffCommand(Light light) {
		this.light = light;
	}

	// invoke method from given device
	@Override
	public void execute() {
		light.off();
	}

}
