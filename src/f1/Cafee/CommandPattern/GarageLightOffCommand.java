package f1.Cafee.CommandPattern;

//concrete command object
public class GarageLightOffCommand implements Command {

	// device
	Light light;

	public GarageLightOffCommand(Light light) {
		this.light = light;
	}

	// invoke method from given device
	@Override
	public void execute() {
		light.off();
	}

}
