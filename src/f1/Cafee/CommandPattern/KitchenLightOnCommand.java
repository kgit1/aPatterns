package f1.Cafee.CommandPattern;

//concrete command object
public class KitchenLightOnCommand implements Command {
	
	//device
	Light light;

	public KitchenLightOnCommand(Light light) {
		this.light = light;
	}

	//invoke method from given device
	@Override
	public void execute() {
		light.on();
	}

}
