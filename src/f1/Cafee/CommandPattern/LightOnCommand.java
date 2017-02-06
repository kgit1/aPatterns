package f1.Cafee.CommandPattern;

//concrete command object
public class LightOnCommand implements Command {
	
	//device
	Light light;

	public LightOnCommand(Light light) {
		this.light = light;
	}

	//invoke method from given device
	@Override
	public void execute() {
		light.on();
	}

}
